package com.example.data.local

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "quiz_attempts")
data class QuizAttemptEntity(
    @PrimaryKey val attemptId: String,
    val scopeId: String,
    val difficultyId: String,
    val modeId: String,
    val totalQuestions: Int,
    val correctCount: Int,
    val incorrectCount: Int,
    val unansweredCount: Int,
    val percentage: Int,
    val startedAtEpochMillis: Long,
    val completedAtEpochMillis: Long,
    val completionStatusId: String
)

@Entity(
    tableName = "quiz_answer_records",
    primaryKeys = ["attemptId", "questionIndex"],
    foreignKeys = [
        ForeignKey(
            entity = QuizAttemptEntity::class,
            parentColumns = ["attemptId"],
            childColumns = ["attemptId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["attemptId"])]
)
data class QuizAnswerRecordEntity(
    val attemptId: String,
    val questionIndex: Int,
    val questionId: String,
    val categoryId: String,
    val shuffledOptionIdsCsv: String,
    val selectedOptionId: String?,
    val submittedOptionId: String?,
    val correctOptionId: String,
    val outcomeId: String
)

@Dao
interface QuizDao {

    @Query("SELECT * FROM quiz_attempts ORDER BY completedAtEpochMillis DESC")
    fun observeAllAttempts(): Flow<List<QuizAttemptEntity>>

    @Query("SELECT * FROM quiz_answer_records ORDER BY attemptId, questionIndex ASC")
    fun observeAllAnswerRecords(): Flow<List<QuizAnswerRecordEntity>>

    @Query("SELECT * FROM quiz_attempts WHERE attemptId = :attemptId LIMIT 1")
    suspend fun getAttemptById(attemptId: String): QuizAttemptEntity?

    @Query("SELECT * FROM quiz_answer_records WHERE attemptId = :attemptId ORDER BY questionIndex ASC")
    suspend fun getAnswerRecordsForAttempt(attemptId: String): List<QuizAnswerRecordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAttemptIgnoreConflict(attempt: QuizAttemptEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnswerRecordsIgnoreConflict(records: List<QuizAnswerRecordEntity>)

    /**
     * Saves a finalized attempt and its answer records atomically and idempotently.
     * Returns true if inserted for the first time, false if an attempt with the same ID already existed.
     */
    @Transaction
    suspend fun saveFinalizedAttemptOnce(
        attempt: QuizAttemptEntity,
        records: List<QuizAnswerRecordEntity>
    ): Boolean {
        val rowId = insertAttemptIgnoreConflict(attempt)
        if (rowId == -1L) {
            return false
        }
        insertAnswerRecordsIgnoreConflict(records)
        return true
    }

    @Query("DELETE FROM quiz_attempts")
    suspend fun clearAllAttempts()
}

@Database(
    entities = [QuizAttemptEntity::class, QuizAnswerRecordEntity::class],
    version = 1,
    exportSchema = false
)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun quizDao(): QuizDao

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getInstance(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiznova_local.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
