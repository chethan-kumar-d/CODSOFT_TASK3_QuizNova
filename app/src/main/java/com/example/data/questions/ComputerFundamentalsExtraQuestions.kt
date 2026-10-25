package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object ComputerFundamentalsExtraQuestions {
    val questions: List<QuizQuestion> by lazy {
        foundationBatch1() + foundationBatch2() +
            appliedBatch1() + appliedBatch2() +
            advancedBatch1() + advancedBatch2()
    }

    private fun foundationBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "cs_f_16",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How many bits are in 1 standard byte in modern computer architecture?",
            options = listOf(
                QuestionOption("a", "8 bits"),
                QuestionOption("b", "4 bits"),
                QuestionOption("c", "16 bits"),
                QuestionOption("d", "32 bits")
            ),
            correctOptionId = "a",
            explanation = "A standard byte (octet) consists of 8 binary bits."
        ),
        QuizQuestion(
            id = "cs_f_17",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is a group of 4 bits (half of a byte, capable of representing a single hexadecimal digit `0`–`F`) called?",
            options = listOf(
                QuestionOption("a", "A word"),
                QuestionOption("b", "A sector"),
                QuestionOption("c", "A frame"),
                QuestionOption("d", "A nibble")
            ),
            correctOptionId = "d",
            explanation = "A 4-bit unit is called a nibble and maps directly to one hexadecimal digit (2^4 = 16 values)."
        ),
        QuizQuestion(
            id = "cs_f_18",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the decimal value of the unsigned 8-bit binary number `01010110`?",
            options = listOf(
                QuestionOption("a", "78"),
                QuestionOption("b", "84"),
                QuestionOption("c", "86"),
                QuestionOption("d", "92")
            ),
            correctOptionId = "c",
            explanation = "`01010110` in base 2 equals 64 + 16 + 4 + 2 = 86 in decimal."
        ),
        QuizQuestion(
            id = "cs_f_19",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the binary representation of the decimal number `37` in 8-bit unsigned binary?",
            options = listOf(
                QuestionOption("a", "00110001"),
                QuestionOption("b", "00100101"),
                QuestionOption("c", "00101001"),
                QuestionOption("d", "00010101")
            ),
            correctOptionId = "b",
            explanation = "37 = 32 + 4 + 1 = 00100101 in binary."
        ),
        QuizQuestion(
            id = "cs_f_20",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the decimal value of the hexadecimal number `0x2F`?",
            options = listOf(
                QuestionOption("a", "47"),
                QuestionOption("b", "37"),
                QuestionOption("c", "45"),
                QuestionOption("d", "63")
            ),
            correctOptionId = "a",
            explanation = "2 * 16 + 15 = 32 + 15 = 47."
        ),
        QuizQuestion(
            id = "cs_f_21",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the hexadecimal representation of the binary byte `10110110`?",
            options = listOf(
                QuestionOption("a", "0xA6"),
                QuestionOption("b", "0xB5"),
                QuestionOption("c", "0xC6"),
                QuestionOption("d", "0xB6")
            ),
            correctOptionId = "d",
            explanation = "`1011` is 11 (`B`) and `0110` is 6 (`6`), giving `0xB6`."
        ),
        QuizQuestion(
            id = "cs_f_22",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the octal (base-8) representation of the binary number `011 101 010`?",
            options = listOf(
                QuestionOption("a", "752"),
                QuestionOption("b", "253"),
                QuestionOption("c", "352"),
                QuestionOption("d", "362")
            ),
            correctOptionId = "c",
            explanation = "`011` = 3, `101` = 5, `010` = 2, so in base 8 it is `352`."
        ),
        QuizQuestion(
            id = "cs_f_23",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In an 8-bit unsigned integer, what is the range of representable decimal values?",
            options = listOf(
                QuestionOption("a", "1 to 255"),
                QuestionOption("b", "0 to 255"),
                QuestionOption("c", "-128 to 127"),
                QuestionOption("d", "0 to 256")
            ),
            correctOptionId = "b",
            explanation = "With 8 unsigned bits, there are 2^8 = 256 values ranging from 0 to 255."
        ),
        QuizQuestion(
            id = "cs_f_24",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In 8-bit two's complement signed representation, what is the range of representable decimal integers?",
            options = listOf(
                QuestionOption("a", "-128 to 127"),
                QuestionOption("b", "-127 to 128"),
                QuestionOption("c", "-255 to 255"),
                QuestionOption("d", "0 to 255")
            ),
            correctOptionId = "a",
            explanation = "An n-bit two's complement integer covers -2^(n-1) to 2^(n-1) - 1, which for n=8 is -128 to 127."
        ),
        QuizQuestion(
            id = "cs_f_25",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How do you compute the two's complement negation of a binary number?",
            options = listOf(
                QuestionOption("a", "Invert only the most significant bit"),
                QuestionOption("b", "Shift all bits left by 1"),
                QuestionOption("c", "Subtract 1 from the unsigned value"),
                QuestionOption("d", "Invert all the bits (one's complement) and add 1")
            ),
            correctOptionId = "d",
            explanation = "Two's complement negation is computed as `~x + 1`."
        ),
        QuizQuestion(
            id = "cs_f_26",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In 8-bit two's complement, what decimal value does `11111111` represent?",
            options = listOf(
                QuestionOption("a", "-127"),
                QuestionOption("b", "255"),
                QuestionOption("c", "-1"),
                QuestionOption("d", "-128")
            ),
            correctOptionId = "c",
            explanation = "Inverting `11111111` gives `00000000`, plus 1 is `1`, so `11111111` represents `-1`."
        ),
        QuizQuestion(
            id = "cs_f_27",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which boolean logic gate outputs `1` (TRUE) if and only if ALL of its inputs are `1`?",
            options = listOf(
                QuestionOption("a", "NAND"),
                QuestionOption("b", "AND"),
                QuestionOption("c", "OR"),
                QuestionOption("d", "XOR")
            ),
            correctOptionId = "b",
            explanation = "The AND gate outputs 1 only when every input is 1."
        ),
        QuizQuestion(
            id = "cs_f_28",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which boolean logic gate outputs `1` when its two inputs are DIFFERENT (`0,1` or `1,0`) and `0` when they are the SAME?",
            options = listOf(
                QuestionOption("a", "XOR (Exclusive OR)"),
                QuestionOption("b", "XNOR"),
                QuestionOption("c", "OR"),
                QuestionOption("d", "AND")
            ),
            correctOptionId = "a",
            explanation = "XOR returns 1 when an odd number of inputs are 1 (i.e., when two inputs differ)."
        ),
        QuizQuestion(
            id = "cs_f_29",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which two logic gates are known as 'universal gates' because any boolean function can be constructed using only gates of that single type?",
            options = listOf(
                QuestionOption("a", "AND and OR"),
                QuestionOption("b", "XOR and NOT"),
                QuestionOption("c", "AND and XOR"),
                QuestionOption("d", "NAND and NOR")
            ),
            correctOptionId = "d",
            explanation = "Both NAND and NOR are functionally complete (universal) logic gates."
        ),
        QuizQuestion(
            id = "cs_f_30",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "According to De Morgan's Law, what is the boolean expression `NOT (A AND B)` equivalent to?",
            options = listOf(
                QuestionOption("a", "A OR B"),
                QuestionOption("b", "NOT A XOR B"),
                QuestionOption("c", "(NOT A) OR (NOT B)"),
                QuestionOption("d", "(NOT A) AND (NOT B)")
            ),
            correctOptionId = "c",
            explanation = "De Morgan's laws state that `!(A && B) == (!A || !B)` and `!(A || B) == (!A && !B)`."
        ),
        QuizQuestion(
            id = "cs_f_31",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In CPU architecture, what does `ALU` stand for?",
            options = listOf(
                QuestionOption("a", "Application Layer Unit"),
                QuestionOption("b", "Arithmetic Logic Unit"),
                QuestionOption("c", "Address Lookup Unit"),
                QuestionOption("d", "Asynchronous Link Utility")
            ),
            correctOptionId = "b",
            explanation = "The ALU performs integer arithmetic (addition, subtraction) and bitwise/logical operations."
        ),
        QuizQuestion(
            id = "cs_f_32",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a CPU, what is the role of the `Program Counter (PC)` (or Instruction Pointer) register?",
            options = listOf(
                QuestionOption("a", "It holds the memory address of the next instruction to be fetched and executed"),
                QuestionOption("b", "It counts the total number of programs installed on the hard drive"),
                QuestionOption("c", "It measures the CPU temperature"),
                QuestionOption("d", "It stores the return value of every function")
            ),
            correctOptionId = "a",
            explanation = "The Program Counter points to the address of the next machine instruction in memory."
        ),
        QuizQuestion(
            id = "cs_f_33",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What are the classic stages of the fundamental CPU instruction execution cycle?",
            options = listOf(
                QuestionOption("a", "Compile -> Link -> Load"),
                QuestionOption("b", "Read -> Sort -> Print"),
                QuestionOption("c", "Boot -> Login -> Shutdown"),
                QuestionOption("d", "Fetch -> Decode -> Execute (and Writeback)")
            ),
            correctOptionId = "d",
            explanation = "The CPU fetches the instruction from memory at PC, decodes the opcode/operands, executes it, and writes back results."
        ),
        QuizQuestion(
            id = "cs_f_34",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which type of computer memory is volatile (loses its stored data when power is turned off) and serves as the main working memory for running programs?",
            options = listOf(
                QuestionOption("a", "NVMe SSD (Solid State Drive)"),
                QuestionOption("b", "Magnetic Hard Disk"),
                QuestionOption("c", "RAM (Random Access Memory)"),
                QuestionOption("d", "ROM (Read-Only Memory)")
            ),
            correctOptionId = "c",
            explanation = "DRAM/SRAM used for main memory and CPU caches are volatile, losing contents when power is removed."
        ),
        QuizQuestion(
            id = "cs_f_35",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In the computer memory hierarchy, which storage level is the fastest and physically closest to the CPU execution cores?",
            options = listOf(
                QuestionOption("a", "L3 Cache"),
                QuestionOption("b", "CPU Registers (followed by L1 Cache)"),
                QuestionOption("c", "Main RAM (DRAM)"),
                QuestionOption("d", "NVMe SSD")
            ),
            correctOptionId = "b",
            explanation = "Hierarchy from fastest/smallest to slowest/largest: Registers -> L1 -> L2 -> L3 Cache -> Main RAM -> SSD/Disk."
        ),
        QuizQuestion(
            id = "cs_f_36",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary difference between `SRAM` (Static RAM) and `DRAM` (Dynamic RAM)?",
            options = listOf(
                QuestionOption("a", "SRAM uses flip-flop latches (faster, no refresh needed, used for CPU caches), whereas DRAM uses capacitors that must be periodically refreshed (denser, used for main RAM)"),
                QuestionOption("b", "DRAM is faster than SRAM and used for CPU registers"),
                QuestionOption("c", "SRAM is non-volatile and keeps data without power"),
                QuestionOption("d", "DRAM can only be written once")
            ),
            correctOptionId = "a",
            explanation = "SRAM is fast and expensive per bit (ideal for L1/L2/L3 caches); DRAM uses 1 transistor + 1 capacitor per bit (ideal for high-capacity main memory)."
        ),
        QuizQuestion(
            id = "cs_f_37",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which linear data structure follows the `LIFO` (Last-In, First-Out) principle?",
            options = listOf(
                QuestionOption("a", "Queue"),
                QuestionOption("b", "Singly Linked List"),
                QuestionOption("c", "Min-Heap"),
                QuestionOption("d", "Stack")
            ),
            correctOptionId = "d",
            explanation = "A Stack pushes and pops elements from the top, so the most recently added item is removed first (LIFO)."
        ),
        QuizQuestion(
            id = "cs_f_38",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which linear data structure follows the `FIFO` (First-In, First-Out) principle?",
            options = listOf(
                QuestionOption("a", "Binary Search Tree"),
                QuestionOption("b", "Hash Set"),
                QuestionOption("c", "Queue"),
                QuestionOption("d", "Stack")
            ),
            correctOptionId = "c",
            explanation = "A Queue enqueues at the rear and dequeues from the front, serving items in arrival order (FIFO)."
        ),
        QuizQuestion(
            id = "cs_f_39",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What are the two fundamental operations of a `Stack` abstract data type?",
            options = listOf(
                QuestionOption("a", "hash and rehash"),
                QuestionOption("b", "push (insert at top) and pop (remove from top)"),
                QuestionOption("c", "enqueue and dequeue"),
                QuestionOption("d", "insertLeft and deleteRight")
            ),
            correctOptionId = "b",
            explanation = "Stacks support `push`, `pop`, and `peek`/`top` in O(1) time."
        ),
        QuizQuestion(
            id = "cs_f_40",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the time complexity of accessing the `i`-th element (`arr[i]`) in a contiguous array of size `n`?",
            options = listOf(
                QuestionOption("a", "O(1)"),
                QuestionOption("b", "O(log n)"),
                QuestionOption("c", "O(n)"),
                QuestionOption("d", "O(n log n)")
            ),
            correctOptionId = "a",
            explanation = "Because array elements are stored contiguously in memory, the address `base + i * element_size` is computed in O(1) constant time."
        ),
        QuizQuestion(
            id = "cs_f_41",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the worst-case time complexity of searching for a value in an unsorted singly linked list of `n` nodes?",
            options = listOf(
                QuestionOption("a", "O(1)"),
                QuestionOption("b", "O(log n)"),
                QuestionOption("c", "O(n^2)"),
                QuestionOption("d", "O(n)")
            ),
            correctOptionId = "d",
            explanation = "In a linked list, you must traverse nodes sequentially from `head`, taking up to O(n) steps."
        ),
        QuizQuestion(
            id = "cs_f_42",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the time complexity of inserting a new node at the very beginning (`head`) of a singly linked list?",
            options = listOf(
                QuestionOption("a", "O(log n)"),
                QuestionOption("b", "O(n log n)"),
                QuestionOption("c", "O(1)"),
                QuestionOption("d", "O(n)")
            ),
            correctOptionId = "c",
            explanation = "Pointing `newNode.next = head` and updating `head = newNode` takes constant O(1) time."
        ),
        QuizQuestion(
            id = "cs_f_43",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What precondition MUST be satisfied before you can run `Binary Search` on an array?",
            options = listOf(
                QuestionOption("a", "The array must be stored as a linked list"),
                QuestionOption("b", "The array must be sorted according to the search key"),
                QuestionOption("c", "The array size must be a prime number"),
                QuestionOption("d", "All elements in the array must be positive integers")
            ),
            correctOptionId = "b",
            explanation = "Binary search relies on sorted order to eliminate half of the remaining search space on each comparison."
        ),
        QuizQuestion(
            id = "cs_f_44",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "At most how many comparisons does `Binary Search` need to find an element (or determine it is absent) in a sorted array of `1,024` (`2^10`) elements?",
            options = listOf(
                QuestionOption("a", "11 (roughly log2(1024) + 1)"),
                QuestionOption("b", "512"),
                QuestionOption("c", "1,024"),
                QuestionOption("d", "100")
            ),
            correctOptionId = "a",
            explanation = "Each step halves the interval: 1024 -> 512 -> 256 -> ... -> 1, requiring at most floor(log2(1024)) + 1 = 11 comparisons."
        ),
        QuizQuestion(
            id = "cs_f_45",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `Binary Tree`, what is the maximum number of children any single node can have?",
            options = listOf(
                QuestionOption("a", "Exactly 2 for every node"),
                QuestionOption("b", "Unlimited children"),
                QuestionOption("c", "At most 4"),
                QuestionOption("d", "At most 2 (a left child and a right child)")
            ),
            correctOptionId = "d",
            explanation = "By definition, each node in a binary tree has at most two children."
        ),
        QuizQuestion(
            id = "cs_f_46",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is a `Leaf Node` in a tree data structure?",
            options = listOf(
                QuestionOption("a", "A node with two children"),
                QuestionOption("b", "A node that stores the value 0"),
                QuestionOption("c", "A node that has no children (degree 0)"),
                QuestionOption("d", "The topmost node of the tree")
            ),
            correctOptionId = "c",
            explanation = "Leaf (external) nodes are terminal nodes with no child pointers."
        ),
        QuizQuestion(
            id = "cs_f_47",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `Binary Search Tree (BST)`, what ordering invariant holds for every node `N`?",
            options = listOf(
                QuestionOption("a", "Keys are stored in insertion order from left to right"),
                QuestionOption("b", "All keys in `N`'s left subtree are less than `N.key`, and all keys in `N`'s right subtree are greater than `N.key`"),
                QuestionOption("c", "Every parent key is smaller than both of its children's keys"),
                QuestionOption("d", "Left and right subtrees always have the exact same height")
            ),
            correctOptionId = "b",
            explanation = "The BST property places smaller keys in the left subtree and larger keys in the right subtree."
        ),
        QuizQuestion(
            id = "cs_f_48",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which traversal of a `Binary Search Tree (BST)` visits the keys in sorted non-decreasing order?",
            options = listOf(
                QuestionOption("a", "In-order traversal (Left -> Root -> Right)"),
                QuestionOption("b", "Pre-order traversal (Root -> Left -> Right)"),
                QuestionOption("c", "Post-order traversal (Left -> Right -> Root)"),
                QuestionOption("d", "Level-order (Breadth-First) traversal")
            ),
            correctOptionId = "a",
            explanation = "In-order traversal visits all smaller keys (Left), then the node itself (Root), then all larger keys (Right)."
        ),
        QuizQuestion(
            id = "cs_f_49",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `Pre-order` traversal of a binary tree, in what order are a node and its subtrees visited?",
            options = listOf(
                QuestionOption("a", "Left subtree -> Root -> Right subtree"),
                QuestionOption("b", "Left subtree -> Right subtree -> Root"),
                QuestionOption("c", "Right subtree -> Root -> Left subtree"),
                QuestionOption("d", "Root -> Left subtree -> Right subtree")
            ),
            correctOptionId = "d",
            explanation = "Pre-order visits the current root node first before recursively traversing its left and right subtrees."
        ),
        QuizQuestion(
            id = "cs_f_50",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `Post-order` traversal of a binary tree, in what order are a node and its subtrees visited?",
            options = listOf(
                QuestionOption("a", "Left subtree -> Root -> Right subtree"),
                QuestionOption("b", "Root -> Right subtree -> Left subtree"),
                QuestionOption("c", "Left subtree -> Right subtree -> Root"),
                QuestionOption("d", "Root -> Left subtree -> Right subtree")
            ),
            correctOptionId = "c",
            explanation = "Post-order visits a node only after both its left and right subtrees have been completely visited (useful for computing subtree sizes or freeing nodes)."
        ),
        QuizQuestion(
            id = "cs_f_51",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which auxiliary data structure is standardly used to implement `Breadth-First Search (BFS)` (level-order traversal) on a graph or tree?",
            options = listOf(
                QuestionOption("a", "A Priority Queue with random weights"),
                QuestionOption("b", "A FIFO Queue"),
                QuestionOption("c", "A LIFO Stack"),
                QuestionOption("d", "A Binary Search Tree")
            ),
            correctOptionId = "b",
            explanation = "BFS explores vertices in waves by distance from the source using a FIFO queue."
        ),
        QuizQuestion(
            id = "cs_f_52",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which auxiliary data structure (or call mechanism) is used by `Depth-First Search (DFS)` on a graph or tree?",
            options = listOf(
                QuestionOption("a", "A LIFO Stack (either the recursion call stack or an explicit stack)"),
                QuestionOption("b", "A FIFO Queue"),
                QuestionOption("c", "A Hash Table only"),
                QuestionOption("d", "A Circular Buffer")
            ),
            correctOptionId = "a",
            explanation = "DFS plunges deep along a path and backtracks using a LIFO stack (or recursion)."
        ),
        QuizQuestion(
            id = "cs_f_53",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `Min-Heap` priority queue, where is the smallest element always located?",
            options = listOf(
                QuestionOption("a", "At the rightmost leaf node"),
                QuestionOption("b", "In the middle of the array"),
                QuestionOption("c", "At a random leaf"),
                QuestionOption("d", "At the root of the heap (accessible in O(1) peek time)")
            ),
            correctOptionId = "d",
            explanation = "The Min-Heap property ensures every parent is `<=` its children, so the global minimum is always at the root."
        ),
        QuizQuestion(
            id = "cs_f_54",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the average-case time complexity of lookup, insertion, and deletion in a well-sized `Hash Table` with a good hash function?",
            options = listOf(
                QuestionOption("a", "O(n)"),
                QuestionOption("b", "O(n log n)"),
                QuestionOption("c", "O(1)"),
                QuestionOption("d", "O(log n)")
            ),
            correctOptionId = "c",
            explanation = "With a uniform hash function and bounded load factor, hash table operations run in O(1) expected time."
        ),
        QuizQuestion(
            id = "cs_f_55",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a Hash Table, what is a `Hash Collision`?",
            options = listOf(
                QuestionOption("a", "When a key is NULL"),
                QuestionOption("b", "When two distinct keys produce the same hash bucket index"),
                QuestionOption("c", "When two threads write to the same CPU register"),
                QuestionOption("d", "When a hash table runs out of RAM")
            ),
            correctOptionId = "b",
            explanation = "Since the space of possible keys is larger than the number of table buckets (Pigeonhole Principle), distinct keys can map to the same index."
        ),
        QuizQuestion(
            id = "cs_f_56",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Operating Systems, what is the fundamental difference between a `Program` and a `Process`?",
            options = listOf(
                QuestionOption("a", "A program is a passive executable file on disk, whereas a process is an active instance of a program in execution with its own memory space and OS state"),
                QuestionOption("b", "A process is stored on disk and a program only exists in CPU registers"),
                QuestionOption("c", "There is no difference; they are synonyms"),
                QuestionOption("d", "A program can only have one line of code")
            ),
            correctOptionId = "a",
            explanation = "A process is a running instance of a program, complete with its address space, program counter, registers, and open file descriptors."
        ),
        QuizQuestion(
            id = "cs_f_57",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Within a single Operating System process, what do multiple `Threads` share with each other, and what does each thread have privately?",
            options = listOf(
                QuestionOption("a", "Threads share nothing at all"),
                QuestionOption("b", "Threads share the same stack and program counter, but have separate heaps"),
                QuestionOption("c", "Each thread runs in a separate virtual machine on disk"),
                QuestionOption("d", "Threads share the process's code, global data, and heap memory, while each thread has its own private stack and CPU register state (including Program Counter)")
            ),
            correctOptionId = "d",
            explanation = "Sharing the address space (heap/globals) makes inter-thread communication fast, while private stacks and PCs allow independent execution flows."
        ),
        QuizQuestion(
            id = "cs_f_58",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In an Operating System, what is a `Context Switch`?",
            options = listOf(
                QuestionOption("a", "Rebooting the operating system"),
                QuestionOption("b", "Compiling source code into machine code"),
                QuestionOption("c", "Saving the CPU state (registers, PC, stack pointer) of the currently running process/thread and restoring the saved state of the next scheduled process/thread"),
                QuestionOption("d", "Switching the computer monitor from dark mode to light mode")
            ),
            correctOptionId = "c",
            explanation = "Context switching allows a single CPU core to time-share execution across multiple processes and threads."
        )
    )

    private fun foundationBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "cs_f_59",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is `Virtual Memory` in modern operating systems?",
            options = listOf(
                QuestionOption("a", "A folder of temporary text files"),
                QuestionOption("b", "An abstraction that gives each process the illusion of its own private, contiguous address space, mapped to physical RAM pages (and disk swap) by the OS and hardware MMU"),
                QuestionOption("c", "Extra memory downloaded from the internet"),
                QuestionOption("d", "Memory stored inside the GPU only")
            ),
            correctOptionId = "b",
            explanation = "Virtual memory isolates processes from each other and maps virtual pages to physical frames via page tables and the MMU."
        ),
        QuizQuestion(
            id = "cs_f_60",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Operating Systems, what is a `System Call` (syscall)?",
            options = listOf(
                QuestionOption("a", "A controlled programmatic interface through which a user-space application requests a privileged service from the OS kernel (such as file I/O, networking, or process creation)"),
                QuestionOption("b", "A function call between two normal functions in the same user class"),
                QuestionOption("c", "A voice call made over the internet"),
                QuestionOption("d", "A hardware interrupt from the power button")
            ),
            correctOptionId = "a",
            explanation = "System calls transition the CPU from unprivileged user mode to privileged kernel mode to safely perform OS operations."
        ),
        QuizQuestion(
            id = "cs_f_61",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In computer networking, how many layers are in the classic `OSI (Open Systems Interconnection)` reference model?",
            options = listOf(
                QuestionOption("a", "4 layers"),
                QuestionOption("b", "3 layers"),
                QuestionOption("c", "10 layers"),
                QuestionOption("d", "7 layers (Physical, Data Link, Network, Transport, Session, Presentation, Application)")
            ),
            correctOptionId = "d",
            explanation = "The 7 OSI layers from bottom to top are: 1-Physical, 2-Data Link, 3-Network, 4-Transport, 5-Session, 6-Presentation, 7-Application."
        ),
        QuizQuestion(
            id = "cs_f_62",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "At which layer of the OSI model do `IP (Internet Protocol)` addresses and packet routing operate?",
            options = listOf(
                QuestionOption("a", "Layer 2 — Data Link Layer"),
                QuestionOption("b", "Layer 7 — Application Layer"),
                QuestionOption("c", "Layer 3 — Network Layer"),
                QuestionOption("d", "Layer 1 — Physical Layer")
            ),
            correctOptionId = "c",
            explanation = "IP addressing and inter-network packet routing belong to Layer 3 (Network Layer)."
        ),
        QuizQuestion(
            id = "cs_f_63",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "At which layer of the OSI model do `TCP` and `UDP` operate?",
            options = listOf(
                QuestionOption("a", "Layer 7 — Application Layer"),
                QuestionOption("b", "Layer 4 — Transport Layer"),
                QuestionOption("c", "Layer 2 — Data Link Layer"),
                QuestionOption("d", "Layer 3 — Network Layer")
            ),
            correctOptionId = "b",
            explanation = "TCP and UDP provide host-to-host port addressing and transport semantics at Layer 4."
        ),
        QuizQuestion(
            id = "cs_f_64",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "At which layer of the OSI model do `MAC (Media Access Control)` addresses and Ethernet frames operate?",
            options = listOf(
                QuestionOption("a", "Layer 2 — Data Link Layer"),
                QuestionOption("b", "Layer 3 — Network Layer"),
                QuestionOption("c", "Layer 4 — Transport Layer"),
                QuestionOption("d", "Layer 7 — Application Layer")
            ),
            correctOptionId = "a",
            explanation = "Ethernet frames and hardware MAC addresses operate at Layer 2 (Data Link Layer)."
        ),
        QuizQuestion(
            id = "cs_f_65",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the key difference between `TCP` and `UDP`?",
            options = listOf(
                QuestionOption("a", "UDP guarantees ordered delivery while TCP drops packets randomly"),
                QuestionOption("b", "TCP is used only for local cables while UDP is used for Wi-Fi"),
                QuestionOption("c", "UDP requires a 3-way handshake before sending data"),
                QuestionOption("d", "TCP is connection-oriented, reliable, and guarantees ordered byte-stream delivery with congestion/flow control; UDP is connectionless and sends best-effort datagrams with minimal overhead")
            ),
            correctOptionId = "d",
            explanation = "TCP provides reliability, ordering, and retransmission; UDP provides low-latency, connectionless datagrams (popular for DNS, live media, and gaming)."
        ),
        QuizQuestion(
            id = "cs_f_66",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What are the three packets exchanged during a standard `TCP 3-Way Handshake` to establish a connection?",
            options = listOf(
                QuestionOption("a", "PING -> PONG -> DONE"),
                QuestionOption("b", "FIN -> ACK -> RST"),
                QuestionOption("c", "SYN -> SYN-ACK -> ACK"),
                QuestionOption("d", "GET -> POST -> 200 OK")
            ),
            correctOptionId = "c",
            explanation = "The client sends SYN, the server replies with SYN-ACK, and the client acknowledges with ACK."
        ),
        QuizQuestion(
            id = "cs_f_67",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary purpose of `DNS (Domain Name System)` on the Internet?",
            options = listOf(
                QuestionOption("a", "To compress video files"),
                QuestionOption("b", "To translate human-readable domain names (like `example.com`) into numerical IP addresses (like `93.184.216.34` or IPv6)"),
                QuestionOption("c", "To encrypt HTTP traffic with TLS certificates"),
                QuestionOption("d", "To assign MAC addresses to network cards")
            ),
            correctOptionId = "b",
            explanation = "DNS acts as the phonebook of the Internet, resolving domain names to IP addresses."
        ),
        QuizQuestion(
            id = "cs_f_68",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How many bits are in an `IPv4` address vs. an `IPv6` address?",
            options = listOf(
                QuestionOption("a", "IPv4 is 32 bits (4 bytes); IPv6 is 128 bits (16 bytes)"),
                QuestionOption("b", "IPv4 is 16 bits; IPv6 is 64 bits"),
                QuestionOption("c", "IPv4 is 64 bits; IPv6 is 128 bits"),
                QuestionOption("d", "IPv4 is 32 bits; IPv6 is 256 bits")
            ),
            correctOptionId = "a",
            explanation = "IPv4 uses 32-bit addresses (e.g., `192.168.1.1`), whereas IPv6 uses 128-bit addresses to provide a vastly larger address space."
        ),
        QuizQuestion(
            id = "cs_f_69",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which standard IPv4 address is reserved as the local `loopback` address (`localhost`)?",
            options = listOf(
                QuestionOption("a", "192.168.0.1"),
                QuestionOption("b", "255.255.255.255"),
                QuestionOption("c", "0.0.0.0"),
                QuestionOption("d", "127.0.0.1 (and `::1` in IPv6)")
            ),
            correctOptionId = "d",
            explanation = "127.0.0.1 routes traffic back to the local host's own network stack without leaving the machine."
        ),
        QuizQuestion(
            id = "cs_f_70",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What are the standard default TCP port numbers for `HTTP` and `HTTPS`?",
            options = listOf(
                QuestionOption("a", "HTTP uses port 53; HTTPS uses port 8080"),
                QuestionOption("b", "HTTP uses port 21; HTTPS uses port 3306"),
                QuestionOption("c", "HTTP uses port 80; HTTPS uses port 443"),
                QuestionOption("d", "HTTP uses port 22; HTTPS uses port 25")
            ),
            correctOptionId = "c",
            explanation = "Port 80 is standard for unencrypted HTTP, and port 443 is standard for TLS-encrypted HTTPS."
        ),
        QuizQuestion(
            id = "cs_f_71",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In HTTP, what do the status code classes `2xx`, `4xx`, and `5xx` represent?",
            options = listOf(
                QuestionOption("a", "All three represent network cable failure"),
                QuestionOption("b", "2xx = Success (e.g., 200 OK), 4xx = Client Error (e.g., 404 Not Found), 5xx = Server Error (e.g., 500 Internal Server Error)"),
                QuestionOption("c", "2xx = Client Error, 4xx = Success, 5xx = Redirect"),
                QuestionOption("d", "2xx = Redirect, 4xx = Server Error, 5xx = Success")
            ),
            correctOptionId = "b",
            explanation = "1xx = Informational, 2xx = Success, 3xx = Redirection, 4xx = Client Error, 5xx = Server Error."
        ),
        QuizQuestion(
            id = "cs_f_72",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In HTTP, which request method is designed to be `safe` and `idempotent` for retrieving a resource without causing server-side state modifications?",
            options = listOf(
                QuestionOption("a", "GET"),
                QuestionOption("b", "POST"),
                QuestionOption("c", "PATCH"),
                QuestionOption("d", "CONNECT")
            ),
            correctOptionId = "a",
            explanation = "GET requests retrieve data only and should have no side effects on server state."
        ),
        QuizQuestion(
            id = "cs_f_73",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the role of a `Compiler` vs. an `Interpreter`?",
            options = listOf(
                QuestionOption("a", "An interpreter produces a standalone `.exe` binary file without running it"),
                QuestionOption("b", "A compiler only checks spelling in comments"),
                QuestionOption("c", "An interpreter only works on assembly language"),
                QuestionOption("d", "A compiler translates high-level source code into machine code or bytecode ahead of execution, whereas an interpreter executes instructions directly statement by statement")
            ),
            correctOptionId = "d",
            explanation = "Compilers translate entire compilation units ahead of time (or JIT at runtime), while interpreters evaluate source or AST/bytecode directly."
        ),
        QuizQuestion(
            id = "cs_f_74",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In character encoding, why was `UTF-8` (Unicode) adopted globally to replace legacy 7-bit `ASCII`?",
            options = listOf(
                QuestionOption("a", "ASCII could not represent English uppercase letters"),
                QuestionOption("b", "UTF-8 only supports numbers"),
                QuestionOption("c", "UTF-8 is backward-compatible with 7-bit ASCII (using 1 byte for ASCII characters `0–127`) while using 1 to 4 bytes to represent over a million Unicode characters across all world languages and symbols"),
                QuestionOption("d", "UTF-8 uses fixed 8-byte characters for every letter")
            ),
            correctOptionId = "c",
            explanation = "UTF-8 is a variable-width encoding (1–4 bytes per code point) whose first 128 code points are byte-for-byte identical to ASCII."
        ),
        QuizQuestion(
            id = "cs_f_75",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ASCII / UTF-8, what are the decimal code values for `'0'`, `'A'`, and `'a'`?",
            options = listOf(
                QuestionOption("a", "'0' = 48, 'A' = 97, 'a' = 65"),
                QuestionOption("b", "'0' = 48, 'A' = 65, 'a' = 97"),
                QuestionOption("c", "'0' = 0, 'A' = 1, 'a' = 27"),
                QuestionOption("d", "'0' = 32, 'A' = 50, 'a' = 100")
            ),
            correctOptionId = "b",
            explanation = "In ASCII/Unicode: digits `'0'`–`'9'` are 48–57, uppercase `'A'`–`'Z'` are 65–90, and lowercase `'a'`–`'z'` are 97–122 (differing from uppercase by bit 5 = 32)."
        ),
        QuizQuestion(
            id = "cs_f_76",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a Doubly Linked List, what references does each node store compared to a Singly Linked List node?",
            options = listOf(
                QuestionOption("a", "Both a `next` pointer to the successor node AND a `prev` pointer to the predecessor node"),
                QuestionOption("b", "Only a pointer to the middle of the list"),
                QuestionOption("c", "An array of all other nodes"),
                QuestionOption("d", "Only a `prev` pointer and no `next` pointer")
            ),
            correctOptionId = "a",
            explanation = "Doubly linked nodes store both `prev` and `next`, allowing O(1) bidirectional traversal and O(1) deletion when given a node reference."
        ),
        QuizQuestion(
            id = "cs_f_77",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a graph `G = (V, E)`, what do `V` and `E` represent?",
            options = listOf(
                QuestionOption("a", "`V` is values and `E` is exceptions"),
                QuestionOption("b", "`V` is virtual memory and `E` is execution time"),
                QuestionOption("c", "`V` is variables and `E` is equations"),
                QuestionOption("d", "`V` is the set of vertices (nodes) and `E` is the set of edges (connections between vertices)")
            ),
            correctOptionId = "d",
            explanation = "Graphs are mathematical structures modeled as a set of vertices `V` and edges `E`."
        ),
        QuizQuestion(
            id = "cs_f_78",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between a `Directed Graph (Digraph)` and an `Undirected Graph`?",
            options = listOf(
                QuestionOption("a", "A directed graph cannot contain any cycles"),
                QuestionOption("b", "An undirected graph only stores strings"),
                QuestionOption("c", "In a directed graph, edges have a one-way direction `(u -> v)`; in an undirected graph, edges are bidirectional `{u, v}`"),
                QuestionOption("d", "An undirected graph cannot have more than 3 nodes")
            ),
            correctOptionId = "c",
            explanation = "Directed edges are ordered pairs `(u, v)`, whereas undirected edges are unordered pairs `{u, v}`."
        ),
        QuizQuestion(
            id = "cs_f_79",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is a `Tree` in graph theory?",
            options = listOf(
                QuestionOption("a", "A graph where every node is connected to every other node"),
                QuestionOption("b", "A connected, undirected acyclic graph (with `|V| - 1` edges for `|V|` vertices)"),
                QuestionOption("c", "Any graph that contains at least one cycle"),
                QuestionOption("d", "A disconnected graph with no edges")
            ),
            correctOptionId = "b",
            explanation = "A tree on `n` vertices is connected and has no cycles, which implies it has exactly `n - 1` edges."
        ),
        QuizQuestion(
            id = "cs_f_80",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How many edges does a connected tree with `50` vertices have?",
            options = listOf(
                QuestionOption("a", "49"),
                QuestionOption("b", "50"),
                QuestionOption("c", "51"),
                QuestionOption("d", "25")
            ),
            correctOptionId = "a",
            explanation = "Every tree with `n` vertices has exactly `n - 1` edges (`50 - 1 = 49`)."
        ),
        QuizQuestion(
            id = "cs_f_81",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the worst-case and average-case time complexity of `Merge Sort` on an array of `n` elements?",
            options = listOf(
                QuestionOption("a", "O(n) average and O(n^2) worst case"),
                QuestionOption("b", "O(n^2) in both cases"),
                QuestionOption("c", "O(log n)"),
                QuestionOption("d", "O(n log n) in both worst case and average case")
            ),
            correctOptionId = "d",
            explanation = "Merge Sort always divides the array in half (`log n` levels) and merges in linear `O(n)` time per level, guaranteeing `O(n log n)` time."
        ),
        QuizQuestion(
            id = "cs_f_82",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the best-case time complexity of `Insertion Sort` when the input array of `n` elements is ALREADY sorted?",
            options = listOf(
                QuestionOption("a", "O(n^2)"),
                QuestionOption("b", "O(1)"),
                QuestionOption("c", "O(n)"),
                QuestionOption("d", "O(n log n)")
            ),
            correctOptionId = "c",
            explanation = "On an already-sorted array, each new element in Insertion Sort is compared once with its immediate predecessor and never shifted, taking O(n) total comparisons."
        ),
        QuizQuestion(
            id = "cs_f_83",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does it mean for a sorting algorithm (such as Merge Sort or Insertion Sort) to be `Stable`?",
            options = listOf(
                QuestionOption("a", "The algorithm cannot crash on empty arrays"),
                QuestionOption("b", "Elements with equal sort keys preserve their original relative order from the input"),
                QuestionOption("c", "The algorithm never uses more than 1 KB of memory"),
                QuestionOption("d", "The algorithm runs in O(1) time")
            ),
            correctOptionId = "b",
            explanation = "Stability guarantees that if two records have equal keys and record A appeared before record B in the input, A still appears before B in the output."
        ),
        QuizQuestion(
            id = "cs_f_84",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In recursion, what happens if a recursive function lacks a reachable `Base Case`?",
            options = listOf(
                QuestionOption("a", "It recurses infinitely until the call stack overflows (`StackOverflowError` / segmentation fault)"),
                QuestionOption("b", "The compiler automatically stops it after 3 calls"),
                QuestionOption("c", "It returns `0` immediately"),
                QuestionOption("d", "It converts itself into a `for` loop")
            ),
            correctOptionId = "a",
            explanation = "Every recursive call allocates a new stack frame; without a terminating base case, call stack memory is exhausted."
        ),
        QuizQuestion(
            id = "cs_f_85",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Big-O notation, when analyzing `T(n) = 3n^2 + 100n + 500`, what is its simplified asymptotic time complexity?",
            options = listOf(
                QuestionOption("a", "O(3n^2)"),
                QuestionOption("b", "O(n^3)"),
                QuestionOption("c", "O(100n)"),
                QuestionOption("d", "O(n^2)")
            ),
            correctOptionId = "d",
            explanation = "Big-O drops lower-order terms (`100n + 500`) and constant multiplicative factors (`3`), leaving the dominant term `O(n^2)`."
        ),
        QuizQuestion(
            id = "cs_f_86",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Rank the following growth rates from fastest (smallest asymptotic growth) to slowest (largest growth) as `n -> infinity`: `O(n)`, `O(1)`, `O(2^n)`, `O(log n)`, `O(n log n)`, `O(n^2)`.",
            options = listOf(
                QuestionOption("a", "O(1) < O(n) < O(log n) < O(n log n) < O(2^n) < O(n^2)"),
                QuestionOption("b", "O(2^n) < O(n^2) < O(n log n) < O(n) < O(log n) < O(1)"),
                QuestionOption("c", "O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n)"),
                QuestionOption("d", "O(log n) < O(1) < O(n) < O(n^2) < O(n log n) < O(2^n)")
            ),
            correctOptionId = "c",
            explanation = "Constant < Logarithmic < Linear < Linearithmic < Quadratic < Exponential."
        ),
        QuizQuestion(
            id = "cs_f_87",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the space complexity of an `in-place` algorithm (such as Heap Sort or iterative Binary Search) in terms of auxiliary extra memory?",
            options = listOf(
                QuestionOption("a", "O(2^n) auxiliary space"),
                QuestionOption("b", "O(1) auxiliary space"),
                QuestionOption("c", "O(n) auxiliary space"),
                QuestionOption("d", "O(n^2) auxiliary space")
            ),
            correctOptionId = "b",
            explanation = "An in-place algorithm modifies the input structure directly using only a constant O(1) amount of extra variables."
        ),
        QuizQuestion(
            id = "cs_f_88",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In bitwise operations, what is the result of `12 & 10` (`1100` AND `1010` in binary)?",
            options = listOf(
                QuestionOption("a", "8 (`1000` in binary)"),
                QuestionOption("b", "14 (`1110` in binary)"),
                QuestionOption("c", "6 (`0110` in binary)"),
                QuestionOption("d", "22")
            ),
            correctOptionId = "a",
            explanation = "`1100 & 1010 = 1000`, which is 8 in decimal."
        ),
        QuizQuestion(
            id = "cs_f_89",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In bitwise operations, what is the result of `12 | 10` (`1100` OR `1010` in binary)?",
            options = listOf(
                QuestionOption("a", "8 (`1000` in binary)"),
                QuestionOption("b", "6 (`0110` in binary)"),
                QuestionOption("c", "2"),
                QuestionOption("d", "14 (`1110` in binary)")
            ),
            correctOptionId = "d",
            explanation = "`1100 | 1010 = 1110`, which is 8 + 4 + 2 = 14."
        ),
        QuizQuestion(
            id = "cs_f_90",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In bitwise operations, what is the result of `12 ^ 10` (`1100` XOR `1010` in binary)?",
            options = listOf(
                QuestionOption("a", "14 (`1110` in binary)"),
                QuestionOption("b", "0"),
                QuestionOption("c", "6 (`0110` in binary)"),
                QuestionOption("d", "8 (`1000` in binary)")
            ),
            correctOptionId = "c",
            explanation = "`1100 ^ 1010 = 0110` (bits that differ), which is 4 + 2 = 6."
        ),
        QuizQuestion(
            id = "cs_f_91",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "For any integer `x`, what do `x ^ x` and `x ^ 0` evaluate to?",
            options = listOf(
                QuestionOption("a", "Both evaluate to `1`"),
                QuestionOption("b", "`x ^ x = 0` and `x ^ 0 = x`"),
                QuestionOption("c", "`x ^ x = x` and `x ^ 0 = 0`"),
                QuestionOption("d", "Both evaluate to `0`")
            ),
            correctOptionId = "b",
            explanation = "XORing a value with itself cancels all 1-bits to 0 (`x ^ x = 0`), and XORing with 0 leaves `x` unchanged (`x ^ 0 = x`)."
        ),
        QuizQuestion(
            id = "cs_f_92",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given an array where every integer appears exactly TWICE except for one integer that appears ONCE, how can you find the unique integer in `O(n)` time and `O(1)` extra space?",
            options = listOf(
                QuestionOption("a", "XOR all elements of the array together; all paired numbers cancel to `0` (`a ^ a = 0`), leaving the unique number"),
                QuestionOption("b", "Sort the array in O(1) time"),
                QuestionOption("c", "Sum all elements and divide by 2"),
                QuestionOption("d", "Multiply all elements together")
            ),
            correctOptionId = "a",
            explanation = "Because XOR is commutative and associative with `a ^ a = 0` and `0 ^ single = single`, XORing all elements isolates the single unpaired value in O(n) time and O(1) space."
        ),
        QuizQuestion(
            id = "cs_f_93",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How can you test whether a positive integer `n` is even or odd using a bitwise operator?",
            options = listOf(
                QuestionOption("a", "Check `(n | 1) == 0`"),
                QuestionOption("b", "Check `(n ^ 1) == 0`"),
                QuestionOption("c", "Check `(n << 1) == 0`"),
                QuestionOption("d", "Check `(n & 1) == 0` (even if 0, odd if 1)")
            ),
            correctOptionId = "d",
            explanation = "The least significant bit (`n & 1`) is 0 for all even integers and 1 for all odd integers."
        ),
        QuizQuestion(
            id = "cs_f_94",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What arithmetic operation does left-shifting an integer by `k` bits (`x << k`, assuming no overflow) correspond to?",
            options = listOf(
                QuestionOption("a", "Adding `k` to `x`"),
                QuestionOption("b", "Raising `x` to the power `k`"),
                QuestionOption("c", "Multiplying `x` by `2^k`"),
                QuestionOption("d", "Dividing `x` by `2^k`")
            ),
            correctOptionId = "c",
            explanation = "Each 1-bit left shift doubles the binary value, so `x << k` equals `x * 2^k`."
        ),
        QuizQuestion(
            id = "cs_f_95",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Operating Systems, what is a `Mutex` (Mutual Exclusion lock)?",
            options = listOf(
                QuestionOption("a", "A network routing table"),
                QuestionOption("b", "A synchronization primitive that ensures only one thread at a time can enter a critical section to access shared state"),
                QuestionOption("c", "A hardware CPU fan controller"),
                QuestionOption("d", "A file compression format")
            ),
            correctOptionId = "b",
            explanation = "A mutex prevents race conditions by serializing access to a critical section across concurrent threads."
        ),
        QuizQuestion(
            id = "cs_f_96",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is a `Race Condition` in multithreaded programming?",
            options = listOf(
                QuestionOption("a", "A bug where the program's outcome depends on the unpredictable relative timing or interleaving of multiple threads accessing shared mutable data without proper synchronization"),
                QuestionOption("b", "When two sorting algorithms are benchmarked against each other"),
                QuestionOption("c", "When a CPU clock frequency boosts under load"),
                QuestionOption("d", "When a loop terminates early with `break`")
            ),
            correctOptionId = "a",
            explanation = "Without synchronization (locks or atomics), concurrent read-modify-write operations (like `counter++`) can interleave and lose updates."
        ),
        QuizQuestion(
            id = "cs_f_97",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a file system, what is the difference between a `Relative Path` and an `Absolute Path`?",
            options = listOf(
                QuestionOption("a", "A relative path is faster to read from disk"),
                QuestionOption("b", "An absolute path can only point to folders, not files"),
                QuestionOption("c", "There is no difference"),
                QuestionOption("d", "An absolute path starts from the root directory (e.g., `/home/user/file.txt`), whereas a relative path is resolved relative to the current working directory (e.g., `docs/file.txt`)")
            ),
            correctOptionId = "d",
            explanation = "Absolute paths specify the complete location from the filesystem root `/`; relative paths start from the process's current directory."
        ),
        QuizQuestion(
            id = "cs_f_98",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Git version control, what does `git commit` do compared to `git push`?",
            options = listOf(
                QuestionOption("a", "`git push` stages untracked files locally"),
                QuestionOption("b", "Both commands delete local branches"),
                QuestionOption("c", "`git commit` records a snapshot of staged changes in your LOCAL repository history, whereas `git push` uploads local commits to a REMOTE repository"),
                QuestionOption("d", "`git commit` uploads files directly to GitHub without saving locally")
            ),
            correctOptionId = "c",
            explanation = "Git is a distributed version control system: commits are created locally first, and `git push` synchronizes them with a remote server."
        ),
        QuizQuestion(
            id = "cs_f_99",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In database and storage units, how many bytes are in `1 KiB` (Kibibyte, binary prefix) vs `1 KB` (Kilobyte, SI decimal prefix)?",
            options = listOf(
                QuestionOption("a", "1 KiB = 8,192 bytes"),
                QuestionOption("b", "1 KiB = 1,024 bytes (2^10); 1 KB = 1,000 bytes (10^3)"),
                QuestionOption("c", "1 KiB = 1,000 bytes; 1 KB = 1,024 bytes"),
                QuestionOption("d", "Both equal 512 bytes")
            ),
            correctOptionId = "b",
            explanation = "Binary prefixes (`KiB`, `MiB`, `GiB`) use powers of 1,024 (`2^10`), whereas SI decimal prefixes (`KB`, `MB`, `GB`) use powers of 1,000 (`10^3`)."
        ),
        QuizQuestion(
            id = "cs_f_100",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is an `API (Application Programming Interface)`?",
            options = listOf(
                QuestionOption("a", "A defined contract of functions, protocols, and data formats that allows different software components or services to communicate with each other"),
                QuestionOption("b", "A physical cable connecting the monitor to the motherboard"),
                QuestionOption("c", "A programming language that replaces C and Java"),
                QuestionOption("d", "A type of relational database index")
            ),
            correctOptionId = "a",
            explanation = "An API defines the inputs, outputs, and operations exposed by a library, operating system, or web service."
        )
    )

    private fun appliedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "cs_a_16",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When a dynamic array (`ArrayList` in Java, `list` in Python, `std::vector` in C++) doubles its capacity whenever it gets full, why is the amortized time complexity of `append` still `O(1)`?",
            options = listOf(
                QuestionOption("a", "Because an O(n) copy happens only after `n/2` cheap O(1) insertions; summing `1 + 2 + 4 + ... + n <= 2n` over `n` appends averages `O(n) / n = O(1)` per append"),
                QuestionOption("b", "Because copying an array of `n` elements in RAM takes O(1) hardware time"),
                QuestionOption("c", "Because it never actually copies existing elements"),
                QuestionOption("d", "It is not O(1); `append` is O(n) amortized")
            ),
            correctOptionId = "a",
            explanation = "By the aggregate/accounting method of amortized analysis, geometric resizing (e.g., 1.5x or 2x) spreads the copy cost to a constant number of element writes per append."
        ),
        QuizQuestion(
            id = "cs_a_17",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you implement a FIFO `Queue` using ONLY two LIFO `Stacks` (`inStack` and `outStack`) so that `enqueue` and `dequeue` both run in `O(1)` amortized time?",
            options = listOf(
                QuestionOption("a", "Copy all elements between both stacks on every single `enqueue` and `dequeue`"),
                QuestionOption("b", "Keep elements sorted inside a single stack"),
                QuestionOption("c", "It is impossible; a queue cannot be simulated with two stacks"),
                QuestionOption("d", "Push new items onto `inStack`; on `dequeue`, pop from `outStack`, and ONLY when `outStack` is empty, pop all items from `inStack` and push them onto `outStack` (reversing their order once)")
            ),
            correctOptionId = "d",
            explanation = "Each element is pushed to `inStack` once, transferred to `outStack` once, and popped from `outStack` once—at most 3 stack operations per element = O(1) amortized!"
        ),
        QuizQuestion(
            id = "cs_a_18",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a singly linked list, how does Floyd's Tortoise and Hare algorithm detect a cycle in `O(n)` time and `O(1)` auxiliary space?",
            options = listOf(
                QuestionOption("a", "Store every visited node in a HashSet (which uses O(n) space)"),
                QuestionOption("b", "Count nodes up to 100 and stop"),
                QuestionOption("c", "Advance `slow` by 1 node and `fast` by 2 nodes per step; if a cycle exists, `fast` will eventually lap and equal `slow` inside the cycle (`slow === fast`), otherwise `fast` reaches `null`"),
                QuestionOption("d", "Reverse the linked list and check if `head` changes")
            ),
            correctOptionId = "c",
            explanation = "Inside a cycle, the distance from `fast` to `slow` decreases by 1 on every step, guaranteeing they meet in O(n) steps using only two pointers."
        ),
        QuizQuestion(
            id = "cs_a_19",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a binary heap stored in a 0-indexed array `arr`, what are the array indices of the left child, right child, and parent of the node at index `i`?",
            options = listOf(
                QuestionOption("a", "Left child = `i^2`, Right child = `i^2 + 1`, Parent = `sqrt(i)`"),
                QuestionOption("b", "Left child = `2*i + 1`, Right child = `2*i + 2`, Parent = `(i - 1) / 2`"),
                QuestionOption("c", "Left child = `2*i`, Right child = `2*i + 1`, Parent = `i / 2`"),
                QuestionOption("d", "Left child = `i + 1`, Right child = `i + 2`, Parent = `i - 1`")
            ),
            correctOptionId = "b",
            explanation = "A complete binary tree maps compactly into a 0-based array without pointers using `2i + 1`, `2i + 2`, and `(i - 1) / 2`."
        ),
        QuizQuestion(
            id = "cs_a_20",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the time complexity of building a Binary Heap (`buildHeap` / `heapify`) bottom-up from an unsorted array of `n` elements?",
            options = listOf(
                QuestionOption("a", "O(n) (because half the nodes are leaves at height 0, a quarter are at height 1, and `sum(n / 2^(h+1) * h) = O(n)`)"),
                QuestionOption("b", "O(n log n)"),
                QuestionOption("c", "O(n^2)"),
                QuestionOption("d", "O(log n)")
            ),
            correctOptionId = "a",
            explanation = "Sifting down from `n/2 - 1` down to `0` takes linear `O(n)` time because most nodes are near the bottom of the tree and travel at most 1–2 steps."
        ),
        QuizQuestion(
            id = "cs_a_21",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can you find the `k` largest elements in an unsorted array of `n` elements in `O(n log k)` time and `O(k)` extra memory?",
            options = listOf(
                QuestionOption("a", "Maintain a `Max-Heap` of size `n` and pop `k` times (which uses O(n) space)"),
                QuestionOption("b", "Sort the entire array in O(n log n) time"),
                QuestionOption("c", "Run QuickSort `k` times"),
                QuestionOption("d", "Maintain a `Min-Heap` of size at most `k`; for each element, if it is larger than the heap's root (`peek()`), replace the root and sift down")
            ),
            correctOptionId = "d",
            explanation = "A Min-Heap of size `k` tracks the smallest of the top `k` elements seen so far at its root in O(1), evicting it in O(log k) whenever a larger element arrives."
        ),
        QuizQuestion(
            id = "cs_a_22",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `QuickSort`, what causes the worst-case `O(n^2)` time complexity, and how is it avoided in practice?",
            options = listOf(
                QuestionOption("a", "When all elements are distinct"),
                QuestionOption("b", "When the array fits in L1 cache"),
                QuestionOption("c", "Picking the minimum or maximum element as the pivot on every partition (e.g., picking the first/last element on an already-sorted array); avoided by using a random pivot or median-of-three pivot"),
                QuestionOption("d", "When the array length is a power of 2")
            ),
            correctOptionId = "c",
            explanation = "Unbalanced `0 : (n - 1)` partitions yield `T(n) = T(n - 1) + O(n) = O(n^2)`; randomized or median-of-three pivots yield `O(n log n)` expected time."
        ),
        QuizQuestion(
            id = "cs_a_23",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When all keys in an array are identical (many duplicate elements), why can basic Lomuto/Hoare 2-way `QuickSort` degrade to `O(n^2)`, and what fixes it?",
            options = listOf(
                QuestionOption("a", "Duplicates cannot be sorted"),
                QuestionOption("b", "2-way partitioning puts all equal keys on one side of the recursion; Dijkstra's 3-way partitioning (`< pivot`, `== pivot`, `> pivot`) groups all equal keys in the middle and excludes them from recursive calls, running in `O(n)` when all keys are equal!"),
                QuestionOption("c", "Merge Sort also degrades to O(n^2) on duplicates"),
                QuestionOption("d", "Using bubble sort fixes it")
            ),
            correctOptionId = "b",
            explanation = "3-way QuickSort (Dutch National Flag partitioning) partitions into `<`, `==`, and `>` regions so duplicate pivot keys are never recursed on again."
        ),
        QuizQuestion(
            id = "cs_a_24",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `O(n log n)` the theoretical lower bound for any comparison-based sorting algorithm in the worst case?",
            options = listOf(
                QuestionOption("a", "A comparison tree sorting `n` elements must have at least `n!` leaves (one per permutation), and a binary tree with `n!` leaves has height at least `log2(n!) = Theta(n log n)` by Stirling's approximation"),
                QuestionOption("b", "Because CPU registers are 64 bits wide"),
                QuestionOption("c", "Because arrays cannot be indexed faster than O(log n)"),
                QuestionOption("d", "Because Merge Sort was invented first")
            ),
            correctOptionId = "a",
            explanation = "Each yes/no comparison yields at most 1 bit of information; distinguishing `n!` possible input orderings requires at least `log2(n!) = Theta(n log n)` comparisons."
        ),
        QuizQuestion(
            id = "cs_a_25",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do non-comparison sorts like `Counting Sort` and `Radix Sort` achieve `O(n + k)` or `O(d * (n + b))` linear-like time without violating the `Omega(n log n)` comparison lower bound?",
            options = listOf(
                QuestionOption("a", "They drop duplicate elements"),
                QuestionOption("b", "They only work on arrays of size <= 16"),
                QuestionOption("c", "They use quantum hardware"),
                QuestionOption("d", "They do not rely on pairwise `<` comparisons; instead, they exploit the integer key structure/digits to index directly into buckets")
            ),
            correctOptionId = "d",
            explanation = "By using key values or radix digits as array indices rather than only comparing pairs, Counting Sort and Radix Sort bypass the comparison-tree model."
        ),
        QuizQuestion(
            id = "cs_a_26",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a Hash Table, what are the two main strategies for resolving hash collisions?",
            options = listOf(
                QuestionOption("a", "Encrypting the keys with RSA and dropping collisions"),
                QuestionOption("b", "Creating a new thread per key"),
                QuestionOption("c", "Separate Chaining (storing a linked list/tree at each bucket) and Open Addressing (probing alternative array slots such as Linear Probing, Quadratic Probing, or Double Hashing)"),
                QuestionOption("d", "Sorting the table on every insert and deleting the older key")
            ),
            correctOptionId = "c",
            explanation = "Separate chaining stores colliding entries in bucket chains/trees, while open addressing probes within the flat bucket array itself."
        ),
        QuizQuestion(
            id = "cs_a_27",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Open Addressing with `Linear Probing`, why can you NOT simply mark a slot as `EMPTY` when deleting a key?",
            options = listOf(
                QuestionOption("a", "Because deleting a key changes the hash function"),
                QuestionOption("b", "Because a subsequent lookup for another key that collided and probed past that slot would hit `EMPTY` and falsely stop early! A `TOMBSTONE` (deleted marker) or backward shift must be used"),
                QuestionOption("c", "Because memory cannot be zeroed out in RAM"),
                QuestionOption("d", "Because Linear Probing does not support `get()`")
            ),
            correctOptionId = "b",
            explanation = "Clearing a slot to `EMPTY` breaks the probe chain for keys inserted later along the same cluster; tombstones keep probe chains intact during search while allowing reuse during insert."
        ),
        QuizQuestion(
            id = "cs_a_28",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the `Load Factor` (`alpha = n / m`) of a hash table with `n` entries and `m` buckets, and what happens when `alpha` exceeds the threshold (e.g., `0.75`)?",
            options = listOf(
                QuestionOption("a", "The table allocates a larger bucket array (typically 2x) and rehashes all existing keys into the new buckets to keep chains/probe lengths O(1)"),
                QuestionOption("b", "The hash table stops accepting new keys and throws an error"),
                QuestionOption("c", "All existing keys are deleted"),
                QuestionOption("d", "Lookup time becomes O(log log n)")
            ),
            correctOptionId = "a",
            explanation = "Keeping the load factor bounded ensures the average bucket size or probe sequence length remains a small constant."
        ),
        QuizQuestion(
            id = "cs_a_29",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens to an unbalanced `Binary Search Tree (BST)` if you insert keys `1, 2, 3, 4, 5, ..., n` in strictly ascending order?",
            options = listOf(
                QuestionOption("a", "It automatically balances itself into height `log2(n)`"),
                QuestionOption("b", "It rejects keys after the 3rd insert"),
                QuestionOption("c", "Lookup becomes `O(1)`"),
                QuestionOption("d", "It degenerates into a skewed linked list of height `n`, degrading lookup and insertion from `O(log n)` to `O(n)`")
            ),
            correctOptionId = "d",
            explanation = "Without self-balancing rotations (as in AVL or Red-Black trees), sorted insertions always go to the right child, creating a height-`n` chain."
        ),
        QuizQuestion(
            id = "cs_a_30",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do self-balancing BSTs like `AVL Trees` and `Red-Black Trees` guarantee `O(log n)` worst-case search, insert, and delete times?",
            options = listOf(
                QuestionOption("a", "They store all keys in a flat hash table"),
                QuestionOption("b", "They disallow deleting nodes"),
                QuestionOption("c", "They maintain structural height invariants using local `O(1)` tree rotations (left/right rotations) and recoloring/balance factors after updates so tree height never exceeds `O(log n)`"),
                QuestionOption("d", "They rebuild the entire tree from scratch in `O(n)` on every insert")
            ),
            correctOptionId = "c",
            explanation = "AVL trees enforce `|height(left) - height(right)| <= 1` (`height <= 1.44 log2 n`), and Red-Black trees enforce color/black-height invariants (`height <= 2 log2(n+1)`)."
        ),
        QuizQuestion(
            id = "cs_a_31",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Which data structure is specifically designed for storing a set of strings to support `O(L)` prefix lookups and autocomplete (where `L` is the length of the query string)?",
            options = listOf(
                QuestionOption("a", "A Disjoint Set (Union-Find)"),
                QuestionOption("b", "A Trie (Prefix Tree)"),
                QuestionOption("c", "A Min-Heap"),
                QuestionOption("d", "A Doubly Linked List")
            ),
            correctOptionId = "b",
            explanation = "A Trie branches by character at each node along a path of length `L`, enabling prefix search and autocomplete in `O(L)` time independent of how many total words are in the dictionary."
        ),
        QuizQuestion(
            id = "cs_a_32",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a graph `G = (V, E)` with `|V|` vertices and `|E|` edges, compare the space complexity and edge-check `(u, v)` time of an `Adjacency Matrix` vs. an `Adjacency List`.",
            options = listOf(
                QuestionOption("a", "Adjacency Matrix uses `O(|V|^2)` space and `O(1)` edge lookup; Adjacency List uses `O(|V| + |E|)` space and `O(degree(u))` edge lookup"),
                QuestionOption("b", "Adjacency Matrix uses `O(|V| + |E|)` space and Adjacency List uses `O(|V|^2)` space"),
                QuestionOption("c", "Both use `O(|V|)` space"),
                QuestionOption("d", "Adjacency List cannot represent directed graphs")
            ),
            correctOptionId = "a",
            explanation = "Sparse graphs (`|E| << |V|^2`) are much more memory-efficient and faster to traverse (`O(|V| + |E|)`) with an Adjacency List."
        ),
        QuizQuestion(
            id = "cs_a_33",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When does `Breadth-First Search (BFS)` guarantee finding the shortest path from a source vertex `s` to all other vertices?",
            options = listOf(
                QuestionOption("a", "When the graph has arbitrary positive and negative edge weights"),
                QuestionOption("b", "Only when the graph is a binary tree"),
                QuestionOption("c", "Never; only Dijkstra's algorithm can find shortest paths in unweighted graphs"),
                QuestionOption("d", "When the graph is unweighted (or all edges have the exact same positive weight)")
            ),
            correctOptionId = "d",
            explanation = "In an unweighted graph, BFS explores vertices in strictly non-decreasing order of hop count (`0, 1, 2, ...`) in `O(|V| + |E|)` time."
        ),
        QuizQuestion(
            id = "cs_a_34",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What requirement must edge weights satisfy for `Dijkstra's Algorithm` to guaranteedly compute correct single-source shortest paths?",
            options = listOf(
                QuestionOption("a", "The graph must not contain any cycles"),
                QuestionOption("b", "All edge weights must equal 1"),
                QuestionOption("c", "All edge weights must be non-negative (`w(u, v) >= 0`)"),
                QuestionOption("d", "All edge weights must be negative")
            ),
            correctOptionId = "c",
            explanation = "Dijkstra's greedy step assumes that once the vertex with the smallest tentative distance is popped from the priority queue, no future path through unvisited edges can make it shorter—which holds only if all edge weights are `>= 0`."
        ),
        QuizQuestion(
            id = "cs_a_35",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the time complexity of `Dijkstra's Algorithm` on a graph `G = (V, E)` using a binary min-heap priority queue and adjacency lists?",
            options = listOf(
                QuestionOption("a", "O(2^|V|)"),
                QuestionOption("b", "O((|V| + |E|) log |V|)"),
                QuestionOption("c", "O(|V|^3)"),
                QuestionOption("d", "O(|V| + |E|)")
            ),
            correctOptionId = "b",
            explanation = "Each vertex is extracted once (`|V| log |V|`) and each edge relaxation pushes/updates the binary heap (`|E| log |V|`)."
        ),
        QuizQuestion(
            id = "cs_a_36",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is a `Topological Sort` of a graph, and for which class of graphs does a valid topological ordering exist?",
            options = listOf(
                QuestionOption("a", "A linear ordering of vertices such that for every directed edge `u -> v`, `u` comes before `v`; it exists if and only if the graph is a `Directed Acyclic Graph (DAG)`"),
                QuestionOption("b", "An ordering of vertices by degree; it exists for all undirected graphs"),
                QuestionOption("c", "A path that visits every edge exactly once; it exists for all cyclic graphs"),
                QuestionOption("d", "A sorting of edge weights")
            ),
            correctOptionId = "a",
            explanation = "If a directed graph has a cycle, no linear order can place every predecessor before its successor; hence topological sort exists iff the directed graph is acyclic (a DAG)."
        ),
        QuizQuestion(
            id = "cs_a_37",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How does `Kahn's Algorithm` compute a topological sort of a directed graph (and simultaneously detect cycles)?",
            options = listOf(
                QuestionOption("a", "Run BFS from a random vertex and reverse the result"),
                QuestionOption("b", "Sort vertices by their out-degree only"),
                QuestionOption("c", "Use Kruskal's algorithm"),
                QuestionOption("d", "Compute in-degrees of all vertices, push all `in_degree == 0` vertices into a queue, repeatedly pop `u` and decrement `in_degree` of its neighbors (pushing any that reach `0`); if fewer than `|V|` vertices are output, the graph has a cycle!")
            ),
            correctOptionId = "d",
            explanation = "Any cycle contains vertices whose in-degrees never drop to 0, so Kahn's algorithm outputs fewer than `|V|` vertices iff a cycle is present."
        ),
        QuizQuestion(
            id = "cs_a_38",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is a `Minimum Spanning Tree (MST)` of a connected, undirected, weighted graph, and which two classic greedy algorithms find it?",
            options = listOf(
                QuestionOption("a", "A cycle visiting every vertex once; found by `DFS`"),
                QuestionOption("b", "A balanced binary search tree"),
                QuestionOption("c", "A subset of `|V| - 1` edges connecting all vertices with minimum total edge weight and no cycles; found by `Kruskal's` and `Prim's` algorithms"),
                QuestionOption("d", "The shortest path between two specific vertices; found by `Dijkstra's` and `Bellman-Ford`")
            ),
            correctOptionId = "c",
            explanation = "Kruskal's algorithm sorts edges by weight and adds them using Disjoint Set (Union-Find) if they don't form a cycle; Prim's grows a single tree from a start vertex using a priority queue."
        ),
        QuizQuestion(
            id = "cs_a_39",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What are the two core properties of a problem that make it solvable by `Dynamic Programming (DP)`?",
            options = listOf(
                QuestionOption("a", "Recursion without a base case"),
                QuestionOption("b", "Overlapping Subproblems and Optimal Substructure"),
                QuestionOption("c", "Randomness and Parallelism"),
                QuestionOption("d", "High Memory and Low CPU")
            ),
            correctOptionId = "b",
            explanation = "Optimal substructure means an optimal solution can be built from optimal solutions to subproblems; overlapping subproblems means recursive calls solve the same subproblems repeatedly, so memoization or tabulation saves exponential work."
        ),
        QuizQuestion(
            id = "cs_a_40",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What makes a naive recursive computation of `fib(n) = fib(n - 1) + fib(n - 2)` take `O(2^n)` time, and what does memoization / bottom-up tabulation reduce it to?",
            options = listOf(
                QuestionOption("a", "Naive recursion recomputes the same `fib(k)` subproblems exponentially many times; memoization/tabulation computes each `fib(0)..fib(n)` once in `O(n)` time (and `O(1)` space with two variables)"),
                QuestionOption("b", "Naive recursion uses floating-point division; tabulation reduces it to O(log log n)"),
                QuestionOption("c", "Naive recursion is already O(n)"),
                QuestionOption("d", "Memoization increases time complexity to O(n^3)")
            ),
            correctOptionId = "a",
            explanation = "Caching subproblem results collapses the recursion tree of size `O(phi^n)` down to `n` distinct states."
        ),
        QuizQuestion(
            id = "cs_a_41",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In the `Sliding Window` or `Two Pointers` technique on an array/string of length `n` (where `left` and `right` pointers only move forward from `0` to `n`), why is the total time complexity `O(n)` despite having an inner `while` loop inside an outer `for` loop?",
            options = listOf(
                QuestionOption("a", "Because inner `while` loops always take 0 CPU cycles"),
                QuestionOption("b", "It is actually `O(n^2)` in all cases"),
                QuestionOption("c", "Because `left` moves backward on every step"),
                QuestionOption("d", "Because `right` increments `n` times and `left` increments at most `n` times across the ENTIRE execution (at most `2n` pointer steps total), not `n` times per outer iteration!")
            ),
            correctOptionId = "d",
            explanation = "By amortized aggregate analysis, each element enters the window once (when `right` advances) and leaves the window at most once (when `left` advances), doing `O(n)` total work."
        ),
        QuizQuestion(
            id = "cs_a_42",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Operating Systems, what are the four Coffman conditions that MUST all hold simultaneously for a resource `Deadlock` to occur?",
            options = listOf(
                QuestionOption("a", "Read, Write, Execute, and Delete"),
                QuestionOption("b", "Compile, Link, Load, and Run"),
                QuestionOption("c", "Mutual Exclusion, Hold and Wait, No Preemption, and Circular Wait"),
                QuestionOption("d", "Paging, Swapping, Thrashing, and Starvation")
            ),
            correctOptionId = "c",
            explanation = "Breaking any one of the four Coffman conditions (most commonly breaking Circular Wait by enforcing a global lock acquisition order) prevents deadlock."
        ),
        QuizQuestion(
            id = "cs_a_43",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Operating Systems, what is the difference between a `Binary Semaphore` and a `Mutex` (ownership lock)?",
            options = listOf(
                QuestionOption("a", "There is no difference"),
                QuestionOption("b", "A Mutex has strict thread ownership (only the thread that locked it may unlock it), whereas a Semaphore is a signaling counter where one thread can `wait (P)` and a different thread can `signal/post (V)`"),
                QuestionOption("c", "A Semaphore can only be used in Python, while a Mutex is only in C"),
                QuestionOption("d", "A Mutex allows 10 threads inside the critical section at once")
            ),
            correctOptionId = "b",
            explanation = "Mutexes protect critical sections via ownership (and support priority inheritance); semaphores coordinate signaling or bound concurrent access (`Counting Semaphore`)."
        ),
        QuizQuestion(
            id = "cs_a_44",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Operating System CPU scheduling, what is the `Convoy Effect` and which scheduling algorithm suffers from it?",
            options = listOf(
                QuestionOption("a", "When one long CPU-bound process holds the CPU while many short I/O-bound processes pile up waiting behind it; characteristic of non-preemptive `First-Come, First-Served (FCFS / FIFO)` scheduling"),
                QuestionOption("b", "When `Round Robin` uses a time quantum of 1 millisecond"),
                QuestionOption("c", "When `Shortest Remaining Time First` starves long jobs"),
                QuestionOption("d", "When two CPUs run at the same clock speed")
            ),
            correctOptionId = "a",
            explanation = "In FCFS, a single long burst at the head of the ready queue delays all shorter interactive tasks behind it, inflating average waiting and turnaround time."
        ),
        QuizQuestion(
            id = "cs_a_45",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `Round Robin (RR)` CPU scheduling, what happens if the time quantum `q` is chosen way too SMALL vs. way too LARGE?",
            options = listOf(
                QuestionOption("a", "If `q` is too small, context switching disappears"),
                QuestionOption("b", "If `q` is too large, processes crash with a page fault"),
                QuestionOption("c", "The time quantum has no effect on performance"),
                QuestionOption("d", "If `q` is too small, CPU time is wasted on constant context-switch overhead; if `q` is too large, Round Robin degenerates into `First-Come, First-Served (FCFS)` with poor interactive response time")
            ),
            correctOptionId = "d",
            explanation = "A well-chosen time quantum (e.g., 10–100 ms) balances responsive time-slicing against context-switch overhead."
        ),
        QuizQuestion(
            id = "cs_a_46",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In virtual memory paging, what is the purpose of the hardware `TLB (Translation Lookaside Buffer)`?",
            options = listOf(
                QuestionOption("a", "A buffer that stores keyboard keystrokes"),
                QuestionOption("b", "A network packet queue in the router"),
                QuestionOption("c", "A fast hardware cache inside the MMU that caches recent virtual-page-number to physical-frame-number translations, avoiding slow multi-level page table walks in RAM on every memory access"),
                QuestionOption("d", "A disk partition used when RAM is full")
            ),
            correctOptionId = "c",
            explanation = "Without a TLB hit, every virtual memory reference would require multiple RAM accesses just to read the multi-level page tables before accessing the actual data!"
        ),
        QuizQuestion(
            id = "cs_a_47",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens during a `Page Fault` in an operating system with demand paging?",
            options = listOf(
                QuestionOption("a", "The program is deleted from disk"),
                QuestionOption("b", "The CPU traps to the OS kernel because the referenced virtual page is not currently mapped as valid/present in physical RAM; the OS loads the page from disk (or allocates a zero page), updates the page table, and restarts the instruction"),
                QuestionOption("c", "The computer immediately shuts down and loses all data"),
                QuestionOption("d", "The L1 cache is permanently disabled")
            ),
            correctOptionId = "b",
            explanation = "Page faults are handled transparently by the OS kernel (unless the virtual address is illegal, which causes a Segmentation Fault / `SIGSEGV`)."
        ),
        QuizQuestion(
            id = "cs_a_48",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Which theoretical page replacement algorithm replaces the page that will NOT be used for the longest period of time in the future, and why is it studied if it cannot be implemented in a real OS?",
            options = listOf(
                QuestionOption("a", "Belady's `Optimal (OPT / MIN)` algorithm; it serves as the theoretical benchmark lower bound on page faults against which real algorithms like `LRU` (Least Recently Used) are compared"),
                QuestionOption("b", "`FIFO` (First-In, First-Out); it is used in all modern kernels"),
                QuestionOption("c", "`Random` replacement; it never has page faults"),
                QuestionOption("d", "`MRU` (Most Recently Used); it predicts the future")
            ),
            correctOptionId = "a",
            explanation = "Belady's OPT requires future knowledge of memory references, so practical systems approximate it using `LRU` or `Clock` (Second-Chance) based on locality of reference."
        ),
        QuizQuestion(
            id = "cs_a_49",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Operating Systems, what is `Thrashing`?",
            options = listOf(
                QuestionOption("a", "When a CPU fan spins at maximum RPM"),
                QuestionOption("b", "When a sorting algorithm runs in O(n log n)"),
                QuestionOption("c", "When a hard drive is defragmented"),
                QuestionOption("d", "When the working set of active processes exceeds physical RAM, causing the system to spend nearly all its time swapping pages in and out of disk instead of executing useful CPU instructions")
            ),
            correctOptionId = "d",
            explanation = "Thrashing causes CPU utilization to plummet as processes continually fault on each other's evicted pages."
        ),
        QuizQuestion(
            id = "cs_a_50",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In CPU cache performance, what are the two forms of `Locality of Reference` that make hardware caches effective?",
            options = listOf(
                QuestionOption("a", "Syntax Locality and Semantic Locality"),
                QuestionOption("b", "Disk Locality and Network Locality"),
                QuestionOption("c", "Temporal Locality (recently accessed data is likely to be accessed again soon) and Spatial Locality (data stored near recently accessed memory addresses is likely to be accessed soon)"),
                QuestionOption("d", "Global Locality and Static Locality")
            ),
            correctOptionId = "c",
            explanation = "Loops and hot variables exhibit Temporal Locality; sequential array traversal exhibits Spatial Locality (fetching an entire 64-byte cache line at once)."
        ),
        QuizQuestion(
            id = "cs_a_51",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is traversing a large 2D row-major array `matrix[row][col]` (in C, Java, Python, Kotlin) much faster with `row` as the outer loop and `col` as the inner loop than the reverse?",
            options = listOf(
                QuestionOption("a", "Both loop orders have identical cache behavior"),
                QuestionOption("b", "Row-major layout stores `matrix[r][0], matrix[r][1], matrix[r][2]...` contiguously in memory; iterating `col` in the inner loop accesses consecutive addresses within each 64-byte CPU cache line (Spatial Locality), whereas jumping by `row` causes a cache miss on almost every access!"),
                QuestionOption("c", "Because compilers optimize variables named `row` faster than `col`"),
                QuestionOption("d", "Because CPU addition is faster on the second index")
            ),
            correctOptionId = "b",
            explanation = "Sequential stride-1 memory access utilizes 100% of every fetched CPU cache line and triggers hardware prefetchers."
        ),
        QuizQuestion(
            id = "cs_a_52",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In memory management, what is the difference between `Internal Fragmentation` and `External Fragmentation`?",
            options = listOf(
                QuestionOption("a", "Internal fragmentation is wasted unused space INSIDE an allocated fixed-size block/page; External fragmentation is when enough total free memory exists, but it is split into small non-contiguous holes so a large contiguous allocation request fails"),
                QuestionOption("b", "Internal fragmentation happens on SSDs and External happens on USB drives"),
                QuestionOption("c", "External fragmentation only occurs inside CPU registers"),
                QuestionOption("d", "They mean the exact same thing")
            ),
            correctOptionId = "a",
            explanation = "Fixed-size paging eliminates external fragmentation but can have internal fragmentation on the last page; variable-size segmentation/heap allocation can suffer from external fragmentation."
        ),
        QuizQuestion(
            id = "cs_a_53",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a program's virtual address space, compare `Stack` memory allocation vs. `Heap` memory allocation.",
            options = listOf(
                QuestionOption("a", "The Heap is faster than the Stack and is limited to 1 KB"),
                QuestionOption("b", "The Stack is shared across all threads while each thread has a private Heap"),
                QuestionOption("c", "Local primitive variables cannot be stored on the Stack"),
                QuestionOption("d", "The Stack allocates/deallocates local function frames automatically in `O(1)` by moving the stack pointer (`LIFO`), whereas the Heap manages dynamically sized objects whose lifetimes outlive the creating function call")
            ),
            correctOptionId = "d",
            explanation = "Stack allocation is a single pointer bump scoped to function entry/exit; heap allocation supports arbitrary lifetimes and dynamic sizes."
        ),
        QuizQuestion(
            id = "cs_a_54",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In IEEE 754 floating-point arithmetic, why does `0.1 + 0.2 == 0.3` evaluate to `false` in most programming languages?",
            options = listOf(
                QuestionOption("a", "Because `0.3` is an irrational number in base 10"),
                QuestionOption("b", "It evaluates to `true` in IEEE 754"),
                QuestionOption("c", "Because `0.1` and `0.2` have infinite repeating representations in base-2 binary (`0.0001100110011..._2`), so rounding them to 53-bit significands produces `0.30000000000000004`"),
                QuestionOption("d", "Because CPUs have a hardware bug when adding numbers below 1")
            ),
            correctOptionId = "c",
            explanation = "Just as `1/3 = 0.333...` repeats infinitely in base 10, `1/10` repeats infinitely in base 2. Use an epsilon tolerance `abs(a - b) < 1e-9` for float comparisons or fixed-point decimal for money."
        ),
        QuizQuestion(
            id = "cs_a_55",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In computer architecture, what is the difference between `Big-Endian` and `Little-Endian` byte ordering for a 32-bit integer `0x12345678` stored at memory address `0x100`?",
            options = listOf(
                QuestionOption("a", "Big-Endian stores numbers in ASCII text"),
                QuestionOption("b", "Big-Endian stores the most significant byte `0x12` at the lowest address `0x100` (`12 34 56 78`); Little-Endian stores the least significant byte `0x78` at the lowest address `0x100` (`78 56 34 12`)"),
                QuestionOption("c", "Big-Endian is used only for 64-bit CPUs and Little-Endian for 8-bit CPUs"),
                QuestionOption("d", "Little-Endian reverses the bits inside each individual byte")
            ),
            correctOptionId = "b",
            explanation = "x86-64 and ARM (by default on Android/Linux) are Little-Endian (`78 56 34 12`), whereas standard network byte order (TCP/IP headers) is Big-Endian."
        ),
        QuizQuestion(
            id = "cs_a_56",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In signed 32-bit two's complement arithmetic, what happens if you add `1` to `Integer.MAX_VALUE` (`2,147,483,647`, which is `0x7FFFFFFF`)?",
            options = listOf(
                QuestionOption("a", "Integer overflow wraps around to `Integer.MIN_VALUE` (`-2,147,483,648`, which is `0x80000000`)"),
                QuestionOption("b", "It saturates and stays at `2,147,483,647`"),
                QuestionOption("c", "It becomes `0`"),
                QuestionOption("d", "It automatically promotes the variable to a 64-bit `long`")
            ),
            correctOptionId = "a",
            explanation = "Adding `1` to `0111...1111` produces `1000...0000`, which is the two's complement bit pattern for `-2^31` (`Integer.MIN_VALUE`)."
        ),
        QuizQuestion(
            id = "cs_a_57",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When computing the midpoint `mid` in Binary Search between indices `low` and `high`, why should you write `low + (high - low) / 2` (or `(low + high) >>> 1`) instead of `(low + high) / 2`?",
            options = listOf(
                QuestionOption("a", "Because `(low + high) / 2` rounds up instead of down"),
                QuestionOption("b", "Because subtraction is slower than division"),
                QuestionOption("c", "They are completely identical for all 32-bit integers"),
                QuestionOption("d", "Because if `low + high` exceeds `Integer.MAX_VALUE` (`2^31 - 1`), `(low + high)` overflows into a negative integer, whereas `low + (high - low) / 2` never overflows!")
            ),
            correctOptionId = "d",
            explanation = "This classic overflow bug lurked in standard library `binarySearch` implementations for decades before being fixed with `low + (high - low) / 2` or unsigned shift `>>> 1`."
        ),
        QuizQuestion(
            id = "cs_a_58",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In networking, given the IPv4 CIDR block `192.168.10.0/24`, how many total IP addresses are in the block, and how many are usable host addresses in standard IPv4 subnetting?",
            options = listOf(
                QuestionOption("a", "1,024 total addresses and 1,022 usable"),
                QuestionOption("b", "255 total addresses and 255 usable"),
                QuestionOption("c", "256 total addresses (`2^(32-24)`), with 254 usable host addresses (excluding the network address `.0` and broadcast address `.255`)"),
                QuestionOption("d", "24 total addresses and 22 usable")
            ),
            correctOptionId = "c",
            explanation = "A `/24` prefix leaves `32 - 24 = 8` host bits (`2^8 = 256` addresses); subtracting network (`.0`) and broadcast (`.255`) leaves `254` usable host addresses."
        )
    )

    private fun appliedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "cs_a_59",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the role of `ARP (Address Resolution Protocol)` in an IPv4 local area network (LAN)?",
            options = listOf(
                QuestionOption("a", "It assigns dynamic IP addresses to new laptops (which is DHCP)"),
                QuestionOption("b", "It resolves a known Layer-3 IPv4 address on the local subnet to its corresponding Layer-2 hardware MAC address"),
                QuestionOption("c", "It translates domain names like `google.com` into IPv4 addresses"),
                QuestionOption("d", "It encrypts Wi-Fi passwords")
            ),
            correctOptionId = "b",
            explanation = "ARP broadcasts 'Who has IP X?' on the local Ethernet/Wi-Fi segment so the sender can fill in the destination Layer-2 MAC address."
        ),
        QuizQuestion(
            id = "cs_a_60",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the purpose of `NAT (Network Address Translation)` on a home or office router?",
            options = listOf(
                QuestionOption("a", "It maps multiple private LAN IPv4 addresses (like `192.168.x.x` or `10.x.x.x`) to a single public IPv4 address using port mappings (`PAT`), conserving public IPv4 addresses"),
                QuestionOption("b", "It converts IPv4 cables into fiber-optic cables"),
                QuestionOption("c", "It replaces DNS servers"),
                QuestionOption("d", "It disables the TCP 3-way handshake")
            ),
            correctOptionId = "a",
            explanation = "NAT rewrites source/destination IP addresses and transport port numbers in packet headers as traffic crosses between a private LAN and the public Internet."
        ),
        QuizQuestion(
            id = "cs_a_61",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "During a `TLS (HTTPS)` connection handshake, why are BOTH `Asymmetric (Public-Key) Cryptography` and `Symmetric Cryptography` used together?",
            options = listOf(
                QuestionOption("a", "Because symmetric cryptography cannot encrypt more than 16 bytes"),
                QuestionOption("b", "Because asymmetric cryptography is 1,000x faster than symmetric cryptography for bulk data"),
                QuestionOption("c", "TLS only uses MD5 hashing"),
                QuestionOption("d", "Asymmetric cryptography (e.g., ECDHE / RSA + certificates) authenticates the server and securely negotiates a shared ephemeral key, and fast Symmetric cryptography (e.g., AES-GCM / ChaCha20-Poly1305) encrypts the bulk session data")
            ),
            correctOptionId = "d",
            explanation = "Public-key key exchange solves key distribution and authentication over an untrusted network, while symmetric AEAD ciphers encrypt bulk application data at gigabits per second."
        ),
        QuizQuestion(
            id = "cs_a_62",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the fundamental difference between `Encryption` (e.g., AES) and `Cryptographic Hashing` (e.g., SHA-256)?",
            options = listOf(
                QuestionOption("a", "AES produces a fixed 32-byte output regardless of whether the input is 10 GB"),
                QuestionOption("b", "Hashing requires a decryption key"),
                QuestionOption("c", "Encryption is a two-way reversible transformation using a key (`decrypt(encrypt(m, k), k) == m`), whereas Hashing is a one-way irreversible function that maps arbitrary-length input to a fixed-size digest"),
                QuestionOption("d", "SHA-256 can be decrypted using a private key")
            ),
            correctOptionId = "c",
            explanation = "Hashes (SHA-256) are one-way digests used for integrity and password verification (with salted KDFs like Argon2/bcrypt), whereas encryption is reversible with the decryption key."
        ),
        QuizQuestion(
            id = "cs_a_63",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why must user passwords in a database NEVER be stored as plain `SHA-256(password)` without a unique per-user `Salt` and a slow key-derivation function (like `Argon2id`, `bcrypt`, or `PBKDF2`)?",
            options = listOf(
                QuestionOption("a", "Plaintext is safer than salted bcrypt"),
                QuestionOption("b", "Unsalted fast hashes allow attackers to crack millions of passwords per second on GPUs and use precomputed `Rainbow Tables` where identical passwords produce the exact same hash!"),
                QuestionOption("c", "Because SHA-256 truncates passwords longer than 8 characters"),
                QuestionOption("d", "Because SHA-256 is reversible with a mathematical formula")
            ),
            correctOptionId = "b",
            explanation = "A unique random salt per user defeats rainbow tables and identical-hash correlation, while memory/CPU-hard functions like Argon2id or bcrypt slow down brute-force guessing."
        ),
        QuizQuestion(
            id = "cs_a_64",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In HTTP/REST APIs, what does it mean for an HTTP method (`PUT` or `DELETE`, as opposed to `POST`) to be `Idempotent`?",
            options = listOf(
                QuestionOption("a", "Making the exact same request once or multiple times has the same intended state effect on the server (e.g., setting a resource to a value or ensuring it is deleted), making automatic network retries safe"),
                QuestionOption("b", "The request never modifies anything on the server (which is `Safe`, like `GET`)"),
                QuestionOption("c", "The request runs in O(1) time"),
                QuestionOption("d", "The request cannot return a JSON body")
            ),
            correctOptionId = "a",
            explanation = "`GET`, `HEAD`, `PUT`, and `DELETE` are idempotent by HTTP specification; `POST` is NOT idempotent (retrying a `POST /orders` without an idempotency key may create duplicate orders!)."
        ),
        QuizQuestion(
            id = "cs_a_65",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In UNIX/Linux file permissions, what does `chmod 754 script.sh` (`rwxr-xr--`) grant?",
            options = listOf(
                QuestionOption("a", "Owner = Read only; Group = Write only; Others = Execute only"),
                QuestionOption("b", "Everyone gets full Read, Write, and Execute permissions (`777`)"),
                QuestionOption("c", "The file is deleted after 754 seconds"),
                QuestionOption("d", "Owner = Read, Write, Execute (`4+2+1=7`); Group = Read, Execute (`4+0+1=5`); Others = Read only (`4+0+0=4`)")
            ),
            correctOptionId = "d",
            explanation = "Each octal digit combines Read (`4`), Write (`2`), and Execute (`1`) for User (Owner), Group, and Others."
        ),
        QuizQuestion(
            id = "cs_a_66",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a compiler or interpreter, what is the sequence of phases that transforms source code text into an Abstract Syntax Tree (AST)?",
            options = listOf(
                QuestionOption("a", "Binary Search -> Hashing -> Sorting"),
                QuestionOption("b", "Garbage Collection -> Tokenization"),
                QuestionOption("c", "Lexical Analysis (Lexer/Scanner tokenizes characters into tokens) -> Syntax Analysis (Parser builds an AST according to the grammar)"),
                QuestionOption("d", "Code Generation -> Lexical Analysis -> Linking")
            ),
            correctOptionId = "c",
            explanation = "The lexer groups raw characters into tokens (keywords, identifiers, literals), and the parser validates grammar rules to construct the AST."
        ),
        QuizQuestion(
            id = "cs_a_67",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Formal Languages and Compilers, why can a `Regular Expression` (Finite Automaton) NOT validate arbitrarily nested balanced parentheses `((...))` or arbitrary nested HTML tags?",
            options = listOf(
                QuestionOption("a", "A regular expression CAN match arbitrary unbounded depth in standard automata theory"),
                QuestionOption("b", "Because a Finite Automaton has only a finite number of states (`O(1)` memory) and cannot count unbounded nesting depth; a `Context-Free Grammar` (Pushdown Automaton with a Stack) is required"),
                QuestionOption("c", "Because Regular Expressions cannot match the `(` character"),
                QuestionOption("d", "Because parentheses are not ASCII characters")
            ),
            correctOptionId = "b",
            explanation = "By the Pumping Lemma for regular languages, matching `{a^n b^n | n >= 0}` requires unbounded state/stack counting (Context-Free, not Regular)."
        ),
        QuizQuestion(
            id = "cs_a_68",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you check whether a string containing `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'` has valid balanced brackets in `O(n)` time?",
            options = listOf(
                QuestionOption("a", "Iterate through the characters: push opening brackets onto a `Stack`; on a closing bracket, check that the stack is non-empty and its popped top matches the corresponding opening bracket; at the end, verify the stack is empty"),
                QuestionOption("b", "Count whether the total number of opening brackets equals the total number of closing brackets (which falsely accepts `\"([)]\"` and `\")( \"`!)"),
                QuestionOption("c", "Sort the characters alphabetically"),
                QuestionOption("d", "Use a FIFO Queue")
            ),
            correctOptionId = "a",
            explanation = "Because the most recently opened bracket must be closed first (LIFO), a Stack validates both bracket counts and proper nesting order in O(n) time."
        ),
        QuizQuestion(
            id = "cs_a_69",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is `Tail Recursion` (Tail-Call Optimization / TCO, supported via `tailrec` in Kotlin)?",
            options = listOf(
                QuestionOption("a", "When a recursive function calls itself at the very first line before the base case"),
                QuestionOption("b", "When two functions call each other infinitely"),
                QuestionOption("c", "When recursion runs on a background thread"),
                QuestionOption("d", "When the recursive call is the very last operation performed by the function before returning (with no pending work after the call), allowing the compiler to reuse the current stack frame in a loop with `O(1)` stack space")
            ),
            correctOptionId = "d",
            explanation = "In tail recursion (e.g., `tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)`), the compiler compiles the recursion into a flat iterative jump with zero stack growth."
        ),
        QuizQuestion(
            id = "cs_a_70",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Using the Euclidean Algorithm `gcd(a, b) = gcd(b, a % b)`, what is the Greatest Common Divisor of `48` and `18`?",
            options = listOf(
                QuestionOption("a", "9"),
                QuestionOption("b", "12"),
                QuestionOption("c", "6 (`gcd(48, 18) -> gcd(18, 12) -> gcd(12, 6) -> gcd(6, 0) = 6`)"),
                QuestionOption("d", "3")
            ),
            correctOptionId = "c",
            explanation = "48 % 18 = 12; 18 % 12 = 6; 12 % 6 = 0, so the GCD is 6 (and Euclidean GCD runs in `O(log(min(a, b)))` time)."
        ),
        QuizQuestion(
            id = "cs_a_71",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can you test whether a positive integer `n` is a power of two (`1, 2, 4, 8, 16, ...`) in `O(1)` time using a single bitwise expression?",
            options = listOf(
                QuestionOption("a", "`n % 2 == 0` (which is true for `6`, `10`, `12` even though they are not powers of 2!)"),
                QuestionOption("b", "`n > 0 && (n & (n - 1)) == 0`"),
                QuestionOption("c", "`(n | (n - 1)) == 0`"),
                QuestionOption("d", "`(n ^ (n - 1)) == 1`")
            ),
            correctOptionId = "b",
            explanation = "A power of two has exactly one `1`-bit in binary; `n & (n - 1)` clears the lowest set bit, which yields `0` if and only if `n` had only one set bit!"
        ),
        QuizQuestion(
            id = "cs_a_72",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does Brian Kernighan's bitwise step `n = n & (n - 1)` do on each iteration of a loop `while (n != 0)`?",
            options = listOf(
                QuestionOption("a", "Clears the lowest (rightmost) set `1`-bit of `n`, counting the exact number of set `1`-bits (popcount / Hamming weight) in `O(number of set bits)` iterations"),
                QuestionOption("b", "Clears the highest set bit"),
                QuestionOption("c", "Divides `n` by 2"),
                QuestionOption("d", "Inverts all bits of `n`")
            ),
            correctOptionId = "a",
            explanation = "Subtracting 1 flips the lowest `1`-bit to `0` and all trailing `0`s to `1`s, so `n & (n - 1)` zeroes out that lowest `1`-bit in one operation."
        ),
        QuizQuestion(
            id = "cs_a_73",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In bitwise arithmetic, what does `n & -n` (or `n & (~n + 1)` in two's complement) isolate?",
            options = listOf(
                QuestionOption("a", "The highest set `1`-bit of `n`"),
                QuestionOption("b", "Always `0`"),
                QuestionOption("c", "Always `-1`"),
                QuestionOption("d", "The lowest (rightmost) set `1`-bit of `n` (e.g., for `n = 12 = 1100_2`, `12 & -12 = 0100_2 = 4`)")
            ),
            correctOptionId = "d",
            explanation = "In two's complement, `-n = ~n + 1` flips all bits above the lowest `1`-bit and keeps the lowest `1`-bit and trailing zeros identical, so `n & -n` isolates that lowest `1`-bit (used in Fenwick Trees!)."
        ),
        QuizQuestion(
            id = "cs_a_74",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you find the maximum subarray sum of a 1D array of `n` integers (containing both positive and negative numbers) in `O(n)` time and `O(1)` space?",
            options = listOf(
                QuestionOption("a", "Use Binary Search on the array indices"),
                QuestionOption("b", "Compute prefix products only"),
                QuestionOption("c", "Kadane's Algorithm: track `cur = max(x, cur + x)` and `best = max(best, cur)` for each element `x`"),
                QuestionOption("d", "Sort the array and sum all positive numbers (which breaks contiguous subarray order!)")
            ),
            correctOptionId = "c",
            explanation = "Kadane's algorithm decides at each index in O(1) whether to extend the best subarray ending at `i-1` or start fresh at `i`."
        ),
        QuizQuestion(
            id = "cs_a_75",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given an array `nums` and a target `T`, how can you count or find subarrays whose sum equals `T` in `O(n)` time (even when `nums` contains negative numbers where a sliding window fails)?",
            options = listOf(
                QuestionOption("a", "Use Binary Search on `nums`"),
                QuestionOption("b", "Maintain a running `prefixSum` and a `HashMap` of frequencies of previous prefix sums, checking how many times `prefixSum - T` has occurred so far"),
                QuestionOption("c", "Use a two-pointer sliding window (which fails when negative numbers can shrink/grow sums non-monotonically!)"),
                QuestionOption("d", "Sort the array first")
            ),
            correctOptionId = "b",
            explanation = "Since `sum(i..j) = pref[j] - pref[i-1] = T`, we have `pref[i-1] = pref[j] - T`, which a HashMap of seen prefix sums looks up in O(1) per index."
        ),
        QuizQuestion(
            id = "cs_a_76",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does the standard two-pointer `Sliding Window` for subarray sum fail when the array contains negative numbers?",
            options = listOf(
                QuestionOption("a", "Because advancing `right` can DECREASE the window sum and advancing `left` can INCREASE the window sum, breaking the monotonicity required to know when to expand or shrink the window"),
                QuestionOption("b", "Because negative numbers cannot be stored in CPU registers"),
                QuestionOption("c", "Because `left` cannot be compared to `right`"),
                QuestionOption("d", "It does not fail; two-pointer sliding window works on all negative arrays")
            ),
            correctOptionId = "a",
            explanation = "Two-pointer window shrinking relies on a monotonic invariant (e.g., adding non-negative numbers only increases the sum)."
        ),
        QuizQuestion(
            id = "cs_a_77",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a sorted array with duplicate values, how do you find the FIRST (leftmost) index of a target `T` in `O(log n)` time using `Binary Search` (lower_bound)?",
            options = listOf(
                QuestionOption("a", "Stop as soon as `arr[mid] == T` and walk linearly left (which degrades to `O(n)` if all elements equal `T`!)"),
                QuestionOption("b", "Use Linear Search from index 0"),
                QuestionOption("c", "Sort the array in reverse"),
                QuestionOption("d", "When `arr[mid] >= T`, record `mid` (or set `high = mid`) and continue searching the LEFT half (`high = mid - 1`) instead of stopping immediately when `arr[mid] == T`")
            ),
            correctOptionId = "d",
            explanation = "Continuing binary search into `[low, mid - 1]` whenever `arr[mid] >= T` finds the exact first occurrence boundary in strict `O(log n)` time."
        ),
        QuizQuestion(
            id = "cs_a_78",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is `Binary Search on the Answer` (Parametric Search), used for problems like 'Minimum capacity to ship packages within D days' or 'Koko eating bananas'?",
            options = listOf(
                QuestionOption("a", "Running BFS on a binary tree"),
                QuestionOption("b", "Searching for the answer inside a hash table"),
                QuestionOption("c", "When the feasibility predicate `canComplete(capacity)` is monotonic (`false, false, ..., true, true`), binary search over the range `[minCap, maxCap]` finds the minimum feasible capacity in `O(n * log(range))` time!"),
                QuestionOption("d", "Sorting the answer choices alphabetically")
            ),
            correctOptionId = "c",
            explanation = "Whenever a boolean predicate `check(x)` transitions monotonically from `false` to `true`, binary search over the domain of `x` finds the threshold in `O(log(high - low))` calls to `check`."
        ),
        QuizQuestion(
            id = "cs_a_79",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a Binary Tree, what is the `Lowest Common Ancestor (LCA)` of two nodes `p` and `q`?",
            options = listOf(
                QuestionOption("a", "The leaf node with the smallest value"),
                QuestionOption("b", "The deepest node in the tree that has BOTH `p` and `q` as descendants (where a node is allowed to be a descendant of itself)"),
                QuestionOption("c", "The root of the entire tree in all cases"),
                QuestionOption("d", "The parent of the root node")
            ),
            correctOptionId = "b",
            explanation = "The LCA is the shared ancestor of `p` and `q` farthest from the root (closest to `p` and `q`)."
        ),
        QuizQuestion(
            id = "cs_a_80",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a `Binary Search Tree (BST)`, how can you find the `Lowest Common Ancestor (LCA)` of two nodes with keys `p` and `q` in `O(height)` time and `O(1)` space?",
            options = listOf(
                QuestionOption("a", "Start at `root`: if both `p, q < cur.key`, move left; if both `p, q > cur.key`, move right; the first node where `p` and `q` split (or one equals `cur.key`) is the LCA!"),
                QuestionOption("b", "Run an in-order traversal into an array and sort it"),
                QuestionOption("c", "Check every pair of nodes in `O(n^2)` time"),
                QuestionOption("d", "Reverse all pointers in the BST")
            ),
            correctOptionId = "a",
            explanation = "The BST ordering property tells you in O(1) at each node whether both targets lie in the left subtree, both lie in the right subtree, or split at the current node."
        ),
        QuizQuestion(
            id = "cs_a_81",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you validate whether a binary tree is a valid `Binary Search Tree (BST)` in `O(n)` time?",
            options = listOf(
                QuestionOption("a", "Only check at each node whether `node.left.val < node.val < node.right.val` (which is a bug!)"),
                QuestionOption("b", "Check that the left and right subtrees have equal height"),
                QuestionOption("c", "Count the number of leaves"),
                QuestionOption("d", "Pass down a valid range `(minBound, maxBound)` recursively: verify `minBound < node.val < maxBound`, recurse left with `(minBound, node.val)` and right with `(node.val, maxBound)` (or check that in-order traversal is strictly increasing)")
            ),
            correctOptionId = "d",
            explanation = "Checking only immediate children fails when a deeper descendant in the left subtree is larger than an ancestor above its parent! Passing `(min, max)` bounds validates the entire subtree invariant."
        ),
        QuizQuestion(
            id = "cs_a_82",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is checking ONLY `node.left.val < node.val && node.right.val > node.val` insufficient to prove a binary tree is a valid BST?",
            options = listOf(
                QuestionOption("a", "Because BSTs can have 3 children"),
                QuestionOption("b", "It IS sufficient for all binary trees"),
                QuestionOption("c", "A node in the left subtree could be greater than the root (e.g., root `10`, left child `5`, and `5`'s right child `12` satisfies `12 > 5` locally, but `12 > 10` violates the root's left-subtree BST invariant!)"),
                QuestionOption("d", "Because leaf nodes do not have values")
            ),
            correctOptionId = "c",
            explanation = "The BST property is a global subtree invariant (`all keys in left subtree < node.key`), not merely a parent-child check."
        ),
        QuizQuestion(
            id = "cs_a_83",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the `Diameter` of a binary tree, and how is it computed in `O(n)` time?",
            options = listOf(
                QuestionOption("a", "The shortest path from root to a leaf"),
                QuestionOption("b", "The length (number of edges) of the longest path between ANY two nodes in the tree (which may or may not pass through the root); computed in a single post-order DFS that returns `height` while updating `maxDiameter = max(maxDiameter, leftHeight + rightHeight)`"),
                QuestionOption("c", "Always `2 * height(root)`"),
                QuestionOption("d", "The number of nodes in the bottom level")
            ),
            correctOptionId = "b",
            explanation = "At every node `u`, the longest path whose highest point is `u` has length `height(u.left) + height(u.right)`, which a post-order traversal computes in O(n) total time."
        ),
        QuizQuestion(
            id = "cs_a_84",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you reverse a Singly Linked List iteratively in `O(n)` time and `O(1)` auxiliary space?",
            options = listOf(
                QuestionOption("a", "Maintain `prev = null` and `cur = head`; in a loop, save `next = cur.next`, set `cur.next = prev`, advance `prev = cur` and `cur = next`, and return `prev`"),
                QuestionOption("b", "Swap `head.val` and `tail.val` only"),
                QuestionOption("c", "Create a new array of size `n` (which takes `O(n)` space)"),
                QuestionOption("d", "Set `head.next = head`")
            ),
            correctOptionId = "a",
            explanation = "Rewiring each node's `next` pointer to `prev` in a single pass reverses the list in place in O(n) time and O(1) space."
        ),
        QuizQuestion(
            id = "cs_a_85",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can you find the middle node of a Singly Linked List in a single pass (`O(n)` time, `O(1)` space) without counting the length first?",
            options = listOf(
                QuestionOption("a", "Advance both pointers by 1 step"),
                QuestionOption("b", "Use Binary Search on the linked list (impossible in O(log n) without random access)"),
                QuestionOption("c", "Reverse the list twice"),
                QuestionOption("d", "Use two pointers starting at `head`: advance `slow` by 1 step and `fast` by 2 steps each iteration; when `fast` reaches the end (`fast == null || fast.next == null`), `slow` is at the middle node!")
            ),
            correctOptionId = "d",
            explanation = "Since `fast` moves at twice the speed of `slow`, when `fast` covers `n` nodes, `slow` has covered `n / 2` nodes."
        ),
        QuizQuestion(
            id = "cs_a_86",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is an `LRU (Least Recently Used) Cache`, and how do you implement both `get(key)` and `put(key, value)` in strict `O(1)` time?",
            options = listOf(
                QuestionOption("a", "Use a `Binary Search Tree` (which takes O(log n) time)"),
                QuestionOption("b", "Use a `FIFO Queue` without a map"),
                QuestionOption("c", "Combine a `HashMap<Key, Node>` (for O(1) node lookup by key) with a `Doubly Linked List` (for O(1) removal and O(1) insertion at the most-recently-used head/tail and eviction from the least-recently-used end)"),
                QuestionOption("d", "Use a single unsorted `ArrayList`")
            ),
            correctOptionId = "c",
            explanation = "The HashMap gives O(1) direct access to the Doubly Linked List node, and the Doubly Linked List moves accessed nodes to the MRU end or evicts the LRU node in O(1) pointer updates."
        ),
        QuizQuestion(
            id = "cs_a_87",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does an `LRU Cache` require a `Doubly Linked List` rather than a `Singly Linked List` alongside its `HashMap`?",
            options = listOf(
                QuestionOption("a", "A Singly Linked List can remove any middle node in O(1) without knowing its predecessor"),
                QuestionOption("b", "To remove an arbitrary node from the middle of the list in `O(1)` time when it is accessed (`get`/`put`), you need immediate access to its `prev` pointer so you can set `node.prev.next = node.next`!"),
                QuestionOption("c", "Because a Singly Linked List cannot store keys"),
                QuestionOption("d", "Because a Doubly Linked List uses less memory per node")
            ),
            correctOptionId = "b",
            explanation = "In a singly linked list, finding the predecessor `prev` of a node takes O(n) traversal; a doubly linked node stores `prev` directly for O(1) unlinking."
        ),
        QuizQuestion(
            id = "cs_a_88",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In interval scheduling ('Maximum number of non-overlapping meetings/intervals you can attend'), which greedy choice is provably optimal?",
            options = listOf(
                QuestionOption("a", "Sort intervals by their `END time` ascending, and greedily pick each interval whose `start >= last_picked_end`!"),
                QuestionOption("b", "Sort intervals by their `START time` ascending (fails if one early meeting spans the entire day!)"),
                QuestionOption("c", "Sort intervals by shortest duration first (fails when a short interval overlaps two adjacent intervals!)"),
                QuestionOption("d", "Pick intervals in random order")
            ),
            correctOptionId = "a",
            explanation = "Finishing as early as possible (`earliest end time first`) leaves the maximum possible remaining time for subsequent intervals—a classic exchange-argument proof."
        ),
        QuizQuestion(
            id = "cs_a_89",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In interval merging ('Merge all overlapping intervals `[start, end]`'), what is the standard `O(n log n)` algorithm?",
            options = listOf(
                QuestionOption("a", "Sort by `end - start` duration only"),
                QuestionOption("b", "Check all pairs in `O(n^2)` without sorting"),
                QuestionOption("c", "Use a Queue without sorting"),
                QuestionOption("d", "Sort all intervals by `start` time ascending; iterate through and if `cur.start <= prev.end`, merge them via `prev.end = max(prev.end, cur.end)`, otherwise append `cur` as a new interval")
            ),
            correctOptionId = "d",
            explanation = "Once sorted by `start` ascending, overlapping intervals are guaranteed to be adjacent in the merged output."
        ),
        QuizQuestion(
            id = "cs_a_90",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you find the minimum number of conference rooms required to host all given intervals `[start_i, end_i]` in `O(n log n)` time?",
            options = listOf(
                QuestionOption("a", "Sort by duration descending"),
                QuestionOption("b", "Pick the single longest interval"),
                QuestionOption("c", "Sort intervals by `start` time and maintain a `Min-Heap` of `end` times of currently active meetings (popping the earliest ending room if `heap.peek() <= cur.start`), or use a sweep-line (+1 at start, -1 at end)"),
                QuestionOption("d", "Count the total number of intervals")
            ),
            correctOptionId = "c",
            explanation = "The Min-Heap tracks the room that frees up earliest (`peek()`), or a chronological sweep-line tracks the maximum concurrent overlap."
        ),
        QuizQuestion(
            id = "cs_a_91",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is `Backtracking` (e.g., for N-Queens, Sudoku, Subsets, or Permutations), and how does `Pruning` improve its performance?",
            options = listOf(
                QuestionOption("a", "A sorting algorithm"),
                QuestionOption("b", "A depth-first search over the state-space tree that builds candidates incrementally and undoes choices on return; Pruning abandons a partial branch as soon as it violates a constraint, avoiding exploring its entire exponential subtree"),
                QuestionOption("c", "A greedy algorithm that never undoes any decision"),
                QuestionOption("d", "A breadth-first search that stores all states in RAM")
            ),
            correctOptionId = "b",
            explanation = "Pruning cuts off invalid partial assignments early in the recursion tree, often reducing the practical search space by orders of magnitude."
        ),
        QuizQuestion(
            id = "cs_a_92",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many subsets (the power set) and how many permutations exist for a set of `n` distinct elements?",
            options = listOf(
                QuestionOption("a", "`2^n` subsets and `n!` permutations"),
                QuestionOption("b", "`n!` subsets and `2^n` permutations"),
                QuestionOption("c", "`n^2` subsets and `n^3` permutations"),
                QuestionOption("d", "`2n` subsets and `n^2` permutations")
            ),
            correctOptionId = "a",
            explanation = "For subsets, each of the `n` elements has 2 independent choices (include or exclude) = `2^n`; for permutations, there are `n * (n-1) * ... * 1 = n!` orderings."
        ),
        QuizQuestion(
            id = "cs_a_93",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Graph Traversal (`BFS` / `DFS`) on an undirected or directed graph with cycles, when should a vertex be marked `visited` when using a `BFS` queue to avoid pushing the same vertex into the queue multiple times?",
            options = listOf(
                QuestionOption("a", "Mark it visited only after all its neighbors have been popped"),
                QuestionOption("b", "Never mark vertices visited in BFS"),
                QuestionOption("c", "Only mark leaf nodes visited"),
                QuestionOption("d", "Mark a neighbor `visited` at the moment it is ENQUEUED (pushed into the queue), NOT when it is dequeued (popped)!")
            ),
            correctOptionId = "d",
            explanation = "If you wait until a vertex is popped to mark it visited, multiple neighbors in the current frontier wave can enqueue the same unvisited vertex repeatedly, blowing up queue size to `O(|E|)`."
        ),
        QuizQuestion(
            id = "cs_a_94",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In DFS on a `Directed Graph`, why do you need `3 states` (`UNVISITED = 0`, `VISITING / IN_STACK = 1`, `VISITED / DONE = 2`) to detect a directed cycle, whereas `visited + parent` suffices in an `Undirected Graph`?",
            options = listOf(
                QuestionOption("a", "Because undirected graphs cannot have cycles"),
                QuestionOption("b", "2 states without tracking the recursion stack are sufficient in directed graphs"),
                QuestionOption("c", "In a directed graph, reaching an already-completed (`DONE = 2`) vertex from another branch is a harmless cross/forward edge (e.g., `A -> B`, `A -> C`, `B -> C`); a cycle exists ONLY if DFS encounters an ancestor currently on the active recursion stack (`VISITING = 1`, a back-edge)!"),
                QuestionOption("d", "Because directed graphs have 3 edges per node")
            ),
            correctOptionId = "c",
            explanation = "A diamond DAG (`A -> B -> D` and `A -> C -> D`) visits `D` twice from different paths without having any cycle; only an edge to an active ancestor (`VISITING`) forms a directed cycle."
        ),
        QuizQuestion(
            id = "cs_a_95",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In networking, what is the difference between a `Forward Proxy` (Client Proxy / VPN gateway) and a `Reverse Proxy` (Load Balancer / CDN edge like Nginx or Cloudflare)?",
            options = listOf(
                QuestionOption("a", "They are identical"),
                QuestionOption("b", "A Forward Proxy sits in front of CLIENTS to make requests to the internet on their behalf; a Reverse Proxy sits in front of backend SERVERS to terminate TLS, cache responses, and load-balance incoming client traffic across server instances"),
                QuestionOption("c", "A Reverse Proxy runs inside the user's web browser"),
                QuestionOption("d", "A Forward Proxy only works with UDP")
            ),
            correctOptionId = "b",
            explanation = "Clients talk to a Reverse Proxy thinking it is the origin server, while the Reverse Proxy distributes load across internal backend servers."
        ),
        QuizQuestion(
            id = "cs_a_96",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Operating Systems, what is the difference between `Concurrency` and `Parallelism`?",
            options = listOf(
                QuestionOption("a", "Concurrency is structuring a program to deal with multiple tasks whose execution lifetimes overlap (even via interleaved time-slicing on 1 CPU core); Parallelism is physically executing multiple tasks at the exact same instant across multiple CPU cores"),
                QuestionOption("b", "Concurrency requires at least 8 CPU cores, while Parallelism runs on 1 core"),
                QuestionOption("c", "Parallelism is only possible in interpreted languages"),
                QuestionOption("d", "They are synonyms with no distinction")
            ),
            correctOptionId = "a",
            explanation = "As Rob Pike summarized: Concurrency is about dealing with lots of things at once (composition); Parallelism is about doing lots of things at once (simultaneous multi-core execution)."
        ),
        QuizQuestion(
            id = "cs_a_97",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In garbage-collected runtimes (like JVM / ART / Python), what is the fundamental flaw of pure `Reference Counting` (without a cycle detector) compared to `Tracing Mark-and-Sweep` garbage collection?",
            options = listOf(
                QuestionOption("a", "Reference Counting pauses the program for 10 minutes on every allocation"),
                QuestionOption("b", "Mark-and-Sweep cannot reclaim arrays"),
                QuestionOption("c", "Reference Counting requires 64 GB of RAM"),
                QuestionOption("d", "Pure Reference Counting cannot reclaim isolated cyclic references (where Object A points to Object B and Object B points to Object A, keeping both reference counts at `1` even when unreachable from roots)!")
            ),
            correctOptionId = "d",
            explanation = "Tracing collectors start from GC roots (stacks, globals, registers) and mark all reachable objects, naturally sweeping any unreachable island even if it contains internal cycles."
        ),
        QuizQuestion(
            id = "cs_a_98",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Android / JVM / modern runtimes, what is the `Generational Hypothesis` behind `Generational Garbage Collection` (Young Generation / Eden vs. Old / Tenured Generation)?",
            options = listOf(
                QuestionOption("a", "Strings never become garbage"),
                QuestionOption("b", "Objects allocated in loops live forever"),
                QuestionOption("c", "Most allocated objects die young (become unreachable very shortly after allocation), so collecting a small Young Generation frequently (via fast copying/scavenging of the few survivors) is much more efficient than scanning the entire heap every time!"),
                QuestionOption("d", "Old objects are smaller than young objects")
            ),
            correctOptionId = "c",
            explanation = "In a generational copying collector, minor GC only copies the small percentage of live objects out of Eden/Survivor spaces, making reclamation of dead temporary objects nearly free."
        ),
        QuizQuestion(
            id = "cs_a_99",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In software architecture and databases, what is `Write-Ahead Logging (WAL)` and which ACID property does it primarily implement?",
            options = listOf(
                QuestionOption("a", "It sorts SQL results in ascending order"),
                QuestionOption("b", "Before modifying data pages on disk, changes are sequentially appended and flushed to an append-only redo/undo log; this guarantees `Durability` (and `Atomicity` via undo rollback) across sudden power loss or crashes"),
                QuestionOption("c", "It caches network DNS responses in memory"),
                QuestionOption("d", "It compresses images before uploading")
            ),
            correctOptionId = "b",
            explanation = "Upon crash recovery, the database replays committed redo records and rolls back uncommitted undo records from the WAL."
        ),
        QuizQuestion(
            id = "cs_a_100",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In IEEE 754 floating-point numbers, what happens when you evaluate `1.0 / 0.0`, `-1.0 / 0.0`, and `0.0 / 0.0` (and what is unusual about `NaN == NaN`)?",
            options = listOf(
                QuestionOption("a", "They produce `+Infinity`, `-Infinity`, and `NaN` (Not a Number); by IEEE 754 rules, `NaN == NaN` is ALWAYS `false` (use `Double.isNaN(x)` to test for `NaN`)!"),
                QuestionOption("b", "All three throw an integer `ArithmeticException`"),
                QuestionOption("c", "`NaN == NaN` is `true`"),
                QuestionOption("d", "`1.0 / 0.0` equals `0.0`")
            ),
            correctOptionId = "a",
            explanation = "Unlike integer division by zero (which throws `ArithmeticException` in Java/Kotlin), IEEE 754 floating-point division by zero produces signed Infinity or `NaN`, and `NaN != NaN`."
        )
    )

    private fun advancedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "cs_adv_16",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the Master Theorem for divide-and-conquer recurrences `T(n) = a * T(n / b) + f(n)`, what is the asymptotic time complexity of `T(n) = 2 * T(n / 2) + Theta(n)`?",
            options = listOf(
                QuestionOption("a", "Theta(n log n) (Case 2: `n^(log_b(a)) = n^(log_2(2)) = n^1`, which matches `f(n) = Theta(n)`)"),
                QuestionOption("b", "Theta(n)"),
                QuestionOption("c", "Theta(n^2)"),
                QuestionOption("d", "Theta(log n)")
            ),
            correctOptionId = "a",
            explanation = "Here `a = 2, b = 2`, so `n^(log_b a) = n^1`. Since `f(n) = Theta(n)` matches `n^(log_b a)`, Case 2 gives `Theta(n log n)` (as in Merge Sort)."
        ),
        QuizQuestion(
            id = "cs_adv_17",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the Master Theorem, what is the asymptotic solution to `T(n) = 4 * T(n / 2) + Theta(n)`?",
            options = listOf(
                QuestionOption("a", "Theta(n log n)"),
                QuestionOption("b", "Theta(n)"),
                QuestionOption("c", "Theta(4^n)"),
                QuestionOption("d", "Theta(n^2) (Case 1: `n^(log_2(4)) = n^2` dominates `f(n) = Theta(n)`)")
            ),
            correctOptionId = "d",
            explanation = "`n^(log_2 4) = n^2` is polynomially larger than `f(n) = n^1`, so the leaf work at the bottom of the recursion tree dominates: `Theta(n^2)`."
        ),
        QuizQuestion(
            id = "cs_adv_18",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the Master Theorem, what is the asymptotic solution to Binary Search's recurrence `T(n) = T(n / 2) + Theta(1)`?",
            options = listOf(
                QuestionOption("a", "Theta(n)"),
                QuestionOption("b", "Theta(n log n)"),
                QuestionOption("c", "Theta(log n) (Case 2: `a = 1, b = 2 => n^(log_2(1)) = n^0 = 1`, matching `f(n) = Theta(1)`)"),
                QuestionOption("d", "Theta(1)")
            ),
            correctOptionId = "c",
            explanation = "With 1 recursive call of half size and O(1) work per level across `log2(n)` levels, `T(n) = Theta(log n)`."
        ),
        QuizQuestion(
            id = "cs_adv_19",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the recurrence `T(n) = 2 * T(n / 2) + Theta(n log n)` equal to (an extension of Master Theorem Case 2 where `f(n) = Theta(n^(log_b a) * log^k n)` with `k = 1`)?",
            options = listOf(
                QuestionOption("a", "Theta(n)"),
                QuestionOption("b", "Theta(n * (log n)^2)"),
                QuestionOption("c", "Theta(n log n)"),
                QuestionOption("d", "Theta(n^2)")
            ),
            correctOptionId = "b",
            explanation = "When `f(n) = Theta(n^(log_b a) * log^k n)` for `k >= 0`, each of the `log n` levels contributes `n log^k n`, summing to `Theta(n^(log_b a) * log^(k+1) n) = Theta(n log^2 n)`."
        ),
        QuizQuestion(
            id = "cs_adv_20",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Disjoint Set (Union-Find)`, when BOTH `Path Compression` (in `find`) and `Union by Rank / Size` (in `union`) are used, what is the amortized time complexity per operation over `m` operations on `n` elements?",
            options = listOf(
                QuestionOption("a", "O(alpha(n)), where `alpha(n)` is the inverse Ackermann function (`<= 4` for all practical `n`, effectively constant time)"),
                QuestionOption("b", "O(log n)"),
                QuestionOption("c", "O(sqrt(n))"),
                QuestionOption("d", "O(n)")
            ),
            correctOptionId = "a",
            explanation = "Tarjan proved that Union-Find with both path compression and union by rank/size achieves `O(alpha(n))` amortized time per operation."
        ),
        QuizQuestion(
            id = "cs_adv_21",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can `Dijkstra's Algorithm` produce an INCORRECT shortest path when a graph contains a negative-weight edge (even if there is no negative-weight cycle)?",
            options = listOf(
                QuestionOption("a", "Because binary heaps cannot store negative integers"),
                QuestionOption("b", "Because negative numbers cause division by zero"),
                QuestionOption("c", "Dijkstra always works on negative edges as long as there are no cycles"),
                QuestionOption("d", "Dijkstra greedily finalizes the vertex `u` popped with minimum tentative distance and assumes adding more edges can only increase path cost; a later negative edge `v -> u` can create a shorter path to `u` after `u` was already finalized!")
            ),
            correctOptionId = "d",
            explanation = "Consider `S -> A (cost 2)`, `S -> B (cost 3)`, and `B -> A (cost -2)`. Standard Dijkstra finalizes `A` at cost 2 first, missing the `S -> B -> A` path of cost `3 + (-2) = 1`."
        ),
        QuizQuestion(
            id = "cs_adv_22",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does the `Bellman-Ford Algorithm` handle negative edge weights and detect negative-weight cycles reachable from the source in a graph `G = (V, E)`?",
            options = listOf(
                QuestionOption("a", "It squares the adjacency matrix"),
                QuestionOption("b", "It deletes all negative edges before running"),
                QuestionOption("c", "It relaxes all `|E|` edges `|V| - 1` times in `O(|V| * |E|)` time (since any simple shortest path has at most `|V| - 1` edges); if a `|V|`-th relaxation pass can still decrease any distance, a reachable negative cycle exists!"),
                QuestionOption("d", "It sorts edges in `O(|E| log |E|)` and runs once")
            ),
            correctOptionId = "c",
            explanation = "Every simple path in a graph with `|V|` vertices has at most `|V| - 1` edges; if any distance still improves on pass `|V|`, the path has `>= |V|` edges and therefore traverses a negative-weight cycle."
        ),
        QuizQuestion(
            id = "cs_adv_23",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the time and space complexity of the `Floyd-Warshall` All-Pairs Shortest Path algorithm on a graph with `V` vertices, and what is its core DP transition?",
            options = listOf(
                QuestionOption("a", "`O(2^V)` time"),
                QuestionOption("b", "`O(V^3)` time and `O(V^2)` space, iterating intermediate vertex `k` as the OUTERMOST loop: `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`"),
                QuestionOption("c", "`O(V^2)` time with `k` as the innermost loop"),
                QuestionOption("d", "`O(V * E)` time")
            ),
            correctOptionId = "b",
            explanation = "In Floyd-Warshall, `k` MUST be the outermost loop (`for k in 0..<V: for i: for j:`) because state `dp[k][i][j]` means shortest path from `i` to `j` using only intermediate vertices from `{0..k}`."
        ),
        QuizQuestion(
            id = "cs_adv_24",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens in `Floyd-Warshall` if you accidentally place `k` (the intermediate vertex) as the INNERMOST loop (`for i: for j: for k:`) instead of the outermost loop?",
            options = listOf(
                QuestionOption("a", "The algorithm fails to find multi-hop shortest paths in a single pass because `dist[i][k]` and `dist[k][j]` have not yet been computed through all intermediate vertices!"),
                QuestionOption("b", "It runs faster and produces the exact same answer"),
                QuestionOption("c", "It throws an ArrayIndexOutOfBoundsException"),
                QuestionOption("d", "It finds longest paths instead")
            ),
            correctOptionId = "a",
            explanation = "Placing `k` on the outside ensures that by iteration `k`, all shortest paths using intermediate vertices `{0..k-1}` are already finalized."
        ),
        QuizQuestion(
            id = "cs_adv_25",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a `DAG (Directed Acyclic Graph)` with arbitrary positive AND negative edge weights, how fast can single-source shortest (or longest) paths be computed?",
            options = listOf(
                QuestionOption("a", "Only in `O(|V| * |E|)` using Bellman-Ford"),
                QuestionOption("b", "Only in `O((|V| + |E|) log |V|)` using Dijkstra"),
                QuestionOption("c", "Longest path in a DAG is NP-Hard"),
                QuestionOption("d", "In `O(|V| + |E|)` linear time by topologically sorting the vertices and relaxing outgoing edges of each vertex in topological order!")
            ),
            correctOptionId = "d",
            explanation = "While Longest Simple Path in a general cyclic graph is NP-Hard, in a DAG both shortest and longest paths are solved in `O(|V| + |E|)` by DP in topological order!"
        ),
        QuizQuestion(
            id = "cs_adv_26",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Graph Theory, what is a `Strongly Connected Component (SCC)` of a directed graph, and which algorithms find all SCCs in `O(|V| + |E|)` linear time?",
            options = listOf(
                QuestionOption("a", "A clique where every pair has a direct edge"),
                QuestionOption("b", "A bipartite graph"),
                QuestionOption("c", "A maximal subset of vertices where every vertex is reachable from every other vertex in the subset; found in `O(|V| + |E|)` by `Tarjan's` or `Kosaraju's` algorithm"),
                QuestionOption("d", "Any connected component of an undirected graph; found by Kruskal's algorithm")
            ),
            correctOptionId = "c",
            explanation = "Kosaraju's (two DFS passes using reverse post-order on the transposed graph) and Tarjan's (single DFS pass tracking discovery times and `lowlink` values on a stack) find all SCCs in `O(|V| + |E|)`."
        ),
        QuizQuestion(
            id = "cs_adv_27",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If you collapse each `Strongly Connected Component (SCC)` of any directed graph into a single super-node (the condensation graph), what structure does the resulting graph ALWAYS have?",
            options = listOf(
                QuestionOption("a", "A binary tree"),
                QuestionOption("b", "A `Directed Acyclic Graph (DAG)`!"),
                QuestionOption("c", "A complete graph"),
                QuestionOption("d", "A single cycle")
            ),
            correctOptionId = "b",
            explanation = "If the condensation graph had a cycle between two distinct super-nodes, all vertices in those super-nodes would be mutually reachable and would have been merged into a single SCC!"
        ),
        QuizQuestion(
            id = "cs_adv_28",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Bipartite Graph`, and how can you test whether an undirected graph is bipartite in `O(|V| + |E|)` time?",
            options = listOf(
                QuestionOption("a", "A graph whose vertices can be 2-colored such that no edge connects two vertices of the same color (equivalent to having NO odd-length cycles); tested via 2-coloring in `BFS` or `DFS`"),
                QuestionOption("b", "A graph with exactly 2 vertices"),
                QuestionOption("c", "A graph where every vertex has degree 2"),
                QuestionOption("d", "A graph with no cycles at all")
            ),
            correctOptionId = "a",
            explanation = "A graph is bipartite if and only if it contains no odd-length cycle, which is easily checked by assigning alternating colors (`0` and `1`) along BFS/DFS edges."
        ),
        QuizQuestion(
            id = "cs_adv_29",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between the `0/1 Knapsack` problem and the `Fractional Knapsack` problem in terms of optimal algorithm and complexity?",
            options = listOf(
                QuestionOption("a", "Both are solved greedily by sorting by `value / weight`"),
                QuestionOption("b", "0/1 Knapsack is solved in `O(n)` greedy time while Fractional requires DP"),
                QuestionOption("c", "Neither can be solved for `n > 10`"),
                QuestionOption("d", "Fractional Knapsack is solved greedily by sorting items by `value / weight` ratio in `O(n log n)`; 0/1 Knapsack (where items cannot be split) fails with the greedy ratio heuristic and requires Dynamic Programming in `O(n * W)` pseudo-polynomial time")
            ),
            correctOptionId = "d",
            explanation = "In 0/1 Knapsack, taking a high-ratio item can leave unused capacity that two slightly lower-ratio items would fill for higher total value; DP (`dp[w] = max(dp[w], dp[w - wt] + val)`) solves it."
        ),
        QuizQuestion(
            id = "cs_adv_30",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is the `O(n * W)` Dynamic Programming solution for `0/1 Knapsack` called `Pseudo-Polynomial Time` rather than true Polynomial Time?",
            options = listOf(
                QuestionOption("a", "Because `n * W` is faster than `O(1)`"),
                QuestionOption("b", "Because `W` is always a floating-point number"),
                QuestionOption("c", "Because the input size in bits to represent the integer capacity `W` is `b = log2(W)` bits, and `W = 2^b` is exponential in the bit-length `b` of `W`!"),
                QuestionOption("d", "Because it uses random numbers")
            ),
            correctOptionId = "c",
            explanation = "Complexity is measured relative to the bit length of the input encoding; `W` takes `O(log W)` bits to write down, so `O(n * W) = O(n * 2^(bits of W))` is pseudo-polynomial."
        ),
        QuizQuestion(
            id = "cs_adv_31",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In 1D space-optimized Dynamic Programming for `0/1 Knapsack` vs. `Unbounded Knapsack` (where each item can be used multiple times), why does the loop direction over capacity `w` matter?",
            options = listOf(
                QuestionOption("a", "Iterating forward solves 0/1 Knapsack and backward solves Unbounded Knapsack"),
                QuestionOption("b", "For `0/1 Knapsack`, iterating `w` BACKWARD from `W` down to `wt` ensures each item is used at most once (reading from the previous row's state); iterating `w` FORWARD from `wt` to `W` allows an item to be reused multiple times in the same pass (`Unbounded Knapsack`)!"),
                QuestionOption("c", "Iterating backward is only for performance on CPUs"),
                QuestionOption("d", "Loop direction makes zero difference to the DP values")
            ),
            correctOptionId = "b",
            explanation = "When updating `dp[w] = max(dp[w], dp[w - wt] + val)` in place, a descending loop `w = W downTo wt` reads `dp[w - wt]` before it is updated in the current item's pass."
        ),
        QuizQuestion(
            id = "cs_adv_32",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the time complexity of finding the `Longest Increasing Subsequence (LIS)` of an array of length `n` using patience sorting + binary search (`tails` array), compared to standard `O(n^2)` DP?",
            options = listOf(
                QuestionOption("a", "O(n log n)"),
                QuestionOption("b", "O(n)"),
                QuestionOption("c", "O(n^2 log n)"),
                QuestionOption("d", "O(2^n)")
            ),
            correctOptionId = "a",
            explanation = "Maintaining the smallest tail value of an increasing subsequence of each length `L` produces a sorted `tails` array that can be binary-searched for each of the `n` elements in `O(n log n)` total time."
        ),
        QuizQuestion(
            id = "cs_adv_33",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Edit Distance` (Levenshtein Distance) between two strings `A` (length `m`) and `B` (length `n`) allowing insert, delete, and replace of single characters, what is the time complexity and space-optimized memory complexity?",
            options = listOf(
                QuestionOption("a", "`O(m + n)` time and `O(1)` space"),
                QuestionOption("b", "`O(2^(m+n))` time"),
                QuestionOption("c", "`O(m^3)` time"),
                QuestionOption("d", "`O(m * n)` time and `O(min(m, n))` auxiliary space (since each row of the DP table only depends on the immediately preceding row)")
            ),
            correctOptionId = "d",
            explanation = "`dp[i][j]` only references `dp[i-1][j]`, `dp[i][j-1]`, and `dp[i-1][j-1]`, so keeping just the previous row (over the shorter string) reduces space from `O(m * n)` to `O(min(m, n))`."
        ),
        QuizQuestion(
            id = "cs_adv_34",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does the `Knuth-Morris-Pratt (KMP)` string matching algorithm search for a pattern `P` (length `m`) inside a text `T` (length `n`) in worst-case `O(n + m)` time without ever moving the text index backward?",
            options = listOf(
                QuestionOption("a", "It sorts both strings alphabetically first"),
                QuestionOption("b", "It requires the pattern to contain no repeated characters"),
                QuestionOption("c", "It precomputes the `LPS` (Longest Proper Prefix which is also a Suffix) failure array on `P` in `O(m)` time so that on a mismatch, it knows how many matched pattern characters can be skipped without re-scanning `T`"),
                QuestionOption("d", "It hashes substrings using SHA-256")
            ),
            correctOptionId = "c",
            explanation = "Unlike naive string search (`O(n * m)` worst case on inputs like `T = \"aaaa...ab\"`, `P = \"aaab\"`), KMP never backs up in `T` and runs in strict `O(n + m)` time."
        ),
        QuizQuestion(
            id = "cs_adv_35",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Segment Tree` or `Fenwick Tree (Binary Indexed Tree)`, and what time complexity do they achieve for both point updates and prefix/range sum queries on an array of size `n`?",
            options = listOf(
                QuestionOption("a", "They only work on immutable arrays"),
                QuestionOption("b", "Both support point updates and range sum queries in `O(log n)` time (compared to `O(1)` update / `O(n)` query in a plain array, or `O(n)` update / `O(1)` query in a static prefix-sum array)"),
                QuestionOption("c", "Both take `O(n)` for queries and `O(n)` for updates"),
                QuestionOption("d", "Both take `O(1)` for both updates and queries")
            ),
            correctOptionId = "b",
            explanation = "Fenwick Trees (`O(n)` space using `i += i & -i`) and Segment Trees (`O(n)` space supporting arbitrary associative range operations and lazy propagation) balance updates and range queries to `O(log n)` each."
        ),
        QuizQuestion(
            id = "cs_adv_36",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When is a simple static `Prefix Sum` array `pref[i] = pref[i-1] + arr[i-1]` preferred over a Segment Tree for range sum queries?",
            options = listOf(
                QuestionOption("a", "When the array is static (no interleaved updates between queries): after an `O(n)` build, every range sum `sum(L..R) = pref[R + 1] - pref[L]` is answered in `O(1)` constant time!"),
                QuestionOption("b", "When elements are updated after every query"),
                QuestionOption("c", "When finding range minimum (RMQ) with updates"),
                QuestionOption("d", "Never; Segment Trees are faster for static range sums")
            ),
            correctOptionId = "a",
            explanation = "For static arrays without updates, prefix sums answer range-sum queries in `O(1)` time after `O(n)` preprocessing."
        ),
        QuizQuestion(
            id = "cs_adv_37",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does a `Monotonic Stack` solve the `Next Greater Element` problem (or `Largest Rectangle in Histogram` / `Daily Temperatures`) for an array of `n` elements in `O(n)` total time?",
            options = listOf(
                QuestionOption("a", "Sort the stack after every push in `O(n^2)` time"),
                QuestionOption("b", "Run binary search on an unsorted stack"),
                QuestionOption("c", "Use recursion of depth `2^n`"),
                QuestionOption("d", "Maintain a stack of indices with monotonic values; each element is pushed onto the stack once and popped at most once when a greater (or smaller) element resolves it, doing at most `2n` stack operations = `O(n)` time")
            ),
            correctOptionId = "d",
            explanation = "Whenever a new element violates the stack's monotonicity, all popped stack elements immediately have their Next Greater (or Next Smaller) element resolved in `O(1)` amortized work per element."
        ),
        QuizQuestion(
            id = "cs_adv_38",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Bloom Filter`, and what are its exact guarantees regarding `False Positives` vs. `False Negatives`?",
            options = listOf(
                QuestionOption("a", "It is an exact hash set that stores full keys in O(n) space"),
                QuestionOption("b", "It sorts keys in O(1) time"),
                QuestionOption("c", "A space-efficient probabilistic bit-array with `k` hash functions that can return `False Positives` ('possibly in set'), but NEVER returns `False Negatives` ('definitely NOT in set' is 100% certain, assuming no deletions)"),
                QuestionOption("d", "It can return False Negatives, but never False Positives")
            ),
            correctOptionId = "c",
            explanation = "If any of the `k` hashed bit positions is `0`, the element was definitely never inserted (zero false negatives). If all `k` bits are `1`, those bits might have been set by other keys (possible false positive)."
        ),
        QuizQuestion(
            id = "cs_adv_39",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why are `B-Trees` / `B+Trees` (with high branching factor `B = 100..1000` where each node matches a 4KB–16KB disk page) used for database and filesystem indexes on disk instead of binary `AVL` or `Red-Black Trees`?",
            options = listOf(
                QuestionOption("a", "Because Red-Black trees are not balanced"),
                QuestionOption("b", "Disk/SSD reads operate in 4KB–16KB page blocks; a high-fanout B+Tree packs hundreds of keys per page, reducing tree height to 3–4 levels (`log_B(N)` page reads) instead of 20–30 pointer-chasing page reads in a binary tree!"),
                QuestionOption("c", "Because binary trees cannot store integers on disk"),
                QuestionOption("d", "Because B+Trees have `O(1)` height regardless of `N`")
            ),
            correctOptionId = "b",
            explanation = "For 100 million keys, a binary tree has height ~27 (up to 27 random disk I/Os), whereas a B+Tree with fanout 500 has height 3 (with top levels cached in RAM, requiring at most 1 disk read!)."
        ),
        QuizQuestion(
            id = "cs_adv_40",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In modern storage engines (like RocksDB, LevelDB, Cassandra), how does an `LSM-Tree (Log-Structured Merge-Tree)` achieve higher write throughput than an in-place B+Tree?",
            options = listOf(
                QuestionOption("a", "Writes are appended sequentially to a Write-Ahead Log (WAL) and buffered in an in-memory sorted `MemTable` (e.g., SkipList), which is flushed sequentially as immutable `SSTables` (Sorted String Tables) and merged in the background via compaction—turning random write I/O into sequential I/O!"),
                QuestionOption("b", "It never writes data to disk at all"),
                QuestionOption("c", "It disables sorting and scans the entire disk on every read"),
                QuestionOption("d", "It overwrites B-tree pages in place without logging")
            ),
            correctOptionId = "a",
            explanation = "LSM-trees trade background compaction and multi-SSTable read amplification (mitigated by Bloom filters per SSTable) for very fast sequential write throughput."
        ),
        QuizQuestion(
            id = "cs_adv_41",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In distributed caching and sharding, what problem does `Consistent Hashing` (using a hash ring with virtual nodes) solve compared to simple `hash(key) % N` when the number of servers changes from `N` to `N + 1`?",
            options = listOf(
                QuestionOption("a", "Consistent Hashing eliminates hash collisions completely"),
                QuestionOption("b", "Consistent Hashing encrypts all network packets"),
                QuestionOption("c", "With `hash(key) % N`, 0 keys are remapped when `N` changes"),
                QuestionOption("d", "With `hash(key) % N`, changing `N` remaps almost 100% of keys (`(N-1)/N`), causing a massive cache stampede; Consistent Hashing remaps only `O(K / N)` keys (just the keys belonging to the added/removed server's ring segments)!")
            ),
            correctOptionId = "d",
            explanation = "Consistent hashing maps both servers (via multiple virtual nodes for even load balance) and keys onto a `0..2^32-1` ring, moving only `~1/N` of keys when a node joins or leaves."
        ),
        QuizQuestion(
            id = "cs_adv_42",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In complexity theory, what is the relationship between the classes `P`, `NP`, `NP-Complete`, and `NP-Hard`?",
            options = listOf(
                QuestionOption("a", "`P` problems cannot be verified in polynomial time"),
                QuestionOption("b", "`NP-Hard` problems are always solvable in `O(n log n)`"),
                QuestionOption("c", "`P` is problems solvable in deterministic polynomial time; `NP` is decision problems whose 'yes' certificates can be VERIFIED in polynomial time (`P subseteq NP`); `NP-Complete` problems are the hardest problems in `NP` (every problem in `NP` reduces to them in polynomial time)"),
                QuestionOption("d", "`NP` stands for 'Not Polynomial' and is disjoint from `P`")
            ),
            correctOptionId = "c",
            explanation = "`NP` stands for Nondeterministic Polynomial time (polynomial-time verifiable). If any single `NP-Complete` problem (like `3-SAT`, `Traveling Salesperson Decision`, or `Vertex Cover`) has a polynomial-time algorithm, then `P = NP`."
        ),
        QuizQuestion(
            id = "cs_adv_43",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does Alan Turing's `Halting Problem` prove about computation?",
            options = listOf(
                QuestionOption("a", "That every bug can be detected by a compiler"),
                QuestionOption("b", "It is undecidable: no general algorithm can exist that takes an arbitrary program `P` and input `X` and always correctly determines in finite time whether `P(X)` eventually halts or runs forever"),
                QuestionOption("c", "That programs with `while` loops are always slower than `for` loops"),
                QuestionOption("d", "That recursion requires exponential memory")
            ),
            correctOptionId = "b",
            explanation = "Proof by diagonalization/contradiction: if `halts(P, P)` existed, a wrapper `paradox(P)` that loops forever if `halts(P, P)` is true and halts if false creates a logical contradiction when called as `paradox(paradox)`."
        ),
        QuizQuestion(
            id = "cs_adv_44",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In CPU microarchitecture, what is `Instruction Pipelining`, and what are the three classic types of `Pipeline Hazards`?",
            options = listOf(
                QuestionOption("a", "Overlapping execution stages (Fetch, Decode, Execute, Memory, Writeback) of multiple instructions concurrently; hazards are `Structural Hazards` (hardware resource conflict), `Data Hazards` (instruction depends on result of a still-in-flight instruction), and `Control Hazards` (branch changes PC)"),
                QuestionOption("b", "Running multiple operating systems at once"),
                QuestionOption("c", "Overclocking CPU voltage until it overheats"),
                QuestionOption("d", "Storing instructions on an external hard drive")
            ),
            correctOptionId = "a",
            explanation = "CPUs mitigate Data Hazards via hardware forwarding/bypassing and out-of-order execution, and Control Hazards via branch prediction and speculative execution."
        ),
        QuizQuestion(
            id = "cs_adv_45",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In multicore CPU caching, what is `False Sharing`, and how does it severely degrade multithreaded performance even when threads access completely different variables?",
            options = listOf(
                QuestionOption("a", "Two threads reading the same immutable `final` constant"),
                QuestionOption("b", "Two threads deadlocking on a mutex"),
                QuestionOption("c", "Sharing a database connection pool"),
                QuestionOption("d", "Two threads on different cores frequently write to two DIFFERENT variables (`varA` and `varB`) that happen to reside on the SAME 64-byte hardware cache line, forcing the MESI cache-coherence protocol to continually invalidate and bounce that cache line between cores!")
            ),
            correctOptionId = "d",
            explanation = "Cache coherence operates at cache-line granularity (typically 64 bytes), not individual variables; padding hot per-thread counters to separate cache lines (`@Contended`) eliminates false sharing."
        ),
        QuizQuestion(
            id = "cs_adv_46",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Operating Systems and systems programming, what is the `Priority Inversion` problem (which famously affected the Mars Pathfinder spacecraft), and how do modern OS mutexes solve it?",
            options = listOf(
                QuestionOption("a", "When a low-priority thread exits normally"),
                QuestionOption("b", "When two high-priority threads run on two different cores"),
                QuestionOption("c", "A high-priority thread `H` waits for a mutex held by a low-priority thread `L`, while a medium-priority thread `M` (which doesn't need the mutex) preempts `L`, indirectly starving `H`! Solved by `Priority Inheritance` (temporarily boosting `L`'s priority to `H`'s priority until `L` releases the mutex)"),
                QuestionOption("d", "When the OS scheduler sorts priorities in descending instead of ascending order")
            ),
            correctOptionId = "c",
            explanation = "Priority Inheritance ensures the lock-holding thread `L` cannot be preempted by intermediate-priority threads `M` while `H` is blocked waiting on `L`."
        ),
        QuizQuestion(
            id = "cs_adv_47",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In high-concurrency lock-free programming using `Compare-And-Swap (CAS)`, what is the `ABA Problem`?",
            options = listOf(
                QuestionOption("a", "When a hash table key is `\"ABA\"`"),
                QuestionOption("b", "Thread 1 reads shared pointer value `A`, gets preempted, and meanwhile Thread 2 changes `A -> B -> A` (reusing freed node memory `A` with different internal state); Thread 1 resumes and its `CAS(expected=A, new=...)` succeeds even though the structure changed underneath it!"),
                QuestionOption("c", "When three threads named A, B, and A deadlock"),
                QuestionOption("d", "When a CAS instruction takes 3 CPU cycles")
            ),
            correctOptionId = "b",
            explanation = "The ABA problem occurs when memory addresses/values are recycled; it is solved by pairing the pointer with a monotonically incrementing version stamp (`AtomicStampedReference`) or hazard pointers / epoch reclamation."
        ),
        QuizQuestion(
            id = "cs_adv_48",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Linux / Android OS internals, when a process calls `fork()` to create a child process, why does the OS NOT immediately copy gigabytes of physical RAM pages?",
            options = listOf(
                QuestionOption("a", "It uses `Copy-On-Write (COW)`: parent and child initially share the same physical pages marked read-only in their page tables; a physical page is copied ONLY when either process attempts to write to it!"),
                QuestionOption("b", "Because `fork()` deletes the parent process's memory"),
                QuestionOption("c", "Because child processes have 0 bytes of virtual memory"),
                QuestionOption("d", "Because all pages are immediately written to swap disk")
            ),
            correctOptionId = "a",
            explanation = "Copy-On-Write makes `fork()` fast and is the reason Android's `Zygote` process can pre-load framework classes once and fork new app processes in milliseconds while sharing clean pages."
        ),
        QuizQuestion(
            id = "cs_adv_49",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Linux / Android network and file I/O, why do `epoll` (or `kqueue` / `io_uring`) scale to tens of thousands of concurrent connections much better than legacy `select()` or `poll()`?",
            options = listOf(
                QuestionOption("a", "`epoll` creates one kernel thread per socket"),
                QuestionOption("b", "`select()` uses UDP instead of TCP"),
                QuestionOption("c", "`epoll` disables encryption"),
                QuestionOption("d", "`select`/`poll` require passing and linearly scanning the entire array of `O(N)` file descriptors on every call, whereas `epoll` maintains an in-kernel interest set and wakes up with ONLY the `O(active)` ready events!")
            ),
            correctOptionId = "d",
            explanation = "In addition, classic `select()` has a fixed `FD_SETSIZE` bitmask limit (typically 1,024) and `O(N)` per-call scan cost, whereas `epoll` scales in `O(ready events)`."
        ),
        QuizQuestion(
            id = "cs_adv_50",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Memory-Mapped I/O (mmap)` (used by Android DEX loading, SQLite, and shared libraries), and how does it avoid redundant buffer copies?",
            options = listOf(
                QuestionOption("a", "`mmap` deletes the file from disk as soon as it is opened"),
                QuestionOption("b", "`mmap` only works on network sockets"),
                QuestionOption("c", "`mmap` maps a file directly into the process's virtual address space backed by the OS page cache, avoiding the extra `read()` copy from kernel page cache into a separate user-space buffer"),
                QuestionOption("d", "`mmap` loads the entire hard drive into L1 cache")
            ),
            correctOptionId = "c",
            explanation = "With `mmap`, demand paging loads 4KB file pages into the OS page cache on access and maps those physical frames directly into the process's page tables."
        ),
        QuizQuestion(
            id = "cs_adv_51",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In TCP networking, what is the difference between `Flow Control` and `Congestion Control`?",
            options = listOf(
                QuestionOption("a", "They are two names for the exact same variable"),
                QuestionOption("b", "Flow Control (using the receiver's advertised window `rwnd`) prevents a fast sender from overwhelming a slow RECEIVER's buffer; Congestion Control (using `cwnd`, Slow Start, Congestion Avoidance, CUBIC/BBR) prevents traffic from overwhelming the intermediate NETWORK links and routers"),
                QuestionOption("c", "Flow Control is for UDP and Congestion Control is for TCP"),
                QuestionOption("d", "Flow Control encrypts packets and Congestion Control compresses them")
            ),
            correctOptionId = "b",
            explanation = "A TCP sender's effective transmission window is bounded by `min(rwnd, cwnd)`: receiver buffer capacity (`rwnd`) and network path capacity (`cwnd`)."
        ),
        QuizQuestion(
            id = "cs_adv_52",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In TCP connection termination, why does the side that initiates the active close enter the `TIME_WAIT` state (typically waiting `2 * MSL`) after sending the final `ACK`?",
            options = listOf(
                QuestionOption("a", "(1) To ensure the passive closer receives the final `ACK` (retransmitting it if the passive closer's `FIN` is re-sent), and (2) to let any delayed stray packets from the old connection expire in the network before the same `(srcIP, srcPort, dstIP, dstPort)` 4-tuple is reused"),
                QuestionOption("b", "Because the CPU needs time to cool down"),
                QuestionOption("c", "To keep the TLS certificate valid"),
                QuestionOption("d", "Because TCP requires 10 minutes between connections")
            ),
            correctOptionId = "a",
            explanation = "Without `TIME_WAIT`, a delayed duplicate packet from a closed incarnation could be accepted as valid data by a new connection reusing the exact same 4-tuple."
        ),
        QuizQuestion(
            id = "cs_adv_53",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Head-of-Line (HOL) Blocking` at the transport layer in `HTTP/2` over a single TCP connection, and how does `HTTP/3 (QUIC)` solve it?",
            options = listOf(
                QuestionOption("a", "HTTP/3 removes encryption to go faster"),
                QuestionOption("b", "HTTP/2 opens 100 separate TCP connections per image"),
                QuestionOption("c", "HTTP/3 uses ICMP instead of UDP or TCP"),
                QuestionOption("d", "In HTTP/2, multiple streams are multiplexed over ONE TCP byte stream, so a single lost TCP packet stalls delivery of ALL streams until retransmitted; HTTP/3 runs over `QUIC` (built on UDP), which implements independent per-stream ordering and recovery so a lost packet only stalls the specific stream whose data was in that packet!")
            ),
            correctOptionId = "d",
            explanation = "QUIC moves stream multiplexing, TLS 1.3 handshake (0-RTT/1-RTT), and loss recovery into the transport protocol over UDP, eliminating cross-stream TCP head-of-line blocking."
        ),
        QuizQuestion(
            id = "cs_adv_54",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In distributed systems, what does the `CAP Theorem` (Brewer's Theorem) state when a network `Partition (P)` occurs between nodes?",
            options = listOf(
                QuestionOption("a", "CAP stands for CPU, ALU, and Paging"),
                QuestionOption("b", "A system can simultaneously guarantee 100% linearizable Consistency and 100% Availability across a severed network link"),
                QuestionOption("c", "In the presence of a network Partition (`P`, where nodes cannot communicate), a distributed data store must choose between linearizable `Consistency (C)` (every read receives the most recent write or an error) and `Availability (A)` (every non-failing node returns a non-error response, potentially stale)"),
                QuestionOption("d", "You can choose to never have network partitions on commodity networks")
            ),
            correctOptionId = "c",
            explanation = "Since network partitions (`P`) are inevitable in real distributed networks, designers choose between `CP` (rejecting requests on the minority side or when quorum is lost to preserve linearizability) and `AP` (serving available reads/writes and reconciling conflicts later)."
        ),
        QuizQuestion(
            id = "cs_adv_55",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Quorum-based distributed replication with `N` replicas, write quorum `W`, and read quorum `R`, what inequality guarantees `Strong Consistency` (that every read quorum overlaps with the latest write quorum in at least one replica)?",
            options = listOf(
                QuestionOption("a", "W == 1 and R == 1 for any N > 2"),
                QuestionOption("b", "W + R > N (and `W > N / 2` to prevent split-brain concurrent writes)"),
                QuestionOption("c", "W + R < N"),
                QuestionOption("d", "W * R == N")
            ),
            correctOptionId = "b",
            explanation = "By the Pigeonhole Principle, if a write updates `W` of `N` nodes and a read queries `R` of `N` nodes with `W + R > N`, the two sets must intersect in at least `W + R - N >= 1` node containing the newest version timestamp."
        ),
        QuizQuestion(
            id = "cs_adv_56",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the role of consensus protocols like `Raft` and `Paxos` in distributed systems?",
            options = listOf(
                QuestionOption("a", "They enable a cluster of nodes to agree on a replicated ordered log of state-machine commands (Strong / Linearizable Consistency) and remain fault-tolerant as long as a strict majority quorum (`floor(N/2) + 1` nodes) is alive and connected"),
                QuestionOption("b", "They mine cryptocurrency using proof-of-work"),
                QuestionOption("c", "They compress network packets using Huffman coding"),
                QuestionOption("d", "They allow 1 surviving node out of 10 to commit writes during a network partition")
            ),
            correctOptionId = "a",
            explanation = "A cluster of `2f + 1` nodes running Raft/Paxos tolerates up to `f` node crash failures (e.g., 3 nodes tolerate 1 failure; 5 nodes tolerate 2 failures) because any two majority quorums overlap."
        ),
        QuizQuestion(
            id = "cs_adv_57",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In graph algorithms, what is `Tarjan's Bridge-Finding / Articulation-Point` condition for an undirected edge `(u, v)` (where `v` is a DFS tree child of `u`) to be a `Bridge` (an edge whose removal disconnects the graph)?",
            options = listOf(
                QuestionOption("a", "`low[v] == disc[u]`"),
                QuestionOption("b", "`low[v] < disc[u]`"),
                QuestionOption("c", "`disc[v] < disc[u]`"),
                QuestionOption("d", "`low[v] > disc[u]` (meaning no vertex in `v`'s DFS subtree has a back-edge reaching `u` or any ancestor of `u`)")
            ),
            correctOptionId = "d",
            explanation = "If `low[v] > disc[u]`, the only way to reach `v`'s subtree from the rest of the graph is via tree edge `(u, v)`, making `(u, v)` a bridge! (For an articulation point on non-root `u`, the condition is `low[v] >= disc[u]`)."
        ),
        QuizQuestion(
            id = "cs_adv_58",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a flow network `G = (V, E)` with source `s` and sink `t`, what does the `Max-Flow Min-Cut Theorem` (Ford-Fulkerson) state?",
            options = listOf(
                QuestionOption("a", "The maximum flow is always the sum of all edges in the graph"),
                QuestionOption("b", "Minimum cut is NP-Complete in directed graphs"),
                QuestionOption("c", "The maximum amount of flow that can be sent from source `s` to sink `t` equals the minimum total capacity of edges in an `s-t cut` that separates `s` from `t`"),
                QuestionOption("d", "The maximum flow equals the shortest path from `s` to `t`")
            ),
            correctOptionId = "c",
            explanation = "When Ford-Fulkerson / Edmonds-Karp terminates with no augmenting path remaining in the residual graph, the vertices reachable from `s` in the residual graph define a minimum `s-t` cut whose capacity equals the max flow."
        )
    )

    private fun advancedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "cs_adv_59",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can `Maximum Bipartite Matching` (matching applicants to jobs where each person/job can be matched at most once) be solved using a `Max-Flow` algorithm?",
            options = listOf(
                QuestionOption("a", "By running Floyd-Warshall"),
                QuestionOption("b", "Construct a source `s` connected to all left nodes with capacity `1`, direct all bipartite edges from left to right with capacity `1`, and connect all right nodes to sink `t` with capacity `1`; the integer max flow from `s` to `t` equals the maximum matching size!"),
                QuestionOption("c", "Because bipartite graphs have no edges"),
                QuestionOption("d", "By running Kruskal's MST algorithm")
            ),
            correctOptionId = "b",
            explanation = "By the Integrality Theorem of network flow, unit capacities yield an integer max flow corresponding 1-to-1 with disjoint matching edges (Hopcroft-Karp solves this even faster in `O(E * sqrt(V))`)."
        ),
        QuizQuestion(
            id = "cs_adv_60",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Huffman Coding` for lossless data compression, why is the resulting variable-length binary code called a `Prefix-Free Code` (Prefix Code), and why is that property essential?",
            options = listOf(
                QuestionOption("a", "No character's binary codeword is a prefix of any other character's codeword (because all characters sit at the LEAVES of the Huffman binary tree), allowing a compressed bit stream to be decoded unambiguously from left to right without delimiter bits!"),
                QuestionOption("b", "Every character is encoded using the exact same number of bits"),
                QuestionOption("c", "Frequent characters get the longest bit strings"),
                QuestionOption("d", "It is a lossy compression algorithm that discards rare letters")
            ),
            correctOptionId = "a",
            explanation = "Huffman Coding greedily merges the two lowest-frequency nodes in a Min-Heap (`O(n log n)`), placing frequent symbols near the root (short bit codes) and rare symbols deeper, with all symbols at leaves (prefix-free)."
        ),
        QuizQuestion(
            id = "cs_adv_61",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the `A* (A-Star)` heuristic shortest-path search algorithm evaluating `f(n) = g(n) + h(n)`, what condition must the heuristic function `h(n)` satisfy to guarantee finding an optimal shortest path?",
            options = listOf(
                QuestionOption("a", "`h(n)` must always be strictly greater than the true remaining cost"),
                QuestionOption("b", "`h(n)` must be a random number"),
                QuestionOption("c", "`h(n)` must equal `g(n)`"),
                QuestionOption("d", "`h(n)` must be `Admissible` (it never overestimates the true remaining cost `h*(n)` to the goal: `0 <= h(n) <= h*(n)`), and for graph search without re-expanding closed nodes, `Consistent / Monotonic` (`h(u) <= w(u, v) + h(v)`)")
            ),
            correctOptionId = "d",
            explanation = "When `h(n) = 0`, A* reduces to Dijkstra's algorithm; when `h(n)` is admissible and consistent (satisfying the triangle inequality), A* expands nodes in non-decreasing order of `f(n)` and finds the optimal path."
        ),
        QuizQuestion(
            id = "cs_adv_62",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `0-1 BFS` (using a double-ended queue `Deque`), and what is its time complexity for finding single-source shortest paths in a graph where every edge weight is either `0` or `1`?",
            options = listOf(
                QuestionOption("a", "`O(|V|^2)`"),
                QuestionOption("b", "`O(|V| * |E|)`"),
                QuestionOption("c", "`O(|V| + |E|)` linear time: when relaxing an edge of weight `0`, push the neighbor to the FRONT of the deque (`addFirst`); when relaxing an edge of weight `1`, push to the BACK of the deque (`addLast`)"),
                QuestionOption("d", "`O((|V| + |E|) log |V|)` using a standard FIFO queue")
            ),
            correctOptionId = "c",
            explanation = "Because the deque maintains vertices with at most two distinct distance values (`d` at the front, `d + 1` at the back), pushing `0`-weight transitions to the front and `1`-weight transitions to the back preserves sorted distance order without heap `log |V|` overhead!"
        ),
        QuizQuestion(
            id = "cs_adv_63",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `Quickselect` (Hoare's selection algorithm) find the `k`-th smallest element in an unordered array of `n` elements in `O(n)` average time (instead of `O(n log n)` full sorting)?",
            options = listOf(
                QuestionOption("a", "Build a balanced BST of all `n` elements"),
                QuestionOption("b", "Partition the array around a pivot as in QuickSort, then recurse ONLY into the single side (left or right) that contains index `k`, giving `n + n/2 + n/4 + ... = O(2n) = O(n)` expected work!"),
                QuestionOption("c", "Recurse into both sides of the pivot like QuickSort"),
                QuestionOption("d", "Run Bubble Sort for `k` passes (which is `O(n * k)`)")
            ),
            correctOptionId = "b",
            explanation = "Because Quickselect discards one partition at each step instead of recursing on both, the geometric series of partition sizes sums to linear `O(n)` expected time (`O(n^2)` worst case unless Median-of-Medians pivot selection is used)."
        ),
        QuizQuestion(
            id = "cs_adv_64",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does the `Boyer-Moore Majority Vote Algorithm` find the element that appears strictly more than `floor(n / 2)` times in an array in `O(n)` time and `O(1)` auxiliary space?",
            options = listOf(
                QuestionOption("a", "Maintain a `candidate` and a `count`: when `count == 0`, set `candidate = x`; if `x == candidate`, increment `count`, else decrement `count`. Because the majority element occurs `> n/2` times, it cannot be completely canceled out by all other elements combined!"),
                QuestionOption("b", "Sort the array in place (which modifies the array or takes `O(n log n)`)"),
                QuestionOption("c", "Use a HashMap of counts (which takes `O(n)` space)"),
                QuestionOption("d", "XOR all elements together (which fails when the majority element appears an even number of times!)")
            ),
            correctOptionId = "a",
            explanation = "Pairing each non-majority element against one occurrence of the majority element cancels at most `2 * (n - count(maj)) < n` elements, leaving the majority element as the surviving `candidate`."
        ),
        QuizQuestion(
            id = "cs_adv_65",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `Rabin-Karp` string matching achieve `O(n + m)` expected time (and `O(n)` multi-pattern matching) for searching a pattern of length `m` in a text of length `n`?",
            options = listOf(
                QuestionOption("a", "It sorts the text characters"),
                QuestionOption("b", "It builds a full suffix tree in `O(n^2)` space"),
                QuestionOption("c", "It compares all `m` characters from scratch at every index"),
                QuestionOption("d", "It uses a `Rolling Hash` (polynomial hash modulo a large prime) that updates the hash of the sliding `m`-character window in `O(1)` time as a character leaves the left and enters the right")
            ),
            correctOptionId = "d",
            explanation = "Subtracting the leading character's high-order term, multiplying by the base `B`, and adding the new trailing character updates the window hash in `O(1)` arithmetic operations."
        ),
        QuizQuestion(
            id = "cs_adv_66",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Spurious Hit` in the `Rabin-Karp` rolling-hash string search algorithm?",
            options = listOf(
                QuestionOption("a", "When the hash function divides by zero"),
                QuestionOption("b", "When the pattern appears at index 0"),
                QuestionOption("c", "When a text window has the exact same hash value as the pattern (`hash(window) == hash(pattern)`) due to a hash collision, even though the actual strings differ"),
                QuestionOption("d", "When the pattern is longer than the text")
            ),
            correctOptionId = "c",
            explanation = "To guarantee exactness (Las Vegas variant) or negligible collision probability (Monte Carlo with double hashing), Rabin-Karp verifies character equality when hashes match."
        ),
        QuizQuestion(
            id = "cs_adv_67",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Dynamic Programming on Trees (or interval DP), what is the time complexity of `Matrix Chain Multiplication` (finding the optimal parenthesization of `n` matrices `M_1 * M_2 * ... * M_n` to minimize scalar multiplications)?",
            options = listOf(
                QuestionOption("a", "`O(2^n)` with memoization"),
                QuestionOption("b", "`O(n^3)` time and `O(n^2)` space by iterating over chain length `len = 2..n`, start index `i`, and split point `k in i..<j`"),
                QuestionOption("c", "`O(n log n)` time"),
                QuestionOption("d", "`O(n)` greedy time by always multiplying the smallest matrices first")
            ),
            correctOptionId = "b",
            explanation = "There are `O(n^2)` subproblem intervals `[i, j]`, and each interval tries `O(n)` split points `k`, totaling `O(n^3)` time."
        ),
        QuizQuestion(
            id = "cs_adv_68",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Bitmask Dynamic Programming (such as solving the `Traveling Salesperson Problem (TSP)` via the `Held-Karp` algorithm on `n` cities), what is the state representation and time complexity compared to `O(n!)` brute force?",
            options = listOf(
                QuestionOption("a", "State `dp[mask][u]` (minimum cost having visited the subset of cities in `n`-bit `mask`, ending at city `u`), reducing complexity from `O(n!)` to `O(n^2 * 2^n)` time and `O(n * 2^n)` space"),
                QuestionOption("b", "`O(n^3)` polynomial time"),
                QuestionOption("c", "`O(2^(n^2))` time"),
                QuestionOption("d", "`O(n log n)` time")
            ),
            correctOptionId = "a",
            explanation = "For `n = 20`, `20! ≈ 2.4 * 10^18` is intractable, whereas `20^2 * 2^20 ≈ 4.2 * 10^8` operations in Held-Karp Bitmask DP finishes in under a second!"
        ),
        QuizQuestion(
            id = "cs_adv_69",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a bitmask `mask` representing a subset of `{0, 1, ..., n-1}`, how do you iterate over all non-empty proper submasks `sub` of `mask` in `O(3^n)` total time across all masks of `[0..2^n - 1]`?",
            options = listOf(
                QuestionOption("a", "`for (sub in 0 until mask)` (which takes `O(4^n)` across all masks and visits invalid non-subsets!)"),
                QuestionOption("b", "`sub = mask shr 1`"),
                QuestionOption("c", "`sub = mask xor 1`"),
                QuestionOption("d", "`var sub = (mask - 1) and mask; while (sub > 0) { ...; sub = (sub - 1) and mask }`")
            ),
            correctOptionId = "d",
            explanation = "`(sub - 1) & mask` jumps directly to the next smaller integer whose set bits are a subset of `mask`. Across all `n`-bit masks, each element is in one of 3 states (in `sub`, in `mask \\ sub`, or outside `mask`), totaling `3^n` iterations!"
        ),
        QuizQuestion(
            id = "cs_adv_70",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Reservoir Sampling` (Algorithm R), and what problem does it solve in `O(n)` time and `O(k)` memory?",
            options = listOf(
                QuestionOption("a", "Finding the median of a stream"),
                QuestionOption("b", "Compressing a stream using RLE"),
                QuestionOption("c", "Selecting `k` items uniformly at random without replacement from a stream of unknown (or huge) length `n` in a single pass: keep the first `k` items, and for the `i`-th item (`1`-indexed, `i > k`), include it with probability `k / i` replacing a uniformly chosen existing item"),
                QuestionOption("d", "Sorting a stream in `O(1)` memory")
            ),
            correctOptionId = "c",
            explanation = "By induction, after seeing `i` items, every item seen so far is in the reservoir of size `k` with exact uniform probability `k / i`!"
        ),
        QuizQuestion(
            id = "cs_adv_71",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How do you maintain the `Running Median` of a dynamic stream of numbers in `O(log n)` time per insertion and `O(1)` time per median query?",
            options = listOf(
                QuestionOption("a", "Keep only the minimum and maximum values seen so far"),
                QuestionOption("b", "Maintain two heaps: a `Max-Heap` (`lowerHalf`) for the smaller half of numbers and a `Min-Heap` (`upperHalf`) for the larger half, keeping their sizes balanced within 1 (`0 <= lowerHalf.size - upperHalf.size <= 1`)"),
                QuestionOption("c", "Re-sort an array on every insertion in `O(n log n)` per element"),
                QuestionOption("d", "Use a single Min-Heap")
            ),
            correctOptionId = "b",
            explanation = "The largest element of the lower half (`lowerHalf.peek()`) and the smallest element of the upper half (`upperHalf.peek()`) bracket the exact median at all times in `O(1)` peek time!"
        ),
        QuizQuestion(
            id = "cs_adv_72",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Monotonic Deque` (Double-Ended Queue) and how does it find the `Sliding Window Maximum` for every window of size `k` across an array of `n` elements in `O(n)` total time (instead of `O(n log k)` with a heap)?",
            options = listOf(
                QuestionOption("a", "Store array indices in the deque in decreasing order of their values: pop indices from the front that fall outside `i - k`, pop indices from the back whose values are `<= arr[i]`, push `i`, and read the window max at `arr[deque.first()]` in `O(1)`!"),
                QuestionOption("b", "Sort each window of size `k` in `O(n * k log k)`"),
                QuestionOption("c", "Use two stacks without removing old elements"),
                QuestionOption("d", "Scan all `k` elements on every step in `O(n * k)`")
            ),
            correctOptionId = "a",
            explanation = "Each index is pushed to the back of the deque once and popped (from either the front on expiry or the back on domination) at most once, totaling `2n` operations = strict `O(n)` time."
        ),
        QuizQuestion(
            id = "cs_adv_73",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Fenwick Trees (Binary Indexed Trees, 1-indexed), how do `update(i, delta)` and `prefixSum(i)` traverse the tree in `O(log n)` steps using bitwise operations?",
            options = listOf(
                QuestionOption("a", "Both increment `i` by `1` in `O(n)` time"),
                QuestionOption("b", "Both multiply `i` by `2`"),
                QuestionOption("c", "Both shift `i` right by `1`"),
                QuestionOption("d", "`update` adds the lowest set bit (`i += i & -i`) to climb covering ranges; `prefixSum` subtracts the lowest set bit (`i -= i & -i`) to sum disjoint power-of-two ranges!")
            ),
            correctOptionId = "d",
            explanation = "Because `i & -i` isolates the lowest set bit (`lsb(i)`), `i -= i & -i` strips one set bit per step (at most `log2(n)` steps)."
        ),
        QuizQuestion(
            id = "cs_adv_74",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Segment Trees, what is `Lazy Propagation`, and why is it necessary when supporting range updates (e.g., 'add `v` to all elements in `[L, R]`') alongside range queries?",
            options = listOf(
                QuestionOption("a", "It stores the Segment Tree on disk instead of RAM"),
                QuestionOption("b", "It approximates range sums within 10%"),
                QuestionOption("c", "Instead of updating all `O(n)` leaf nodes in `[L, R]`, when a segment tree node's range is completely covered by `[L, R]`, we update that node's aggregate in `O(1)` and store a pending `lazy` tag to push down to its children ONLY when a future operation visits them—keeping both range updates and range queries `O(log n)`!"),
                QuestionOption("d", "It delays building the Segment Tree until the program exits")
            ),
            correctOptionId = "c",
            explanation = "Without lazy propagation, a range update over `[0, n-1]` would touch all `O(n)` leaves; lazy tags defer propagation so only `O(log n)` nodes are visited per range operation."
        ),
        QuizQuestion(
            id = "cs_adv_75",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Sparse Table` preprocessing for static `Range Minimum Query (RMQ)` (where the array is never modified), and what is its query time complexity after `O(n log n)` preprocessing?",
            options = listOf(
                QuestionOption("a", "`O(n)` per query"),
                QuestionOption("b", "`O(1)` constant time per RMQ query! It precomputes `st[k][i] = min of range of length 2^k starting at i`, and answers `min(L..R)` by taking `min(st[k][L], st[k][R - 2^k + 1])` where `k = floor(log2(R - L + 1))`"),
                QuestionOption("c", "`O(log n)` per query"),
                QuestionOption("d", "`O(sqrt(n))` per query")
            ),
            correctOptionId = "b",
            explanation = "Because `min` (and `max` / `gcd`) is idempotent (`min(x, x) == x`), two overlapping intervals of length `2^k` covering `[L, R]` give the exact range minimum in `O(1)` time! (Note: this overlap trick does NOT work in O(1) for non-idempotent `sum`)."
        ),
        QuizQuestion(
            id = "cs_adv_76",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does the `O(1)` overlapping-interval query trick of a `Sparse Table` work for `RMQ (min/max)` and `GCD`, but NOT for `Range Sum`?",
            options = listOf(
                QuestionOption("a", "Because `min`, `max`, and `gcd` are `Idempotent` (`f(x, x) = x`, so double-counting the overlapping middle region does not change the answer), whereas `sum` is NOT idempotent (`x + x != x`, so overlapping intervals double-count the middle elements)!"),
                QuestionOption("b", "Because `sum` is not associative"),
                QuestionOption("c", "Because Sparse Tables cannot store integers larger than 100"),
                QuestionOption("d", "It DOES work in O(1) with overlapping intervals for Range Sum")
            ),
            correctOptionId = "a",
            explanation = "Idempotence (`op(a, a) == a`) allows two overlapping power-of-two blocks `[L, L + 2^k - 1]` and `[R - 2^k + 1, R]` to be combined in O(1) without corrupting the result."
        ),
        QuizQuestion(
            id = "cs_adv_77",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In game theory and combinatorial games (impartial games under normal play convention, where the last player to move wins), what does the `Sprague-Grundy (Nim) Theorem` state for a game of `Nim` with pile sizes `a_1, a_2, ..., a_k`?",
            options = listOf(
                QuestionOption("a", "The first player wins if and only if the arithmetic sum `a_1 + ... + a_k` is odd"),
                QuestionOption("b", "The first player always wins regardless of pile sizes"),
                QuestionOption("c", "The player with the largest single pile always loses"),
                QuestionOption("d", "The first player has a winning strategy if and only if the bitwise XOR sum (`a_1 ^ a_2 ^ ... ^ a_k`) is NON-ZERO (`!= 0`); if the XOR sum is `0`, the second player can always mirror into a `0`-XOR state and win!")
            ),
            correctOptionId = "d",
            explanation = "From any non-zero XOR state, there exists a move that makes the XOR sum `0`; from any `0` XOR state, every legal move makes the XOR sum non-zero, and the terminal empty state `(0, ..., 0)` has XOR sum `0`."
        ),
        QuizQuestion(
            id = "cs_adv_78",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In number theory and cryptography (such as RSA and modular arithmetic), how does `Modular Exponentiation` (Binary Exponentiation) compute `(base^exp) mod m` in `O(log(exp))` multiplications instead of `O(exp)`?",
            options = listOf(
                QuestionOption("a", "By adding `base` to itself `exp` times"),
                QuestionOption("b", "By dividing `exp` by `m`"),
                QuestionOption("c", "By squaring `base = (base * base) % m` on each bit shift of `exp` (`exp >>= 1`) and multiplying into `result = (result * base) % m` whenever the current lowest bit `exp & 1` is `1`"),
                QuestionOption("d", "By computing `base^exp` as a 64-bit float first and then taking `% m` (which overflows for `exp > 1000`!)")
            ),
            correctOptionId = "c",
            explanation = "Using `(a * b) mod m = ((a mod m) * (b mod m)) mod m` and binary decomposition of `exp` computes `(base^10^18) mod m` in at most 60 loop iterations without overflow!"
        ),
        QuizQuestion(
            id = "cs_adv_79",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When computing combinations `(n choose r) mod p` where `p` is a large prime (like `1,000,000,007`), why can you NOT simply compute `(fact[n] / (fact[r] * fact[n-r])) % p` using integer division, and what is used instead?",
            options = listOf(
                QuestionOption("a", "Subtract `fact[r]` instead of dividing"),
                QuestionOption("b", "Modular arithmetic does not distribute over integer division; instead, multiply by the `Modular Multiplicative Inverse` of `(fact[r] * fact[n-r]) mod p`, computed via Fermat's Little Theorem as `x^(p - 2) mod p` (or Extended Euclidean Algorithm)!"),
                QuestionOption("c", "You can use regular `/` after taking `% p`"),
                QuestionOption("d", "Use floating-point division `double` and cast back")
            ),
            correctOptionId = "b",
            explanation = "By Fermat's Little Theorem, for prime `p` and `a not divisible by p`, `a^(p - 1) ≡ 1 (mod p)`, so `a^(p - 2) mod p` is the exact modular inverse `a^(-1) mod p`!"
        ),
        QuizQuestion(
            id = "cs_adv_80",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the `Sieve of Eratosthenes` for finding all prime numbers up to `N`, why does the inner loop for prime `p` start at `p * p` (rather than `2 * p`), and what is its time complexity?",
            options = listOf(
                QuestionOption("a", "Any composite multiple `k * p` with `k < p` already has a smaller prime factor `<= k` and was already marked composite by an earlier prime; the Sieve runs in `O(N log log N)` time and `O(N)` space"),
                QuestionOption("b", "Starting at `p * p` skips composite numbers by accident"),
                QuestionOption("c", "The Sieve runs in `O(N^2)` time"),
                QuestionOption("d", "It only works for `N <= 100`")
            ),
            correctOptionId = "a",
            explanation = "The harmonic sum of prime reciprocals `sum_{p <= N} (N / p) = O(N log log N)`, making the Sieve of Eratosthenes nearly linear."
        ),
        QuizQuestion(
            id = "cs_adv_81",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why only check trial divisors `d` up to `d * d <= n` (i.e., `d <= sqrt(n)`) when testing if an integer `n > 1` is prime?",
            options = listOf(
                QuestionOption("a", "Because prime factors cannot exceed `n / 10`"),
                QuestionOption("b", "Because `sqrt(n)` is always an integer"),
                QuestionOption("c", "It is an approximation that sometimes misses primes"),
                QuestionOption("d", "If `n = a * b` is composite, at least one of the factors `a` or `b` must be `<= sqrt(n)` (since if both were `> sqrt(n)`, their product `a * b` would be `> n`!)")
            ),
            correctOptionId = "d",
            explanation = "Every composite number `n` has a prime factor `<= sqrt(n)`, so trial division up to `sqrt(n)` is an exact `O(sqrt(n))` primality test."
        ),
        QuizQuestion(
            id = "cs_adv_82",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In compiler optimization and modern CPU execution, what is `Static Single Assignment (SSA)` form (used by LLVM, GCC, and ART/JVM JIT compilers)?",
            options = listOf(
                QuestionOption("a", "A restriction that functions cannot have loops"),
                QuestionOption("b", "Storing all variables on disk"),
                QuestionOption("c", "An intermediate representation (IR) where every variable is assigned exactly ONCE, and `phi (Φ)` functions merge values at control-flow join points—making data-flow optimizations like constant propagation, dead-code elimination, and register allocation fast and explicit"),
                QuestionOption("d", "A rule that programs can only contain one variable total")
            ),
            correctOptionId = "c",
            explanation = "SSA makes def-use chains explicit in the IR graph so the compiler knows immediately which unique definition reaches any use."
        ),
        QuizQuestion(
            id = "cs_adv_83",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In CPU branch execution, why can sorting an array BEFORE running a tight loop with an `if (arr[i] >= 128)` branch inside it sometimes make the loop run 3–5x faster (until vectorized/branchless code is used)?",
            options = listOf(
                QuestionOption("a", "Because `>=` is faster on large numbers"),
                QuestionOption("b", "Modern CPUs use a hardware `Branch Predictor` to speculatively execute instructions down the predicted branch path; on random data, branch mispredictions flush the ~15–20 stage CPU pipeline on ~50% of iterations, whereas on sorted data the branch is 100% predictable (or can be replaced by branchless `CMOV`/SIMD)!"),
                QuestionOption("c", "Because the CPU skips the loop on sorted arrays"),
                QuestionOption("d", "Because RAM runs at a higher voltage when data is sorted")
            ),
            correctOptionId = "b",
            explanation = "Branch misprediction penalties (pipeline flush of 15–20 cycles) are a classic microarchitectural bottleneck when a data-dependent branch has 50/50 unpredictable outcomes."
        ),
        QuizQuestion(
            id = "cs_adv_84",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `SIMD (Single Instruction, Multiple Data)` vectorization (such as ARM NEON on Android devices or x86 AVX2)?",
            options = listOf(
                QuestionOption("a", "A single CPU instruction operates in parallel on multiple data elements packed into wide vector registers (e.g., adding four 32-bit floats or sixteen 8-bit integers in a single clock cycle)"),
                QuestionOption("b", "Multiple CPU cores running completely different programs (`MIMD`)"),
                QuestionOption("c", "A single instruction running multiple times sequentially in a loop"),
                QuestionOption("d", "Storing data on multiple hard drives (`RAID`)")
            ),
            correctOptionId = "a",
            explanation = "ARM NEON 128-bit vector registers allow Android CPUs to process 4 floats, 8 shorts, or 16 bytes simultaneously per instruction in image processing, audio, ML, and physics."
        ),
        QuizQuestion(
            id = "cs_adv_85",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Android and graphics rendering systems, what is the purpose of `Double Buffering` / `Triple Buffering` combined with `VSYNC (Vertical Synchronization)`?",
            options = listOf(
                QuestionOption("a", "It doubles the screen resolution automatically"),
                QuestionOption("b", "It renders every frame twice on the CPU"),
                QuestionOption("c", "It disables GPU hardware acceleration"),
                QuestionOption("d", "The display controller reads from a completed `Front Buffer` at the screen refresh rate (60Hz/120Hz) while the CPU/GPU renders the next frame into a separate `Back Buffer`, swapping buffers at the VSYNC interval to prevent visual screen tearing!")
            ),
            correctOptionId = "d",
            explanation = "Without buffer swapping synchronized to VSYNC, swapping mid-scanout causes the top half of the screen to show frame `N` and the bottom half to show frame `N+1` (screen tearing)."
        ),
        QuizQuestion(
            id = "cs_adv_86",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Operating Systems and security, what is `ASLR (Address Space Layout Randomization)` and `DEP / NX (No-Execute bit)`?",
            options = listOf(
                QuestionOption("a", "Network routing protocols for IPv6"),
                QuestionOption("b", "Garbage collection heuristics"),
                QuestionOption("c", "Hardware/OS exploit mitigations: `NX/DEP` marks data/stack/heap pages non-executable so injected shellcode cannot run as instructions; `ASLR` randomizes the virtual base addresses of the stack, heap, and shared libraries on each launch to thwart hardcoded return-oriented jumps"),
                QuestionOption("d", "Algorithms for compressing files on SSDs")
            ),
            correctOptionId = "c",
            explanation = "Together with stack canaries, `DEP/NX` and `ASLR` are foundational memory-safety mitigations in Android, Linux, iOS, Windows, and macOS."
        ),
        QuizQuestion(
            id = "cs_adv_87",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In distributed systems, what is the `Two Generals' Problem` (and the `FLP Impossibility Result`), and what is its practical consequence for network protocols?",
            options = listOf(
                QuestionOption("a", "Encryption keys cannot be shared over the internet"),
                QuestionOption("b", "Over an unreliable communication channel that can lose messages, two parties can NEVER achieve 100% guaranteed common knowledge consensus in bounded messages; in practice, systems use timeouts, retries, and idempotency keys to reduce failure probability to negligible levels"),
                QuestionOption("c", "Two routers cannot connect to the same switch"),
                QuestionOption("d", "TCP 3-way handshake never works")
            ),
            correctOptionId = "b",
            explanation = "Because the last `ACK` itself can always be lost without the sender knowing whether it arrived, distributed systems combine at-least-once retries with idempotent receivers (`exactly-once` effect)."
        ),
        QuizQuestion(
            id = "cs_adv_88",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In distributed systems and microservices, what is the `Outbox Pattern` (Transactional Outbox) for reliably updating a local database AND publishing an event to a message broker without a fragile distributed 2-Phase Commit?",
            options = listOf(
                QuestionOption("a", "Within the SAME local ACID database transaction that updates the business table, insert the outgoing event into an `outbox` table; a separate relay worker reads uncommitted-safe committed rows from `outbox` and publishes them to the broker (at-least-once) with idempotent consumers!"),
                QuestionOption("b", "Publish the message over the network BEFORE starting the database transaction (which publishes phantom events if the DB rolls back!)"),
                QuestionOption("c", "Ignore message broker failures"),
                QuestionOption("d", "Use UDP broadcast without persistence")
            ),
            correctOptionId = "a",
            explanation = "Dual-writing to a DB and a message broker without atomic coordination risks losing the message after DB commit or publishing a message whose DB commit rolled back; the Transactional Outbox solves this using a single local DB transaction."
        ),
        QuizQuestion(
            id = "cs_adv_89",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Rate Limiting algorithms for APIs and servers, what is the difference between a `Token Bucket` and a `Fixed Window Counter`?",
            options = listOf(
                QuestionOption("a", "Fixed Window Counter uses O(n) memory per request"),
                QuestionOption("b", "Token Bucket rejects all requests when the bucket is full"),
                QuestionOption("c", "They behave identically at window boundaries"),
                QuestionOption("d", "`Token Bucket` replenishes tokens at a steady rate `r` up to bucket capacity `B` (smoothly allowing bounded short bursts up to `B` while enforcing long-term rate `r`), whereas a `Fixed Window Counter` can allow `2x` the rate limit in a sudden burst straddling the boundary between two adjacent time windows!")
            ),
            correctOptionId = "d",
            explanation = "In a Fixed Window of 100 req/min, a client sending 100 requests at `00:59` and 100 requests at `01:01` sends 200 requests in 2 seconds! Token Bucket or Sliding Window Log/Counter prevents boundary burst spikes."
        ),
        QuizQuestion(
            id = "cs_adv_90",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Skip Lists` (used in Redis sorted sets and Java's `ConcurrentSkipListMap`), how do they achieve `O(log n)` average search, insertion, and deletion without tree rotations?",
            options = listOf(
                QuestionOption("a", "By reversing pointers randomly"),
                QuestionOption("b", "By limiting list size to 64 nodes"),
                QuestionOption("c", "By building a hierarchy of linked lists where each inserted node is promoted to each higher level with fixed probability `p` (e.g., `1/2`), creating express lanes that skip over `~2^k` nodes at level `k`"),
                QuestionOption("d", "By copying the linked list into an array on every search")
            ),
            correctOptionId = "c",
            explanation = "Randomized multi-level forward pointers give Skip Lists the same `O(log n)` expected complexity as balanced BSTs while being much simpler to make lock-free (`ConcurrentSkipListMap`)."
        ),
        QuizQuestion(
            id = "cs_adv_91",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Kruskal's` Minimum Spanning Tree algorithm vs. `Prim's` MST algorithm on a connected graph `G = (V, E)`, when is Kruskal's vs. Prim's generally advantageous?",
            options = listOf(
                QuestionOption("a", "Kruskal's runs in `O(1)` time"),
                QuestionOption("b", "Kruskal's (`O(|E| log |E|)` sorting edges + Union-Find) is simple and fast on sparse graphs (`|E| ≈ |V|`), whereas Prim's (`O(|E| log |V|)` or `O(|V|^2)` dense array / `O(|E| + |V| log |V|)` Fibonacci heap) avoids sorting all `|E|` edges upfront and excels on dense graphs (`|E| ≈ |V|^2`)"),
                QuestionOption("c", "Kruskal's only works on directed graphs"),
                QuestionOption("d", "Prim's produces a different total MST weight than Kruskal's")
            ),
            correctOptionId = "b",
            explanation = "Both algorithms always produce the exact same minimum total spanning tree weight; Prim's grows a single connected component, while Kruskal's merges forest components globally by edge weight."
        ),
        QuizQuestion(
            id = "cs_adv_92",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Trie (Prefix Tree)` memory optimization, what is a `Radix Tree` (Compressed Trie / Patricia Trie)?",
            options = listOf(
                QuestionOption("a", "A trie where any chain of single-child nodes is merged (compressed) into a single edge labeled with a multi-character substring, reducing node count to `O(number of stored keys)` instead of `O(sum of string lengths)`"),
                QuestionOption("b", "A binary heap that stores integers in base 16"),
                QuestionOption("c", "A hash table with open addressing"),
                QuestionOption("d", "An unbalanced binary search tree")
            ),
            correctOptionId = "a",
            explanation = "Compressing non-branching paths saves substantial memory and pointer hops when keys share long common substrings (used in Linux kernel page caches, HTTP routers, and IP routing tables)."
        ),
        QuizQuestion(
            id = "cs_adv_93",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In graph shortest-path algorithms, what is `Bidirectional Search` (running BFS or Dijkstra simultaneously forward from source `s` and backward from target `t`), and why is it much faster for point-to-point queries?",
            options = listOf(
                QuestionOption("a", "It explores `O(b^(2d))` nodes"),
                QuestionOption("b", "It only works on trees of depth 1"),
                QuestionOption("c", "It skips half the edges randomly"),
                QuestionOption("d", "If branching factor is `b` and shortest distance is `d`, standard BFS explores `O(b^d)` nodes, whereas Bidirectional BFS meets in the middle at depth `d/2` from both ends, exploring only `O(2 * b^(d/2))` nodes—a quadratic reduction in search space!")
            ),
            correctOptionId = "d",
            explanation = "For `b = 10` and `d = 6`, `10^6 = 1,000,000` nodes vs `2 * 10^3 = 2,000` nodes—a 500x speedup for single-pair shortest path!"
        ),
        QuizQuestion(
            id = "cs_adv_94",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Disjoint Set (Union-Find)`, why must `Union by Size/Rank` attach the root of the SMALLER tree under the root of the LARGER tree (even without path compression)?",
            options = listOf(
                QuestionOption("a", "To keep keys sorted in ascending order"),
                QuestionOption("b", "It makes no difference; arbitrary union without path compression is already `O(log n)`"),
                QuestionOption("c", "Because every time a node's depth increases by 1 during a union, the size of its component at least DOUBLES (`>= 2x`), guaranteeing that no node ever has depth greater than `floor(log2(n))`!"),
                QuestionOption("d", "Because attaching larger under smaller uses more memory")
            ),
            correctOptionId = "c",
            explanation = "Arbitrary union without rank/size can build a degenerate chain of height `n - 1`; union by size/rank alone bounds tree height by `O(log n)` in the worst case."
        ),
        QuizQuestion(
            id = "cs_adv_95",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Convex Hull` computational geometry algorithms (`Graham Scan` or `Monotone Chain`), what is the time complexity of finding the convex hull of `n` 2D points, and which step dominates the runtime?",
            options = listOf(
                QuestionOption("a", "`O(2^n)` time"),
                QuestionOption("b", "`O(n log n)` total time: sorting the `n` points by angle or `(x, y)` coordinate takes `O(n log n)`, and the monotonic stack cross-product scan takes linear `O(n)` time"),
                QuestionOption("c", "`O(n^3)` time"),
                QuestionOption("d", "`O(n)` time for unsorted points in general comparison model")
            ),
            correctOptionId = "b",
            explanation = "After `O(n log n)` sorting, each point is pushed onto the hull stack once and popped at most once when a clockwise turn (`crossProduct <= 0`) is detected (`O(n)` scan)."
        ),
        QuizQuestion(
            id = "cs_adv_96",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In 2D computational geometry, what does the 2D `Cross Product` (signed area determinant) `(B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x)` of three points `A -> B -> C` tell you?",
            options = listOf(
                QuestionOption("a", "If `> 0`, `A -> B -> C` makes a counter-clockwise (left) turn; if `< 0`, a clockwise (right) turn; if `== 0`, the three points `A, B, C` are collinear (and its magnitude is `2 * Area(triangle ABC)`)!"),
                QuestionOption("b", "It computes the Euclidean distance between `A` and `C`"),
                QuestionOption("c", "It is always positive for all triangles"),
                QuestionOption("d", "It requires `sin()` and `cos()` floating-point calls")
            ),
            correctOptionId = "a",
            explanation = "The 2D cross product orientation test uses pure integer/exact multiplication and subtraction without slow or imprecise trigonometric `atan2` calls."
        ),
        QuizQuestion(
            id = "cs_adv_97",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In string algorithms, what is the `Z-Algorithm` (building the `Z-array` where `Z[i]` is the length of the longest common prefix between string `S` and the suffix of `S` starting at `i`), and what is its time complexity?",
            options = listOf(
                QuestionOption("a", "`O(n^2)` time"),
                QuestionOption("b", "`O(n log n)` time"),
                QuestionOption("c", "`O(2^n)` time"),
                QuestionOption("d", "`O(n)` linear time by maintaining the rightmost matched `[L, R]` Z-box interval and reusing previously computed `Z[i - L]` values before extending `R` monotonically")
            ),
            correctOptionId = "d",
            explanation = "Concatenating `P + '\$' + T` and computing the Z-array in `O(|P| + |T|)` finds all occurrences of pattern `P` in text `T` wherever `Z[i] == |P|`."
        ),
        QuizQuestion(
            id = "cs_adv_98",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `Manacher's Algorithm` find the `Longest Palindromic Substring` of a string of length `n` in strict `O(n)` linear time (compared to `O(n^2)` expand-around-center)?",
            options = listOf(
                QuestionOption("a", "It hashes all `O(n^2)` substrings"),
                QuestionOption("b", "It uses a Min-Heap of characters"),
                QuestionOption("c", "It inserts separator characters (like `'#'`) to unify odd/even palindromes, tracks the palindrome with the rightmost boundary `R` centered at `C`, and initializes `p[i]` from its mirror index `2*C - i` before only expanding beyond `R` (so `R` advances at most `2n` times total)!"),
                QuestionOption("d", "It sorts the string and checks if it equals its reverse")
            ),
            correctOptionId = "c",
            explanation = "By mirroring known palindrome radii inside the rightmost palindrome `[2C - R, R]`, Manacher's algorithm guarantees the right boundary `R` only increments, achieving `O(n)` worst-case time."
        ),
        QuizQuestion(
            id = "cs_adv_99",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Topological Sort` / `DAG` scheduling with task durations (Critical Path Method / `PERT`), what does the `Longest Path` in the dependency DAG represent?",
            options = listOf(
                QuestionOption("a", "The shortest single task"),
                QuestionOption("b", "The minimum possible total completion time (`makespan`) to finish all tasks even with unlimited parallel workers (the `Critical Path`, where any delay on a critical-path task directly delays the entire project)!"),
                QuestionOption("c", "The time required on a single-core CPU (which is the sum of all task durations)"),
                QuestionOption("d", "An infinite loop")
            ),
            correctOptionId = "b",
            explanation = "Even with infinite parallelism, sequential dependency chains must execute in order; the longest weighted path in the DAG (`dp[v] = duration[v] + max(dp[u])`) is the project's critical path."
        ),
        QuizQuestion(
            id = "cs_adv_100",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Bloom Filters` vs. `Cuckoo Filters` (or `Counting Bloom Filters`), why can you NOT simply clear the `k` bit positions to `0` to delete an element from a standard Bloom Filter?",
            options = listOf(
                QuestionOption("a", "Because those same bit positions may be shared (`1`) by other elements that were also inserted into the Bloom Filter; clearing them to `0` would introduce `False Negatives` for those other elements!"),
                QuestionOption("b", "Because bit arrays are read-only in hardware"),
                QuestionOption("c", "Because deleting a bit takes `O(n^2)` time"),
                QuestionOption("d", "You CAN safely clear bits to 0 in a standard Bloom Filter without side effects")
            ),
            correctOptionId = "a",
            explanation = "To support deletion without false negatives, a `Counting Bloom Filter` replaces each 1-bit slot with a small counter (incremented on insert, decremented on delete), or a `Cuckoo Filter` stores compact fingerprints."
        )
    )

}
