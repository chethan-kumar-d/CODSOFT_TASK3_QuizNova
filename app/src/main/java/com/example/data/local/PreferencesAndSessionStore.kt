package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.ActiveQuizSession
import com.example.model.ActiveSessionQuestion
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizScope
import com.example.model.ThemePreference
import com.example.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.quizNovaDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "quiznova_preferences_and_session"
)

class PreferencesAndSessionStore(private val dataStore: DataStore<Preferences>) {

    constructor(context: Context) : this(context.applicationContext.quizNovaDataStore)

    companion object {
        private val KEY_THEME = stringPreferencesKey("theme_preference")
        private val KEY_REDUCE_MOTION = booleanPreferencesKey("reduce_motion")
        private val KEY_SEEN_QUESTION_IDS = stringSetPreferencesKey("seen_question_ids")

        private val KEY_SESSION_ID = stringPreferencesKey("active_session_id")
        private val KEY_SESSION_SCOPE = stringPreferencesKey("active_session_scope")
        private val KEY_SESSION_DIFFICULTY = stringPreferencesKey("active_session_difficulty")
        private val KEY_SESSION_MODE = stringPreferencesKey("active_session_mode")
        private val KEY_SESSION_INDEX = intPreferencesKey("active_session_index")
        private val KEY_SESSION_STARTED_AT = longPreferencesKey("active_session_started_at")
        private val KEY_SESSION_CHALLENGE_ARMED = booleanPreferencesKey("active_session_challenge_armed")
        private val KEY_SESSION_FINALIZED = booleanPreferencesKey("active_session_finalized")
        private val KEY_SESSION_QUESTIONS_PAYLOAD = stringPreferencesKey("active_session_questions_payload")

        fun encodeQuestionsPayload(questions: List<ActiveSessionQuestion>): String {
            return questions.joinToString(separator = "\n") { q ->
                val opts = q.shuffledOptionIds.joinToString(",")
                val sel = q.selectedOptionId.orEmpty()
                val sub = q.submittedOptionId.orEmpty()
                val isSub = if (q.isSubmitted) "1" else "0"
                "${q.questionId}|$opts|$sel|$sub|$isSub"
            }
        }

        fun decodeQuestionsPayload(payload: String): List<ActiveSessionQuestion> {
            if (payload.isBlank()) return emptyList()
            return payload.lines().mapNotNull { line ->
                val parts = line.split("|")
                if (parts.size < 5) return@mapNotNull null
                val questionId = parts[0]
                val shuffledOptionIds = parts[1].split(",").filter { it.isNotBlank() }
                val selectedOptionId = parts[2].takeIf { it.isNotBlank() }
                val submittedOptionId = parts[3].takeIf { it.isNotBlank() }
                val isSubmitted = parts[4] == "1"
                if (questionId.isBlank() || shuffledOptionIds.isEmpty()) return@mapNotNull null
                ActiveSessionQuestion(
                    questionId = questionId,
                    shuffledOptionIds = shuffledOptionIds,
                    selectedOptionId = selectedOptionId,
                    submittedOptionId = submittedOptionId,
                    isSubmitted = isSubmitted
                )
            }
        }
    }

    val userPreferencesFlow: Flow<UserPreferences> = dataStore.data.map { prefs ->
        UserPreferences(
            themePreference = ThemePreference.fromId(prefs[KEY_THEME] ?: ThemePreference.DARK.id),
            reduceMotion = prefs[KEY_REDUCE_MOTION] ?: false
        )
    }

    val seenQuestionIdsFlow: Flow<Set<String>> = dataStore.data.map { prefs ->
        prefs[KEY_SEEN_QUESTION_IDS].orEmpty()
    }

    val activeSessionFlow: Flow<ActiveQuizSession?> = dataStore.data.map { prefs ->
        readSessionFromPreferences(prefs)
    }

    suspend fun getSeenQuestionIdsSnapshot(): Set<String> {
        return dataStore.data.first()[KEY_SEEN_QUESTION_IDS].orEmpty()
    }

    suspend fun markQuestionSeen(questionId: String) {
        if (questionId.isBlank()) return
        dataStore.edit { prefs ->
            val current = prefs[KEY_SEEN_QUESTION_IDS].orEmpty()
            if (questionId !in current) {
                prefs[KEY_SEEN_QUESTION_IDS] = current + questionId
            }
        }
    }

    suspend fun markQuestionsSeen(questionIds: Collection<String>) {
        val validIds = questionIds.filter { it.isNotBlank() }.toSet()
        if (validIds.isEmpty()) return
        dataStore.edit { prefs ->
            val current = prefs[KEY_SEEN_QUESTION_IDS].orEmpty()
            prefs[KEY_SEEN_QUESTION_IDS] = current + validIds
        }
    }

    suspend fun resetSeenQuestionsForPool(poolQuestionIds: Set<String>) {
        if (poolQuestionIds.isEmpty()) return
        dataStore.edit { prefs ->
            val current = prefs[KEY_SEEN_QUESTION_IDS].orEmpty()
            prefs[KEY_SEEN_QUESTION_IDS] = current - poolQuestionIds
        }
    }

    suspend fun getActiveSessionSnapshot(): ActiveQuizSession? {
        return readSessionFromPreferences(dataStore.data.first())
    }

    private fun readSessionFromPreferences(prefs: Preferences): ActiveQuizSession? {
        val sessionId = prefs[KEY_SESSION_ID] ?: return null
        val payload = prefs[KEY_SESSION_QUESTIONS_PAYLOAD] ?: return null
        val questions = decodeQuestionsPayload(payload)
        if (questions.isEmpty()) return null

        val scope = QuizScope.fromId(prefs[KEY_SESSION_SCOPE] ?: QuizScope.MIXED.id)
        val difficulty = QuizDifficulty.fromId(prefs[KEY_SESSION_DIFFICULTY] ?: QuizDifficulty.APPLIED.id)
        val mode = QuizMode.fromId(prefs[KEY_SESSION_MODE] ?: QuizMode.PRACTICE.id)
        val currentIndex = (prefs[KEY_SESSION_INDEX] ?: 0).coerceIn(0, questions.lastIndex)
        val startedAt = prefs[KEY_SESSION_STARTED_AT] ?: 0L
        val challengeArmed = prefs[KEY_SESSION_CHALLENGE_ARMED] ?: false
        val isFinalized = prefs[KEY_SESSION_FINALIZED] ?: false

        return ActiveQuizSession(
            sessionId = sessionId,
            scope = scope,
            difficulty = difficulty,
            mode = mode,
            questions = questions,
            currentIndex = currentIndex,
            startedAtEpochMillis = startedAt,
            challengeArmed = challengeArmed,
            isFinalized = isFinalized
        )
    }

    suspend fun saveActiveSession(session: ActiveQuizSession) {
        dataStore.edit { prefs ->
            prefs[KEY_SESSION_ID] = session.sessionId
            prefs[KEY_SESSION_SCOPE] = session.scope.id
            prefs[KEY_SESSION_DIFFICULTY] = session.difficulty.id
            prefs[KEY_SESSION_MODE] = session.mode.id
            prefs[KEY_SESSION_INDEX] = session.currentIndex
            prefs[KEY_SESSION_STARTED_AT] = session.startedAtEpochMillis
            prefs[KEY_SESSION_CHALLENGE_ARMED] = session.challengeArmed
            prefs[KEY_SESSION_FINALIZED] = session.isFinalized
            prefs[KEY_SESSION_QUESTIONS_PAYLOAD] = encodeQuestionsPayload(session.questions)
        }
    }

    suspend fun clearActiveSession() {
        dataStore.edit { prefs ->
            prefs.remove(KEY_SESSION_ID)
            prefs.remove(KEY_SESSION_SCOPE)
            prefs.remove(KEY_SESSION_DIFFICULTY)
            prefs.remove(KEY_SESSION_MODE)
            prefs.remove(KEY_SESSION_INDEX)
            prefs.remove(KEY_SESSION_STARTED_AT)
            prefs.remove(KEY_SESSION_CHALLENGE_ARMED)
            prefs.remove(KEY_SESSION_FINALIZED)
            prefs.remove(KEY_SESSION_QUESTIONS_PAYLOAD)
        }
    }

    suspend fun setThemePreference(themePreference: ThemePreference) {
        dataStore.edit { prefs ->
            prefs[KEY_THEME] = themePreference.id
        }
    }

    suspend fun setReduceMotion(reduceMotion: Boolean) {
        dataStore.edit { prefs ->
            prefs[KEY_REDUCE_MOTION] = reduceMotion
        }
    }
}
