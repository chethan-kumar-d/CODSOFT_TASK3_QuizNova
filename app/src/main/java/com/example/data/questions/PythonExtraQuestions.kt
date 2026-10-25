package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object PythonExtraQuestions {
    val questions: List<QuizQuestion> by lazy {
        foundationBatch1() + foundationBatch2() + appliedBatch1() + appliedBatch2() + advancedBatch1() + advancedBatch2()
    }

    private fun foundationBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "py_f_16",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'  hello world  '.strip()` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'hello world'"),
                QuestionOption("b", "'helloworld'"),
                QuestionOption("c", "'  hello world'"),
                QuestionOption("d", "'hello world  '")
            ),
            correctOptionId = "a",
            explanation = "`str.strip()` removes leading and trailing whitespace characters, leaving internal spaces untouched."
        ),
        QuizQuestion(
            id = "py_f_17",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the output of `'-'.join(['2025', '05', '19'])`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['2025-05-19']"),
                QuestionOption("b", "'2025-05-19'"),
                QuestionOption("c", "'20250519-'"),
                QuestionOption("d", "'-2025-05-19-'")
            ),
            correctOptionId = "b",
            explanation = "`str.join(iterable)` concatenates the strings in the iterable separated by the delimiter string `'-'`."
        ),
        QuizQuestion(
            id = "py_f_18",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'banana'.count('an')` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1"),
                QuestionOption("b", "3"),
                QuestionOption("c", "2"),
                QuestionOption("d", "0")
            ),
            correctOptionId = "c",
            explanation = "`str.count(sub)` counts non-overlapping occurrences of `'an'` in `'banana'` (at indices 1 and 3), returning `2`."
        ),
        QuizQuestion(
            id = "py_f_19",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is returned by `'prefixed_name'.removeprefix('prefixed_')` in Python 3.9+?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises AttributeError"),
                QuestionOption("b", "'prefixed_name'"),
                QuestionOption("c", "''"),
                QuestionOption("d", "'name'")
            ),
            correctOptionId = "d",
            explanation = "`str.removeprefix(prefix)` removes the exact leading prefix once if present and returns the remaining string `'name'`."
        ),
        QuizQuestion(
            id = "py_f_20",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'archive.tar.gz'.endswith(('.zip', '.gz'))` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "True"),
                QuestionOption("b", "False"),
                QuestionOption("c", "'.gz'"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "a",
            explanation = "`str.endswith()` accepts a tuple of suffixes and returns `True` if the string ends with any one of them."
        ),
        QuizQuestion(
            id = "py_f_21",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when `'hello'.index('z')` is executed?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `-1`."),
                QuestionOption("b", "It raises a `ValueError`."),
                QuestionOption("c", "It returns `None`."),
                QuestionOption("d", "It returns `False`.")
            ),
            correctOptionId = "b",
            explanation = "Unlike `str.find()`, which returns `-1` when a substring is not found, `str.index()` raises a `ValueError`."
        ),
        QuizQuestion(
            id = "py_f_22",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the value of `'Python'[-2]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'t'"),
                QuestionOption("b", "'n'"),
                QuestionOption("c", "'o'"),
                QuestionOption("d", "Raises IndexError")
            ),
            correctOptionId = "c",
            explanation = "Negative indices count from the end of the sequence: `-1` is `'n'` and `-2` is `'o'`."
        ),
        QuizQuestion(
            id = "py_f_23",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'abcdef'[::2]` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'fedcba'"),
                QuestionOption("b", "'bdf'"),
                QuestionOption("c", "'ab'"),
                QuestionOption("d", "'ace'")
            ),
            correctOptionId = "d",
            explanation = "A slice step of `2` selects every second character starting from index `0` (`'a'`, `'c'`, `'e'`)."
        ),
        QuizQuestion(
            id = "py_f_24",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which literal creates a single-element tuple containing the integer `42`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "(42,)"),
                QuestionOption("b", "(42)"),
                QuestionOption("c", "[42]"),
                QuestionOption("d", "{42}")
            ),
            correctOptionId = "a",
            explanation = "A trailing comma `(42,)` is required to construct a 1-tuple; `(42)` is just a parenthesized integer expression."
        ),
        QuizQuestion(
            id = "py_f_25",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "After executing `a, *b, c = [10, 20, 30, 40, 50]`, what is the value of `b`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "(20, 30, 40)"),
                QuestionOption("b", "[20, 30, 40]"),
                QuestionOption("c", "30"),
                QuestionOption("d", "[10, 20, 30, 40]")
            ),
            correctOptionId = "b",
            explanation = "Starred assignment `*b` captures all middle elements into a `list`, while `a` gets `10` and `c` gets `50`."
        ),
        QuizQuestion(
            id = "py_f_26",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `[10, 20, 30, 20].remove(20)` do to the list?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Removes the element at index 20."),
                QuestionOption("b", "Removes all occurrences of `20`, leaving `[10, 30]`."),
                QuestionOption("c", "Removes only the first occurrence of `20`, leaving `[10, 30, 20]`."),
                QuestionOption("d", "Returns a new list without mutating the original.")
            ),
            correctOptionId = "c",
            explanation = "`list.remove(x)` deletes the first matching element equal to `x` in place and returns `None`."
        ),
        QuizQuestion(
            id = "py_f_27",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is returned by `nums.pop(1)` when `nums = ['a', 'b', 'c']`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['a', 'c']"),
                QuestionOption("b", "'c'"),
                QuestionOption("c", "'a'"),
                QuestionOption("d", "'b'")
            ),
            correctOptionId = "d",
            explanation = "`list.pop(index)` removes and returns the element at the specified zero-based index (`1`, which is `'b'`)."
        ),
        QuizQuestion(
            id = "py_f_28",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How do `nums.sort()` and `sorted(nums)` differ for a list `nums`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`nums.sort()` sorts the list in place and returns `None`; `sorted(nums)` returns a new sorted list without modifying `nums`."),
                QuestionOption("b", "`sorted(nums)` mutates `nums` in place; `nums.sort()` returns a copy."),
                QuestionOption("c", "They both return a new list."),
                QuestionOption("d", "`nums.sort()` only works on strings.")
            ),
            correctOptionId = "a",
            explanation = "`list.sort()` is an in-place mutating method returning `None`, whereas built-in `sorted()` builds and returns a new list."
        ),
        QuizQuestion(
            id = "py_f_29",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the type of `{}` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`set`"),
                QuestionOption("b", "`dict`"),
                QuestionOption("c", "`frozenset`"),
                QuestionOption("d", "`tuple`")
            ),
            correctOptionId = "b",
            explanation = "`{}` creates an empty dictionary; an empty set must be created using `set()`."
        ),
        QuizQuestion(
            id = "py_f_30",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `s = {1, 2, 3}`, what is the difference between `s.discard(99)` and `s.remove(99)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Both raise `KeyError` when the element is absent."),
                QuestionOption("b", "`s.remove(99)` returns `False`, whereas `s.discard(99)` raises a `ValueError`."),
                QuestionOption("c", "`s.discard(99)` does nothing and raises no error, whereas `s.remove(99)` raises a `KeyError`."),
                QuestionOption("d", "`s.discard(99)` clears the entire set.")
            ),
            correctOptionId = "c",
            explanation = "`set.discard(elem)` removes `elem` if present and quietly succeeds if absent; `set.remove(elem)` raises `KeyError` if absent."
        ),
        QuizQuestion(
            id = "py_f_31",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `{1, 2, 3} & {2, 3, 4}` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "{1}"),
                QuestionOption("b", "{1, 2, 3, 4}"),
                QuestionOption("c", "{1, 4}"),
                QuestionOption("d", "{2, 3}")
            ),
            correctOptionId = "d",
            explanation = "The `&` operator on sets computes the set intersection—elements common to both sets."
        ),
        QuizQuestion(
            id = "py_f_32",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `{1, 2, 3} ^ {2, 3, 4}` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "{1, 4}"),
                QuestionOption("b", "{2, 3}"),
                QuestionOption("c", "{1, 2, 3, 4}"),
                QuestionOption("d", "set()")
            ),
            correctOptionId = "a",
            explanation = "The `^` operator on sets computes the symmetric difference—elements present in either set, but not in both."
        ),
        QuizQuestion(
            id = "py_f_33",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `d = {'a': 1, 'b': 2}`, what does `'a' in d` check?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Whether `'a'` is a value in `d`."),
                QuestionOption("b", "Whether `'a'` is a key in `d`."),
                QuestionOption("c", "Whether `'a'` is both a key and value."),
                QuestionOption("d", "Whether `'a'` is the first value.")
            ),
            correctOptionId = "b",
            explanation = "The `in` operator on a dictionary checks membership among its keys in O(1) average time."
        ),
        QuizQuestion(
            id = "py_f_34",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `d.setdefault('count', 10)` do if `'count'` is NOT already a key in `d`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises a `KeyError`."),
                QuestionOption("b", "Returns `10` without modifying `d`."),
                QuestionOption("c", "Inserts `'count': 10` into `d` and returns `10`."),
                QuestionOption("d", "Replaces all values in `d` with `10`.")
            ),
            correctOptionId = "c",
            explanation = "`dict.setdefault(key, default)` returns `d[key]` if `key` exists; otherwise it sets `d[key] = default` and returns `default`."
        ),
        QuizQuestion(
            id = "py_f_35",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `dict([('x', 1), ('y', 2)])`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises TypeError"),
                QuestionOption("b", "[('x', 1), ('y', 2)]"),
                QuestionOption("c", "{('x', 1), ('y', 2)}"),
                QuestionOption("d", "{'x': 1, 'y': 2}")
            ),
            correctOptionId = "d",
            explanation = "Passing an iterable of `(key, value)` pairs to `dict()` constructs a dictionary mapping each key to its value."
        ),
        QuizQuestion(
            id = "py_f_36",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `list(enumerate(['a', 'b'], start=1))` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[(1, 'a'), (2, 'b')]"),
                QuestionOption("b", "[(0, 'a'), (1, 'b')]"),
                QuestionOption("c", "[('a', 1), ('b', 2)]"),
                QuestionOption("d", "[1, 2]")
            ),
            correctOptionId = "a",
            explanation = "`enumerate(iterable, start=1)` yields `(index, item)` tuples starting the counter at `1`."
        ),
        QuizQuestion(
            id = "py_f_37",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `list(zip([1, 2, 3], ['a', 'b']))` return in Python 3?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[(1, 'a'), (2, 'b'), (3, None)]"),
                QuestionOption("b", "[(1, 'a'), (2, 'b')]"),
                QuestionOption("c", "Raises ValueError"),
                QuestionOption("d", "[(1, 2, 3), ('a', 'b')]")
            ),
            correctOptionId = "b",
            explanation = "By default (when `strict=False`), `zip()` stops as soon as the shortest input iterable is exhausted."
        ),
        QuizQuestion(
            id = "py_f_38",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When does the `else` block of a `for` loop execute in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Whenever a `break` statement is executed inside the loop."),
                QuestionOption("b", "Only when the iterable is empty."),
                QuestionOption("c", "When the loop finishes iterating normally without encountering a `break` statement."),
                QuestionOption("d", "Only if an exception is raised inside the loop.")
            ),
            correctOptionId = "c",
            explanation = "A `for ... else` block runs if and only if the loop terminates naturally without hitting `break`."
        ),
        QuizQuestion(
            id = "py_f_39",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `all([True, 1, 'non-empty'])` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'non-empty'"),
                QuestionOption("b", "False"),
                QuestionOption("c", "1"),
                QuestionOption("d", "True")
            ),
            correctOptionId = "d",
            explanation = "`all(iterable)` returns `True` if every element in the iterable is truthy (or if the iterable is empty)."
        ),
        QuizQuestion(
            id = "py_f_40",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `any([0, '', None, []])` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "False"),
                QuestionOption("b", "True"),
                QuestionOption("c", "None"),
                QuestionOption("d", "0")
            ),
            correctOptionId = "a",
            explanation = "`any(iterable)` returns `True` if at least one element is truthy; since `0`, `''`, `None`, and `[]` are all falsy, it returns `False`."
        ),
        QuizQuestion(
            id = "py_f_41",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `all([])` evaluate to for an empty list?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "False"),
                QuestionOption("b", "True"),
                QuestionOption("c", "None"),
                QuestionOption("d", "Raises ValueError")
            ),
            correctOptionId = "b",
            explanation = "`all([])` is vacuously `True` because there are no falsy elements in the empty iterable."
        ),
        QuizQuestion(
            id = "py_f_42",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the value of `0 or 'default'` and `0 and 'default'` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`0` and `'default'`"),
                QuestionOption("b", "`True` and `False`"),
                QuestionOption("c", "`'default'` and `0`"),
                QuestionOption("d", "`False` and `0`")
            ),
            correctOptionId = "c",
            explanation = "`or` returns the first operand if truthy, else the second (`'default'`). `and` returns the first operand if falsy (`0`), else the second."
        ),
        QuizQuestion(
            id = "py_f_43",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `divmod(23, 5)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[4, 3]"),
                QuestionOption("b", "(3, 4)"),
                QuestionOption("c", "4.6"),
                QuestionOption("d", "(4, 3)")
            ),
            correctOptionId = "d",
            explanation = "`divmod(a, b)` returns the tuple `(a // b, a % b)`, which for `(23, 5)` is `(4, 3)`."
        ),
        QuizQuestion(
            id = "py_f_44",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Python 3, what does `round(2.5)` and `round(3.5)` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`2` and `4`"),
                QuestionOption("b", "`3` and `4`"),
                QuestionOption("c", "`2` and `3`"),
                QuestionOption("d", "`3` and `3`")
            ),
            correctOptionId = "a",
            explanation = "Python 3 uses round-half-to-even (banker's rounding), rounding `.5` ties to the nearest even integer (`2` and `4`)."
        ),
        QuizQuestion(
            id = "py_f_45",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `int('1011', 2)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1011"),
                QuestionOption("b", "11"),
                QuestionOption("c", "7"),
                QuestionOption("d", "Raises ValueError")
            ),
            correctOptionId = "b",
            explanation = "`int(string, base=2)` parses `'1011'` as a binary number: `8 + 0 + 2 + 1 = 11`."
        ),
        QuizQuestion(
            id = "py_f_46",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What do `ord('A')` and `chr(65)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`97` and `'a'`"),
                QuestionOption("b", "`'A'` and `65`"),
                QuestionOption("c", "`65` and `'A'`"),
                QuestionOption("d", "`1` and `'A'`")
            ),
            correctOptionId = "c",
            explanation = "`ord()` returns the Unicode code point of a character (`65` for `'A'`), and `chr()` converts the code point back to a character."
        ),
        QuizQuestion(
            id = "py_f_47",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Python, `bool` is a subclass of which built-in type?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`tuple`"),
                QuestionOption("b", "`str`"),
                QuestionOption("c", "`float`"),
                QuestionOption("d", "`int`")
            ),
            correctOptionId = "d",
            explanation = "`issubclass(bool, int)` is `True` in Python; `True` and `False` behave like `1` and `0` in integer contexts."
        ),
        QuizQuestion(
            id = "py_f_48",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `isinstance(True, int)` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "True"),
                QuestionOption("b", "False"),
                QuestionOption("c", "Raises TypeError"),
                QuestionOption("d", "None")
            ),
            correctOptionId = "a",
            explanation = "Because `bool` inherits from `int`, `isinstance(True, int)` returns `True`."
        ),
        QuizQuestion(
            id = "py_f_49",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Inside a function definition `def log(msg, *tags, **meta):`, what are the types of `tags` and `meta`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`tags` is a `list` and `meta` is a `set`."),
                QuestionOption("b", "`tags` is a `tuple` and `meta` is a `dict`."),
                QuestionOption("c", "Both are `dict`."),
                QuestionOption("d", "Both are `list`.")
            ),
            correctOptionId = "b",
            explanation = "`*args` collects extra positional arguments into a `tuple`, and `**kwargs` collects extra keyword arguments into a `dict`."
        ),
        QuizQuestion(
            id = "py_f_50",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does a Python function return if it reaches the end of its body without executing a `return` statement?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`False`"),
                QuestionOption("b", "`0`"),
                QuestionOption("c", "`None`"),
                QuestionOption("d", "`''`")
            ),
            correctOptionId = "c",
            explanation = "Every Python function that falls off the end (or executes a bare `return`) implicitly returns `None`."
        ),
        QuizQuestion(
            id = "py_f_51",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In `def connect(host, /, port=5432, *, timeout=10):`, what do `/` and `*` specify?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "All three parameters are keyword-only."),
                QuestionOption("b", "`host` is keyword-only and `timeout` is positional-only."),
                QuestionOption("c", "`port` cannot have a default value."),
                QuestionOption("d", "`host` is positional-only and `timeout` is keyword-only.")
            ),
            correctOptionId = "d",
            explanation = "Parameters before `/` are positional-only (Python 3.8+), and parameters after `*` are keyword-only."
        ),
        QuizQuestion(
            id = "py_f_52",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which block in a `try ... except ... else ... finally` statement ALWAYS executes whether an exception occurs or not?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`finally`"),
                QuestionOption("b", "`else`"),
                QuestionOption("c", "`except`"),
                QuestionOption("d", "None of them")
            ),
            correctOptionId = "a",
            explanation = "The `finally` block runs unconditionally when leaving the `try` statement, whereas `else` runs only if no exception was raised."
        ),
        QuizQuestion(
            id = "py_f_53",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When does the `else` block of a `try ... except ... else` statement execute?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Only when an exception is caught by `except`."),
                QuestionOption("b", "Only when the `try` block completes without raising any exception."),
                QuestionOption("c", "Always, right after `finally`."),
                QuestionOption("d", "When an unhandled exception occurs.")
            ),
            correctOptionId = "b",
            explanation = "The `else` clause on a `try` statement runs only if the `try` suite did not raise an exception."
        ),
        QuizQuestion(
            id = "py_f_54",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which built-in exception is raised when accessing a non-existent attribute on an object, such as `(42).append(1)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`NameError`"),
                QuestionOption("b", "`KeyError`"),
                QuestionOption("c", "`AttributeError`"),
                QuestionOption("d", "`IndexError`")
            ),
            correctOptionId = "c",
            explanation = "Attempting to access or call an attribute or method that does not exist on an object's type raises `AttributeError`."
        ),
        QuizQuestion(
            id = "py_f_55",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which built-in exception is raised when referencing a variable name that has not been defined in any accessible scope?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`TypeError`"),
                QuestionOption("b", "`KeyError`"),
                QuestionOption("c", "`ValueError`"),
                QuestionOption("d", "`NameError`")
            ),
            correctOptionId = "d",
            explanation = "Looking up an unbound identifier raises `NameError`."
        ),
        QuizQuestion(
            id = "py_f_56",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `f'{42:05d}'`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'00042'"),
                QuestionOption("b", "'42000'"),
                QuestionOption("c", "'   42'"),
                QuestionOption("d", "'42.00000'")
            ),
            correctOptionId = "a",
            explanation = "The format specifier `05d` pads the integer with leading zeros to a minimum width of 5 characters."
        ),
        QuizQuestion(
            id = "py_f_57",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Python 3.8+, what does `x = 7; f'{x=}'` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'7'"),
                QuestionOption("b", "'x=7'"),
                QuestionOption("c", "'{x=7}'"),
                QuestionOption("d", "Raises SyntaxError")
            ),
            correctOptionId = "b",
            explanation = "Adding `=` after an expression in an f-string (`f'{x=}'`) outputs both the expression text and its formatted value (`'x=7'`)."
        ),
        QuizQuestion(
            id = "py_f_58",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary purpose of a raw string literal like `r'C:\\new\\test'`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It encodes the string as UTF-16 bytes."),
                QuestionOption("b", "It makes the string mutable."),
                QuestionOption("c", "Backslashes are treated as literal characters rather than escape sequences like `\\n` or `\\t`."),
                QuestionOption("d", "It strips whitespace automatically.")
            ),
            correctOptionId = "c",
            explanation = "Raw string literals (`r'...'`) disable standard backslash escape processing, which is useful for regexes and Windows paths."
        )
    )

    private fun foundationBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "py_f_59",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `'hello'` and `b'hello'` in Python 3?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`'hello'` only supports ASCII characters."),
                QuestionOption("b", "They are identical in Python 3."),
                QuestionOption("c", "`b'hello'` is a mutable bytearray."),
                QuestionOption("d", "`'hello'` is a Unicode text `str`, whereas `b'hello'` is an immutable sequence of raw 8-bit integers (`bytes`).")
            ),
            correctOptionId = "d",
            explanation = "`str` stores Unicode code points, while `bytes` stores raw byte values (`0..255`)."
        ),
        QuizQuestion(
            id = "py_f_60",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How do you convert the string `'café'` into UTF-8 `bytes` and back to a `str`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`'café'.encode('utf-8')` and `raw_bytes.decode('utf-8')`"),
                QuestionOption("b", "`bytes('café')` and `str(raw_bytes)`"),
                QuestionOption("c", "`'café'.decode('utf-8')` and `raw_bytes.encode('utf-8')`"),
                QuestionOption("d", "`ord('café')` and `chr(raw_bytes)`")
            ),
            correctOptionId = "a",
            explanation = "Text `str` is encoded to `bytes` via `.encode(encoding)`, and `bytes` are decoded back to `str` via `.decode(encoding)`."
        ),
        QuizQuestion(
            id = "py_f_61",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When opening a file with `open('data.txt', mode)`, which mode truncates an existing file or creates a new file for writing?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`'r'`"),
                QuestionOption("b", "`'w'`"),
                QuestionOption("c", "`'a'`"),
                QuestionOption("d", "`'x'`")
            ),
            correctOptionId = "b",
            explanation = "Mode `'w'` opens a file for writing and truncates it if it already exists (`'a'` appends, `'x'` fails if the file exists)."
        ),
        QuizQuestion(
            id = "py_f_62",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which `open()` mode creates a new file for writing and raises `FileExistsError` if the file already exists?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`'a'`"),
                QuestionOption("b", "`'w+'`"),
                QuestionOption("c", "`'x'`"),
                QuestionOption("d", "`'r+'`")
            ),
            correctOptionId = "c",
            explanation = "Exclusive creation mode `'x'` guarantees that an existing file is not accidentally overwritten."
        ),
        QuizQuestion(
            id = "py_f_63",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the main advantage of reading a file with `with open('log.txt') as f:` instead of calling `f = open('log.txt')` without a `with` block?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It automatically parses the file as JSON."),
                QuestionOption("b", "It loads the entire file into GPU memory."),
                QuestionOption("c", "It prevents `FileNotFoundError` from being raised."),
                QuestionOption("d", "The context manager guarantees `f.close()` is called automatically when leaving the `with` block, even if an exception occurs.")
            ),
            correctOptionId = "d",
            explanation = "The `with` statement invokes the file object's `__exit__` method on block exit, ensuring deterministic descriptor cleanup."
        ),
        QuizQuestion(
            id = "py_f_64",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In `pathlib`, if `p = Path('/var/log')`, what does `p / 'app.log'` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A `Path` object representing `'/var/log/app.log'`."),
                QuestionOption("b", "A float division error (`TypeError`)."),
                QuestionOption("c", "A string `'/var/log/app.log'`."),
                QuestionOption("d", "A list `['/var/log', 'app.log']`.")
            ),
            correctOptionId = "a",
            explanation = "`pathlib.Path` overloads the `/` operator (`__truediv__`) to join path segments cleanly across operating systems."
        ),
        QuizQuestion(
            id = "py_f_65",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `from pathlib import Path; p = Path('/home/user/report.final.pdf')`, what do `p.name`, `p.stem`, and `p.suffix` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`'report'`, `'final'`, and `'pdf'`"),
                QuestionOption("b", "`'report.final.pdf'`, `'report.final'`, and `'.pdf'`"),
                QuestionOption("c", "`'/home/user'`, `'report.final'`, and `'.pdf'`"),
                QuestionOption("d", "`'report.final.pdf'`, `'report'`, and `'.final.pdf'`")
            ),
            correctOptionId = "b",
            explanation = "`p.name` is the full filename, `p.suffix` is the final extension (`'.pdf'`), and `p.stem` is `p.name` without the final suffix."
        ),
        QuizQuestion(
            id = "py_f_66",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `math.floor(-3.2)` and `int(-3.2)` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Both return `-4`."),
                QuestionOption("b", "Both return `-3`."),
                QuestionOption("c", "`math.floor(-3.2)` returns `-4` (towards negative infinity), whereas `int(-3.2)` truncates towards zero and returns `-3`."),
                QuestionOption("d", "`math.floor(-3.2)` returns `-3` and `int(-3.2)` returns `-4`.")
            ),
            correctOptionId = "c",
            explanation = "`math.floor(x)` returns the largest integer `<= x` (`-4`), while `int(x)` truncates the fractional part toward zero (`-3`)."
        ),
        QuizQuestion(
            id = "py_f_67",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which built-in type is an immutable version of a `set` that can be used as a dictionary key?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`immutable_set`"),
                QuestionOption("b", "`tuple`"),
                QuestionOption("c", "`bytes`"),
                QuestionOption("d", "`frozenset`")
            ),
            correctOptionId = "d",
            explanation = "`frozenset` is hashable and immutable, allowing sets of items to be used as `dict` keys or elements of another `set`."
        ),
        QuizQuestion(
            id = "py_f_68",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why does `{[1, 2]: 'value'}` raise a `TypeError: unhashable type: 'list'`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Dictionary keys must be hashable (immutable value identity), and `list` objects are mutable and unhashable."),
                QuestionOption("b", "Dictionaries cannot have collection keys of any kind, including tuples."),
                QuestionOption("c", "The key must be a string."),
                QuestionOption("d", "Lists with fewer than 3 elements cannot be keys.")
            ),
            correctOptionId = "a",
            explanation = "Mutable containers like `list`, `dict`, and `set` define `__hash__ = None` because mutating a key would corrupt hash table lookups."
        ),
        QuizQuestion(
            id = "py_f_69",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `sum([10, 20, 30], start=100)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "60"),
                QuestionOption("b", "160"),
                QuestionOption("c", "100"),
                QuestionOption("d", "[100, 10, 20, 30]")
            ),
            correctOptionId = "b",
            explanation = "`sum(iterable, start)` adds the elements of the iterable to `start` (`100 + 10 + 20 + 30 = 160`)."
        ),
        QuizQuestion(
            id = "py_f_70",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `min(['pear', 'fig', 'apple', 'banana'], key=len)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'pear'"),
                QuestionOption("b", "'apple'"),
                QuestionOption("c", "'fig'"),
                QuestionOption("d", "3")
            ),
            correctOptionId = "c",
            explanation = "With `key=len`, `min()` compares strings by their length and returns the element with the smallest length (`'fig'`, length 3)."
        ),
        QuizQuestion(
            id = "py_f_71",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `list(reversed([10, 20, 30]))`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[10, 20, 30]"),
                QuestionOption("b", "None"),
                QuestionOption("c", "(30, 20, 10)"),
                QuestionOption("d", "[30, 20, 10]")
            ),
            correctOptionId = "d",
            explanation = "`reversed(seq)` returns a reverse iterator without mutating the original list; wrapping it in `list()` produces `[30, 20, 10]`."
        ),
        QuizQuestion(
            id = "py_f_72",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `list(map(str.upper, ['py', 'sql']))` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['PY', 'SQL']"),
                QuestionOption("b", "['py', 'sql']"),
                QuestionOption("c", "'PYSQL'"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "a",
            explanation = "`map(func, iterable)` applies `str.upper` to each element lazily, and `list()` materializes `['PY', 'SQL']`."
        ),
        QuizQuestion(
            id = "py_f_73",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `list(filter(None, [0, 1, '', 'ok', None, [5]]))` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[0, '', None]"),
                QuestionOption("b", "[1, 'ok', [5]]"),
                QuestionOption("c", "[True, True, True]"),
                QuestionOption("d", "[0, 1, '', 'ok', [5]]")
            ),
            correctOptionId = "b",
            explanation = "When the first argument to `filter()` is `None`, it keeps all elements that are truthy (`1`, `'ok'`, `[5]`)."
        ),
        QuizQuestion(
            id = "py_f_74",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the value of `__name__` when a Python file is executed directly as the main script (`python app.py`)?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'app.py'"),
                QuestionOption("b", "'app'"),
                QuestionOption("c", "'__main__'"),
                QuestionOption("d", "None")
            ),
            correctOptionId = "c",
            explanation = "Python sets a module's `__name__` global to `'__main__'` when run directly as the entry-point script."
        ),
        QuizQuestion(
            id = "py_f_75",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the `pass` statement do in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It ignores exceptions inside a block."),
                QuestionOption("b", "It skips the rest of the current loop iteration like `continue`."),
                QuestionOption("c", "It exits the current function and returns `None`."),
                QuestionOption("d", "It is a null operation (no-op) used as a syntactic placeholder where a statement block is required.")
            ),
            correctOptionId = "d",
            explanation = "`pass` performs no action at runtime and satisfies Python's grammar for empty functions, classes, or branches."
        ),
        QuizQuestion(
            id = "py_f_76",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Inside a `while` loop, how does `continue` differ from `break`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`continue` skips the remainder of the current iteration and re-evaluates the loop condition; `break` exits the loop immediately."),
                QuestionOption("b", "`continue` exits the loop; `break` pauses execution."),
                QuestionOption("c", "They behave identically in `while` loops."),
                QuestionOption("d", "`continue` restarts the loop from the very first iteration.")
            ),
            correctOptionId = "a",
            explanation = "`continue` jumps to the next iteration check, while `break` terminates the enclosing loop completely."
        ),
        QuizQuestion(
            id = "py_f_77",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'hello world'.title()` return, and how does it differ from `'hello world'.capitalize()`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`.title()` returns `'HELLO WORLD'`, whereas `.capitalize()` returns `'Hello World'`."),
                QuestionOption("b", "`.title()` returns `'Hello World'`, whereas `.capitalize()` returns `'Hello world'`."),
                QuestionOption("c", "Both return `'Hello World'`."),
                QuestionOption("d", "`.title()` only capitalizes the last word.")
            ),
            correctOptionId = "b",
            explanation = "`str.title()` uppercases the first letter of each word, while `str.capitalize()` uppercases only the first character of the whole string."
        ),
        QuizQuestion(
            id = "py_f_78",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'a,b,c,d'.split(',', maxsplit=2)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['a,b', 'c', 'd']"),
                QuestionOption("b", "['a', 'b']"),
                QuestionOption("c", "['a', 'b', 'c,d']"),
                QuestionOption("d", "['a', 'b', 'c', 'd']")
            ),
            correctOptionId = "c",
            explanation = "`maxsplit=2` performs at most 2 splits from the left, producing 3 elements with the unsplit remainder `'c,d'` at the end."
        ),
        QuizQuestion(
            id = "py_f_79",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'line1\\nline2\\n'.splitlines()` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'line1 line2'"),
                QuestionOption("b", "['line1', 'line2', '']"),
                QuestionOption("c", "['line1\\n', 'line2\\n']"),
                QuestionOption("d", "['line1', 'line2']")
            ),
            correctOptionId = "d",
            explanation = "`str.splitlines()` splits on line boundaries and does not include a trailing empty string for a final newline."
        ),
        QuizQuestion(
            id = "py_f_80",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `d = {'a': 1, 'b': 2}`, what happens if you execute `d.pop('z', 99)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `99` without raising an error."),
                QuestionOption("b", "It raises a `KeyError`."),
                QuestionOption("c", "It inserts `'z': 99` into `d`."),
                QuestionOption("d", "It returns `None`.")
            ),
            correctOptionId = "a",
            explanation = "Providing a second `default` argument to `dict.pop(key, default)` returns `default` when `key` is absent instead of raising `KeyError`."
        ),
        QuizQuestion(
            id = "py_f_81",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `pow(2, 10, 1000)` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1024"),
                QuestionOption("b", "24"),
                QuestionOption("c", "100"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "b",
            explanation = "Three-argument `pow(base, exp, mod)` computes `(base ** exp) % mod` efficiently: `2**10 % 1000 = 1024 % 1000 = 24`."
        ),
        QuizQuestion(
            id = "py_f_82",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `bin(13)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1101"),
                QuestionOption("b", "'1101'"),
                QuestionOption("c", "'0b1101'"),
                QuestionOption("d", "'0x0d'")
            ),
            correctOptionId = "c",
            explanation = "`bin(n)` returns the binary representation of an integer prefixed with `'0b'`."
        ),
        QuizQuestion(
            id = "py_f_83",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `hex(255)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "255"),
                QuestionOption("b", "'ff'"),
                QuestionOption("c", "'0xFF'"),
                QuestionOption("d", "'0xff'")
            ),
            correctOptionId = "d",
            explanation = "`hex(n)` returns the lowercase hexadecimal string representation prefixed with `'0x'`."
        ),
        QuizQuestion(
            id = "py_f_84",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `x = [1, 2]; y = [1, 2]`, what is `(x == y, x is y)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "(True, False)"),
                QuestionOption("b", "(True, True)"),
                QuestionOption("c", "(False, False)"),
                QuestionOption("d", "(False, True)")
            ),
            correctOptionId = "a",
            explanation = "Two separately constructed list literals have equal contents (`x == y` is `True`) but are distinct objects in memory (`x is y` is `False`)."
        ),
        QuizQuestion(
            id = "py_f_85",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the recommended way to test whether a variable `val` is `None` according to PEP 8?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`val == None`"),
                QuestionOption("b", "`val is None`"),
                QuestionOption("c", "`type(val) == None`"),
                QuestionOption("d", "`not val`")
            ),
            correctOptionId = "b",
            explanation = "`None` is a singleton in Python, and custom classes can override `__eq__`, so `val is None` (or `is not None`) is fast and reliable."
        ),
        QuizQuestion(
            id = "py_f_86",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `del items[1:3]` do when `items = [10, 20, 30, 40]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Deletes the variable `items`."),
                QuestionOption("b", "Returns `[20, 30]` and leaves `items` unchanged."),
                QuestionOption("c", "Mutates `items` in place to `[10, 40]`."),
                QuestionOption("d", "Raises a `TypeError`.")
            ),
            correctOptionId = "c",
            explanation = "`del list[start:stop]` removes the specified slice from the list in place."
        ),
        QuizQuestion(
            id = "py_f_87",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the value of `result` after running the code?",
            codeSnippet = "vals = [1, 2, 3]\nresult = vals * 2",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises TypeError"),
                QuestionOption("b", "[2, 4, 6]"),
                QuestionOption("c", "[[1, 2, 3], [1, 2, 3]]"),
                QuestionOption("d", "[1, 2, 3, 1, 2, 3]")
            ),
            correctOptionId = "d",
            explanation = "Multiplying a sequence (`list`, `tuple`, `str`) by an integer `n` concatenates `n` shallow copies of the sequence."
        ),
        QuizQuestion(
            id = "py_f_88",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'42'.zfill(5)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'00042'"),
                QuestionOption("b", "'42000'"),
                QuestionOption("c", "'   42'"),
                QuestionOption("d", "'55542'")
            ),
            correctOptionId = "a",
            explanation = "`str.zfill(width)` pads a numeric string on the left with ASCII `'0'` digits to reach the specified width."
        ),
        QuizQuestion(
            id = "py_f_89",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'-42'.zfill(5)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'00-42'"),
                QuestionOption("b", "'-0042'"),
                QuestionOption("c", "'-4200'"),
                QuestionOption("d", "'000-42'")
            ),
            correctOptionId = "b",
            explanation = "`str.zfill(width)` is sign-aware: it places the leading zeros after a leading `'+'` or `'-'` sign."
        ),
        QuizQuestion(
            id = "py_f_90",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `callable(len)` and `callable(42)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`True` and `True`"),
                QuestionOption("b", "`False` and `False`"),
                QuestionOption("c", "`True` and `False`"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "c",
            explanation = "`callable(obj)` returns `True` if `obj` can be called like a function (`len` is a built-in function; `42` is an `int`)."
        ),
        QuizQuestion(
            id = "py_f_91",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `getattr(obj, ' missing ', 'fallback')` do when `' missing '` is not an attribute of `obj`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Returns `None`."),
                QuestionOption("b", "Raises `AttributeError`."),
                QuestionOption("c", "Sets the attribute on `obj` to `'fallback'`."),
                QuestionOption("d", "Returns `'fallback'` instead of raising `AttributeError`.")
            ),
            correctOptionId = "d",
            explanation = "Three-argument `getattr(object, name, default)` returns `default` when the named attribute does not exist."
        ),
        QuizQuestion(
            id = "py_f_92",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the output of `print('a', 'b', 'c', sep=':', end='!')`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "a:b:c!"),
                QuestionOption("b", "a b c!"),
                QuestionOption("c", "a:b:c:\\n"),
                QuestionOption("d", "a!b!c!")
            ),
            correctOptionId = "a",
            explanation = "`sep=':'` joins positional arguments with `':'`, and `end='!'` replaces the trailing newline with `'!'`."
        ),
        QuizQuestion(
            id = "py_f_93",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If `s1 = {1, 2}` and `s2 = {1, 2, 3}`, what does `s1 < s2` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "False"),
                QuestionOption("b", "True (because `s1` is a proper subset of `s2`)."),
                QuestionOption("c", "Raises TypeError"),
                QuestionOption("d", "{3}")
            ),
            correctOptionId = "b",
            explanation = "On sets, `<` tests for proper subset (`s1 <= s2 and s1 != s2`)."
        ),
        QuizQuestion(
            id = "py_f_94",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `dict.fromkeys(['a', 'b', 'c'], 0)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "{0: ['a', 'b', 'c']}"),
                QuestionOption("b", "[('a', 0), ('b', 0), ('c', 0)]"),
                QuestionOption("c", "{'a': 0, 'b': 0, 'c': 0}"),
                QuestionOption("d", "Raises ValueError")
            ),
            correctOptionId = "c",
            explanation = "`dict.fromkeys(iterable, value)` creates a new dictionary with keys from `iterable` all mapped to `value`."
        ),
        QuizQuestion(
            id = "py_f_95",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when you iterate over a dictionary directly with `for x in {'k1': 10, 'k2': 20}:`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises a `TypeError`."),
                QuestionOption("b", "`x` receives `(key, value)` tuples."),
                QuestionOption("c", "`x` receives each value (`10`, then `20`)."),
                QuestionOption("d", "`x` receives each key (`'k1'`, then `'k2'`) in insertion order.")
            ),
            correctOptionId = "d",
            explanation = "Iterating directly over a `dict` yields its keys in insertion order (guaranteed since Python 3.7)."
        ),
        QuizQuestion(
            id = "py_f_96",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the output of `bool('False')` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "True"),
                QuestionOption("b", "False"),
                QuestionOption("c", "None"),
                QuestionOption("d", "Raises ValueError")
            ),
            correctOptionId = "a",
            explanation = "Any non-empty string has length > 0 and is therefore truthy (`True`), regardless of the characters it contains."
        ),
        QuizQuestion(
            id = "py_f_97",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `10 < 20 < 15` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "True"),
                QuestionOption("b", "False"),
                QuestionOption("c", "Raises TypeError"),
                QuestionOption("d", "15")
            ),
            correctOptionId = "b",
            explanation = "Python chains comparisons: `10 < 20 < 15` is equivalent to `(10 < 20) and (20 < 15)`, which evaluates to `False`."
        ),
        QuizQuestion(
            id = "py_f_98",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'abc'.isalpha()` and `'abc1'.isalpha()` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`False` and `False`"),
                QuestionOption("b", "`True` and `True`"),
                QuestionOption("c", "`True` and `False`"),
                QuestionOption("d", "`False` and `True`")
            ),
            correctOptionId = "c",
            explanation = "`str.isalpha()` returns `True` only when the string is non-empty and all characters are alphabetic."
        ),
        QuizQuestion(
            id = "py_f_99",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `tuple([1, 2, 3])` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises TypeError"),
                QuestionOption("b", "[1, 2, 3]"),
                QuestionOption("c", "{1, 2, 3}"),
                QuestionOption("d", "(1, 2, 3)")
            ),
            correctOptionId = "d",
            explanation = "`tuple(iterable)` constructs a tuple containing the elements of the given iterable in order."
        ),
        QuizQuestion(
            id = "py_f_100",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `'hello'.replace('l', 'L', 1)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'heLlo'"),
                QuestionOption("b", "'heLLo'"),
                QuestionOption("c", "'heLo'"),
                QuestionOption("d", "'hello'")
            ),
            correctOptionId = "a",
            explanation = "The third argument `count=1` limits `str.replace(old, new, count)` to replacing only the first occurrence."
        )
    )

    private fun appliedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "py_a_16",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the value of `result` after running this comprehension?",
            codeSnippet = "matrix = [[1, 2], [3, 4], [5, 6]]\nresult = [x for row in matrix for x in row if x % 2 == 1]",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[1, 3, 5]"),
                QuestionOption("b", "[[1], [3], [5]]"),
                QuestionOption("c", "[1, 2, 3, 4, 5, 6]"),
                QuestionOption("d", "Raises NameError")
            ),
            correctOptionId = "a",
            explanation = "In nested list comprehensions, clauses are read left-to-right in the same order as nested `for` loops: `for row in matrix` then `for x in row`."
        ),
        QuizQuestion(
            id = "py_a_17",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between `[x * x for x in range(1000)]` and `(x * x for x in range(1000))`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The parentheses create a `tuple` of 1,000 ints."),
                QuestionOption("b", "The brackets build a `list` in memory immediately, whereas the parentheses create a lazy generator object that computes values on demand."),
                QuestionOption("c", "Both return a `list`."),
                QuestionOption("d", "The generator expression can be indexed with `[0]`.")
            ),
            correctOptionId = "b",
            explanation = "`(expr for ...)` is a generator expression yielding items lazily one at a time with O(1) memory overhead."
        ),
        QuizQuestion(
            id = "py_a_18",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does this dictionary merge expression produce in Python 3.9+?",
            codeSnippet = "defaults = {'host': 'localhost', 'port': 5432}\noverrides = {'port': 6432, 'ssl': True}\nconfig = defaults | overrides",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises TypeError"),
                QuestionOption("b", "{'host': 'localhost', 'port': 5432, 'ssl': True}"),
                QuestionOption("c", "{'host': 'localhost', 'port': 6432, 'ssl': True}"),
                QuestionOption("d", "{'port': 6432}")
            ),
            correctOptionId = "c",
            explanation = "The union operator `|` on dictionaries creates a new `dict` where right-hand keys overwrite matching left-hand keys."
        ),
        QuizQuestion(
            id = "py_a_19",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `collections.Counter` snippet?",
            codeSnippet = "from collections import Counter\nc = Counter('abracadabra')\nprint(c.most_common(2))",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[('a', 5), ('r', 2), ('b', 2)]"),
                QuestionOption("b", "{'a': 5, 'b': 2}"),
                QuestionOption("c", "['a', 'b']"),
                QuestionOption("d", "[('a', 5), ('b', 2)]")
            ),
            correctOptionId = "d",
            explanation = "`Counter.most_common(n)` returns a list of the `n` most frequent `(element, count)` tuples in descending count order."
        ),
        QuizQuestion(
            id = "py_a_20",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When subtracting two `Counter` objects with `Counter(a=3, b=1) - Counter(a=1, b=2)`, what is the result?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Counter({'a': 2})"),
                QuestionOption("b", "Counter({'a': 2, 'b': -1})"),
                QuestionOption("c", "{'a': 2, 'b': 0}"),
                QuestionOption("d", "Raises ValueError")
            ),
            correctOptionId = "a",
            explanation = "The `-` operator on `Counter` subtracts counts but keeps only strictly positive counts (unlike `.subtract()`, which keeps zero/negative counts)."
        ),
        QuizQuestion(
            id = "py_a_21",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when accessing a missing key on `d = defaultdict(list)` via `d['users'].append('alice')`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises a `KeyError`."),
                QuestionOption("b", "`defaultdict` calls `list()` to insert `'users': []` and then appends `'alice'`."),
                QuestionOption("c", "It appends `'alice'` to every list in `d`."),
                QuestionOption("d", "It returns `None` without mutating `d`.")
            ),
            correctOptionId = "b",
            explanation = "When a key is missing in `defaultdict`, `__missing__` invokes `default_factory()` (`list`), stores the empty list under `'users'`, and returns it."
        ),
        QuizQuestion(
            id = "py_a_22",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `collections.deque` preferred over `list` for a FIFO queue using `.append(x)` and `.popleft()`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`list` does not support removing the first element."),
                QuestionOption("b", "`deque` uses less memory than `tuple`."),
                QuestionOption("c", "`deque.popleft()` is O(1), whereas `list.pop(0)` is O(n) because all remaining elements must shift in memory."),
                QuestionOption("d", "`deque` automatically sorts elements.")
            ),
            correctOptionId = "c",
            explanation = "`deque` is implemented as a doubly linked list of fixed-size blocks, providing O(1) appends and pops at both ends."
        ),
        QuizQuestion(
            id = "py_a_23",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when a bounded `deque([1, 2, 3], maxlen=3)` has `.append(4)` called on it?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The rightmost element `3` is overwritten with `4`, leaving `[1, 2, 4]`."),
                QuestionOption("b", "It raises an `IndexError`."),
                QuestionOption("c", "The call is ignored and `deque` stays `[1, 2, 3]`."),
                QuestionOption("d", "The leftmost element `1` is automatically discarded, leaving `deque([2, 3, 4], maxlen=3)`.")
            ),
            correctOptionId = "d",
            explanation = "When a `deque` with `maxlen` is full, appending to one end automatically drops the oldest element from the opposite end."
        ),
        QuizQuestion(
            id = "py_a_24",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by this `nonlocal` scope snippet?",
            codeSnippet = "def make_counter(start=0):\n    count = start\n    def step():\n        nonlocal count\n        count += 1\n        return count\n    return step\n\nc = make_counter(10)\nprint(c(), c())",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "11 12"),
                QuestionOption("b", "11 11"),
                QuestionOption("c", "10 11"),
                QuestionOption("d", "Raises UnboundLocalError")
            ),
            correctOptionId = "a",
            explanation = "`nonlocal count` binds `count` to the enclosing `make_counter` frame's cell variable, allowing `step()` to mutate and persist it across calls."
        ),
        QuizQuestion(
            id = "py_a_25",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does this function raise `UnboundLocalError` when called?",
            codeSnippet = "total = 10\ndef add_five():\n    total += 5\n    return total",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because integers cannot use `+=` inside functions."),
                QuestionOption("b", "Because `total += 5` assigns to `total`, making `total` a local variable throughout `add_five` before it has been assigned a value."),
                QuestionOption("c", "Because `total` must be declared `nonlocal` at module level."),
                QuestionOption("d", "Because `return` cannot return a global variable.")
            ),
            correctOptionId = "b",
            explanation = "In Python, any assignment to a name inside a function scope marks that name as local at compile time unless declared `global` or `nonlocal`."
        ),
        QuizQuestion(
            id = "py_a_26",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the role of `@functools.wraps(func)` when writing a custom decorator?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It makes the decorated function thread-safe."),
                QuestionOption("b", "It memoizes the function's return values."),
                QuestionOption("c", "It copies metadata such as `__name__`, `__doc__`, `__annotations__`, and `__wrapped__` from `func` onto the wrapper function."),
                QuestionOption("d", "It converts the function into a `@staticmethod`.")
            ),
            correctOptionId = "c",
            explanation = "Without `@wraps(func)`, the decorated function would expose the inner wrapper's `__name__` and docstring instead of the original function's metadata."
        ),
        QuizQuestion(
            id = "py_a_27",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What requirement must arguments satisfy when calling a function decorated with `@functools.lru_cache`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The function must be an `async def` coroutine."),
                QuestionOption("b", "All arguments must be integers or strings."),
                QuestionOption("c", "The function cannot accept keyword arguments."),
                QuestionOption("d", "All arguments must be hashable so they can be stored in the underlying cache dictionary.")
            ),
            correctOptionId = "d",
            explanation = "`lru_cache` keys its internal dictionary using the call arguments, so passing an unhashable argument like a `list` or `dict` raises `TypeError`."
        ),
        QuizQuestion(
            id = "py_a_28",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `functools.partial(int, base=2)('1010')` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "10"),
                QuestionOption("b", "'1010'"),
                QuestionOption("c", "2"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "a",
            explanation = "`partial(int, base=2)` creates a callable that pre-supplies `base=2`, so calling it with `'1010'` executes `int('1010', base=2) == 10`."
        ),
        QuizQuestion(
            id = "py_a_29",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `functools.reduce(lambda acc, x: acc * x, [2, 3, 4], 10)` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "24"),
                QuestionOption("b", "240"),
                QuestionOption("c", "90"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "b",
            explanation = "With initial value `10`, `reduce` computes `(((10 * 2) * 3) * 4) = 240`."
        ),
        QuizQuestion(
            id = "py_a_30",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `field(default_factory=list)` required for a default empty list in a `@dataclass`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because `default_factory` converts the list into a tuple."),
                QuestionOption("b", "Because `[]` is a syntax error inside a class body."),
                QuestionOption("c", "Python `@dataclass` forbids mutable default values like `tags: list = []` and raises `ValueError` to prevent all instances from sharing the same list."),
                QuestionOption("d", "Because `dataclass` only supports primitive types without `field`.")
            ),
            correctOptionId = "c",
            explanation = "`@dataclass` detects mutable defaults (`list`, `dict`, `set`) and requires `field(default_factory=...)` so each instance receives a fresh copy."
        ),
        QuizQuestion(
            id = "py_a_31",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when you try to assign `p.x = 99` on an instance of `@dataclass(frozen=True) class Point: x: int; y: int`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It mutates `p.x` to `99`."),
                QuestionOption("b", "It silently ignores the assignment."),
                QuestionOption("c", "It creates a new `Point` and rebinds `p`."),
                QuestionOption("d", "It raises `dataclasses.FrozenInstanceError` (a subclass of `AttributeError`).")
            ),
            correctOptionId = "d",
            explanation = "`frozen=True` generates `__setattr__` and `__delattr__` methods that raise `FrozenInstanceError` on any mutation attempt."
        ),
        QuizQuestion(
            id = "py_a_32",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by this Python 3.10+ `match` statement?",
            codeSnippet = "point = (0, 7)\nmatch point:\n    case (0, 0):\n        res = 'origin'\n    case (0, y) if y > 0:\n        res = f'pos-y:{y}'\n    case (0, y):\n        res = 'y-axis'\nprint(res)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "pos-y:7"),
                QuestionOption("b", "y-axis"),
                QuestionOption("c", "origin"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "a",
            explanation = "Structural pattern matching destructures `(0, 7)` against `(0, y)`, binds `y = 7`, evaluates the guard `y > 0` (`True`), and selects the first matching branch."
        ),
        QuizQuestion(
            id = "py_a_33",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Inside a `match` statement, what is the difference between `case 200:` and `case status:`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`case status:` compares the subject to the variable `status`."),
                QuestionOption("b", "`case 200:` matches the literal value `200`, whereas a bare name `case status:` is a capture pattern that matches ANY subject and binds it to `status`."),
                QuestionOption("c", "`case status:` raises a `NameError` if `status` is defined."),
                QuestionOption("d", "They both compare equality.")
            ),
            correctOptionId = "b",
            explanation = "In Python `match`/`case`, bare identifiers (except `_`) are capture patterns that always match and bind the variable; dotted names (`HttpStatus.OK`) are value patterns."
        ),
        QuizQuestion(
            id = "py_a_34",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do `@staticmethod` and `@classmethod` differ when invoked on a subclass `Sub` of `Base`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`@classmethod` cannot be inherited by subclasses."),
                QuestionOption("b", "`@staticmethod` receives `Base` as its first argument."),
                QuestionOption("c", "`@classmethod` receives `Sub` as its first argument (`cls`), whereas `@staticmethod` receives no implicit `self` or `cls` argument."),
                QuestionOption("d", "`@staticmethod` can only be called on an instance, not on the class.")
            ),
            correctOptionId = "c",
            explanation = "A `@classmethod` is bound to the class it is called on (`cls = Sub`), making it ideal for polymorphic factory methods; a `@staticmethod` is a plain function namespaced in the class."
        ),
        QuizQuestion(
            id = "py_a_35",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `itertools.islice` call?",
            codeSnippet = "from itertools import count, islice\nprint(list(islice(count(10, 5), 4)))",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Infinite loop"),
                QuestionOption("b", "[10, 11, 12, 13]"),
                QuestionOption("c", "[0, 5, 10, 15]"),
                QuestionOption("d", "[10, 15, 20, 25]")
            ),
            correctOptionId = "d",
            explanation = "`count(10, 5)` yields `10, 15, 20, 25, ...` lazily, and `islice(..., 4)` takes the first 4 items."
        ),
        QuizQuestion(
            id = "py_a_36",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why did `itertools.groupby` produce 3 groups for `'a'` in this code?",
            codeSnippet = "from itertools import groupby\ndata = ['a', 'a', 'b', 'a']\ngroups = [(k, list(g)) for k, g in groupby(data)]",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because `itertools.groupby` only groups consecutive matching elements; the input must be sorted by the key first to consolidate all `'a'` items."),
                QuestionOption("b", "Because `groupby` splits groups of size > 2."),
                QuestionOption("c", "Because `list(g)` mutates `data`."),
                QuestionOption("d", "Because `groupby` requires a `dict` input.")
            ),
            correctOptionId = "a",
            explanation = "Unlike SQL `GROUP BY`, `itertools.groupby` scans linearly and starts a new group whenever the key value changes between adjacent items."
        ),
        QuizQuestion(
            id = "py_a_37",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `list(itertools.chain.from_iterable([[1, 2], [3], [4, 5]]))` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[[1, 2], [3], [4, 5]]"),
                QuestionOption("b", "[1, 2, 3, 4, 5]"),
                QuestionOption("c", "[(1, 3, 4), (2, 5)]"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "b",
            explanation = "`chain.from_iterable` flattens one level of nested iterables lazily into a single sequence."
        ),
        QuizQuestion(
            id = "py_a_38",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many tuples are yielded by `itertools.permutations('ABC', 2)` vs `itertools.combinations('ABC', 2)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`9` permutations and `3` combinations."),
                QuestionOption("b", "`3` permutations and `6` combinations."),
                QuestionOption("c", "`6` permutations and `3` combinations."),
                QuestionOption("d", "`6` permutations and `6` combinations.")
            ),
            correctOptionId = "c",
            explanation = "Order matters in permutations (`3 * 2 = 6`: AB, AC, BA, BC, CA, CB) and does not matter in combinations (`3! / (2!1!) = 3`: AB, AC, BC)."
        ),
        QuizQuestion(
            id = "py_a_39",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `list(itertools.accumulate([1, 2, 3, 4]))` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[0, 1, 3, 6, 10]"),
                QuestionOption("b", "[10]"),
                QuestionOption("c", "[1, 2, 6, 24]"),
                QuestionOption("d", "[1, 3, 6, 10]")
            ),
            correctOptionId = "d",
            explanation = "By default, `itertools.accumulate` yields running sums (`1`, `1+2=3`, `3+3=6`, `6+4=10`)."
        ),
        QuizQuestion(
            id = "py_a_40",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a custom context manager class, if `__exit__(self, exc_type, exc_val, exc_tb)` returns `True` when an exception occurred inside the `with` block, what happens?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The exception is suppressed and execution continues normally after the `with` block."),
                QuestionOption("b", "The exception is re-raised immediately."),
                QuestionOption("c", "Python raises a `RuntimeError`."),
                QuestionOption("d", "The `with` block runs a second time.")
            ),
            correctOptionId = "a",
            explanation = "Returning a truthy value from `__exit__` instructs the Python runtime to swallow the exception; returning `False` or `None` propagates it."
        ),
        QuizQuestion(
            id = "py_a_41",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `@contextlib.contextmanager`, how must the generator function handle an exception raised inside the caller's `with` block if it wants to run cleanup code?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Place cleanup code after `return`."),
                QuestionOption("b", "Wrap the `yield` statement in a `try ... finally:` block because the exception is thrown into the generator at the `yield` point."),
                QuestionOption("c", "Use `yield from` instead of `yield`."),
                QuestionOption("d", "Exceptions cannot occur inside `@contextmanager` blocks.")
            ),
            correctOptionId = "b",
            explanation = "When an exception occurs in the `with` body, `@contextmanager` calls `gen.throw(...)` at the suspended `yield` expression, so `try ... finally` around `yield` guarantees cleanup."
        ),
        QuizQuestion(
            id = "py_a_42",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `with contextlib.suppress(FileNotFoundError): os.remove('missing.tmp')` do if `'missing.tmp'` does not exist?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Creates `'missing.tmp'` before deleting it."),
                QuestionOption("b", "Suppresses all exceptions including `KeyboardInterrupt`."),
                QuestionOption("c", "Catches and suppresses `FileNotFoundError` cleanly, while allowing any other exception type (such as `PermissionError`) to propagate."),
                QuestionOption("d", "Logs a warning and exits the program.")
            ),
            correctOptionId = "c",
            explanation = "`contextlib.suppress(*exceptions)` selectively suppresses only the specified exception types (and their subclasses)."
        ),
        QuizQuestion(
            id = "py_a_43",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between `copy.copy(nested)` and `copy.deepcopy(nested)` for `nested = [[1, 2], [3, 4]]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`copy.deepcopy` only works on dictionaries."),
                QuestionOption("b", "Both clone all inner lists recursively."),
                QuestionOption("c", "`copy.copy` returns the exact same outer list reference (`nested is copy.copy(nested)`)."),
                QuestionOption("d", "`copy.copy` duplicates only the outer list so inner lists are still shared; `copy.deepcopy` recursively clones both the outer list and all inner lists.")
            ),
            correctOptionId = "d",
            explanation = "A shallow copy constructs a new outer container populated with references to the same child objects; a deep copy recursively copies child objects."
        ),
        QuizQuestion(
            id = "py_a_44",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `import heapq; h = [5, 1, 4, 2]; heapq.heapify(h)`, what does `heapq.heappop(h)` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1"),
                QuestionOption("b", "5"),
                QuestionOption("c", "2"),
                QuestionOption("d", "4")
            ),
            correctOptionId = "a",
            explanation = "Python's `heapq` implements a min-heap, so `h[0]` is always the smallest item (`1`), which `heappop` removes and returns in O(log n) time."
        ),
        QuizQuestion(
            id = "py_a_45",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `import bisect; a = [10, 20, 20, 30]`, what is `(bisect.bisect_left(a, 20), bisect.bisect_right(a, 20))`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "(1, 2)"),
                QuestionOption("b", "(1, 3)"),
                QuestionOption("c", "(2, 3)"),
                QuestionOption("d", "(0, 3)")
            ),
            correctOptionId = "b",
            explanation = "`bisect_left` returns the insertion index before any existing `20`s (`1`), while `bisect_right` returns the insertion index after all existing `20`s (`3`)."
        ),
        QuizQuestion(
            id = "py_a_46",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python's `re` module, how do `re.match(pattern, text)` and `re.search(pattern, text)` differ?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`re.match` matches the entire string from start to end (`fullmatch`)."),
                QuestionOption("b", "`re.search` returns all matches as a list, whereas `re.match` returns a boolean."),
                QuestionOption("c", "`re.match` checks for a match only at the beginning of `text`, whereas `re.search` scans through `text` for the first location where `pattern` matches."),
                QuestionOption("d", "They are aliases for the same function.")
            ),
            correctOptionId = "c",
            explanation = "`re.match` is anchored at index 0 of the string, while `re.search` finds a match anywhere in the string."
        ),
        QuizQuestion(
            id = "py_a_47",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `re.findall(r'<.*?>', '<a><b>')` return compared to `re.findall(r'<.*>', '<a><b>')`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`['<>', '<>']` versus `['<a><b>']`."),
                QuestionOption("b", "`['<a><b>']` versus `['<a>', '<b>']`."),
                QuestionOption("c", "`['a', 'b']` for both."),
                QuestionOption("d", "`['<a>', '<b>']` (non-greedy) versus `['<a><b>']` (greedy).")
            ),
            correctOptionId = "d",
            explanation = "`*?` is a non-greedy quantifier that matches the shortest possible substring before `'>'`, whereas `*` greedily matches through the last `'>'`."
        ),
        QuizQuestion(
            id = "py_a_48",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `re.findall(r'(\\d+)-(\\w+)', '10-py 20-sql')` return when the pattern contains multiple capture groups?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[('10', 'py'), ('20', 'sql')]"),
                QuestionOption("b", "['10-py', '20-sql']"),
                QuestionOption("c", "['10', '20']"),
                QuestionOption("d", "Raises re.error")
            ),
            correctOptionId = "a",
            explanation = "When a regex has 2 or more capturing groups `(...)`, `re.findall` returns a list of tuples containing the captured group strings."
        ),
        QuizQuestion(
            id = "py_a_49",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you write a non-capturing group in a Python regular expression so `re.findall` does not return only the group contents?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`(?P<name>...)`"),
                QuestionOption("b", "`(?:...)`"),
                QuestionOption("c", "`(?=...)`"),
                QuestionOption("d", "`(?!...)`")
            ),
            correctOptionId = "b",
            explanation = "`(?:...)` groups sub-expressions for quantifiers or alternation without creating a capture group."
        ),
        QuizQuestion(
            id = "py_a_50",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `json.dumps({1: 'one', 2: 'two'})` is called in Python's standard `json` module?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `'{1: \"one\", 2: \"two\"}'`. "),
                QuestionOption("b", "It raises a `TypeError` because JSON keys must already be `str`."),
                QuestionOption("c", "It returns `'{\"1\": \"one\", \"2\": \"two\"}'`, converting integer dictionary keys into JSON strings."),
                QuestionOption("d", "It drops all non-string keys.")
            ),
            correctOptionId = "c",
            explanation = "Standard JSON requires object keys to be strings; `json.dumps` converts primitive Python keys (`int`, `float`, `bool`, `None`) to strings by default."
        ),
        QuizQuestion(
            id = "py_a_51",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does `json.dumps({'items': {1, 2, 3}})` raise a `TypeError` by default?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`json.dumps` requires `ensure_ascii=False`."),
                QuestionOption("b", "Dictionaries cannot be nested in `json.dumps`."),
                QuestionOption("c", "Integers inside containers are not supported by `json`."),
                QuestionOption("d", "Python `set` objects are not JSON-serializable by default unless converted to a `list` or handled by a custom `default=` serializer.")
            ),
            correctOptionId = "d",
            explanation = "JSON has arrays (`list`/`tuple`) and objects (`dict`), but no native set type, so `set` raises `TypeError: Object of type set is not JSON serializable`."
        ),
        QuizQuestion(
            id = "py_a_52",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `users = [{'name': 'Bob', 'age': 30}, {'name': 'Ada', 'age': 30}, {'name': 'Cid', 'age': 25}]`, how can you sort by `age` ascending and then `name` ascending using Python's stable sort?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`sorted(users, key=lambda u: (u['age'], u['name']))`"),
                QuestionOption("b", "`sorted(users, key=lambda u: u['age'] and u['name'])`"),
                QuestionOption("c", "`users.sort('age', 'name')`"),
                QuestionOption("d", "`sorted(users, reverse=True)`")
            ),
            correctOptionId = "a",
            explanation = "Tuples are compared lexicographically element by element: `u['age']` is compared first, and ties are broken by `u['name']`."
        ),
        QuizQuestion(
            id = "py_a_53",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Because Python's Timsort (`list.sort` / `sorted`) is guaranteed to be **stable**, what happens when two items have equal keys?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "They are ordered randomly."),
                QuestionOption("b", "They retain their original relative order from the input sequence."),
                QuestionOption("c", "They are ordered by their memory address `id()`."),
                QuestionOption("d", "Duplicate keys are removed.")
            ),
            correctOptionId = "b",
            explanation = "Sort stability guarantees that records with equal sort keys appear in the same relative order after sorting as they did before sorting."
        ),
        QuizQuestion(
            id = "py_a_54",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between a **naive** and an **aware** `datetime` object in Python's `datetime` module?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Naive `datetime` objects only store dates without hours or minutes."),
                QuestionOption("b", "An aware `datetime` automatically updates itself every second."),
                QuestionOption("c", "An aware `datetime` has a non-null `tzinfo` with a defined UTC offset, whereas a naive `datetime` lacks timezone information (`tzinfo is None`)."),
                QuestionOption("d", "Aware `datetime` objects cannot be subtracted from one another.")
            ),
            correctOptionId = "c",
            explanation = "Timezone-aware `datetime` instances (e.g., `datetime.now(timezone.utc)`) carry explicit offset/timezone rules, preventing ambiguous local-time arithmetic."
        ),
        QuizQuestion(
            id = "py_a_55",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the type and value of `(datetime(2025, 5, 10) - datetime(2025, 5, 3)).days`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises TypeError"),
                QuestionOption("b", "A `float` equal to `7.0`."),
                QuestionOption("c", "A `datetime` object."),
                QuestionOption("d", "An `int` equal to `7` (from the resulting `datetime.timedelta` object).")
            ),
            correctOptionId = "d",
            explanation = "Subtracting one `datetime` (or `date`) from another produces a `datetime.timedelta` object whose `.days` attribute is the integer day difference."
        ),
        QuizQuestion(
            id = "py_a_56",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `enum`, how does `IntEnum` differ from a standard `Enum`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Members of `IntEnum` are also subclasses of `int` and can be compared directly to integers, whereas standard `Enum` members do not compare equal to raw integers."),
                QuestionOption("b", "`Enum` only allows string values."),
                QuestionOption("c", "`IntEnum` allows duplicate member names."),
                QuestionOption("d", "`Enum` members are mutable at runtime.")
            ),
            correctOptionId = "a",
            explanation = "`Color.RED == 1` is `False` for `class Color(Enum): RED = 1`, whereas `Status.OK == 200` is `True` for `class Status(IntEnum): OK = 200`."
        ),
        QuizQuestion(
            id = "py_a_57",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python 3.8+, what does the walrus operator `:=` do inside `if (n := len(items)) > 10:`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Compares `n` and `len(items)` for identity."),
                QuestionOption("b", "Assigns `len(items)` to `n` and returns that value so it is immediately compared against `10`."),
                QuestionOption("c", "Declares `n` as a type annotation."),
                QuestionOption("d", "Creates a lazy lambda returning `len(items)`.")
            ),
            correctOptionId = "b",
            explanation = "An assignment expression (`name := expr`) binds `name` in the current scope and evaluates to the assigned value inside the surrounding expression."
        ),
        QuizQuestion(
            id = "py_a_58",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If a comprehension uses the walrus operator `[last := x * 2 for x in [1, 2, 3]]`, in which scope is `last` bound?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Both `last` and `x` leak into the enclosing scope."),
                QuestionOption("b", "Both `last` and `x` are local to the comprehension."),
                QuestionOption("c", "`last` leaks into the enclosing scope outside the comprehension with value `6`, whereas the loop variable `x` remains local to the comprehension."),
                QuestionOption("d", "Using `:=` inside a comprehension is a `SyntaxError`.")
            ),
            correctOptionId = "c",
            explanation = "PEP 572 specifies that assignment expressions (`:=`) inside comprehensions bind the target name in the containing scope."
        )
    )

    private fun appliedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "py_a_59",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `raise RuntimeError('db failed') from err` do compared to a plain `raise RuntimeError('db failed')` inside an `except` block?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It catches `RuntimeError` automatically."),
                QuestionOption("b", "It suppresses `err` and hides the original traceback."),
                QuestionOption("c", "It re-raises `err` instead of `RuntimeError`."),
                QuestionOption("d", "It explicitly chains the original exception `err` as `__cause__` (`The above exception was the direct cause...`).")
            ),
            correctOptionId = "d",
            explanation = "`raise NewExc from orig_exc` sets `NewExc.__cause__ = orig_exc` for explicit exception chaining (while `raise NewExc from None` suppresses context chaining)."
        ),
        QuizQuestion(
            id = "py_a_60",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `raise ValueError('bad input') from None` accomplish inside an `except` block?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It disables automatic exception context display (`__suppress_context__ = True`) so only the new `ValueError` traceback is shown."),
                QuestionOption("b", "It raises `None` instead of `ValueError`."),
                QuestionOption("c", "It logs the original exception to `stderr` and exits."),
                QuestionOption("d", "It raises a `TypeError`.")
            ),
            correctOptionId = "a",
            explanation = "`raise ... from None` sets `__suppress_context__ = True`, hiding the intermediate exception traceback when transforming internal errors into clean API errors."
        ),
        QuizQuestion(
            id = "py_a_61",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `@property` on a method `def celsius(self):`, how do you also allow `obj.celsius = 25`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Pass `mutable=True` to `@property(mutable=True)`."),
                QuestionOption("b", "Define a setter method decorated with `@celsius.setter`."),
                QuestionOption("c", "Define `__getattr__` on the class."),
                QuestionOption("d", "Assign directly because `@property` attributes are writable by default.")
            ),
            correctOptionId = "b",
            explanation = "A `@property` without a corresponding `@<name>.setter` is read-only and raises `AttributeError` on assignment."
        ),
        QuizQuestion(
            id = "py_a_62",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed when a generator function contains `return 'done'`?",
            codeSnippet = "def gen():\n    yield 1\n    return 'done'\n\ng = gen()\nprint(next(g))\ntry:\n    next(g)\nexcept StopIteration as e:\n    print(e.value)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1 followed by StopIteration"),
                QuestionOption("b", "1 followed by None"),
                QuestionOption("c", "1 followed by done"),
                QuestionOption("d", "Raises SyntaxError")
            ),
            correctOptionId = "c",
            explanation = "In Python 3, `return expr` inside a generator raises `StopIteration(expr)`, storing the return value in the exception's `.value` attribute."
        ),
        QuizQuestion(
            id = "py_a_63",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `yield from sub_iterable` do inside a generator function?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Spawns a background thread to iterate `sub_iterable`."),
                QuestionOption("b", "Yields `sub_iterable` as a single list object."),
                QuestionOption("c", "Terminates the generator after one element."),
                QuestionOption("d", "Delegates iteration to `sub_iterable`, yielding each of its items directly to the caller (and forwarding `.send()` / `.throw()` if it is a sub-generator).")
            ),
            correctOptionId = "d",
            explanation = "`yield from` establishes a transparent two-way delegation channel between the outer caller and the sub-generator/iterable."
        ),
        QuizQuestion(
            id = "py_a_64",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `from collections import namedtuple; Point = namedtuple('Point', ['x', 'y'])`, how does `p._replace(x=99)` work on `p = Point(1, 2)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because namedtuples are immutable, `p._replace(x=99)` returns a new `Point(x=99, y=2)` without modifying `p`."),
                QuestionOption("b", "It mutates `p.x` to `99` in place."),
                QuestionOption("c", "It raises `AttributeError`."),
                QuestionOption("d", "It converts `p` into a dictionary.")
            ),
            correctOptionId = "a",
            explanation = "`namedtuple._replace(**kwargs)` returns a new tuple instance with the specified fields updated."
        ),
        QuizQuestion(
            id = "py_a_65",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `collections.ChainMap(local_cfg, default_cfg)`, how do lookups and writes (`cmap['k'] = v`) behave?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Writes update every dictionary in the `ChainMap`."),
                QuestionOption("b", "Lookups search `local_cfg` then `default_cfg`, whereas writes and deletions always mutate only the first mapping (`local_cfg`)."),
                QuestionOption("c", "Lookups search from the last dictionary to the first."),
                QuestionOption("d", "`ChainMap` copies all dictionaries into one new dictionary on creation.")
            ),
            correctOptionId = "b",
            explanation = "`ChainMap` keeps views over the underlying dicts: reads search mappings in order, while mutations affect only `maps[0]`."
        ),
        QuizQuestion(
            id = "py_a_66",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `operator.itemgetter` call?",
            codeSnippet = "from operator import itemgetter\nget_pair = itemgetter(2, 0)\nprint(get_pair(['alpha', 'beta', 'gamma']))",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'gamma'"),
                QuestionOption("b", "['gamma', 'alpha']"),
                QuestionOption("c", "('gamma', 'alpha')"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "c",
            explanation = "When `itemgetter` is given multiple indices, calling it returns a tuple of the elements at those indices."
        ),
        QuizQuestion(
            id = "py_a_67",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python `typing`, what is the difference between `Sequence[int]` and `list[int]` as a function parameter type hint?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "There is no difference in static type checkers."),
                QuestionOption("b", "`Sequence[int]` only accepts generators."),
                QuestionOption("c", "`list[int]` accepts tuples and sets."),
                QuestionOption("d", "`Sequence[int]` accepts any read-only sequence (such as `list[int]`, `tuple[int, ...]`, or `range`) and is covariant, whereas `list[int]` requires a mutable `list`.")
            ),
            correctOptionId = "d",
            explanation = "Typing parameters as abstract read-only collections like `Sequence[T]` or `Mapping[K, V]` follows Postel's law and enables covariance in `mypy`/`pyright`."
        ),
        QuizQuestion(
            id = "py_a_68",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python 3.8+ `typing.Protocol`, how does structural subtyping (duck typing) work?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A class satisfies a `Protocol` automatically if it implements the required methods/attributes with matching signatures, without needing to inherit from the `Protocol`."),
                QuestionOption("b", "The class must explicitly inherit from the `Protocol` class."),
                QuestionOption("c", "`Protocol` enforces method types at C compilation time."),
                QuestionOption("d", "`Protocol` can only contain `@staticmethod` definitions.")
            ),
            correctOptionId = "a",
            explanation = "`typing.Protocol` brings static structural subtyping to Python type checkers (and supports `isinstance` checks if decorated with `@runtime_checkable`)."
        ),
        QuizQuestion(
            id = "py_a_69",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `zip([1, 2, 3], ['a', 'b'], strict=True)` is iterated in Python 3.10+?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises `ValueError` before yielding the first item."),
                QuestionOption("b", "It yields `(1, 'a')` and `(2, 'b')`, and then raises `ValueError` because the iterables have unequal lengths."),
                QuestionOption("c", "It pads the shorter iterable with `None`."),
                QuestionOption("d", "It truncates silently to 2 items.")
            ),
            correctOptionId = "b",
            explanation = "Because `zip` is lazy, it yields pairs until one iterator finishes early, at which point `strict=True` raises `ValueError`."
        ),
        QuizQuestion(
            id = "py_a_70",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by this dictionary view code?",
            codeSnippet = "d = {'a': 1, 'b': 2}\nkeys_view = d.keys()\nd['c'] = 3\nprint(list(keys_view))",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises RuntimeError"),
                QuestionOption("b", "['a', 'b']"),
                QuestionOption("c", "['a', 'b', 'c']"),
                QuestionOption("d", "['c']")
            ),
            correctOptionId = "c",
            explanation = "`d.keys()`, `d.values()`, and `d.items()` return dynamic view objects that reflect subsequent mutations to the dictionary."
        ),
        QuizQuestion(
            id = "py_a_71",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does mutating a dictionary's keys while iterating over `for k in d:` raise `RuntimeError: dictionary changed size during iteration`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It only happens when deleting values equal to `None`."),
                QuestionOption("b", "Because dictionaries are immutable inside `for` loops."),
                QuestionOption("c", "Because `k` is a read-only reference."),
                QuestionOption("d", "Inserting or deleting keys can resize or reorder the underlying hash table, invalidating the iterator's internal position; iterating over `list(d)` avoids this.")
            ),
            correctOptionId = "d",
            explanation = "Python's dict iterator tracks table state and raises `RuntimeError` if keys are added or removed mid-iteration; `for k in list(d):` iterates over a snapshot."
        ),
        QuizQuestion(
            id = "py_a_72",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `string.Template('Hello, \$user! Cost: \$\$10').substitute(user='Ada')` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'Hello, Ada! Cost: \$10'"),
                QuestionOption("b", "'Hello, Ada! Cost: \$\$10'"),
                QuestionOption("c", "Raises KeyError"),
                QuestionOption("d", "'Hello, \$user! Cost: \$10'")
            ),
            correctOptionId = "a",
            explanation = "In `string.Template`, `\$identifier` is substituted from the mapping, and `\$\$` is an escape sequence for a literal `'\$'`."
        ),
        QuizQuestion(
            id = "py_a_73",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How does `Template.safe_substitute()` differ from `Template.substitute()` when a placeholder key is missing?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`safe_substitute()` replaces missing placeholders with `'None'`."),
                QuestionOption("b", "`safe_substitute()` leaves the missing `\$placeholder` intact in the output string instead of raising `KeyError`."),
                QuestionOption("c", "`safe_substitute()` HTML-escapes all values."),
                QuestionOption("d", "`safe_substitute()` raises `ValueError` instead of `KeyError`.")
            ),
            correctOptionId = "b",
            explanation = "`safe_substitute` never raises `KeyError` for missing keys, making it safer for user-supplied templates."
        ),
        QuizQuestion(
            id = "py_a_74",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `urllib.parse.urlencode({'q': 'python 3', 'page': 2})` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "{'q': 'python+3', 'page': '2'}"),
                QuestionOption("b", "'?q=python%203&page=2'"),
                QuestionOption("c", "'q=python+3&page=2'"),
                QuestionOption("d", "'q=python 3&page=2'")
            ),
            correctOptionId = "c",
            explanation = "`urlencode` percent-encodes key-value pairs into an `application/x-www-form-urlencoded` query string, encoding spaces as `'+'` by default."
        ),
        QuizQuestion(
            id = "py_a_75",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `csv.DictReader(f)`, what does each row yielded by the reader look like?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A JSON string."),
                QuestionOption("b", "A `list` of strings."),
                QuestionOption("c", "A `namedtuple` of converted ints and floats."),
                QuestionOption("d", "A `dict` mapping each column header name (from the first row by default) to the row's string value.")
            ),
            correctOptionId = "d",
            explanation = "`csv.DictReader` uses the first CSV line as `fieldnames` (unless specified) and yields an ordered `dict` for each subsequent row."
        ),
        QuizQuestion(
            id = "py_a_76",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why should `newline=''` be passed to `open('out.csv', 'w', newline='')` when using Python's `csv.writer`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because the `csv` module handles its own line endings (`\\r\\n`), and omitting `newline=''` on Windows can insert extra blank lines between rows."),
                QuestionOption("b", "Because `csv.writer` raises `ValueError` without `newline=''`."),
                QuestionOption("c", "Because `newline=''` strips all newlines inside quoted CSV fields."),
                QuestionOption("d", "Because it enables UTF-16 encoding.")
            ),
            correctOptionId = "a",
            explanation = "Universal newline translation in `open()` would translate `\\r\\n` written by `csv.writer` into `\\r\\r\\n` on Windows unless `newline=''` is set."
        ),
        QuizQuestion(
            id = "py_a_77",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `io.StringIO` provide in Python's standard library?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A binary socket wrapper."),
                QuestionOption("b", "An in-memory text stream that implements the file-like `TextIOBase` interface (`read`, `write`, `getvalue`)."),
                QuestionOption("c", "A C-level string interning pool."),
                QuestionOption("d", "A regular expression compiler.")
            ),
            correctOptionId = "b",
            explanation = "`io.StringIO` (for `str`) and `io.BytesIO` (for `bytes`) provide in-memory file-like streams ideal for testing or APIs expecting file objects."
        ),
        QuizQuestion(
            id = "py_a_78",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `any()` generator short-circuit test?",
            codeSnippet = "visited = []\ndef check(x):\n    visited.append(x)\n    return x > 2\n\nres = any(check(n) for n in [1, 3, 5, 7])\nprint(res, visited)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "True [3]"),
                QuestionOption("b", "True [1, 3, 5, 7]"),
                QuestionOption("c", "True [1, 3]"),
                QuestionOption("d", "False [1, 3]")
            ),
            correctOptionId = "c",
            explanation = "`any()` consumes the generator lazily and short-circuits as soon as `check(3)` returns `True`, never evaluating `5` or `7`."
        ),
        QuizQuestion(
            id = "py_a_79",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `class User: pass`, what happens when a class attribute `role = 'guest'` is read via `u.role` and then assigned via `u.role = 'admin'` on an instance `u = User()`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It deletes `User.role`."),
                QuestionOption("b", "It mutates `User.role` to `'admin'` for all instances."),
                QuestionOption("c", "It raises an `AttributeError` because `role` is a class attribute."),
                QuestionOption("d", "`u.role = 'admin'` creates an instance attribute in `u.__dict__` that shadows `User.role`, leaving `User.role` as `'guest'` for other instances.")
            ),
            correctOptionId = "d",
            explanation = "Attribute reads fall back to the class if not found in `instance.__dict__`, whereas `u.attr = val` writes to `u.__dict__` (unless `attr` is a data descriptor)."
        ),
        QuizQuestion(
            id = "py_a_80",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens instead if `User.roles = []` is a mutable class attribute and an instance calls `u.roles.append('admin')`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because `.append()` mutates the list in place without rebinding `u.roles`, the shared `User.roles` list is modified for all instances of `User`."),
                QuestionOption("b", "Python automatically copies `User.roles` into `u.__dict__`."),
                QuestionOption("c", "It raises a `TypeError`."),
                QuestionOption("d", "Only `u` sees `'admin'`.")
            ),
            correctOptionId = "a",
            explanation = "`u.roles` looks up the class list and `.append()` mutates that shared list object in place."
        ),
        QuizQuestion(
            id = "py_a_81",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `itertools.product([1, 2], ['a', 'b'])` compute?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`[(1, 'a'), (2, 'b')]`"),
                QuestionOption("b", "The Cartesian product: `[(1, 'a'), (1, 'b'), (2, 'a'), (2, 'b')]`."),
                QuestionOption("c", "`[1, 2, 'a', 'b']`"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "b",
            explanation = "`itertools.product(*iterables)` yields tuples representing the Cartesian product, equivalent to nested `for` loops."
        ),
        QuizQuestion(
            id = "py_a_82",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `itertools.zip_longest([1, 2, 3], ['a'], fillvalue='-')` return when converted to a list?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[(1, 'a'), (2, None), (3, None)]"),
                QuestionOption("b", "[(1, 'a')]"),
                QuestionOption("c", "[(1, 'a'), (2, '-'), (3, '-')]"),
                QuestionOption("d", "Raises ValueError")
            ),
            correctOptionId = "c",
            explanation = "`zip_longest` continues until the longest iterable is exhausted, filling missing positions from shorter iterables with `fillvalue`."
        ),
        QuizQuestion(
            id = "py_a_83",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python's `logging` module, why is `logger.info('User %s logged in from %s', user, ip)` preferred over `logger.info(f'User {user} logged in from {ip}')` in high-throughput code?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because f-strings cannot format integers."),
                QuestionOption("b", "Because `logger.info` raises a `TypeError` when passed an f-string."),
                QuestionOption("c", "Because `%s` encrypts sensitive fields automatically."),
                QuestionOption("d", "With `%` args, string interpolation is deferred and skipped entirely if the `INFO` log level is disabled, whereas an f-string is always evaluated before calling `logger.info`.")
            ),
            correctOptionId = "d",
            explanation = "Passing the template and arguments separately allows `logging` to avoid formatting overhead when the logger's effective level filters out the message."
        ),
        QuizQuestion(
            id = "py_a_84",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does ` secrets.token_hex(16)` from the `secrets` module return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A cryptographically strong random hex string of `32` hexadecimal characters (`16` random bytes)."),
                QuestionOption("b", "A `16`-character string derived from `random.seed(0)`."),
                QuestionOption("c", "An integer between `0` and `16`."),
                QuestionOption("d", "A `bytes` object of length 8.")
            ),
            correctOptionId = "a",
            explanation = "`secrets.token_hex(nbytes)` generates `nbytes` of OS-backed cryptographic randomness, where each byte is encoded as 2 hex digits (`32` chars for `16` bytes)."
        ),
        QuizQuestion(
            id = "py_a_85",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why should the `secrets` module be used instead of the `random` module for generating password reset tokens or session IDs?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`random` only generates floating-point numbers."),
                QuestionOption("b", "`random` uses the deterministic Mersenne Twister PRNG whose internal state can be reconstructed from observed outputs, whereas `secrets` uses the OS CSPRNG (`os.urandom`)."),
                QuestionOption("c", "`secrets` is 100x faster than `random`."),
                QuestionOption("d", "`random` cannot generate strings.")
            ),
            correctOptionId = "b",
            explanation = "Mersenne Twister (`random`) is completely predictable after observing 624 outputs and is unsuitable for security tokens."
        ),
        QuizQuestion(
            id = "py_a_86",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the result of `set('mississippi')`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`['m', 'i', 's', 'p']`"),
                QuestionOption("b", "`{'mississippi'}`"),
                QuestionOption("c", "`{'m', 'i', 's', 'p'}` (order not fixed, 4 distinct characters)."),
                QuestionOption("d", "11")
            ),
            correctOptionId = "c",
            explanation = "Passing a string (an iterable of characters) to `set()` collects its unique characters."
        ),
        QuizQuestion(
            id = "py_a_87",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you create a single-element set containing the string `'mississippi'` without splitting it into characters?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`{'m': 'ississippi'}`"),
                QuestionOption("b", "`set('mississippi')`"),
                QuestionOption("c", "`('mississippi')`"),
                QuestionOption("d", "`{'mississippi'}` or `set(['mississippi'])`")
            ),
            correctOptionId = "d",
            explanation = "A set literal `{'mississippi'}` treats the string as a single element, whereas `set('mississippi')` iterates over its characters."
        ),
        QuizQuestion(
            id = "py_a_88",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `math.isclose(0.1 + 0.2, 0.3)` return, and why is it needed?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `True`, whereas `(0.1 + 0.2) == 0.3` is `False` due to IEEE 754 binary floating-point representation rounding (`0.30000000000000004`)."),
                QuestionOption("b", "Both `math.isclose` and `==` return `False`."),
                QuestionOption("c", "`math.isclose` converts floats to strings before comparing."),
                QuestionOption("d", "It returns `0.0`.")
            ),
            correctOptionId = "a",
            explanation = "`0.1` and `0.2` do not have exact finite representations in base-2 floating point; `math.isclose` checks relative/absolute tolerance."
        ),
        QuizQuestion(
            id = "py_a_89",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python `unittest.mock`, what is the difference between `Mock` and `MagicMock`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`MagicMock` automatically connects to live external APIs."),
                QuestionOption("b", "`MagicMock` is a subclass of `Mock` that pre-implements default dunder (magic) methods such as `__len__`, `__iter__`, and `__enter__`/`__exit__`."),
                QuestionOption("c", "`Mock` cannot record call arguments."),
                QuestionOption("d", "`MagicMock` is only usable with `pytest`.")
            ),
            correctOptionId = "b",
            explanation = "`MagicMock` provides default implementations for most Python protocol dunder methods so mocked objects work naturally with `len()`, `with`, or iteration."
        ),
        QuizQuestion(
            id = "py_a_90",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `unittest.mock.patch('app.service.requests.get')`, what is the golden rule for choosing the patch target path?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Always patch the lowest-level C extension."),
                QuestionOption("b", "Always patch the built-in `builtins` module."),
                QuestionOption("c", "Patch the name in the module where it is **looked up / imported into** (`app.service.requests.get`), not merely where it is defined."),
                QuestionOption("d", "Patch targets must be file system paths ending in `.py`.")
            ),
            correctOptionId = "c",
            explanation = "If `app.service` did `from requests import get`, patching `requests.get` leaves `app.service.get` pointing to the original function; you must patch `app.service.get`."
        ),
        QuizQuestion(
            id = "py_a_91",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `sys.getsizeof(obj)` measure in CPython?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The disk size when pickled."),
                QuestionOption("b", "The total deep recursive size of `obj` and all nested children."),
                QuestionOption("c", "The number of elements in `obj`."),
                QuestionOption("d", "The shallow memory footprint in bytes of `obj` itself (including garbage-collector header overhead), NOT recursively summing objects referenced by a container.")
            ),
            correctOptionId = "d",
            explanation = "`sys.getsizeof` calls the object's `__sizeof__()` plus GC overhead; for a `list`, it includes the pointer array buffer but not the sizes of the target element objects."
        ),
        QuizQuestion(
            id = "py_a_92",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this tuple concatenation code?",
            codeSnippet = "t1 = (1, 2)\nt2 = t1\nt1 += (3, 4)\nprint(t1, t2)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "(1, 2, 3, 4) (1, 2)"),
                QuestionOption("b", "(1, 2, 3, 4) (1, 2, 3, 4)"),
                QuestionOption("c", "Raises TypeError"),
                QuestionOption("d", "(1, 2) (1, 2, 3, 4)")
            ),
            correctOptionId = "a",
            explanation = "Because tuples are immutable, `t1 += (3, 4)` creates a brand-new tuple `(1, 2, 3, 4)` and rebinds `t1`, leaving `t2` bound to `(1, 2)`."
        ),
        QuizQuestion(
            id = "py_a_93",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Contrastingly, what is the output when `+=` is used on a `list`?",
            codeSnippet = "L1 = [1, 2]\nL2 = L1\nL1 += [3, 4]\nprint(L1, L2)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[1, 2, 3, 4] [1, 2]"),
                QuestionOption("b", "[1, 2, 3, 4] [1, 2, 3, 4]"),
                QuestionOption("c", "[1, 2] [1, 2, 3, 4]"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "b",
            explanation = "For a `list`, `+=` invokes `__iadd__`, which mutates the list in place (like `.extend()`), so both `L1` and `L2` observe the mutation."
        ),
        QuizQuestion(
            id = "py_a_94",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does `L = L + [3, 4]` behave differently from `L += [3, 4]` when another variable aliases `L`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`L + [3, 4]` mutates `L` in place."),
                QuestionOption("b", "They behave identically in all cases."),
                QuestionOption("c", "`L = L + [3, 4]` calls `__add__`, which allocates a new list and rebinds `L`, whereas `L += [3, 4]` calls `__iadd__` and mutates the existing list in place."),
                QuestionOption("d", "`L += [3, 4]` only accepts tuples on the right-hand side.")
            ),
            correctOptionId = "c",
            explanation = "`__iadd__` (`+=`) on mutable sequences performs an in-place extension, whereas `__add__` (`+`) always constructs a new list."
        ),
        QuizQuestion(
            id = "py_a_95",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `L += 'ab'` do when `L = [1, 2]`, versus `L + 'ab'`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`L += 'ab'` produces `[1, 2, 'ab']`."),
                QuestionOption("b", "Both raise `TypeError`."),
                QuestionOption("c", "Both produce `[1, 2, 'ab']`."),
                QuestionOption("d", "`L += 'ab'` succeeds and mutates `L` to `[1, 2, 'a', 'b']` (because `list.__iadd__` accepts any iterable like `.extend()`), whereas `L + 'ab'` raises `TypeError`.")
            ),
            correctOptionId = "d",
            explanation = "`list.__iadd__` iterates over any right-hand iterable just like `list.extend()`, whereas `list.__add__` strictly requires another `list`."
        ),
        QuizQuestion(
            id = "py_a_96",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the purpose of `__all__ = ['Client', 'connect']` at the top of a Python module?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It defines the explicit list of public names exported when a consumer executes `from module import *`."),
                QuestionOption("b", "It prevents any other function from being imported via `from module import helper`."),
                QuestionOption("c", "It makes all other module variables `private` at runtime."),
                QuestionOption("d", "It pre-compiles only those functions to C.")
            ),
            correctOptionId = "a",
            explanation = "`__all__` controls wildcard imports (`from module import *`) and signals the module's public API to documentation tools and linters."
        ),
        QuizQuestion(
            id = "py_a_97",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `int(' 42\\n')` is evaluated?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises a `ValueError` because of the space and newline."),
                QuestionOption("b", "It returns `42` because `int()` automatically strips leading and trailing whitespace around the digits."),
                QuestionOption("c", "It returns `0`."),
                QuestionOption("d", "It returns `'42'`.")
            ),
            correctOptionId = "b",
            explanation = "`int()` and `float()` ignore leading and trailing whitespace characters when parsing numeric strings."
        ),
        QuizQuestion(
            id = "py_a_98",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Python 3, why is `range(1_000_000_000)` fast and uses minimal memory, and does `500_000_000 in range(0, 1_000_000_000, 2)` scan linearly?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`in` on `range` performs an O(n) linear scan."),
                QuestionOption("b", "`range` allocates a C array of 1 billion ints."),
                QuestionOption("c", "`range` stores only `(start, stop, step)` in O(1) memory, and `in` membership testing on `range` is computed arithmetically in O(1) time."),
                QuestionOption("d", "`range` cannot step by 2.")
            ),
            correctOptionId = "c",
            explanation = "In Python 3, `range` is a sequence object that computes indexing, `len()`, and `x in r` mathematically in O(1) time and O(1) space."
        ),
        QuizQuestion(
            id = "py_a_99",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `zip(*matrix)` do when `matrix = [[1, 2, 3], [4, 5, 6]]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises `TypeError`."),
                QuestionOption("b", "Flattens the matrix into `[1, 2, 3, 4, 5, 6]`."),
                QuestionOption("c", "Reverses the order of rows."),
                QuestionOption("d", "Transposes the rows and columns, yielding `(1, 4)`, `(2, 5)`, and `(3, 6)`.")
            ),
            correctOptionId = "d",
            explanation = "Unpacking `*matrix` passes each row as a separate positional argument to `zip()`, pairing elements at matching column indices (matrix transposition)."
        ),
        QuizQuestion(
            id = "py_a_100",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `try / finally` return interaction?",
            codeSnippet = "def compute():\n    try:\n        return 'from_try'\n    finally:\n        return 'from_finally'\n\nprint(compute())",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "from_finally"),
                QuestionOption("b", "from_try"),
                QuestionOption("c", "('from_try', 'from_finally')"),
                QuestionOption("d", "Raises SyntaxError")
            ),
            correctOptionId = "a",
            explanation = "If a `finally` block executes a `return` statement, its return value overrides any pending `return` value (or unhandled exception!) from the `try` block."
        )
    )

    private fun advancedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "py_adv_16",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python's descriptor protocol, what distinguishes a **data descriptor** from a **non-data descriptor**, and how does this affect lookup priority relative to `instance.__dict__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A data descriptor defines `__set__` or `__delete__` and takes priority over `instance.__dict__`; a non-data descriptor defines only `__get__` and is shadowed by a matching key in `instance.__dict__`."),
                QuestionOption("b", "A non-data descriptor takes priority over `instance.__dict__`."),
                QuestionOption("c", "Data descriptors cannot define `__get__`."),
                QuestionOption("d", "`instance.__dict__` always overrides both data and non-data descriptors.")
            ),
            correctOptionId = "a",
            explanation = "`object.__getattribute__` checks data descriptors on the class type first, then `instance.__dict__`, and finally non-data descriptors (such as regular functions/methods)."
        ),
        QuizQuestion(
            id = "py_adv_17",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When is the descriptor method `__set_name__(self, owner, name)` (introduced in Python 3.6) automatically called?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Every time an instance of `owner` is instantiated."),
                QuestionOption("b", "At class creation time (`type.__new__`), once for each descriptor attribute defined in the class body, passing the owning class and the attribute name."),
                QuestionOption("c", "Only when `__set__` is called for the first time."),
                QuestionOption("d", "When the module is garbage collected.")
            ),
            correctOptionId = "b",
            explanation = "`__set_name__` allows descriptors to learn the attribute name they were assigned to on `owner` without repeating the string name in the constructor."
        ),
        QuizQuestion(
            id = "py_adv_18",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How are regular instance methods in Python implemented under the hood so that `obj.method(x)` automatically passes `obj` as `self`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Every instance copies all function objects into `obj.__dict__` during `__init__`."),
                QuestionOption("b", "The compiler rewrites every `.method()` call site into `Class.method(obj)`."),
                QuestionOption("c", "Function objects implement the non-data descriptor protocol (`__get__`), returning a bound method object that wraps `(func, obj)` when accessed through an instance."),
                QuestionOption("d", "Methods use metaclasses to intercept parentheses.")
            ),
            correctOptionId = "c",
            explanation = "`function.__get__(instance, owner)` returns a bound `method` object when `instance is not None`, and returns the raw function when accessed on the class."
        ),
        QuizQuestion(
            id = "py_adv_19",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the Method Resolution Order (`C.__mro__`) for this diamond hierarchy under C3 linearization?",
            codeSnippet = "class A: pass\nclass B(A): pass\nclass C(A): pass\nclass D(B, C): pass",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises TypeError (inconsistent MRO)"),
                QuestionOption("b", "[D, B, A, C, object]"),
                QuestionOption("c", "[D, C, B, A, object]"),
                QuestionOption("d", "[D, B, C, A, object]")
            ),
            correctOptionId = "d",
            explanation = "C3 linearization preserves local precedence order (`B` before `C`) and monotonicity (`A` appears only after all its subclasses `B` and `C`), yielding `D -> B -> C -> A -> object`."
        ),
        QuizQuestion(
            id = "py_adv_20",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does `class X(A, B): pass; class Y(B, A): pass; class Z(X, Y): pass` fail at class definition time?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises `TypeError: Cannot create a consistent method resolution order (MRO)` because `X` requires `A` before `B` while `Y` requires `B` before `A`."),
                QuestionOption("b", "It raises `SyntaxError` because Python allows at most two base classes."),
                QuestionOption("c", "It succeeds and picks `X`'s order."),
                QuestionOption("d", "It fails only when `Z()` is instantiated.")
            ),
            correctOptionId = "a",
            explanation = "C3 linearization enforces consistent precedence ordering across all base classes; contradictory orderings (`A < B` in `X` and `B < A` in `Y`) cannot be linearized."
        ),
        QuizQuestion(
            id = "py_adv_21",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `D.__mro__ == [D, B, C, A, object]`, if `B.work(self)` calls `super().work()`, which class's `work` method is invoked next?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`A.work`, because `B` inherits directly from `A`."),
                QuestionOption("b", "`C.work`, because `super()` follows the runtime instance's `__mro__` (`self.__class__.__mro__`) starting after `B`, not `B`'s static parent `A`."),
                QuestionOption("c", "`D.work`, causing infinite recursion."),
                QuestionOption("d", "`object`")
            ),
            correctOptionId = "b",
            explanation = "`super()` resolves the next class in `type(self).__mro__` immediately following the class where `super()` was called (`B` -> `C`)."
        ),
        QuizQuestion(
            id = "py_adv_22",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens if a subclass `Sub` inherits from a base class `Base` that defines `__slots__ = ('x',)` while `Sub` itself does NOT define `__slots__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Instances of `Sub` automatically inherit `__slots__` with no `__dict__`."),
                QuestionOption("b", "It raises a `TypeError` at class definition time."),
                QuestionOption("c", "Instances of `Sub` get a `__dict__` (in addition to the slot for `'x'`), losing the memory savings of `__slots__` unless `Sub` also defines `__slots__ = ()` (or new slot names)."),
                QuestionOption("d", "`Sub` cannot access `self.x`.")
            ),
            correctOptionId = "c",
            explanation = "Every subclass in an inheritance chain must declare `__slots__` (without duplicating parent slot names) to prevent `__dict__` creation on subclass instances."
        ),
        QuizQuestion(
            id = "py_adv_23",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does creating a `weakref.ref(obj)` to a custom class with `__slots__ = ('a',)` fail unless `'__weakref__'` is included in `__slots__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because `weakref` requires `__hash__`."),
                QuestionOption("b", "Because `weakref` only works on built-in `int` and `str`."),
                QuestionOption("c", "Because `__slots__` objects are allocated on the C stack."),
                QuestionOption("d", "Standard instances store weak reference pointers via a special descriptor, which `__slots__` omits unless `'__weakref__'` is explicitly listed in `__slots__`.")
            ),
            correctOptionId = "d",
            explanation = "When `__slots__` is defined without `'__weakref__'`, instances lack the weakref slot and `weakref.ref(obj)` raises `TypeError: cannot create weak reference`."
        ),
        QuizQuestion(
            id = "py_adv_24",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Which built-in Python types CANNOT be targets of `weakref.ref(...)` directly?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Built-in immutable/container types like `int`, `str`, `tuple`, `list`, and `dict` (though user subclasses of `list` or `dict` can be weak-referenced)."),
                QuestionOption("b", "User-defined classes without `__slots__`."),
                QuestionOption("c", "Functions and classes."),
                QuestionOption("d", "`set` objects.")
            ),
            correctOptionId = "a",
            explanation = "`int`, `str`, `tuple`, `list`, and `dict` omit the `tp_weaklistoffset` slot in CPython to save per-instance memory, whereas `set`, functions, classes, and normal user instances support weakrefs."
        ),
        QuizQuestion(
            id = "py_adv_25",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `__init_subclass__(cls, **kwargs)` (PEP 487) simplify many use cases that previously required a custom metaclass?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It replaces `__init__` for all instances of the base class."),
                QuestionOption("b", "It is a hook on a base class called automatically whenever a new subclass is created, allowing plugin registration or class validation without writing a `type` subclass."),
                QuestionOption("c", "It prevents a class from being subclassed."),
                QuestionOption("d", "It runs before the module is imported.")
            ),
            correctOptionId = "b",
            explanation = "`__init_subclass__` receives the newly created subclass `cls` and any keyword arguments passed in `class Child(Base, role='worker'):`."
        ),
        QuizQuestion(
            id = "py_adv_26",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "During class creation with a custom metaclass `Meta(type)`, in what order are the metaclass hooks invoked?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Class body execution -> `Meta.__prepare__` -> `Meta.__call__`."),
                QuestionOption("b", "`Meta.__init__` -> `Meta.__new__` -> `Meta.__prepare__`."),
                QuestionOption("c", "`Meta.__prepare__` -> class body execution -> `Meta.__new__` -> `Meta.__init__`."),
                QuestionOption("d", "`Meta.__call__` -> `Meta.__new__`.")
            ),
            correctOptionId = "c",
            explanation = "`__prepare__` creates the namespace mapping before executing the class body, `__new__` allocates the class object, and `__init__` initializes the class object."
        ),
        QuizQuestion(
            id = "py_adv_27",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When an instance `obj = MyClass()` is created, which metaclass method orchestrates calling `MyClass.__new__` and `MyClass.__init__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`MyClass.__prepare__`."),
                QuestionOption("b", "`Meta.__new__`."),
                QuestionOption("c", "`object.__init_subclass__`."),
                QuestionOption("d", "`type.__call__` (or `Meta.__call__` on `MyClass`'s metaclass).")
            ),
            correctOptionId = "d",
            explanation = "Calling a class `MyClass()` invokes `__call__` on its type (its metaclass `type`), which calls `MyClass.__new__` and—if an instance of `MyClass` is returned—calls `MyClass.__init__`."
        ),
        QuizQuestion(
            id = "py_adv_28",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If `MyClass.__new__(cls, *args)` returns an object that is NOT an instance of `cls` (e.g., an `int`), what happens to `MyClass.__init__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`MyClass.__init__` is NOT called at all."),
                QuestionOption("b", "`MyClass.__init__` is called with the `int` as `self`."),
                QuestionOption("c", "Python raises a `TypeError`."),
                QuestionOption("d", "`MyClass.__init__` is called with `self = None`.")
            ),
            correctOptionId = "a",
            explanation = "`type.__call__` checks `isinstance(obj, cls)` on the return value of `__new__` and only invokes `__init__` if that check is `True`."
        ),
        QuizQuestion(
            id = "py_adv_29",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the critical difference between overriding `__getattr__(self, name)` and overriding `__getattribute__(self, name)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`__getattr__` is called on every attribute access, whereas `__getattribute__` is the fallback."),
                QuestionOption("b", "`__getattribute__` is called unconditionally on EVERY attribute access, whereas `__getattr__` is called only as a fallback when normal lookup fails with `AttributeError`."),
                QuestionOption("c", "`__getattr__` only intercepts private attributes."),
                QuestionOption("d", "They are synonyms.")
            ),
            correctOptionId = "b",
            explanation = "Overriding `__getattribute__` intercepts all lookups (and must delegate to `super().__getattribute__(name)` to avoid infinite recursion on `self.x`)."
        ),
        QuizQuestion(
            id = "py_adv_30",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If a custom class overrides `__eq__` to compare by value, what does Python 3 automatically do to its `__hash__` attribute if `__hash__` is not explicitly defined?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Python auto-generates a hash from all instance attributes."),
                QuestionOption("b", "Python keeps the default identity-based `object.__hash__`."),
                QuestionOption("c", "Python sets `__hash__ = None` on the class, making its instances unhashable so mutable or custom-equality objects aren't silently broken in `dict`/`set`."),
                QuestionOption("d", "Python raises a `SyntaxError`.")
            ),
            correctOptionId = "c",
            explanation = "To preserve the hash invariant (`a == b` implies `hash(a) == hash(b)`), defining `__eq__` without `__hash__` implicitly sets `__hash__ = None`."
        ),
        QuizQuestion(
            id = "py_adv_31",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does CPython's memory manager handle reference cycles (e.g. `a = []; a.append(a)`) that reference counting alone cannot free?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "CPython pauses for a full mark-and-sweep of primitive `int` and `str` objects every millisecond."),
                QuestionOption("b", "CPython leaks all reference cycles until process exit."),
                QuestionOption("c", "Reference counting automatically detects cycles on every assignment."),
                QuestionOption("d", "A generational cyclic garbage collector (`gc` module) periodically scans tracked container objects in generations 0, 1, and 2 using trial reference decrements to detect unreachable isolated cycles.")
            ),
            correctOptionId = "d",
            explanation = "CPython combines immediate reference counting with a 3-generation cyclic GC that only tracks container objects capable of forming reference cycles."
        ),
        QuizQuestion(
            id = "py_adv_32",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.11+, how does `asyncio.TaskGroup` (`async with asyncio.TaskGroup() as tg:`) differ from `asyncio.gather(*coros)` when one child task raises an unhandled exception?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`TaskGroup` enforces structured concurrency: it automatically cancels all remaining sibling tasks in the group, awaits their completion, and raises an `ExceptionGroup`."),
                QuestionOption("b", "`TaskGroup` ignores exceptions until `tg.result()` is called manually."),
                QuestionOption("c", "`asyncio.gather` cancels all sibling tasks by default, whereas `TaskGroup` lets them run in the background."),
                QuestionOption("d", "`TaskGroup` runs tasks in separate OS processes.")
            ),
            correctOptionId = "a",
            explanation = "`TaskGroup` guarantees no orphan background tasks outlive the `async with` block, cancelling siblings on failure and bundling errors into an `ExceptionGroup`."
        ),
        QuizQuestion(
            id = "py_adv_33",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `asyncio`, why is `asyncio.CancelledError` a subclass of `BaseException` rather than `Exception` (since Python 3.8)?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because `CancelledError` crashes the entire Python interpreter like `SystemExit`."),
                QuestionOption("b", "So that generic `except Exception:` blocks inside coroutines do not accidentally swallow task cancellation requests and prevent tasks from terminating cleanly."),
                QuestionOption("c", "Because `CancelledError` cannot be caught at all."),
                QuestionOption("d", "To make `CancelledError` unpicklable.")
            ),
            correctOptionId = "b",
            explanation = "Moving `CancelledError` under `BaseException` ensures `except Exception:` handlers don't inadvertently trap task cancellation."
        ),
        QuizQuestion(
            id = "py_adv_34",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens if an `async def` coroutine calls `time.sleep(5)` instead of `await asyncio.sleep(5)` on a single-threaded `asyncio` event loop?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It raises a `RuntimeError`."),
                QuestionOption("b", "`asyncio` automatically patches `time.sleep` to yield control."),
                QuestionOption("c", "`time.sleep(5)` blocks the entire OS thread and freezes the event loop, preventing all other concurrent tasks from making progress for 5 seconds."),
                QuestionOption("d", "Only the current coroutine pauses while other tasks continue.")
            ),
            correctOptionId = "c",
            explanation = "Cooperative multitasking in `asyncio` only switches tasks at `await` points; blocking synchronous calls stall the entire event loop thread."
        ),
        QuizQuestion(
            id = "py_adv_35",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How can an `asyncio` application safely run a blocking synchronous function `cpu_or_io_fn(arg)` without stalling the event loop in Python 3.9+?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Call `asyncio.sleep(0)` after `cpu_or_io_fn(arg)`."),
                QuestionOption("b", "Wrap the call in `async with`."),
                QuestionOption("c", "Decorate the synchronous function with `@asyncio.coroutine`."),
                QuestionOption("d", "Use `await asyncio.to_thread(cpu_or_io_fn, arg)` (or `loop.run_in_executor(...)`).")
            ),
            correctOptionId = "d",
            explanation = "`asyncio.to_thread` dispatches the blocking callable to the loop's `ThreadPoolExecutor` and returns an awaitable future."
        ),
        QuizQuestion(
            id = "py_adv_36",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.11+, how does `except* ValueError as eg:` behave when catching an `ExceptionGroup('errors', [ValueError(1), TypeError(2), ValueError(3)])`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The `except* ValueError as eg:` block runs once with `eg` containing a sub-`ExceptionGroup` of `[ValueError(1), ValueError(3)]`, while the unhandled `TypeError(2)` continues propagating."),
                QuestionOption("b", "The `except*` block runs twice, once per `ValueError`, and discards `TypeError(2)`."),
                QuestionOption("c", "It raises a `SyntaxError` unless all exceptions in the group have the same type."),
                QuestionOption("d", "`eg` is bound to `ValueError(1)` only.")
            ),
            correctOptionId = "a",
            explanation = "`except*` splits matching exceptions out of the `ExceptionGroup` into a subgroup `eg` and re-raises any remaining unmatched exceptions after the handler chain finishes."
        ),
        QuizQuestion(
            id = "py_adv_37",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `contextvars.ContextVar` differ from `threading.local()` in an `asyncio` server?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`threading.local()` is isolated per `asyncio.Task`, whereas `ContextVar` is global."),
                QuestionOption("b", "`ContextVar` values are scoped per logical execution context (isolated across concurrent `asyncio.Task`s sharing the same OS thread), whereas `threading.local()` is shared by all tasks running on the same thread."),
                QuestionOption("c", "`ContextVar` only stores integers."),
                QuestionOption("d", "`ContextVar` cannot be read inside synchronous functions.")
            ),
            correctOptionId = "b",
            explanation = "Each `asyncio.Task` copies the current `contextvars.Context` when spawned, keeping request IDs or auth contexts isolated across interleaved coroutines on one thread."
        ),
        QuizQuestion(
            id = "py_adv_38",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does a multi-threaded Python program using `threading.Thread` achieve concurrency for network I/O despite CPython's Global Interpreter Lock (GIL)?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because the GIL is disabled automatically whenever `socket` is imported."),
                QuestionOption("b", "Because `threading.Thread` spawns separate OS processes with independent GILs."),
                QuestionOption("c", "CPython's C implementation releases the GIL around blocking OS system calls (socket `read`/`write`, disk I/O, `time.sleep`), allowing other Python threads to run while waiting on I/O."),
                QuestionOption("d", "Because network I/O executes on the GPU.")
            ),
            correctOptionId = "c",
            explanation = "While CPU-bound Python bytecode contends on the GIL, blocking I/O wrappers release the GIL before invoking the OS kernel and reacquire it upon completion."
        ),
        QuizQuestion(
            id = "py_adv_39",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When using `concurrent.futures.ProcessPoolExecutor`, what requirement must the target function and its arguments/return values satisfy?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "They must be smaller than 64 bytes."),
                QuestionOption("b", "They must be `async def` coroutines."),
                QuestionOption("c", "They must use `__slots__`."),
                QuestionOption("d", "They must be picklable by the `pickle` module so they can be serialized across OS process boundaries over IPC pipes.")
            ),
            correctOptionId = "d",
            explanation = "Separate worker processes do not share heap memory, so `ProcessPoolExecutor` serializes tasks and results via `pickle`."
        ),
        QuizQuestion(
            id = "py_adv_40",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the main advantage of taking a slice of a `memoryview(byte_buffer)[100:5000]` compared to slicing `byte_buffer[100:5000]` directly on a `bytes` or `bytearray` object?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Slicing a `memoryview` creates a zero-copy view over the underlying buffer in O(1) time and memory, whereas slicing `bytes` or `bytearray` allocates and copies a new buffer."),
                QuestionOption("b", "`memoryview` compresses the bytes with zlib."),
                QuestionOption("c", "`memoryview` converts the bytes into a Unicode `str`."),
                QuestionOption("d", "`memoryview` allows resizing a `bytes` object.")
            ),
            correctOptionId = "a",
            explanation = "`memoryview` exposes the C-level Buffer Protocol (`Py_buffer`), enabling zero-copy slicing and in-place mutation of writable buffers like `bytearray`."
        ),
        QuizQuestion(
            id = "py_adv_41",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why should `decimal.Decimal('0.1')` be initialized with a `str` rather than a `float` `decimal.Decimal(0.1)` in financial calculations?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`Decimal(0.1)` raises a `TypeError`."),
                QuestionOption("b", "Passing the float `0.1` first converts `0.1` into its binary IEEE 754 approximation (`0.1000000000000000055511151231257827021181583404541015625`), whereas `'0.1'` constructs the exact base-10 value."),
                QuestionOption("c", "`Decimal('0.1')` rounds to an integer."),
                QuestionOption("d", "There is no difference in Python 3.")
            ),
            correctOptionId = "b",
            explanation = "A float literal is already approximated in binary before `Decimal.__new__` receives it; string initialization parses exact base-10 digits."
        ),
        QuizQuestion(
            id = "py_adv_42",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `fractions.Fraction(1, 3) + fractions.Fraction(1, 6)` evaluate to?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`0.5` (`float`)"),
                QuestionOption("b", "`Fraction(3, 6)`"),
                QuestionOption("c", "`Fraction(1, 2)` (automatically reduced to lowest terms)."),
                QuestionOption("d", "`Fraction(2, 9)`")
            ),
            correctOptionId = "c",
            explanation = "`fractions.Fraction` performs exact rational arithmetic and reduces numerators and denominators by their greatest common divisor (`1/2`)."
        ),
        QuizQuestion(
            id = "py_adv_43",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When a binary arithmetic expression `a + b` is evaluated where `type(a)` and `type(b)` are different unrelated classes, when does Python invoke `b.__radd__(a)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "When `a` and `b` have the exact same type."),
                QuestionOption("b", "Only when `a.__add__(b)` raises `TypeError`."),
                QuestionOption("c", "Always before calling `a.__add__(b)`."),
                QuestionOption("d", "When `a.__add__(b)` returns `NotImplemented` (or `type(a)` does not define `__add__`).")
            ),
            correctOptionId = "d",
            explanation = "Returning the singleton `NotImplemented` (not raising `NotImplementedError`!) signals the runtime to try the reflected operation `b.__radd__(a)`."
        ),
        QuizQuestion(
            id = "py_adv_44",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Wait—what happens in `a + b` if `type(b)` is a strict **subclass** of `type(a)` and `type(b)` overrides `__radd__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Python calls `b.__radd__(a)` BEFORE `a.__add__(b)` so the more specific subclass `type(b)` can control the operation."),
                QuestionOption("b", "Python still calls `a.__add__(b)` first."),
                QuestionOption("c", "Python raises a `TypeError`."),
                QuestionOption("d", "Python calls `b.__add__(a)`.")
            ),
            correctOptionId = "a",
            explanation = "Data model rule: if the right operand is an instance of a proper subclass of the left operand's class and overrides `__radd__`, `b.__radd__(a)` is tried first."
        ),
        QuizQuestion(
            id = "py_adv_45",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between `NotImplemented` and `NotImplementedError` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "They are aliases for the same exception class."),
                QuestionOption("b", "`NotImplemented` is a singleton return value used by binary special methods (`__eq__`, `__add__`, `__lt__`) to signal fallback to the reflected operation; `NotImplementedError` is an exception raised by abstract/stub methods."),
                QuestionOption("c", "`NotImplemented` is raised with `raise NotImplemented`."),
                QuestionOption("d", "`NotImplementedError` is returned by `__eq__`.")
            ),
            correctOptionId = "b",
            explanation = "Returning `NotImplemented` from `__eq__` or `__add__` lets Python try the other operand's method; raising `NotImplementedError` aborts execution with an exception."
        ),
        QuizQuestion(
            id = "py_adv_46",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `@functools.total_ordering` reduce boilerplate when implementing rich comparisons on a class?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It sorts all instances of the class in a global registry."),
                QuestionOption("b", "It generates `__hash__` and `__repr__` from class annotations."),
                QuestionOption("c", "Given `__eq__` and any one ordering method (`__lt__`, `__le__`, `__gt__`, or `__ge__`), `@total_ordering` automatically synthesizes the remaining ordering methods."),
                QuestionOption("d", "It requires all 6 comparison methods to be implemented manually.")
            ),
            correctOptionId = "c",
            explanation = "`@total_ordering` derives the missing comparison dunders from `__eq__` plus a single ordering method such as `__lt__`."
        ),
        QuizQuestion(
            id = "py_adv_47",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `abc.ABC`, what happens if a subclass inherits from an abstract base class containing an `@abstractmethod def process(self):` and does NOT implement `process`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`Sub` is automatically excluded from `issubclass(Sub, Base)`."),
                QuestionOption("b", "Defining the subclass immediately raises `SyntaxError`."),
                QuestionOption("c", "`Sub()` succeeds and raises `NotImplementedError` only when `.process()` is called."),
                QuestionOption("d", "The subclass can be defined, but attempting to instantiate it (`Sub()`) raises `TypeError: Can't instantiate abstract class Sub with abstract method process`.")
            ),
            correctOptionId = "d",
            explanation = "`ABCMeta` tracks `__abstractmethods__` (a `frozenset` of unimplemented abstract names) and blocks instantiation while `__abstractmethods__` is non-empty."
        ),
        QuizQuestion(
            id = "py_adv_48",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `Base.register(ThirdPartyClass)` on an `abc.ABC` class `Base` do?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Registers `ThirdPartyClass` as a **virtual subclass** of `Base` so `issubclass(ThirdPartyClass, Base)` and `isinstance(obj, Base)` return `True`, without adding `Base` to `ThirdPartyClass.__mro__`."),
                QuestionOption("b", "Mutates `ThirdPartyClass.__bases__` to include `Base`."),
                QuestionOption("c", "Copies all methods from `Base` into `ThirdPartyClass`."),
                QuestionOption("d", "Enforces `@abstractmethod` checks when `ThirdPartyClass()` is instantiated.")
            ),
            correctOptionId = "a",
            explanation = "Virtual subclasses satisfy `isinstance`/`issubclass` checks, though they do not inherit methods from `Base` or appear in `__mro__`."
        ),
        QuizQuestion(
            id = "py_adv_49",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When using a generator as a coroutine via `g.send(value)`, what must be passed on the very first `.send(...)` call to a newly created generator before it reaches its first `yield`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Any integer value."),
                QuestionOption("b", "`g.send(None)` (or `next(g)`) to prime the generator up to its first `yield` expression; passing a non-`None` value to a just-started generator raises `TypeError`."),
                QuestionOption("c", "`g.send(StopIteration)`."),
                QuestionOption("d", "Generators do not need priming before `g.send('data')`.")
            ),
            correctOptionId = "b",
            explanation = "At the start of a generator frame, there is no suspended `yield` expression yet to receive a value, so only `send(None)` or `next(g)` is valid initially."
        ),
        QuizQuestion(
            id = "py_adv_50",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `g.close()` do when called on a paused generator `g`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Raises `StopIteration` in the caller."),
                QuestionOption("b", "Terminates the generator without running `finally` blocks."),
                QuestionOption("c", "Throws `GeneratorExit` into the generator at its paused `yield` point so `finally` blocks and `with` context managers inside the generator execute cleanup."),
                QuestionOption("d", "Restarts the generator from the beginning.")
            ),
            correctOptionId = "c",
            explanation = "`g.close()` injects `GeneratorExit` at the suspension point; if the generator catches `GeneratorExit` and yields another value instead of exiting, Python raises `RuntimeError`."
        ),
        QuizQuestion(
            id = "py_adv_51",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does `sys.modules` play a central role when `import pkg.mod` is executed multiple times across a Python application?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`sys.modules` is read-only."),
                QuestionOption("b", "`sys.modules` re-executes the module file on every `import` statement."),
                QuestionOption("c", "`sys.modules` only stores built-in C modules."),
                QuestionOption("d", "Python checks `sys.modules['pkg.mod']` first and returns the cached module object if present, executing the module's top-level code only on the first import.")
            ),
            correctOptionId = "d",
            explanation = "`sys.modules` is the global process-wide dictionary caching loaded modules by their canonical name."
        ),
        QuizQuestion(
            id = "py_adv_52",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when two modules have a top-level circular import (`a.py` runs `from b import func_b` at the top, and `b.py` runs `from a import func_a` at the top)?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The second module encounters a partially initialized module in `sys.modules` before the target name has been defined, raising `ImportError: cannot import name ... (most likely due to a circular import)`."),
                QuestionOption("b", "Python enters an infinite import loop until `RecursionError`."),
                QuestionOption("c", "Python compiles both modules simultaneously without error."),
                QuestionOption("d", "Python deletes both modules from disk.")
            ),
            correctOptionId = "a",
            explanation = "Because `a` is registered in `sys.modules['a']` before its body finishes executing, when `b` executes `from a import func_a` before `a` has defined `func_a`, `ImportError` is raised."
        ),
        QuizQuestion(
            id = "py_adv_53",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `sys.intern(s)` affect string comparisons in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It makes the string mutable."),
                QuestionOption("b", "It registers `s` in the global interned string table and returns the canonical string object, allowing two interned strings to be compared for equality in O(1) pointer time."),
                QuestionOption("c", "It compresses the string in UTF-7."),
                QuestionOption("d", "It pins the string in CPU L1 cache.")
            ),
            correctOptionId = "b",
            explanation = "`str.__eq__` first checks `if self is other: return True` in O(1) time before comparing characters; `sys.intern` guarantees equal interned strings share the same identity."
        ),
        QuizQuestion(
            id = "py_adv_54",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between `__str__` and `__repr__` when only one of them is defined on a custom class?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Both must always be defined together or `TypeError` is raised."),
                QuestionOption("b", "If `__str__` is defined, `repr(obj)` falls back to `__str__`."),
                QuestionOption("c", "If `__repr__` is defined and `__str__` is omitted, `str(obj)` and `print(obj)` fall back to calling `__repr__`; if only `__str__` is defined, `repr(obj)` still uses `object.__repr__`."),
                QuestionOption("d", "Neither falls back to the other.")
            ),
            correctOptionId = "c",
            explanation = "`object.__str__` delegates to `self.__repr__()`, so implementing a clear `__repr__` provides a useful representation for both `repr()` and `str()`."
        ),
        QuizQuestion(
            id = "py_adv_55",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python's `inspect` module, how can you inspect the parameters, default values, and annotations of a callable `fn` without calling it?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`sys.gettrace(fn)`"),
                QuestionOption("b", "`inspect.getframeinfo(fn)`"),
                QuestionOption("c", "`fn.__call__()`"),
                QuestionOption("d", "`inspect.signature(fn)` (returning a `Signature` object whose `.parameters` mapping holds `Parameter` objects).")
            ),
            correctOptionId = "d",
            explanation = "`inspect.signature(fn)` unwraps decorated functions (following `__wrapped__`) and returns a structured `Signature` representation."
        ),
        QuizQuestion(
            id = "py_adv_56",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `typing.TypeVar`, what is the difference between `T = TypeVar('T')` (invariant), `T_co = TypeVar('T_co', covariant=True)`, and `T_contra = TypeVar('T_contra', contravariant=True)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "If `Dog` is a subclass of `Animal`: a covariant container `Box[Dog]` is a subtype of `Box[Animal]` (safe for read-only outputs), whereas a contravariant consumer `Sink[Animal]` is a subtype of `Sink[Dog]` (safe for write-only inputs); mutable containers like `list[T]` must be invariant."),
                QuestionOption("b", "`list[Dog]` is covariant and a subtype of `list[Animal]`."),
                QuestionOption("c", "Contravariant types only accept primitive types."),
                QuestionOption("d", "Variance is enforced at runtime by `isinstance`.")
            ),
            correctOptionId = "a",
            explanation = "Mutable containers like `list` are invariant because allowing `list[Dog]` where `list[Animal]` is expected would let callers append a `Cat()` into a `list[Dog]`."
        ),
        QuizQuestion(
            id = "py_adv_57",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `Callable[[ArgType], ReturnType]`, what is the variance of argument types versus return types?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Callable types are covariant in both parameter and return types."),
                QuestionOption("b", "Callable types are **contravariant** in their parameter types and **covariant** in their return type."),
                QuestionOption("c", "Callable types are invariant in both."),
                QuestionOption("d", "Callable types are covariant in parameters and contravariant in return type.")
            ),
            correctOptionId = "b",
            explanation = "A function expecting `Callable[[Dog], Animal]` can safely be passed a function of type `(Animal) -> Dog`: it accepts any `Animal` (including `Dog`) and returns a `Dog` (which is an `Animal`)."
        ),
        QuizQuestion(
            id = "py_adv_58",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `from __future__ import annotations` (PEP 563) change about type annotations in a Python module?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It removes `__annotations__` completely."),
                QuestionOption("b", "It enforces all type annotations at runtime on every function call."),
                QuestionOption("c", "Annotations are stored in `__annotations__` as unevaluated strings rather than being evaluated eagerly at function/class definition time, avoiding forward-reference `NameError`s and import-time overhead."),
                QuestionOption("d", "It compiles annotated functions to C.")
            ),
            correctOptionId = "c",
            explanation = "Postponed evaluation of annotations prevents circular import issues for type-only references and allows classes to annotate methods with their own class name directly."
        )
    )

    private fun advancedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "py_adv_59",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When `from __future__ import annotations` is active, how should runtime tools (like Pydantic, FastAPI, or custom decorators) resolve the stringized annotations into actual type objects?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Annotations cannot be resolved at runtime."),
                QuestionOption("b", "Call `eval(obj)`."),
                QuestionOption("c", "Read `obj.__doc__`."),
                QuestionOption("d", "Call `typing.get_type_hints(obj)`.")
            ),
            correctOptionId = "d",
            explanation = "`typing.get_type_hints(obj, globalns, localns)` evaluates string annotations in the proper module/class namespace."
        ),
        QuizQuestion(
            id = "py_adv_60",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the output of this class-body scope resolution snippet?",
            codeSnippet = "x = 'global'\nclass Demo:\n    x = 'class_attr'\n    items = [x for _ in range(2)]\nprint(Demo.items)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "['global', 'global']"),
                QuestionOption("b", "['class_attr', 'class_attr']"),
                QuestionOption("c", "Raises NameError"),
                QuestionOption("d", "['Demo', 'Demo']")
            ),
            correctOptionId = "a",
            explanation = "In Python 3, a list comprehension creates its own function-like scope, and enclosing **class bodies are NOT searched** by inner function/comprehension scopes under LEGB—only the outermost iterable expression runs in the class scope!"
        ),
        QuizQuestion(
            id = "py_adv_61",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the previous class scope rule, why does `class Demo: x = 10; gen = (x for _ in range(2))` behave differently for the iterable vs the body expression?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Both are evaluated in the class scope."),
                QuestionOption("b", "The outermost iterable expression (`range(2)`) is evaluated immediately in the class scope, whereas the loop body expression (`x`) is evaluated inside the generator's function scope, which skips the class namespace and looks in enclosing functions/globals."),
                QuestionOption("c", "Both skip the class scope."),
                QuestionOption("d", "Generator expressions cannot be defined in a class.")
            ),
            correctOptionId = "b",
            explanation = "Python's lexical scoping (LEGB) skips class scopes for nested functions and comprehensions so methods must access class attributes via `self.x` or `cls.x`."
        ),
        QuizQuestion(
            id = "py_adv_62",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens to the exception variable `e` after leaving an `except ValueError as e:` block in Python 3?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`e` becomes `None`."),
                QuestionOption("b", "`e` remains bound in the function scope until the function returns."),
                QuestionOption("c", "Python automatically deletes `e` (`del e`) at the end of the `except` block so `e` (and its attached `__traceback__` frame references) does not create a reference cycle keeping local variables alive."),
                QuestionOption("d", "`e` is moved to `builtins`.")
            ),
            correctOptionId = "c",
            explanation = "Exception objects hold `__traceback__`, which references stack frames, which reference local variables (including `e`). Deleting `e` on `except` exit breaks that reference cycle."
        ),
        QuizQuestion(
            id = "py_adv_63",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is printed by this default-argument evaluation timing snippet?",
            codeSnippet = "def register(item, registry=[]):\n    registry.append(item)\n    return len(registry)\n\nprint(register('a'), register('b', []), register('c'))",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "1 2 1"),
                QuestionOption("b", "1 1 1"),
                QuestionOption("c", "1 2 3"),
                QuestionOption("d", "1 1 2")
            ),
            correctOptionId = "d",
            explanation = "The first call appends `'a'` to the shared default list (length `1`); the second call passes a fresh `[]` (length `1`); the third call uses the shared default list again, which now holds `['a', 'c']` (length `2`)."
        ),
        QuizQuestion(
            id = "py_adv_64",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Where is a function's tuple of positional default argument values stored in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`func.__defaults__` (and keyword-only defaults in `func.__kwdefaults__`)."),
                QuestionOption("b", "`func.__closure__`"),
                QuestionOption("c", "`func.__dict__['defaults']`"),
                QuestionOption("d", "`func.__code__.co_consts`")
            ),
            correctOptionId = "a",
            explanation = "`__defaults__` holds a tuple of default values for positional parameters, evaluated once when the `def` statement executes."
        ),
        QuizQuestion(
            id = "py_adv_65",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Where are the captured free variables of a closure stored on a Python function object `fn`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`fn.__defaults__`"),
                QuestionOption("b", "`fn.__closure__` (a tuple of `cell` objects whose values are accessed via `.cell_contents`, with variable names in `fn.__code__.co_freevars`)."),
                QuestionOption("c", "`fn.__globals__`"),
                QuestionOption("d", "`fn.__annotations__`")
            ),
            correctOptionId = "b",
            explanation = "Closures store references to enclosing variables in `cell` objects inside `fn.__closure__`."
        ),
        QuizQuestion(
            id = "py_adv_66",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the result of executing this tuple in-place mutation puzzle?",
            codeSnippet = "t = ([1, 2], 3)\ntry:\n    t[0] += [4]\nexcept TypeError:\n    pass\nprint(t)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "([1, 2, 4], 3) without raising TypeError"),
                QuestionOption("b", "([1, 2], 3)"),
                QuestionOption("c", "([1, 2, 4], 3)"),
                QuestionOption("d", "Raises IndexError")
            ),
            correctOptionId = "c",
            explanation = "`t[0] += [4]` compiles to: (1) load `t[0]` and call `list.__iadd__([4])`, which mutates the list in place to `[1, 2, 4]`, and (2) assign the result back to `t[0]`, which raises `TypeError` on the tuple—leaving the list already mutated!"
        ),
        QuizQuestion(
            id = "py_adv_67",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `asyncio`, what is the difference between `asyncio.create_task(coro())` and simply calling `coro()` without `await` or `create_task`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "There is no difference."),
                QuestionOption("b", "Calling `coro()` starts running it in the background immediately."),
                QuestionOption("c", "`create_task` blocks until `coro()` finishes."),
                QuestionOption("d", "Calling `coro()` merely returns an unscheduled coroutine object (and emits a `RuntimeWarning: coroutine was never awaited` if dropped), whereas `create_task(coro())` schedules it on the running event loop immediately.")
            ),
            correctOptionId = "d",
            explanation = "Unlike JavaScript Promises (which start eagerly on construction), Python coroutines do nothing until awaited or wrapped in a `Task` via `asyncio.create_task`."
        ),
        QuizQuestion(
            id = "py_adv_68",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why should an application keep a strong reference (e.g., in a `set`) to background tasks created with `asyncio.create_task(coro())` if they are not immediately awaited?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The event loop only keeps weak references to tasks, so an unreferenced task can be garbage-collected mid-execution before it completes."),
                QuestionOption("b", "Because `create_task` returns a `weakref.ref`."),
                QuestionOption("c", "Because unreferenced tasks block the GIL."),
                QuestionOption("d", "Because `asyncio` cancels tasks after 1 second if not stored in a list.")
            ),
            correctOptionId = "a",
            explanation = "As documented in the official `asyncio.create_task` docs, the event loop holds only weak references to scheduled tasks; storing them in a set (`tasks.add(t); t.add_done_callback(tasks.discard)`) prevents premature GC."
        ),
        QuizQuestion(
            id = "py_adv_69",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `asyncio.Semaphore(5)` control concurrency across 50 coroutines?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It creates 5 OS threads."),
                QuestionOption("b", "At most 5 coroutines can hold the semaphore inside `async with sem:` concurrently; the remaining coroutines suspend at `__aenter__` until a holder exits the block."),
                QuestionOption("c", "It cancels any coroutine beyond the 5th."),
                QuestionOption("d", "It rate-limits to 5 calls per second.")
            ),
            correctOptionId = "b",
            explanation = "`asyncio.Semaphore(value)` maintains an internal counter decremented on `acquire()` (`__aenter__`) and incremented on `release()` (`__aexit__`), waking waiting futures in FIFO order."
        ),
        QuizQuestion(
            id = "py_adv_70",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.7+, what guarantees does the language specification make about `dict` ordering?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Updating an existing key's value moves that key to the end."),
                QuestionOption("b", "`dict` sorts keys alphabetically."),
                QuestionOption("c", "`dict` preserves key **insertion order** as a language guarantee; updating an existing key's value does not change its position, while deleting and re-inserting moves it to the end."),
                QuestionOption("d", "`dict` order is still implementation-defined.")
            ),
            correctOptionId = "c",
            explanation = "Compact dictionaries introduced in CPython 3.6 became part of the official Python 3.7+ language specification: insertion order is preserved."
        ),
        QuizQuestion(
            id = "py_adv_71",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Even though `dict` preserves insertion order in Python 3.7+, how does `{'a': 1, 'b': 2} == {'b': 2, 'a': 1}` compare to `OrderedDict([('a', 1), ('b', 2)]) == OrderedDict([('b', 2), ('a', 1)])`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Standard `dict` equality is order-sensitive (`False`)."),
                QuestionOption("b", "Both return `True`."),
                QuestionOption("c", "Both return `False`."),
                QuestionOption("d", "Standard `dict` equality is order-insensitive (`True`), whereas `collections.OrderedDict` equality comparing two `OrderedDict`s is order-sensitive (`False`).")
            ),
            correctOptionId = "d",
            explanation = "`dict.__eq__` checks only that both dicts have identical key-value pairs regardless of insertion order, whereas `OrderedDict.__eq__` also requires matching key order."
        ),
        QuizQuestion(
            id = "py_adv_72",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can two objects `a` and `b` have `id(a) == id(b)` in `id(Foo()) == id(Foo())` even though two separate `Foo` instances were created?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`id(obj)` is only guaranteed to be unique among simultaneously **live** objects; the first temporary `Foo()` has its reference count drop to 0 and is freed before the second `Foo()` is allocated at the same memory address."),
                QuestionOption("b", "Because `Foo()` is a singleton by default."),
                QuestionOption("c", "Because `id()` hashes the class name."),
                QuestionOption("d", "`id(Foo()) == id(Foo())` is always `False`.")
            ),
            correctOptionId = "a",
            explanation = "In CPython, `id(x)` is the memory address of `x` during its lifetime. Because neither temporary instance is bound to a variable, the first is deallocated before the second is allocated."
        ),
        QuizQuestion(
            id = "py_adv_73",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `WeakKeyDictionary` or `WeakValueDictionary` in the `weakref` module do when a key or value object has no strong references left elsewhere?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It keeps the object alive forever."),
                QuestionOption("b", "The entry is automatically removed from the dictionary once the weakly referenced object is garbage-collected, preventing cache memory leaks."),
                QuestionOption("c", "It replaces the value with `None` but keeps the key."),
                QuestionOption("d", "It raises `ReferenceError` on the next dictionary lookup.")
            ),
            correctOptionId = "b",
            explanation = "Weak dictionaries attach a finalizer callback to the weak reference that removes the corresponding dictionary entry when the referent is collected."
        ),
        QuizQuestion(
            id = "py_adv_74",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python's data model, when is `__missing__(self, key)` called on a `dict` subclass?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Whenever a key is deleted with `del d[key]`."),
                QuestionOption("b", "Whenever `d.get(key)` or `key in d` is called for a missing key."),
                QuestionOption("c", "When `d[key]` (`__getitem__`) fails to find `key` in the dictionary (note: `d.get(key)` and `key in d` do NOT invoke `__missing__`)."),
                QuestionOption("d", "Only on `object` subclasses that do not inherit from `dict`.")
            ),
            correctOptionId = "c",
            explanation = "`dict.__getitem__` calls `self.__missing__(key)` if the key is absent (this is how `collections.Counter` returns `0` for `c['missing']` and `defaultdict` populates defaults)."
        ),
        QuizQuestion(
            id = "py_adv_75",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Because `collections.Counter` implements `__missing__` to return `0` without inserting the key, how does `c['z']` differ from `defaultdict(int)['z']` when `'z'` is absent?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`c['z']` raises `KeyError`."),
                QuestionOption("b", "Both insert `'z': 0` into the dictionary."),
                QuestionOption("c", "Neither inserts `'z': 0`."),
                QuestionOption("d", "`c['z']` returns `0` without adding `'z'` to `c`, whereas `defaultdict(int)['z']` returns `0` AND inserts `'z': 0` into the dictionary.")
            ),
            correctOptionId = "d",
            explanation = "`Counter.__missing__` simply returns `0` without mutating `self`, whereas `defaultdict.__missing__` assigns `self[key] = value = self.default_factory()`."
        ),
        QuizQuestion(
            id = "py_adv_76",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is printed by this `float('nan')` container membership test?",
            codeSnippet = "nan = float('nan')\nitems = [nan]\nprint(nan == nan, nan is nan, nan in items)",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "False True True"),
                QuestionOption("b", "False True False"),
                QuestionOption("c", "False False False"),
                QuestionOption("d", "True True True")
            ),
            correctOptionId = "a",
            explanation = "By IEEE 754, `nan == nan` is `False`, but `nan is nan` is `True` (same object reference). Python's `list`/`tuple`/`set`/`dict` containment checks object identity (`x is item` or `x == item`) first, so `nan in [nan]` is `True`!"
        ),
        QuizQuestion(
            id = "py_adv_77",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens if two distinct `NaN` objects `n1 = float('nan')` and `n2 = float('nan')` are accessed in `n1 in [n2]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `True` because all NaNs are singletons."),
                QuestionOption("b", "It returns `False` because `n1 is n2` is `False` (distinct float objects) and `n1 == n2` is also `False`."),
                QuestionOption("c", "It raises `ValueError`."),
                QuestionOption("d", "It returns `NaN`.")
            ),
            correctOptionId = "b",
            explanation = "List containment checks `elem is target or elem == target`; for two separate `float('nan')` allocations, both identity and equality are `False`."
        ),
        QuizQuestion(
            id = "py_adv_78",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.11, what performance optimization does the **Specializing Adaptive Interpreter** (PEP 659) perform at runtime?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It removes the GIL by running each function in a separate kernel thread."),
                QuestionOption("b", "It compiles all Python code to WebAssembly ahead of time."),
                QuestionOption("c", "It dynamically replaces generic bytecode instructions (like `BINARY_OP` or `LOAD_ATTR`) in hot loops with type-specialized quickened instructions (like `BINARY_OP_ADD_INT`) with inline caches."),
                QuestionOption("d", "It converts all lists into NumPy arrays.")
            ),
            correctOptionId = "c",
            explanation = "PEP 659 observes runtime types after a few executions and specializes generic bytecode instructions in place, falling back (deoptimizing) if types change."
        ),
        QuizQuestion(
            id = "py_adv_79",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `functools.singledispatch` enable in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Compile-time template instantiation."),
                QuestionOption("b", "Multiple dispatch based on the types of all arguments."),
                QuestionOption("c", "Method overloading by argument count (`arity`)."),
                QuestionOption("d", "Generic functions that dispatch to different registered implementations based on the runtime type of the **first** argument.")
            ),
            correctOptionId = "d",
            explanation = "`@singledispatch` transforms a function into a single-dispatch generic function where `@fn.register(Type)` registers specialized handlers for the first argument's type."
        ),
        QuizQuestion(
            id = "py_adv_80",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "If a `@classmethod` or regular method inside a class needs single-dispatch behavior on the first non-`self`/`cls` argument (Python 3.8+), which decorator should be used instead of `@singledispatch`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`@functools.singledispatchmethod`"),
                QuestionOption("b", "`@functools.singledispatch`"),
                QuestionOption("c", "`@typing.overload`"),
                QuestionOption("d", "`@abc.abstractmethod`")
            ),
            correctOptionId = "a",
            explanation = "`@singledispatch` dispatches on the very first positional parameter (`self`), whereas `@singledispatchmethod` dispatches on the first argument after `self` or `cls`."
        ),
        QuizQuestion(
            id = "py_adv_81",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the runtime behavior of `@typing.overload` in Python?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Python dispatches at runtime to whichever `@overload` signature matches the argument types."),
                QuestionOption("b", "`@overload`-decorated stubs are strictly for static type checkers (`mypy`/`pyright`) and are overwritten at runtime by the final non-decorated implementation function."),
                QuestionOption("c", "Calling a function with `@overload` stubs is 2x faster."),
                QuestionOption("d", "Each `@overload` creates a separate mangled method name.")
            ),
            correctOptionId = "b",
            explanation = "In Python's `typing` module, `@overload` definitions document type-level relationships between inputs and outputs; the final un-decorated `def` provides the sole runtime implementation."
        ),
        QuizQuestion(
            id = "py_adv_82",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When subclassing an immutable built-in type like `tuple` or `int`, why must custom initialization be placed in `__new__` rather than `__init__`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because `__init__` is never called on subclasses of built-in types."),
                QuestionOption("b", "Because `tuple` and `int` do not have an `__init__` method on `object`."),
                QuestionOption("c", "Because the immutable value of `tuple` or `int` is fixed when allocated inside `__new__`; by the time `__init__` runs, the object's value can no longer be modified."),
                QuestionOption("d", "Because `__new__` runs after `__init__`.")
            ),
            correctOptionId = "c",
            explanation = "Immutable objects must compute and pass their underlying data to `super().__new__(cls, ...)` at allocation time."
        ),
        QuizQuestion(
            id = "py_adv_83",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `sys.setrecursionlimit(limit)` control, and why does CPython not perform automatic tail-call elimination (TCO)?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It limits `while` loop iterations."),
                QuestionOption("b", "It enables tail-call optimization for recursion depths above `limit`."),
                QuestionOption("c", "It controls the maximum number of threads."),
                QuestionOption("d", "It sets the maximum depth of the Python interpreter call stack before raising `RecursionError`; CPython preserves full stack frames and tracebacks and because functions can be dynamically rebound at runtime.")
            ),
            correctOptionId = "d",
            explanation = "Guido van Rossum explicitly rejected TCO in Python because eliminating frames destroys accurate stack traces and conflicts with dynamic name binding."
        ),
        QuizQuestion(
            id = "py_adv_84",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `pickle`, why is `pickle.loads(untrusted_bytes)` a critical arbitrary-code-execution vulnerability?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Pickle is a stack-based virtual machine whose `__reduce__` protocol allows serialized payloads to invoke arbitrary callables (such as `os.system` or `subprocess.Popen`) during deserialization."),
                QuestionOption("b", "Because `pickle` overflows the C stack on strings longer than 1 KB."),
                QuestionOption("c", "Because `pickle` automatically executes SQL queries."),
                QuestionOption("d", "It is only vulnerable in Python 2.")
            ),
            correctOptionId = "a",
            explanation = "`object.__reduce__()` returns a `(callable, args)` tuple that `pickle.loads` invokes directly to reconstruct objects, allowing untrusted payloads to execute arbitrary code."
        ),
        QuizQuestion(
            id = "py_adv_85",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `importlib.resources` (Python 3.9+ `importlib.resources.files(pkg)`) improve upon `Path(__file__).parent` when reading data files bundled inside a Python package?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It automatically parses CSV and JSON files."),
                QuestionOption("b", "It provides a `Traversable` abstraction that works even when the package is imported from a zip archive, wheel, or frozen executable where a regular filesystem path may not exist."),
                QuestionOption("c", "It is required for reading `.py` source files."),
                QuestionOption("d", "`__file__` was removed in Python 3.10.")
            ),
            correctOptionId = "b",
            explanation = "`importlib.resources.files()` abstracts package resource access across filesystem directories and zipped/frozen distributions."
        ),
        QuizQuestion(
            id = "py_adv_86",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is printed by this late-binding vs default-argument closure comparison?",
            codeSnippet = "funcs_a = [lambda: i for i in range(3)]\nfuncs_b = [lambda i=i: i for i in range(3)]\nprint([f() for f in funcs_a], [f() for f in funcs_b])",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "[2, 2, 2] [2, 2, 2]"),
                QuestionOption("b", "[0, 1, 2] [0, 1, 2]"),
                QuestionOption("c", "[2, 2, 2] [0, 1, 2]"),
                QuestionOption("d", "[0, 1, 2] [2, 2, 2]")
            ),
            correctOptionId = "c",
            explanation = "`funcs_a` captures the loop cell variable `i` by reference (which ends at `2`), while `funcs_b` binds the current value of `i` at each iteration as a default argument."
        ),
        QuizQuestion(
            id = "py_adv_87",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python's buffer / struct handling, what does `struct.pack('>IH', 1, 2)` produce?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "A string `'1 2'`."),
                QuestionOption("b", "A `6`-byte little-endian `bytes` object."),
                QuestionOption("c", "An `8`-byte native-aligned `bytes` object."),
                QuestionOption("d", "A `6`-byte big-endian `bytes` object (`4`-byte unsigned int `1` followed by `2`-byte unsigned short `2`: `b'\\x00\\x00\\x00\\x01\\x00\\x02'`).")
            ),
            correctOptionId = "d",
            explanation = "In `struct` format strings, `>` specifies big-endian byte order with standard sizes and no alignment padding (`I` = 4 bytes, `H` = 2 bytes)."
        ),
        QuizQuestion(
            id = "py_adv_88",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can `struct.calcsize('BH')` return `4` on a 64-bit machine while `struct.calcsize('=BH')` or `struct.calcsize('<BH')` returns `3`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Without a byte-order prefix (`@` default), `struct` uses native C struct alignment and inserts 1 padding byte after `B` (1 byte) to align `H` (2 bytes) on a 2-byte boundary; `=` or `<` uses standard unpadded sizes."),
                QuestionOption("b", "Because `H` is 3 bytes in native mode."),
                QuestionOption("c", "Because `=` compresses the integers."),
                QuestionOption("d", "Because `<` drops the first byte.")
            ),
            correctOptionId = "a",
            explanation = "Native mode (`@`) matches the platform C compiler's struct padding rules, whereas standard modes (`=`, `<`, `>`, `!`) pack fields tightly without alignment padding."
        ),
        QuizQuestion(
            id = "py_adv_89",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when `__del__(self)` (the finalizer method) creates a new strong global reference to `self` during garbage collection?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "CPython ignores the reference and frees the memory anyway, causing a segfault."),
                QuestionOption("b", "The object is **resurrected** (not deallocated), and CPython marks the object as having already run its finalizer so `__del__` will not be called a second time when it eventually dies."),
                QuestionOption("c", "`__del__` raises a `RuntimeError`."),
                QuestionOption("d", "`__del__` is called repeatedly in an infinite loop.")
            ),
            correctOptionId = "b",
            explanation = "PEP 442 guarantees that finalizers (`__del__`) are executed at most once per object lifetime, even if the finalizer resurrects the object."
        ),
        QuizQuestion(
            id = "py_adv_90",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Instead of overriding `__del__`, what does the standard library provide for registering reliable cleanup callbacks when an object is garbage-collected without risking object resurrection?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`sys.atexit(obj)`"),
                QuestionOption("b", "`gc.collect(obj)`"),
                QuestionOption("c", "`weakref.finalize(obj, func, *args, **kwargs)`"),
                QuestionOption("d", "`contextlib.closing(obj)`")
            ),
            correctOptionId = "c",
            explanation = "`weakref.finalize` attaches a cleanup callback to a weak reference that does not receive `obj` itself, preventing accidental resurrection and also running at interpreter shutdown."
        ),
        QuizQuestion(
            id = "py_adv_91",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.10+, what does `zip(*iterables, strict=True)` protect against when transposing a jagged list of lists `[[1, 2], [3, 4, 5]]`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns `None`."),
                QuestionOption("b", "It pads `[1, 2]` with `0`."),
                QuestionOption("c", "It sorts the rows by length."),
                QuestionOption("d", "It raises `ValueError` instead of silently dropping the extra element `5` from the longer row.")
            ),
            correctOptionId = "d",
            explanation = "Without `strict=True`, `zip(*jagged)` silently truncates to the shortest row; `strict=True` ensures all rows have identical length."
        ),
        QuizQuestion(
            id = "py_adv_92",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `types.MappingProxyType(d)` protect a dictionary `d`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It returns a dynamic read-only view of `d` that raises `TypeError` on any mutation attempt through the proxy while still reflecting changes made directly to `d`."),
                QuestionOption("b", "It makes a deep frozen copy of `d`."),
                QuestionOption("c", "It converts `d` into a `frozenset`."),
                QuestionOption("d", "It encrypts the keys of `d`.")
            ),
            correctOptionId = "a",
            explanation = "`MappingProxyType` wraps an underlying mapping in an immutable proxy without copying it (this is what Python uses for `cls.__dict__`)."
        ),
        QuizQuestion(
            id = "py_adv_93",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `cls.__dict__` on a Python class a `mappingproxy` rather than a plain `dict`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "Because classes cannot have attributes added after definition."),
                QuestionOption("b", "So user code cannot bypass the class attribute machinery (`type.__setattr__`) by mutating `cls.__dict__['attr'] = val` directly, which would fail to update internal method/slot caches."),
                QuestionOption("c", "Because `mappingproxy` uses 10x less RAM."),
                QuestionOption("d", "Because `cls.__dict__` only stores strings.")
            ),
            correctOptionId = "b",
            explanation = "Modifying class attributes must go through `setattr(cls, name, val)` so the type's internal lookup caches and special method slots (`tp_as_number`, etc.) stay synchronized."
        ),
        QuizQuestion(
            id = "py_adv_94",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `operator.methodcaller('split', ',', maxsplit=1)('a,b,c')` return?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "'a'"),
                QuestionOption("b", "['a', 'b', 'c']"),
                QuestionOption("c", "['a', 'b,c']"),
                QuestionOption("d", "Raises TypeError")
            ),
            correctOptionId = "c",
            explanation = "`methodcaller(name, *args, **kwargs)` returns a callable object that invokes `obj.split(',', maxsplit=1)` on its argument."
        ),
        QuizQuestion(
            id = "py_adv_95",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `asyncio`, what is the difference between `asyncio.wait(tasks, return_when=asyncio.FIRST_COMPLETED)` and `asyncio.gather(*tasks)`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`asyncio.wait` only accepts a single coroutine."),
                QuestionOption("b", "`asyncio.wait` cancels all pending tasks immediately."),
                QuestionOption("c", "`gather` returns `(done, pending)` sets."),
                QuestionOption("d", "`asyncio.wait` returns a `(done, pending)` tuple of `Task` sets as soon as the first task completes without cancelling the `pending` tasks, whereas `gather` waits for all tasks and returns their ordered results.")
            ),
            correctOptionId = "d",
            explanation = "`asyncio.wait` gives low-level control over `(done, pending)` task sets and completion conditions (`FIRST_COMPLETED`, `FIRST_EXCEPTION`, `ALL_COMPLETED`)."
        ),
        QuizQuestion(
            id = "py_adv_96",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When using `asyncio.wait_for(coro, timeout=2.0)`, what happens to `coro` if the 2-second timeout expires before it finishes?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`wait_for` cancels the wrapped task, waits for the cancellation to complete, and raises `TimeoutError`."),
                QuestionOption("b", "`wait_for` raises `TimeoutError` while leaving `coro` running in the background."),
                QuestionOption("c", "`wait_for` returns `None` without raising an exception."),
                QuestionOption("d", "`wait_for` restarts `coro` from the beginning.")
            ),
            correctOptionId = "a",
            explanation = "`asyncio.wait_for` cancels the inner task on timeout (to observe timeout without cancelling the task, `asyncio.shield(task)` can be used)."
        ),
        QuizQuestion(
            id = "py_adv_97",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3.11+, what is the cleanest context-manager way to apply a timeout to a block of multiple `await` calls?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`with time.timeout(2.0):`"),
                QuestionOption("b", "`async with asyncio.timeout(2.0):`"),
                QuestionOption("c", "`async with asyncio.wait_for(2.0):`"),
                QuestionOption("d", "`try ... except asyncio.SleepError:`")
            ),
            correctOptionId = "b",
            explanation = "`asyncio.timeout(delay)` (added in Python 3.11) is an async context manager that cancels the enclosing task on deadline expiry and transforms the `CancelledError` into `TimeoutError`."
        ),
        QuizQuestion(
            id = "py_adv_98",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `itertools.pairwise(['A', 'B', 'C', 'D'])` (added in Python 3.10) yield?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "`('A', 'B', 'C', 'D')`"),
                QuestionOption("b", "`('A', 'B')`, `('C', 'D')` (non-overlapping pairs)."),
                QuestionOption("c", "`('A', 'B')`, `('B', 'C')`, `('C', 'D')` (overlapping consecutive pairs)."),
                QuestionOption("d", "`[('A', 0), ('B', 1), ('C', 2), ('D', 3)]`")
            ),
            correctOptionId = "c",
            explanation = "`itertools.pairwise(iterable)` returns successive overlapping pairs taken from the input iterable."
        ),
        QuizQuestion(
            id = "py_adv_99",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `functools.cached_property` (Python 3.8+) do on an instance, and why does it NOT work on a class with `__slots__` (and no `__dict__`)?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "It works only on `@dataclass(frozen=True)`."),
                QuestionOption("b", "It stores the cached value on the class object."),
                QuestionOption("c", "It uses `lru_cache` on the module."),
                QuestionOption("d", "`cached_property` is a non-data descriptor that computes the value on first access and writes it directly into `instance.__dict__[attr_name]`, so subsequent accesses read `instance.__dict__` without calling the descriptor; without `__dict__`, it raises `TypeError`.")
            ),
            correctOptionId = "d",
            explanation = "Because `cached_property` only implements `__get__` (non-data descriptor), writing the computed result into `instance.__dict__` shadows the descriptor on all future reads."
        ),
        QuizQuestion(
            id = "py_adv_100",
            category = QuizCategory.PYTHON,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Python 3, why does `bool(datetime.time(0, 0))` evaluate to `True`, even though in Python 3.0–3.4 midnight `time(0, 0)` evaluated to `False`?",
            languageNote = "Python 3.11+",
            options = listOf(
                QuestionOption("a", "The false-at-midnight behavior caused subtle bugs where `if timestamp:` treated valid `00:00:00` times as missing (`None`), so Python 3.5+ removed `time.__bool__` so all `datetime.time` instances are truthy."),
                QuestionOption("b", "Because `00:00` is stored as `24:00`."),
                QuestionOption("c", "Because `datetime.time` subclasses `int`."),
                QuestionOption("d", "`bool(datetime.time(0, 0))` is still `False`.")
            ),
            correctOptionId = "a",
            explanation = "Removing the special-case falsiness of midnight `00:00:00` eliminated a notorious class of production bugs when checking `if scheduled_time:`."
        )
    )

}
