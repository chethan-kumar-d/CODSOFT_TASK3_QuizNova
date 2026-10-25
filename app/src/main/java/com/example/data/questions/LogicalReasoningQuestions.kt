package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object LogicalReasoningQuestions {
    val questions: List<QuizQuestion> = listOf(
        // ==================== FOUNDATION (15) ====================
        QuizQuestion(
            id = "lr_f_01",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Find the next number in the sequence: `3, 7, 15, 31, 63, ?`",
            options = listOf(
                QuestionOption("a", "127"),
                QuestionOption("b", "125"),
                QuestionOption("c", "126"),
                QuestionOption("d", "95")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Observe the differences between consecutive terms: 7 - 3 = 4, 15 - 7 = 8, 31 - 15 = 16, 63 - 31 = 32. Step 2: Each difference doubles (or equivalently each term is 2x + 1). Step 3: Next term = 63 + 64 = 127."
        ),
        QuizQuestion(
            id = "lr_f_02",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given the rule: \"If an API request is unauthenticated, then the server returns status 401.\" Suppose a request returned status `200 OK`. Which conclusion is logically certain?",
            options = listOf(
                QuestionOption("a", "The API request was authenticated."),
                QuestionOption("b", "The API request was unauthenticated."),
                QuestionOption("c", "Every authenticated request always returns 200 OK."),
                QuestionOption("d", "No conclusion can be drawn about authentication.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Let P = \"unauthenticated\" and Q = \"returns 401\". The given rule is P → Q. Step 2: By Modus Tollens (contrapositive ¬Q → ¬P), since the server returned `200 OK` (¬Q), ¬P must hold: the request was authenticated."
        ),
        QuizQuestion(
            id = "lr_f_03",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a team of 40 developers, 26 know Python, 22 know Java, and 4 know neither language. How many developers know **both** Python and Java?",
            options = listOf(
                QuestionOption("a", "12"),
                QuestionOption("b", "8"),
                QuestionOption("c", "14"),
                QuestionOption("d", "10")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Developers who know at least one language = 40 - 4 = 36. Step 2: By Inclusion-Exclusion, |P ∪ J| = |P| + |J| - |P ∩ J|. Step 3: 36 = 26 + 22 - |P ∩ J| ⇒ |P ∩ J| = 48 - 36 = 12."
        ),
        QuizQuestion(
            id = "lr_f_04",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Five servers (`A, B, C, D, E`) are ranked by latency from lowest (fastest) to highest (slowest). `A` is faster than `B`, `C` is slower than `B`, `D` is faster than `A`, and `E` is slower than `C`. Which server has the median (3rd fastest) latency?",
            options = listOf(
                QuestionOption("a", "`B`"),
                QuestionOption("b", "`A`"),
                QuestionOption("c", "`C`"),
                QuestionOption("d", "`D`")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Order from fastest to slowest using the clues: `D` is faster than `A` (D < A); `A` is faster than `B` (D < A < B); `B` is faster than `C` (D < A < B < C); `C` is faster than `E` (D < A < B < C < E). Step 2: The 3rd server in the ordered list is `B`."
        ),
        QuizQuestion(
            id = "lr_f_05",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If the price of a software license is increased by 25%, by what percentage must the new price be reduced to restore it to the original price?",
            options = listOf(
                QuestionOption("a", "20%"),
                QuestionOption("b", "25%"),
                QuestionOption("c", "15%"),
                QuestionOption("d", "22.5%")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Start with an original price of 100. Step 2: Increasing by 25% gives 125. Step 3: To return from 125 to 100, the reduction is 25 out of 125: 25 / 125 = 1 / 5 = 20%."
        ),
        QuizQuestion(
            id = "lr_f_06",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A drawer in a dark room contains 6 blue cables, 8 black cables, and 4 red cables. What is the **minimum** number of cables you must pull out to be 100% certain you have at least 2 cables of the same color?",
            options = listOf(
                QuestionOption("a", "4"),
                QuestionOption("b", "2"),
                QuestionOption("c", "3"),
                QuestionOption("d", "7")
            ),
            correctOptionId = "a",
            explanation = "Step 1: There are 3 distinct colors (blue, black, red). Step 2: In the worst case, the first 3 cables picked could be 1 blue, 1 black, and 1 red. Step 3: By the Pigeonhole Principle, the 4th cable must match one of those 3 colors."
        ),
        QuizQuestion(
            id = "lr_f_07",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "An automated backup runs every 6 hours, and a health check runs every 8 hours. If both run together at `00:00` (midnight), after how many hours will they next run at the exact same time?",
            options = listOf(
                QuestionOption("a", "24 hours"),
                QuestionOption("b", "14 hours"),
                QuestionOption("c", "48 hours"),
                QuestionOption("d", "12 hours")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Simultaneous occurrences happen at common multiples of 6 and 8. Step 2: Compute the Least Common Multiple: 6 = 2 × 3 and 8 = 2³, so LCM(6, 8) = 2³ × 3 = 24 hours."
        ),
        QuizQuestion(
            id = "lr_f_08",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a letter-shift cipher where every letter is shifted forward by +3 positions in the alphabet (`A -> D`, `B -> E`, `C -> F`), how is the word `CODE` encoded?",
            options = listOf(
                QuestionOption("a", "`FRGH`"),
                QuestionOption("b", "`FRGF`"),
                QuestionOption("c", "`EPFG`"),
                QuestionOption("d", "`DPEF`")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Shift each letter by +3: `C` (3) → `F` (6); `O` (15) → `R` (18); `D` (4) → `G` (7); `E` (5) → `H` (8). Step 2: Combining them produces `FRGH`."
        ),
        QuizQuestion(
            id = "lr_f_09",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Premise 1: All unit tests are automated checks.\nPremise 2: Some automated checks are slow.\nWhich statement is logically guaranteed to be true?",
            options = listOf(
                QuestionOption("a", "Every unit test is an automated check, though slow checks may or may not overlap with unit tests."),
                QuestionOption("b", "All unit tests are slow."),
                QuestionOption("c", "Some unit tests are guaranteed to be slow."),
                QuestionOption("d", "No unit test can ever be slow.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Let U = unit tests and A = automated checks, with U ⊆ A. Step 2: Knowing some elements of A are slow (S ∩ A ≠ ∅) does not force S to intersect the subset U, nor does it forbid it. Only U ⊆ A is logically guaranteed."
        ),
        QuizQuestion(
            id = "lr_f_10",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A sensor robot starts at coordinates `(0, 0)`, moves 4 meters North, then 3 meters East, and then 1 meter South. What is its straight-line Euclidean distance from `(0, 0)`?",
            options = listOf(
                QuestionOption("a", "`3 * sqrt(2)` meters (approximately 4.24 m)"),
                QuestionOption("b", "5 meters"),
                QuestionOption("c", "8 meters"),
                QuestionOption("d", "6 meters")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Net North-South displacement = 4 - 1 = 3 meters North (y = 3). Step 2: Net East-West displacement = 3 meters East (x = 3). Step 3: Distance = √(3² + 3²) = √18 = 3√2 ≈ 4.24 m."
        ),
        QuizQuestion(
            id = "lr_f_11",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Find the missing term in the alternating sequence: `10, 20, 13, 18, 16, 16, 19, ?`",
            options = listOf(
                QuestionOption("a", "14"),
                QuestionOption("b", "22"),
                QuestionOption("c", "15"),
                QuestionOption("d", "17")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Separate odd-indexed and even-indexed positions. Odd positions (`1st, 3rd, 5th, 7th`): `10, 13, 16, 19` (+3 each time). Step 2: Even positions (`2nd, 4th, 6th, 8th`): `20, 18, 16, ?` (-2 each time). Step 3: 16 - 2 = 14."
        ),
        QuizQuestion(
            id = "lr_f_12",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "By De Morgan's Law, what is the exact logical negation of the condition `(isAdmin AND isVerified)`?",
            options = listOf(
                QuestionOption("a", "`(NOT isAdmin) OR (NOT isVerified)`"),
                QuestionOption("b", "`(NOT isAdmin) AND (NOT isVerified)`"),
                QuestionOption("c", "`isAdmin OR isVerified`"),
                QuestionOption("d", "`isAdmin AND (NOT isVerified)`")
            ),
            correctOptionId = "a",
            explanation = "Step 1: A conjunction A ∧ B fails as soon as at least one operand is false. Step 2: By De Morgan's Law, ¬(A ∧ B) ≡ (¬A) ∨ (¬B)."
        ),
        QuizQuestion(
            id = "lr_f_13",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "The average latency of 4 microservices is 30 ms. When a 5th microservice is added, the average latency of all 5 becomes 34 ms. What is the latency of the 5th microservice?",
            options = listOf(
                QuestionOption("a", "50 ms"),
                QuestionOption("b", "38 ms"),
                QuestionOption("c", "46 ms"),
                QuestionOption("d", "32 ms")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Total latency of the first 4 services = 4 × 30 = 120 ms. Step 2: Total latency of all 5 services = 5 × 34 = 170 ms. Step 3: Latency of the 5th service = 170 - 120 = 50 ms."
        ),
        QuizQuestion(
            id = "lr_f_14",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If two fair 6-sided dice (`1` through `6`) are rolled simultaneously, what is the probability that the sum of the two dice is exactly `7`?",
            options = listOf(
                QuestionOption("a", "`1/6` (6 out of 36)"),
                QuestionOption("b", "`1/12` (3 out of 36)"),
                QuestionOption("c", "`7/36`"),
                QuestionOption("d", "`1/9` (4 out of 36)")
            ),
            correctOptionId = "a",
            explanation = "Step 1: There are 6 × 6 = 36 equally likely ordered outcomes. Step 2: For any outcome `(d1, d2)`, there is a unique value d2 = 7 - d1 matching each of the 6 values of d1: `(1,6), (2,5), (3,4), (4,3), (5,2), (6,1)` (6 outcomes). Step 3: 6 / 36 = 1/6."
        ),
        QuizQuestion(
            id = "lr_f_15",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If 3 build servers can compile 3 identical projects in 3 minutes, how many minutes does it take 9 build servers working in parallel to compile 9 of those projects?",
            options = listOf(
                QuestionOption("a", "3 minutes"),
                QuestionOption("b", "9 minutes"),
                QuestionOption("c", "1 minute"),
                QuestionOption("d", "27 minutes")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Since 3 servers compile 3 projects in 3 minutes, 1 server compiles 1 project in 3 minutes. Step 2: Therefore, 9 servers working concurrently on 9 projects (1 project per server) also finish in 3 minutes."
        ),

        // ==================== APPLIED (15) ====================
        QuizQuestion(
            id = "lr_a_01",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Worker A can complete a data migration alone in 12 hours, and Worker B can complete the same migration alone in 6 hours. How many hours will it take if A and B work together at their constant rates?",
            options = listOf(
                QuestionOption("a", "4 hours"),
                QuestionOption("b", "9 hours"),
                QuestionOption("c", "3 hours"),
                QuestionOption("d", "4.5 hours")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Worker A completes 1/12 of the job per hour; Worker B completes 1/6 = 2/12 of the job per hour. Step 2: Combined rate = 1/12 + 2/12 = 3/12 = 1/4 job per hour. Step 3: Time = 1 / (1/4) = 4 hours."
        ),
        QuizQuestion(
            id = "lr_a_02",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Three nodes (`X, Y, Z`) are inspected. Exactly ONE of the three nodes is faulty, and **exactly ONE** of the following three diagnostic statements is true:\n• Statement 1: `X` is faulty.\n• Statement 2: `Y` is NOT faulty.\n• Statement 3: `X` is NOT faulty.\nWhich node is faulty?",
            options = listOf(
                QuestionOption("a", "`Y` is faulty."),
                QuestionOption("b", "`X` is faulty."),
                QuestionOption("c", "`Z` is faulty."),
                QuestionOption("d", "It cannot be uniquely determined.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Notice Statement 1 (`X is faulty`) and Statement 3 (`X is NOT faulty`) are logical contradictories, so exactly one of {Statement 1, Statement 3} must be True. Step 2: Since only one statement is True in total, Statement 2 (`Y is NOT faulty`) must be False. Step 3: Because `Y is NOT faulty` is False, `Y` is the faulty node."
        ),
        QuizQuestion(
            id = "lr_a_03",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A vehicle travels from Station P to Station Q at a constant speed of 40 km/h, and immediately returns along the exact same route from Q to P at 60 km/h. What is its average speed for the entire round trip?",
            options = listOf(
                QuestionOption("a", "48 km/h"),
                QuestionOption("b", "50 km/h"),
                QuestionOption("c", "45 km/h"),
                QuestionOption("d", "52 km/h")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Let the one-way distance be d = 120 km. Step 2: Time from P to Q = 120 / 40 = 3 hours; time from Q to P = 120 / 60 = 2 hours. Step 3: Total distance = 240 km and total time = 3 + 2 = 5 hours, so average speed = 240 / 5 = 48 km/h (the harmonic mean 2·v1·v2 / (v1 + v2))."
        ),
        QuizQuestion(
            id = "lr_a_04",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many 4-character alphanumeric passcodes can be formed if the first 2 characters must be **distinct** uppercase letters from `{A, B, C, D, E}` (5 letters) and the last 2 characters must be **distinct** digits from `{1, 2, 3, 4}` (4 digits)?",
            options = listOf(
                QuestionOption("a", "240"),
                QuestionOption("b", "400"),
                QuestionOption("c", "120"),
                QuestionOption("d", "60")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Choices for the 1st letter = 5; choices for the 2nd distinct letter = 4 (5 × 4 = 20 letter pairs). Step 2: Choices for the 1st digit = 4; choices for the 2nd distinct digit = 3 (4 × 3 = 12 digit pairs). Step 3: Total passcodes = 20 × 12 = 240."
        ),
        QuizQuestion(
            id = "lr_a_05",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "At `3:30` on a standard 12-hour analog clock, what is the acute angle (in degrees) between the hour hand and the minute hand?",
            options = listOf(
                QuestionOption("a", "75°"),
                QuestionOption("b", "90°"),
                QuestionOption("c", "60°"),
                QuestionOption("d", "82.5°")
            ),
            correctOptionId = "a",
            explanation = "Step 1: At 30 minutes past the hour, the minute hand points at 6 (30 × 6° = 180°). Step 2: Each hour mark is 30°, and at `3:30` the hour hand is halfway between 3 and 4: 3 × 30° + 30 × 0.5° = 90° + 15° = 105°. Step 3: Difference = |180° - 105°| = 75°."
        ),
        QuizQuestion(
            id = "lr_a_06",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Six engineers (`P, Q, R, S, T, U`) sit around a circular table facing the center.\n• `P` sits directly opposite `S`.\n• `Q` sits to the immediate right of `P`.\n• `R` sits opposite `Q`.\n• `T` sits to the immediate left of `P`.\nWho sits directly opposite `T`?",
            options = listOf(
                QuestionOption("a", "`U`"),
                QuestionOption("b", "`R`"),
                QuestionOption("c", "`Q`"),
                QuestionOption("d", "`S`")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Place 6 seats `0..5` counterclockwise around the circle. Put `P` at seat `0`, so `S` is opposite at seat `3`. Step 2: `Q` is immediate right of `P` (seat `1`), and `R` is opposite `Q` (seat `4`). Step 3: `T` is immediate left of `P` (seat `5`), leaving `U` at seat `2`—which is directly opposite seat `5` (`T`)."
        ),
        QuizQuestion(
            id = "lr_a_07",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a tournament of 37 players, every match is a 1-vs-1 single-elimination game (no ties; the loser is eliminated and the winner advances) until a single champion remains. With byes allowed in any round, how many total matches are played?",
            options = listOf(
                QuestionOption("a", "36 matches"),
                QuestionOption("b", "37 matches"),
                QuestionOption("c", "18 matches"),
                QuestionOption("d", "64 matches")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Use an invariant: every match produces exactly 1 eliminated loser. Step 2: To crown 1 champion out of 37 players, exactly 37 - 1 = 36 players must be eliminated. Step 3: Therefore, regardless of how byes are scheduled, exactly 36 matches must be played."
        ),
        QuizQuestion(
            id = "lr_a_08",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Find the next number in the sequence: `2, 3, 6, 15, 42, ?`",
            options = listOf(
                QuestionOption("a", "123"),
                QuestionOption("b", "114"),
                QuestionOption("c", "126"),
                QuestionOption("d", "96")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Compute consecutive differences: 3 - 2 = 1, 6 - 3 = 3, 15 - 6 = 9, 42 - 15 = 27. Step 2: The differences are successive powers of 3 (3^0 = 1, 3^1 = 3, 3^2 = 9, 3^3 = 27). Step 3: The next difference is 3^4 = 81, so 42 + 81 = 123."
        ),
        QuizQuestion(
            id = "lr_a_09",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A server cluster contains 5 primary nodes and 4 replica nodes. A maintenance script selects 2 nodes at random without replacement. What is the probability that **both** selected nodes are primary nodes?",
            options = listOf(
                QuestionOption("a", "`5/18`"),
                QuestionOption("b", "`25/81`"),
                QuestionOption("c", "`5/9`"),
                QuestionOption("d", "`1/3`")
            ),
            correctOptionId = "a",
            explanation = "Step 1: There are 5 + 4 = 9 nodes total. The probability the first node is primary is 5/9. Step 2: Given the first was primary, 4 primary nodes remain out of 8 total nodes (4/8 = 1/2). Step 3: Multiply: (5/9) × (1/2) = 5/18."
        ),
        QuizQuestion(
            id = "lr_a_10",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Premise 1: If a query uses an index (`I`), it finishes under 10 ms (`F`).\nPremise 2: If a query does NOT use an index (`NOT I`), it logs a warning (`W`).\nObservation: A query did NOT log a warning (`NOT W`). What follows logically?",
            options = listOf(
                QuestionOption("a", "The query used an index (`I`) AND finished under 10 ms (`F`)."),
                QuestionOption("b", "The query did not use an index, but still finished under 10 ms."),
                QuestionOption("c", "The query took longer than 10 ms."),
                QuestionOption("d", "Nothing can be concluded about whether the query finished under 10 ms.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: From Premise 2 (¬I → W) and observation ¬W, Modus Tollens gives ¬(¬I) ≡ I (the query used an index). Step 2: From Premise 1 (I → F) and I, Modus Ponens gives F (it finished under 10 ms)."
        ),
        QuizQuestion(
            id = "lr_a_11",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Solution X is 20% acid by volume, and Solution Y is 50% acid by volume. How many liters of Solution Y must be mixed with 10 liters of Solution X to obtain a mixture that is 30% acid?",
            options = listOf(
                QuestionOption("a", "5 liters"),
                QuestionOption("b", "10 liters"),
                QuestionOption("c", "4 liters"),
                QuestionOption("d", "6 liters")
            ),
            correctOptionId = "a",
            explanation = "Step 1: 10 liters of X contains 10 × 0.20 = 2 liters of acid. Step 2: Let y be the liters of Y added (containing 0.50y acid). Step 3: Solve (2 + 0.5y) / (10 + y) = 0.30 ⇒ 2 + 0.5y = 3 + 0.3y ⇒ 0.2y = 1 ⇒ y = 5 liters."
        ),
        QuizQuestion(
            id = "lr_a_12",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A 150-meter-long train traveling at 72 km/h (which equals 20 m/s) enters a 250-meter-long tunnel. How many seconds elapse from the instant the front of the train enters the tunnel until the rear of the train completely exits the tunnel?",
            options = listOf(
                QuestionOption("a", "20 seconds"),
                QuestionOption("b", "12.5 seconds"),
                QuestionOption("c", "7.5 seconds"),
                QuestionOption("d", "15 seconds")
            ),
            correctOptionId = "a",
            explanation = "Step 1: For the rear of the 150 m train to clear the 250 m tunnel, the front of the train must travel 250 + 150 = 400 meters. Step 2: At 20 m/s, time = 400 / 20 = 20 seconds."
        ),
        QuizQuestion(
            id = "lr_a_13",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A committee of 3 reviewers must be chosen from 4 backend engineers and 3 Android engineers. How many distinct committees of 3 contain **at least one** Android engineer?",
            options = listOf(
                QuestionOption("a", "31"),
                QuestionOption("b", "35"),
                QuestionOption("c", "27"),
                QuestionOption("d", "18")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Total ways to choose 3 people from all 4 + 3 = 7 engineers is C(7, 3) = (7 × 6 × 5) / 6 = 35. Step 2: Subtract committees with zero Android engineers (all 3 chosen from the 4 backend engineers): C(4, 3) = 4. Step 3: 35 - 4 = 31 committees."
        ),
        QuizQuestion(
            id = "lr_a_14",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Each card in a deck has a letter on one side and a number on the other. Four cards on the table show: `A`, `K`, `4`, `7`. To verify the rule \"If a card has a vowel on one side, then it has an even number on the other side\", which two cards are the **only** ones you need to flip over?",
            options = listOf(
                QuestionOption("a", "`A` and `7`"),
                QuestionOption("b", "`A` and `4`"),
                QuestionOption("c", "`K` and `7`"),
                QuestionOption("d", "All four cards")
            ),
            correctOptionId = "a",
            explanation = "Step 1: An implication P → Q (Vowel → Even) is falsified ONLY when P is True and Q is False (Vowel paired with Odd). Step 2: We must flip `A` (a vowel, P) to check its number is even, and `7` (an odd number, ¬Q) to check its letter is not a vowel. `K` (¬P) and `4` (Q) cannot falsify the rule."
        ),
        QuizQuestion(
            id = "lr_a_15",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A repository has 120 commits: 75 touch backend files, 60 touch frontend files, and 30 touch both backend and frontend files. How many commits touch **neither** backend nor frontend files (e.g., docs/CI only)?",
            options = listOf(
                QuestionOption("a", "15 commits"),
                QuestionOption("b", "25 commits"),
                QuestionOption("c", "10 commits"),
                QuestionOption("d", "0 commits")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Commits touching backend or frontend = |B ∪ F| = |B| + |F| - |B ∩ F| = 75 + 60 - 30 = 105. Step 2: Commits touching neither = 120 - 105 = 15."
        ),

        // ==================== ADVANCED (15) ====================
        QuizQuestion(
            id = "lr_x_01",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "1% of network packets on a link are malformed (`P(M) = 0.01`). A packet filter flags 99% of malformed packets (`P(Flag | M) = 0.99`), and falsely flags 1% of valid packets (`P(Flag | Valid) = 0.01`). If a packet is flagged, what is the exact probability `P(M | Flag)` that it is actually malformed?",
            options = listOf(
                QuestionOption("a", "50% (`1/2`)"),
                QuestionOption("b", "99%"),
                QuestionOption("c", "98%"),
                QuestionOption("d", "10%")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Out of 10,000 packets, 100 are malformed and 9,900 are valid. Step 2: True positives = 100 × 0.99 = 99; false positives = 9,900 × 0.01 = 99. Step 3: By Bayes' Theorem, P(M | Flag) = 99 / (99 + 99) = 99 / 198 = 50%."
        ),
        QuizQuestion(
            id = "lr_x_02",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "You have 9 identical-looking silicon wafers, except 1 wafer is slightly **heavier** than the other 8 (which all have equal weight). Using a two-pan balance scale without external weights, what is the **minimum** number of weighings needed to guarantee identifying the heavy wafer?",
            options = listOf(
                QuestionOption("a", "2 weighings"),
                QuestionOption("b", "3 weighings"),
                QuestionOption("c", "4 weighings"),
                QuestionOption("d", "1 weighing")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Divide the 9 wafers into three groups of 3: `(A, B, C)`, and weigh `A` vs `B`. Step 2: If one pan tips down, that group of 3 contains the heavy wafer; if they balance, group `C` has it. Step 3: Weigh 1 wafer vs 1 wafer from the identified group of 3 to pinpoint the heavy wafer in just 2 weighings (3² = 9)."
        ),
        QuizQuestion(
            id = "lr_x_03",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A standard 8 × 8 chessboard (64 squares) has two diagonally opposite corner squares removed, leaving 62 squares. You have 31 dominoes, each covering 2 orthogonally adjacent squares. Can the 62 remaining squares be completely tiled by the 31 dominoes?",
            options = listOf(
                QuestionOption("a", "No, because every domino covers 1 black and 1 white square, whereas removing two opposite corners removes two squares of the SAME color (leaving 32 of one color and 30 of the other)."),
                QuestionOption("b", "Yes, because 62 is evenly divisible by 2."),
                QuestionOption("c", "Yes, as long as dominoes are placed in a spiral from the center."),
                QuestionOption("d", "No, because 31 is a prime number.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Color the 8 × 8 board like a chessboard (32 white, 32 black). Diagonally opposite corners `(0,0)` and `(7,7)` share the same parity (0+0 and 7+7 are both even), so they have the same color. Step 2: Removing them leaves 32 squares of one color and 30 of the other. Step 3: Since each domino must cover 1 white and 1 black square, 31 dominoes must cover 31 of each color—an invariant impossibility."
        ),
        QuizQuestion(
            id = "lr_x_04",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How many trailing zeros are at the end of 100! (100 factorial = 1 × 2 × 3 × ... × 100) in base 10?",
            options = listOf(
                QuestionOption("a", "24"),
                QuestionOption("b", "20"),
                QuestionOption("c", "10"),
                QuestionOption("d", "25")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Each trailing zero comes from a factor of 10 = 2 × 5. Since factors of 2 are more plentiful than 5, count the exponent of 5 in the prime factorization of 100! (Legendre's formula). Step 2: floor(100 / 5) + floor(100 / 25) = 20 + 4 = 24 trailing zeros."
        ),
        QuizQuestion(
            id = "lr_x_05",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "100 server racks numbered `1` to `100` initially have their status LEDs turned OFF. For pass k = 1, 2, ..., 100, an automated script toggles every rack whose number is a multiple of k. After all 100 passes finish, how many racks have their LED turned ON?",
            options = listOf(
                QuestionOption("a", "10 racks (specifically the perfect squares `1, 4, 9, ..., 100`)."),
                QuestionOption("b", "50 racks (all odd-numbered racks)."),
                QuestionOption("c", "25 racks (all prime-numbered racks)."),
                QuestionOption("d", "1 rack (only rack 1).")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Rack n is toggled on pass k iff k divides n. Thus rack n ends ON iff n has an **odd** number of positive divisors. Step 2: Divisors come in pairs (d, n/d) unless d = n/d, which happens iff n is a perfect square. Step 3: There are 10 perfect squares ≤ 100 (1², 2², ..., 10²)."
        ),
        QuizQuestion(
            id = "lr_x_06",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Four processes (`A, B, C, D`) must cross a narrow bridge using a single shared token. At most 2 processes can cross together, and any crossing back requires 1 process to carry the token back. Crossing times are `A = 1 min`, `B = 2 min`, `C = 5 min`, `D = 10 min`, and a pair crosses at the slower member's speed. What is the minimum total time for all four to cross?",
            options = listOf(
                QuestionOption("a", "17 minutes"),
                QuestionOption("b", "19 minutes"),
                QuestionOption("c", "15 minutes"),
                QuestionOption("d", "21 minutes")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Avoid pairing `C (5)` and `D (10)` separately with `A`. Instead: `A` & `B` cross (2 min); `A` returns (1 min). Step 2: `C` & `D` cross together (10 min); `B` returns (2 min). Step 3: `A` & `B` cross together (2 min). Total = 2 + 1 + 10 + 2 + 2 = 17 minutes."
        ),
        QuizQuestion(
            id = "lr_x_07",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "You have two ungraduated hourglass timers: one measures exactly **7 minutes** and the other measures **4 minutes**. What is the simplest way to measure an exact **9-minute** interval?",
            options = listOf(
                QuestionOption("a", "Start both at t=0. At t=4 (4-min empties), flip the 4-min. At t=7 (7-min empties), flip the 7-min. At t=8 (4-min empties a second time, leaving 1 min of sand in the bottom of the 7-min), flip the 7-min again so that 1 min runs out at t=9."),
                QuestionOption("b", "Run the 7-minute timer once and the 4-minute timer once sequentially."),
                QuestionOption("c", "It is impossible because gcd(7, 4) = 1."),
                QuestionOption("d", "Run the 4-minute timer twice and stop halfway through the third run by eye.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Start both at t=0. At t=4, flip the 4-min timer. Step 2: At t=7, the 7-min timer finishes; flip it immediately. Step 3: One minute later at t=8, the 4-min timer finishes its second run—at that moment the 7-min timer has run for exactly 8 - 7 = 1 minute. Flipping the 7-min timer back takes 1 more minute, reaching 8 + 1 = 9 minutes."
        ),
        QuizQuestion(
            id = "lr_x_08",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Three opaque server boxes are labeled `\"2 SSDs\"`, `\"2 HDDs\"`, and `\"1 SSD + 1 HDD\"`, but **every single label is guaranteed to be on the wrong box**. By drawing just ONE drive from ONE box without looking inside, which box should you sample to deduce the contents of all three boxes with certainty?",
            options = listOf(
                QuestionOption("a", "The box labeled `\"1 SSD + 1 HDD\"`"),
                QuestionOption("b", "The box labeled `\"2 SSDs\"`"),
                QuestionOption("c", "The box labeled `\"2 HDDs\"`"),
                QuestionOption("d", "Any of the three boxes works equally well")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Since the box labeled `\"1 SSD + 1 HDD\"` is mislabeled, it must actually contain either `2 SSDs` or `2 HDDs`. Step 2: Drawing 1 drive from it immediately tells you whether that box is `2 SSDs` (if you draw an SSD) or `2 HDDs` (if you draw an HDD). Step 3: Since the other two boxes are also mislabeled, their identities are then uniquely forced."
        ),
        QuizQuestion(
            id = "lr_x_09",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Three automated tasks (`A, B, C`) are assigned to their 3 respective queues (`Q_A, Q_B, Q_C`) in a uniformly random permutation. In how many of the 3! = 6 possible permutations does **no task** land in its own matching queue (a **derangement** !3)?",
            options = listOf(
                QuestionOption("a", "2 permutations"),
                QuestionOption("b", "3 permutations"),
                QuestionOption("c", "1 permutation"),
                QuestionOption("d", "4 permutations")
            ),
            correctOptionId = "a",
            explanation = "Step 1: The 3! = 6 permutations of `(A, B, C)` are: `(A,B,C)` [3 fixed], `(A,C,B)`, `(C,B,A)`, `(B,A,C)` [1 fixed each], and the two 3-cycles `(B,C,A)` and `(C,A,B)` [0 fixed]. Step 2: Thus there are exactly !3 = 2 derangements."
        ),
        QuizQuestion(
            id = "lr_x_10",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A deployment verification test has 3 independent stages. Stage 1 passes with probability `0.7`, Stage 2 passes with probability `0.5`, and Stage 3 passes with probability `0.5`. What is the probability that **at least two** of the three stages pass?",
            options = listOf(
                QuestionOption("a", "`0.60` (60%)"),
                QuestionOption("b", "`0.50` (50%)"),
                QuestionOption("c", "`0.40` (40%)"),
                QuestionOption("d", "`0.70` (70%)")
            ),
            correctOptionId = "a",
            explanation = "Step 1: List the four mutually exclusive outcomes where ≥ 2 stages pass: `(P,P,P)`, `(P,P,F)`, `(P,F,P)`, `(F,P,P)`. Step 2: When Stage 1 passes (`0.7`), Stages 2 and 3 have 3 ways to yield at least one more pass (`PP, PF, FP`, probability 3 × 0.25 = 0.75), giving 0.7 × 0.75 = 0.525. Step 3: When Stage 1 fails (`0.3`), both Stages 2 and 3 must pass (0.3 × 0.25 = 0.075). Total = 0.525 + 0.075 = 0.60 (60%)."
        ),
        QuizQuestion(
            id = "lr_x_11",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the remainder when 2^50 is divided by 7 (2^50 mod 7)?",
            options = listOf(
                QuestionOption("a", "4"),
                QuestionOption("b", "2"),
                QuestionOption("c", "1"),
                QuestionOption("d", "6")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Notice that 2³ = 8 ≡ 1 (mod 7). Step 2: Divide the exponent 50 by 3: 50 = 3 × 16 + 2. Step 3: 2^50 = (2³)^16 × 2² ≡ 1^16 × 4 ≡ 4 (mod 7)."
        ),
        QuizQuestion(
            id = "lr_x_12",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A simple undirected graph has 8 vertices, and every vertex has degree 3 (each vertex is connected to 3 edges). How many edges does the graph have in total?",
            options = listOf(
                QuestionOption("a", "12 edges"),
                QuestionOption("b", "24 edges"),
                QuestionOption("c", "11 edges"),
                QuestionOption("d", "16 edges")
            ),
            correctOptionId = "a",
            explanation = "Step 1: By the Handshaking Lemma, the sum of vertex degrees equals twice the number of edges (sum of deg(v) = 2|E|) because each edge contributes 2 to the total degree sum. Step 2: 8 × 3 = 24 = 2|E| ⇒ |E| = 12 edges."
        ),
        QuizQuestion(
            id = "lr_x_13",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Two players alternate taking 1, 2, or 3 tokens from a pile of **18 tokens**. The player who takes the very last token wins. How many tokens should the first player take on the opening move to guarantee a win against any strategy?",
            options = listOf(
                QuestionOption("a", "2 tokens (leaving 16, a multiple of 4)"),
                QuestionOption("b", "3 tokens (leaving 15)"),
                QuestionOption("c", "1 token (leaving 17)"),
                QuestionOption("d", "The second player can always force a win from 18")
            ),
            correctOptionId = "a",
            explanation = "Step 1: With allowed moves `{1, 2, 3}`, any multiple of 1 + 3 = 4 (`4, 8, 12, 16`) is a losing position for the player whose turn it is, because whatever k in {1, 2, 3} they take, the opponent can take 4 - k to restore a multiple of 4. Step 2: From 18, the first player takes 18 - 16 = 2 tokens, leaving 16."
        ),
        QuizQuestion(
            id = "lr_x_14",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Ten server racks (`1` through `10`) contain motherboards weighing 100 g each, except one rack contains defective boards weighing 101 g each. Using a digital precision scale **only once**, how can you identify which rack has the 101 g boards?",
            options = listOf(
                QuestionOption("a", "Take 1 board from Rack 1, 2 boards from Rack 2, ..., and 10 boards from Rack 10 (55 boards total), weigh them all together, and subtract 5500 g; the excess weight in grams equals the defective rack number."),
                QuestionOption("b", "Take 1 board from each of the 10 racks and weigh all 10 together."),
                QuestionOption("c", "Weigh only 5 boards from Rack 5 and 5 boards from Rack 10."),
                QuestionOption("d", "It is impossible with a single reading on a digital scale.")
            ),
            correctOptionId = "a",
            explanation = "Step 1: Taking i boards from Rack i for i = 1..10 gives 1 + 2 + ... + 10 = 55 boards. Step 2: If all boards weighed 100 g, the total would be 55 × 100 = 5500 g. Step 3: If Rack k has 101 g boards, it adds k × 1 = k extra grams, so Weight - 5500 = k."
        ),
        QuizQuestion(
            id = "lr_x_15",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a room of n people, what is the minimum value of n required to guarantee (by the Pigeonhole Principle) that at least **3 people** were born in the same calendar month (out of 12 months)?",
            options = listOf(
                QuestionOption("a", "25"),
                QuestionOption("b", "24"),
                QuestionOption("c", "13"),
                QuestionOption("d", "36")
            ),
            correctOptionId = "a",
            explanation = "Step 1: There are 12 months (pigeonholes). Step 2: The maximum number of people without any month having 3 people is when every month has at most 2 people: 12 × 2 = 24 people. Step 3: Adding 1 more person (24 + 1 = 25) forces at least one month to have ceil(25 / 12) = 3 people."
        )
    )
}
