package com.example.model

enum class QuizCategory(
    val id: String,
    val title: String,
    val shortTitle: String,
    val subtitle: String,
    val badgeCode: String,
    val primaryHex: Long,
    val secondaryHex: Long
) {
    PYTHON(
        id = "PYTHON",
        title = "Python",
        shortTitle = "Python",
        subtitle = "Data structures, functions, comprehensions & runtime behavior.",
        badgeCode = "PY",
        primaryHex = 0xFF06B6D4,
        secondaryHex = 0xFF3B82F6
    ),
    JAVA(
        id = "JAVA",
        title = "Java",
        shortTitle = "Java",
        subtitle = "Object-oriented design, JVM memory, collections & streams.",
        badgeCode = "JV",
        primaryHex = 0xFFF59E0B,
        secondaryHex = 0xFFEF4444
    ),
    SQL(
        id = "SQL",
        title = "SQL",
        shortTitle = "SQL",
        subtitle = "Joins, aggregation, filtering, subqueries & indexing.",
        badgeCode = "SQL",
        primaryHex = 0xFF8B5CF6,
        secondaryHex = 0xFF6366F1
    ),
    COMPUTER_FUNDAMENTALS(
        id = "COMPUTER_FUNDAMENTALS",
        title = "Computer Fundamentals",
        shortTitle = "CS Core",
        subtitle = "Operating systems, networking, memory hierarchy & complexity.",
        badgeCode = "CS",
        primaryHex = 0xFF10B981,
        secondaryHex = 0xFF06B6D4
    ),
    LOGICAL_REASONING(
        id = "LOGICAL_REASONING",
        title = "Logical Reasoning",
        shortTitle = "Logic",
        subtitle = "Deductive logic, patterns, quantitative aptitude & combinatorics.",
        badgeCode = "LR",
        primaryHex = 0xFF6366F1,
        secondaryHex = 0xFF22D3EE
    );

    companion object {
        fun fromId(id: String): QuizCategory? = entries.find { it.id == id }
    }
}

enum class QuizScope(
    val id: String,
    val displayName: String,
    val description: String,
    val category: QuizCategory?
) {
    PYTHON("PYTHON", "Python", QuizCategory.PYTHON.subtitle, QuizCategory.PYTHON),
    JAVA("JAVA", "Java", QuizCategory.JAVA.subtitle, QuizCategory.JAVA),
    SQL("SQL", "SQL", QuizCategory.SQL.subtitle, QuizCategory.SQL),
    COMPUTER_FUNDAMENTALS(
        "COMPUTER_FUNDAMENTALS",
        "Computer Fundamentals",
        QuizCategory.COMPUTER_FUNDAMENTALS.subtitle,
        QuizCategory.COMPUTER_FUNDAMENTALS
    ),
    LOGICAL_REASONING(
        "LOGICAL_REASONING",
        "Logical Reasoning",
        QuizCategory.LOGICAL_REASONING.subtitle,
        QuizCategory.LOGICAL_REASONING
    ),
    MIXED(
        "MIXED",
        "Mixed Quiz",
        "Balanced blend across all 5 programming and aptitude categories.",
        null
    );

    companion object {
        fun fromId(id: String): QuizScope = entries.find { it.id == id } ?: MIXED
    }
}

enum class QuizDifficulty(
    val id: String,
    val title: String,
    val tagline: String,
    val detail: String
) {
    FOUNDATION(
        id = "FOUNDATION",
        title = "Foundation",
        tagline = "Core concepts",
        detail = "Focuses on essential concepts, syntax fundamentals, and clear mental models."
    ),
    APPLIED(
        id = "APPLIED",
        title = "Applied",
        tagline = "Recommended",
        detail = "Moderately challenging code tracing, query evaluation, and practical problem solving."
    ),
    ADVANCED(
        id = "ADVANCED",
        title = "Advanced",
        tagline = "Deep mastery",
        detail = "Tests subtle runtime behavior, algorithmic trade-offs, and multi-step analytical reasoning."
    );

    companion object {
        fun fromId(id: String): QuizDifficulty = entries.find { it.id == id } ?: APPLIED
    }
}

enum class QuizMode(
    val id: String,
    val title: String,
    val badge: String,
    val summary: String,
    val bulletPoints: List<String>
) {
    PRACTICE(
        id = "PRACTICE",
        title = "Practice",
        badge = "Flexible",
        summary = "Learn at your own pace.",
        bulletPoints = listOf(
            "Switch apps freely and resume anytime.",
            "Immediate answer feedback and explanations."
        )
    ),
    CHALLENGE(
        id = "CHALLENGE",
        title = "Challenge",
        badge = "Focused",
        summary = "Leaving the app ends the attempt.",
        bulletPoints = listOf(
            "Stay in QuizNova until you finish.",
            "Screenshots are restricted during Challenge mode where supported."
        )
    );

    companion object {
        fun fromId(id: String): QuizMode = entries.find { it.id == id } ?: PRACTICE
    }
}

enum class AttemptCompletionStatus(
    val id: String,
    val label: String,
    val bannerMessage: String?
) {
    COMPLETED_NORMALLY(
        id = "COMPLETED_NORMALLY",
        label = "Completed",
        bannerMessage = null
    ),
    AUTO_SUBMITTED_FOCUS_LOSS(
        id = "AUTO_SUBMITTED_FOCUS_LOSS",
        label = "Auto-Submitted",
        bannerMessage = "Automatically submitted because the app lost focus."
    ),
    ENDED_INTERRUPTED_SESSION(
        id = "ENDED_INTERRUPTED_SESSION",
        label = "Ended Early",
        bannerMessage = "Automatically ended because the previous Challenge session was interrupted before completion."
    );

    companion object {
        fun fromId(id: String): AttemptCompletionStatus =
            entries.find { it.id == id } ?: COMPLETED_NORMALLY
    }
}

data class QuestionOption(
    val id: String,
    val text: String
)

data class QuizQuestion(
    val id: String,
    val category: QuizCategory,
    val difficulty: QuizDifficulty,
    val prompt: String,
    val codeSnippet: String? = null,
    val languageNote: String? = null,
    val options: List<QuestionOption>,
    val correctOptionId: String,
    val explanation: String
) {
    fun optionById(optionId: String?): QuestionOption? =
        options.find { it.id == optionId }
}

data class ActiveSessionQuestion(
    val questionId: String,
    val shuffledOptionIds: List<String>,
    val selectedOptionId: String? = null,
    val submittedOptionId: String? = null,
    val isSubmitted: Boolean = false
)

data class ActiveQuizSession(
    val sessionId: String,
    val scope: QuizScope,
    val difficulty: QuizDifficulty,
    val mode: QuizMode,
    val questions: List<ActiveSessionQuestion>,
    val currentIndex: Int,
    val startedAtEpochMillis: Long,
    val challengeArmed: Boolean = false,
    val isFinalized: Boolean = false
) {
    val totalQuestions: Int get() = questions.size
    val currentQuestionState: ActiveSessionQuestion?
        get() = questions.getOrNull(currentIndex)
    val submittedCount: Int
        get() = questions.count { it.isSubmitted }
}

enum class AnswerOutcome {
    CORRECT,
    INCORRECT,
    UNANSWERED
}

data class EvaluatedAnswerRecord(
    val questionIndex: Int,
    val question: QuizQuestion,
    val shuffledOptionIds: List<String>,
    val selectedOptionId: String?,
    val submittedOptionId: String?,
    val correctOptionId: String,
    val outcome: AnswerOutcome
)

data class FinalizedAttemptSummary(
    val attemptId: String,
    val scope: QuizScope,
    val difficulty: QuizDifficulty,
    val mode: QuizMode,
    val totalQuestions: Int,
    val correctCount: Int,
    val incorrectCount: Int,
    val unansweredCount: Int,
    val percentage: Int,
    val startedAtEpochMillis: Long,
    val completedAtEpochMillis: Long,
    val completionStatus: AttemptCompletionStatus,
    val answers: List<EvaluatedAnswerRecord>
)

enum class ThemePreference(val id: String, val label: String) {
    SYSTEM("SYSTEM", "System"),
    LIGHT("LIGHT", "Light"),
    DARK("DARK", "Dark");

    companion object {
        fun fromId(id: String): ThemePreference = entries.find { it.id == id } ?: DARK
    }
}

data class UserPreferences(
    val themePreference: ThemePreference = ThemePreference.DARK,
    val reduceMotion: Boolean = false
)
