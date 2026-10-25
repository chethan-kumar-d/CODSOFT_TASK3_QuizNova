package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object LogicalReasoningExtraQuestions {
    val questions: List<QuizQuestion> by lazy {
        foundationBatch1() + foundationBatch2() +
            appliedBatch1() + appliedBatch2() +
            advancedBatch1() + advancedBatch2()
    }

    private fun foundationBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "lr_f_16",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the next number in the arithmetic sequence: 7, 13, 19, 25, 31, ?",
            options = listOf(
                QuestionOption("a", "37"),
                QuestionOption("b", "35"),
                QuestionOption("c", "36"),
                QuestionOption("d", "39")
            ),
            correctOptionId = "a",
            explanation = "Each term increases by a constant difference of +6: 31 + 6 = 37."
        ),
        QuizQuestion(
            id = "lr_f_17",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the next number in the geometric sequence: 3, 6, 12, 24, 48, ?",
            options = listOf(
                QuestionOption("a", "72"),
                QuestionOption("b", "84"),
                QuestionOption("c", "108"),
                QuestionOption("d", "96")
            ),
            correctOptionId = "d",
            explanation = "Each term is multiplied by 2: 48 * 2 = 96."
        ),
        QuizQuestion(
            id = "lr_f_18",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Find the next number in the sequence of perfect squares: 4, 9, 16, 25, 36, ?",
            options = listOf(
                QuestionOption("a", "48"),
                QuestionOption("b", "64"),
                QuestionOption("c", "49"),
                QuestionOption("d", "45")
            ),
            correctOptionId = "c",
            explanation = "The sequence is 2^2, 3^2, 4^2, 5^2, 6^2, so the next term is 7^2 = 49."
        ),
        QuizQuestion(
            id = "lr_f_19",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Find the next number in the sequence of cubes: 1, 8, 27, 64, 125, ?",
            options = listOf(
                QuestionOption("a", "256"),
                QuestionOption("b", "216"),
                QuestionOption("c", "196"),
                QuestionOption("d", "225")
            ),
            correctOptionId = "b",
            explanation = "The terms are 1^3, 2^3, 3^3, 4^3, 5^3, so the next term is 6^3 = 216."
        ),
        QuizQuestion(
            id = "lr_f_20",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What comes next in the increasing-difference sequence: 2, 4, 7, 11, 16, 22, ?",
            options = listOf(
                QuestionOption("a", "29"),
                QuestionOption("b", "28"),
                QuestionOption("c", "30"),
                QuestionOption("d", "27")
            ),
            correctOptionId = "a",
            explanation = "The differences between consecutive terms are +2, +3, +4, +5, +6, so the next difference is +7: 22 + 7 = 29."
        ),
        QuizQuestion(
            id = "lr_f_21",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What comes next in the Fibonacci-style sequence: 2, 3, 5, 8, 13, 21, ?",
            options = listOf(
                QuestionOption("a", "32"),
                QuestionOption("b", "33"),
                QuestionOption("c", "35"),
                QuestionOption("d", "34")
            ),
            correctOptionId = "d",
            explanation = "Each term is the sum of the two preceding terms: 13 + 21 = 34."
        ),
        QuizQuestion(
            id = "lr_f_22",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Find the missing term in the alternating sequence: 10, 20, 13, 23, 16, 26, ?",
            options = listOf(
                QuestionOption("a", "18"),
                QuestionOption("b", "36"),
                QuestionOption("c", "19"),
                QuestionOption("d", "29")
            ),
            correctOptionId = "c",
            explanation = "The rule alternates +10 and -7 (or two interleaved sequences 10, 13, 16, 19 and 20, 23, 26), giving 19."
        ),
        QuizQuestion(
            id = "lr_f_23",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In the letter series B, E, H, K, N, what is the next letter?",
            options = listOf(
                QuestionOption("a", "O"),
                QuestionOption("b", "Q"),
                QuestionOption("c", "P"),
                QuestionOption("d", "R")
            ),
            correctOptionId = "b",
            explanation = "Advancing by +3 alphabet positions each step: B(2), E(5), H(8), K(11), N(14), Q(17)."
        ),
        QuizQuestion(
            id = "lr_f_24",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In the letter-pair series AZ, BY, CX, DW, what comes next?",
            options = listOf(
                QuestionOption("a", "EV"),
                QuestionOption("b", "EU"),
                QuestionOption("c", "FV"),
                QuestionOption("d", "EW")
            ),
            correctOptionId = "a",
            explanation = "The first letter moves forward from A (A, B, C, D, E) while the second moves backward from Z (Z, Y, X, W, V), giving EV."
        ),
        QuizQuestion(
            id = "lr_f_25",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If each letter is assigned its alphabetical position (A=1, B=2, ..., Z=26), what is the sum of the letters in the word `CODE`?",
            options = listOf(
                QuestionOption("a", "25"),
                QuestionOption("b", "28"),
                QuestionOption("c", "30"),
                QuestionOption("d", "27")
            ),
            correctOptionId = "d",
            explanation = "C(3) + O(15) + D(4) + E(5) = 27."
        ),
        QuizQuestion(
            id = "lr_f_26",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a simple shift cipher where every letter is shifted forward by 1 position (`A -> B`, `B -> C`, ...), how is `LOGIC` encoded?",
            options = listOf(
                QuestionOption("a", "MPIJD"),
                QuestionOption("b", "LPHJD"),
                QuestionOption("c", "MPHJD"),
                QuestionOption("d", "KNFHB")
            ),
            correctOptionId = "c",
            explanation = "L->M, O->P, G->H, I->J, C->D gives MPHJD."
        ),
        QuizQuestion(
            id = "lr_f_27",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If a shift cipher encodes `DATA` as `FCVC` (shifting each letter forward by +2), how does it encode `BYTE`?",
            options = listOf(
                QuestionOption("a", "CAVG"),
                QuestionOption("b", "DAVG"),
                QuestionOption("c", "CZUF"),
                QuestionOption("d", "DAUF")
            ),
            correctOptionId = "b",
            explanation = "Shifting each letter forward by +2: B(2)->D(4), Y(25)->A(1), T(20)->V(22), E(5)->G(7) = DAVG."
        ),
        QuizQuestion(
            id = "lr_f_28",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Statement: 'If the server is overloaded, then latency increases.' Suppose we observe that latency did NOT increase. What must be true?",
            options = listOf(
                QuestionOption("a", "The server is not overloaded (Contrapositive)"),
                QuestionOption("b", "The server is overloaded"),
                QuestionOption("c", "The network cable is unplugged"),
                QuestionOption("d", "Nothing can be concluded")
            ),
            correctOptionId = "a",
            explanation = "By Modus Tollens (contrapositive of P -> Q is ~Q -> ~P), if latency did not increase (~Q), then the server is not overloaded (~P)."
        ),
        QuizQuestion(
            id = "lr_f_29",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Statement: 'If a number is divisible by 6, then it is divisible by 3.' Given that N is divisible by 3, what can we validly conclude?",
            options = listOf(
                QuestionOption("a", "N is definitely divisible by 6"),
                QuestionOption("b", "N is definitely NOT divisible by 6"),
                QuestionOption("c", "N must be an odd number"),
                QuestionOption("d", "We cannot conclude whether N is divisible by 6 (e.g., N could be 9 or 12)")
            ),
            correctOptionId = "d",
            explanation = "Assuming the converse (Q -> P from P -> Q) is the fallacy of affirming the consequent; 9 is divisible by 3 but not by 6."
        ),
        QuizQuestion(
            id = "lr_f_30",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Premise 1: All compilers are software tools. Premise 2: All software tools require memory. Which conclusion necessarily follows?",
            options = listOf(
                QuestionOption("a", "No compiler requires memory"),
                QuestionOption("b", "Only compilers require memory"),
                QuestionOption("c", "All compilers require memory"),
                QuestionOption("d", "All programs that require memory are compilers")
            ),
            correctOptionId = "c",
            explanation = "By transitive categorical syllogism (All A are B; All B are C => All A are C), all compilers require memory."
        ),
        QuizQuestion(
            id = "lr_f_31",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the logical negation of the statement: 'Every test case in the suite passed'?",
            options = listOf(
                QuestionOption("a", "Half of the test cases passed"),
                QuestionOption("b", "At least one test case in the suite did NOT pass"),
                QuestionOption("c", "No test case in the suite passed"),
                QuestionOption("d", "Every test case in the suite failed")
            ),
            correctOptionId = "b",
            explanation = "The negation of the universal quantifier 'For all x, P(x)' is the existential quantifier 'There exists at least one x such that NOT P(x)'."
        ),
        QuizQuestion(
            id = "lr_f_32",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the logical negation of the statement: 'At least one server in the cluster is offline'?",
            options = listOf(
                QuestionOption("a", "All servers in the cluster are online (none are offline)"),
                QuestionOption("b", "All servers in the cluster are offline"),
                QuestionOption("c", "At least two servers are online"),
                QuestionOption("d", "Exactly one server is online")
            ),
            correctOptionId = "a",
            explanation = "The negation of 'There exists an x that is offline' is 'No x is offline' (i.e., all servers are online)."
        ),
        QuizQuestion(
            id = "lr_f_33",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Five developers—Asha, Bilal, Charu, Dev, and Elena—finish a coding challenge with no ties. Asha finishes before Bilal. Charu finishes before Asha. Dev finishes after Bilal. Elena finishes before Charu. Who finished in 1st place?",
            options = listOf(
                QuestionOption("a", "Charu"),
                QuestionOption("b", "Asha"),
                QuestionOption("c", "Bilal"),
                QuestionOption("d", "Elena")
            ),
            correctOptionId = "d",
            explanation = "The order from 1st to 5th is Elena -> Charu -> Asha -> Bilal -> Dev, so Elena finished 1st."
        ),
        QuizQuestion(
            id = "lr_f_34",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a single row of 25 chairs, Priya is sitting in the 11th chair from the left end. What is her position from the right end?",
            options = listOf(
                QuestionOption("a", "16th"),
                QuestionOption("b", "13th"),
                QuestionOption("c", "15th"),
                QuestionOption("d", "14th")
            ),
            correctOptionId = "c",
            explanation = "Position from right = Total - Position from left + 1 = 25 - 11 + 1 = 15th."
        ),
        QuizQuestion(
            id = "lr_f_35",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a queue, Rohan is 8th from the front and 14th from the back. How many people are in the queue in total?",
            options = listOf(
                QuestionOption("a", "23"),
                QuestionOption("b", "21"),
                QuestionOption("c", "22"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "b",
            explanation = "Total = 8 + 14 - 1 (since Rohan is counted in both) = 21 people."
        ),
        QuizQuestion(
            id = "lr_f_36",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Kiran walks 6 km North, then turns right (East) and walks 8 km. What is the straight-line distance from his starting point?",
            options = listOf(
                QuestionOption("a", "10 km"),
                QuestionOption("b", "14 km"),
                QuestionOption("c", "12 km"),
                QuestionOption("d", "9 km")
            ),
            correctOptionId = "a",
            explanation = "By the Pythagorean theorem on the right triangle with legs 6 and 8: sqrt(6^2 + 8^2) = sqrt(36 + 64) = sqrt(100) = 10 km."
        ),
        QuizQuestion(
            id = "lr_f_37",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Meera is facing North. She turns 90 degrees clockwise, then 180 degrees counterclockwise, and finally 45 degrees clockwise. Which direction is she facing now?",
            options = listOf(
                QuestionOption("a", "North-East"),
                QuestionOption("b", "South-West"),
                QuestionOption("c", "West"),
                QuestionOption("d", "North-West")
            ),
            correctOptionId = "d",
            explanation = "Starting at North (0°): +90° (East) - 180° (West, 270°) + 45° = 315°, which is North-West."
        ),
        QuizQuestion(
            id = "lr_f_38",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Pointing to a photograph, Arjun says, 'She is the daughter of the only child of my grandmother.' Assuming Arjun's grandmother has only one child, how is the girl in the photograph related to Arjun?",
            options = listOf(
                QuestionOption("a", "She is Arjun's mother"),
                QuestionOption("b", "She is Arjun's cousin"),
                QuestionOption("c", "She is Arjun's sister"),
                QuestionOption("d", "She is Arjun's aunt")
            ),
            correctOptionId = "c",
            explanation = "The only child of Arjun's grandmother is Arjun's parent; the daughter of Arjun's parent is Arjun's sister."
        ),
        QuizQuestion(
            id = "lr_f_39",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If A is the brother of B, B is the sister of C, and C is the father of D, how is A related to D?",
            options = listOf(
                QuestionOption("a", "Cousin"),
                QuestionOption("b", "Paternal uncle"),
                QuestionOption("c", "Brother"),
                QuestionOption("d", "Grandfather")
            ),
            correctOptionId = "b",
            explanation = "A is the brother of C, and C is D's father, so A is D's paternal uncle."
        ),
        QuizQuestion(
            id = "lr_f_40",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A dataset of 5 API response times (in ms) is: 12, 18, 15, 25, 20. What is the arithmetic mean (average)?",
            options = listOf(
                QuestionOption("a", "18 ms"),
                QuestionOption("b", "17 ms"),
                QuestionOption("c", "19 ms"),
                QuestionOption("d", "15 ms")
            ),
            correctOptionId = "a",
            explanation = "(12 + 18 + 15 + 25 + 20) / 5 = 90 / 5 = 18 ms."
        ),
        QuizQuestion(
            id = "lr_f_41",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the median of the following 7 test scores: 72, 88, 65, 91, 79, 84, 70?",
            options = listOf(
                QuestionOption("a", "84"),
                QuestionOption("b", "72"),
                QuestionOption("c", "80"),
                QuestionOption("d", "79")
            ),
            correctOptionId = "d",
            explanation = "Sorted in ascending order: 65, 70, 72, 79, 84, 88, 91. The middle (4th) value is 79."
        ),
        QuizQuestion(
            id = "lr_f_42",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the median of the 6 numbers: 10, 24, 14, 30, 18, 22?",
            options = listOf(
                QuestionOption("a", "22"),
                QuestionOption("b", "19"),
                QuestionOption("c", "20"),
                QuestionOption("d", "18")
            ),
            correctOptionId = "c",
            explanation = "Sorted: 10, 14, 18, 22, 24, 30. The average of the two middle numbers (18 and 22) is (18 + 22) / 2 = 20."
        ),
        QuizQuestion(
            id = "lr_f_43",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In the dataset `4, 7, 9, 7, 12, 4, 7, 10`, what is the mode?",
            options = listOf(
                QuestionOption("a", "9"),
                QuestionOption("b", "7"),
                QuestionOption("c", "4"),
                QuestionOption("d", "8")
            ),
            correctOptionId = "b",
            explanation = "The mode is the most frequently occurring value; 7 appears three times."
        ),
        QuizQuestion(
            id = "lr_f_44",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A cloud subscription costs \$240 per year. After a 15% discount, what is the discounted annual price?",
            options = listOf(
                QuestionOption("a", "\$204"),
                QuestionOption("b", "\$210"),
                QuestionOption("c", "\$196"),
                QuestionOption("d", "\$216")
            ),
            correctOptionId = "a",
            explanation = "15% of 240 is 0.15 * 240 = 36; 240 - 36 = \$204."
        ),
        QuizQuestion(
            id = "lr_f_45",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If the number of daily active users grows from 800 to 1,000, what is the percentage increase?",
            options = listOf(
                QuestionOption("a", "20%"),
                QuestionOption("b", "22.5%"),
                QuestionOption("c", "30%"),
                QuestionOption("d", "25%")
            ),
            correctOptionId = "d",
            explanation = "Percentage increase = (1000 - 800) / 800 * 100% = 200 / 800 * 100% = 25%."
        ),
        QuizQuestion(
            id = "lr_f_46",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a team of 45 engineers, the ratio of backend to frontend developers is 5 : 4. How many backend developers are on the team?",
            options = listOf(
                QuestionOption("a", "27"),
                QuestionOption("b", "24"),
                QuestionOption("c", "25"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "c",
            explanation = "Total ratio parts = 5 + 4 = 9. Backend developers = (5 / 9) * 45 = 25."
        ),
        QuizQuestion(
            id = "lr_f_47",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If 6 build servers can compile a repository in 20 minutes working at the same rate, how many minutes would 10 identical build servers take (assuming perfect parallel scaling)?",
            options = listOf(
                QuestionOption("a", "33.3 minutes"),
                QuestionOption("b", "12 minutes"),
                QuestionOption("c", "15 minutes"),
                QuestionOption("d", "10 minutes")
            ),
            correctOptionId = "b",
            explanation = "Total server-minutes = 6 * 20 = 120. With 10 servers: 120 / 10 = 12 minutes."
        ),
        QuizQuestion(
            id = "lr_f_48",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A train travels 180 km in 2 hours and 30 minutes. What is its average speed in km/h?",
            options = listOf(
                QuestionOption("a", "72 km/h"),
                QuestionOption("b", "75 km/h"),
                QuestionOption("c", "60 km/h"),
                QuestionOption("d", "80 km/h")
            ),
            correctOptionId = "a",
            explanation = "2 hours 30 minutes = 2.5 hours. Speed = 180 / 2.5 = 72 km/h."
        ),
        QuizQuestion(
            id = "lr_f_49",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Convert a speed of 20 meters per second (m/s) into kilometers per hour (km/h).",
            options = listOf(
                QuestionOption("a", "60 km/h"),
                QuestionOption("b", "54 km/h"),
                QuestionOption("c", "80 km/h"),
                QuestionOption("d", "72 km/h")
            ),
            correctOptionId = "d",
            explanation = "Multiply m/s by 3.6 (i.e., 18/5): 20 * 3.6 = 72 km/h."
        ),
        QuizQuestion(
            id = "lr_f_50",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Convert a speed of 90 kilometers per hour (km/h) into meters per second (m/s).",
            options = listOf(
                QuestionOption("a", "30 m/s"),
                QuestionOption("b", "15 m/s"),
                QuestionOption("c", "25 m/s"),
                QuestionOption("d", "20 m/s")
            ),
            correctOptionId = "c",
            explanation = "Multiply km/h by 5/18: 90 * (5 / 18) = 25 m/s."
        ),
        QuizQuestion(
            id = "lr_f_51",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A fair 6-sided die (numbered 1 to 6) is rolled once. What is the probability of rolling a prime number?",
            options = listOf(
                QuestionOption("a", "1/6"),
                QuestionOption("b", "1/2 (or 3/6)"),
                QuestionOption("c", "1/3 (or 2/6)"),
                QuestionOption("d", "2/3 (or 4/6)")
            ),
            correctOptionId = "b",
            explanation = "The prime numbers on a 6-sided die are 2, 3, and 5 (note: 1 is NOT prime), giving 3 / 6 = 1/2."
        ),
        QuizQuestion(
            id = "lr_f_52",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Two fair coins are tossed simultaneously. What is the probability of getting at least one Head?",
            options = listOf(
                QuestionOption("a", "3/4"),
                QuestionOption("b", "1/2"),
                QuestionOption("c", "1/4"),
                QuestionOption("d", "2/3")
            ),
            correctOptionId = "a",
            explanation = "The 4 equally likely outcomes are HH, HT, TH, TT; 3 of the 4 have at least one Head (or 1 - P(TT) = 1 - 1/4 = 3/4)."
        ),
        QuizQuestion(
            id = "lr_f_53",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A bag contains 5 red tokens, 3 blue tokens, and 2 green tokens. If one token is drawn at random, what is the probability that it is NOT red?",
            options = listOf(
                QuestionOption("a", "3/10"),
                QuestionOption("b", "2/5"),
                QuestionOption("c", "3/5"),
                QuestionOption("d", "1/2 (5/10)")
            ),
            correctOptionId = "d",
            explanation = "There are 10 tokens total and 3 + 2 = 5 non-red tokens, so 5 / 10 = 1/2."
        ),
        QuizQuestion(
            id = "lr_f_54",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a group of 40 students, 26 know Python, 22 know Java, and every student knows at least one of the two languages. How many students know BOTH Python and Java?",
            options = listOf(
                QuestionOption("a", "6"),
                QuestionOption("b", "10"),
                QuestionOption("c", "8"),
                QuestionOption("d", "12")
            ),
            correctOptionId = "c",
            explanation = "By Inclusion-Exclusion: |P U J| = |P| + |J| - |P ∩ J| => 40 = 26 + 22 - Both => Both = 48 - 40 = 8."
        ),
        QuizQuestion(
            id = "lr_f_55",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a survey of 60 developers, 35 use Linux, 28 use macOS, and 10 use BOTH Linux and macOS. How many developers use NEITHER Linux nor macOS?",
            options = listOf(
                QuestionOption("a", "12"),
                QuestionOption("b", "7"),
                QuestionOption("c", "10"),
                QuestionOption("d", "5")
            ),
            correctOptionId = "b",
            explanation = "|L U M| = 35 + 28 - 10 = 53. Neither = 60 - 53 = 7."
        ),
        QuizQuestion(
            id = "lr_f_56",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If today is Wednesday, what day of the week will it be 30 days from today?",
            options = listOf(
                QuestionOption("a", "Friday"),
                QuestionOption("b", "Thursday"),
                QuestionOption("c", "Saturday"),
                QuestionOption("d", "Monday")
            ),
            correctOptionId = "a",
            explanation = "30 mod 7 = 2 remainder days. Wednesday + 2 days = Friday."
        ),
        QuizQuestion(
            id = "lr_f_57",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "At 3:00 PM on a standard 12-hour analog clock, what is the smaller angle (in degrees) between the hour hand and the minute hand?",
            options = listOf(
                QuestionOption("a", "75 degrees"),
                QuestionOption("b", "60 degrees"),
                QuestionOption("c", "120 degrees"),
                QuestionOption("d", "90 degrees")
            ),
            correctOptionId = "d",
            explanation = "At 3:00, the minute hand is at 12 (0°) and the hour hand is exactly at 3 (3 * 30° = 90°)."
        ),
        QuizQuestion(
            id = "lr_f_58",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How many degrees does the minute hand of a standard analog clock rotate in 20 minutes?",
            options = listOf(
                QuestionOption("a", "90 degrees"),
                QuestionOption("b", "100 degrees"),
                QuestionOption("c", "120 degrees"),
                QuestionOption("d", "60 degrees")
            ),
            correctOptionId = "c",
            explanation = "The minute hand completes 360° in 60 minutes (6° per minute), so in 20 minutes it rotates 20 * 6° = 120°."
        )
    )

    private fun foundationBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "lr_f_59",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If 3 notebooks and 2 pens cost \$19, and 1 notebook and 2 pens cost \$9, what is the cost of 1 notebook?",
            options = listOf(
                QuestionOption("a", "\$3"),
                QuestionOption("b", "\$5"),
                QuestionOption("c", "\$4"),
                QuestionOption("d", "\$6")
            ),
            correctOptionId = "b",
            explanation = "Subtracting the two equations: (3N + 2P) - (1N + 2P) = 19 - 9 => 2N = 10 => N = \$5."
        ),
        QuizQuestion(
            id = "lr_f_60",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "The sum of two numbers is 34 and their difference is 10. What is the larger of the two numbers?",
            options = listOf(
                QuestionOption("a", "22"),
                QuestionOption("b", "12"),
                QuestionOption("c", "24"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "a",
            explanation = "If x + y = 34 and x - y = 10, adding gives 2x = 44 => x = 22 (and y = 12)."
        ),
        QuizQuestion(
            id = "lr_f_61",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Today, a mother is 3 times as old as her daughter. If the sum of their ages today is 48 years, how old is the daughter today?",
            options = listOf(
                QuestionOption("a", "16 years old"),
                QuestionOption("b", "14 years old"),
                QuestionOption("c", "10 years old"),
                QuestionOption("d", "12 years old")
            ),
            correctOptionId = "d",
            explanation = "3d + d = 48 => 4d = 48 => d = 12 years old."
        ),
        QuizQuestion(
            id = "lr_f_62",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How many different 3-letter arrangements (permutations) can be formed using the distinct letters of the word `CAT` without repeating any letter?",
            options = listOf(
                QuestionOption("a", "9"),
                QuestionOption("b", "27"),
                QuestionOption("c", "6"),
                QuestionOption("d", "3")
            ),
            correctOptionId = "c",
            explanation = "3! = 3 * 2 * 1 = 6 arrangements (CAT, CTA, ACT, ATC, TCA, TAC)."
        ),
        QuizQuestion(
            id = "lr_f_63",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A restaurant menu offers 4 appetizers, 5 main courses, and 3 desserts. In how many ways can a customer choose 1 appetizer, 1 main course, and 1 dessert?",
            options = listOf(
                QuestionOption("a", "45"),
                QuestionOption("b", "60"),
                QuestionOption("c", "12"),
                QuestionOption("d", "23")
            ),
            correctOptionId = "b",
            explanation = "By the Fundamental Counting Principle (multiplication rule): 4 * 5 * 3 = 60 combinations."
        ),
        QuizQuestion(
            id = "lr_f_64",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In how many ways can a committee of 2 people be chosen from a group of 6 people (order does not matter)?",
            options = listOf(
                QuestionOption("a", "15"),
                QuestionOption("b", "12"),
                QuestionOption("c", "30"),
                QuestionOption("d", "36")
            ),
            correctOptionId = "a",
            explanation = "6 choose 2 = (6 * 5) / 2 = 15."
        ),
        QuizQuestion(
            id = "lr_f_65",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which number is the odd one out among `16, 25, 36, 48, 64`?",
            options = listOf(
                QuestionOption("a", "16"),
                QuestionOption("b", "25"),
                QuestionOption("c", "64"),
                QuestionOption("d", "48 (it is the only number that is not a perfect square)")
            ),
            correctOptionId = "d",
            explanation = "16=4^2, 25=5^2, 36=6^2, and 64=8^2 are all perfect squares, whereas 48 is not."
        ),
        QuizQuestion(
            id = "lr_f_66",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which number is the odd one out among `11, 13, 17, 21, 23`?",
            options = listOf(
                QuestionOption("a", "17"),
                QuestionOption("b", "23"),
                QuestionOption("c", "21 (it is composite: 3 * 7, while all others are prime numbers)"),
                QuestionOption("d", "11")
            ),
            correctOptionId = "c",
            explanation = "11, 13, 17, and 23 are prime numbers; 21 = 3 * 7 is composite."
        ),
        QuizQuestion(
            id = "lr_f_67",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Analogy: `Compiler : Source Code` is most analogous to `Browser : ?`",
            options = listOf(
                QuestionOption("a", "Power Supply"),
                QuestionOption("b", "HTML / Web Page"),
                QuestionOption("c", "Keyboard"),
                QuestionOption("d", "Hard Drive")
            ),
            correctOptionId = "b",
            explanation = "A compiler parses and processes source code just as a browser parses and renders an HTML web page."
        ),
        QuizQuestion(
            id = "lr_f_68",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If `\$800` is invested at `5%` simple interest per year, how much total interest is earned after `3` years?",
            options = listOf(
                QuestionOption("a", "\$120"),
                QuestionOption("b", "\$40"),
                QuestionOption("c", "\$150"),
                QuestionOption("d", "\$100")
            ),
            correctOptionId = "a",
            explanation = "Simple Interest = P * R * T = 800 * 0.05 * 3 = \$120."
        ),
        QuizQuestion(
            id = "lr_f_69",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A hardware store buys a router for \$50 and sells it for \$65. What is the profit percentage on the cost price?",
            options = listOf(
                QuestionOption("a", "15%"),
                QuestionOption("b", "25%"),
                QuestionOption("c", "23%"),
                QuestionOption("d", "30%")
            ),
            correctOptionId = "d",
            explanation = "Profit = 65 - 50 = \$15. Profit % = (15 / 50) * 100% = 30%."
        ),
        QuizQuestion(
            id = "lr_f_70",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A rectangle has a length of 12 cm and a width of 5 cm. What is the length of its diagonal?",
            options = listOf(
                QuestionOption("a", "15 cm"),
                QuestionOption("b", "14 cm"),
                QuestionOption("c", "13 cm"),
                QuestionOption("d", "17 cm")
            ),
            correctOptionId = "c",
            explanation = "By the Pythagorean theorem: sqrt(12^2 + 5^2) = sqrt(144 + 25) = sqrt(169) = 13 cm."
        ),
        QuizQuestion(
            id = "lr_f_71",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If the side length of a square is doubled, by what factor does its area increase?",
            options = listOf(
                QuestionOption("a", "16 times"),
                QuestionOption("b", "4 times"),
                QuestionOption("c", "2 times"),
                QuestionOption("d", "8 times")
            ),
            correctOptionId = "b",
            explanation = "Area = s^2; replacing s with 2s gives (2s)^2 = 4s^2 (4 times the original area)."
        ),
        QuizQuestion(
            id = "lr_f_72",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A water tank is 2/5 full. After adding 18 liters of water, it becomes 7/10 full. What is the total capacity of the tank?",
            options = listOf(
                QuestionOption("a", "60 liters"),
                QuestionOption("b", "50 liters"),
                QuestionOption("c", "45 liters"),
                QuestionOption("d", "80 liters")
            ),
            correctOptionId = "a",
            explanation = "7/10 - 2/5 = 7/10 - 4/10 = 3/10 of the tank = 18 liters => total capacity = 18 * 10 / 3 = 60 liters."
        ),
        QuizQuestion(
            id = "lr_f_73",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Pipe A can fill an empty tank in 6 hours, and Pipe B can fill the same tank in 3 hours. If both pipes are opened together, how many hours will it take to fill the empty tank?",
            options = listOf(
                QuestionOption("a", "4.5 hours"),
                QuestionOption("b", "3 hours"),
                QuestionOption("c", "1.5 hours"),
                QuestionOption("d", "2 hours")
            ),
            correctOptionId = "d",
            explanation = "Combined rate = 1/6 + 1/3 = 1/6 + 2/6 = 3/6 = 1/2 tank per hour, so it takes 2 hours."
        ),
        QuizQuestion(
            id = "lr_f_74",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the missing number in the sequence: 100, 95, 85, 70, 50, ?",
            options = listOf(
                QuestionOption("a", "20"),
                QuestionOption("b", "35"),
                QuestionOption("c", "25"),
                QuestionOption("d", "30")
            ),
            correctOptionId = "c",
            explanation = "The differences are -5, -10, -15, -20, so the next step is -25: 50 - 25 = 25."
        ),
        QuizQuestion(
            id = "lr_f_75",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the missing number in the sequence: 1, 2, 6, 24, 120, ?",
            options = listOf(
                QuestionOption("a", "840"),
                QuestionOption("b", "720"),
                QuestionOption("c", "600"),
                QuestionOption("d", "480")
            ),
            correctOptionId = "b",
            explanation = "These are factorials (1!, 2!, 3!, 4!, 5!), multiplying by 2, 3, 4, 5, and next by 6: 120 * 6 = 720."
        ),
        QuizQuestion(
            id = "lr_f_76",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Four friends (P, Q, R, S) sit at the four corners of a square table facing the center. P sits opposite R, and Q sits to the immediate right of P. Who sits to the immediate left of P?",
            options = listOf(
                QuestionOption("a", "S"),
                QuestionOption("b", "R"),
                QuestionOption("c", "Q"),
                QuestionOption("d", "P")
            ),
            correctOptionId = "a",
            explanation = "With P and R opposite each other and Q on P's immediate right, S must occupy the remaining seat on P's immediate left."
        ),
        QuizQuestion(
            id = "lr_f_77",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If `x / 4 + 3 = 10`, what is the value of `x`?",
            options = listOf(
                QuestionOption("a", "24"),
                QuestionOption("b", "32"),
                QuestionOption("c", "52"),
                QuestionOption("d", "28")
            ),
            correctOptionId = "d",
            explanation = "x / 4 = 10 - 3 = 7 => x = 7 * 4 = 28."
        ),
        QuizQuestion(
            id = "lr_f_78",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the least common multiple (LCM) of `12` and `18`?",
            options = listOf(
                QuestionOption("a", "54"),
                QuestionOption("b", "72"),
                QuestionOption("c", "36"),
                QuestionOption("d", "6")
            ),
            correctOptionId = "c",
            explanation = "Multiples of 12: 12, 24, 36; multiples of 18: 18, 36. The smallest common multiple is 36."
        ),
        QuizQuestion(
            id = "lr_f_79",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When a positive integer `N` is divided by `7`, the quotient is `8` and the remainder is `5`. What is `N`?",
            options = listOf(
                QuestionOption("a", "47"),
                QuestionOption("b", "61"),
                QuestionOption("c", "56"),
                QuestionOption("d", "53")
            ),
            correctOptionId = "b",
            explanation = "By the division algorithm: N = 7 * 8 + 5 = 56 + 5 = 61."
        ),
        QuizQuestion(
            id = "lr_f_80",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the average of the first 10 positive even integers (`2, 4, 6, ..., 20`)?",
            options = listOf(
                QuestionOption("a", "11"),
                QuestionOption("b", "10"),
                QuestionOption("c", "12"),
                QuestionOption("d", "10.5")
            ),
            correctOptionId = "a",
            explanation = "In an arithmetic progression, the average equals the average of the first and last terms: (2 + 20) / 2 = 11."
        ),
        QuizQuestion(
            id = "lr_f_81",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the sum of all integers from `1` to `20` inclusive (`1 + 2 + 3 + ... + 20`)?",
            options = listOf(
                QuestionOption("a", "200"),
                QuestionOption("b", "190"),
                QuestionOption("c", "220"),
                QuestionOption("d", "210")
            ),
            correctOptionId = "d",
            explanation = "Using Gauss's formula n(n + 1) / 2: 20 * 21 / 2 = 210."
        ),
        QuizQuestion(
            id = "lr_f_82",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A box contains 8 black socks and 8 white socks in a dark room. What is the minimum number of socks you must pull out to be 100% certain of having a matching pair of the same color?",
            options = listOf(
                QuestionOption("a", "9 socks"),
                QuestionOption("b", "4 socks"),
                QuestionOption("c", "3 socks"),
                QuestionOption("d", "2 socks")
            ),
            correctOptionId = "c",
            explanation = "By the Pigeonhole Principle with 2 colors, drawing 3 socks guarantees at least 2 socks share the same color."
        ),
        QuizQuestion(
            id = "lr_f_83",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A drawer holds 5 red, 5 blue, and 5 green cables. Without looking, what is the minimum number of cables you must draw to guarantee having at least 2 cables of the SAME color?",
            options = listOf(
                QuestionOption("a", "2 cables"),
                QuestionOption("b", "4 cables"),
                QuestionOption("c", "3 cables"),
                QuestionOption("d", "6 cables")
            ),
            correctOptionId = "b",
            explanation = "With 3 colors (pigeonholes), worst case you draw 1 of each color in the first 3 draws; the 4th cable must match one of them."
        ),
        QuizQuestion(
            id = "lr_f_84",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If all `Glints` are `Sparks`, and no `Sparks` are `Dulls`, which statement MUST be true?",
            options = listOf(
                QuestionOption("a", "No `Glints` are `Dulls`"),
                QuestionOption("b", "Some `Glints` are `Dulls`"),
                QuestionOption("c", "All `Sparks` are `Glints`"),
                QuestionOption("d", "All `Dulls` are `Glints`")
            ),
            correctOptionId = "a",
            explanation = "Since Glints are a subset of Sparks and Sparks are disjoint from Dulls, Glints are completely disjoint from Dulls."
        ),
        QuizQuestion(
            id = "lr_f_85",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A digital log records an alert every 15 minutes starting at `09:00` (including one at `09:00`). How many alerts are recorded from `09:00` to `11:00` inclusive?",
            options = listOf(
                QuestionOption("a", "8 alerts"),
                QuestionOption("b", "7 alerts"),
                QuestionOption("c", "10 alerts"),
                QuestionOption("d", "9 alerts")
            ),
            correctOptionId = "d",
            explanation = "2 hours = 120 minutes; 120 / 15 = 8 intervals, plus 1 for the starting fencepost at 09:00 = 9 alerts."
        ),
        QuizQuestion(
            id = "lr_f_86",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A 30-meter cable is cut into smaller pieces of 3 meters each. How many cuts are required (assuming pieces are cut one at a time without folding)?",
            options = listOf(
                QuestionOption("a", "11 cuts"),
                QuestionOption("b", "8 cuts"),
                QuestionOption("c", "9 cuts"),
                QuestionOption("d", "10 cuts")
            ),
            correctOptionId = "c",
            explanation = "30 / 3 = 10 pieces; producing 10 pieces requires 10 - 1 = 9 cuts (fencepost principle)."
        ),
        QuizQuestion(
            id = "lr_f_87",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If 40% of a number is 72, what is 25% of that same number?",
            options = listOf(
                QuestionOption("a", "50"),
                QuestionOption("b", "45"),
                QuestionOption("c", "40"),
                QuestionOption("d", "48")
            ),
            correctOptionId = "b",
            explanation = "0.40 * N = 72 => N = 180. Then 25% of 180 = 180 / 4 = 45."
        ),
        QuizQuestion(
            id = "lr_f_88",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "On a map with a scale of `1 cm = 25 km`, the distance between two data centers is `6.4 cm`. What is the actual distance between them?",
            options = listOf(
                QuestionOption("a", "160 km"),
                QuestionOption("b", "150 km"),
                QuestionOption("c", "175 km"),
                QuestionOption("d", "140 km")
            ),
            correctOptionId = "a",
            explanation = "6.4 * 25 = 160 km."
        ),
        QuizQuestion(
            id = "lr_f_89",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A recipe for 6 servings uses 150 grams of oats. How many grams of oats are needed for 10 servings?",
            options = listOf(
                QuestionOption("a", "240 grams"),
                QuestionOption("b", "225 grams"),
                QuestionOption("c", "300 grams"),
                QuestionOption("d", "250 grams")
            ),
            correctOptionId = "d",
            explanation = "(150 / 6) * 10 = 25 * 10 = 250 grams."
        ),
        QuizQuestion(
            id = "lr_f_90",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the units digit (last digit) of `7^2 + 8^2`?",
            options = listOf(
                QuestionOption("a", "7"),
                QuestionOption("b", "1"),
                QuestionOption("c", "3"),
                QuestionOption("d", "5")
            ),
            correctOptionId = "c",
            explanation = "7^2 = 49 and 8^2 = 64; 49 + 64 = 113, whose units digit is 3."
        ),
        QuizQuestion(
            id = "lr_f_91",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which fraction is the largest among `2/3`, `3/5`, `5/8`, and `7/10`?",
            options = listOf(
                QuestionOption("a", "3/5 (0.60)"),
                QuestionOption("b", "7/10 (0.70)"),
                QuestionOption("c", "2/3 (0.667)"),
                QuestionOption("d", "5/8 (0.625)")
            ),
            correctOptionId = "b",
            explanation = "Converting to decimals: 3/5 = 0.60, 5/8 = 0.625, 2/3 ≈ 0.667, and 7/10 = 0.70."
        ),
        QuizQuestion(
            id = "lr_f_92",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A student scored 78, 82, and 86 on the first three quizzes. What score must the student get on the 4th quiz to achieve an overall average of 85 across all 4 quizzes?",
            options = listOf(
                QuestionOption("a", "94"),
                QuestionOption("b", "92"),
                QuestionOption("c", "90"),
                QuestionOption("d", "96")
            ),
            correctOptionId = "a",
            explanation = "Total needed for 4 quizzes = 4 * 85 = 340. Current sum = 78 + 82 + 86 = 246. Needed = 340 - 246 = 94."
        ),
        QuizQuestion(
            id = "lr_f_93",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a binary truth table with 3 boolean variables `(P, Q, R)`, how many total rows (combinations of truth values) are there?",
            options = listOf(
                QuestionOption("a", "6 rows"),
                QuestionOption("b", "9 rows"),
                QuestionOption("c", "4 rows"),
                QuestionOption("d", "8 rows (2^3)")
            ),
            correctOptionId = "d",
            explanation = "Each of the 3 boolean variables has 2 possible values (True/False), giving 2^3 = 8 rows."
        ),
        QuizQuestion(
            id = "lr_f_94",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If `P` is `True` and `Q` is `False`, what is the truth value of `(P OR Q) AND (NOT Q)`?",
            options = listOf(
                QuestionOption("a", "Unknown"),
                QuestionOption("b", "Both True and False"),
                QuestionOption("c", "True"),
                QuestionOption("d", "False")
            ),
            correctOptionId = "c",
            explanation = "`P OR Q` is `True OR False = True`, and `NOT Q` is `NOT False = True`, so `True AND True = True`."
        ),
        QuizQuestion(
            id = "lr_f_95",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If `P` is `False` and `Q` is `True`, what is the truth value of the logical implication `P -> Q` ('If P, then Q')?",
            options = listOf(
                QuestionOption("a", "Null"),
                QuestionOption("b", "True (an implication with a false premise is vacuously True)"),
                QuestionOption("c", "False"),
                QuestionOption("d", "Contradiction")
            ),
            correctOptionId = "b",
            explanation = "In classical logic, `P -> Q` is equivalent to `(NOT P) OR Q`, which is only False when `P` is True and `Q` is False."
        ),
        QuizQuestion(
            id = "lr_f_96",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A store reduces the price of a \$100 keyboard by 20%, and then offers an additional 10% off the already-reduced sale price. What is the final price?",
            options = listOf(
                QuestionOption("a", "\$72"),
                QuestionOption("b", "\$70"),
                QuestionOption("c", "\$75"),
                QuestionOption("d", "\$68")
            ),
            correctOptionId = "a",
            explanation = "First reduction: \$100 * 0.80 = \$80. Second reduction: \$80 * 0.90 = \$72 (a combined 28% discount, not 30%)."
        ),
        QuizQuestion(
            id = "lr_f_97",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Two runners start at the same point on a 400-meter circular track and run in the SAME direction at 5 m/s and 3 m/s. After how many seconds will the faster runner lap (meet) the slower runner for the first time?",
            options = listOf(
                QuestionOption("a", "50 seconds"),
                QuestionOption("b", "80 seconds"),
                QuestionOption("c", "100 seconds"),
                QuestionOption("d", "200 seconds")
            ),
            correctOptionId = "d",
            explanation = "Relative speed in the same direction = 5 - 3 = 2 m/s. To gain 1 full lap (400 m): 400 / 2 = 200 seconds."
        ),
        QuizQuestion(
            id = "lr_f_98",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If the same two runners (5 m/s and 3 m/s) start from the same point on the 400-meter circular track but run in OPPOSITE directions, after how many seconds will they first meet?",
            options = listOf(
                QuestionOption("a", "80 seconds"),
                QuestionOption("b", "40 seconds"),
                QuestionOption("c", "50 seconds"),
                QuestionOption("d", "200 seconds")
            ),
            correctOptionId = "c",
            explanation = "Relative speed in opposite directions = 5 + 3 = 8 m/s. Time to cover 400 m together = 400 / 8 = 50 seconds."
        ),
        QuizQuestion(
            id = "lr_f_99",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "A number is doubled and then 9 is subtracted, giving a result of 25. What was the original number?",
            options = listOf(
                QuestionOption("a", "8"),
                QuestionOption("b", "17"),
                QuestionOption("c", "16"),
                QuestionOption("d", "18")
            ),
            correctOptionId = "b",
            explanation = "2x - 9 = 25 => 2x = 34 => x = 17."
        ),
        QuizQuestion(
            id = "lr_f_100",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a class of 30 students, 60% are girls. If 5 more girls join the class, what fraction of the new class of 35 students are girls?",
            options = listOf(
                QuestionOption("a", "23/35"),
                QuestionOption("b", "18/35"),
                QuestionOption("c", "4/7"),
                QuestionOption("d", "5/7")
            ),
            correctOptionId = "a",
            explanation = "Initially 0.60 * 30 = 18 girls. After 5 more join, there are 18 + 5 = 23 girls out of 35 total students (23/35)."
        )
    )

    private fun appliedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "lr_a_16",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A commuter drives 60 km from City A to City B at 40 km/h, and immediately returns the same 60 km from City B to City A at 60 km/h. What is the average speed for the entire 120 km round trip?",
            options = listOf(
                QuestionOption("a", "48 km/h (the harmonic mean `2*40*60 / (40 + 60)`, NOT 50 km/h!)"),
                QuestionOption("b", "50 km/h"),
                QuestionOption("c", "45 km/h"),
                QuestionOption("d", "52 km/h")
            ),
            correctOptionId = "a",
            explanation = "Time A->B = 60/40 = 1.5 hrs; Time B->A = 60/60 = 1.0 hr. Total distance / total time = 120 / 2.5 = 48 km/h."
        ),
        QuizQuestion(
            id = "lr_a_17",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A 150-meter-long train traveling at 54 km/h (15 m/s) crosses a 210-meter-long bridge. How many seconds does it take from the moment the front of the train enters the bridge until the rear exits?",
            options = listOf(
                QuestionOption("a", "14 seconds"),
                QuestionOption("b", "10 seconds"),
                QuestionOption("c", "30 seconds"),
                QuestionOption("d", "24 seconds")
            ),
            correctOptionId = "d",
            explanation = "Total distance to clear the bridge = train length + bridge length = 150 + 210 = 360 m. Time = 360 m / 15 m/s = 24 seconds."
        ),
        QuizQuestion(
            id = "lr_a_18",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Two trains of lengths 120 m and 180 m are running in OPPOSITE directions on parallel tracks at 42 km/h and 48 km/h. How many seconds do they take to completely pass each other?",
            options = listOf(
                QuestionOption("a", "10 seconds"),
                QuestionOption("b", "18 seconds"),
                QuestionOption("c", "12 seconds"),
                QuestionOption("d", "15 seconds")
            ),
            correctOptionId = "c",
            explanation = "Combined length = 120 + 180 = 300 m. Relative speed = 42 + 48 = 90 km/h = 25 m/s. Time = 300 / 25 = 12 seconds."
        ),
        QuizQuestion(
            id = "lr_a_19",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A boat travels at 12 km/h in still water, and the river current flows at 3 km/h. How long does it take the boat to travel 45 km downstream AND return 45 km upstream?",
            options = listOf(
                QuestionOption("a", "6 hours"),
                QuestionOption("b", "8 hours (3 hours downstream + 5 hours upstream)"),
                QuestionOption("c", "7.5 hours"),
                QuestionOption("d", "9 hours")
            ),
            correctOptionId = "b",
            explanation = "Downstream speed = 12 + 3 = 15 km/h (45/15 = 3 hrs); upstream speed = 12 - 3 = 9 km/h (45/9 = 5 hrs). Total = 3 + 5 = 8 hours."
        ),
        QuizQuestion(
            id = "lr_a_20",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Developer A can build a module in 12 days, and Developer B can build it in 15 days. They work together for 4 days, after which A leaves. How many MORE days will B take alone to finish the remaining work?",
            options = listOf(
                QuestionOption("a", "6 days"),
                QuestionOption("b", "5 days"),
                QuestionOption("c", "8 days"),
                QuestionOption("d", "7.5 days")
            ),
            correctOptionId = "a",
            explanation = "In 4 days together, they complete 4 * (1/12 + 1/15) = 4 * (9/60) = 3/5 of the work. Remaining 2/5 at B's rate (1/15 per day) takes (2/5) / (1/15) = 6 days."
        ),
        QuizQuestion(
            id = "lr_a_21",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Pipe A fills a tank in 10 hours, Pipe B fills it in 15 hours, while drain Pipe C can empty the full tank in 30 hours. If all three pipes are opened simultaneously on an empty tank, how long until the tank is full?",
            options = listOf(
                QuestionOption("a", "6 hours"),
                QuestionOption("b", "8 hours"),
                QuestionOption("c", "5 hours"),
                QuestionOption("d", "7.5 hours")
            ),
            correctOptionId = "d",
            explanation = "Net filling rate = 1/10 + 1/15 - 1/30 = (3 + 2 - 1) / 30 = 4/30 = 2/15 per hour. Time = 15 / 2 = 7.5 hours."
        ),
        QuizQuestion(
            id = "lr_a_22",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A 40-liter mixture of milk and water contains 10% water. How many liters of pure water must be added so that water becomes 20% of the new mixture?",
            options = listOf(
                QuestionOption("a", "6 liters"),
                QuestionOption("b", "8 liters"),
                QuestionOption("c", "5 liters"),
                QuestionOption("d", "4 liters")
            ),
            correctOptionId = "c",
            explanation = "Initially there are 36 L of milk (90%). In the new mixture, those 36 L of milk must represent 80% (4/5) of total volume: 0.80 * V = 36 => V = 45 L, so 45 - 40 = 5 liters of water added."
        ),
        QuizQuestion(
            id = "lr_a_23",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Chemist A mixes a 20% acid solution with a 50% acid solution to obtain 30 liters of a 30% acid solution. How many liters of the 20% solution were used?",
            options = listOf(
                QuestionOption("a", "25 liters"),
                QuestionOption("b", "20 liters (and 10 liters of the 50% solution)"),
                QuestionOption("c", "15 liters"),
                QuestionOption("d", "10 liters")
            ),
            correctOptionId = "b",
            explanation = "By alligation: ratio of 20% to 50% is (50 - 30) : (30 - 20) = 20 : 10 = 2 : 1. Two-thirds of 30 L = 20 liters."
        ),
        QuizQuestion(
            id = "lr_a_24",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If the price of a cloud storage plan increases by 25%, by what percentage must a team reduce its storage consumption to keep its monthly expenditure unchanged?",
            options = listOf(
                QuestionOption("a", "20%"),
                QuestionOption("b", "25%"),
                QuestionOption("c", "15%"),
                QuestionOption("d", "22.5%")
            ),
            correctOptionId = "a",
            explanation = "If price becomes 5/4 of original, consumption must become 4/5 of original—a reduction of 1/5 = 20%."
        ),
        QuizQuestion(
            id = "lr_a_25",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A merchant marks an item 40% above its cost price and then gives a 20% discount on the marked price. What is the net profit percentage on the cost price?",
            options = listOf(
                QuestionOption("a", "20% profit"),
                QuestionOption("b", "15% profit"),
                QuestionOption("c", "8% profit"),
                QuestionOption("d", "12% profit")
            ),
            correctOptionId = "d",
            explanation = "1.40 * 0.80 = 1.12 of cost price, which is a 12% net profit."
        ),
        QuizQuestion(
            id = "lr_a_26",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If a merchant sells two gadgets for \$120 each, making a 20% profit on the first gadget and a 20% loss on the second gadget, what is the overall net result?",
            options = listOf(
                QuestionOption("a", "A net profit of \$10"),
                QuestionOption("b", "A net loss of \$20"),
                QuestionOption("c", "A net loss of \$10 (4% loss on total cost of \$250)"),
                QuestionOption("d", "Break even (\$0 profit or loss)")
            ),
            correctOptionId = "c",
            explanation = "Cost of 1st = 120 / 1.20 = \$100; Cost of 2nd = 120 / 0.80 = \$150. Total cost = \$250 vs. Total revenue = \$240 => \$10 net loss!"
        ),
        QuizQuestion(
            id = "lr_a_27",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "An amount of \$2,000 is invested at 10% annual interest compounded annually for 2 years. What is the total compound interest earned?",
            options = listOf(
                QuestionOption("a", "\$410"),
                QuestionOption("b", "\$420"),
                QuestionOption("c", "\$400"),
                QuestionOption("d", "\$440")
            ),
            correctOptionId = "b",
            explanation = "After 2 years: 2000 * (1.10)^2 = 2000 * 1.21 = \$2,420. Interest = 2420 - 2000 = \$420 (\$20 more than simple interest)."
        ),
        QuizQuestion(
            id = "lr_a_28",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Four years ago, the ratio of Aarav's age to Bhanu's age was `3 : 4`. Four years from now, the ratio of their ages will be `5 : 6`. What is Aarav's present age?",
            options = listOf(
                QuestionOption("a", "16 years old"),
                QuestionOption("b", "12 years old"),
                QuestionOption("c", "20 years old"),
                QuestionOption("d", "18 years old")
            ),
            correctOptionId = "a",
            explanation = "From 4 years ago to 4 years hence is +8 years, and the ratio steps by +2 parts (`3->5` and `4->6`), so 2 parts = 8 years => 1 part = 4 years. Four years ago Aarav was 3*4 = 12, so today Aarav is 12 + 4 = 16."
        ),
        QuizQuestion(
            id = "lr_a_29",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "The average age of a team of 8 members is 27 years. When a new team lead joins, the average age of all 9 people increases to 29 years. How old is the new team lead?",
            options = listOf(
                QuestionOption("a", "38 years old"),
                QuestionOption("b", "42 years old"),
                QuestionOption("c", "47 years old"),
                QuestionOption("d", "45 years old")
            ),
            correctOptionId = "d",
            explanation = "New total = 9 * 29 = 261; old total = 8 * 27 = 216. Team lead's age = 261 - 216 = 45 (or 27 + 9 * 2 = 45)."
        ),
        QuizQuestion(
            id = "lr_a_30",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "While computing the average score of 10 students, a score of `84` was misread as `48`, yielding an incorrect average of `71.4`. What is the true average?",
            options = listOf(
                QuestionOption("a", "76.0"),
                QuestionOption("b", "73.8"),
                QuestionOption("c", "75.0"),
                QuestionOption("d", "74.6")
            ),
            correctOptionId = "c",
            explanation = "The sum was understated by 84 - 48 = 36 across 10 students (+3.6 to the average): 71.4 + 3.6 = 75.0."
        ),
        QuizQuestion(
            id = "lr_a_31",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "At exactly `4:20` on an analog clock, what is the exact angle between the hour hand and the minute hand?",
            options = listOf(
                QuestionOption("a", "20 degrees"),
                QuestionOption("b", "10 degrees"),
                QuestionOption("c", "0 degrees"),
                QuestionOption("d", "15 degrees")
            ),
            correctOptionId = "b",
            explanation = "At 4:20, the minute hand is at 4 (120°), while the hour hand has moved 20/60 = 1/3 of the way from 4 to 5 (120° + 10° = 130°). Difference = 10°."
        ),
        QuizQuestion(
            id = "lr_a_32",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "At `2:30` on an analog clock, what is the angle between the hour hand and the minute hand?",
            options = listOf(
                QuestionOption("a", "105 degrees"),
                QuestionOption("b", "120 degrees"),
                QuestionOption("c", "90 degrees"),
                QuestionOption("d", "115 degrees")
            ),
            correctOptionId = "a",
            explanation = "Minute hand at 30 min = 180°. Hour hand at 2:30 = 2 * 30° + 30 * 0.5° = 75°. Angle = 180° - 75° = 105°."
        ),
        QuizQuestion(
            id = "lr_a_33",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many times in a 12-hour period do the hour and minute hands of an analog clock overlap (coincide)?",
            options = listOf(
                QuestionOption("a", "12 times"),
                QuestionOption("b", "10 times"),
                QuestionOption("c", "13 times"),
                QuestionOption("d", "11 times (and 22 times in 24 hours)")
            ),
            correctOptionId = "d",
            explanation = "Because the hour hand also moves forward, the hands overlap once every 12/11 hours (≈ 65.45 minutes), which is 11 times in 12 hours (the overlap between 11 and 1 happens right at 12:00)."
        ),
        QuizQuestion(
            id = "lr_a_34",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many leap years occur in the 100-year span from the year `2001` to the year `2100` inclusive (in the Gregorian calendar)?",
            options = listOf(
                QuestionOption("a", "26 leap years"),
                QuestionOption("b", "20 leap years"),
                QuestionOption("c", "24 leap years (because `2100` is divisible by 100 but NOT by 400, so `2100` is NOT a leap year!)"),
                QuestionOption("d", "25 leap years")
            ),
            correctOptionId = "c",
            explanation = "Century years are leap years ONLY if divisible by 400 (like 2000 and 2400); 2100 is not divisible by 400, leaving 24 leap years in 2001–2100."
        ),
        QuizQuestion(
            id = "lr_a_35",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In how many ways can 5 distinct books be arranged on a shelf if 2 specific books (Book A and Book B) must ALWAYS be placed next to each other?",
            options = listOf(
                QuestionOption("a", "120"),
                QuestionOption("b", "48"),
                QuestionOption("c", "24"),
                QuestionOption("d", "60")
            ),
            correctOptionId = "b",
            explanation = "Treat `(A, B)` as a single block: there are 4! = 24 ways to arrange the 4 items, and 2! = 2 ways to order A and B within the block: 24 * 2 = 48."
        ),
        QuizQuestion(
            id = "lr_a_36",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In how many ways can 5 distinct books be arranged on a shelf if Book A and Book B must NEVER be placed next to each other?",
            options = listOf(
                QuestionOption("a", "72"),
                QuestionOption("b", "48"),
                QuestionOption("c", "96"),
                QuestionOption("d", "60")
            ),
            correctOptionId = "a",
            explanation = "Total arrangements (5! = 120) minus arrangements where A and B are adjacent (48) = 120 - 48 = 72."
        ),
        QuizQuestion(
            id = "lr_a_37",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many distinct anagrams (arrangements of all letters) can be formed from the 6-letter word `BANANA`?",
            options = listOf(
                QuestionOption("a", "720"),
                QuestionOption("b", "120"),
                QuestionOption("c", "30"),
                QuestionOption("d", "60")
            ),
            correctOptionId = "d",
            explanation = "`BANANA` has 6 letters with 3 A's, 2 N's, and 1 B: 6! / (3! * 2! * 1!) = 720 / (6 * 2) = 60."
        ),
        QuizQuestion(
            id = "lr_a_38",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In how many ways can 6 people be seated around a circular table if rotations of the same seating arrangement are considered identical?",
            options = listOf(
                QuestionOption("a", "60"),
                QuestionOption("b", "24"),
                QuestionOption("c", "120 (which is `(6 - 1)! = 5!`)"),
                QuestionOption("d", "720 (6!)")
            ),
            correctOptionId = "c",
            explanation = "For `n` people around a circle up to rotation, fix one person's seat as the reference and permute the remaining `n - 1` people in `(n - 1)! = 5! = 120` ways."
        ),
        QuizQuestion(
            id = "lr_a_39",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A committee of 4 members is to be formed from 5 developers and 3 designers such that the committee includes at least 1 designer. How many such committees are possible?",
            options = listOf(
                QuestionOption("a", "60"),
                QuestionOption("b", "65"),
                QuestionOption("c", "70"),
                QuestionOption("d", "55")
            ),
            correctOptionId = "b",
            explanation = "Total committees of 4 from 8 people = (8 choose 4) = 70. Subtract committees with 0 designers (5 choose 4 = 5): 70 - 5 = 65."
        ),
        QuizQuestion(
            id = "lr_a_40",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "At a meetup of 12 people, every person shakes hands with every other person exactly once. How many total handshakes take place?",
            options = listOf(
                QuestionOption("a", "66"),
                QuestionOption("b", "144"),
                QuestionOption("c", "132"),
                QuestionOption("d", "72")
            ),
            correctOptionId = "a",
            explanation = "Number of pairs = (12 choose 2) = 12 * 11 / 2 = 66."
        ),
        QuizQuestion(
            id = "lr_a_41",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many diagonals does a convex octagon (an 8-sided polygon) have?",
            options = listOf(
                QuestionOption("a", "16"),
                QuestionOption("b", "28"),
                QuestionOption("c", "24"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "d",
            explanation = "An n-sided polygon has n(n - 3) / 2 diagonals (or (8 choose 2) - 8 sides = 28 - 8 = 20)."
        ),
        QuizQuestion(
            id = "lr_a_42",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Two standard 6-sided dice are rolled. What is the probability that the sum of the two dice equals `9`?",
            options = listOf(
                QuestionOption("a", "1/12 (3 out of 36)"),
                QuestionOption("b", "5/36"),
                QuestionOption("c", "1/9 (4 out of 36 outcomes)"),
                QuestionOption("d", "1/6 (6 out of 36)")
            ),
            correctOptionId = "c",
            explanation = "The 4 outcomes summing to 9 are (3,6), (4,5), (5,4), and (6,3) out of 36 equally likely pairs: 4/36 = 1/9."
        ),
        QuizQuestion(
            id = "lr_a_43",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A box contains 4 working microchips and 2 defective microchips. If 2 microchips are drawn at random WITHOUT replacement, what is the probability that BOTH are working?",
            options = listOf(
                QuestionOption("a", "8/15"),
                QuestionOption("b", "2/5 (or 6/15)"),
                QuestionOption("c", "4/9"),
                QuestionOption("d", "1/3")
            ),
            correctOptionId = "b",
            explanation = "(4/6) * (3/5) = 12/30 = 2/5 (or (4 choose 2) / (6 choose 2) = 6 / 15 = 2/5)."
        ),
        QuizQuestion(
            id = "lr_a_44",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Server A handles 60% of requests with a 1% error rate, and Server B handles the remaining 40% of requests with a 2% error rate. What percentage of ALL requests result in an error?",
            options = listOf(
                QuestionOption("a", "1.4%"),
                QuestionOption("b", "1.5%"),
                QuestionOption("c", "3.0%"),
                QuestionOption("d", "1.2%")
            ),
            correctOptionId = "a",
            explanation = "By the Law of Total Probability: 0.60 * 1% + 0.40 * 2% = 0.6% + 0.8% = 1.4%."
        ),
        QuizQuestion(
            id = "lr_a_45",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Using the same servers (Server A: 60% traffic, 1% error; Server B: 40% traffic, 2% error), given that a request resulted in an error, what is the probability (by Bayes' Theorem) that it was handled by Server B?",
            options = listOf(
                QuestionOption("a", "3/7 (approx. 42.9%)"),
                QuestionOption("b", "2/5 (40%)"),
                QuestionOption("c", "2/3 (66.7%)"),
                QuestionOption("d", "4/7 (approx. 57.1%)")
            ),
            correctOptionId = "d",
            explanation = "P(B | Error) = (0.40 * 0.02) / (0.60 * 0.01 + 0.40 * 0.02) = 0.008 / 0.014 = 8 / 14 = 4/7."
        ),
        QuizQuestion(
            id = "lr_a_46",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Three independent automated checks have probabilities `1/2`, `1/3`, and `1/4` of catching a subtle formatting glitch. What is the probability that AT LEAST ONE of the three checks catches it?",
            options = listOf(
                QuestionOption("a", "23/24"),
                QuestionOption("b", "5/6"),
                QuestionOption("c", "3/4"),
                QuestionOption("d", "1/24")
            ),
            correctOptionId = "c",
            explanation = "P(none catch it) = (1 - 1/2) * (1 - 1/3) * (1 - 1/4) = (1/2) * (2/3) * (3/4) = 1/4. Therefore P(at least one) = 1 - 1/4 = 3/4."
        ),
        QuizQuestion(
            id = "lr_a_47",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a logic puzzle on the Island of Knights (who always tell the truth) and Knaves (who always lie), you meet two inhabitants, A and B. A says: 'At least one of us is a Knave.' What are A and B?",
            options = listOf(
                QuestionOption("a", "A is a Knave and B is a Knight"),
                QuestionOption("b", "A is a Knight and B is a Knave"),
                QuestionOption("c", "Both A and B are Knights"),
                QuestionOption("d", "Both A and B are Knaves")
            ),
            correctOptionId = "b",
            explanation = "If A were a Knave, then 'At least one of us is a Knave' would be true—contradicting that Knaves always lie! Thus A must be a Knight, making A's statement true, so B must be a Knave."
        ),
        QuizQuestion(
            id = "lr_a_48",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "On the Island of Knights and Knaves, inhabitant X says: 'Both of us are Knights,' and inhabitant Y says: 'X is lying.' What are X and Y?",
            options = listOf(
                QuestionOption("a", "X is a Knave and Y is a Knight"),
                QuestionOption("b", "Both X and Y are Knights"),
                QuestionOption("c", "Both X and Y are Knaves"),
                QuestionOption("d", "X is a Knight and Y is a Knave")
            ),
            correctOptionId = "a",
            explanation = "Since X and Y contradict each other, one is a Knight and one is a Knave. Therefore 'Both of us are Knights' is false, making X a Knave and Y a Knight."
        ),
        QuizQuestion(
            id = "lr_a_49",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Six colleagues (A, B, C, D, E, F) sit in a row of 6 seats numbered 1 (leftmost) to 6 (rightmost). C is in Seat 1. B is in Seat 3. F sits immediately between C and B. A sits immediately between D and E. Which seat is A in?",
            options = listOf(
                QuestionOption("a", "Seat 4"),
                QuestionOption("b", "Seat 2"),
                QuestionOption("c", "Seat 6"),
                QuestionOption("d", "Seat 5")
            ),
            correctOptionId = "d",
            explanation = "C is at 1, B is at 3, and F is between them at 2. That leaves Seats 4, 5, and 6 for D, A, and E; since A sits immediately between D and E, A must be in the middle at Seat 5!"
        ),
        QuizQuestion(
            id = "lr_a_50",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Five tasks (J, K, L, M, N) run one per day Monday through Friday. L runs on Wednesday. M runs immediately before K (on two consecutive days). J runs on Monday. On which day does N run?",
            options = listOf(
                QuestionOption("a", "Friday"),
                QuestionOption("b", "Wednesday"),
                QuestionOption("c", "Tuesday"),
                QuestionOption("d", "Thursday")
            ),
            correctOptionId = "c",
            explanation = "J is Monday and L is Wednesday. Since M and K require two consecutive days, they must occupy Thursday and Friday (M on Thursday, K on Friday), leaving Tuesday for N."
        ),
        QuizQuestion(
            id = "lr_a_51",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Six servers (S1, S2, S3, S4, S5, S6) are arranged in a circle facing the center. S1 is directly opposite S4. S2 is to the immediate right of S1. S5 is directly opposite S2. S3 is to the immediate left of S4. Which server is directly opposite S3?",
            options = listOf(
                QuestionOption("a", "S5"),
                QuestionOption("b", "S6"),
                QuestionOption("c", "S1"),
                QuestionOption("d", "S2")
            ),
            correctOptionId = "b",
            explanation = "Since (S1, S4) are opposite and (S2, S5) are opposite, the remaining pair (S3, S6) must be directly opposite each other."
        ),
        QuizQuestion(
            id = "lr_a_52",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the remainder when `2^10` (`1,024`) is divided by `7`?",
            options = listOf(
                QuestionOption("a", "2"),
                QuestionOption("b", "1"),
                QuestionOption("c", "4"),
                QuestionOption("d", "3")
            ),
            correctOptionId = "a",
            explanation = "Since 2^3 = 8 ≡ 1 (mod 7), we have 2^10 = (2^3)^3 * 2^1 ≡ 1^3 * 2 = 2 (mod 7) (indeed, 1024 = 7 * 146 + 2)."
        ),
        QuizQuestion(
            id = "lr_a_53",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the units digit (last digit) of `3^47`?",
            options = listOf(
                QuestionOption("a", "3"),
                QuestionOption("b", "9"),
                QuestionOption("c", "1"),
                QuestionOption("d", "7")
            ),
            correctOptionId = "d",
            explanation = "Powers of 3 have a 4-cycle of units digits: 3^1=3, 3^2=9, 3^3=7, 3^4=1. Since 47 mod 4 = 3, the units digit of 3^47 matches 3^3 -> 7."
        ),
        QuizQuestion(
            id = "lr_a_54",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many positive integers from `1` to `100` inclusive are divisible by `3` OR `5`?",
            options = listOf(
                QuestionOption("a", "46"),
                QuestionOption("b", "50"),
                QuestionOption("c", "47"),
                QuestionOption("d", "53")
            ),
            correctOptionId = "c",
            explanation = "By Inclusion-Exclusion: floor(100/3) + floor(100/5) - floor(100/15) = 33 + 20 - 6 = 47."
        ),
        QuizQuestion(
            id = "lr_a_55",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many positive divisors (factors) does the number `72` have?",
            options = listOf(
                QuestionOption("a", "14"),
                QuestionOption("b", "12"),
                QuestionOption("c", "10"),
                QuestionOption("d", "8")
            ),
            correctOptionId = "b",
            explanation = "Prime factorization: 72 = 2^3 * 3^2. Number of divisors = (3 + 1) * (2 + 1) = 4 * 3 = 12 (namely 1, 2, 3, 4, 6, 8, 9, 12, 18, 24, 36, 72)."
        ),
        QuizQuestion(
            id = "lr_a_56",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In how many trailing zeros does `25!` (`1 * 2 * 3 * ... * 25`) end when written in base 10?",
            options = listOf(
                QuestionOption("a", "6 trailing zeros"),
                QuestionOption("b", "5 trailing zeros"),
                QuestionOption("c", "4 trailing zeros"),
                QuestionOption("d", "7 trailing zeros")
            ),
            correctOptionId = "a",
            explanation = "By Legendre's formula, count factors of 5: floor(25/5) + floor(25/25) = 5 + 1 = 6 trailing zeros."
        ),
        QuizQuestion(
            id = "lr_a_57",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A bacteria culture doubles in population every 3 hours. If a dish becomes completely full at hour 24, at what hour was the dish exactly ONE-QUARTER (`1/4`) full?",
            options = listOf(
                QuestionOption("a", "Hour 6"),
                QuestionOption("b", "Hour 12"),
                QuestionOption("c", "Hour 21"),
                QuestionOption("d", "Hour 18")
            ),
            correctOptionId = "d",
            explanation = "Working backward from full at hour 24: one doubling period earlier (hour 21) it was 1/2 full; two doubling periods earlier (hour 18) it was 1/4 full."
        ),
        QuizQuestion(
            id = "lr_a_58",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A snail climbs a 10-meter slippery pole. Each day it climbs up 3 meters, and each night it slips down 2 meters. Starting at the bottom on the morning of Day 1, on which day does the snail reach the top of the 10-meter pole?",
            options = listOf(
                QuestionOption("a", "Day 7"),
                QuestionOption("b", "Day 9"),
                QuestionOption("c", "Day 8 (NOT Day 10!)"),
                QuestionOption("d", "Day 10")
            ),
            correctOptionId = "c",
            explanation = "In the first 7 days and nights, the snail nets 7 * (3 - 2) = 7 meters. On the morning of Day 8, it climbs +3 meters from 7m to 10m and reaches the top before slipping!"
        )
    )

    private fun appliedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "lr_a_59",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "You have two sand hourglasses: one measures exactly `7 minutes` and the other measures exactly `4 minutes`. How can you measure an exact `9-minute` interval?",
            options = listOf(
                QuestionOption("a", "It is impossible to measure 9 minutes with 4 and 7"),
                QuestionOption("b", "Start both at t=0; flip the 4-min when it runs out at t=4; flip the 7-min when it runs out at t=7; when the 4-min finishes at t=8 (1 min of sand now in the 7-min), flip the 7-min back to run for that 1 extra minute until t=9!"),
                QuestionOption("c", "Run the 4-minute hourglass twice (which gives 8 minutes)"),
                QuestionOption("d", "Run the 7-minute hourglass twice (which gives 14 minutes)")
            ),
            correctOptionId = "b",
            explanation = "At t=7 the 7-min flips; at t=8 the 4-min finishes its second run, meaning the 7-min has accumulated exactly 1 minute of sand in its bottom bulb. Flipping the 7-min at t=8 measures 8 + 1 = 9 minutes."
        ),
        QuizQuestion(
            id = "lr_a_60",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "You have a `5-liter` jug, a `3-liter` jug, and an unlimited water tap. How do you measure exactly `4 liters` in the 5-liter jug?",
            options = listOf(
                QuestionOption("a", "Fill the 5L jug, pour into the 3L jug (leaving 2L in 5L); empty the 3L jug, pour the 2L into the 3L jug; refill the 5L jug and top off the remaining 1L space in the 3L jug, leaving 5 - 1 = 4L in the 5L jug!"),
                QuestionOption("b", "Fill the 3L jug and add half of the 5L jug by eye"),
                QuestionOption("c", "Pour the 3L jug into the 5L jug once"),
                QuestionOption("d", "It requires a 1-liter jug")
            ),
            correctOptionId = "a",
            explanation = "5 - 3 = 2L; transfer 2L to the 3L jug (leaving 1L empty capacity in the 3L jug); fill 5L and pour 1L into 3L -> 4L remains in the 5L jug."
        ),
        QuizQuestion(
            id = "lr_a_61",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "You have `9` identical-looking coins, one of which is counterfeit and slightly HEAVIER than the other 8. Using a two-pan balance scale without weights, what is the minimum number of weighings needed to guaranteedly identify the heavy coin?",
            options = listOf(
                QuestionOption("a", "3 weighings"),
                QuestionOption("b", "4 weighings"),
                QuestionOption("c", "1 weighing"),
                QuestionOption("d", "2 weighings (weigh 3 vs 3 first, then 1 vs 1 from the heavier group of 3)")
            ),
            correctOptionId = "d",
            explanation = "Each balance weighing has 3 outcomes (left heavier, right heavier, balanced), so `k` weighings distinguish up to `3^k` coins: for 9 coins, `log3(9) = 2` weighings."
        ),
        QuizQuestion(
            id = "lr_a_62",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Consider the Wason Selection Task: Four cards lie on a table showing `A`, `K`, `4`, and `7`. Each card has a letter on one side and a number on the other. Which TWO cards must you turn over to test the rule: 'If a card has a vowel on one side, then it has an even number on the other side'?",
            options = listOf(
                QuestionOption("a", "`K` and `4`"),
                QuestionOption("b", "`A`, `4`, and `7`"),
                QuestionOption("c", "`A` and `7` (NOT `A` and `4`!)"),
                QuestionOption("d", "`A` and `4`")
            ),
            correctOptionId = "c",
            explanation = "To falsify `Vowel -> Even`, you must check for `Vowel AND Odd`: turn `A` (vowel) to verify its number is even, and turn `7` (odd, `~Q`) to verify its letter is NOT a vowel (`~P` by Modus Tollens). Turning `4` cannot falsify the rule because consonants are allowed to have even numbers!"
        ),
        QuizQuestion(
            id = "lr_a_63",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Statement: 'Only authenticated users can access the dashboard.' Which of the following is logically equivalent (`->`) to this statement?",
            options = listOf(
                QuestionOption("a", "Every user is authenticated"),
                QuestionOption("b", "If a user can access the dashboard, then the user is authenticated (`Access -> Authenticated`)"),
                QuestionOption("c", "If a user is authenticated, then the user can access the dashboard (`Authenticated -> Access`)"),
                QuestionOption("d", "No authenticated user can access the dashboard")
            ),
            correctOptionId = "b",
            explanation = "'Only B can A' means `A -> B` (being B is a necessary condition for A, though an authenticated user might still need other permissions)."
        ),
        QuizQuestion(
            id = "lr_a_64",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In propositional logic, what is the `Inverse` of `P -> Q`, and which statement IS logically equivalent to the Inverse?",
            options = listOf(
                QuestionOption("a", "The Inverse is `~P -> ~Q`, which is logically equivalent to the `Converse (Q -> P)` (and NOT equivalent to `P -> Q`!)"),
                QuestionOption("b", "The Inverse is `~Q -> ~P`, which is equivalent to `P -> Q`"),
                QuestionOption("c", "The Inverse is `P AND ~Q`"),
                QuestionOption("d", "The Inverse is always False")
            ),
            correctOptionId = "a",
            explanation = "`P -> Q` is equivalent to its Contrapositive `~Q -> ~P`; the Converse `Q -> P` is equivalent to the Inverse `~P -> ~Q`."
        ),
        QuizQuestion(
            id = "lr_a_65",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A rectangular grid has `3` horizontal roads and `4` vertical roads (forming a `2 x 3` grid of city blocks from the bottom-left corner `(0,0)` to the top-right corner `(3,2)`). How many shortest paths along the grid lines lead from `(0,0)` to `(3,2)` moving only Right and Up?",
            options = listOf(
                QuestionOption("a", "6 paths"),
                QuestionOption("b", "12 paths"),
                QuestionOption("c", "15 paths"),
                QuestionOption("d", "10 paths (`(3 + 2) choose 2 = 5 choose 2`)")
            ),
            correctOptionId = "d",
            explanation = "Every shortest path consists of 3 Right steps and 2 Up steps in some order; choosing which 2 of the 5 steps are Up gives (5 choose 2) = 10 paths."
        ),
        QuizQuestion(
            id = "lr_a_66",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a knockout (single-elimination) tournament with `64` players where every match has 1 winner and 1 eliminated loser (no ties), how many total matches must be played to determine the single champion?",
            options = listOf(
                QuestionOption("a", "32 matches"),
                QuestionOption("b", "127 matches"),
                QuestionOption("c", "63 matches (each match eliminates exactly 1 player, and 63 of the 64 players must be eliminated!)"),
                QuestionOption("d", "64 matches")
            ),
            correctOptionId = "c",
            explanation = "By the invariant method, every match eliminates 1 player; to leave 1 champion from `N` players requires `N - 1` matches regardless of bracket byes (`64 - 1 = 63`)."
        ),
        QuizQuestion(
            id = "lr_a_67",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If `x + 1/x = 4`, what is the value of `x^2 + 1/x^2`?",
            options = listOf(
                QuestionOption("a", "18"),
                QuestionOption("b", "14"),
                QuestionOption("c", "16"),
                QuestionOption("d", "12")
            ),
            correctOptionId = "b",
            explanation = "Squaring both sides: (x + 1/x)^2 = x^2 + 2 + 1/x^2 = 16 => x^2 + 1/x^2 = 16 - 2 = 14."
        ),
        QuizQuestion(
            id = "lr_a_68",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If `a : b = 2 : 3` and `b : c = 4 : 5`, what is the combined ratio `a : b : c`?",
            options = listOf(
                QuestionOption("a", "8 : 12 : 15"),
                QuestionOption("b", "2 : 4 : 5"),
                QuestionOption("c", "6 : 12 : 15"),
                QuestionOption("d", "8 : 10 : 15")
            ),
            correctOptionId = "a",
            explanation = "Match the common term `b` to LCM(3, 4) = 12: `a : b = 8 : 12` and `b : c = 12 : 15`, giving `8 : 12 : 15`."
        ),
        QuizQuestion(
            id = "lr_a_69",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Three traffic lights blink every `12`, `18`, and `24` seconds respectively. If they all blink together at `10:00:00 AM`, after how many seconds will all three next blink simultaneously?",
            options = listOf(
                QuestionOption("a", "36 seconds"),
                QuestionOption("b", "48 seconds"),
                QuestionOption("c", "144 seconds"),
                QuestionOption("d", "72 seconds (at `10:01:12 AM`)")
            ),
            correctOptionId = "d",
            explanation = "LCM(12, 18, 24) = 72 seconds."
        ),
        QuizQuestion(
            id = "lr_a_70",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Find the greatest common length of square tiles that can exactly tile a rectangular server room floor measuring `54 meters` by `90 meters` without cutting any tiles.",
            options = listOf(
                QuestionOption("a", "6 meters"),
                QuestionOption("b", "27 meters"),
                QuestionOption("c", "18 meters (`GCD(54, 90) = 18`)"),
                QuestionOption("d", "9 meters")
            ),
            correctOptionId = "c",
            explanation = "The largest square tile side length that divides both 54 and 90 evenly is GCD(54, 90) = 18 meters."
        ),
        QuizQuestion(
            id = "lr_a_71",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A password consists of 2 uppercase English letters (`A–Z`, 26 choices each) followed by 3 digits (`0–9`, 10 choices each), where repetition of letters and digits IS allowed. How many total passwords can be formed?",
            options = listOf(
                QuestionOption("a", "468,000"),
                QuestionOption("b", "676,000 (`26^2 * 10^3`)"),
                QuestionOption("c", "650,000"),
                QuestionOption("d", "260,000")
            ),
            correctOptionId = "b",
            explanation = "26 * 26 * 10 * 10 * 10 = 676 * 1000 = 676,000."
        ),
        QuizQuestion(
            id = "lr_a_72",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many 4-digit numbers can be formed using the digits `{0, 1, 2, 3, 4, 5}` WITHOUT repeating any digit (note: the first digit of a 4-digit number cannot be `0`)?",
            options = listOf(
                QuestionOption("a", "300"),
                QuestionOption("b", "360"),
                QuestionOption("c", "240"),
                QuestionOption("d", "120")
            ),
            correctOptionId = "a",
            explanation = "First digit has 5 choices (`1–5`), second has 5 remaining choices (including `0`), third has 4, fourth has 3: 5 * 5 * 4 * 3 = 300."
        ),
        QuizQuestion(
            id = "lr_a_73",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Using the same digits `{0, 1, 2, 3, 4, 5}` without repetition, how many of those 4-digit numbers are divisible by `5`?",
            options = listOf(
                QuestionOption("a", "120"),
                QuestionOption("b", "60"),
                QuestionOption("c", "96"),
                QuestionOption("d", "108")
            ),
            correctOptionId = "d",
            explanation = "Case 1 (ends in `0`): 5 * 4 * 3 * 1 = 60. Case 2 (ends in `5`, first digit != `0`): 4 * 4 * 3 * 1 = 48. Total = 60 + 48 = 108."
        ),
        QuizQuestion(
            id = "lr_a_74",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the missing number in the alternate-prime series: `2, 5, 11, 17, 23, 31, ?` (where every odd-indexed prime number is listed: 1st, 3rd, 5th, 7th, 9th, 11th, 13th prime)?",
            options = listOf(
                QuestionOption("a", "39"),
                QuestionOption("b", "43"),
                QuestionOption("c", "41"),
                QuestionOption("d", "37")
            ),
            correctOptionId = "c",
            explanation = "The primes are 2, (3), 5, (7), 11, (13), 17, (19), 23, (29), 31, (37), 41—skipping every second prime gives 41."
        ),
        QuizQuestion(
            id = "lr_a_75",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the next term in the sequence: `2, 6, 12, 20, 30, 42, ?`",
            options = listOf(
                QuestionOption("a", "60"),
                QuestionOption("b", "56 (`7 * 8`)"),
                QuestionOption("c", "54"),
                QuestionOption("d", "52")
            ),
            correctOptionId = "b",
            explanation = "The terms are `n(n + 1)`: 1*2=2, 2*3=6, 3*4=12, 4*5=20, 5*6=30, 6*7=42, 7*8=56."
        ),
        QuizQuestion(
            id = "lr_a_76",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the next term in the sequence: `0, 7, 26, 63, 124, ?`",
            options = listOf(
                QuestionOption("a", "215 (`6^3 - 1`)"),
                QuestionOption("b", "216"),
                QuestionOption("c", "195"),
                QuestionOption("d", "214")
            ),
            correctOptionId = "a",
            explanation = "The terms follow `n^3 - 1`: 1^3-1=0, 2^3-1=7, 3^3-1=26, 4^3-1=63, 5^3-1=124, 6^3-1=215."
        ),
        QuizQuestion(
            id = "lr_a_77",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a code language, `MIND` is written as `DNIM` and `GAME` is written as `EMAG`. How is `QUIZ` written in that code?",
            options = listOf(
                QuestionOption("a", "UIQZ"),
                QuestionOption("b", "QZIU"),
                QuestionOption("c", "IZUQ"),
                QuestionOption("d", "ZIUQ")
            ),
            correctOptionId = "d",
            explanation = "Each word is reversed from right to left: QUIZ -> ZIUQ."
        ),
        QuizQuestion(
            id = "lr_a_78",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a code language where each letter is assigned its reverse alphabetical value (`A=26, B=25, ..., Z=1`), what is the sum of the values for `ACE`?",
            options = listOf(
                QuestionOption("a", "68"),
                QuestionOption("b", "9"),
                QuestionOption("c", "72 (`26 + 24 + 22`)"),
                QuestionOption("d", "70")
            ),
            correctOptionId = "c",
            explanation = "Reverse position is `27 - pos`: A(27-1=26) + C(27-3=24) + E(27-5=22) = 72."
        ),
        QuizQuestion(
            id = "lr_a_79",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a certain code, `256` means `'red sweet apple'`, `637` means `'eat sweet fruit'`, and `358` means `'red ripe fruit'`. Which digit stands for `'apple'`?",
            options = listOf(
                QuestionOption("a", "3"),
                QuestionOption("b", "2"),
                QuestionOption("c", "5"),
                QuestionOption("d", "6")
            ),
            correctOptionId = "b",
            explanation = "`6` is common to 1st and 2nd ('sweet'); `5` is common to 1st and 3rd ('red'). That leaves `2` in `256` for `'apple'`."
        ),
        QuizQuestion(
            id = "lr_a_80",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A cube of side `3 cm` is painted blue on all 6 outer faces and then sliced into `27` smaller `1 cm x 1 cm x 1 cm` unit cubes. How many of the 27 small cubes have paint on EXACTLY TWO faces?",
            options = listOf(
                QuestionOption("a", "12 cubes (the middle edge cubes on each of the 12 edges)"),
                QuestionOption("b", "8 cubes (the corners)"),
                QuestionOption("c", "6 cubes (the face centers)"),
                QuestionOption("d", "1 cube (the interior center)")
            ),
            correctOptionId = "a",
            explanation = "For an `n x n x n` painted cube (`n = 3`): 3 faces painted = 8 corners; 2 faces painted = `12 * (n - 2) = 12` edge cubes; 1 face painted = `6 * (n - 2)^2 = 6` face-center cubes; 0 faces painted = `(n - 2)^3 = 1` interior cube."
        ),
        QuizQuestion(
            id = "lr_a_81",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Using the same painted `3 x 3 x 3` cube sliced into `27` unit cubes, how many small cubes have NO paint on any face (`0` painted faces)?",
            options = listOf(
                QuestionOption("a", "0 cubes"),
                QuestionOption("b", "6 cubes"),
                QuestionOption("c", "8 cubes"),
                QuestionOption("d", "1 cube (the single cube at the very center of the 3x3x3 block)")
            ),
            correctOptionId = "d",
            explanation = "For `n = 3`, `(n - 2)^3 = (3 - 2)^3 = 1` interior cube is completely untouched by exterior paint."
        ),
        QuizQuestion(
            id = "lr_a_82",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If a `4 x 4 x 4` painted cube is sliced into `64` unit cubes, how many of the unit cubes have paint on EXACTLY ONE face?",
            options = listOf(
                QuestionOption("a", "16 cubes"),
                QuestionOption("b", "32 cubes"),
                QuestionOption("c", "24 cubes (`6 faces * (4 - 2)^2 = 6 * 4`)"),
                QuestionOption("d", "8 cubes")
            ),
            correctOptionId = "c",
            explanation = "Each of the 6 faces has an inner `(4 - 2) x (4 - 2) = 2 x 2 = 4` square of 1-face-painted cubes: `6 * 4 = 24`."
        ),
        QuizQuestion(
            id = "lr_a_83",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A father is currently 36 years old and his son is 8 years old. In how many years will the father be exactly THREE times as old as his son?",
            options = listOf(
                QuestionOption("a", "8 years"),
                QuestionOption("b", "6 years (when father is 42 and son is 14)"),
                QuestionOption("c", "4 years"),
                QuestionOption("d", "7 years")
            ),
            correctOptionId = "b",
            explanation = "36 + t = 3 * (8 + t) => 36 + t = 24 + 3t => 2t = 12 => t = 6 years."
        ),
        QuizQuestion(
            id = "lr_a_84",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When the price of a ticket was reduced by 20%, the number of tickets sold increased by 40%. What was the percentage change in total ticket revenue?",
            options = listOf(
                QuestionOption("a", "+12% increase"),
                QuestionOption("b", "+20% increase"),
                QuestionOption("c", "+8% increase"),
                QuestionOption("d", "+16% increase")
            ),
            correctOptionId = "a",
            explanation = "New revenue factor = 0.80 * 1.40 = 1.12, which is a +12% increase in total revenue."
        ),
        QuizQuestion(
            id = "lr_a_85",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A contractor hires 20 workers to finish a project in 30 days. After 15 days, they have completed `1/3` of the project. How many ADDITIONAL workers (working at the same rate) must join for the remaining 15 days to finish the remaining `2/3` on schedule?",
            options = listOf(
                QuestionOption("a", "10 additional workers"),
                QuestionOption("b", "15 additional workers"),
                QuestionOption("c", "30 additional workers"),
                QuestionOption("d", "20 additional workers (40 workers total)")
            ),
            correctOptionId = "d",
            explanation = "20 workers did 1/3 of the project in 15 days; doing the remaining 2/3 (twice as much work) in the same 15 days requires twice as many workers: 40 total, or 20 additional workers."
        ),
        QuizQuestion(
            id = "lr_a_86",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a class of 50 students, 30 play chess, 25 play badminton, and 10 play NEITHER. How many students play ONLY chess (chess but not badminton)?",
            options = listOf(
                QuestionOption("a", "10"),
                QuestionOption("b", "5"),
                QuestionOption("c", "15"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "c",
            explanation = "Students playing at least one = 50 - 10 = 40. Both = 30 + 25 - 40 = 15. Only chess = 30 - 15 = 15."
        ),
        QuizQuestion(
            id = "lr_a_87",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If `log_2(x) + log_2(8) = 7`, what is the value of `x`?",
            options = listOf(
                QuestionOption("a", "64"),
                QuestionOption("b", "16"),
                QuestionOption("c", "8"),
                QuestionOption("d", "32")
            ),
            correctOptionId = "b",
            explanation = "Since log_2(8) = 3, we have log_2(x) = 7 - 3 = 4, so x = 2^4 = 16."
        ),
        QuizQuestion(
            id = "lr_a_88",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A fair coin is flipped 4 times. What is the probability of getting EXACTLY 2 Heads and 2 Tails?",
            options = listOf(
                QuestionOption("a", "3/8 (6 out of 16 outcomes)"),
                QuestionOption("b", "1/2 (8 out of 16)"),
                QuestionOption("c", "1/4 (4 out of 16)"),
                QuestionOption("d", "5/16")
            ),
            correctOptionId = "a",
            explanation = "Number of ways to choose which 2 of the 4 flips are Heads = (4 choose 2) = 6 out of 2^4 = 16 total outcomes: 6/16 = 3/8."
        ),
        QuizQuestion(
            id = "lr_a_89",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Two cards are drawn successively WITHOUT replacement from a standard 52-card deck. What is the probability that both cards are Aces?",
            options = listOf(
                QuestionOption("a", "1/169 (`(4/52)^2`)"),
                QuestionOption("b", "1/13"),
                QuestionOption("c", "3/221"),
                QuestionOption("d", "1/221 (`(4/52) * (3/51)`)")
            ),
            correctOptionId = "d",
            explanation = "First card Ace = 4/52 = 1/13; second card Ace without replacement = 3/51 = 1/17. Product = 1 / (13 * 17) = 1/221."
        ),
        QuizQuestion(
            id = "lr_a_90",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A circular pizza is cut by `4` straight cuts that all pass through the center of the pizza. Into how many slices is the pizza divided?",
            options = listOf(
                QuestionOption("a", "16 slices"),
                QuestionOption("b", "4 slices"),
                QuestionOption("c", "8 slices"),
                QuestionOption("d", "11 slices")
            ),
            correctOptionId = "c",
            explanation = "Every straight cut through the center adds 2 opposite radii, so `n` distinct cuts through the center produce `2n = 8` slices."
        ),
        QuizQuestion(
            id = "lr_a_91",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the MAXIMUM number of pieces a circular pancake can be divided into using `4` straight cuts if the cuts do NOT have to pass through the same center point (the Lazy Caterer's sequence `n(n+1)/2 + 1`)?",
            options = listOf(
                QuestionOption("a", "16 pieces"),
                QuestionOption("b", "11 pieces"),
                QuestionOption("c", "8 pieces"),
                QuestionOption("d", "10 pieces")
            ),
            correctOptionId = "b",
            explanation = "When each new line intersects all previous lines at distinct interior points, `n` cuts produce `1 + n(n + 1)/2` pieces: for `n = 4`, `1 + 4*5/2 = 11` pieces."
        ),
        QuizQuestion(
            id = "lr_a_92",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Five runners (A, B, C, D, E) compete in a race. A finishes ahead of B and C. D finishes behind C. E finishes ahead of A. Which two runners finish in 1st and 2nd place?",
            options = listOf(
                QuestionOption("a", "E is 1st and A is 2nd"),
                QuestionOption("b", "A is 1st and E is 2nd"),
                QuestionOption("c", "E is 1st and C is 2nd"),
                QuestionOption("d", "A is 1st and C is 2nd")
            ),
            correctOptionId = "a",
            explanation = "Since E > A and A > {B, C} and C > D, E is ahead of everyone (1st) and A is ahead of B, C, and D (2nd)."
        ),
        QuizQuestion(
            id = "lr_a_93",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If `3^(x + 2) = 81`, what is the value of `2^x`?",
            options = listOf(
                QuestionOption("a", "8"),
                QuestionOption("b", "2"),
                QuestionOption("c", "16"),
                QuestionOption("d", "4")
            ),
            correctOptionId = "d",
            explanation = "81 = 3^4, so x + 2 = 4 => x = 2. Therefore 2^x = 2^2 = 4."
        ),
        QuizQuestion(
            id = "lr_a_94",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A number when divided by `899` leaves a remainder of `63`. What remainder will the same number leave when divided by `29`?",
            options = listOf(
                QuestionOption("a", "4"),
                QuestionOption("b", "10"),
                QuestionOption("c", "5"),
                QuestionOption("d", "6")
            ),
            correctOptionId = "c",
            explanation = "Since 899 = 29 * 31 is a multiple of 29, N = 899k + 63 = 29(31k) + 63. Dividing 63 by 29 gives 63 = 29 * 2 + 5, so the remainder is 5."
        ),
        QuizQuestion(
            id = "lr_a_95",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In an election between two candidates, the winner received 56% of the valid votes and won by a margin of 1,440 votes. Assuming all votes were valid, how many total votes were cast?",
            options = listOf(
                QuestionOption("a", "9,600 votes"),
                QuestionOption("b", "12,000 votes"),
                QuestionOption("c", "10,000 votes"),
                QuestionOption("d", "14,400 votes")
            ),
            correctOptionId = "b",
            explanation = "The winner got 56% and the runner-up got 44%, so the margin is 56% - 44% = 12% of total votes. 0.12 * V = 1440 => V = 12,000."
        ),
        QuizQuestion(
            id = "lr_a_96",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A clock gains 4 minutes every 24 hours. If it is set accurately at 8:00 AM on Monday, what time will this clock show when the true time is 8:00 AM on the following Thursday (72 hours later)?",
            options = listOf(
                QuestionOption("a", "8:12 AM"),
                QuestionOption("b", "8:08 AM"),
                QuestionOption("c", "8:16 AM"),
                QuestionOption("d", "7:48 AM")
            ),
            correctOptionId = "a",
            explanation = "From Monday 8:00 AM to Thursday 8:00 AM is 3 days (72 hours). Gaining 4 minutes per day, it gains 3 * 4 = 12 minutes, showing 8:12 AM."
        ),
        QuizQuestion(
            id = "lr_a_97",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many squares of ALL sizes (`1x1`, `2x2`, `3x3`, and `4x4`) exist on a standard `4 x 4` checkerboard grid?",
            options = listOf(
                QuestionOption("a", "16 squares"),
                QuestionOption("b", "20 squares"),
                QuestionOption("c", "24 squares"),
                QuestionOption("d", "30 squares (`4^2 + 3^2 + 2^2 + 1^2 = 16 + 9 + 4 + 1`)")
            ),
            correctOptionId = "d",
            explanation = "In an `n x n` grid, there are `k^2` squares of size `(n - k + 1) x (n - k + 1)`, summing to `1^2 + 2^2 + 3^2 + 4^2 = 30`."
        ),
        QuizQuestion(
            id = "lr_a_98",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "A car's odometer reads `15,951` km, which is a palindrome (reads the same forward and backward). What is the minimum number of kilometers the car must travel to display the NEXT palindrome on its odometer?",
            options = listOf(
                QuestionOption("a", "210 km"),
                QuestionOption("b", "1,010 km"),
                QuestionOption("c", "110 km (to reach `16,061`)"),
                QuestionOption("d", "100 km")
            ),
            correctOptionId = "c",
            explanation = "Since the ten-thousands and thousands digits `15` must roll over to `16` after `15,999`, the smallest palindrome greater than `15,951` is `16,061` (`16061 - 15951 = 110` km)."
        ),
        QuizQuestion(
            id = "lr_a_99",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Two candles of equal height are lit at the same time. The first candle takes `4 hours` to burn down completely, and the second takes `3 hours` to burn down completely (at steady linear rates). After how many hours of burning is the first candle exactly TWICE as tall as the second candle?",
            options = listOf(
                QuestionOption("a", "2.5 hours"),
                QuestionOption("b", "2.4 hours (2 hours 24 minutes)"),
                QuestionOption("c", "2 hours"),
                QuestionOption("d", "1.5 hours")
            ),
            correctOptionId = "b",
            explanation = "After t hours, heights are (1 - t/4) and (1 - t/3). Setting 1 - t/4 = 2 * (1 - t/3) => 1 - t/4 = 2 - 2t/3 => (2/3 - 1/4)t = 1 => (5/12)t = 1 => t = 12/5 = 2.4 hours."
        ),
        QuizQuestion(
            id = "lr_a_100",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a class, the average score of 20 boys is `80` and the average score of 30 girls is `85`. What is the combined weighted average score of all 50 students?",
            options = listOf(
                QuestionOption("a", "83"),
                QuestionOption("b", "82.5"),
                QuestionOption("c", "84"),
                QuestionOption("d", "82")
            ),
            correctOptionId = "a",
            explanation = "(20 * 80 + 30 * 85) / 50 = (1600 + 2550) / 50 = 4150 / 50 = 83."
        )
    )

    private fun advancedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "lr_adv_16",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the classic `Monty Hall Problem`, you pick Door 1 out of 3 doors (1 hides a car, 2 hide goats). The host—who knows where the car is and ALWAYS opens a goat door you didn't pick—opens Door 3 to reveal a goat. If you switch your choice to Door 2, what is your probability of winning the car?",
            options = listOf(
                QuestionOption("a", "2/3 (switching doubles your win probability from 1/3 to 2/3!)"),
                QuestionOption("b", "1/2"),
                QuestionOption("c", "1/3"),
                QuestionOption("d", "3/4")
            ),
            correctOptionId = "a",
            explanation = "Your initial pick (Door 1) had a 1/3 chance of being the car and a 2/3 chance that the car was behind one of {Door 2, Door 3}. Because the host intentionally filters out a goat from {Door 2, Door 3}, the entire 2/3 probability concentrates onto the remaining unopened door (Door 2)!"
        ),
        QuizQuestion(
            id = "lr_adv_17",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A diagnostic test for a rare hardware defect (which affects `1%` of devices, so prior prevalence = `0.01`) has a `99%` true positive rate (sensitivity) and a `1%` false positive rate (`99%` specificity). If a randomly selected device tests POSITIVE, what is the approximate probability (by Bayes' Theorem) that it actually has the defect?",
            options = listOf(
                QuestionOption("a", "99%"),
                QuestionOption("b", "98%"),
                QuestionOption("c", "1%"),
                QuestionOption("d", "50% (`1/2`, because in 10,000 devices, ~99 infected devices test positive AND ~99 of the 9,900 healthy devices also test positive!)")
            ),
            correctOptionId = "d",
            explanation = "Base-rate fallacy! P(Defect | +) = (0.01 * 0.99) / (0.01 * 0.99 + 0.99 * 0.01) = 0.0099 / (0.0099 + 0.0099) = 0.50 (50%)."
        ),
        QuizQuestion(
            id = "lr_adv_18",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Simpson's Paradox` in data analysis and statistics?",
            options = listOf(
                QuestionOption("a", "When a sample size of 10 has a 0% margin of error"),
                QuestionOption("b", "When two independent events have probability > 1"),
                QuestionOption("c", "A trend or comparison that appears in several separate groups of data REVERSES direction when the groups are combined into a single aggregate dataset (due to a confounding variable and unequal group sizes)!"),
                QuestionOption("d", "When the mean and median of a dataset are equal")
            ),
            correctOptionId = "c",
            explanation = "For example, Service A can have a lower error rate than Service B on BOTH fast networks and slow networks individually, yet have a higher overall error rate if 90% of Service A's traffic comes from slow networks!"
        ),
        QuizQuestion(
            id = "lr_adv_19",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Survivorship Bias` (famously illustrated by Abraham Wald's analysis of returning WWII aircraft bullet holes)?",
            options = listOf(
                QuestionOption("a", "Using the median instead of the mean"),
                QuestionOption("b", "Drawing flawed conclusions by analyzing only the 'survivors' that passed a selection process while overlooking the failed/missing cases (Wald recommended armoring the areas with NO bullet holes on returning planes, because planes hit there didn't return!)"),
                QuestionOption("c", "Assuming older servers are faster than newer servers"),
                QuestionOption("d", "Testing only the last element of an array")
            ),
            correctOptionId = "b",
            explanation = "Focusing only on successful companies, returning aircraft, or retained users ignores the silent denominator of those that failed for the exact attribute being studied."
        ),
        QuizQuestion(
            id = "lr_adv_20",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Four people need to cross a narrow bridge at night with a single flashlight. At most 2 people can cross at a time, and any crossing requires the flashlight (walking at the slower person's speed). Their individual crossing times are `1 min`, `2 min`, `5 min`, and `10 min`. What is the MINIMUM total time to get all 4 across?",
            options = listOf(
                QuestionOption("a", "17 minutes (NOT 19 minutes! Send `1 & 2` across [2m], `1` returns [1m], `5 & 10` cross together [10m], `2` returns [2m], `1 & 2` cross [2m]: `2 + 1 + 10 + 2 + 2 = 17`)"),
                QuestionOption("b", "19 minutes (`1` shuttles everyone: `10 + 1 + 5 + 1 + 2 = 19`)"),
                QuestionOption("c", "15 minutes"),
                QuestionOption("d", "18 minutes")
            ),
            correctOptionId = "a",
            explanation = "The key insight is to pair the two slowest people (`5` and `10`) together in the same crossing so the `5`-minute penalty is absorbed inside the `10`-minute crossing, while `1` and `2` stationed on opposite sides handle the fast flashlight returns!"
        ),
        QuizQuestion(
            id = "lr_adv_21",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "You have `8` identical-looking balls, one of which is slightly heavier. Using a two-pan balance scale, what is the minimum number of weighings required to guaranteedly find the heavier ball?",
            options = listOf(
                QuestionOption("a", "3 weighings (weighing 4 vs 4 first takes 3 weighings)"),
                QuestionOption("b", "1 weighing"),
                QuestionOption("c", "4 weighings"),
                QuestionOption("d", "2 weighings (weigh 3 vs 3 first; whether they balance or tilt, at most 3 candidates remain for the 2nd weighing of 1 vs 1)")
            ),
            correctOptionId = "d",
            explanation = "Information theory: each weighing has 3 outcomes (`<, =, >`), so 2 weighings distinguish up to `3^2 = 9 >= 8` balls by weighing `3 vs 3` first."
        ),
        QuizQuestion(
            id = "lr_adv_22",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "You have `10` stacks of 10 coins each. Nine stacks contain genuine `10-gram` coins, and ONE entire stack contains counterfeit `11-gram` coins. Using a digital scale that displays exact weight in grams, what is the minimum number of weighings needed to identify the counterfeit stack?",
            options = listOf(
                QuestionOption("a", "4 weighings (binary search)"),
                QuestionOption("b", "10 weighings"),
                QuestionOption("c", "1 single weighing! (Take 1 coin from Stack 1, 2 coins from Stack 2, ..., 10 coins from Stack 10 and weigh all 55 coins together; the excess weight `W - 550` grams directly equals the counterfeit stack number!)"),
                QuestionOption("d", "2 weighings")
            ),
            correctOptionId = "c",
            explanation = "With 1 + 2 + ... + 10 = 55 coins, if all were 10g the weight would be 550g; if Stack `k` has 11g coins, it adds `+k` grams, uniquely identifying `k = W - 550` in 1 weighing!"
        ),
        QuizQuestion(
            id = "lr_adv_23",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Derangement` problem (Hat-Check problem), 4 letters (`L1, L2, L3, L4`) are placed randomly into 4 addressed envelopes (`E1, E2, E3, E4`), one per envelope. In how many of the `4! = 24` permutations does NO letter end up in its own matching envelope (`!4`)?",
            options = listOf(
                QuestionOption("a", "12 derangements"),
                QuestionOption("b", "9 derangements (out of 24)"),
                QuestionOption("c", "8 derangements"),
                QuestionOption("d", "6 derangements")
            ),
            correctOptionId = "b",
            explanation = "The subfactorial formula `!n = n! * (1 - 1/1! + 1/2! - 1/3! + 1/4!)` gives `24 * (1 - 1 + 1/2 - 1/6 + 1/24) = 12 - 4 + 1 = 9` derangements."
        ),
        QuizQuestion(
            id = "lr_adv_24",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the number of derangements `!3` of 3 items (permutations of `(1, 2, 3)` where no item stays in its original position), and what is the probability of a random 3-element permutation being a derangement?",
            options = listOf(
                QuestionOption("a", "2 derangements (`(2,3,1)` and `(3,1,2)`) out of `3! = 6`, so probability = `2/6 = 1/3`"),
                QuestionOption("b", "3 derangements (`1/2`)"),
                QuestionOption("c", "1 derangement (`1/6`)"),
                QuestionOption("d", "4 derangements (`2/3`)")
            ),
            correctOptionId = "a",
            explanation = "Only the two 3-cycles `(2, 3, 1)` and `(3, 1, 2)` have zero fixed points out of 6 permutations."
        ),
        QuizQuestion(
            id = "lr_adv_25",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "By the `Stars and Bars` theorem in combinatorics, in how many ways can `10` identical CPU tasks be distributed among `4` distinct worker nodes if a worker node is allowed to receive `0` tasks?",
            options = listOf(
                QuestionOption("a", "84 ways (`9 choose 3`)"),
                QuestionOption("b", "1,000 ways"),
                QuestionOption("c", "210 ways"),
                QuestionOption("d", "286 ways (`(10 + 4 - 1) choose (4 - 1) = 13 choose 3`)")
            ),
            correctOptionId = "d",
            explanation = "Non-negative integer solutions to `x1 + x2 + x3 + x4 = 10` is `(n + k - 1) choose (k - 1) = (10 + 4 - 1) choose 3 = (13 * 12 * 11) / 6 = 286`."
        ),
        QuizQuestion(
            id = "lr_adv_26",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using `Stars and Bars`, in how many ways can `10` identical CPU tasks be distributed among `4` distinct worker nodes if EVERY worker node must receive AT LEAST `1` task (`x_i >= 1`)?",
            options = listOf(
                QuestionOption("a", "120 ways"),
                QuestionOption("b", "64 ways"),
                QuestionOption("c", "84 ways (`(10 - 1) choose (4 - 1) = 9 choose 3`)"),
                QuestionOption("d", "286 ways")
            ),
            correctOptionId = "c",
            explanation = "Give 1 task to each of the 4 nodes first (leaving 6 tasks), then `(6 + 4 - 1) choose (4 - 1) = 9 choose 3 = (9 * 8 * 7) / 6 = 84`."
        ),
        QuizQuestion(
            id = "lr_adv_27",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a survey of `100` software engineers on three languages—Python (`P`), Java (`J`), and SQL (`S`): `|P| = 60`, `|J| = 50`, `|S| = 50`, `|P ∩ J| = 30`, `|J ∩ S| = 25`, `|P ∩ S| = 25`, and `|P ∩ J ∩ S| = 15`. How many engineers use AT LEAST ONE of the three languages?",
            options = listOf(
                QuestionOption("a", "90 engineers"),
                QuestionOption("b", "95 engineers (and 5 use none of the three)"),
                QuestionOption("c", "80 engineers"),
                QuestionOption("d", "100 engineers")
            ),
            correctOptionId = "b",
            explanation = "By 3-set Inclusion-Exclusion: `|P U J U S| = (60 + 50 + 50) - (30 + 25 + 25) + 15 = 160 - 80 + 15 = 95`."
        ),
        QuizQuestion(
            id = "lr_adv_28",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the exact same survey (`|P|=60, |J|=50, |S|=50, |P∩J|=30, |J∩S|=25, |P∩S|=25, |P∩J∩S|=15`), how many engineers use ONLY Python (Python, but neither Java nor SQL)?",
            options = listOf(
                QuestionOption("a", "20 engineers"),
                QuestionOption("b", "15 engineers"),
                QuestionOption("c", "30 engineers"),
                QuestionOption("d", "25 engineers")
            ),
            correctOptionId = "a",
            explanation = "`|P only| = |P| - |P ∩ J| - |P ∩ S| + |P ∩ J ∩ S| = 60 - 30 - 25 + 15 = 20`."
        ),
        QuizQuestion(
            id = "lr_adv_29",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the `Mutilated Chessboard` invariant proof? Suppose two opposite corner squares (`a1` and `h8`) are removed from a standard `8 x 8` chessboard, leaving `62` squares. Can those `62` squares be completely tiled by `31` non-overlapping `2 x 1` dominoes?",
            options = listOf(
                QuestionOption("a", "Yes, because 62 is divisible by 2"),
                QuestionOption("b", "Yes, if you rotate the dominoes diagonally"),
                QuestionOption("c", "Only if 4 corners are removed"),
                QuestionOption("d", "No, NEVER! Because opposite corners of a chessboard have the SAME color, removing them leaves `32` squares of one color and `30` of the other, whereas every `2 x 1` domino always covers `1` white and `1` black square!")
            ),
            correctOptionId = "d",
            explanation = "This is the classic parity/coloring invariant: 31 dominoes must cover exactly 31 light and 31 dark squares, which cannot match 32 and 30."
        ),
        QuizQuestion(
            id = "lr_adv_30",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Two players (Alice and Bob) play a game with a pile of `21` tokens. On each turn, a player must remove `1`, `2`, or `3` tokens from the pile. The player who takes the LAST token wins. If Alice moves first and both play optimally, how does Alice guarantee a win?",
            options = listOf(
                QuestionOption("a", "Bob can always force a win if he plays second"),
                QuestionOption("b", "Alice takes `2` tokens on her first move"),
                QuestionOption("c", "Alice takes `1` token on her first move (leaving `20`, a multiple of `4`), and thereafter whenever Bob takes `k` tokens (`1, 2, or 3`), Alice takes `4 - k` tokens to always leave a multiple of `4` (`16, 12, 8, 4, 0`)!"),
                QuestionOption("d", "Alice takes `3` tokens on her first move")
            ),
            correctOptionId = "c",
            explanation = "In subtraction games with moves `{1, 2, ..., m}`, multiples of `m + 1` (`4, 8, 12, 16, 20`) are losing positions (`P-positions`) for the player whose turn it is. Since `21 mod 4 = 1`, Alice takes `1` to leave `20`."
        ),
        QuizQuestion(
            id = "lr_adv_31",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What if the pile starts with `20` tokens under the exact same rules (each turn remove `1`, `2`, or `3` tokens; last token wins)? Who has a guaranteed winning strategy?",
            options = listOf(
                QuestionOption("a", "The game always ends in a draw"),
                QuestionOption("b", "The SECOND player (Bob)! Because `20` is already divisible by `4`, whatever `k in {1, 2, 3}` Alice takes, Bob responds with `4 - k` to maintain multiples of `4` down to `0`!"),
                QuestionOption("c", "The first player (Alice) by taking 3 tokens"),
                QuestionOption("d", "The first player (Alice) by taking 2 tokens")
            ),
            correctOptionId = "b",
            explanation = "Starting on a multiple of `m + 1 = 4` (`20 mod 4 == 0`), the second player can always pair the first player's move `k` with `4 - k`."
        ),
        QuizQuestion(
            id = "lr_adv_32",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Consider a fair coin flipped repeatedly until the first `Head` appears. What is the expected number of flips `E[X]` required to get the first `Head`?",
            options = listOf(
                QuestionOption("a", "2 flips (`1 / p = 1 / (1/2) = 2`)"),
                QuestionOption("b", "1 flip"),
                QuestionOption("c", "1.5 flips"),
                QuestionOption("d", "4 flips")
            ),
            correctOptionId = "a",
            explanation = "For a geometric distribution with success probability `p`, `E[X] = 1 + (1 - p) * E[X] => E[X] = 1 / p = 2`."
        ),
        QuizQuestion(
            id = "lr_adv_33",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the expected number of rolls of a fair 6-sided die required to see the number `6` for the first time?",
            options = listOf(
                QuestionOption("a", "3.5 rolls"),
                QuestionOption("b", "3 rolls"),
                QuestionOption("c", "5 rolls"),
                QuestionOption("d", "6 rolls (`1 / (1/6) = 6`)")
            ),
            correctOptionId = "d",
            explanation = "Each roll has probability `p = 1/6` of showing `6`, so the geometric expectation is `1 / p = 6` rolls."
        ),
        QuizQuestion(
            id = "lr_adv_34",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "By `Linearity of Expectation`, if 100 people at a conference each toss their name badge into a bin and each person draws 1 badge uniformly at random, what is the expected number of people who draw their OWN badge?",
            options = listOf(
                QuestionOption("a", "10 people"),
                QuestionOption("b", "It depends on `n` and grows with `n`"),
                QuestionOption("c", "Exactly `1` person! (Each of the 100 people has probability `1/100` of drawing their own badge, and by linearity of expectation `E[X_1 + ... + X_n] = n * (1/n) = 1` regardless of `n`!)"),
                QuestionOption("d", "0.5 people")
            ),
            correctOptionId = "c",
            explanation = "Linearity of expectation holds even when indicator random variables `X_i` are dependent! Each `E[X_i] = 1/n`, so `sum_{i=1..n} E[X_i] = n * (1/n) = 1` for any `n >= 1`."
        ),
        QuizQuestion(
            id = "lr_adv_35",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Birthday Paradox`, approximately how many people are needed in a room so that the probability that AT LEAST TWO people share the same birthday (ignoring Feb 29, 365 equally likely days) exceeds `50%`?",
            options = listOf(
                QuestionOption("a", "50 people"),
                QuestionOption("b", "23 people (because 23 people form `(23 choose 2) = 253` pairs, and `1 - (365/365)*(364/365)*...*(343/365) ≈ 50.7%`!)"),
                QuestionOption("c", "183 people (`365 / 2`)"),
                QuestionOption("d", "100 people")
            ),
            correctOptionId = "b",
            explanation = "Because the number of pairs grows quadratically (`n(n-1)/2`), just 23 people create 253 pair comparisons, pushing collision probability past 50% (this is also the basis of the `2^(b/2)` Birthday Attack on `b`-bit cryptographic hashes!)."
        ),
        QuizQuestion(
            id = "lr_adv_36",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Two players (A and B) take turns flipping a fair coin, with A flipping first. The first player to flip `Heads` wins immediately. What is the probability that the first player (A) wins?",
            options = listOf(
                QuestionOption("a", "2/3 (`1/2 + 1/8 + 1/32 + ... = (1/2) / (1 - 1/4) = 2/3`)"),
                QuestionOption("b", "1/2"),
                QuestionOption("c", "3/4"),
                QuestionOption("d", "5/8")
            ),
            correctOptionId = "a",
            explanation = "Let `p` be A's win probability. A wins on flip 1 with prob `1/2`; if both A and B flip Tails (prob `1/4`), the game resets with A up again: `p = 1/2 + (1/4)p => (3/4)p = 1/2 => p = 2/3`."
        ),
        QuizQuestion(
            id = "lr_adv_37",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "You have two ropes. Each rope takes exactly `60 minutes` to burn from one end to the other, but they burn at NON-UNIFORM rates along their lengths (so half the length does not necessarily take 30 minutes). How can you measure exactly `45 minutes`?",
            options = listOf(
                QuestionOption("a", "Cut Rope 1 into 4 equal pieces by length"),
                QuestionOption("b", "Light Rope 1 at one end and wait until 3/4 of its length is gone"),
                QuestionOption("c", "It is impossible if the burn rate is non-uniform"),
                QuestionOption("d", "At t=0, light Rope 1 at BOTH ends and Rope 2 at ONE end; when Rope 1 finishes burning completely at exactly t=30 minutes, immediately light the OTHER end of Rope 2 (which has 30 minutes of burn left, so burning from both ends finishes in `30 / 2 = 15` more minutes, at t=45)!")
            ),
            correctOptionId = "d",
            explanation = "Lighting a 60-minute rope at both ends always burns it completely in 30 minutes regardless of rate non-uniformity; lighting the second end of Rope 2 at t=30 halves its remaining 30-minute burn time to 15 minutes (`30 + 15 = 45`)."
        ),
        QuizQuestion(
            id = "lr_adv_38",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `100 Doors (100 Lockers) Puzzle`, 100 closed doors are numbered `1` to `100`. On pass `k` (for `k = 1, 2, ..., 100`), you toggle every door whose number is a multiple of `k`. After all 100 passes, which doors remain OPEN, and how many are there?",
            options = listOf(
                QuestionOption("a", "All 25 prime-numbered doors"),
                QuestionOption("b", "Only door 1 and door 100"),
                QuestionOption("c", "The `10` perfect square doors (`1, 4, 9, 16, 25, 36, 49, 64, 81, 100`), because only perfect squares have an ODD number of positive divisors!"),
                QuestionOption("d", "All 50 even-numbered doors")
            ),
            correctOptionId = "c",
            explanation = "Door `n` is toggled once for each divisor `d` of `n`. Divisors come in distinct pairs `(d, n/d)` EXCEPT when `d = n/d` (`n = d^2`), so `n` has an odd number of divisors iff `n` is a perfect square!"
        ),
        QuizQuestion(
            id = "lr_adv_39",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Josephus Problem` with `n = 16` (`2^4`) people standing in a circle (`1` to `16`), starting at person `1`, every 2nd remaining person is eliminated (`2, 4, 6, ...`) around the circle until only 1 survivor remains. Who is the survivor?",
            options = listOf(
                QuestionOption("a", "Person `15`"),
                QuestionOption("b", "Person `1`! (Whenever `n = 2^k` is a power of 2, half the circle is eliminated on each full pass and the turn always returns to Person `1`, so Person `1` survives!)"),
                QuestionOption("c", "Person `16`"),
                QuestionOption("d", "Person `8`")
            ),
            correctOptionId = "b",
            explanation = "For general `n = 2^k + L` (where `0 <= L < 2^k`), the survivor is `J(n) = 2L + 1`. When `n = 16 = 2^4 + 0` (`L = 0`), `J(16) = 2(0) + 1 = 1`."
        ),
        QuizQuestion(
            id = "lr_adv_40",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the Josephus formula `J(2^k + L) = 2L + 1` (for `0 <= L < 2^k`), who survives when `n = 100` people stand in a circle and every 2nd person (`2, 4, 6, ...`) is eliminated?",
            options = listOf(
                QuestionOption("a", "Person `73` (`100 = 64 + 36`, so `L = 36` and `2 * 36 + 1 = 73`)"),
                QuestionOption("b", "Person `50`"),
                QuestionOption("c", "Person `99`"),
                QuestionOption("d", "Person `37`")
            ),
            correctOptionId = "a",
            explanation = "The largest power of 2 `<= 100` is `64`, leaving `L = 100 - 64 = 36`. After 36 eliminations (`2, 4, ..., 72`), 64 people remain with the turn at Person `73`, who then survives!"
        ),
        QuizQuestion(
            id = "lr_adv_41",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the `4th Catalan Number` `C_4`, which counts the number of valid combinations of `n = 4` pairs of balanced parentheses (and the number of structurally distinct Binary Search Trees with `4` keys)?",
            options = listOf(
                QuestionOption("a", "12"),
                QuestionOption("b", "16"),
                QuestionOption("c", "24"),
                QuestionOption("d", "14 (`(1 / (4 + 1)) * (8 choose 4) = (1/5) * 70 = 14`)")
            ),
            correctOptionId = "d",
            explanation = "The `n`-th Catalan number is `C_n = (2n choose n) / (n + 1)`: `C_0=1, C_1=1, C_2=2, C_3=5, C_4 = 70 / 5 = 14`."
        ),
        QuizQuestion(
            id = "lr_adv_42",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How many structurally distinct Binary Search Trees can be formed using `3` distinct keys `{1, 2, 3}`?",
            options = listOf(
                QuestionOption("a", "3"),
                QuestionOption("b", "4"),
                QuestionOption("c", "5 (`C_3 = (6 choose 3) / 4 = 20 / 4 = 5`)"),
                QuestionOption("d", "6 (`3!`)")
            ),
            correctOptionId = "c",
            explanation = "Choosing root `1` gives 2 right-subtree shapes; root `2` gives 1 balanced shape; root `3` gives 2 left-subtree shapes: `2 + 1 + 2 = 5` (the 3rd Catalan number `C_3`)."
        ),
        QuizQuestion(
            id = "lr_adv_43",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a rectangular grid from `(0, 0)` to `(4, 4)` moving only Right (`+x`) and Up (`+y`), there are `(8 choose 4) = 70` total shortest paths. How many of those paths pass through the checkpoint `(2, 2)`?",
            options = listOf(
                QuestionOption("a", "12 paths"),
                QuestionOption("b", "36 paths (`(4 choose 2) * (4 choose 2) = 6 * 6 = 36`)"),
                QuestionOption("c", "35 paths"),
                QuestionOption("d", "24 paths")
            ),
            correctOptionId = "b",
            explanation = "Paths from `(0,0)` to `(2,2)` = `(4 choose 2) = 6`; paths from `(2,2)` to `(4,4)` = `(4 choose 2) = 6`. By the multiplication rule, `6 * 6 = 36` paths pass through `(2,2)`."
        ),
        QuizQuestion(
            id = "lr_adv_44",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the same `(0, 0)` to `(4, 4)` grid (`70` total paths), if the intersection `(2, 2)` is BLOCKED by construction, how many shortest paths from `(0, 0)` to `(4, 4)` avoid `(2, 2)`?",
            options = listOf(
                QuestionOption("a", "34 paths (`70 total - 36 through (2,2) = 34`)"),
                QuestionOption("b", "36 paths"),
                QuestionOption("c", "64 paths"),
                QuestionOption("d", "35 paths")
            ),
            correctOptionId = "a",
            explanation = "Subtracting the 36 paths that pass through `(2,2)` from the 70 unrestricted paths leaves `70 - 36 = 34` valid paths."
        ),
        QuizQuestion(
            id = "lr_adv_45",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the remainder when `7^100` is divided by `5`?",
            options = listOf(
                QuestionOption("a", "2"),
                QuestionOption("b", "3"),
                QuestionOption("c", "4"),
                QuestionOption("d", "1 (because `7 ≡ 2 (mod 5)` and `7^4 = 2401 ≡ 1 (mod 5)` by Fermat's Little Theorem, so `(7^4)^25 ≡ 1^25 = 1`)")
            ),
            correctOptionId = "d",
            explanation = "Since `7^2 = 49 ≡ -1 (mod 5)`, we have `7^100 = (7^2)^50 ≡ (-1)^50 = 1 (mod 5)`."
        ),
        QuizQuestion(
            id = "lr_adv_46",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Find the smallest positive integer `x` that satisfies `x ≡ 2 (mod 3)`, `x ≡ 3 (mod 5)`, and `x ≡ 2 (mod 7)` (Sunzi's classic Chinese Remainder Theorem puzzle).",
            options = listOf(
                QuestionOption("a", "38"),
                QuestionOption("b", "53"),
                QuestionOption("c", "23 (`23 = 3*7 + 2 = 5*4 + 3 = 7*3 + 2`)"),
                QuestionOption("d", "17")
            ),
            correctOptionId = "c",
            explanation = "`x ≡ 2 (mod 3)` and `x ≡ 2 (mod 7)` implies `x ≡ 2 (mod 21)`. Checking `2, 23, 44...`: `23 mod 5 = 3`, so `x = 23` is the smallest positive solution (unique modulo `3*5*7 = 105`)."
        ),
        QuizQuestion(
            id = "lr_adv_47",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `x ≡ 2 (mod 3)`, `x ≡ 3 (mod 4)`, and `x ≡ 4 (mod 5)` (where each remainder is `1` less than the divisor, i.e., `x ≡ -1`), what is the smallest positive integer `x` satisfying all three?",
            options = listOf(
                QuestionOption("a", "119"),
                QuestionOption("b", "59 (`LCM(3, 4, 5) - 1 = 60 - 1 = 59`)"),
                QuestionOption("c", "61 (`LCM + 1`)"),
                QuestionOption("d", "57")
            ),
            correctOptionId = "b",
            explanation = "Since `x + 1` is divisible by `3`, `4`, and `5`, `x + 1` is a multiple of `LCM(3, 4, 5) = 60`, giving `x = 60 - 1 = 59`."
        ),
        QuizQuestion(
            id = "lr_adv_48",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How many zeros are at the end of `100!` (`1 * 2 * 3 * ... * 100`) in base 10?",
            options = listOf(
                QuestionOption("a", "24 trailing zeros (`floor(100/5) + floor(100/25) = 20 + 4 = 24`)"),
                QuestionOption("b", "20 trailing zeros"),
                QuestionOption("c", "25 trailing zeros"),
                QuestionOption("d", "10 trailing zeros")
            ),
            correctOptionId = "a",
            explanation = "Each trailing zero comes from a factor of `10 = 2 * 5`. Since factors of 2 are plentiful, Legendre's formula counts factors of 5: `floor(100/5) + floor(100/25) = 20 + 4 = 24`."
        ),
        QuizQuestion(
            id = "lr_adv_49",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If `a` and `b` are two positive integers with `GCD(a, b) = 6` and `LCM(a, b) = 180`, and `a = 30`, what is `b`?",
            options = listOf(
                QuestionOption("a", "24"),
                QuestionOption("b", "45"),
                QuestionOption("c", "18"),
                QuestionOption("d", "36 (using the identity `a * b = GCD(a, b) * LCM(a, b)`)")
            ),
            correctOptionId = "d",
            explanation = "For any two positive integers, `a * b = GCD(a, b) * LCM(a, b) = 6 * 180 = 1080`. Thus `b = 1080 / 30 = 36`."
        ),
        QuizQuestion(
            id = "lr_adv_50",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the sum of the infinite geometric series `1 + 1/2 + 1/4 + 1/8 + 1/16 + ...`?",
            options = listOf(
                QuestionOption("a", "4"),
                QuestionOption("b", "Infinity"),
                QuestionOption("c", "2 (`a / (1 - r) = 1 / (1 - 1/2) = 2`)"),
                QuestionOption("d", "1.5")
            ),
            correctOptionId = "c",
            explanation = "For `|r| < 1`, the infinite geometric series sums to `a / (1 - r) = 1 / (1/2) = 2`."
        ),
        QuizQuestion(
            id = "lr_adv_51",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A rubber ball is dropped from a height of `16 meters`. Every time it hits the ground, it bounces back up to `1/2` of the height from which it just fell (`8m`, then `4m`, `2m`, ...). What is the total vertical distance (both down and up) the ball travels before coming to rest?",
            options = listOf(
                QuestionOption("a", "40 meters"),
                QuestionOption("b", "48 meters (`16` down initially + `2 * (8 + 4 + 2 + 1 + ...) = 16 + 2 * 16 = 48`)"),
                QuestionOption("c", "32 meters"),
                QuestionOption("d", "64 meters")
            ),
            correctOptionId = "b",
            explanation = "The initial drop is 16m; every subsequent bounce of height `h` is traveled TWICE (up and down): `16 + 2 * (8 / (1 - 1/2)) = 16 + 32 = 48` meters."
        ),
        QuizQuestion(
            id = "lr_adv_52",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a room of `13` people, why must at least `2` people have been born in the same calendar month?",
            options = listOf(
                QuestionOption("a", "By the Pigeonhole Principle: there are `12` months (pigeonholes) and `13` people (pigeons), so `ceil(13 / 12) = 2`"),
                QuestionOption("b", "Because February has 28 days"),
                QuestionOption("c", "Only if it is a leap year"),
                QuestionOption("d", "It is not guaranteed; all 13 could have different birth months")
            ),
            correctOptionId = "a",
            explanation = "By the generalized Pigeonhole Principle, placing `N` items into `k` boxes guarantees at least one box contains at least `ceil(N / k)` items."
        ),
        QuizQuestion(
            id = "lr_adv_53",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the generalized Pigeonhole Principle (`ceil(N / k)`), in a group of `100` people, at least how many people must have been born on the SAME day of the week (Monday through Sunday)?",
            options = listOf(
                QuestionOption("a", "At least `14` people"),
                QuestionOption("b", "At least `12` people"),
                QuestionOption("c", "At least `20` people"),
                QuestionOption("d", "At least `15` people (`ceil(100 / 7) = ceil(14.28) = 15`)")
            ),
            correctOptionId = "d",
            explanation = "If at most 14 people were born on each of the 7 days of the week, there could be at most `7 * 14 = 98` people; with 100 people, at least one day has `>= 15` people."
        ),
        QuizQuestion(
            id = "lr_adv_54",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "According to `Ramsey's Theorem R(3, 3) = 6` (the Party Problem), in any group of at least `6` people where every pair of people are either mutual friends or mutual strangers, what is ALWAYS guaranteed?",
            options = listOf(
                QuestionOption("a", "At least 4 people are mutual friends"),
                QuestionOption("b", "No three people can know each other"),
                QuestionOption("c", "There is ALWAYS either a group of `3 mutual friends` (a triangle in `G`) OR a group of `3 mutual strangers` (a triangle in the complement graph)! (Whereas with 5 people, a 5-cycle `C_5` has neither)"),
                QuestionOption("d", "Everyone knows everyone else")
            ),
            correctOptionId = "c",
            explanation = "Pick any person `P`: `P` has 5 relationships to the others, so by Pigeonhole Principle at least `ceil(5/2) = 3` are of the same type (say friends `A, B, C`). If any pair among `A, B, C` are friends, they form 3 mutual friends with `P`; if none are friends with each other, `{A, B, C}` are 3 mutual strangers!"
        ),
        QuizQuestion(
            id = "lr_adv_55",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In graph theory, what does the `Handshaking Lemma` state about the sum of degrees of all vertices in any finite undirected graph `G = (V, E)`?",
            options = listOf(
                QuestionOption("a", "The sum of degrees equals `|E|^2`"),
                QuestionOption("b", "The sum of the degrees of all vertices equals `2 * |E|` (an even number), which implies that the number of vertices with an ODD degree must ALWAYS be EVEN!"),
                QuestionOption("c", "The sum of degrees equals `|V|`"),
                QuestionOption("d", "Every graph has an odd number of odd-degree vertices")
            ),
            correctOptionId = "b",
            explanation = "Every undirected edge `{u, v}` contributes `+2` to the total degree sum (`+1` at `u` and `+1` at `v`), so `sum(deg(v)) = 2|E|` is even, meaning odd-degree vertices must come in pairs!"
        ),
        QuizQuestion(
            id = "lr_adv_56",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "At a party of `9` people, is it possible for EVERY person to shake hands with exactly `3` other people at the party?",
            options = listOf(
                QuestionOption("a", "No, it is impossible! By the Handshaking Lemma, `9 * 3 = 27` is odd, and the sum of degrees (`2 * handshakes`) must be an EVEN number!"),
                QuestionOption("b", "Yes, it requires 13.5 handshakes"),
                QuestionOption("c", "Yes, if they stand in a circle"),
                QuestionOption("d", "Yes, if 3 people shake hands twice")
            ),
            correctOptionId = "a",
            explanation = "An undirected graph on 9 vertices cannot be 3-regular because `9 * 3 = 27` is not divisible by 2."
        ),
        QuizQuestion(
            id = "lr_adv_57",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Euler's theorem on `Eulerian Paths` (Konigsberg Bridge Problem), when does a connected undirected graph have an `Eulerian Trail` (a walk that traverses every EDGE of the graph exactly once)?",
            options = listOf(
                QuestionOption("a", "Whenever the graph has an even number of edges"),
                QuestionOption("b", "When all vertices have degree 4 (Konigsberg had 4 odd-degree vertices of degrees 3, 3, 3, 5, which is why it had NO Eulerian path!)"),
                QuestionOption("c", "Whenever the graph is a tree"),
                QuestionOption("d", "If and only if the number of vertices with an ODD degree is either `0` (an Eulerian circuit starting and ending at the same vertex) or `2` (an Eulerian trail starting at one odd-degree vertex and ending at the other)!")
            ),
            correctOptionId = "d",
            explanation = "Every intermediate visit to a vertex uses 2 edges (1 in, 1 out); only the start and end vertices of the trail can have odd degree (0 or 2 odd-degree vertices total)."
        ),
        QuizQuestion(
            id = "lr_adv_58",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "For any connected `Planar Graph` drawn in the plane without edge crossings, with `V` vertices, `E` edges, and `F` faces (including the outer infinite face), what is `Euler's Polyhedral / Planar Graph Formula`?",
            options = listOf(
                QuestionOption("a", "V - E - F = 0"),
                QuestionOption("b", "V * F = 2E"),
                QuestionOption("c", "V - E + F = 2"),
                QuestionOption("d", "V + E + F = 2")
            ),
            correctOptionId = "c",
            explanation = "For example, a cube has `V = 8` vertices, `E = 12` edges, and `F = 6` faces: `8 - 12 + 6 = 2`."
        )
    )

    private fun advancedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "lr_adv_59",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using Euler's Planar Formula `V - E + F = 2`, if a connected planar graph has `10` vertices and `15` edges, into how many faces `F` (including the outer face) does it divide the plane?",
            options = listOf(
                QuestionOption("a", "8 faces"),
                QuestionOption("b", "7 faces (`F = 2 - V + E = 2 - 10 + 15 = 7`)"),
                QuestionOption("c", "5 faces"),
                QuestionOption("d", "6 faces")
            ),
            correctOptionId = "b",
            explanation = "Substituting `V = 10` and `E = 15` into `V - E + F = 2` gives `10 - 15 + F = 2 => F = 7`."
        ),
        QuizQuestion(
            id = "lr_adv_60",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Three statements are written on a box, and you are told that EXACTLY ONE of the three statements is TRUE: (1) 'The prize is in Box 1.' (2) 'The prize is NOT in Box 2.' (3) 'The prize is NOT in Box 1.' Which box contains the prize?",
            options = listOf(
                QuestionOption("a", "Box 2! (Statements 1 and 3 are direct negations of each other, so one of {1, 3} MUST be true; since only one statement total is true, Statement 2 must be FALSE, meaning the prize IS in Box 2!)"),
                QuestionOption("b", "Box 1"),
                QuestionOption("c", "Box 3"),
                QuestionOption("d", "It cannot be determined")
            ),
            correctOptionId = "a",
            explanation = "Because (1) and (3) are contradictory (`P` and `~P`), exactly one of them is True. Since only 1 statement in total is True, (2) must be False—so 'NOT in Box 2' is False, placing the prize in Box 2!"
        ),
        QuizQuestion(
            id = "lr_adv_61",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Three suspects (Alice, Bob, Charlie) make statements: Alice says 'Bob did it.' Bob says 'Charlie did it.' Charlie says 'Bob is lying.' Assuming exactly ONE person committed the act and exactly ONE of the three is telling the truth, who committed the act?",
            options = listOf(
                QuestionOption("a", "Bob"),
                QuestionOption("b", "Charlie"),
                QuestionOption("c", "None of them"),
                QuestionOption("d", "Alice! (Bob and Charlie contradict each other, so the single truth-teller is one of {Bob, Charlie}; if Alice did it, Alice is lying, Bob is lying, and Charlie's 'Bob is lying' is the unique TRUE statement!)")
            ),
            correctOptionId = "d",
            explanation = "Check: if Alice did it -> Alice ('Bob did it') is False, Bob ('Charlie did it') is False, and Charlie ('Bob is lying') is True (1 truth-teller, 1 culprit!)."
        ),
        QuizQuestion(
            id = "lr_adv_62",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `'Cheryl's Birthday'` style epistemic logic deductions, what does it mean when Player A (who knows only the Month) says: 'I don't know the date, AND I know that Player B (who knows only the Day) does NOT know it either'?",
            options = listOf(
                QuestionOption("a", "Player B already knew the birthday from the start"),
                QuestionOption("b", "The birthday must be in January"),
                QuestionOption("c", "Every possible Day occurring in Player A's Month must appear in multiple months (so A can rule out any Month that contains a unique singleton Day)!"),
                QuestionOption("d", "Player A's Month has only 1 possible date")
            ),
            correctOptionId = "c",
            explanation = "If A's month contained a Day that appeared only once in the entire candidate list, B might have had that unique Day and known immediately; for A to be CERTAIN B doesn't know, A's month cannot contain any unique Day!"
        ),
        QuizQuestion(
            id = "lr_adv_63",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Five pirates (ranked P1 highest to P5 lowest) must split `100` gold coins. P1 proposes a distribution; if AT LEAST `50%` of the voting pirates (including the proposer, so 3 out of 5) vote yes, it passes; otherwise P1 is thrown overboard and P2 proposes. Pirates are rational, first want to survive, second want to maximize their gold, and third prefer throwing others overboard if tied on gold. How should P1 distribute `(P1, P2, P3, P4, P5)`?",
            options = listOf(
                QuestionOption("a", "(50, 50, 0, 0, 0)"),
                QuestionOption("b", "(98, 0, 1, 0, 1) — P1 keeps 98 coins and gives 1 coin each to P3 and P5!"),
                QuestionOption("c", "(20, 20, 20, 20, 20)"),
                QuestionOption("d", "(97, 0, 1, 1, 1)")
            ),
            correctOptionId = "b",
            explanation = "By backward induction: with 2 pirates (P4, P5), P4 votes (100, 0) with 50%; with 3 (P3, P4, P5), P3 bribes P5 with 1 coin: (99, 0, 1); with 4 (P2..P5), P2 bribes P4 with 1 coin: (99, 0, 1, 0); with 5 (P1..P5), P1 bribes P3 and P5 (who would get 0 under P2) with 1 coin each: (98, 0, 1, 0, 1)!"
        ),
        QuizQuestion(
            id = "lr_adv_64",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A frog sits at `0` on a number line and wants to reach `6` by jumping either `+1` step or `+2` steps at a time. In how many distinct sequences of jumps can the frog reach `6`?",
            options = listOf(
                QuestionOption("a", "13 ways (the Fibonacci recurrence `ways(n) = ways(n-1) + ways(n-2)`: `1, 2, 3, 5, 8, 13`)"),
                QuestionOption("b", "8 ways"),
                QuestionOption("c", "12 ways"),
                QuestionOption("d", "21 ways")
            ),
            correctOptionId = "a",
            explanation = "To reach step `n`, the last jump came from `n-1` (+1) or `n-2` (+2): `w(1)=1, w(2)=2, w(3)=3, w(4)=5, w(5)=8, w(6)=13`."
        ),
        QuizQuestion(
            id = "lr_adv_65",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What if the frog at `0` wants to reach `6` using jumps of `+1`, `+2`, or `+3` steps at a time (the Tribonacci recurrence `w(n) = w(n-1) + w(n-2) + w(n-3)`)? How many distinct jump sequences reach `6`?",
            options = listOf(
                QuestionOption("a", "13 ways"),
                QuestionOption("b", "20 ways"),
                QuestionOption("c", "27 ways"),
                QuestionOption("d", "24 ways (`w(0)=1, w(1)=1, w(2)=2, w(3)=4, w(4)=7, w(5)=13, w(6)=24`)")
            ),
            correctOptionId = "d",
            explanation = "Summing the previous three states: `w(3) = 1+1+2 = 4`, `w(4) = 1+2+4 = 7`, `w(5) = 2+4+7 = 13`, `w(6) = 4+7+13 = 24`."
        ),
        QuizQuestion(
            id = "lr_adv_66",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How many binary strings of length `5` (made of `'0'` and `'1'`) do NOT contain two consecutive `'1'`s (`\"11\"`)?",
            options = listOf(
                QuestionOption("a", "10 binary strings"),
                QuestionOption("b", "8 binary strings"),
                QuestionOption("c", "13 binary strings (follows Fibonacci: length 1 -> `2`, length 2 -> `3`, length 3 -> `5`, length 4 -> `8`, length 5 -> `13`)"),
                QuestionOption("d", "16 binary strings")
            ),
            correctOptionId = "c",
            explanation = "A valid string of length `n` either ends in `0` (preceded by any valid length `n-1` string) or ends in `01` (preceded by any valid length `n-2` string), giving `F(n) = F(n-1) + F(n-2) = 13`."
        ),
        QuizQuestion(
            id = "lr_adv_67",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Tower of Hanoi` puzzle with `3` pegs and `n = 5` disks of different sizes, what is the minimum number of single-disk moves required to transfer all 5 disks from Peg A to Peg C without ever placing a larger disk on top of a smaller disk?",
            options = listOf(
                QuestionOption("a", "25 moves"),
                QuestionOption("b", "31 moves (`2^5 - 1 = 31`)"),
                QuestionOption("c", "32 moves"),
                QuestionOption("d", "15 moves")
            ),
            correctOptionId = "b",
            explanation = "Moving `n` disks requires recursively moving the top `n-1` disks to the spare peg (`T(n-1)`), moving the largest disk (`1`), and moving the `n-1` disks onto it (`T(n-1)`): `T(n) = 2*T(n-1) + 1 = 2^n - 1 = 31`."
        ),
        QuizQuestion(
            id = "lr_adv_68",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A server cluster has 3 independent power supplies, each with a `90%` (`0.9`) probability of functioning during a storm. The cluster stays online if AT LEAST `2` of the 3 power supplies function. What is the probability that the cluster stays online?",
            options = listOf(
                QuestionOption("a", "0.972 (`97.2%`, which is `P(all 3) + P(exactly 2) = 0.9^3 + 3 * (0.9^2 * 0.1) = 0.729 + 0.243`)"),
                QuestionOption("b", "0.900 (`90%`)"),
                QuestionOption("c", "0.729 (`72.9%`)"),
                QuestionOption("d", "0.990 (`99%`)")
            ),
            correctOptionId = "a",
            explanation = "P(3 working) = `0.9^3 = 0.729`; P(exactly 2 working) = `(3 choose 2) * 0.9^2 * 0.1 = 3 * 0.081 = 0.243`. Sum = `0.729 + 0.243 = 0.972` (97.2%)."
        ),
        QuizQuestion(
            id = "lr_adv_69",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Suppose you roll two fair 6-sided dice and you are told that AT LEAST ONE of the two dice shows a `6`. Given this condition, what is the conditional probability that the sum of the two dice is `>= 10`?",
            options = listOf(
                QuestionOption("a", "5/12"),
                QuestionOption("b", "1/2"),
                QuestionOption("c", "6/11"),
                QuestionOption("d", "5/11 (There are `11` outcomes with at least one `6`, and `5` of them have sum `>= 10`: `(4,6), (6,4), (5,6), (6,5), (6,6)`)")
            ),
            correctOptionId = "d",
            explanation = "There are 11 outcomes with at least one 6 (6 + 6 - 1 = 11 because (6,6) is only counted once!). Among those 11, the pairs with sum >= 10 are (4,6), (6,4), (5,6), (6,5), and (6,6)—which is 5 outcomes out of 11 (5/11)."
        ),
        QuizQuestion(
            id = "lr_adv_70",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A family has 2 children (assuming independent 50/50 Boys and Girls: BB, BG, GB, GG). You are told that AT LEAST ONE child is a Boy (`{BB, BG, GB}`). What is the conditional probability that BOTH children are Boys (`BB`)?",
            options = listOf(
                QuestionOption("a", "1/4"),
                QuestionOption("b", "2/3"),
                QuestionOption("c", "1/3 (because out of the 3 equally likely outcomes `{BB, BG, GB}`, only 1 is `BB`!)"),
                QuestionOption("d", "1/2 (which holds only if you are told the ELDEST child is a Boy: `{BB, BG}`)")
            ),
            correctOptionId = "c",
            explanation = "Conditioning on 'at least one is B' eliminates only `GG`, leaving 3 equally likely outcomes `{BB, BG, GB}`, of which 1 is `BB` (`1/3`)."
        ),
        QuizQuestion(
            id = "lr_adv_71",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In contrast, if a family has 2 children and you are told specifically that the ELDEST child is a Boy, what is the conditional probability that BOTH children are Boys?",
            options = listOf(
                QuestionOption("a", "2/3"),
                QuestionOption("b", "1/2 (because the sample space is `{BB, BG}`, and the younger child's gender is independent)"),
                QuestionOption("c", "1/3"),
                QuestionOption("d", "1/4")
            ),
            correctOptionId = "b",
            explanation = "Specifying which child (the eldest) is a Boy restricts the sample space to `{BB, BG}`, giving probability `1/2`."
        ),
        QuizQuestion(
            id = "lr_adv_72",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Three ants sit at the three corners of an equilateral triangle. Simultaneously, each ant independently picks one of the two adjacent edges at random (50/50 clockwise or counterclockwise) and walks along it. What is the probability that NO two ants collide?",
            options = listOf(
                QuestionOption("a", "1/4 (out of `2^3 = 8` direction combinations, only `2` avoid collision: all 3 walk clockwise OR all 3 walk counterclockwise, giving `2/8 = 1/4`)"),
                QuestionOption("b", "1/8"),
                QuestionOption("c", "1/2"),
                QuestionOption("d", "3/8")
            ),
            correctOptionId = "a",
            explanation = "Ants avoid collision if and only if all 3 choose the exact same orientation around the triangle (all CW or all CCW): `2 / 2^3 = 2/8 = 1/4`."
        ),
        QuizQuestion(
            id = "lr_adv_73",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What if `4` ants sit at the four corners of a square and each independently chooses one of its two adjacent edges at random (50/50 CW or CCW)? What is the probability that no two ants collide?",
            options = listOf(
                QuestionOption("a", "1/4"),
                QuestionOption("b", "1/16"),
                QuestionOption("c", "3/8"),
                QuestionOption("d", "1/8 (`2 / 2^4 = 2/16 = 1/8`)")
            ),
            correctOptionId = "d",
            explanation = "For any `n`-gon, all `n` ants must pick the same orientation (all CW or all CCW), so the probability is `2 / 2^n = 1 / 2^(n-1)`. For `n = 4`, `1 / 2^3 = 1/8`."
        ),
        QuizQuestion(
            id = "lr_adv_74",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If `f(x)` satisfies `f(x + y) = f(x) + f(y)` for all integers `x, y` and `f(3) = 15`, what is the value of `f(11)`?",
            options = listOf(
                QuestionOption("a", "45"),
                QuestionOption("b", "60"),
                QuestionOption("c", "55 (since `f(n) = c * n` with `c = 15 / 3 = 5`, so `f(11) = 5 * 11 = 55`)"),
                QuestionOption("d", "33")
            ),
            correctOptionId = "c",
            explanation = "For integers, Cauchy's additive functional equation `f(x + y) = f(x) + f(y)` gives `f(n) = n * f(1)`. Since `3 * f(1) = 15 => f(1) = 5`, we have `f(11) = 55`."
        ),
        QuizQuestion(
            id = "lr_adv_75",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If `x` and `y` are positive real numbers whose sum is fixed at `x + y = 20`, what values of `x` and `y` maximize their product `x * y`, and what is that maximum product (by the AM-GM Inequality)?",
            options = listOf(
                QuestionOption("a", "`x = 12, y = 8`, giving `96`"),
                QuestionOption("b", "`x = 10, y = 10`, giving maximum product `100` (since `sqrt(xy) <= (x + y) / 2 = 10 => xy <= 100`)"),
                QuestionOption("c", "`x = 15, y = 5`, giving `75`"),
                QuestionOption("d", "`x = 19, y = 1`, giving `19`")
            ),
            correctOptionId = "b",
            explanation = "By the Arithmetic Mean – Geometric Mean (AM-GM) inequality, `(x + y)/2 >= sqrt(xy)` with equality if and only if `x = y = 10`, maximizing `xy = 100`."
        ),
        QuizQuestion(
            id = "lr_adv_76",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "By the AM-GM inequality, for any positive real number `x > 0`, what is the MINIMUM possible value of `x + 9/x`, and at what `x` does it occur?",
            options = listOf(
                QuestionOption("a", "Minimum value is `6`, occurring at `x = 3` (`x + 9/x >= 2 * sqrt(x * (9/x)) = 2 * 3 = 6`)"),
                QuestionOption("b", "Minimum value is `9` at `x = 1`"),
                QuestionOption("c", "Minimum value is `3` at `x = 3`"),
                QuestionOption("d", "Minimum value is `10` at `x = 9`")
            ),
            correctOptionId = "a",
            explanation = "`x + 9/x >= 2 * sqrt(x * 9 / x) = 6`, with equality when `x = 9/x => x^2 = 9 => x = 3`."
        ),
        QuizQuestion(
            id = "lr_adv_77",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A 100-kg batch of fresh berries is initially `99%` water by weight (and `1%` dry solid matter). After drying in the sun, the berries are now `98%` water by weight. What is the new total weight of the batch of berries (the `Potato Paradox`)?",
            options = listOf(
                QuestionOption("a", "99 kg"),
                QuestionOption("b", "98 kg"),
                QuestionOption("c", "90 kg"),
                QuestionOption("d", "50 kg! (The `1 kg` of dry solid matter never evaporates; when water is `98%`, that `1 kg` of solid matter is now `2%` of total weight: `0.02 * W = 1 kg => W = 50 kg`!)")
            ),
            correctOptionId = "d",
            explanation = "Track the invariant (non-evaporating dry solids): `1%` of `100 kg = 1 kg` of solids. When solids become `100% - 98% = 2%` of the total weight, total weight is `1 kg / 0.02 = 50 kg`!"
        ),
        QuizQuestion(
            id = "lr_adv_78",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Two trains start 100 km apart on the same straight track and head toward each other, each traveling at `50 km/h`. Simultaneously, a fast drone starts at the front of Train A and flies back and forth between the fronts of the two approaching trains at a constant speed of `80 km/h` (turning around instantaneously) until the trains meet. What total distance does the drone fly?",
            options = listOf(
                QuestionOption("a", "50 km"),
                QuestionOption("b", "160 km"),
                QuestionOption("c", "80 km! (The trains approach at relative speed `50 + 50 = 100 km/h` and meet in exactly `1 hour`; flying at `80 km/h` for `1 hour`, the drone covers `80 km` without needing to sum an infinite series!)"),
                QuestionOption("d", "100 km")
            ),
            correctOptionId = "c",
            explanation = "Instead of summing every back-and-forth leg (von Neumann's joke), compute the total time until the trains meet: `100 km / (50 + 50 km/h) = 1 hour`. In 1 hour at 80 km/h, the drone flies 80 km."
        ),
        QuizQuestion(
            id = "lr_adv_79",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a round-robin chess tournament with `10` players where every player plays every other player once (`(10 choose 2) = 45` games), each game awards `1` point to the winner (`0` to the loser) or `0.5` points to each player in a draw. What is the sum of the final scores of all 10 players at the end of the tournament?",
            options = listOf(
                QuestionOption("a", "50 points"),
                QuestionOption("b", "45 points (every single game—whether won or drawn—adds an invariant `+1` total point to the pool of player scores across 45 games!)"),
                QuestionOption("c", "90 points"),
                QuestionOption("d", "It depends on how many games end in a draw")
            ),
            correctOptionId = "b",
            explanation = "Because both `1 + 0 = 1` and `0.5 + 0.5 = 1`, the total points awarded across `G` games is an invariant equal to `G = 45`."
        ),
        QuizQuestion(
            id = "lr_adv_80",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Suppose a secret integer `x` is known to lie in `{1, 2, ..., 1000}`. What is the minimum number of Yes/No questions required in the worst case to guaranteedly identify `x` (by Shannon information theory)?",
            options = listOf(
                QuestionOption("a", "10 questions (since `2^9 = 512 < 1000 <= 1024 = 2^10`, so `ceil(log2(1000)) = 10` bits of information)"),
                QuestionOption("b", "9 questions"),
                QuestionOption("c", "500 questions"),
                QuestionOption("d", "100 questions")
            ),
            correctOptionId = "a",
            explanation = "Each Yes/No question provides at most 1 bit of information (halving the candidate set), so distinguishing `N` possibilities requires at least `ceil(log2(N))` questions."
        ),
        QuizQuestion(
            id = "lr_adv_81",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What if the responder is allowed to LIE at most ONCE during your Yes/No questions to find `x in {1..N}` (Ulam's Game / Error-Correcting Binary Search)? Why are 10 questions no longer enough for `N = 1000`?",
            options = listOf(
                QuestionOption("a", "Because binary search does not work on integers"),
                QuestionOption("b", "You need 1,000 questions if 1 lie is allowed"),
                QuestionOption("c", "10 questions are still enough"),
                QuestionOption("d", "Because the final state must distinguish not only which of the `N` numbers is `x`, but ALSO whether 0 lies occurred (`1` way) or 1 lie occurred on one of the `q` questions (`q` ways)—requiring `(q + 1) * N <= 2^q` (the Hamming bound)!")
            ),
            correctOptionId = "d",
            explanation = "By the Hamming sphere-packing bound, `q` questions with at most 1 error need `(q + 1) * N <= 2^q` (for `N = 1000`, `q = 14` since `15 * 1000 = 15000 <= 16384 = 2^14`)."
        ),
        QuizQuestion(
            id = "lr_adv_82",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a 7-bit `Hamming(7, 4)` error-correcting code (4 data bits + 3 parity bits), what is the minimum Hamming distance `d_min` between any two valid codewords, and how many single-bit errors can it detect vs. correct?",
            options = listOf(
                QuestionOption("a", "`d_min = 7`, correcting 7 errors"),
                QuestionOption("b", "`d_min = 2`, correcting 2 errors"),
                QuestionOption("c", "`d_min = 3`, allowing it to CORRECT any `1-bit` error (`floor((3-1)/2) = 1`) or DETECT up to `2-bit` errors (`d_min - 1 = 2`)"),
                QuestionOption("d", "`d_min = 1`")
            ),
            correctOptionId = "c",
            explanation = "A block code with minimum Hamming distance `d` can detect up to `d - 1` bit flips and correct up to `floor((d - 1) / 2)` bit flips."
        ),
        QuizQuestion(
            id = "lr_adv_83",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A bag contains `3` red balls and `3` blue balls. You draw balls one by one WITHOUT replacement. What is the probability that the VERY LAST (6th) ball drawn is red?",
            options = listOf(
                QuestionOption("a", "2/3"),
                QuestionOption("b", "1/2! (By symmetry, every ball in the bag is equally likely to be in the 6th position as in the 1st position: `3/6 = 1/2`!)"),
                QuestionOption("c", "1/6"),
                QuestionOption("d", "1/3")
            ),
            correctOptionId = "b",
            explanation = "In a uniform random permutation of 3 red and 3 blue balls, the marginal probability that the `k`-th ball is red is identical for every position `k in 1..6`: `3 / 6 = 1/2`!"
        ),
        QuizQuestion(
            id = "lr_adv_84",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Five people (`A, B, C, D, E`) stand in a random line (all `5! = 120` orderings equally likely). What is the probability that `A` stands somewhere ahead of `B` (not necessarily immediately adjacent, just anywhere to the left of `B`)?",
            options = listOf(
                QuestionOption("a", "1/2 (By symmetry, in exactly half of all permutations `A` precedes `B`, and in the other half `B` precedes `A`!)"),
                QuestionOption("b", "1/5"),
                QuestionOption("c", "2/5"),
                QuestionOption("d", "1/10")
            ),
            correctOptionId = "a",
            explanation = "Swapping `A` and `B` creates a 1-to-1 bijection between permutations where `A` is before `B` and permutations where `B` is before `A`, so the probability is `1/2`."
        ),
        QuizQuestion(
            id = "lr_adv_85",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What if five people (`A, B, C, D, E`) stand in a random line: what is the probability that `A` is ahead of `B` AND `B` is ahead of `C` (i.e., `A, B, C` appear in the relative order `A ... B ... C`)?",
            options = listOf(
                QuestionOption("a", "1/3"),
                QuestionOption("b", "1/2"),
                QuestionOption("c", "1/12"),
                QuestionOption("d", "1/6 (Among the `3! = 6` equally likely relative orderings of `{A, B, C}`, exactly `1` is `A < B < C`!)")
            ),
            correctOptionId = "d",
            explanation = "By symmetry, all `k! = 3! = 6` relative orderings of the subset `{A, B, C}` occur in an equal number of full permutations (`120 / 6 = 20` each), so `P(A < B < C) = 1/6`."
        ),
        QuizQuestion(
            id = "lr_adv_86",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How many rectangles of ALL sizes (including squares, since every square is a rectangle) can be formed using the grid lines of a standard `4 x 4` grid of squares (which has `5` horizontal lines and `5` vertical lines)?",
            options = listOf(
                QuestionOption("a", "64 rectangles"),
                QuestionOption("b", "80 rectangles"),
                QuestionOption("c", "100 rectangles (`(5 choose 2) * (5 choose 2) = 10 * 10 = 100`)"),
                QuestionOption("d", "30 rectangles")
            ),
            correctOptionId = "c",
            explanation = "Every axis-aligned rectangle is uniquely determined by choosing 2 of the 5 horizontal grid lines and 2 of the 5 vertical grid lines: `(5 choose 2) * (5 choose 2) = 10 * 10 = 100`."
        ),
        QuizQuestion(
            id = "lr_adv_87",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Since there are `100` total rectangles and `30` squares on a `4 x 4` grid, how many NON-SQUARE (strictly oblong) rectangles exist on a `4 x 4` grid?",
            options = listOf(
                QuestionOption("a", "84 non-square rectangles"),
                QuestionOption("b", "70 non-square rectangles (`100 total rectangles - 30 squares = 70`)"),
                QuestionOption("c", "70 squares"),
                QuestionOption("d", "50 non-square rectangles")
            ),
            correctOptionId = "b",
            explanation = "Subtracting the `1^2 + 2^2 + 3^2 + 4^2 = 30` squares from the `100` total rectangles yields `70` non-square rectangles."
        ),
        QuizQuestion(
            id = "lr_adv_88",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Suppose `10` points lie on a circle, and no three chords connecting them intersect at the same interior point. How many interior intersection points are formed by drawing all chords between the 10 points?",
            options = listOf(
                QuestionOption("a", "210 intersection points (`(10 choose 4) = 210`, because every subset of 4 points on a circle determines a unique pair of crossing diagonals!)"),
                QuestionOption("b", "45 intersection points (`10 choose 2`)"),
                QuestionOption("c", "120 intersection points (`10 choose 3`)"),
                QuestionOption("d", "252 intersection points")
            ),
            correctOptionId = "a",
            explanation = "Any 4 points on a circle form a convex quadrilateral whose 2 diagonals intersect at exactly 1 interior point, giving a 1-to-1 bijection between interior intersections and 4-point subsets: `(10 choose 4) = 210`."
        ),
        QuizQuestion(
            id = "lr_adv_89",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the fallacy in the famous `'Missing Dollar Riddle'`: Three guests pay \$10 each (\$30 total) for a room. The manager refunds \$5; the bellhop keeps \$2 and gives \$1 back to each guest. 'Each guest paid \$9 (`3 * \$9 = \$27`), plus the bellhop's `\$2` makes `\$29`—where is the 30th dollar?'",
            options = listOf(
                QuestionOption("a", "Inflation ate the 1 dollar"),
                QuestionOption("b", "27 + 2 actually equals 30 in modular arithmetic"),
                QuestionOption("c", "The manager kept \$6 instead of \$5"),
                QuestionOption("d", "Adding the bellhop's `\$2` to the `\$27` is an accounting sign error! The guests' net outflow is `\$27`, which EQUALS the `\$25` in the hotel register PLUS the `\$2` in the bellhop's pocket (`\$27 = \$25 + \$2`, while `\$27 + \$3 refunded = \$30`)!")
            ),
            correctOptionId = "d",
            explanation = "The `\$2` held by the bellhop is already PART of the `\$27` net paid by the guests (`\$25` to hotel + `\$2` to bellhop = `\$27`); you subtract `\$2` from `\$27` to get `\$25`, or add the `\$3` refund to `\$27` to get `\$30`."
        ),
        QuizQuestion(
            id = "lr_adv_90",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `'Two Envelopes' / Exchange Paradox` setup, why is the naive argument 'If my envelope has `\$X`, the other has `\$2X` or `\$X/2` with 50/50 probability, so its expected value is `0.5(2X) + 0.5(X/2) = 1.25X > X`' fallacious?",
            options = listOf(
                QuestionOption("a", "Because expected value does not apply to money"),
                QuestionOption("b", "The argument is completely valid for all bounded distributions"),
                QuestionOption("c", "It uses the same symbol `X` for two different conditional values (no uniform prior distribution exists over `(0, infinity)`, and in `0.5(2X) + 0.5(X/2)`, the first case assumes `{X, 2X}` while the second assumes `{X/2, X}` with different total sums)!"),
                QuestionOption("d", "Because `0.5 * 2 + 0.5 * 0.5` actually equals `1.0`")
            ),
            correctOptionId = "c",
            explanation = "Conditioning on observing `X` without a proper prior treats `{X, 2X}` and `{X/2, X}` as equally likely for every `X`, which is impossible over a bounded or normalizable probability distribution."
        ),
        QuizQuestion(
            id = "lr_adv_91",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Coupon Collector's Problem`, there are `4` distinct types of collectibles (`n = 4`), and each blind box contains 1 collectible chosen uniformly and independently at random. What is the expected number of boxes you must open to collect ALL 4 distinct types?",
            options = listOf(
                QuestionOption("a", "16 boxes"),
                QuestionOption("b", "25/3 boxes (approx. `8.33`, computed as `4/4 + 4/3 + 4/2 + 4/1 = 1 + 4/3 + 2 + 4 = 25/3`)"),
                QuestionOption("c", "4 boxes"),
                QuestionOption("d", "8 boxes")
            ),
            correctOptionId = "b",
            explanation = "When you already have `k` distinct types, the probability of getting a new type is `(n - k) / n`, taking `n / (n - k)` expected boxes. By linearity of expectation: `4/4 + 4/3 + 4/2 + 4/1 = 25/3 ≈ 8.33`."
        ),
        QuizQuestion(
            id = "lr_adv_92",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In general, as `n` grows large in the `Coupon Collector's Problem`, what is the asymptotic expected number of draws `n * (1 + 1/2 + 1/3 + ... + 1/n)` required to collect all `n` distinct coupons?",
            options = listOf(
                QuestionOption("a", "Theta(n log n) (specifically `n * H_n ≈ n * ln(n) + gamma * n`)"),
                QuestionOption("b", "Theta(n)"),
                QuestionOption("c", "Theta(n^2)"),
                QuestionOption("d", "Theta(2^n)")
            ),
            correctOptionId = "a",
            explanation = "The `n`-th Harmonic number `H_n = 1 + 1/2 + ... + 1/n` grows as `ln(n)`, so collecting all `n` items takes `n * H_n = Theta(n log n)` draws."
        ),
        QuizQuestion(
            id = "lr_adv_93",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Secretary Problem` (Optimal Stopping Theory), `n` applicants are interviewed one by one in random order, and you must immediately accept or permanently reject each applicant on the spot, aiming to maximize the probability of picking the single best overall applicant. What is the optimal strategy and its asymptotic success probability?",
            options = listOf(
                QuestionOption("a", "Always pick the very first applicant (`1 / n` probability)"),
                QuestionOption("b", "Reject the first `50%` and pick the last applicant"),
                QuestionOption("c", "Pick a random applicant (`1 / n` probability)"),
                QuestionOption("d", "Reject the first `n / e` (approx. `37%`) applicants as a benchmark, and then pick the FIRST subsequent applicant who is better than everyone seen in the first `37%`—succeeding with probability `1 / e ≈ 36.8%` even for huge `n`!")
            ),
            correctOptionId = "d",
            explanation = "Stopping after a sample fraction `1/e ≈ 36.8%` balances the risk of stopping too early against the risk of the best candidate already having passed in the calibration phase, achieving `1/e ≈ 36.8%` success!"
        ),
        QuizQuestion(
            id = "lr_adv_94",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Gambler's Ruin` problem with a fair coin (`p = 1/2` win `+\$1`, `q = 1/2` lose `-\$1`), a player starts with `\$30` and plays until either reaching `\$100` or going broke at `\$0`. What is the probability that the player reaches `\$100` before `\$0`?",
            options = listOf(
                QuestionOption("a", "7/10 (`70%`)"),
                QuestionOption("b", "9/100 (`9%`)"),
                QuestionOption("c", "3/10 (`30%`, because in a fair random walk `E[W_T] = W_0`, so `P(hit N) = start / N = 30 / 100 = 3/10`!)"),
                QuestionOption("d", "1/2 (`50%`)")
            ),
            correctOptionId = "c",
            explanation = "Because the fair random walk is a martingale (zero drift), the expected final wealth equals the starting wealth: `100 * P(win) + 0 * (1 - P(win)) = 30 => P(win) = 30 / 100 = 3/10`."
        ),
        QuizQuestion(
            id = "lr_adv_95",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A stick of length `1` is broken at a single point `X` chosen uniformly at random along `[0, 1]`. What is the expected length of the LONGER of the two resulting pieces?",
            options = listOf(
                QuestionOption("a", "5/8 (`0.625`)"),
                QuestionOption("b", "3/4 (`0.75`)"),
                QuestionOption("c", "2/3 (`0.667`)"),
                QuestionOption("d", "1/2 (`0.50`)")
            ),
            correctOptionId = "b",
            explanation = "By symmetry, if `X` is in `[0, 1/2]`, the longer piece is `1 - X` which is uniformly distributed on `[1/2, 1]` with midpoint `3/4` (and identically on `[1/2, 1]`)."
        ),
        QuizQuestion(
            id = "lr_adv_96",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If a stick of length `1` is broken at TWO independent points chosen uniformly at random along `[0, 1]`, what is the probability that the three resulting pieces can form a valid triangle (satisfying the triangle inequality where no piece has length `>= 1/2`)?",
            options = listOf(
                QuestionOption("a", "1/4 (`25%`)"),
                QuestionOption("b", "1/2 (`50%`)"),
                QuestionOption("c", "1/3 (`33.3%`)"),
                QuestionOption("d", "1/8 (`12.5%`)")
            ),
            correctOptionId = "a",
            explanation = "Three pieces summing to 1 form a triangle iff each piece `< 1/2`, which requires the two cut points `X` and `Y` to lie on opposite sides of `1/2` (`prob 1/2`) AND have `|X - Y| < 1/2` (`prob 1/2` given opposite sides): `(1/2) * (1/2) = 1/4`."
        ),
        QuizQuestion(
            id = "lr_adv_97",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Benford's Law` (the First-Digit Law observed in many real-world multi-order-of-magnitude datasets like city populations, financial ledgers, and file sizes), which leading digit (`1` through `9`) occurs most frequently?",
            options = listOf(
                QuestionOption("a", "All digits `1` through `9` occur equally often (`11.1%` each)"),
                QuestionOption("b", "The digit `5` occurs most frequently"),
                QuestionOption("c", "The digit `9` occurs most frequently"),
                QuestionOption("d", "The digit `1` (occurring about `log10(1 + 1/1) ≈ 30.1%` of the time, while `9` occurs only `log10(1 + 1/9) ≈ 4.6%` of the time)!")
            ),
            correctOptionId = "d",
            explanation = "Because multiplicative growth spends `log10(2) - log10(1) ≈ 30.1%` of each decade order of magnitude between `1.0x` and `2.0x`, leading digit `1` appears ~30.1% of the time."
        ),
        QuizQuestion(
            id = "lr_adv_98",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Braess's Paradox` for road traffic and communication networks, what counterintuitive phenomenon can occur when a new high-capacity shortcut link is ADDED to a network where users selfishly choose their own shortest route (Nash Equilibrium)?",
            options = listOf(
                QuestionOption("a", "Traffic disappears completely"),
                QuestionOption("b", "Only the slowest route gets faster"),
                QuestionOption("c", "Adding the shortcut can INCREASE the travel time (latency) for EVERY single user at the new Nash Equilibrium compared to when the shortcut did not exist!"),
                QuestionOption("d", "Adding a link always strictly decreases travel time for everyone")
            ),
            correctOptionId = "c",
            explanation = "When selfish routing shifts everyone onto a shared bottleneck feeder to use the shortcut, the Nash Equilibrium degrades compared to the socially optimal flow."
        ),
        QuizQuestion(
            id = "lr_adv_99",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `Prisoner's Dilemma` (non-cooperative game theory), why do two purely self-interested rational players in a single-shot game both choose to `Defect` even though mutual `Cooperation` yields a better payoff for both?",
            options = listOf(
                QuestionOption("a", "Because the payoffs are random"),
                QuestionOption("b", "Because `Defect` is a `Strictly Dominant Strategy` for each player individually (regardless of whether the other player Cooperates or Defects, Defecting yields a higher individual payoff), making `(Defect, Defect)` the unique Nash Equilibrium!"),
                QuestionOption("c", "Because players are not allowed to Cooperate by the rules"),
                QuestionOption("d", "Because `(Cooperate, Cooperate)` is the unique Nash Equilibrium")
            ),
            correctOptionId = "b",
            explanation = "This illustrates the divergence between individual rationality (Nash Equilibrium `(Defect, Defect)`) and collective Pareto optimality (`(Cooperate, Cooperate)`)."
        ),
        QuizQuestion(
            id = "lr_adv_100",
            category = QuizCategory.LOGICAL_REASONING,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `100 Prisoners and a Lightbulb` or the `Blue-Eyed Islanders` common-knowledge induction puzzle with `k` blue-eyed islanders, why does the public announcement 'At least one of you has blue eyes' trigger a deduction on Day `k` even though everyone already saw `>= k - 1` blue-eyed people?",
            options = listOf(
                QuestionOption("a", "The announcement transforms mutual knowledge ('everyone knows') into `Common Knowledge` ('everyone knows that everyone knows...'), anchoring the base case `k = 1` on Day 1 so induction proceeds up to `k` on Day `k`!"),
                QuestionOption("b", "Because the islanders could not count before the announcement"),
                QuestionOption("c", "They all leave on Day 1 regardless of `k`"),
                QuestionOption("d", "It is a trick question and no one ever leaves")
            ),
            correctOptionId = "a",
            explanation = "For `k = 2`, Person A knew B had blue eyes, and B knew A had blue eyes, but before the public announcement A did NOT know that B knew someone had blue eyes! The public announcement creates the shared common-knowledge induction base."
        )
    )

}
