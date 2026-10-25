package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object ComputerFundamentalsQuestions {
    val questions: List<QuizQuestion> = listOf(
        // ==================== FOUNDATION (15) ====================
        QuizQuestion(
            id = "cs_f_01",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In an operating system, what is the primary memory difference between a **process** and a **thread** within the same process?",
            options = listOf(
                QuestionOption("a", "Processes have separate virtual address spaces by default, whereas threads of the same process share the same address space (heap and global data) while each having its own stack and registers."),
                QuestionOption("b", "Threads have completely isolated virtual address spaces, whereas all processes share a single heap."),
                QuestionOption("c", "A process can only run on one CPU core during its lifetime, whereas a thread cannot use CPU registers."),
                QuestionOption("d", "Threads share the same call stack and program counter register.")
            ),
            correctOptionId = "a",
            explanation = "Processes are isolated execution environments with independent virtual memory spaces, while threads within a process share code, data, and heap memory, maintaining separate stacks and register states."
        ),
        QuizQuestion(
            id = "cs_f_02",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which data structures directly correspond to **LIFO** (Last-In, First-Out) and **FIFO** (First-In, First-Out) ordering?",
            options = listOf(
                QuestionOption("a", "LIFO: Stack • FIFO: Queue"),
                QuestionOption("b", "LIFO: Queue • FIFO: Stack"),
                QuestionOption("c", "LIFO: Binary Search Tree • FIFO: Hash Table"),
                QuestionOption("d", "LIFO: Min-Heap • FIFO: Max-Heap")
            ),
            correctOptionId = "a",
            explanation = "A stack pops the most recently pushed element first (LIFO), whereas a queue dequeues the earliest enqueued element first (FIFO)."
        ),
        QuizQuestion(
            id = "cs_f_03",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the time complexity of binary search on a sorted array of n elements in the worst case?",
            options = listOf(
                QuestionOption("a", "O(log n)"),
                QuestionOption("b", "O(n)"),
                QuestionOption("c", "O(1)"),
                QuestionOption("d", "O(n log n)")
            ),
            correctOptionId = "a",
            explanation = "Binary search halves the remaining search interval on every comparison, requiring at most floor(log2(n)) + 1 comparisons (O(log n))."
        ),
        QuizQuestion(
            id = "cs_f_04",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the decimal value of the unsigned 8-bit binary number `00101101`?",
            options = listOf(
                QuestionOption("a", "45"),
                QuestionOption("b", "43"),
                QuestionOption("c", "53"),
                QuestionOption("d", "90")
            ),
            correctOptionId = "a",
            explanation = "`00101101` in base 2 equals 32 + 8 + 4 + 1 = 45 in decimal."
        ),
        QuizQuestion(
            id = "cs_f_05",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In computer networking, what is the primary trade-off between **TCP** and **UDP** at the Transport Layer?",
            options = listOf(
                QuestionOption("a", "TCP provides connection-oriented, reliable, ordered byte-stream delivery with congestion/flow control; UDP is connectionless with minimal overhead but no delivery or ordering guarantees."),
                QuestionOption("b", "UDP encrypts all packets automatically, whereas TCP sends packets in plaintext."),
                QuestionOption("c", "TCP is only used on local Wi-Fi networks, whereas UDP is required for routing across the internet."),
                QuestionOption("d", "UDP guarantees packet retransmission and in-order assembly, whereas TCP does not.")
            ),
            correctOptionId = "a",
            explanation = "TCP establishes a connection and uses sequence numbers, ACKs, and retransmissions for reliable in-order delivery; UDP sends independent datagrams with low latency and no handshake."
        ),
        QuizQuestion(
            id = "cs_f_06",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why do CPUs include small, fast **L1/L2/L3 caches** (SRAM) between processor registers and main memory (DRAM)?",
            options = listOf(
                QuestionOption("a", "To bridge the speed gap between fast CPU cores and slower DRAM by exploiting temporal and spatial locality."),
                QuestionOption("b", "To permanently store files when the computer is powered off."),
                QuestionOption("c", "Because CPU cores cannot address DRAM without first copying the entire RAM into L1 cache."),
                QuestionOption("d", "To replace virtual memory page tables.")
            ),
            correctOptionId = "a",
            explanation = "Main memory accesses take tens of nanoseconds, whereas L1 cache accesses take ~1 nanosecond. Caching recently accessed and nearby memory lines keeps the CPU pipeline fed."
        ),
        QuizQuestion(
            id = "cs_f_07",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What role does **DNS** (Domain Name System) play when a browser requests `https://example.com`?",
            options = listOf(
                QuestionOption("a", "It resolves the human-readable domain name (`example.com`) into an IP address (such as an IPv4 `A` or IPv6 `AAAA` record)."),
                QuestionOption("b", "It renders the HTML and CSS into pixels on the screen."),
                QuestionOption("c", "It assigns a private MAC address to the client's network card."),
                QuestionOption("d", "It compresses images inside the HTTP response body.")
            ),
            correctOptionId = "a",
            explanation = "DNS translates domain names into routable numerical IP addresses so the client can open a network connection to the target server."
        ),
        QuizQuestion(
            id = "cs_f_08",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In HTTP, which status code category indicates a **client error** (such as `404 Not Found` or `401 Unauthorized`) versus a **server error** (such as `500 Internal Server Error`)?",
            options = listOf(
                QuestionOption("a", "`4xx` indicates a client error; `5xx` indicates a server error."),
                QuestionOption("b", "`2xx` indicates a client error; `4xx` indicates a server error."),
                QuestionOption("c", "`3xx` indicates a client error; `2xx` indicates a server error."),
                QuestionOption("d", "`5xx` indicates a client error; `4xx` indicates a server error.")
            ),
            correctOptionId = "a",
            explanation = "HTTP status codes are grouped as `1xx` (Informational), `2xx` (Success), `3xx` (Redirection), `4xx` (Client Error), and `5xx` (Server Error)."
        ),
        QuizQuestion(
            id = "cs_f_09",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the essential requirement for every **recursive** function to avoid an infinite call chain and a stack overflow?",
            options = listOf(
                QuestionOption("a", "At least one reachable base case that returns without making a further recursive call, and recursive steps that make progress toward that base case."),
                QuestionOption("b", "Using global variables instead of function parameters."),
                QuestionOption("c", "Allocating all variables on the heap."),
                QuestionOption("d", "Having at least three parameters.")
            ),
            correctOptionId = "a",
            explanation = "Without a reachable base case and state changes that converge toward it, each call pushes another activation frame onto the call stack until the stack overflows."
        ),
        QuizQuestion(
            id = "cs_f_10",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary advantage of a **contiguous array** over a **singly linked list** for accessing the k-th element (`items[k]`)?",
            options = listOf(
                QuestionOption("a", "An array computes the address `base + k * element_size` in O(1) constant time, whereas a singly linked list must traverse k pointers in O(k) time."),
                QuestionOption("b", "Inserting at the very front (`index 0`) of an array is always O(1) without shifting elements."),
                QuestionOption("c", "A singly linked list cannot store more than 100 elements."),
                QuestionOption("d", "Arrays never require contiguous virtual memory.")
            ),
            correctOptionId = "a",
            explanation = "Contiguous memory layout gives arrays O(1) random access and high CPU cache locality, whereas linked list nodes are scattered in memory and require sequential pointer chasing."
        ),
        QuizQuestion(
            id = "cs_f_11",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a **Binary Search Tree (BST)**, which traversal order visits the nodes in non-decreasing (sorted) key order?",
            options = listOf(
                QuestionOption("a", "In-order traversal (Left subtree → Root → Right subtree)"),
                QuestionOption("b", "Pre-order traversal (Root → Left subtree → Right subtree)"),
                QuestionOption("c", "Post-order traversal (Left subtree → Right subtree → Root)"),
                QuestionOption("d", "Breadth-first level-order traversal")
            ),
            correctOptionId = "a",
            explanation = "Because every key in the left subtree is smaller than the root and every key in the right subtree is larger, visiting Left → Root → Right (in-order) outputs keys in sorted order."
        ),
        QuizQuestion(
            id = "cs_f_12",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the bitwise result of `0b1100 ^ 0b1010` (bitwise XOR)?",
            options = listOf(
                QuestionOption("a", "`0b0110` (decimal 6)"),
                QuestionOption("b", "`0b1000` (decimal 8)"),
                QuestionOption("c", "`0b1110` (decimal 14)"),
                QuestionOption("d", "`0b1001` (decimal 9)")
            ),
            correctOptionId = "a",
            explanation = "Bitwise XOR (`^`) outputs `1` where the corresponding bits differ and `0` where they are equal: `1100 ^ 1010 = 0110` (decimal 6)."
        ),
        QuizQuestion(
            id = "cs_f_13",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In operating systems, what is **virtual memory**?",
            options = listOf(
                QuestionOption("a", "An abstraction that gives each process its own private, contiguous logical address space mapped to physical RAM pages (and disk swap) via page tables and the MMU."),
                QuestionOption("b", "Memory stored exclusively on remote cloud servers."),
                QuestionOption("c", "A special CPU register used only for floating-point math."),
                QuestionOption("d", "Read-only BIOS firmware memory.")
            ),
            correctOptionId = "a",
            explanation = "Virtual memory decouples logical program addresses from physical RAM addresses using OS page tables and the hardware Memory Management Unit (MMU), providing isolation and demand paging."
        ),
        QuizQuestion(
            id = "cs_f_14",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why is a **mutex** (mutual exclusion lock) used when multiple threads update a shared counter?",
            options = listOf(
                QuestionOption("a", "To ensure only one thread enters the critical section at a time, preventing race conditions and lost updates."),
                QuestionOption("b", "To make all threads run simultaneously inside the critical section without waiting."),
                QuestionOption("c", "To double the clock frequency of the CPU."),
                QuestionOption("d", "To automatically delete unused variables from the stack.")
            ),
            correctOptionId = "a",
            explanation = "A mutex serializes access to a critical section so concurrent read-modify-write operations do not interleave and corrupt shared state."
        ),
        QuizQuestion(
            id = "cs_f_15",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Git version control, what is the difference between `git commit` and `git push`?",
            options = listOf(
                QuestionOption("a", "`git commit` records a snapshot in your local repository's history, whereas `git push` uploads local commits to a remote repository."),
                QuestionOption("b", "`git commit` uploads files directly to GitHub without saving locally."),
                QuestionOption("c", "`git push` stages untracked files into the working tree without committing."),
                QuestionOption("d", "They perform the exact same network operation.")
            ),
            correctOptionId = "a",
            explanation = "Git is a distributed version control system: `git commit` writes solely to the local `.git` repository, and `git push` transfers committed objects to a remote server."
        ),

        // ==================== APPLIED (15) ====================
        QuizQuestion(
            id = "cs_a_01",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In 8-bit **two's complement** signed integer representation, what decimal value does the binary pattern `11111100` represent?",
            options = listOf(
                QuestionOption("a", "`-4`"),
                QuestionOption("b", "`-124`"),
                QuestionOption("c", "`-3`"),
                QuestionOption("d", "`252`")
            ),
            correctOptionId = "a",
            explanation = "The sign bit is `1` (negative). Inverting the bits of `11111100` gives `00000011` (`3`), and adding `1` gives `00000100` (`4`), so the value is `-4` (or -128 + 64 + 32 + 16 + 8 + 4 = -4)."
        ),
        QuizQuestion(
            id = "cs_a_02",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the tight Big-O time complexity of the following nested loop as a function of n?",
            codeSnippet = """
                int steps = 0;
                for (int i = 1; i <= n; i *= 2) {
                    for (int j = 0; j < n; j++) {
                        steps++;
                    }
                }
            """.trimIndent(),
            options = listOf(
                QuestionOption("a", "O(n log n)"),
                QuestionOption("b", "O(n²)"),
                QuestionOption("c", "O(log n)"),
                QuestionOption("d", "O(n)")
            ),
            correctOptionId = "a",
            explanation = "The outer loop doubles `i` each time (`i *= 2`), running floor(log2(n)) + 1 iterations. For each outer iteration, the inner loop runs n times, giving O(n log n) total steps."
        ),
        QuizQuestion(
            id = "cs_a_03",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Suppose n keys are inserted in strictly ascending sorted order (`1, 2, 3, ..., n`) into an **unbalanced** Binary Search Tree. What is the worst-case lookup time complexity in the resulting tree?",
            options = listOf(
                QuestionOption("a", "O(n), because the tree degenerates into a right-leaning chain of height n - 1."),
                QuestionOption("b", "O(log n), because a BST always balances itself automatically."),
                QuestionOption("c", "O(1), because the keys are already sorted."),
                QuestionOption("d", "O(n²).")
            ),
            correctOptionId = "a",
            explanation = "Without self-balancing rotations (such as AVL or Red-Black trees), inserting sorted keys places every new node as the right child of the previous node, forming a linked list of height O(n)."
        ),
        QuizQuestion(
            id = "cs_a_04",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is **Breadth-First Search (BFS)** guaranteed to find the shortest path (fewest edges) from a source node in an unweighted graph, whereas **Depth-First Search (DFS)** is not?",
            options = listOf(
                QuestionOption("a", "BFS uses a FIFO queue to explore vertices in non-decreasing order of distance (d = 0, 1, 2, ... edges) from the source, whereas DFS explores deeply along one branch before backtracking."),
                QuestionOption("b", "BFS inspects edge weights using a priority queue, whereas DFS ignores edges."),
                QuestionOption("c", "DFS cannot visit all reachable vertices in a connected graph."),
                QuestionOption("d", "BFS only works on trees and cannot run on graphs with cycles.")
            ),
            correctOptionId = "a",
            explanation = "Because BFS processes nodes level-by-level via a queue, the first time a vertex v is discovered, it is reached via a path with the minimum possible number of edges."
        ),
        QuizQuestion(
            id = "cs_a_05",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Which sorting algorithm is **stable** and guarantees O(n log n) time complexity in best, average, and worst cases, at the cost of O(n) auxiliary memory on arrays?",
            options = listOf(
                QuestionOption("a", "Merge Sort"),
                QuestionOption("b", "In-place Quick Sort with last-element pivot"),
                QuestionOption("c", "Heap Sort"),
                QuestionOption("d", "Selection Sort")
            ),
            correctOptionId = "a",
            explanation = "Merge Sort recursively splits the array in half and merges sorted halves stably in O(n) time per level across log2(n) levels (O(n log n) worst-case), using O(n) buffer space."
        ),
        QuizQuestion(
            id = "cs_a_06",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In an LRU (Least Recently Used) cache with capacity **3** (initially empty), the keys `A, B, C, A, D` are accessed in that order. Which key is evicted when `D` is inserted?",
            options = listOf(
                QuestionOption("a", "`B`"),
                QuestionOption("b", "`A`"),
                QuestionOption("c", "`C`"),
                QuestionOption("d", "`D`")
            ),
            correctOptionId = "a",
            explanation = "Step 1: `A, B, C` fills the cache (order from oldest to newest: `A, B, C`). Step 2: Accessing `A` marks `A` as most recently used (order: `B, C, A`). Step 3: Inserting `D` evicts the least recently used key, which is `B` (leaving `C, A, D`)."
        ),
        QuizQuestion(
            id = "cs_a_07",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What sequence of packet flags is exchanged during a standard **TCP 3-way handshake** to establish a connection?",
            options = listOf(
                QuestionOption("a", "Client sends `SYN` → Server replies `SYN-ACK` → Client replies `ACK`"),
                QuestionOption("b", "Client sends `ACK` → Server replies `SYN` → Client replies `FIN`"),
                QuestionOption("c", "Client sends `SYN` → Server replies `ACK` → Server sends `FIN`"),
                QuestionOption("d", "Client sends `GET` → Server replies `200 OK` → Client sends `ACK`")
            ),
            correctOptionId = "a",
            explanation = "To synchronize initial sequence numbers in both directions, the client sends `SYN`, the server acknowledges and sends its own sequence number (`SYN-ACK`), and the client acknowledges (`ACK`)."
        ),
        QuizQuestion(
            id = "cs_a_08",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In IPv4 CIDR notation, how many total IP addresses and how many usable host addresses exist in a `/26` subnet (such as `192.168.1.0/26`)?",
            options = listOf(
                QuestionOption("a", "64 total addresses (2^(32-26) = 2^6), with 62 usable host addresses (excluding network and broadcast addresses)."),
                QuestionOption("b", "256 total addresses, with 254 usable host addresses."),
                QuestionOption("c", "32 total addresses, with 30 usable host addresses."),
                QuestionOption("d", "26 total addresses, with 24 usable host addresses.")
            ),
            correctOptionId = "a",
            explanation = "An IPv4 address has 32 bits. A `/26` prefix leaves 32 - 26 = 6 host bits, giving 2^6 = 64 total addresses. Subtracting the network address (all host bits 0) and broadcast address (all host bits 1) leaves 64 - 2 = 62 usable hosts."
        ),
        QuizQuestion(
            id = "cs_a_09",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In HTTP/1.1 and REST API design, what does it mean for an HTTP method (such as `PUT` or `DELETE`) to be **idempotent**?",
            options = listOf(
                QuestionOption("a", "Making the identical request multiple times in a row has the same intended state effect on the server as making it once."),
                QuestionOption("b", "The request is guaranteed to never modify any data on the server (read-only)."),
                QuestionOption("c", "The response is always cached permanently by the browser."),
                QuestionOption("d", "The request never requires authentication headers.")
            ),
            correctOptionId = "a",
            explanation = "An operation is idempotent if repeating the exact request produces the same server state as a single execution (`GET`, `PUT`, and `DELETE` are idempotent; `POST` is generally not)."
        ),
        QuizQuestion(
            id = "cs_a_10",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When the CPU translates a virtual memory address to a physical address, what is the role of the **TLB** (Translation Lookaside Buffer)?",
            options = listOf(
                QuestionOption("a", "A hardware cache of recent virtual-to-physical page table translations that avoids slow multi-level page table walks in RAM on a TLB hit."),
                QuestionOption("b", "A disk partition used when physical RAM is completely full."),
                QuestionOption("c", "A buffer that stores incoming network packets from the NIC."),
                QuestionOption("d", "A compiler optimization pass that reorders assembly instructions.")
            ),
            correctOptionId = "a",
            explanation = "Without a TLB, every virtual memory access would require reading page table entries from RAM. The TLB caches hot page translations right inside the MMU."
        ),
        QuizQuestion(
            id = "cs_a_11",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the time complexity of building a binary heap from an unsorted array of n elements using the bottom-up `heapify` (Floyd's) algorithm, and what is the time complexity of extracting the minimum element?",
            options = listOf(
                QuestionOption("a", "Building the heap is O(n), and extracting the minimum (`extractMin`) is O(log n)."),
                QuestionOption("b", "Building the heap is O(n²), and extracting the minimum is O(1)."),
                QuestionOption("c", "Building the heap is O(n log n), and extracting the minimum is O(n)."),
                QuestionOption("d", "Both building the heap and extracting the minimum are O(1).")
            ),
            correctOptionId = "a",
            explanation = "Bottom-up sifting down from n/2 to 1 takes linear O(n) total work because most nodes are near the bottom of the tree. Removing the root swaps the last leaf to the root and sifts down along the tree height in O(log n)."
        ),
        QuizQuestion(
            id = "cs_a_12",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why do two-dimensional row-major arrays (such as in C, Java, or NumPy default order) run significantly faster when iterated **row-by-row** (`grid[r][c]` with `c` in the inner loop) than **column-by-column**?",
            options = listOf(
                QuestionOption("a", "Row-by-row access reads contiguous memory addresses, maximizing CPU cache line spatial locality and hardware prefetching, whereas column-by-column jumps by a full row stride and causes frequent cache misses."),
                QuestionOption("b", "CPUs have a dedicated row-addition instruction that cannot index columns."),
                QuestionOption("c", "Column-by-column iteration requires acquiring an OS kernel lock on each step."),
                QuestionOption("d", "Row-by-row skips bounds checking automatically in all languages.")
            ),
            correctOptionId = "a",
            explanation = "A CPU cache line typically loads 64 contiguous bytes at once. Stepping through adjacent elements in row-major order hits the already-loaded cache line instead of missing cache on every jump."
        ),
        QuizQuestion(
            id = "cs_a_13",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does floating-point arithmetic evaluate `0.1 + 0.2 == 0.3` to `false` in standard IEEE 754 binary64 (`double`)?",
            options = listOf(
                QuestionOption("a", "Fractions like 1/10 (0.1) and 2/10 (0.2) do not have finite representations in base-2 binary fractions, so rounding errors accumulate to `0.30000000000000004`."),
                QuestionOption("b", "The `==` operator on `double` compares memory addresses instead of numeric values."),
                QuestionOption("c", "IEEE 754 only supports integers and single-digit decimals."),
                QuestionOption("d", "The CPU randomizes the least significant bit for security.")
            ),
            correctOptionId = "a",
            explanation = "Just as 1/3 = 0.333... repeats infinitely in base 10, 0.1 in base 10 = 0.0001100110011... in base 2. Rounding to 53 significand bits introduces tiny representation deltas."
        ),
        QuizQuestion(
            id = "cs_a_14",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a hash table with n elements and m buckets, what happens to the average lookup time if the hash function maps every key to the exact same constant hash code (e.g., `return 42;`)?",
            options = listOf(
                QuestionOption("a", "All n elements collide in a single bucket, degrading lookup from O(1) average to O(n) (or O(log n) if treeified)."),
                QuestionOption("b", "Lookup becomes faster because `return 42;` takes O(1) to compute."),
                QuestionOption("c", "The hash table automatically overwrites previous keys so only 1 element remains."),
                QuestionOption("d", "Lookup remains O(1) regardless of collisions.")
            ),
            correctOptionId = "a",
            explanation = "Hash table O(1) average performance depends on uniform key distribution across buckets. Constant hashes collapse all entries into bucket `42 % m`, requiring a scan of all n entries."
        ),
        QuizQuestion(
            id = "cs_a_15",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a bitwise permission bitmask where `READ = 1 << 0` (`1`), `WRITE = 1 << 1` (`2`), and `EXEC = 1 << 2` (`4`), which expression checks whether `flags` has the `WRITE` bit set?",
            options = listOf(
                QuestionOption("a", "`(flags & WRITE) != 0`"),
                QuestionOption("b", "`(flags | WRITE) != 0`"),
                QuestionOption("c", "`(flags ^ WRITE) != 0`"),
                QuestionOption("d", "`flags == WRITE`")
            ),
            correctOptionId = "a",
            explanation = "Bitwise AND (`flags & WRITE`) masks out all bits except the `WRITE` bit (`0b010`). If the result is non-zero, `WRITE` is enabled regardless of whether `READ` or `EXEC` are also set."
        ),

        // ==================== ADVANCED (15) ====================
        QuizQuestion(
            id = "cs_x_01",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "According to the **Coffman deadlock conditions**, all four of the following must hold simultaneously for a resource deadlock to occur: Mutual Exclusion, Hold and Wait, No Preemption, and Circular Wait. Which condition is broken when you enforce that all threads acquire locks in a strict global ascending order of lock IDs?",
            options = listOf(
                QuestionOption("a", "Circular Wait"),
                QuestionOption("b", "Mutual Exclusion"),
                QuestionOption("c", "No Preemption"),
                QuestionOption("d", "Hold and Wait")
            ),
            correctOptionId = "a",
            explanation = "If every thread must acquire lock L_i before lock L_j whenever i < j, no cycle T1 → T2 → ... → T1 can ever form in the resource allocation graph, eliminating Circular Wait."
        ),
        QuizQuestion(
            id = "cs_x_02",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can **Dijkstra's shortest-path algorithm** produce incorrect results on a graph with negative-weight edges (even when no negative-weight cycle exists)?",
            options = listOf(
                QuestionOption("a", "Dijkstra greedily assumes that once a vertex u with the minimum tentative distance is popped from the priority queue, its shortest path is final—an assumption violated if a later path through a negative edge reduces d[u] further."),
                QuestionOption("b", "Priority queues cannot store negative numbers."),
                QuestionOption("c", "Dijkstra's algorithm only works on undirected trees."),
                QuestionOption("d", "Negative edge weights cause `Integer.MIN_VALUE` overflow on the very first step.")
            ),
            correctOptionId = "a",
            explanation = "Dijkstra relies on non-negative edge weights so that extending any path only increases (or keeps equal) total distance. With negative edges, a longer initial detour followed by a negative edge can beat an already-finalized vertex (Bellman-Ford handles negative edges in O(V × E))."
        ),
        QuizQuestion(
            id = "cs_x_03",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Using the Master Theorem, what is the asymptotic time complexity of the divide-and-conquer recurrence T(n) = 2T(n/2) + O(n)?",
            options = listOf(
                QuestionOption("a", "O(n log n)"),
                QuestionOption("b", "O(n)"),
                QuestionOption("c", "O(n²)"),
                QuestionOption("d", "O(log n)")
            ),
            correctOptionId = "a",
            explanation = "With a = 2 subproblems of size n/2 (b = 2), n^(log_b(a)) = n^1 = n. Since the combine work f(n) = O(n) matches n^1 (Case 2 of the Master Theorem), T(n) = O(n log n)."
        ),
        QuizQuestion(
            id = "cs_x_04",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In multi-core CPU architectures, what is **false sharing**?",
            options = listOf(
                QuestionOption("a", "When threads on different cores frequently modify independent variables that happen to reside on the same CPU cache line (e.g., 64 bytes), causing repeated cache-coherency invalidations and severe performance degradation."),
                QuestionOption("b", "When two threads read the same `final` constant from shared memory."),
                QuestionOption("c", "When a process shares a read-only code library (`.so` / `.dll`) with another process."),
                QuestionOption("d", "When a pointer points to freed heap memory.")
            ),
            correctOptionId = "a",
            explanation = "Cache coherence protocols (like MESI) track state per cache line, not per individual variable. If Core 0 writes `arr[0]` and Core 1 writes `arr[1]` in the same 64-byte line, the cache line ping-pongs between cores."
        ),
        QuizQuestion(
            id = "cs_x_05",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When resizing a dynamic array (like `ArrayList` or `std::vector`) by doubling its capacity whenever it becomes full, why is the **amortized** cost of n sequential `append` operations O(1) per append?",
            options = listOf(
                QuestionOption("a", "Copies occur only at powers of two (1, 2, 4, 8, ..., 2^k), so the total elements copied across n appends is 1 + 2 + 4 + ... + n < 2n, averaging < 2 copies per append."),
                QuestionOption("b", "The operating system resizes arrays in O(1) without ever copying elements in memory."),
                QuestionOption("c", "Doubling capacity means reallocation happens on every single append."),
                QuestionOption("d", "The amortized cost is actually O(log n) per append.")
            ),
            correctOptionId = "a",
            explanation = "By geometric series summation, n insertions perform n direct writes plus 1 + 2 + 4 + ... < 2n element copies during reallocations, totaling < 3n = O(n) work for n operations, or O(1) amortized per append."
        ),
        QuizQuestion(
            id = "cs_x_06",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In operating systems, what happens during **Copy-on-Write (CoW)** after a process calls `fork()`?",
            options = listOf(
                QuestionOption("a", "Parent and child initially share the same physical memory pages marked read-only; only when either process writes to a page does the OS trap the fault and duplicate that specific page."),
                QuestionOption("b", "`fork()` immediately copies every byte of the parent's physical RAM before returning."),
                QuestionOption("c", "Writes made by the child process are permanently visible in the parent process."),
                QuestionOption("d", "All open files are deleted when `fork()` is called.")
            ),
            correctOptionId = "a",
            explanation = "Copy-on-Write avoids duplicating the entire address space on `fork()`. Page table entries in both processes point to the same physical frames with write-protection enabled until a write triggers a page fault and copies just the modified page."
        ),
        QuizQuestion(
            id = "cs_x_07",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What guarantee does a **Bloom filter** provide when testing whether an element x is in a set?",
            options = listOf(
                QuestionOption("a", "False positives are possible (it may say x is probably present when it is not), but **false negatives are impossible** (if it says x is not present, x is definitely not in the set), assuming no deletions."),
                QuestionOption("b", "False negatives are possible, but false positives are impossible."),
                QuestionOption("c", "Both false positives and false negatives are impossible, using O(1) bits total."),
                QuestionOption("d", "It can return all original elements in sorted order.")
            ),
            correctOptionId = "a",
            explanation = "A Bloom filter sets k bit positions for each inserted key. If any of the k bits for query key x is `0`, x was definitely never inserted (zero false negatives). However, bits set by other keys can overlap, causing a small, tunable false-positive rate."
        ),
        QuizQuestion(
            id = "cs_x_08",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a **TLS 1.3 handshake** (HTTPS), how are asymmetric (public-key) cryptography and symmetric cryptography combined?",
            options = listOf(
                QuestionOption("a", "Asymmetric key exchange (e.g., ephemeral Diffie-Hellman ECDHE) and certificates authenticate the server and establish shared ephemeral session keys, after which fast symmetric AEAD ciphers (e.g., AES-GCM or ChaCha20-Poly1305) encrypt the actual application traffic."),
                QuestionOption("b", "Every byte of the HTTP response body is encrypted directly with the server's 4096-bit RSA public key."),
                QuestionOption("c", "The client sends its symmetric key in plaintext inside an HTTP header."),
                QuestionOption("d", "TLS 1.3 uses only MD5 hashing and no encryption.")
            ),
            correctOptionId = "a",
            explanation = "Public-key operations are computationally expensive and provide authentication + forward-secret key agreement (ECDHE). Once both sides derive the shared session secret, symmetric AEAD encryption handles bulk data transfer at high speed."
        ),
        QuizQuestion(
            id = "cs_x_09",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In CPU execution pipelines, why can a branch with a random 50/50 condition inside a tight loop run several times slower than the same loop over sorted or branchless data?",
            options = listOf(
                QuestionOption("a", "Random branch outcomes defeat the CPU's hardware branch predictor, causing frequent pipeline flushes and wasted speculative work (~15–20 cycles per misprediction)."),
                QuestionOption("b", "`if` statements always trigger a system call into the OS kernel."),
                QuestionOption("c", "Sorted arrays are stored in CPU registers instead of RAM."),
                QuestionOption("d", "Branch prediction only exists in interpreted languages, not compiled machine code.")
            ),
            correctOptionId = "a",
            explanation = "Modern superscalar CPUs speculatively fetch and execute instructions past conditional branches before the condition is resolved. A branch misprediction requires flushing the pipeline and rolling back speculative state."
        ),
        QuizQuestion(
            id = "cs_x_10",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is **thrashing** in an operating system's virtual memory subsystem?",
            options = listOf(
                QuestionOption("a", "When the combined working sets of active processes exceed physical RAM, causing the system to spend nearly all its time paging memory frames to and from disk rather than executing instructions."),
                QuestionOption("b", "When a CPU core runs at 100% utilization executing tight math loops in L1 cache."),
                QuestionOption("c", "When a hard drive's file system is defragmented."),
                QuestionOption("d", "When garbage collection frees unreachable objects in the young generation.")
            ),
            correctOptionId = "a",
            explanation = "Thrashing occurs when processes lack enough resident pages to hold their active working sets, triggering continuous page faults that evict pages needed moments later."
        ),
        QuizQuestion(
            id = "cs_x_11",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What defines a **topological sort** of a directed graph G = (V, E), and when does a valid topological ordering exist?",
            options = listOf(
                QuestionOption("a", "A linear ordering of vertices such that for every directed edge u → v, vertex u comes before v; it exists if and only if G is a Directed Acyclic Graph (DAG)."),
                QuestionOption("b", "A sorting of vertices by their out-degree; it exists for every directed graph including cycles."),
                QuestionOption("c", "A minimum spanning tree of an undirected weighted graph."),
                QuestionOption("d", "A path that visits every edge in the graph exactly once.")
            ),
            correctOptionId = "a",
            explanation = "Any directed cycle u → ... → v → u makes it impossible for every edge predecessor to appear earlier in a linear order. Thus a topological ordering exists iff the directed graph has no cycles (a DAG)."
        ),
        QuizQuestion(
            id = "cs_x_12",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a Disjoint-Set (Union-Find) data structure with both **path compression** and **union by rank/size**, what is the amortized time complexity per `find` and `union` operation on n elements?",
            options = listOf(
                QuestionOption("a", "O(α(n)), where α(n) is the inverse Ackermann function (practically ≤ 4, effectively constant time)."),
                QuestionOption("b", "O(n) per operation."),
                QuestionOption("c", "O(√n) per operation."),
                QuestionOption("d", "O(n log n) per operation.")
            ),
            correctOptionId = "a",
            explanation = "Combining union by rank/size with path compression flattens trees during lookups, achieving O(α(n)) amortized time per operation (Tarjan's bound)."
        ),
        QuizQuestion(
            id = "cs_x_13",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "For any positive integer x, what does the bitwise expression `x & (x - 1)` do?",
            options = listOf(
                QuestionOption("a", "Clears (sets to `0`) the lowest set `1`-bit of `x` (so `(x & (x - 1)) == 0` tests whether `x` is a power of two)."),
                QuestionOption("b", "Sets the highest `0`-bit of `x` to `1`."),
                QuestionOption("c", "Multiplies `x` by `2`."),
                QuestionOption("d", "Always evaluates to `0` for every odd integer.")
            ),
            correctOptionId = "a",
            explanation = "Subtracting `1` from `x` flips the rightmost `1`-bit to `0` and turns all trailing `0`s after it to `1`s. Bitwise ANDing `x & (x - 1)` zeroes out that rightmost `1`-bit while leaving all higher bits unchanged."
        ),
        QuizQuestion(
            id = "cs_x_14",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What are the two core properties that characterize problems solvable by **Dynamic Programming**?",
            options = listOf(
                QuestionOption("a", "Optimal Substructure (an optimal solution can be constructed from optimal solutions to subproblems) and Overlapping Subproblems (the same subproblems are solved repeatedly in naive recursion)."),
                QuestionOption("b", "Greedy Choice Property and disjoint independent subproblems that never overlap."),
                QuestionOption("c", "Constant O(1) space and no loops."),
                QuestionOption("d", "Randomized pivot selection and hashing.")
            ),
            correctOptionId = "a",
            explanation = "Divide-and-conquer algorithms like Merge Sort have disjoint subproblems; Dynamic Programming specifically shines when optimal substructure is paired with overlapping subproblems that can be memoized or tabulated."
        ),
        QuizQuestion(
            id = "cs_x_15",
            category = QuizCategory.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In automatic memory management, why cannot simple **reference counting** alone reclaim two unreachable objects `A` and `B` that hold references to each other (`A.next = B; B.prev = A`), whereas a **tracing mark-and-sweep garbage collector** can?",
            options = listOf(
                QuestionOption("a", "In a reference cycle, both `A` and `B` still have a reference count of `1` even when unreachable from program roots, whereas tracing GC starts from GC roots (stacks, globals, registers) and sweeps anything not reachable from those roots."),
                QuestionOption("b", "Reference counting only works on primitive integers, not objects."),
                QuestionOption("c", "Tracing garbage collectors delete objects as soon as their constructor finishes."),
                QuestionOption("d", "Reference counting cannot decrement counts when local variables go out of scope.")
            ),
            correctOptionId = "a",
            explanation = "Pure reference counting only tracks incoming edges to each node locally, so isolated cycles retain positive counts (≥ 1). Tracing collectors determine liveness via graph reachability from root references."
        )
    )
}
