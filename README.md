# QuizNova — Programming & Aptitude

**QuizNova** is a native Android quiz application built with **Kotlin**, **Jetpack Compose**, and **Material 3** for **Task 4 of the CodSoft Android Development Internship**.

It combines a dimensional 3D-inspired interface, a validated bank of **225 unique programming and aptitude questions**, deterministic single-question scoring, **Practice** and **Challenge** integrity modes, genuine on-device **Room** analytics, and transparent privacy controls—operating 100% offline without accounts, API keys, advertisements, or external backends.

---

## Features

- **Dimensional 3D-Inspired Interface**:
  - Custom sculpted `QuizNova3DEmblem` combining a geometric `Q` ring, bevelled tail, and a 4-point learning spark motif.
  - Layered cards with extruded bottom lips, top-edge bevel highlights, tactile raised buttons, and an animated result medallion.
  - Coordinated **Dark**, **Light**, and **System** themes, plus a **Reduce Motion** setting that also respects Android system animation scale.
- **225 Unique Curated Questions (5 Domains × 3 Tiers × 15 Questions)**:
  - **Domains**: `Python` (Python 3.11+), `Java` (Java 17 LTS), `SQL` (ANSI SQL / PostgreSQL / SQLite), `Computer Fundamentals`, and `Logical Reasoning`, plus balanced **Mixed Quiz** sessions.
  - **Difficulty Tiers**: `Foundation` (core conceptual models), `Applied` (default — code tracing, query evaluation, and realistic scenarios), and `Advanced` (deep runtime semantics, query optimization, and analytical reasoning).
  - Every question features 4 distinct options, a stable ID, formatted monospace code blocks where relevant, and a step-by-step explanation.
- **Deterministic Quiz Flow & Scoring**:
  - Presents one multiple-choice question at a time.
  - Selecting an option highlights it without auto-submitting; **Submit Answer** is enabled only after selection.
  - Submitting locks the answer, immediately displays **Correct (+1)** or **Incorrect (0)** with icons and text, reveals the correct answer, and presents the explanation.
  - Explicit **Next Question** / **View Results** navigation—never advances automatically.
- **Practice Mode vs. Challenge Mode**:
  - **Practice Mode**: Switch apps freely without penalty; active session progress, shuffled question/option order, and submitted answers are persisted in Jetpack DataStore and restored seamlessly.
  - **Challenge Mode**: Requires explicit acceptance of foreground-focus rules before starting. Rejects starting while in split-screen / multi-window mode. Once active and focused, losing window focus (`onWindowFocusChanged(false)`) or backgrounding (`ON_STOP` when `!isChangingConfigurations`) automatically finalizes and persists the attempt once using only already-submitted answers. Applies `FLAG_SECURE` strictly during the active Challenge quiz screen and removes it immediately afterward so Home, Results, and Progress can be recorded for portfolio demos.
- **Results, Answer Review & Plain-Text Share**:
  - Displays final score (`X / Y`), percentage (using total questions in the attempt as denominator), and counts of **Correct**, **Incorrect**, and **Unanswered** questions.
  - Distinguishes normal completion, automatic submission (`"Automatically submitted because the app lost focus."`), and interrupted Challenge sessions.
  - Full question-by-question **Answer Review** and plain-text score sharing via the Android Share Sheet.
- **Local Progress Analytics & Attempt History**:
  - Backed exclusively by genuine local **Room** database records.
  - Filterable by `All Modes`, `Practice`, and `Challenge`.
  - Attributes Mixed Quiz answers to their actual underlying domains (`Python`, `Java`, `SQL`, `Computer Fundamentals`, `Logical Reasoning`).

---

## Tech Stack

- **Language**: Kotlin 2.2
- **UI Framework**: Jetpack Compose + Material 3 (Edge-to-Edge, Adaptive `NavigationBar` / `NavigationRail`)
- **Architecture**: MVVM (`QuizNovaViewModel`, `QuizRepository`, `QuizScoringEngine`, `QuizAnalyticsEngine`)
- **Local Persistence**:
  - **Room Database** (`QuizDatabase`, `QuizAttemptEntity`, `QuizAnswerRecordEntity`) for finalized attempts and answer review records.
  - **Jetpack DataStore Preferences** (`PreferencesAndSessionStore`) for theme, Reduce Motion, and active session recovery.
- **Testing**: JUnit 4, Kotlin Coroutines Test, Robolectric, and Compose UI Test (`testDebugUnitTest`).

---

## Scoring Rules

- Each question is worth **1 mark** when the explicitly submitted option matches the question's `correctOptionId`.
- **Incorrect** answers and **Unanswered** questions receive **0 marks** (no negative marking).
- An option that is selected on screen but **not explicitly submitted** before a Challenge auto-submits is counted as **Unanswered (0 marks)**.
- **Attempt Percentage** = `round((correctCount / totalQuestions) * 100)`.
- **Overall Accuracy** = `round((totalCorrectAcrossAttempts / totalQuestionsAcrossAttempts) * 100)`.

---

## Privacy & Challenge Integrity Limitations

- **100% Local & Offline**: QuizNova requests zero dangerous or network permissions. All attempts, answer records, and preferences remain in local app storage on the device.
- **Challenge Focus Monitoring**: Challenge mode uses standard Android Activity lifecycle (`onStop`) and window focus (`onWindowFocusChanged`) callbacks. Because Android does not distinguish why focus was lost without invasive permissions, legitimate system interruptions (incoming calls, notification shade, permission/volume panels, or system overlays) can also trigger automatic submission.
- **Honest Non-Claims**: QuizNova does **not** use Accessibility Services, Device Administrator APIs, or Usage Stats, and cannot block external cameras, secondary devices, or OS-level features such as Circle to Search or Gemini overlays.
- **Scoped `FLAG_SECURE`**: Screenshot and screen-recording restriction (`WindowManager.LayoutParams.FLAG_SECURE`) is applied only while an active Challenge quiz is displayed and is cleared as soon as the user exits to Results or Home.

---

## Project Structure

```text
app/src/main/java/com/example/
├── MainActivity.kt                         # Edge-to-edge host, FLAG_SECURE scope & lifecycle/focus hooks
├── model/
│   └── QuizModels.kt                       # Domain models, enums, session & summary state
├── data/
│   ├── QuizRepository.kt                   # Coordinates Room DB + DataStore with single-finalization lock
│   ├── local/
│   │   ├── QuizDatabase.kt                 # Room entities, DAO & database
│   │   └── PreferencesAndSessionStore.kt   # DataStore preferences & active session serializer
│   └── questions/
│       ├── QuestionBank.kt                 # 225-question aggregator, session builder & bank validator
│       ├── PythonQuestions.kt              # 45 Python 3.11+ questions (15 per difficulty)
│       ├── JavaQuestions.kt                # 45 Java 17 LTS questions (15 per difficulty)
│       ├── SqlQuestions.kt                 # 45 SQL questions (15 per difficulty)
│       ├── ComputerFundamentalsQuestions.kt# 45 CS Fundamentals questions (15 per difficulty)
│       └── LogicalReasoningQuestions.kt    # 45 Logical Reasoning questions (15 per difficulty)
├── domain/
│   ├── QuizScoringEngine.kt                # Pure selection, submission locking & evaluation logic
│   └── QuizAnalyticsEngine.kt              # Genuine accuracy, category attribution & trend calculations
├── viewmodel/
│   └── QuizNovaViewModel.kt                # UI state holder, setup, Practice & Challenge orchestration
└── ui/
    ├── QuizNovaApp.kt                      # Adaptive scaffold & screen router
    ├── components/
    │   └── DimensionalComponents.kt        # 3D Q-Spark emblem, layered cards, raised buttons, medallion
    ├── screens/
    │   ├── HomeScreen.kt                   # Dimensional landing page & category cards
    │   ├── QuizSetupScreen.kt              # Quiz configuration & Challenge integrity consent
    │   ├── QuizSessionScreen.kt            # Active question view, option locking & instant feedback
    │   ├── ResultsAndReviewScreens.kt      # Score medallion, share sheet & full answer review
    │   ├── ProgressAndHistoryScreens.kt    # Local analytics dashboard, history & attempt detail
    │   └── SettingsAndPrivacyScreen.kt     # Theme, Reduce Motion, Clear History & privacy transparency
    └── theme/
        ├── Color.kt                        # Midnight Navy, Electric Violet, Cyan & Daylight palettes
        ├── Type.kt                         # Space Grotesk, Plus Jakarta Sans & JetBrains Mono
        └── Theme.kt                        # Coordinated Light/Dark theme & motion tokens
```

---

## Setup & Verification

```bash
# Run unit and Robolectric tests
gradle :app:testDebugUnitTest

# Build installable Debug APK
gradle :app:assembleDebug
```

---

## Author

**Chethan Kumar D**
