package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object PythonQuestions {
    val questions: List<QuizQuestion> = listOf(
        // ==================== FOUNDATION (15) ====================
        QuizQuestion(
            id = "py_f_01",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Python 3, what is the primary structural difference between a `list` and a `tuple`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A list is mutable, whereas a tuple is immutable after creation."),
                QuestionOption("b", "A tuple can only store elements of a single data type."),
                QuestionOption("c", "A list cannot be indexed with negative numbers."),
                QuestionOption("d", "A tuple automatically sorts its elements in ascending order.")
            ),
            correctOptionId = "a",
            explanation = "Lists allow item reassignment, appending, and removal in place, while tuples have a fixed structure whose element references cannot be rebound after creation."
        ),
        QuizQuestion(
            id = "py_f_02",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of evaluating the expression `17 // 5` and `17 / 5` in Python 3?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`3` and `3.4`"),
                QuestionOption("b", "`3.4` and `3`"),
                QuestionOption("c", "`3` and `3`"),
                QuestionOption("d", "`4` and `3.4`")
            ),
            correctOptionId = "a",
            explanation = "In Python 3, `//` performs floor division (`17 // 5 == 3`), while `/` always performs true floating-point division (`17 / 5 == 3.4`)."
        ),
        QuizQuestion(
            id = "py_f_03",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why is calling `my_dict.get('score', 0)` often preferred over `my_dict['score']` when reading a potentially missing key?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `0` instead of raising a `KeyError` if `'score'` is absent."),
                QuestionOption("b", "It permanently inserts `'score': 0` into the dictionary."),
                QuestionOption("c", "It converts string values into integers automatically."),
                QuestionOption("d", "It executes in constant time while bracket indexing is linear.")
            ),
            correctOptionId = "a",
            explanation = "`dict.get(key, default)` safely returns `default` when `key` is not present without mutating the dictionary or raising `KeyError`."
        ),
        QuizQuestion(
            id = "py_f_04",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the slice `" + "\"QuizNova\"[1:5]" + "` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "\"uizN\""),
                QuestionOption("b", "\"Quiz\""),
                QuestionOption("c", "\"uizNo\""),
                QuestionOption("d", "\"QuizN\"")
            ),
            correctOptionId = "a",
            explanation = "Python slices `[start:stop]` start at zero-based index `1` (`'u'`) and stop just before index `5` (`'o'`), producing characters at indices 1, 2, 3, and 4: `\"uizN\"`."
        ),
        QuizQuestion(
            id = "py_f_05",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which statement accurately contrasts the `==` operator and the `is` keyword in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`==` checks value equality, whereas `is` checks whether both operands refer to the exact same object in memory."),
                QuestionOption("b", "`is` checks value equality, whereas `==` compares memory addresses."),
                QuestionOption("c", "`==` only works on numbers, whereas `is` only works on strings."),
                QuestionOption("d", "They are completely interchangeable for all Python objects.")
            ),
            correctOptionId = "a",
            explanation = "`==` invokes `__eq__` to test if two objects have equal values; `is` compares `id(a) == id(b)` to verify object identity."
        ),
        QuizQuestion(
            id = "py_f_06",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which of the following values is treated as truthy (`True`) inside an `if` condition in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "\"0\""),
                QuestionOption("b", "[]"),
                QuestionOption("c", "0"),
                QuestionOption("d", "None")
            ),
            correctOptionId = "a",
            explanation = "Any non-empty string—including `\"0\"` (length 1)—is truthy in Python. Empty containers (`[]`), numeric zero (`0`), and `None` are all falsy."
        ),
        QuizQuestion(
            id = "py_f_07",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What sequence of integers is produced by `list(range(2, 9, 3))`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[2, 5, 8]"),
                QuestionOption("b", "[2, 5, 8, 11]"),
                QuestionOption("c", "[2, 3, 6, 9]"),
                QuestionOption("d", "[3, 6, 9]")
            ),
            correctOptionId = "a",
            explanation = "`range(start=2, stop=9, step=3)` begins at 2 and adds 3 repeatedly while strictly less than 9, yielding `2, 5, 8`."
        ),
        QuizQuestion(
            id = "py_f_08",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the main difference between `items.append([4, 5])` and `items.extend([4, 5])` on `items = [1, 2, 3]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`append` adds `[4, 5]` as a single nested list element; `extend` appends `4` and `5` individually."),
                QuestionOption("b", "`extend` creates a new list and leaves `items` unchanged, while `append` mutates `items`."),
                QuestionOption("c", "`append` adds elements at the start of the list, while `extend` adds them at the end."),
                QuestionOption("d", "There is no difference when the argument is a list.")
            ),
            correctOptionId = "a",
            explanation = "`append(x)` inserts `x` as a single item (`[1, 2, 3, [4, 5]]`), whereas `extend(iterable)` iterates over the argument and appends each element (`[1, 2, 3, 4, 5]`)."
        ),
        QuizQuestion(
            id = "py_f_09",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when you convert a list with duplicate values into a `set`, such as `set([3, 1, 3, 2, 1])`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Duplicate values are removed, leaving a set of the unique items `{1, 2, 3}`."),
                QuestionOption("b", "A `ValueError` is raised because sets cannot be constructed from lists with duplicates."),
                QuestionOption("c", "Only the duplicate elements `{1, 3}` are retained."),
                QuestionOption("d", "All five elements are kept, but they become immutable.")
            ),
            correctOptionId = "a",
            explanation = "A Python `set` is an unordered collection of unique hashable elements, so duplicate values are automatically deduplicated."
        ),
        QuizQuestion(
            id = "py_f_10",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If a Python function finishes executing without encountering a `return` statement, what value does it return to the caller?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`None`"),
                QuestionOption("b", "`0`"),
                QuestionOption("c", "`False`"),
                QuestionOption("d", "An empty tuple `()`")
            ),
            correctOptionId = "a",
            explanation = "Every Python function implicitly returns `None` when execution reaches the end of the function body without an explicit `return` value."
        ),
        QuizQuestion(
            id = "py_f_11",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which built-in function lets you iterate over a sequence while receiving both the index and the item as `(index, item)` pairs?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`enumerate()`"),
                QuestionOption("b", "`zip()`"),
                QuestionOption("c", "`iter()`"),
                QuestionOption("d", "`map()`")
            ),
            correctOptionId = "a",
            explanation = "`enumerate(iterable, start=0)` yields `(index, value)` tuples for each item in the iterable."
        ),
        QuizQuestion(
            id = "py_f_12",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `try ... except ... finally` block, when does the `finally` suite execute?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Always before leaving the `try` statement, whether an exception occurred, was caught, or `return` was executed."),
                QuestionOption("b", "Only when no exception is raised inside the `try` block."),
                QuestionOption("c", "Only when an exception is raised and not caught by any `except` clause."),
                QuestionOption("d", "Only when an `except` block explicitly calls `finally()`.")
            ),
            correctOptionId = "a",
            explanation = "The `finally` block is guaranteed to run for cleanup regardless of whether the `try` block completes normally, raises an exception, or returns early."
        ),
        QuizQuestion(
            id = "py_f_13",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary purpose of using `with open('data.txt', 'r') as f:` instead of manually calling `f = open('data.txt', 'r')`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The context manager guarantees the file is closed automatically when exiting the `with` block, even if an exception occurs."),
                QuestionOption("b", "It loads the entire file into GPU memory for faster reading."),
                QuestionOption("c", "It suppresses all `FileNotFoundError` exceptions automatically."),
                QuestionOption("d", "It locks the file permanently so no other function in the program can ever open it again.")
            ),
            correctOptionId = "a",
            explanation = "The `with` statement invokes the file's context manager (`__enter__` and `__exit__`), ensuring `f.close()` is called deterministically."
        ),
        QuizQuestion(
            id = "py_f_14",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a function definition `def log_event(category, *tags, **metadata):`, how are `*tags` and `**metadata` collected inside the function?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`tags` is a `tuple` of extra positional arguments, and `metadata` is a `dict` of extra keyword arguments."),
                QuestionOption("b", "`tags` is a `list` of keyword arguments, and `metadata` is a `set` of positional arguments."),
                QuestionOption("c", "Both `tags` and `metadata` are collected as Python `list` objects."),
                QuestionOption("d", "`tags` is a `dict` and `metadata` is a `tuple`.")
            ),
            correctOptionId = "a",
            explanation = "`*args` packs excess positional arguments into a `tuple`, while `**kwargs` packs excess keyword arguments into a `dict`."
        ),
        QuizQuestion(
            id = "py_f_15",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which type of object can be used as a key in a standard Python `dict`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A tuple containing only immutable elements, such as `('US', 2026)`"),
                QuestionOption("b", "A standard list, such as `['US', 2026]`"),
                QuestionOption("c", "A standard dictionary, such as `{'country': 'US'}`"),
                QuestionOption("d", "A mutable `set`, such as `{'US', 2026}`")
            ),
            correctOptionId = "a",
            explanation = "Dictionary keys must be hashable. Lists, dicts, and mutable sets are unhashable (`TypeError: unhashable type`), whereas a tuple of hashable items is hashable."
        ),

        // ==================== APPLIED (15) ====================
        QuizQuestion(
            id = "py_a_01",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following Python code output?",
            codeSnippet = """
                def add_tag(tag, tags=[]):
                    tags.append(tag)
                    return tags

                first = add_tag("sql")
                second = add_tag("python")
                print(first, second)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['sql', 'python'] ['sql', 'python']"),
                QuestionOption("b", "['sql'] ['python']"),
                QuestionOption("c", "['sql'] ['sql', 'python']"),
                QuestionOption("d", "Raises a TypeError at runtime")
            ),
            correctOptionId = "a",
            explanation = "Default parameter values are evaluated once when `def` is executed, not on each call. Both `first` and `second` reference and mutate the exact same default list object `['sql', 'python']`."
        ),
        QuizQuestion(
            id = "py_a_02",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the value of `result` after running this list comprehension?",
            codeSnippet = """
                nums = [1, 2, 3, 4, 5, 6]
                result = [n * n for n in nums if n % 2 == 0]
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[4, 16, 36]"),
                QuestionOption("b", "[1, 4, 9, 16, 25, 36]"),
                QuestionOption("c", "[2, 4, 6]"),
                QuestionOption("d", "[1, 9, 25]")
            ),
            correctOptionId = "a",
            explanation = "The `if n % 2 == 0` filter keeps even numbers (`2, 4, 6`), and `n * n` squares each of them to produce `[4, 16, 36]`."
        ),
        QuizQuestion(
            id = "py_a_03",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by the following code that uses `copy.copy()` (shallow copy)?",
            codeSnippet = """
                import copy

                original = [[1, 2], [3, 4]]
                shallow = copy.copy(original)
                shallow.append([5, 6])
                shallow[0][0] = 99
                print(original)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[[99, 2], [3, 4]]"),
                QuestionOption("b", "[[1, 2], [3, 4]]"),
                QuestionOption("c", "[[99, 2], [3, 4], [5, 6]]"),
                QuestionOption("d", "[[1, 2], [3, 4], [5, 6]]")
            ),
            correctOptionId = "a",
            explanation = "`shallow` is a new outer list, so `shallow.append([5, 6])` does not affect `original`. However, the inner lists are shared references, so mutating `shallow[0][0] = 99` is visible in `original[0][0]`."
        ),
        QuizQuestion(
            id = "py_a_04",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following generator code print?",
            codeSnippet = """
                gen = (x * 2 for x in [1, 2, 3])
                first_sum = sum(gen)
                second_sum = sum(gen)
                print(first_sum, second_sum)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "12 0"),
                QuestionOption("b", "12 12"),
                QuestionOption("c", "6 0"),
                QuestionOption("d", "Raises StopIteration on the second sum()")
            ),
            correctOptionId = "a",
            explanation = "A generator expression produces a single-pass iterator. The first `sum(gen)` consumes `2 + 4 + 6 = 12` and exhausts `gen`. The second `sum(gen)` sees an empty iterator and returns `0`."
        ),
        QuizQuestion(
            id = "py_a_05",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `for ... else` loop in Python?",
            codeSnippet = """
                values = [2, 4, 6]
                for v in values:
                    if v % 2 != 0:
                        print("Found odd")
                        break
                else:
                    print("No odd found")
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "No odd found"),
                QuestionOption("b", "Found odd"),
                QuestionOption("c", "Nothing is printed"),
                QuestionOption("d", "SyntaxError: else cannot follow a for loop")
            ),
            correctOptionId = "a",
            explanation = "In Python, the `else` clause on a `for` or `while` loop executes if and only if the loop terminates normally without hitting a `break` statement."
        ),
        QuizQuestion(
            id = "py_a_06",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed when this dictionary unpacking expression runs?",
            codeSnippet = """
                defaults = {"timeout": 10, "retries": 3}
                custom = {"retries": 5, "tls": True}
                merged = {**defaults, **custom}
                print(merged["retries"], len(merged))
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "5 3"),
                QuestionOption("b", "3 3"),
                QuestionOption("c", "5 4"),
                QuestionOption("d", "Raises ValueError for duplicate key 'retries'")
            ),
            correctOptionId = "a",
            explanation = "When unpacking dictionaries with `{**defaults, **custom}`, later keys overwrite earlier ones. `'retries'` becomes `5`, and the total distinct keys are `'timeout'`, `'retries'`, and `'tls'` (3 keys)."
        ),
        QuizQuestion(
            id = "py_a_07",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following `sorted()` call return?",
            codeSnippet = """
                words = ["pear", "fig", "apple", "kiwi"]
                result = sorted(words, key=lambda w: (len(w), w))
                print(result)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['fig', 'kiwi', 'pear', 'apple']"),
                QuestionOption("b", "['apple', 'fig', 'kiwi', 'pear']"),
                QuestionOption("c", "['fig', 'pear', 'kiwi', 'apple']"),
                QuestionOption("d", "['apple', 'pear', 'kiwi', 'fig']")
            ),
            correctOptionId = "a",
            explanation = "The key `(len(w), w)` sorts primarily by word length (`'fig'` has 3, `'kiwi'` and `'pear'` have 4, `'apple'` has 5) and breaks ties alphabetically (`'kiwi'` before `'pear'`)."
        ),
        QuizQuestion(
            id = "py_a_08",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What are the values of `head`, `middle`, and `tail` after sequence unpacking?",
            codeSnippet = """
                head, *middle, tail = [10, 20, 30, 40, 50]
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`head = 10`, `middle = [20, 30, 40]`, `tail = 50`"),
                QuestionOption("b", "`head = 10`, `middle = (20, 30, 40)`, `tail = 50`"),
                QuestionOption("c", "`head = [10]`, `middle = [20, 30, 40]`, `tail = [50]`"),
                QuestionOption("d", "Raises ValueError: too many values to unpack")
            ),
            correctOptionId = "a",
            explanation = "Starred target unpacking (`*middle`) always binds the captured middle slice as a `list` (`[20, 30, 40]`), regardless of whether the source iterable is a list or tuple."
        ),
        QuizQuestion(
            id = "py_a_09",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following short-circuit boolean expression output?",
            codeSnippet = """
                user_name = ""
                fallback = "Guest"
                display = user_name or fallback
                verified = bool(user_name) and "Badge"
                print(display, verified)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Guest False"),
                QuestionOption("b", "True False"),
                QuestionOption("c", "Guest Badge"),
                QuestionOption("d", " True")
            ),
            correctOptionId = "a",
            explanation = "In Python, `x or y` returns `x` if `x` is truthy, else `y` (so `\"\" or \"Guest\"` evaluates to `\"Guest\"`). `x and y` returns `x` if `x` is falsy, else `y` (so `False and \"Badge\"` stops and returns `False`)."
        ),
        QuizQuestion(
            id = "py_a_10",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when this code executes?",
            codeSnippet = """
                count = 10

                def increment():
                    count += 1
                    return count

                print(increment())
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises `UnboundLocalError` because `count` is assigned inside `increment()` without `global`."),
                QuestionOption("b", "Prints `11` and updates the global `count` to `11`."),
                QuestionOption("c", "Prints `11` while keeping the global `count` at `10`."),
                QuestionOption("d", "Prints `10`.")
            ),
            correctOptionId = "a",
            explanation = "Because `count += 1` assigns to `count` inside `increment`, Python compiles `count` as a local variable. Reading it before it has a local value raises `UnboundLocalError`."
        ),
        QuizQuestion(
            id = "py_a_11",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this code using `collections.defaultdict`?",
            codeSnippet = """
                from collections import defaultdict

                groups = defaultdict(list)
                for word in ["cat", "car", "dog"]:
                    groups[word[0]].append(word)

                print(len(groups["c"]), len(groups["z"]))
                print("z" in groups)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "2 0\nTrue"),
                QuestionOption("b", "2 0\nFalse"),
                QuestionOption("c", "Raises KeyError on groups['z']"),
                QuestionOption("d", "3 0\nTrue")
            ),
            correctOptionId = "a",
            explanation = "Accessing `groups['z']` via `[]` on a `defaultdict(list)` invokes `list()` to insert `'z': []` into the dictionary, so `len(groups['z'])` is `0` and `'z' in groups` is now `True`."
        ),
        QuizQuestion(
            id = "py_a_12",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `list(zip([1, 2, 3, 4], ['a', 'b']))` return in Python 3?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[(1, 'a'), (2, 'b')]"),
                QuestionOption("b", "[(1, 'a'), (2, 'b'), (3, None), (4, None)]"),
                QuestionOption("c", "Raises ValueError because the input lengths differ"),
                QuestionOption("d", "[1, 'a', 2, 'b']")
            ),
            correctOptionId = "a",
            explanation = "By default, `zip()` stops as soon as the shortest input iterable is exhausted, producing two pairs: `[(1, 'a'), (2, 'b')]`."
        ),
        QuizQuestion(
            id = "py_a_13",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by the following class attribute vs. instance attribute code?",
            codeSnippet = """
                class Counter:
                    step = 1

                c1 = Counter()
                c2 = Counter()
                c1.step = 5
                Counter.step = 2
                print(c1.step, c2.step)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "5 2"),
                QuestionOption("b", "2 2"),
                QuestionOption("c", "5 1"),
                QuestionOption("d", "5 5")
            ),
            correctOptionId = "a",
            explanation = "`c1.step = 5` creates an instance attribute in `c1.__dict__` that shadows the class attribute. `c2` has no instance attribute `step`, so `c2.step` resolves to the updated `Counter.step` (`2`)."
        ),
        QuizQuestion(
            id = "py_a_14",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of evaluating `all([])` and `any([])` on an empty list in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`True` and `False`"),
                QuestionOption("b", "`False` and `False`"),
                QuestionOption("c", "`True` and `True`"),
                QuestionOption("d", "`False` and `True`")
            ),
            correctOptionId = "a",
            explanation = "`all(iterable)` checks that no element is falsy (vacuously `True` for an empty iterable). `any(iterable)` checks whether at least one element is truthy (`False` for an empty iterable)."
        ),
        QuizQuestion(
            id = "py_a_15",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following dictionary comprehension produce?",
            codeSnippet = """
                pairs = [("a", 1), ("b", 2), ("a", 9)]
                lookup = {k: v for k, v in pairs}
                print(lookup)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "{'a': 9, 'b': 2}"),
                QuestionOption("b", "{'a': 1, 'b': 2}"),
                QuestionOption("c", "{'a': [1, 9], 'b': [2]}"),
                QuestionOption("d", "Raises KeyError for duplicate key 'a'")
            ),
            correctOptionId = "a",
            explanation = "The comprehension inserts keys in iteration order. The second `('a', 9)` pair overwrites the earlier value `1` for key `'a'`, resulting in `{'a': 9, 'b': 2}`."
        ),

        // ==================== ADVANCED (15) ====================
        QuizQuestion(
            id = "py_x_01",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does this closure loop print, and why?",
            codeSnippet = """
                funcs = [lambda x: x + i for i in range(3)]
                results = [f(10) for f in funcs]
                print(results)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`[12, 12, 12]` because `i` is looked up by late binding after the loop finishes with `i == 2`."),
                QuestionOption("b", "`[10, 11, 12]` because each lambda captures the value of `i` at the moment it is created."),
                QuestionOption("c", "`[10, 10, 10]` because `i` resets to `0` after the list comprehension."),
                QuestionOption("d", "Raises `NameError: name 'i' is not defined` when `f(10)` is called.")
            ),
            correctOptionId = "a",
            explanation = "Python closures capture variables by reference (late binding), not by value. By the time `f(10)` is called, the comprehension loop has completed and `i` in that scope holds `2`, so every call computes `10 + 2 = 12`."
        ),
        QuizQuestion(
            id = "py_x_02",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Given the inheritance hierarchy below, what is the Method Resolution Order (MRO) printed for class `D`?",
            codeSnippet = """
                class A: pass
                class B(A): pass
                class C(A): pass
                class D(B, C): pass

                print([cls.__name__ for cls in D.mro()])
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['D', 'B', 'C', 'A', 'object']"),
                QuestionOption("b", "['D', 'B', 'A', 'C', 'object']"),
                QuestionOption("c", "['D', 'C', 'B', 'A', 'object']"),
                QuestionOption("d", "['D', 'A', 'B', 'C', 'object']")
            ),
            correctOptionId = "a",
            explanation = "Python uses C3 linearization: subclasses always precede base classes (`B` and `C` both precede `A`), and left-to-right base order (`B` before `C`) is preserved, yielding `D -> B -> C -> A -> object`."
        ),
        QuizQuestion(
            id = "py_x_03",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is the assignment `t[1] += [4]` on the tuple below both raising `TypeError` AND mutating the nested list?",
            codeSnippet = """
                t = (1, [2, 3])
                try:
                    t[1] += [4]
                except TypeError:
                    pass
                print(t)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Prints `(1, [2, 3, 4])` because `+=` first calls `list.__iadd__` to mutate the list in place, and then fails when attempting `t[1] = result` on the tuple."),
                QuestionOption("b", "Prints `(1, [2, 3])` because the tuple blocks the operation before the list can be touched."),
                QuestionOption("c", "Prints `(1, [2, 3, 4])` without raising `TypeError` at all."),
                QuestionOption("d", "Raises `AttributeError` instead of `TypeError`, halting execution.")
            ),
            correctOptionId = "a",
            explanation = "Augmented assignment `t[1] += [4]` executes in two steps: first `list.__iadd__` extends the list in place to `[2, 3, 4]`, and second Python tries to assign the returned reference back into `t[1]`, which raises `TypeError` on the tuple."
        ),
        QuizQuestion(
            id = "py_x_04",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when a class defines `__eq__` without defining `__hash__` in Python 3?",
            codeSnippet = """
                class Point:
                    def __init__(self, x, y):
                        self.x, self.y = x, y
                    def __eq__(self, other):
                        return (self.x, self.y) == (other.x, other.y)
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`Point.__hash__` is automatically set to `None`, making `Point` instances unhashable in sets and dict keys."),
                QuestionOption("b", "`Point` continues to inherit `object.__hash__` based on memory address."),
                QuestionOption("c", "Python automatically generates a hash from `(self.x, self.y)`."),
                QuestionOption("d", "Defining `__eq__` without `__hash__` raises a `SyntaxError` when defining the class.")
            ),
            correctOptionId = "a",
            explanation = "To uphold the invariant that equal objects must have equal hashes, Python 3 sets `__hash__ = None` whenever a class overrides `__eq__` without explicitly defining `__hash__`."
        ),
        QuizQuestion(
            id = "py_x_05",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the effect of declaring `__slots__ = ('x', 'y')` on a class that inherits directly from `object`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Instances store `x` and `y` in fixed descriptor slots instead of creating an instance `__dict__`, reducing memory overhead and preventing arbitrary new attributes."),
                QuestionOption("b", "Instances become completely immutable like a `namedtuple`."),
                QuestionOption("c", "The class cannot be subclassed by any other class."),
                QuestionOption("d", "All methods on the class become `staticmethod` automatically.")
            ),
            correctOptionId = "a",
            explanation = "`__slots__` suppresses the per-instance `__dict__` (unless `'__dict__'` is included in `__slots__`), saving memory and raising `AttributeError` if undeclared attributes are assigned."
        ),
        QuizQuestion(
            id = "py_x_06",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When two decorators are stacked above a function, in what order are they applied at definition time versus executed at call time?",
            codeSnippet = """
                @dec_outer
                @dec_inner
                def compute():
                    return 42
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Applied bottom-up (`dec_inner` first, then `dec_outer`), so at call time `dec_outer`'s wrapper runs first."),
                QuestionOption("b", "Applied top-down (`dec_outer` first, then `dec_inner`), so at call time `dec_inner`'s wrapper runs first."),
                QuestionOption("c", "Both applied and executed bottom-up (`dec_inner` runs before `dec_outer` on every call)."),
                QuestionOption("d", "Applied only the first time `compute()` is called at runtime.")
            ),
            correctOptionId = "a",
            explanation = "`@dec_outer @dec_inner def compute()` is equivalent to `compute = dec_outer(dec_inner(compute))`. Thus `dec_inner` wraps `compute` first, and `dec_outer` wraps the result—meaning `dec_outer`'s wrapper is the outermost entry point when called."
        ),
        QuizQuestion(
            id = "py_x_07",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does the following function return when called?",
            codeSnippet = """
                def check():
                    try:
                        return "from_try"
                    finally:
                        return "from_finally"

                print(check())
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "from_finally"),
                QuestionOption("b", "from_try"),
                QuestionOption("c", "('from_try', 'from_finally')"),
                QuestionOption("d", "Raises SyntaxError because finally cannot contain return")
            ),
            correctOptionId = "a",
            explanation = "Because `finally` always runs before the function exits, a `return` statement inside `finally` overrides any pending `return` value (and even suppresses any active exception) from the `try` block."
        ),
        QuizQuestion(
            id = "py_x_08",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is printed when this matrix initialization code runs?",
            codeSnippet = """
                grid = [[0] * 3] * 3
                grid[0][1] = 7
                print([row[1] for row in grid])
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[7, 7, 7]"),
                QuestionOption("b", "[7, 0, 0]"),
                QuestionOption("c", "[0, 7, 0]"),
                QuestionOption("d", "[0, 0, 0]")
            ),
            correctOptionId = "a",
            explanation = "`[[0] * 3] * 3` creates an outer list containing three references to the exact same inner list object. Modifying `grid[0][1] = 7` updates index 1 of that single shared row."
        ),
        QuizQuestion(
            id = "py_x_09",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python's descriptor protocol, what distinguishes a **data descriptor** from a **non-data descriptor** during attribute lookup `obj.attr`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A data descriptor defines `__set__` or `__delete__` and takes precedence over `obj.__dict__['attr']`; a non-data descriptor only defines `__get__` and is shadowed by `obj.__dict__['attr']`."),
                QuestionOption("b", "A non-data descriptor takes precedence over `obj.__dict__`, whereas a data descriptor is shadowed by instance attributes."),
                QuestionOption("c", "Data descriptors can only store primitive numbers, whereas non-data descriptors store functions."),
                QuestionOption("d", "Data descriptors are looked up on the instance first, whereas non-data descriptors are looked up on `object` first.")
            ),
            correctOptionId = "a",
            explanation = "Attribute lookup `obj.attr` checks data descriptors (such as `@property` with a setter, or any descriptor defining `__set__`/`__delete__`) on `type(obj)` BEFORE `obj.__dict__`, and non-data descriptors (such as regular methods defining only `__get__`) AFTER `obj.__dict__`."
        ),
        QuizQuestion(
            id = "py_x_10",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `yield from sub_gen()` differ from a simple loop `for item in sub_gen(): yield item`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`yield from` forwards `.send()`, `.throw()`, and `.close()` directly to `sub_gen()` and captures `sub_gen`'s final `return` value as the expression result."),
                QuestionOption("b", "`yield from` runs `sub_gen()` on a separate OS thread automatically."),
                QuestionOption("c", "`yield from` eagerly converts `sub_gen()` into a `list` in memory before yielding."),
                QuestionOption("d", "There is no behavioral difference; it is purely syntactic sugar for the `for` loop.")
            ),
            correctOptionId = "a",
            explanation = "PEP 380 introduced `yield from` to establish a transparent two-way channel between the caller and the subgenerator (propagating `send`, `throw`, and `close`) and returning the value carried by the subgenerator's `StopIteration.value`."
        ),
        QuizQuestion(
            id = "py_x_11",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when you mutate a dictionary's keys while iterating directly over it?",
            codeSnippet = """
                scores = {"a": 1, "b": 2, "c": 3}
                for k in scores:
                    if k == "a":
                        del scores[k]
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises `RuntimeError: dictionary changed size during iteration`."),
                QuestionOption("b", "Silently removes `'a'` and finishes iterating over `'b'` and `'c'`."),
                QuestionOption("c", "Raises `KeyError: 'a'`."),
                QuestionOption("d", "Automatically iterates over a snapshot copy of the dictionary.")
            ),
            correctOptionId = "a",
            explanation = "Python dictionary iterators track the dictionary's structural size/version and raise `RuntimeError: dictionary changed size during iteration` when keys are added or removed mid-loop. Iterating over `list(scores)` avoids this."
        ),
        QuizQuestion(
            id = "py_x_12",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.8+, what is the difference between `[y := f(x), y * 2]` and `[f(x), f(x) * 2]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The assignment expression `:=` evaluates `f(x)` once, binds its result to `y` in the enclosing scope, and reuses `y` for `y * 2`."),
                QuestionOption("b", "`y := f(x)` creates a variable `y` that is strictly private to the list literal and inaccessible afterward."),
                QuestionOption("c", "The `:=` operator compares `y` and `f(x)` for identity."),
                QuestionOption("d", "`[y := f(x), y * 2]` is a `SyntaxError` inside a list literal.")
            ),
            correctOptionId = "a",
            explanation = "The walrus operator (`:=`) assigns and returns the value of `f(x)` in a single evaluation, binding `y` in the current scope so `y * 2` does not recompute `f(x)`."
        ),
        QuizQuestion(
            id = "py_x_13",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a `@dataclass` definition, why does Python disallow `tags: list[str] = []` and require `field(default_factory=list)` instead?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises `ValueError: mutable default <class 'list'> is not allowed` to prevent all instances from accidentally sharing the same mutable list."),
                QuestionOption("b", "Type annotations in dataclasses cannot use generic types like `list[str]`."),
                QuestionOption("c", "Dataclasses only support immutable primitive fields."),
                QuestionOption("d", "It is allowed and creates a deep copy automatically, so `default_factory` is optional.")
            ),
            correctOptionId = "a",
            explanation = "The `@dataclass` decorator inspects default values at class creation time and raises `ValueError` for mutable defaults (`list`, `dict`, `set`) so developers use `default_factory` to instantiate a fresh container per instance."
        ),
        QuizQuestion(
            id = "py_x_14",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a custom context manager's `__exit__(self, exc_type, exc_val, exc_tb)` method, what happens if `__exit__` returns `True` when an exception was raised inside the `with` block?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The exception is suppressed, and execution resumes normally at the statement immediately following the `with` block."),
                QuestionOption("b", "The exception is re-raised immediately after `__exit__` completes."),
                QuestionOption("c", "The `with` block restarts from the beginning."),
                QuestionOption("d", "A `RuntimeError` is raised because `__exit__` must always return `None`.")
            ),
            correctOptionId = "a",
            explanation = "If `__exit__` returns a truthy value, the Python runtime suppresses the exception that occurred in the `with` body; if it returns `False` or `None`, the exception propagates outward."
        ),
        QuizQuestion(
            id = "py_x_15",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does the following `itertools.groupby` snippet output, and why?",
            codeSnippet = """
                from itertools import groupby

                data = ["a1", "a2", "b1", "a3"]
                groups = [(k, list(g)) for k, g in groupby(data, key=lambda s: s[0])]
                print(len(groups))
            """.trimIndent(),
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`3`, because `groupby` only groups consecutive elements that share a key (`'a'`, then `'b'`, then `'a'` again)."),
                QuestionOption("b", "`2`, because `groupby` sorts the input by key before grouping."),
                QuestionOption("c", "`4`, because every string in `data` is distinct."),
                QuestionOption("d", "`1`, because all elements are strings.")
            ),
            correctOptionId = "a",
            explanation = "`itertools.groupby` scans linearly and starts a new group whenever the key value changes relative to the previous element. Since `data` is not pre-sorted by key, `'a3'` forms a third group `[('a', ['a1', 'a2']), ('b', ['b1']), ('a', ['a3'])]`."
        )
    )
}
