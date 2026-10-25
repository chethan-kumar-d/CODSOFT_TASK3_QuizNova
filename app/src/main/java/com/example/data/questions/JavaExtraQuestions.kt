package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object JavaExtraQuestions {
    val questions: List<QuizQuestion> by lazy {
        foundationBatch1() + foundationBatch2() + appliedBatch1() + appliedBatch2() + advancedBatch1() + advancedBatch2()
    }

    private fun foundationBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "jv_f_16",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java 17, what is the bit width and value range of a `byte` primitive?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "8-bit unsigned integer (`0` to `255`)."),
                QuestionOption("b", "8-bit signed two's complement integer (`-128` to `127`)."),
                QuestionOption("c", "16-bit signed integer (`-32768` to `32767`)."),
                QuestionOption("d", "1-bit boolean value.")
            ),
            correctOptionId = "b",
            explanation = "Java's `byte` is an 8-bit signed two's complement integer with minimum `-128` (`-2^7`) and maximum `127` (`2^7 - 1`)."
        ),
        QuizQuestion(
            id = "jv_f_17",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which primitive type in Java is an unsigned 16-bit value (`0` to `65535`) used to represent UTF-16 code units?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`byte`"),
                QuestionOption("b", "`short`"),
                QuestionOption("c", "`char`"),
                QuestionOption("d", "`int`")
            ),
            correctOptionId = "c",
            explanation = "`char` is the only unsigned integer-like primitive in Java, occupying 16 bits (`'\\u0000'` to `'\\uffff'`), whereas `short` is signed 16-bit."
        ),
        QuizQuestion(
            id = "jv_f_18",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why does `float ratio = 3.14;` fail to compile in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `float` variables can only store integers."),
                QuestionOption("b", "Because `float` is not a valid keyword in Java 17."),
                QuestionOption("c", "Because `ratio` is a reserved keyword."),
                QuestionOption("d", "A decimal literal like `3.14` has type `double` by default and requires an `f` or `F` suffix (`3.14f`) to be assigned to a `float` without an explicit cast.")
            ),
            correctOptionId = "d",
            explanation = "Floating-point literals without a suffix default to 64-bit `double`; assigning a `double` to a 32-bit `float` is a narrowing conversion requiring `3.14f`."
        ),
        QuizQuestion(
            id = "jv_f_19",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the type and value of `b1 + b2` when `byte b1 = 10; byte b2 = 20;`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "An `int` with value `30` (because binary `+` promotes `byte`, `short`, and `char` operands to `int`)."),
                QuestionOption("b", "A `byte` with value `30`."),
                QuestionOption("c", "A `short` with value `30`."),
                QuestionOption("d", "A `long` with value `30`.")
            ),
            correctOptionId = "a",
            explanation = "Binary numeric promotion widens `byte`, `short`, and `char` operands to at least `int`, which is why `byte b3 = b1 + b2;` fails without `(byte)(b1 + b2)`."
        ),
        QuizQuestion(
            id = "jv_f_20",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `-17 % 5` and `17 % -5` in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`3` and `-3`"),
                QuestionOption("b", "`-2` and `2` (in Java, the remainder `%` takes the sign of the dividend, i.e., the left operand)."),
                QuestionOption("c", "`-2` and `-2`"),
                QuestionOption("d", "`2` and `2`")
            ),
            correctOptionId = "b",
            explanation = "In Java (`(a / b) * b + (a % b) == a` with integer division truncating toward zero), the sign of `a % b` matches the sign of the dividend `a`."
        ),
        QuizQuestion(
            id = "jv_f_21",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How does `Math.floorMod(-17, 5)` differ from `-17 % 5` in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both return `3`."),
                QuestionOption("b", "Both return `-2`."),
                QuestionOption("c", "`Math.floorMod(-17, 5)` returns `3` (taking the sign of the divisor `5`), whereas `-17 % 5` returns `-2`."),
                QuestionOption("d", "`Math.floorMod` returns a `double`.")
            ),
            correctOptionId = "c",
            explanation = "`Math.floorMod(x, y)` pairs with `Math.floorDiv(x, y)` and returns a non-negative remainder when the divisor `y` is positive."
        ),
        QuizQuestion(
            id = "jv_f_22",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `\"Java 17\".substring(1, 4)` return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "\"va 1\""),
                QuestionOption("b", "\"Java\""),
                QuestionOption("c", "\"ava \""),
                QuestionOption("d", "\"ava\"")
            ),
            correctOptionId = "d",
            explanation = "`String.substring(beginIndex, endIndex)` starts at inclusive index `1` (`'a'`) and stops before exclusive index `4` (`' '`), returning `\"ava\"`."
        ),
        QuizQuestion(
            id = "jv_f_23",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `str.isEmpty()` and `str.isBlank()` (Java 11+) on `\"   \\t\\n\"`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`isEmpty()` returns `false` (length is not 0), whereas `isBlank()` returns `true` because the string contains only whitespace."),
                QuestionOption("b", "Both return `true`."),
                QuestionOption("c", "Both return `false`."),
                QuestionOption("d", "`isEmpty()` returns `true` and `isBlank()` returns `false`.")
            ),
            correctOptionId = "a",
            explanation = "`isEmpty()` checks `length() == 0`; `isBlank()` checks whether the string is empty or contains only Unicode whitespace code points."
        ),
        QuizQuestion(
            id = "jv_f_24",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How does `str.strip()` (Java 11+) improve upon `str.trim()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`trim()` removes internal spaces, whereas `strip()` does not."),
                QuestionOption("b", "`strip()` is Unicode-aware (`Character.isWhitespace`), whereas `trim()` only removes ASCII characters with code point `<= U+0020`."),
                QuestionOption("c", "`strip()` mutates the String in place."),
                QuestionOption("d", "`trim()` was removed in Java 17.")
            ),
            correctOptionId = "b",
            explanation = "`String.strip()` removes all leading and trailing Unicode whitespace (such as non-breaking or ideographic spaces), whereas `trim()` only strips `<= '\\u0020'`."
        ),
        QuizQuestion(
            id = "jv_f_25",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `String.join(\"-\", \"2025\", \"05\", \"19\")` return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "\"20250519\""),
                QuestionOption("b", "\"-2025-05-19-\""),
                QuestionOption("c", "\"2025-05-19\""),
                QuestionOption("d", "Compilation error")
            ),
            correctOptionId = "c",
            explanation = "`String.join(delimiter, elements...)` concatenates the elements separated by the delimiter."
        ),
        QuizQuestion(
            id = "jv_f_26",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why is `StringBuilder` preferred over repeated `str += piece` inside a large loop when building a string dynamically?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`+=` is not defined for `String` in Java."),
                QuestionOption("b", "`String` cannot be used inside `for` loops."),
                QuestionOption("c", "`StringBuilder` is immutable and thread-safe."),
                QuestionOption("d", "`StringBuilder` appends into a mutable resizable character/byte buffer in amortized O(1) per character, whereas `+=` in a loop allocates and copies a new immutable `String` on every iteration (O(n^2) total).")
            ),
            correctOptionId = "d",
            explanation = "Repeated concatenation in a loop copies all previously accumulated characters each iteration; `StringBuilder.append` mutates an internal buffer."
        ),
        QuizQuestion(
            id = "jv_f_27",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `StringBuilder` and `StringBuffer` in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`StringBuilder` is unsynchronized and faster for single-threaded use, whereas `StringBuffer` synchronizes its methods for thread safety."),
                QuestionOption("b", "`StringBuffer` is immutable, whereas `StringBuilder` is mutable."),
                QuestionOption("c", "`StringBuilder` is synchronized, whereas `StringBuffer` is not."),
                QuestionOption("d", "They are aliases for the same class.")
            ),
            correctOptionId = "a",
            explanation = "`StringBuilder` (Java 5+) drops the method-level `synchronized` overhead of `StringBuffer` for single-threaded string construction."
        ),
        QuizQuestion(
            id = "jv_f_28",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Arrays.equals(a, b)` check compared to `a.equals(b)` for two `int[]` arrays `a = {1, 2}` and `b = {1, 2}`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both return `true`."),
                QuestionOption("b", "`Arrays.equals(a, b)` compares array lengths and elements (`true`), whereas `a.equals(b)` uses `Object.equals` reference identity (`false`)."),
                QuestionOption("c", "Both return `false`."),
                QuestionOption("d", "`a.equals(b)` compares elements and `Arrays.equals` compares references.")
            ),
            correctOptionId = "b",
            explanation = "Java arrays do not override `Object.equals`, so `a.equals(b)` is equivalent to `a == b`; `Arrays.equals(a, b)` compares element contents."
        ),
        QuizQuestion(
            id = "jv_f_29",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "For nested multi-dimensional arrays `int[][] m1` and `int[][] m2`, which method compares their nested element values recursively?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`m1.equals(m2)`"),
                QuestionOption("b", "`Arrays.equals(m1, m2)`"),
                QuestionOption("c", "`Arrays.deepEquals(m1, m2)` (and `Arrays.deepToString(m1)` for formatting)."),
                QuestionOption("d", "`Objects.equals(m1, m2)`")
            ),
            correctOptionId = "c",
            explanation = "`Arrays.equals` on a 2D array only checks reference equality of the inner row arrays; `Arrays.deepEquals` compares nested sub-arrays recursively."
        ),
        QuizQuestion(
            id = "jv_f_30",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when `List<String> list = Arrays.asList(\"a\", \"b\");` has `list.add(\"c\")` vs `list.set(0, \"z\")` called on it?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`set` throws `UnsupportedOperationException` and `add` succeeds."),
                QuestionOption("b", "Both `set` and `add` succeed."),
                QuestionOption("c", "Both throw `UnsupportedOperationException`."),
                QuestionOption("d", "`list.set(0, \"z\")` succeeds (and writes through to the backing array), whereas `list.add(\"c\")` throws `UnsupportedOperationException` because the list is fixed-size.")
            ),
            correctOptionId = "d",
            explanation = "`Arrays.asList` returns a fixed-size `List` view backed by the array: replacing elements via `set` is allowed, but structural resizing (`add`/`remove`) is unsupported."
        ),
        QuizQuestion(
            id = "jv_f_31",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How does `List.of(\"a\", \"b\")` (Java 9+) differ from `Arrays.asList(\"a\", \"b\")` regarding mutability and `null` elements?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`List.of(...)` is completely unmodifiable (`set` and `add` both throw `UnsupportedOperationException`) and forbids `null` elements (`NullPointerException`)."),
                QuestionOption("b", "`List.of(...)` allows `set(0, \"z\")` and `null` elements."),
                QuestionOption("c", "`List.of(...)` returns a mutable `ArrayList`."),
                QuestionOption("d", "`Arrays.asList` forbids `null` elements.")
            ),
            correctOptionId = "a",
            explanation = "Unmodifiable collection factories (`List.of`, `Set.of`, `Map.of`) reject `null` elements at creation time and forbid all mutations including `set`."
        ),
        QuizQuestion(
            id = "jv_f_32",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the output of this Java 14+ switch expression?",
            codeSnippet = "int day = 6;\nString type = switch (day) {\n    case 1, 2, 3, 4, 5 -> \"Weekday\";\n    case 6, 7 -> \"Weekend\";\n    default -> \"Invalid\";\n};\nSystem.out.println(type);",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Weekday"),
                QuestionOption("b", "Weekend"),
                QuestionOption("c", "Weekend\\nInvalid"),
                QuestionOption("d", "Compilation error")
            ),
            correctOptionId = "b",
            explanation = "Arrow `case L ->` switch rules in Java 14+ support comma-separated labels and never fall through to subsequent cases."
        ),
        QuizQuestion(
            id = "jv_f_33",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Inside a multi-statement block of a Java 14+ switch expression (`case 1 -> { ... }`), which keyword produces the value for that case arm?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`break`"),
                QuestionOption("b", "`return`"),
                QuestionOption("c", "`yield`"),
                QuestionOption("d", "`continue`")
            ),
            correctOptionId = "c",
            explanation = "`yield value;` exits the enclosing switch expression with `value`, whereas `return` would exit the enclosing method."
        ),
        QuizQuestion(
            id = "jv_f_34",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does pattern matching for `instanceof` (`if (obj instanceof String s && s.length() > 3)`) allow in Java 16+?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`s` is in scope even when the `&&` operator is replaced by `||`."),
                QuestionOption("b", "It converts any object to a `String` via `toString()`."),
                QuestionOption("c", "It only works for primitive types."),
                QuestionOption("d", "It tests whether `obj` is a `String` and, if `true`, binds the cast variable `s` in scope for the right-hand side of `&&` and the `if` body without an explicit `(String) obj` cast.")
            ),
            correctOptionId = "d",
            explanation = "Flow-scoped pattern variables are definitely matched on the right side of `&&` (and in the `if` branch), eliminating redundant casts."
        ),
        QuizQuestion(
            id = "jv_f_35",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What methods and fields does `public record Coordinate(int x, int y) {}` automatically generate in Java 16+?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`private final` fields `x` and `y`, a canonical constructor, public accessor methods `x()` and `y()`, and value-based `equals()`, `hashCode()`, and `toString()`."),
                QuestionOption("b", "Mutable getters and setters `getX()`, `setX(int)`, `getY()`, `setY(int)`."),
                QuestionOption("c", "A no-arg default constructor only."),
                QuestionOption("d", "Protected non-final fields.")
            ),
            correctOptionId = "a",
            explanation = "Java `record` classes are transparent immutable data carriers whose accessors are named `x()` and `y()` (without a `get` prefix)."
        ),
        QuizQuestion(
            id = "jv_f_36",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Can a Java `record` extend another class (`extends BaseClass`) or be extended by a subclass?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Yes, a `record` can extend any non-final class."),
                QuestionOption("b", "No: every `record` implicitly extends `java.lang.Record` and is implicitly `final` (though a `record` CAN implement interfaces)."),
                QuestionOption("c", "A `record` can be `abstract` and extended by subclasses."),
                QuestionOption("d", "A `record` cannot implement interfaces.")
            ),
            correctOptionId = "b",
            explanation = "Because Java does not support multiple class inheritance and records implicitly extend `java.lang.Record`, records cannot `extend` another class and are always `final`."
        ),
        QuizQuestion(
            id = "jv_f_37",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a Java constructor, what is the rule for calling `this(...)` (constructor chaining) or `super(...)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both `super(...)` and `this(...)` can be called in the same constructor."),
                QuestionOption("b", "It must be the last statement in the constructor."),
                QuestionOption("c", "It must be the very first statement in the constructor body, and a constructor cannot call both `this(...)` and `super(...)` directly."),
                QuestionOption("d", "`super(...)` can be called inside regular instance methods.")
            ),
            correctOptionId = "c",
            explanation = "Java requires superclass or chained sibling constructor initialization to complete before accessing `this`."
        ),
        QuizQuestion(
            id = "jv_f_38",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between **method overloading** and **method overriding** in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Private and static methods can be overridden."),
                QuestionOption("b", "Overloading requires `@Override` and different return types only."),
                QuestionOption("c", "Overriding is resolved at compile time based on the reference type."),
                QuestionOption("d", "Overloading defines multiple methods with the same name but different parameter lists (resolved at compile time); overriding replaces an inherited superclass method with the same signature (resolved at runtime via dynamic dispatch).")
            ),
            correctOptionId = "d",
            explanation = "Overload resolution uses static compile-time parameter types; method overriding uses the runtime class of the receiver object."
        ),
        QuizQuestion(
            id = "jv_f_39",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Can two methods in the same Java class have the exact same name and parameter types if they differ ONLY in their return type?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "No, the return type is not part of a method signature for overload resolution, so it causes a compile-time error."),
                QuestionOption("b", "Yes, as long as one returns `void`."),
                QuestionOption("c", "Yes, in Java 17+."),
                QuestionOption("d", "Yes, if one is marked `final`.")
            ),
            correctOptionId = "a",
            explanation = "A call like `foo(10);` does not specify a return type at the call site, so Java forbids overloading solely by return type."
        ),
        QuizQuestion(
            id = "jv_f_40",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java overriding, what is a **covariant return type**?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "An overriding method can change a primitive `int` return type to `long`."),
                QuestionOption("b", "An overriding method in a subclass may declare a return type that is a subtype (subclass) of the return type declared in the superclass method."),
                QuestionOption("c", "An overriding method can return a supertype (`Object`) when the parent returns `String`."),
                QuestionOption("d", "An overriding method can accept more specific parameter types.")
            ),
            correctOptionId = "b",
            explanation = "Since Java 5, if `Parent.create()` returns `Number`, `Child.create()` can override it and return `Integer` (a subtype of `Number`)."
        ),
        QuizQuestion(
            id = "jv_f_41",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the visibility rule when overriding a method in a subclass (e.g., overriding a `protected` method)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The overriding method must have the exact same access modifier."),
                QuestionOption("b", "The overriding method can be changed to `private`."),
                QuestionOption("c", "The overriding method cannot have a more restrictive access modifier (so a `protected` method can be overridden as `protected` or `public`, but not package-private or `private`)."),
                QuestionOption("d", "Any method can be narrowed to package-private.")
            ),
            correctOptionId = "c",
            explanation = "By Liskov Substitution, a subclass must remain usable wherever a superclass reference is expected, so visibility can be widened (`protected` -> `public`) but never narrowed."
        ),
        QuizQuestion(
            id = "jv_f_42",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What are the four access levels in Java from most restrictive to least restrictive?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`private`, `internal`, `protected`, `public`."),
                QuestionOption("b", "`private`, `protected`, package-private, `public`."),
                QuestionOption("c", "package-private, `private`, `protected`, `public`."),
                QuestionOption("d", "`private`, package-private (no modifier), `protected`, `public`.")
            ),
            correctOptionId = "d",
            explanation = "`private` is class-only; package-private is package-only; `protected` is package PLUS subclasses in other packages; `public` is everywhere."
        ),
        QuizQuestion(
            id = "jv_f_43",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when `Integer a = null; int b = a;` is executed at runtime?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It throws a `NullPointerException` when attempting to unbox `a` via `a.intValue()`."),
                QuestionOption("b", "It assigns `0` to `b`."),
                QuestionOption("c", "It fails to compile."),
                QuestionOption("d", "It assigns `-1` to `b`.")
            ),
            correctOptionId = "a",
            explanation = "Autounboxing a `null` wrapper reference (`Integer`, `Boolean`, `Double`) invokes `<wrapper>.<prim>Value()` on `null`, throwing `NullPointerException`."
        ),
        QuizQuestion(
            id = "jv_f_44",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `Integer.parseInt(\"42\")` and `Integer.valueOf(\"42\")`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`parseInt` returns an `Integer` object, whereas `valueOf` returns a primitive `int`."),
                QuestionOption("b", "`parseInt` returns a primitive `int`, whereas `valueOf` returns an `Integer` object (using the `Integer` cache for `-128..127`)."),
                QuestionOption("c", "`valueOf` throws `NullPointerException` on valid digits."),
                QuestionOption("d", "There is no difference.")
            ),
            correctOptionId = "b",
            explanation = "`Integer.parseInt(String)` returns primitive `int`; `Integer.valueOf(String)` parses the int and boxes it via `Integer.valueOf(int)`."
        ),
        QuizQuestion(
            id = "jv_f_45",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which exception hierarchy branch in Java consists of **unchecked** exceptions that do NOT need to be declared in a `throws` clause?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "All subclasses of `Throwable`."),
                QuestionOption("b", "`Exception` and `IOException`."),
                QuestionOption("c", "`RuntimeException` and `Error` (and their subclasses)."),
                QuestionOption("d", "`SQLException` and `ClassNotFoundException`.")
            ),
            correctOptionId = "c",
            explanation = "Subclasses of `RuntimeException` and `Error` are unchecked; all other subclasses of `Throwable` (such as `Exception` and `IOException`) are checked."
        ),
        QuizQuestion(
            id = "jv_f_46",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a `multi-catch` block `catch (IOException | SQLException ex)`, what is true about the exception parameter `ex`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Multi-catch only works for unchecked exceptions."),
                QuestionOption("b", "`ex` can be reassigned to `new RuntimeException()`."),
                QuestionOption("c", "`IOException` and `FileNotFoundException` can be combined in `catch (IOException | FileNotFoundException ex)`."),
                QuestionOption("d", "`ex` is implicitly `final` and cannot be reassigned inside the `catch` block, and the caught exception types cannot be subclasses of one another.")
            ),
            correctOptionId = "d",
            explanation = "In a multi-catch clause (`|`), the catch parameter is implicitly `final`, and listing both a superclass and subclass (`IOException | FileNotFoundException`) is a compile-time error."
        ),
        QuizQuestion(
            id = "jv_f_47",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why does `catch (Exception e)` placed BEFORE `catch (IOException e)` on the same `try` statement fail to compile?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `IOException` is a subclass of `Exception`, so the first `catch (Exception e)` catches all `IOException`s, making the second `catch` block unreachable code."),
                QuestionOption("b", "Because `IOException` is an unchecked exception."),
                QuestionOption("c", "Because a `try` statement can have at most one `catch` block."),
                QuestionOption("d", "Because `catch` blocks are evaluated from bottom to top.")
            ),
            correctOptionId = "a",
            explanation = "Java checks `catch` clauses in top-down order and rejects any subsequent `catch` block whose exception type is already handled by an earlier `catch`."
        ),
        QuizQuestion(
            id = "jv_f_48",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What can a Java 8+ `interface` contain that was not allowed in Java 7?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Mutable instance fields (`private int count = 0;`)."),
                QuestionOption("b", "`default` methods with implementations, `static` methods, and (in Java 9+) `private` helper methods."),
                QuestionOption("c", "Public constructors."),
                QuestionOption("d", "`protected` abstract methods.")
            ),
            correctOptionId = "b",
            explanation = "Java 8 added `default` and `static` interface methods, and Java 9 added `private` interface methods to share code between `default` methods; instance fields are still forbidden."
        ),
        QuizQuestion(
            id = "jv_f_49",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What modifiers are implicitly applied to every field declared in a Java `interface` (e.g., `int MAX_RETRIES = 3;`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`protected static`"),
                QuestionOption("b", "`private final`"),
                QuestionOption("c", "`public static final`"),
                QuestionOption("d", "Package-private non-final")
            ),
            correctOptionId = "c",
            explanation = "All fields in a Java interface are implicitly `public static final` constants."
        ),
        QuizQuestion(
            id = "jv_f_50",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If a class implements two interfaces `A` and `B` that both provide a `default void log()` method with the same signature, what happens?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It throws a runtime `IncompatibleClassChangeError` when instantiated."),
                QuestionOption("b", "Java automatically picks `A.log()` because `A` is listed first in `implements A, B`."),
                QuestionOption("c", "Java calls both `A.log()` and `B.log()` in sequence."),
                QuestionOption("d", "The class fails to compile unless it explicitly overrides `log()` (where it can optionally delegate via `A.super.log()` or `B.super.log()`).")
            ),
            correctOptionId = "d",
            explanation = "To avoid ambiguity in multiple inheritance of behavior, the compiler requires the implementing class to resolve conflicting `default` methods explicitly."
        ),
        QuizQuestion(
            id = "jv_f_51",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the output of this `static` vs instance method dispatch snippet?",
            codeSnippet = "class Parent {\n    static String tag() { return \"P\"; }\n    String name() { return \"P\"; }\n}\nclass Child extends Parent {\n    static String tag() { return \"C\"; }\n    @Override String name() { return \"C\"; }\n}\nParent ref = new Child();\nSystem.out.println(ref.tag() + ref.name());",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "PC"),
                QuestionOption("b", "CC"),
                QuestionOption("c", "PP"),
                QuestionOption("d", "CP")
            ),
            correctOptionId = "a",
            explanation = "`static` methods (`tag()`) are hidden, not overridden, and are bound at compile time to the declared reference type (`Parent` -> `\"P\"`), whereas instance methods (`name()`) dispatch dynamically (`Child` -> `\"C\"`)."
        ),
        QuizQuestion(
            id = "jv_f_52",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a Java `enum`, what is the visibility of an enum constructor, and when does it run?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Enum constructors are `public` so callers can create new constants with `new`."),
                QuestionOption("b", "Enum constructors are implicitly `private` (cannot be `public` or `protected`) and run once per enum constant when the enum class is initialized."),
                QuestionOption("c", "Enum constructors cannot accept parameters."),
                QuestionOption("d", "Enum constructors run every time `.values()` is called.")
            ),
            correctOptionId = "b",
            explanation = "Java enums have a fixed set of constants instantiated once at class load time; `public` or `protected` constructors on an `enum` are a compile error."
        ),
        QuizQuestion(
            id = "jv_f_53",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What do `Season.values()` and `Season.valueOf(\"WINTER\")` return for `enum Season { WINTER, SPRING, SUMMER, FALL }`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`valueOf` is case-insensitive."),
                QuestionOption("b", "`values()` returns a `List<Season>`; `valueOf` returns `null` if not found."),
                QuestionOption("c", "`values()` returns a `Season[]` array of all constants in declaration order; `valueOf(\"WINTER\")` returns `Season.WINTER` (or throws `IllegalArgumentException` if no constant matches)."),
                QuestionOption("d", "`values()` returns constants in alphabetical order.")
            ),
            correctOptionId = "c",
            explanation = "The compiler synthesizes `values()` (returning a fresh array in declaration order) and `valueOf(String)` (exact case-sensitive match or `IllegalArgumentException`)."
        ),
        QuizQuestion(
            id = "jv_f_54",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Objects.equals(a, b)` do when `a` is `null` and `b` is `\"hello\"`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It converts `null` to `\"null\"`."),
                QuestionOption("b", "It throws a `NullPointerException`."),
                QuestionOption("c", "It returns `true`."),
                QuestionOption("d", "It safely returns `false` without throwing a `NullPointerException` (and returns `true` if both `a` and `b` are `null`).")
            ),
            correctOptionId = "d",
            explanation = "`Objects.equals(a, b)` evaluates `(a == b) || (a != null && a.equals(b))`, avoiding `NullPointerException` when `a` is `null`."
        ),
        QuizQuestion(
            id = "jv_f_55",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Objects.requireNonNull(arg, \"arg must not be null\")` do?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Returns `arg` if it is non-null, or throws `NullPointerException` with the message `\"arg must not be null\"` if `arg` is `null`."),
                QuestionOption("b", "Returns a default empty object when `arg` is `null`."),
                QuestionOption("c", "Throws `IllegalArgumentException`."),
                QuestionOption("d", "Logs a warning and returns `null`.")
            ),
            correctOptionId = "a",
            explanation = "`Objects.requireNonNull` is the standard fail-fast precondition check for non-null parameters in constructors and methods."
        ),
        QuizQuestion(
            id = "jv_f_56",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java 10+, where is the `var` keyword allowed for local variable type inference?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "For class fields and method parameters."),
                QuestionOption("b", "Only for local variables with an initializer inside methods, constructors, or loops (never for fields, method parameters, or return types)."),
                QuestionOption("c", "For variables initialized to `null` (`var x = null;`)."),
                QuestionOption("d", "For uninitialized variables (`var x;`).")
            ),
            correctOptionId = "b",
            explanation = "`var` infers the static compile-time type from the local variable's non-null initializer and is intentionally disallowed on fields and method signatures."
        ),
        QuizQuestion(
            id = "jv_f_57",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If you write `var count = 10;` in Java 17, can you later assign `count = \"ten\";` in the same method?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Yes, if `count` is not `final`."),
                QuestionOption("b", "Yes, `var` makes the variable dynamically typed like JavaScript `let`."),
                QuestionOption("c", "No: `var` is static compile-time type inference, not dynamic typing; `count` has static type `int`."),
                QuestionOption("d", "Only inside a `switch` block.")
            ),
            correctOptionId = "c",
            explanation = "`var count = 10;` is compiled identically to `int count = 10;`; Java remains strictly statically typed."
        ),
        QuizQuestion(
            id = "jv_f_58",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java 15+ text blocks (`\"\"\" ... \"\"\"`), what must immediately follow the opening `\"\"\"` delimiter?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "An encoding name like `UTF-8`."),
                QuestionOption("b", "The first character of the string on the same line."),
                QuestionOption("c", "A semicolon."),
                QuestionOption("d", "Optional whitespace followed by a mandatory line terminator (newline); content cannot start on the same line as the opening `\"\"\"`.")
            ),
            correctOptionId = "d",
            explanation = "A text block opening `\"\"\"` must be followed by a newline; omitting the newline is a compile-time syntax error."
        )
    )

    private fun foundationBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "jv_f_59",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How do Java 15+ text blocks (`\"\"\" ... \"\"\"`) handle incidental leading indentation across lines?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The compiler automatically strips the common leading whitespace prefix shared by all non-blank lines (and the closing `\"\"\"` position controls minimum stripping)."),
                QuestionOption("b", "All leading whitespace is preserved verbatim from column 0 of the source file."),
                QuestionOption("c", "All whitespace on every line is stripped completely."),
                QuestionOption("d", "Text blocks do not allow indentation.")
            ),
            correctOptionId = "a",
            explanation = "Java text blocks run a compile-time re-indentation algorithm (`String.stripIndent()`) using the leftmost non-blank line or the closing `\"\"\"` delimiter."
        ),
        QuizQuestion(
            id = "jv_f_60",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between a **static nested class** (`static class Node`) and an **inner class** (`class Node` without `static`) in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A static nested class can only contain static fields."),
                QuestionOption("b", "A static nested class does NOT hold an implicit reference to an enclosing outer instance, whereas a non-static inner class holds an implicit `Outer.this` reference and cannot be instantiated without an `Outer` instance."),
                QuestionOption("c", "An inner class cannot access `private` fields of the outer class."),
                QuestionOption("d", "There is no difference.")
            ),
            correctOptionId = "b",
            explanation = "Making a nested class `static` when it doesn't need `Outer.this` avoids hidden outer-instance memory retention."
        ),
        QuizQuestion(
            id = "jv_f_61",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the time complexity of `arrayList.get(index)` vs `linkedList.get(index)` for an index in the middle of an `n`-element list?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both are O(n)."),
                QuestionOption("b", "Both are O(1)."),
                QuestionOption("c", "`ArrayList.get(index)` is O(1) random access, whereas `LinkedList.get(index)` is O(n) because it must traverse nodes from the closer end."),
                QuestionOption("d", "`LinkedList.get(index)` is O(1) and `ArrayList.get(index)` is O(n).")
            ),
            correctOptionId = "c",
            explanation = "`ArrayList` is backed by a contiguous `Object[]` array (O(1) indexing), whereas `LinkedList` is a doubly linked list requiring pointer traversal."
        ),
        QuizQuestion(
            id = "jv_f_62",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when you add a duplicate element to a `HashSet<String>` via `set.add(\"java\")` when `\"java\"` is already present?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It stores both copies."),
                QuestionOption("b", "It throws `IllegalArgumentException`."),
                QuestionOption("c", "It replaces the existing element and returns `true`."),
                QuestionOption("d", "`set.add(\"java\")` returns `false` and leaves the set unchanged without throwing an exception.")
            ),
            correctOptionId = "d",
            explanation = "`Set.add(e)` returns `true` if the set did not already contain `e`, and `false` if an equal element was already present."
        ),
        QuizQuestion(
            id = "jv_f_63",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `map.put(\"k\", 20)` return on a `Map<String, Integer>` if `\"k\"` was previously mapped to `10`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It replaces the value with `20` and returns the **previous** value `10` (or `null` if there was no previous mapping)."),
                QuestionOption("b", "It returns `20`."),
                QuestionOption("c", "It returns `true`."),
                QuestionOption("d", "It leaves the value as `10` and returns `20`.")
            ),
            correctOptionId = "a",
            explanation = "`Map.put(key, value)` associates `key` with `value` and returns the old value previously associated with `key`."
        ),
        QuizQuestion(
            id = "jv_f_64",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How does `map.putIfAbsent(\"k\", 99)` behave if `\"k\"` is already mapped to `10`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It overwrites `\"k\"` with `99` and returns `99`."),
                QuestionOption("b", "It keeps the existing mapping `10` unchanged and returns `10`."),
                QuestionOption("c", "It throws `IllegalStateException`."),
                QuestionOption("d", "It returns `null`.")
            ),
            correctOptionId = "b",
            explanation = "`putIfAbsent` only inserts the new value if the key is currently absent (or mapped to `null`), returning the existing value otherwise."
        ),
        QuizQuestion(
            id = "jv_f_65",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `map.getOrDefault(\"missing\", 0)` do when `\"missing\"` is not in the map?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Throws `NoSuchElementException`."),
                QuestionOption("b", "Inserts `\"missing\" -> 0` into the map and returns `0`."),
                QuestionOption("c", "Returns `0` without modifying the map."),
                QuestionOption("d", "Returns `null`.")
            ),
            correctOptionId = "c",
            explanation = "`Map.getOrDefault` is a pure read operation that returns the fallback value when the key has no mapping."
        ),
        QuizQuestion(
            id = "jv_f_66",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `&` and `&&` when both operands are `boolean` expressions in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "There is no difference on `boolean` operands."),
                QuestionOption("b", "`&` is only valid on integers and fails to compile on `boolean`."),
                QuestionOption("c", "`&&` evaluates both operands in parallel."),
                QuestionOption("d", "`&&` short-circuits (skips evaluating the right operand if the left operand is `false`), whereas `&` on booleans always evaluates BOTH operands before computing the logical AND.")
            ),
            correctOptionId = "d",
            explanation = "In Java, `&` and `|` are defined both as bitwise integer operators and as non-short-circuiting logical boolean operators; `&&` and `||` short-circuit."
        ),
        QuizQuestion(
            id = "jv_f_67",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java, what is the difference between `>>` (signed right shift) and `>>>` (unsigned right shift) on a negative `int` like `-8`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`>>` preserves the sign bit by filling leading bits with `1`s (`-8 >> 1 == -4`), whereas `>>>` fills leading bits with `0`s (`-8 >>> 1 == 2147483644`)."),
                QuestionOption("b", "`>>>` preserves the sign bit and `>>` fills with `0`s."),
                QuestionOption("c", "Both produce `-4`."),
                QuestionOption("d", "`>>>` shifts left instead of right.")
            ),
            correctOptionId = "a",
            explanation = "`>>` performs arithmetic (sign-extending) right shift, while `>>>` performs logical (zero-extending) right shift."
        ),
        QuizQuestion(
            id = "jv_f_68",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When iterating over an array or `Iterable` with `for (String s : list)`, what interface must a custom collection implement to be usable in a `for-each` loop?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`java.util.Iterator<T>`"),
                QuestionOption("b", "`java.lang.Iterable<T>`"),
                QuestionOption("c", "`java.util.RandomAccess`"),
                QuestionOption("d", "`java.io.Serializable`")
            ),
            correctOptionId = "b",
            explanation = "The enhanced `for-each` statement works on any array or any class implementing `java.lang.Iterable<T>` (which provides `iterator()`)."
        ),
        QuizQuestion(
            id = "jv_f_69",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when `System.arraycopy(arr, 0, arr, 1, 3)` is called on the SAME array `arr = {10, 20, 30, 40, 50}`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It throws `ArrayStoreException` because source and destination are the same array."),
                QuestionOption("b", "It overwrites everything with `10` (`{10, 10, 10, 10, 50}`)."),
                QuestionOption("c", "It safely copies `{10, 20, 30}` to indices `1..3` as if through a temporary buffer, resulting in `{10, 10, 20, 30, 50}`."),
                QuestionOption("d", "It reverses the array.")
            ),
            correctOptionId = "c",
            explanation = "`System.arraycopy` handles overlapping source and destination regions within the same array safely without corrupting elements being shifted."
        ),
        QuizQuestion(
            id = "jv_f_70",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What exception is thrown at runtime in this array covariance snippet?",
            codeSnippet = "Object[] items = new String[2];\nitems[0] = \"hello\";\nitems[1] = 42;",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "No exception; `42` is stored as an `Integer`."),
                QuestionOption("b", "`ClassCastException`"),
                QuestionOption("c", "Compile-time error on `items[1] = 42;`"),
                QuestionOption("d", "`ArrayStoreException` (because Java arrays are covariant at compile time but reify their element type `String` at runtime).")
            ),
            correctOptionId = "d",
            explanation = "Java arrays know their runtime component type (`String[]`). Storing an `Integer` into an `Object[]` backed by a `String[]` throws `ArrayStoreException`."
        ),
        QuizQuestion(
            id = "jv_f_71",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the value of `Character.isDigit('7')` and `Character.getNumericValue('7')`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`true` and `7` (whereas `(int) '7'` is the ASCII/UTF-16 code point `55`)."),
                QuestionOption("b", "`true` and `55`"),
                QuestionOption("c", "`false` and `7`"),
                QuestionOption("d", "`7` and `'7'`")
            ),
            correctOptionId = "a",
            explanation = "Casting `'7'` to `int` yields its UTF-16 code unit (`55`); `Character.getNumericValue('7')` or `'7' - '0'` yields `7`."
        ),
        QuizQuestion(
            id = "jv_f_72",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is printed by `System.out.println(1 + 2 + \"3\" + 4 + 5);`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "12345"),
                QuestionOption("b", "3345"),
                QuestionOption("c", "15"),
                QuestionOption("d", "339")
            ),
            correctOptionId = "b",
            explanation = "`+` associates left-to-right: `1 + 2` is integer `3`; `3 + \"3\"` is string `\"33\"`; `\"33\" + 4` is `\"334\"`; `\"334\" + 5` is `\"3345\"`."
        ),
        QuizQuestion(
            id = "jv_f_73",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why can an `abstract` class have a constructor in Java even though it cannot be instantiated directly with `new`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Only `static` constructors are allowed in abstract classes."),
                QuestionOption("b", "Because `abstract` classes CAN be instantiated with `new` inside the same package."),
                QuestionOption("c", "To initialize fields declared in the `abstract` class when a concrete subclass constructor invokes `super(...)`."),
                QuestionOption("d", "The compiler deletes constructors from abstract classes.")
            ),
            correctOptionId = "c",
            explanation = "Concrete subclasses chain to their abstract superclass constructor via `super(...)` to establish superclass invariants and `final` fields."
        ),
        QuizQuestion(
            id = "jv_f_74",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Can a class or method in Java be declared both `abstract` and `final`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Yes, if it is also `private`."),
                QuestionOption("b", "Yes, for singleton classes."),
                QuestionOption("c", "Yes, on `record` classes."),
                QuestionOption("d", "No: `abstract` requires a subclass to extend/override it, whereas `final` forbids subclassing/overriding, so the combination is a compile-time error.")
            ),
            correctOptionId = "d",
            explanation = "`abstract` and `final` have mutually exclusive semantics (similarly, `abstract` cannot be combined with `private` or `static`)."
        ),
        QuizQuestion(
            id = "jv_f_75",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Math.round(-2.5)` return in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`-2L` (because `Math.round(x)` is defined as `floor(x + 0.5)`, rounding `.5` ties toward **positive infinity**)."),
                QuestionOption("b", "`-3L`"),
                QuestionOption("c", "`-2.5`"),
                QuestionOption("d", "`-3`")
            ),
            correctOptionId = "a",
            explanation = "In Java, `Math.round(double)` computes `(long) Math.floor(a + 0.5d)`, so `-2.5 + 0.5 = -2.0`."
        ),
        QuizQuestion(
            id = "jv_f_76",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the result of `Double.isNaN(0.0 / 0.0)` and `(0.0 / 0.0) == Double.NaN` in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`true` and `true`"),
                QuestionOption("b", "`true` and `false` (because `NaN == NaN` is always `false`, so `Double.isNaN(x)` must be used)."),
                QuestionOption("c", "Throws `ArithmeticException: / by zero`."),
                QuestionOption("d", "`false` and `false`")
            ),
            correctOptionId = "b",
            explanation = "Unlike integer `0 / 0` (which throws `ArithmeticException`), floating-point `0.0 / 0.0` evaluates to `Double.NaN`, which is not equal to itself under `==`."
        ),
        QuizQuestion(
            id = "jv_f_77",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens when `1.0 / 0.0` is evaluated in Java vs `1 / 0`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both return `Double.POSITIVE_INFINITY`."),
                QuestionOption("b", "Both throw `ArithmeticException`."),
                QuestionOption("c", "`1.0 / 0.0` evaluates to `Double.POSITIVE_INFINITY` without throwing an exception, whereas integer `1 / 0` throws `ArithmeticException`."),
                QuestionOption("d", "`1.0 / 0.0` returns `0.0`.")
            ),
            correctOptionId = "c",
            explanation = "IEEE 754 floating-point division by `0.0` produces `+Infinity`, `-Infinity`, or `NaN`, whereas integer division by `0` throws `ArithmeticException`."
        ),
        QuizQuestion(
            id = "jv_f_78",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java, when does an instance initializer block `{ ... }` inside a class body run relative to constructors?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Only when no constructor is defined."),
                QuestionOption("b", "Once when the class is loaded, before `static` blocks."),
                QuestionOption("c", "After the constructor body finishes."),
                QuestionOption("d", "Inside each constructor, immediately after the `super(...)` call finishes and before the rest of the constructor body runs.")
            ),
            correctOptionId = "d",
            explanation = "The compiler copies instance initializer blocks and field initializers into every constructor right after `super(...)`."
        ),
        QuizQuestion(
            id = "jv_f_79",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When does a `static { ... }` initializer block run in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Exactly once when the class is initialized by the JVM (before the first active use of the class)."),
                QuestionOption("b", "Every time `new MyClass()` is called."),
                QuestionOption("c", "When the object is garbage-collected."),
                QuestionOption("d", "Only when `main()` exits.")
            ),
            correctOptionId = "a",
            explanation = "Class initialization (`<clinit>`) executes `static` field initializers and `static {}` blocks in top-to-bottom source order once per class loader."
        ),
        QuizQuestion(
            id = "jv_f_80",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `String.format(\"%04d-%s\", 7, \"A\")` (or `\"%04d-%s\".formatted(7, \"A\")` in Java 15+) return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "\"7000-A\""),
                QuestionOption("b", "\"0007-A\""),
                QuestionOption("c", "\"   7-A\""),
                QuestionOption("d", "\"04d-A\"")
            ),
            correctOptionId = "b",
            explanation = "`%04d` formats the integer with leading zeros to width 4 (`0007`), and `String.formatted(...)` in Java 15+ is the convenient instance method equivalent."
        ),
        QuizQuestion(
            id = "jv_f_81",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `String s = \"a.b.c\";`, why does `s.split(\".\")` return an empty array `[]` instead of `[\"a\", \"b\", \"c\"]`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `.` is only split from the right."),
                QuestionOption("b", "Because `split` only splits on spaces."),
                QuestionOption("c", "Because `String.split(regex)` takes a **regular expression** where `.` matches ANY character; it must be escaped as `s.split(\"\\\\.\")` or `s.split(Pattern.quote(\".\"))`."),
                QuestionOption("d", "`s.split(\".\")` does return `[\"a\", \"b\", \"c\"]`.")
            ),
            correctOptionId = "c",
            explanation = "In regex, unescaped `.` matches every character in `\"a.b.c\"`, and `split` discards trailing empty strings by default, leaving an empty array `[]`."
        ),
        QuizQuestion(
            id = "jv_f_82",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `\"a,,b,\".split(\",\", -1)` return compared to `\"a,,b,\".split(\",\")`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`split(\",\", -1)` throws `IllegalArgumentException`."),
                QuestionOption("b", "Both return `[\"a\", \"b\"]`."),
                QuestionOption("c", "`split(\",\", -1)` reverses the array."),
                QuestionOption("d", "`split(\",\", -1)` preserves trailing empty strings (`[\"a\", \"\", \"b\", \"\"]`), whereas `split(\",\")` (limit `0`) discards trailing empty strings (`[\"a\", \"\", \"b\"]`).")
            ),
            correctOptionId = "d",
            explanation = "Passing a negative `limit` to `String.split(regex, limit)` applies the pattern as many times as possible and retains trailing empty strings."
        ),
        QuizQuestion(
            id = "jv_f_83",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java, what is the difference between `ClassNotFoundException` and `NoClassDefFoundError`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`ClassNotFoundException` is a checked `Exception` thrown when reflective loading (`Class.forName`) fails to find a class; `NoClassDefFoundError` is an `Error` thrown when the JVM cannot find a class that was present at compile time (or whose `static` initialization previously failed)."),
                QuestionOption("b", "They are identical checked exceptions."),
                QuestionOption("c", "`NoClassDefFoundError` is thrown by `Class.forName`."),
                QuestionOption("d", "`ClassNotFoundException` is an unchecked `Error`.")
            ),
            correctOptionId = "a",
            explanation = "`ClassNotFoundException` comes from explicit reflective lookup by string name; `NoClassDefFoundError` is a JVM linkage error."
        ),
        QuizQuestion(
            id = "jv_f_84",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If a `static {}` initializer block throws an uncaught `RuntimeException` on the first attempt to use class `Config`, what happens on the SECOND attempt to reference `Config`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The JVM re-runs the `static {}` block on the second attempt."),
                QuestionOption("b", "The first attempt throws `ExceptionInInitializerError`, and the JVM marks `Config` as erroneous so the second attempt immediately throws `NoClassDefFoundError: Could not initialize class Config`."),
                QuestionOption("c", "The second attempt succeeds with default values."),
                QuestionOption("d", "The JVM terminates the process.")
            ),
            correctOptionId = "b",
            explanation = "Per the JVM Specification, once `<clinit>` fails with `ExceptionInInitializerError`, the class is permanently marked unusable and subsequent uses throw `NoClassDefFoundError`."
        ),
        QuizQuestion(
            id = "jv_f_85",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java 7+, what numeric literal feature improves readability of large numbers like `1_000_000`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Spaces `1 000 000` are allowed inside numbers."),
                QuestionOption("b", "Commas `1,000,000` are allowed in numeric literals."),
                QuestionOption("c", "Underscores `_` are allowed between digits in numeric literals (`1_000_000`, `0b1010_0001`), but not at the very beginning/end or adjacent to a decimal point."),
                QuestionOption("d", "Single quotes `1'000'000` are used.")
            ),
            correctOptionId = "c",
            explanation = "Java allows `_` strictly between digits in integer and floating-point literals."
        ),
        QuizQuestion(
            id = "jv_f_86",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Collections.frequency(List.of(\"a\", \"b\", \"a\", \"c\"), \"a\")` return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "true"),
                QuestionOption("b", "1"),
                QuestionOption("c", "4"),
                QuestionOption("d", "2")
            ),
            correctOptionId = "d",
            explanation = "`Collections.frequency(collection, obj)` counts how many elements in the collection are equal to `obj`."
        ),
        QuizQuestion(
            id = "jv_f_87",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Collections.disjoint(listA, listB)` return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`true` if `listA` and `listB` have NO elements in common, or `false` if they share at least one element."),
                QuestionOption("b", "`true` if the two collections are equal."),
                QuestionOption("c", "A new collection containing the intersection."),
                QuestionOption("d", "The number of shared elements.")
            ),
            correctOptionId = "a",
            explanation = "`Collections.disjoint(c1, c2)` returns `true` when the intersection of the two collections is empty."
        ),
        QuizQuestion(
            id = "jv_f_88",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How do you obtain an immutable empty list in Java without allocating a new object every time?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`new ArrayList<>(0)`"),
                QuestionOption("b", "`Collections.emptyList()` or `List.of()`"),
                QuestionOption("c", "`Arrays.asList(null)`"),
                QuestionOption("d", "`List.copyOf(null)`")
            ),
            correctOptionId = "b",
            explanation = "Both `Collections.emptyList()` and `List.of()` return shared, immutable, zero-allocation singleton instances."
        ),
        QuizQuestion(
            id = "jv_f_89",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When using `Iterator<String> it = list.iterator();`, how do you safely remove the current element during iteration without throwing `ConcurrentModificationException`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Call `it.delete()`."),
                QuestionOption("b", "Call `list.remove(elem)` inside a `for (String elem : list)` loop."),
                QuestionOption("c", "Call `it.remove()` (after `it.next()`), or use `list.removeIf(predicate)`."),
                QuestionOption("d", "Set `elem = null`.")
            ),
            correctOptionId = "c",
            explanation = "Calling `list.remove(...)` directly while an iterator is active invalidates `expectedModCount` and throws `ConcurrentModificationException`; `it.remove()` updates `expectedModCount`."
        ),
        QuizQuestion(
            id = "jv_f_90",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `list.removeIf(s -> s.startsWith(\"tmp_\"))` do on a mutable `ArrayList<String>`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Removes only the first matching element."),
                QuestionOption("b", "Returns a new filtered list without modifying `list`."),
                QuestionOption("c", "Throws `UnsupportedOperationException` on `ArrayList`."),
                QuestionOption("d", "Removes all elements matching the predicate in place and returns `true` if any elements were removed.")
            ),
            correctOptionId = "d",
            explanation = "`Collection.removeIf(Predicate)` (Java 8+) removes all matching elements in place in a single O(n) pass on `ArrayList`."
        ),
        QuizQuestion(
            id = "jv_f_91",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In `ArrayList<Integer> nums = new ArrayList<>(List.of(10, 20, 30));`, what is the difference between `nums.remove(1)` and `nums.remove(Integer.valueOf(10))`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`nums.remove(1)` calls `remove(int index)` and removes element `20` at index 1; `nums.remove(Integer.valueOf(10))` calls `remove(Object)` and removes the value `10`."),
                QuestionOption("b", "Both remove the value `1`."),
                QuestionOption("c", "`nums.remove(1)` throws `IndexOutOfBoundsException`."),
                QuestionOption("d", "Both remove the element at index 1.")
            ),
            correctOptionId = "a",
            explanation = "`List<E>` has two overloaded `remove` methods: `remove(int index)` and `remove(Object o)`. With `E = Integer`, passing a primitive `int` invokes `remove(int index)`."
        ),
        QuizQuestion(
            id = "jv_f_92",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `String.valueOf((Object) null)` return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`null`"),
                QuestionOption("b", "The 4-character string `\"null\"` (without throwing `NullPointerException`)."),
                QuestionOption("c", "`\"\"` (empty string)"),
                QuestionOption("d", "Throws `NullPointerException`")
            ),
            correctOptionId = "b",
            explanation = "`String.valueOf(Object obj)` returns `(obj == null) ? \"null\" : obj.toString()`. (Caution: `String.valueOf(null)` without a cast resolves to `String.valueOf(char[])` and throws `NPE`!)"
        ),
        QuizQuestion(
            id = "jv_f_93",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Wait—why does `String.valueOf(null)` (with a literal `null` and no cast) throw a `NullPointerException`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `null` is a primitive."),
                QuestionOption("b", "Because `String.valueOf` never accepts `null`."),
                QuestionOption("c", "Overload resolution picks the more specific `String.valueOf(char[] data)` over `String.valueOf(Object obj)`, and `new String((char[]) null)` throws `NullPointerException`."),
                QuestionOption("d", "It does not throw an exception.")
            ),
            correctOptionId = "c",
            explanation = "Between `valueOf(Object)` and `valueOf(char[])`, `char[]` is a subtype of `Object`, so Java selects the most specific overload `valueOf(char[])`, which dereferences the null `char[]`."
        ),
        QuizQuestion(
            id = "jv_f_94",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `Integer.compare(x, y)` avoid that a naive comparator `return x - y;` suffers from?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Division by zero."),
                QuestionOption("b", "Autoboxing overhead."),
                QuestionOption("c", "Floating-point rounding."),
                QuestionOption("d", "Signed integer overflow when `x` and `y` have opposite signs and large magnitudes (e.g., `Integer.MIN_VALUE - 10` overflows to a positive number).")
            ),
            correctOptionId = "d",
            explanation = "`x - y` can overflow 32-bit signed `int` (`Integer.MIN_VALUE - 1 == Integer.MAX_VALUE > 0`), breaking transitivity in sorting; `Integer.compare(x, y)` compares without subtraction."
        ),
        QuizQuestion(
            id = "jv_f_95",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens if a `Comparator` returns inconsistent results or violates transitivity when passed to `List.sort` / `Collections.sort` (TimSort)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "TimSort can throw `IllegalArgumentException: Comparison method violates its general contract!` or produce an improperly sorted list."),
                QuestionOption("b", "TimSort ignores the comparator and sorts by memory address."),
                QuestionOption("c", "The JVM crashes with a segmentation fault."),
                QuestionOption("d", "Nothing; any comparator works.")
            ),
            correctOptionId = "a",
            explanation = "Java's TimSort verifies comparator invariants during merge steps and throws `IllegalArgumentException` if a comparator violates reflexivity, antisymmetry, or transitivity."
        ),
        QuizQuestion(
            id = "jv_f_96",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java, are method arguments passed by value or passed by reference?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Objects are passed by reference so reassigning `param = new Obj()` changes the caller's variable."),
                QuestionOption("b", "Always **pass-by-value**: for primitives, the primitive value is copied; for objects, the object reference (pointer) value is copied, so reassigning the parameter inside the method never rebinds the caller's variable."),
                QuestionOption("c", "Primitives are passed by reference."),
                QuestionOption("d", "`String` is passed by value and all other objects are passed by reference.")
            ),
            correctOptionId = "b",
            explanation = "Java strictly passes arguments by value. Mutating an object through the copied reference (`list.add(1)`) is visible to the caller, but rebinding `list = new ArrayList<>()` only changes the local parameter."
        ),
        QuizQuestion(
            id = "jv_f_97",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `@Override` do when placed on a method in a Java class?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Makes the method `public` automatically."),
                QuestionOption("b", "Enables dynamic dispatch at runtime (without `@Override`, methods are static)."),
                QuestionOption("c", "Instructs the compiler to verify that the method actually overrides a superclass method or implements an interface method, catching signature typos at compile time."),
                QuestionOption("d", "Allows changing parameter types while still overriding.")
            ),
            correctOptionId = "c",
            explanation = "`@Override` (`@Retention(RetentionPolicy.SOURCE)`) is a compile-time safety check that prevents accidental overloading when overriding was intended."
        ),
        QuizQuestion(
            id = "jv_f_98",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java, what is the superclass of every class that does not explicitly declare `extends ...`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "There is no superclass."),
                QuestionOption("b", "`java.lang.Class`"),
                QuestionOption("c", "`java.lang.Record`"),
                QuestionOption("d", "`java.lang.Object`")
            ),
            correctOptionId = "d",
            explanation = "`java.lang.Object` is the root of the Java class hierarchy."
        ),
        QuizQuestion(
            id = "jv_f_99",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `obj.getClass()` return at runtime for `Number obj = Integer.valueOf(5);`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Integer.class` (the runtime `Class<?>` of the actual instance, not the declared variable type `Number.class`)."),
                QuestionOption("b", "`Number.class`"),
                QuestionOption("c", "`int.class`"),
                QuestionOption("d", "`Object.class`")
            ),
            correctOptionId = "a",
            explanation = "`Object.getClass()` is a `final` method returning the runtime `Class` object representing the concrete class of the instance (`java.lang.Integer`)."
        ),
        QuizQuestion(
            id = "jv_f_100",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How do `int.class` and `Integer.class` relate to `Integer.TYPE`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`int.class == Integer.class` is `true`."),
                QuestionOption("b", "`int.class == Integer.TYPE` is `true` (representing the primitive type `int`), and both are distinct from `Integer.class` (the wrapper class)."),
                QuestionOption("c", "`int.class` is a syntax error."),
                QuestionOption("d", "`Integer.TYPE` is `String.class`.")
            ),
            correctOptionId = "b",
            explanation = "`int.class` (and `Integer.TYPE`) is the `Class<Integer>` instance representing the primitive type `int`, distinct from `Integer.class`."
        )
    )

    private fun appliedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "jv_a_16",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the contract between `equals(Object)` and `hashCode()` in Java, and what happens in a `HashMap` if two equal keys have different hash codes?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "If `a.hashCode() == b.hashCode()`, then `a.equals(b)` must be `true`."),
                QuestionOption("b", "If `a.equals(b)` is `true`, then `a.hashCode() == b.hashCode()` MUST hold; violating this causes `HashMap` to look in the wrong hash bucket so `map.get(b)` can return `null` even after `map.put(a, val)`."),
                QuestionOption("c", "`HashMap` ignores `hashCode()` and scans all entries with `equals()`."),
                QuestionOption("d", "Violating the contract throws a compile-time error.")
            ),
            correctOptionId = "b",
            explanation = "`HashMap` first selects the bucket using `key.hashCode()` and then compares keys in that bucket using `equals()`. Equal objects with different hash codes land in different buckets."
        ),
        QuizQuestion(
            id = "jv_a_17",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 8+ `HashMap`, how are hash collisions within a single bucket handled when the bucket size exceeds `TREEIFY_THRESHOLD` (8) and the table capacity is at least `MIN_TREEIFY_CAPACITY` (64)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "New keys colliding in that bucket overwrite the last entry."),
                QuestionOption("b", "The `HashMap` throws an `OutOfMemoryError`."),
                QuestionOption("c", "The bucket's linked list is converted into a balanced Red-Black Tree (`TreeNode`), improving worst-case bucket lookup from O(n) to O(log n)."),
                QuestionOption("d", "The bucket is converted into an `ArrayList`.")
            ),
            correctOptionId = "c",
            explanation = "Treeification protects `HashMap` against hash-collision denial-of-service degradation, guaranteeing O(log n) worst-case lookup when keys are comparable or tie-broken."
        ),
        QuizQuestion(
            id = "jv_a_18",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is mutating a field of an object AFTER inserting that object as a key in a `HashSet` or `HashMap` dangerous if the field participates in `hashCode()` and `equals()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It only affects `TreeMap`, not `HashMap`."),
                QuestionOption("b", "`HashMap` automatically rehashes all keys whenever any object field changes."),
                QuestionOption("c", "Mutating a key object throws `ConcurrentModificationException`."),
                QuestionOption("d", "The entry remains stored in the bucket calculated from its old `hashCode()`, so subsequent `contains(key)` or `get(key)` calls compute the new hash code, probe a different bucket, and fail to find the entry.")
            ),
            correctOptionId = "d",
            explanation = "`HashMap` does not observe internal mutations of key objects; changing a key's hash code after insertion orphans the entry in its original bucket."
        ),
        QuizQuestion(
            id = "jv_a_19",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can `LinkedHashMap` be configured to act as an **LRU (Least Recently Used) cache** with a fixed maximum capacity?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Use the constructor `new LinkedHashMap<>(capacity, loadFactor, true)` (`accessOrder = true`) and override `removeEldestEntry(Map.Entry<K,V> eldest)` to return `size() > maxEntries`."),
                QuestionOption("b", "Pass `lru = true` to `new HashMap<>()`."),
                QuestionOption("c", "Use `TreeMap` with `Comparator.naturalOrder()`."),
                QuestionOption("d", "`LinkedHashMap` only supports insertion order, never access order.")
            ),
            correctOptionId = "a",
            explanation = "With `accessOrder = true`, `get` and `put` move the accessed entry to the end of the doubly linked list, and `removeEldestEntry` evicts the least-recently accessed head entry."
        ),
        QuizQuestion(
            id = "jv_a_20",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `TreeMap` and `TreeSet`, how is key uniqueness/membership determined when a custom `Comparator` is supplied?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "By calling `hashCode()` and `equals()`."),
                QuestionOption("b", " Exclusively by `comparator.compare(k1, k2) == 0` (NOT by `k1.equals(k2)`!)."),
                QuestionOption("c", "By checking reference identity `k1 == k2`."),
                QuestionOption("d", "By requiring both `compare == 0` and `equals == true`.")
            ),
            correctOptionId = "b",
            explanation = "Sorted collections (`TreeMap`/`TreeSet`) rely solely on `compareTo` / `compare` returning `0` to treat two elements as duplicates."
        ),
        QuizQuestion(
            id = "jv_a_21",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by this `TreeSet` with a case-insensitive comparator?",
            codeSnippet = "Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);\nset.add(\"Java\");\nset.add(\"JAVA\");\nSystem.out.println(set);",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "[JAVA]"),
                QuestionOption("b", "[Java, JAVA]"),
                QuestionOption("c", "[Java]"),
                QuestionOption("d", "Throws IllegalArgumentException")
            ),
            correctOptionId = "c",
            explanation = "Because `String.CASE_INSENSITIVE_ORDER.compare(\"Java\", \"JAVA\") == 0`, `TreeSet` considers `\"JAVA\"` a duplicate of `\"Java\"` and retains the original element."
        ),
        QuizQuestion(
            id = "jv_a_22",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java's `PriorityQueue<Integer> pq = new PriorityQueue<>();`, which element is returned by `pq.poll()` by default?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The element that was inserted most recently (LIFO)."),
                QuestionOption("b", "The **largest** integer (a max-heap)."),
                QuestionOption("c", "The element that was inserted first (FIFO)."),
                QuestionOption("d", "The **smallest** integer (natural ascending order, i.e., a min-heap).")
            ),
            correctOptionId = "d",
            explanation = "`PriorityQueue` is a binary min-heap ordered by natural ordering (`Comparable`) unless a custom `Comparator` (such as `Comparator.reverseOrder()`) is provided."
        ),
        QuizQuestion(
            id = "jv_a_23",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Does iterating over a `PriorityQueue` with `for (int x : pq)` yield elements in sorted order?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "No: the `PriorityQueue` iterator traverses the internal heap array in arbitrary heap order; only repeated `pq.poll()` removes elements in sorted priority order."),
                QuestionOption("b", "Yes, the iterator always yields elements in ascending sorted order."),
                QuestionOption("c", "It yields elements in reverse sorted order."),
                QuestionOption("d", "`PriorityQueue` does not implement `Iterable`.")
            ),
            correctOptionId = "a",
            explanation = "A binary heap only guarantees the heap property (`parent <= children`) with the minimum at index 0; array iteration order is not sorted."
        ),
        QuizQuestion(
            id = "jv_a_24",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `ArrayDeque<E>` generally preferred over `java.util.Stack<E>` and `LinkedList<E>` for stack (`push`/`pop`) and queue (`offer`/`poll`) operations?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Stack` is an interface and cannot be instantiated."),
                QuestionOption("b", "`ArrayDeque` uses a contiguous resizable circular array with better CPU cache locality, no per-node object allocation overhead, and no legacy `Vector` synchronization overhead."),
                QuestionOption("c", "`ArrayDeque` allows `null` elements whereas `LinkedList` does not."),
                QuestionOption("d", "`ArrayDeque` is thread-safe.")
            ),
            correctOptionId = "b",
            explanation = "`java.util.Stack` extends synchronized `Vector`, and `LinkedList` allocates a `Node` object per element; `ArrayDeque` is faster and more memory-efficient for both LIFO and FIFO."
        ),
        QuizQuestion(
            id = "jv_a_25",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens if you pass `null` to `arrayDeque.offer(null)` or `priorityQueue.offer(null)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`ArrayDeque` allows `null` and `PriorityQueue` throws `NPE`."),
                QuestionOption("b", "Both insert `null` at the head."),
                QuestionOption("c", "Both throw `NullPointerException` because `ArrayDeque` and `PriorityQueue` forbid `null` elements (since `poll()` uses `null` to indicate an empty queue)."),
                QuestionOption("d", "Both return `false` without throwing.")
            ),
            correctOptionId = "c",
            explanation = "Most `Queue`/`Deque` implementations (except `LinkedList`) disallow `null` because `poll()` and `peek()` return `null` when the queue is empty."
        ),
        QuizQuestion(
            id = "jv_a_26",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between `Collections.unmodifiableList(mutableList)` and `List.copyOf(mutableList)` (Java 10+)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Collections.unmodifiableList` forbids `null` elements."),
                QuestionOption("b", "Both make a deep copy of `mutableList`."),
                QuestionOption("c", "`List.copyOf` reflects subsequent changes to `mutableList`."),
                QuestionOption("d", "`Collections.unmodifiableList` returns a read-only **view** that still reflects subsequent mutations made directly to `mutableList`, whereas `List.copyOf` takes an independent immutable snapshot.")
            ),
            correctOptionId = "d",
            explanation = "Mutating `mutableList.add(x)` after calling `Collections.unmodifiableList(mutableList)` changes the contents visible through the unmodifiable wrapper; `List.copyOf` copies the elements into an immutable list."
        ),
        QuizQuestion(
            id = "jv_a_27",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In the Java Stream API, why does this code print nothing?",
            codeSnippet = "Stream.of(\"a\", \"b\", \"c\")\n    .filter(s -> {\n        System.out.print(s);\n        return true;\n    });",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Intermediate stream operations (`filter`, `map`, `sorted`, `peek`) are **lazy** and do not execute until a terminal operation (like `toList()`, `count()`, or `forEach()`) is invoked."),
                QuestionOption("b", "Because `filter` runs on a background daemon thread."),
                QuestionOption("c", "Because `return true` skips printing."),
                QuestionOption("d", "Because `Stream.of` creates an empty stream.")
            ),
            correctOptionId = "a",
            explanation = "Java Streams build a lazy pipeline; without a terminal operation, intermediate stages are never evaluated."
        ),
        QuizQuestion(
            id = "jv_a_28",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens if you call two terminal operations on the same `Stream` variable (`s.count(); s.toList();`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both operations succeed and reuse the cached elements."),
                QuestionOption("b", "The second terminal operation throws `IllegalStateException: stream has already been operated upon or closed`."),
                QuestionOption("c", "The second operation returns an empty list."),
                QuestionOption("d", "It fails to compile.")
            ),
            correctOptionId = "b",
            explanation = "A `Stream` is a single-use pipeline and cannot be traversed or operated on a second time after a terminal operation."
        ),
        QuizQuestion(
            id = "jv_a_29",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between `Stream.map(...)` and `Stream.flatMap(...)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`map` flattens nested lists automatically."),
                QuestionOption("b", "`flatMap` only works on primitive `int[]` arrays."),
                QuestionOption("c", "`map` transforms each element `T` into a single output element `R` (1-to-1), whereas `flatMap` transforms each element `T` into a `Stream<R>` and flattens all resulting streams into one `Stream<R>` (1-to-many)."),
                QuestionOption("d", "`flatMap` sorts the output stream.")
            ),
            correctOptionId = "c",
            explanation = "`flatMap(Function<T, Stream<R>>)` maps each item to a stream of zero or more items and concatenates them into a single flat stream."
        ),
        QuizQuestion(
            id = "jv_a_30",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `Collectors.toMap(User::role, User::name)` encounters two users with the same `role` key without a merge function?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It drops the duplicate entry."),
                QuestionOption("b", "It silently overwrites the first value with the second."),
                QuestionOption("c", "It collects values into a `List` automatically."),
                QuestionOption("d", "It throws `IllegalStateException: Duplicate key ...` (to handle duplicates, a 3rd merge-function argument `(oldVal, newVal) -> newVal` must be supplied).")
            ),
            correctOptionId = "d",
            explanation = "Unlike `Map.put`, two-argument `Collectors.toMap(keyMapper, valueMapper)` throws `IllegalStateException` on key collision unless a `BinaryOperator<U> mergeFunction` is passed."
        ),
        QuizQuestion(
            id = "jv_a_31",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do `Collectors.groupingBy(predicate)` and `Collectors.partitioningBy(predicate)` differ when given a `Predicate<T>`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`partitioningBy` ALWAYS returns a `Map<Boolean, List<T>>` containing both `true` and `false` keys (even if one list is empty), whereas `groupingBy` only creates keys for values actually present in the stream."),
                QuestionOption("b", "`groupingBy` always includes missing keys with empty lists."),
                QuestionOption("c", "`partitioningBy` returns a `Set<T>`."),
                QuestionOption("d", "They return identical maps even on an empty stream.")
            ),
            correctOptionId = "a",
            explanation = "Even on an empty stream, `Collectors.partitioningBy(pred)` guarantees `{false=[], true=[]}` is present in the returned map."
        ),
        QuizQuestion(
            id = "jv_a_32",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 16+, how does `stream.toList()` differ from `stream.collect(Collectors.toList())`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`stream.toList()` returns a mutable `LinkedList`."),
                QuestionOption("b", "`stream.toList()` returns an **unmodifiable** `List` (and allows `null` elements), whereas `Collectors.toList()` returns a mutable `ArrayList` in standard JDK implementations."),
                QuestionOption("c", "`stream.toList()` forbids `null` elements like `List.of()`."),
                QuestionOption("d", "They are completely identical.")
            ),
            correctOptionId = "b",
            explanation = "`Stream.toList()` (added in Java 16) produces an unmodifiable list directly with less allocation overhead."
        ),
        QuizQuestion(
            id = "jv_a_33",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the subtle difference between `optional.orElse(computeDefault())` and `optional.orElseGet(() -> computeDefault())`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`orElseGet` throws `NoSuchElementException` if the `Optional` is empty."),
                QuestionOption("b", "`orElse` is lazy and `orElseGet` is eager."),
                QuestionOption("c", "`orElse(computeDefault())` EAGERLY evaluates `computeDefault()` even when the `Optional` is non-empty, whereas `orElseGet(Supplier)` invokes `computeDefault()` LAZILY only when the `Optional` is empty."),
                QuestionOption("d", "There is no runtime difference.")
            ),
            correctOptionId = "c",
            explanation = "Because Java evaluates method arguments before calling `orElse(...)`, passing a method call to `orElse` runs that method unconditionally on every call!"
        ),
        QuizQuestion(
            id = "jv_a_34",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `Optional.of(null)` do compared to `Optional.ofNullable(null)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Optional.of(null)` wraps `null` inside a non-empty `Optional`."),
                QuestionOption("b", "Both return `Optional.empty()`."),
                QuestionOption("c", "Both throw `NullPointerException`."),
                QuestionOption("d", "`Optional.of(null)` immediately throws `NullPointerException`, whereas `Optional.ofNullable(null)` returns `Optional.empty()`.")
            ),
            correctOptionId = "d",
            explanation = "`Optional.of` requires a non-null value; `Optional.ofNullable` translates `null` into `Optional.empty()`."
        ),
        QuizQuestion(
            id = "jv_a_35",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "If `Function<User, Optional<String>> getEmail` returns an `Optional<String>`, why should `optUser.flatMap(getEmail)` be used instead of `optUser.map(getEmail)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`optUser.map(getEmail)` produces a nested `Optional<Optional<String>>`, whereas `optUser.flatMap(getEmail)` flattens it to a single `Optional<String>`."),
                QuestionOption("b", "`map` throws `NullPointerException` when `getEmail` returns `Optional.empty()`."),
                QuestionOption("c", "`flatMap` only works on `Stream`, not `Optional`."),
                QuestionOption("d", "Both return `Optional<String>`.")
            ),
            correctOptionId = "a",
            explanation = "`Optional.flatMap` avoids nested `Optional<Optional<T>>` wrappers when the mapping function itself returns an `Optional`."
        ),
        QuizQuestion(
            id = "jv_a_36",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java Generics, why is `List<Integer>` NOT a subtype of `List<Number>` even though `Integer` is a subtype of `Number`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `Integer` does not extend `Number`."),
                QuestionOption("b", "Generic types are **invariant**: if `List<Integer>` were assignable to `List<Number> nums`, callers could execute `nums.add(3.14)` (`Double`), corrupting the `List<Integer>` with a non-`Integer`."),
                QuestionOption("c", "Because `List` only supports `String`."),
                QuestionOption("d", "`List<Integer>` IS a subtype of `List<Number>`.")
            ),
            correctOptionId = "b",
            explanation = "Invariance of `List<T>` preserves compile-time type safety for mutable generic containers; covariance requires bounded wildcards `List<? extends Number>`."
        ),
        QuizQuestion(
            id = "jv_a_37",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "According to the **PECS** rule (*Producer Extends, Consumer Super*), what can you safely read from and write to a `List<? extends Number> nums`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "You can only read as `Object`."),
                QuestionOption("b", "You can `add(42)` (`Integer`) and `add(3.14)` (`Double`), and read as `Object`."),
                QuestionOption("c", "You can safely **read** elements as `Number`, but you CANNOT `add` any element (except `null`) because the runtime list could be `List<Integer>`, `List<Double>`, or `List<Long>`."),
                QuestionOption("d", "You can `add` any `Number`.")
            ),
            correctOptionId = "c",
            explanation = "An upper-bounded wildcard `? extends Number` is a covariance **producer**: elements out are guaranteed to be `Number`, while writes in are rejected."
        ),
        QuizQuestion(
            id = "jv_a_38",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Conversely, under **PECS** (*Consumer Super*), what can you safely write to and read from a `List<? super Integer> sink`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "You cannot `add` `Integer` into `sink`."),
                QuestionOption("b", "You can read elements as `Integer` without casting."),
                QuestionOption("c", "You can `add(new Object())` into `sink`."),
                QuestionOption("d", "You can safely `add` `Integer` instances into `sink`, while reading from `sink.get(i)` only guarantees type `Object` (since `sink` could be `List<Integer>`, `List<Number>`, or `List<Object>`).")
            ),
            correctOptionId = "d",
            explanation = "A lower-bounded wildcard `? super Integer` is a contravariance **consumer**: it safely accepts `Integer` inputs, while outputs are typed as `Object`."
        ),
        QuizQuestion(
            id = "jv_a_39",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Due to **type erasure** in Java generics, what does `new ArrayList<String>().getClass() == new ArrayList<Integer>().getClass()` evaluate to at runtime?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`true` (both erase to the raw runtime class `ArrayList.class`)."),
                QuestionOption("b", "`false`"),
                QuestionOption("c", "Compile-time error."),
                QuestionOption("d", "Throws `ClassCastException`.")
            ),
            correctOptionId = "a",
            explanation = "Java erases generic type arguments at compile time, so all instantiations of `ArrayList<T>` share a single `ArrayList.class` at runtime."
        ),
        QuizQuestion(
            id = "jv_a_40",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a `try-with-resources` statement `try (ResA a = new ResA(); ResB b = new ResB()) { ... }`, in what order are `a.close()` and `b.close()` called when exiting the `try` block?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "In declaration order: `a.close()` then `b.close()`."),
                QuestionOption("b", "In **reverse** order of declaration: `b.close()` is called first, followed by `a.close()`."),
                QuestionOption("c", "In parallel on separate threads."),
                QuestionOption("d", "Only `b.close()` is called.")
            ),
            correctOptionId = "b",
            explanation = "Because later resources (`b`) often wrap or depend on earlier resources (`a`), `try-with-resources` closes resources in reverse declaration order (LIFO)."
        ),
        QuizQuestion(
            id = "jv_a_41",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `try-with-resources`, if BOTH the `try` body throws `PrimaryException` AND `resource.close()` throws `CloseException`, which exception is propagated to the caller and what happens to the other?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both exceptions are discarded."),
                QuestionOption("b", "`CloseException` overwrites `PrimaryException` and `PrimaryException` is lost."),
                QuestionOption("c", "`PrimaryException` is thrown to the caller, and `CloseException` is attached to it as a **suppressed exception** retrievable via `primaryEx.getSuppressed()`."),
                QuestionOption("d", "The JVM wraps both in a `CompositeException`.")
            ),
            correctOptionId = "c",
            explanation = "Unlike a manual `finally` block (where an exception in `close()` overwrites the primary exception), `try-with-resources` preserves the primary exception and attaches `close()` failures via `Throwable.addSuppressed`."
        ),
        QuizQuestion(
            id = "jv_a_42",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `java.time` (Java 8+), what is the difference between `Duration` and `Period`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "They are aliases for the same class."),
                QuestionOption("b", "`Period` measures nanoseconds, whereas `Duration` measures years and months."),
                QuestionOption("c", "Both are mutable classes."),
                QuestionOption("d", "`Duration` measures exact time-based amounts in seconds and nanoseconds (unaffected by daylight saving shifts), whereas `Period` measures calendar-based amounts in years, months, and days.")
            ),
            correctOptionId = "d",
            explanation = "Adding `Period.ofDays(1)` to a `ZonedDateTime` across a Daylight Saving Time transition keeps the same local wall-clock hour (23 or 25 real hours), whereas `Duration.ofHours(24)` adds an exact 24 hours."
        ),
        QuizQuestion(
            id = "jv_a_43",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `java.time.format.DateTimeFormatter` safe to store in a `private static final` field and share across multiple threads, unlike legacy `java.text.SimpleDateFormat`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`DateTimeFormatter` is immutable and thread-safe, whereas `SimpleDateFormat` mutates internal `Calendar` fields during `format()` and `parse()` calls, causing data corruption when shared across threads."),
                QuestionOption("b", "`SimpleDateFormat` is thread-safe and `DateTimeFormatter` is not."),
                QuestionOption("c", "`DateTimeFormatter` synchronizes every call with a global lock."),
                QuestionOption("d", "`DateTimeFormatter` can only be used once.")
            ),
            correctOptionId = "a",
            explanation = "All core `java.time` value classes (`Instant`, `LocalDate`, `ZonedDateTime`, `DateTimeFormatter`) are immutable and thread-safe."
        ),
        QuizQuestion(
            id = "jv_a_44",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `DateTimeFormatter.ofPattern(...)`, what subtle bug can happen at the end of December if you use uppercase `YYYY` instead of lowercase `yyyy` for the year?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Uppercase `YYYY` throws `DateTimeParseException`."),
                QuestionOption("b", "Uppercase `Y` is the **week-based year** (ISO-8601 week year), which can advance to the next year during the final days of December if that week belongs to week 1 of the new year; lowercase `y` is the standard calendar year."),
                QuestionOption("c", "Uppercase `YYYY` prints only 2 digits."),
                QuestionOption("d", "Lowercase `yyyy` prints the day of the year.")
            ),
            correctOptionId = "b",
            explanation = "In `DateTimeFormatter`, `Y` is `week-based-year` and `y` is `year-of-era` ( similarly `D` is day-of-year `1..366` while `d` is day-of-month `1..31`)."
        ),
        QuizQuestion(
            id = "jv_a_45",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 17 **sealed classes** (`public sealed interface Shape permits Circle, Rectangle`), what modifier MUST every permitted subclass (`Circle`, `Rectangle`) explicitly declare?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Permitted subclasses cannot have modifiers."),
                QuestionOption("b", "Every permitted subclass must be `abstract`."),
                QuestionOption("c", "Every permitted subclass must be declared `final`, `sealed`, or `non-sealed`."),
                QuestionOption("d", "Every permitted subclass must be a `record`.")
            ),
            correctOptionId = "c",
            explanation = "Java 17 requires every direct subtype of a `sealed` type to explicitly state how the sealing hierarchy continues: `final` (closed), `sealed` (restricted further), or `non-sealed` (open)."
        ),
        QuizQuestion(
            id = "jv_a_46",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a Java 16+ `record Range(int min, int max)`, how does a **compact constructor** `public Range { if (min > max) throw new IllegalArgumentException(); }` work?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It makes `min` and `max` mutable."),
                QuestionOption("b", "It creates a no-arg constructor `new Range()`."),
                QuestionOption("c", "It requires explicit `this.min = min;` assignments or the fields stay `0`."),
                QuestionOption("d", "It omits the parameter list `(int min, int max)` and runs validation/normalization logic, after which the compiler automatically appends `this.min = min; this.max = max;` at the end of the constructor.")
            ),
            correctOptionId = "d",
            explanation = "A compact record constructor has implicit access to the canonical parameters, lets you validate or normalize them (`min = Math.max(0, min);`), and implicitly assigns the `final` component fields at the end."
        ),
        QuizQuestion(
            id = "jv_a_47",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `map.computeIfAbsent(key, k -> new ArrayList<>()).add(item)` do on a `Map<String, List<String>>`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "If `key` is absent (or mapped to `null`), it invokes the mapping function to create and insert the new `ArrayList`, returns that list (or the existing list if already present), and appends `item`."),
                QuestionOption("b", "It always creates a new `ArrayList` and overwrites any existing list."),
                QuestionOption("c", "It returns `null` on the first call for a new key."),
                QuestionOption("d", "It throws `NullPointerException` if `key` is absent.")
            ),
            correctOptionId = "a",
            explanation = "`computeIfAbsent` returns the current (existing or newly computed) value associated with `key`, making multi-map insertion a concise one-liner."
        ),
        QuizQuestion(
            id = "jv_a_48",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens in `map.computeIfAbsent(key, k -> null)` if the mapping function returns `null`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It inserts `key -> null` into the map."),
                QuestionOption("b", "No mapping is recorded in the map (the key remains absent) and `computeIfAbsent` returns `null`."),
                QuestionOption("c", "It throws `NullPointerException`."),
                QuestionOption("d", "It deletes the entire map.")
            ),
            correctOptionId = "b",
            explanation = "Per the `Map.computeIfAbsent` specification, if the mapping function returns `null`, no mapping is recorded."
        ),
        QuizQuestion(
            id = "jv_a_49",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `map.merge(word, 1, Integer::sum)` do when counting word frequencies in a `Map<String, Integer>`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Throws `NullPointerException` when `word` is seen for the first time."),
                QuestionOption("b", "Always sets `word` to `1`."),
                QuestionOption("c", "If `word` is absent, inserts `word -> 1`; if `word` is already present with value `v`, updates it to `Integer.sum(v, 1)` (`v + 1`)."),
                QuestionOption("d", "Only updates `word` if it is already present.")
            ),
            correctOptionId = "c",
            explanation = "`Map.merge(key, value, remappingFunction)` inserts `value` if `key` is absent, or applies `remappingFunction(oldValue, value)` if present (removing the key if the function returns `null`)."
        ),
        QuizQuestion(
            id = "jv_a_50",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Which built-in `Map` implementation is specialized for keys of a single `enum` type and stores mappings in a compact internal array indexed by `enumConstant.ordinal()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`WeakHashMap`"),
                QuestionOption("b", "`TreeMap`"),
                QuestionOption("c", "`IdentityHashMap`"),
                QuestionOption("d", "`EnumMap<K extends Enum<K>, V>` (and `EnumSet<E extends Enum<E>>` for sets of enums using bit vectors).")
            ),
            correctOptionId = "d",
            explanation = "`EnumMap` uses a flat array of size `Enum.values().length` indexed by `ordinal()`, offering O(1) lookups with zero hash collision overhead."
        ),
        QuizQuestion(
            id = "jv_a_51",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How does `IdentityHashMap` differ from a standard `HashMap`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`IdentityHashMap` compares keys by reference identity (`k1 == k2`) and uses `System.identityHashCode(k)` instead of calling `k1.equals(k2)` and `k.hashCode()`."),
                QuestionOption("b", "`IdentityHashMap` only allows `Integer` keys."),
                QuestionOption("c", "`IdentityHashMap` sorts keys by `System.identityHashCode`."),
                QuestionOption("d", "`IdentityHashMap` is thread-safe.")
            ),
            correctOptionId = "a",
            explanation = "`IdentityHashMap` intentionally violates `Map`'s value-equality contract to track object graph identity (e.g., during serialization or deep copying)."
        ),
        QuizQuestion(
            id = "jv_a_52",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a lambda expression `Runnable r = () -> System.out.println(count);`, what restriction applies to the local variable `count` declared in the enclosing method?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`count` must be declared `volatile`."),
                QuestionOption("b", "`count` must be `final` or **effectively final** (never reassigned after initialization in the enclosing method)."),
                QuestionOption("c", "`count` can be incremented inside the lambda (`count++`)."),
                QuestionOption("d", "`count` must be a `static` field.")
            ),
            correctOptionId = "b",
            explanation = "Java lambdas capture local variables by value, so the compiler requires captured locals to be `final` or effectively final to prevent confusing mutation of a copy."
        ),
        QuizQuestion(
            id = "jv_a_53",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Inside a lambda expression vs an anonymous inner class (`new Runnable() { ... }`), what does the keyword `this` refer to?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Inside both, `this` refers to the enclosing class."),
                QuestionOption("b", "Inside a lambda, `this` refers to the lambda's `Runnable` instance."),
                QuestionOption("c", "Inside a lambda, `this` refers to the **enclosing class instance** where the lambda is written; inside an anonymous inner class, `this` refers to the anonymous inner class instance itself."),
                QuestionOption("d", "`this` cannot be used inside a lambda.")
            ),
            correctOptionId = "c",
            explanation = "Lambdas do not introduce a new lexical scope for `this` or `super`; `this` inside a lambda is the surrounding instance."
        ),
        QuizQuestion(
            id = "jv_a_54",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What are the 4 standard kinds of method references in Java 8+?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Private-only method references."),
                QuestionOption("b", "Only static and constructor method references exist."),
                QuestionOption("c", "Field references (`obj::field`) and package references."),
                QuestionOption("d", "Static (`Integer::parseInt`), bound instance (`str::startsWith`), unbound instance (`String::toLowerCase`), and constructor (`ArrayList::new`).")
            ),
            correctOptionId = "d",
            explanation = "Unbound instance method references like `String::toLowerCase` take the receiver `String` as the first parameter of the functional interface (`Function<String, String>`)."
        ),
        QuizQuestion(
            id = "jv_a_55",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why should `IntStream`, `LongStream`, or `DoubleStream` (`stream.mapToInt(Order::cents).sum()`) be preferred over `Stream<Integer>` (`reduce(0, Integer::sum)`) for large numeric aggregations?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Primitive streams operate directly on unboxed `int`/`long`/`double` values and provide specialized terminal operations (`sum()`, `average()`, `summaryStatistics()`), avoiding millions of heap allocations and unboxing operations."),
                QuestionOption("b", "`Stream<Integer>` cannot compute sums."),
                QuestionOption("c", "`IntStream` automatically runs on multiple threads."),
                QuestionOption("d", "`IntStream` stores elements on disk.")
            ),
            correctOptionId = "a",
            explanation = "Avoiding boxing (`Integer`) and unboxing per element eliminates GC pressure and pointer-chasing overhead."
        ),
        QuizQuestion(
            id = "jv_a_56",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `IntStream.range(1, 5)` produce compared to `IntStream.rangeClosed(1, 5)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both yield `1, 2, 3, 4, 5`."),
                QuestionOption("b", "`range(1, 5)` yields `1, 2, 3, 4` (exclusive upper bound), whereas `rangeClosed(1, 5)` yields `1, 2, 3, 4, 5` (inclusive upper bound)."),
                QuestionOption("c", "`range(1, 5)` yields `2, 3, 4`."),
                QuestionOption("d", "`rangeClosed` yields `5, 4, 3, 2, 1`.")
            ),
            correctOptionId = "b",
            explanation = "`IntStream.range(startInclusive, endExclusive)` excludes the upper bound; `IntStream.rangeClosed(startInclusive, endInclusive)` includes it."
        ),
        QuizQuestion(
            id = "jv_a_57",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `stream.reduce(identity, accumulator)` require of the `identity` value (especially in parallel streams)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The `identity` must always be `0` or `null`."),
                QuestionOption("b", "The `identity` is only used if the stream is empty."),
                QuestionOption("c", "For all `x`, `accumulator.apply(identity, x)` MUST equal `x` (so passing `10` as the identity to `reduce(10, Integer::sum)` on a parallel stream adds `10` to EVERY parallel worker subtask!)."),
                QuestionOption("d", "Parallel streams ignore the `identity` value.")
            ),
            correctOptionId = "c",
            explanation = "In `Stream.reduce(identity, op)`, `identity` must be a true mathematical identity for `op` (`0` for `+`, `1` for `*`); in a parallel stream, each split subtask starts with `identity`!"
        ),
        QuizQuestion(
            id = "jv_a_58",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do `Predicate.and(...)`, `Predicate.or(...)`, and `Predicate.negate()` allow composing filter rules?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "They only work on `Predicate<String>`."),
                QuestionOption("b", "They immediately evaluate the predicate on `null`."),
                QuestionOption("c", "They require a `Stream` to be created first."),
                QuestionOption("d", "They are `default` methods on `Predicate<T>` that return a new composed `Predicate<T>` with short-circuit evaluation (`p1.and(p2).negate()`).")
            ),
            correctOptionId = "d",
            explanation = "Functional interfaces in `java.util.function` provide combinator default methods (`Predicate.and/or/negate`, `Function.andThen/compose`, `Comparator.thenComparing`)."
        )
    )

    private fun appliedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "jv_a_59",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "For `Function<Integer, Integer> times2 = x -> x * 2;` and `Function<Integer, Integer> plus3 = x -> x + 3;`, what is `(times2.andThen(plus3).apply(5), times2.compose(plus3).apply(5))`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`(13, 16)` (`andThen` runs `times2(5)=10` then `plus3(10)=13`; `compose` runs `plus3(5)=8` first then `times2(8)=16`)."),
                QuestionOption("b", "`(16, 13)`"),
                QuestionOption("c", "`(13, 13)`"),
                QuestionOption("d", "`(16, 16)`")
            ),
            correctOptionId = "a",
            explanation = "`f.andThen(g)` computes `g(f(x))`, whereas `f.compose(g)` computes `f(g(x))`."
        ),
        QuizQuestion(
            id = "jv_a_60",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `Comparator.comparing(User::lastName).thenComparingInt(User::age)`, why is `thenComparingInt` preferred over `thenComparing(User::age)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`thenComparing(User::age)` sorts in descending order."),
                QuestionOption("b", "`thenComparingInt(ToIntFunction)` compares primitive `int` values directly via `Integer.compare`, avoiding autoboxing `age` to `Integer` on every comparison."),
                QuestionOption("c", "`thenComparingInt` only works on arrays."),
                QuestionOption("d", "There is no difference.")
            ),
            correctOptionId = "b",
            explanation = "`Comparator.comparingInt` / `thenComparingInt` use `ToIntFunction<T>` to avoid boxing primitives during O(n log n) comparisons."
        ),
        QuizQuestion(
            id = "jv_a_61",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can a `Comparator<String>` gracefully place `null` references at the end of a sorted list without throwing `NullPointerException`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Collections.sortWithNulls(list)`"),
                QuestionOption("b", "`Comparator.naturalOrder().reversed()`"),
                QuestionOption("c", "`Comparator.nullsLast(Comparator.naturalOrder())`"),
                QuestionOption("d", "`String.CASE_INSENSITIVE_ORDER`")
            ),
            correctOptionId = "c",
            explanation = "`Comparator.nullsFirst(comp)` and `Comparator.nullsLast(comp)` wrap a comparator to handle `null` elements safely."
        ),
        QuizQuestion(
            id = "jv_a_62",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java NIO.2 (`java.nio.file`), why must a caller using `Files.lines(path)` or `Files.walk(path)` wrap the returned `Stream` in a `try-with-resources` block?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Files.lines` closes the file before returning the `Stream`."),
                QuestionOption("b", "Because `Files.lines` throws a compile error outside `try-with-resources`."),
                QuestionOption("c", "Because `Stream` does not implement `AutoCloseable`."),
                QuestionOption("d", "Unlike collection streams, `Files.lines` and `Files.walk` hold open OS file/directory descriptors that are only closed when `stream.close()` is invoked (even if the stream is consumed to completion).")
            ),
            correctOptionId = "d",
            explanation = "`BaseStream` extends `AutoCloseable`; I/O-backed streams from `Files.lines`, `Files.list`, and `Files.walk` must be closed via `try (Stream<String> lines = Files.lines(path))` to avoid file descriptor leaks."
        ),
        QuizQuestion(
            id = "jv_a_63",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `Path.of(\"/var/app/logs\").resolve(\"../config/app.yml\").normalize()` return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A `Path` representing `\"/var/app/config/app.yml\"` (removing redundant `.` and `..` segments purely lexically without touching the filesystem)."),
                QuestionOption("b", "It throws `NoSuchFileException` if the file does not exist on disk."),
                QuestionOption("c", "A `Path` representing `\"/config/app.yml\"`."),
                QuestionOption("d", "A `String`.")
            ),
            correctOptionId = "a",
            explanation = "`Path.resolve` joins paths and `Path.normalize` eliminates `.` and `parent/..` segments lexically without performing disk I/O (unlike `toRealPath()`, which resolves symlinks on disk)."
        ),
        QuizQuestion(
            id = "jv_a_64",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens in `Path.of(\"/var/app\").resolve(\"/etc/passwd\")` when the argument passed to `resolve` is an **absolute** path?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It returns `\"/var/app/etc/passwd\"`."),
                QuestionOption("b", "`resolve` returns `\"/etc/passwd\"` directly (resolving an absolute path against any base path returns the absolute argument)."),
                QuestionOption("c", "It throws `InvalidPathException`."),
                QuestionOption("d", "It returns `\"/var/app\"`.")
            ),
            correctOptionId = "b",
            explanation = "Per `Path.resolve` documentation, if the `other` parameter is an `isAbsolute()` path, `resolve` trivially returns `other`."
        ),
        QuizQuestion(
            id = "jv_a_65",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why should `BigDecimal` in Java be constructed using `new BigDecimal(\"0.1\")` or `BigDecimal.valueOf(0.1)` rather than `new BigDecimal(0.1)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`BigDecimal.valueOf(0.1)` rounds to `0`."),
                QuestionOption("b", "`new BigDecimal(0.1)` fails to compile."),
                QuestionOption("c", "`new BigDecimal(0.1)` captures the exact binary `double` approximation (`0.1000000000000000055511151231257827021181583404541015625`), whereas `new BigDecimal(\"0.1\")` and `BigDecimal.valueOf(0.1)` represent exact `0.1`."),
                QuestionOption("d", "All three produce the exact same `BigDecimal` scale.")
            ),
            correctOptionId = "c",
            explanation = "`BigDecimal.valueOf(double)` converts the double via `Double.toString(val)` first, giving exact decimal `0.1` (scale 1)."
        ),
        QuizQuestion(
            id = "jv_a_66",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `new BigDecimal(\"2.0\").equals(new BigDecimal(\"2.00\"))` `false` in Java, and how should numeric value equality of two `BigDecimal`s be checked?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Use `bd1 == bd2`."),
                QuestionOption("b", "`BigDecimal.equals` compares reference identity `==`."),
                QuestionOption("c", "Both `equals` and `compareTo` return `false`."),
                QuestionOption("d", "`BigDecimal.equals` requires BOTH value AND `scale` to match (`2.0` has scale 1, `2.00` has scale 2); use `bd1.compareTo(bd2) == 0` to compare numerical value ignoring scale.")
            ),
            correctOptionId = "d",
            explanation = "`BigDecimal.equals` checks both unscaled value and scale (`20 * 10^-1` vs `200 * 10^-2`), whereas `compareTo` compares pure numerical value."
        ),
        QuizQuestion(
            id = "jv_a_67",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `new BigDecimal(\"1\").divide(new BigDecimal(\"3\"))` is called without specifying a `MathContext` or scale + `RoundingMode`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It throws `ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result`."),
                QuestionOption("b", "It truncates to `0.333333`."),
                QuestionOption("c", "It returns `0`."),
                QuestionOption("d", "It returns `Double.POSITIVE_INFINITY`.")
            ),
            correctOptionId = "a",
            explanation = "Because `1 / 3 = 0.333...` has no finite base-10 representation, `BigDecimal.divide` without a rounding mode throws `ArithmeticException` instead of silently losing precision."
        ),
        QuizQuestion(
            id = "jv_a_68",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `java.util.regex.Pattern`, what does `Matcher.find()` do compared to `Matcher.matches()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`find()` matches the entire string and `matches()` finds a substring."),
                QuestionOption("b", "`matches()` attempts to match the **entire** input sequence against the pattern, whereas `find()` scans the input for the **next subsequence** that matches the pattern."),
                QuestionOption("c", "`matches()` returns a `List<String>`."),
                QuestionOption("d", "They are synonyms.")
            ),
            correctOptionId = "b",
            explanation = "`Matcher.matches()` is implicitly anchored at both ends of the input, whereas `Matcher.find()` searches for matching substrings and advances on repeated calls."
        ),
        QuizQuestion(
            id = "jv_a_69",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `Matcher.replaceAll(replacement)`, why can an unescaped `\$` in the `replacement` string (such as `\"Price: \$10\"`) cause an `IndexOutOfBoundsException` or `IllegalArgumentException`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `replaceAll` does not allow digits in the replacement."),
                QuestionOption("b", "Because `\$` is the end-of-line anchor in replacement strings."),
                QuestionOption("c", "Because `replaceAll` interprets `\$1`, `\$2`, `\${name}` in the replacement string as regex capture-group backreferences; literal replacements should use `Matcher.quoteReplacement(str)` (or `String.replace` for non-regex literals)."),
                QuestionOption("d", "`replaceAll` treats `\$` as a literal character.")
            ),
            correctOptionId = "c",
            explanation = "`Matcher.replaceAll` parses `\\` and `\$` for group references; `Matcher.quoteReplacement` escapes them safely."
        ),
        QuizQuestion(
            id = "jv_a_70",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java, what is the difference between `String.replace(CharSequence, CharSequence)` and `String.replaceAll(String, String)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`replace` mutates the string in place."),
                QuestionOption("b", "`replace` only replaces the first occurrence, whereas `replaceAll` replaces all occurrences."),
                QuestionOption("c", "`replace` is case-insensitive."),
                QuestionOption("d", "BOTH replace all occurrences, but `replace` treats its target and replacement as **literal strings**, whereas `replaceAll` treats them as a **regular expression** and group-reference replacement.")
            ),
            correctOptionId = "d",
            explanation = "Despite its name, `String.replace(\"a\", \"b\")` replaces ALL literal occurrences of `\"a\"` without regex compilation or `\$`/`\\` escaping hazards (for first-only regex replacement, Java has `replaceFirst`)."
        ),
        QuizQuestion(
            id = "jv_a_71",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `List<String> sub = list.subList(1, 3);` on an `ArrayList<String> list`, what happens if you call `sub.clear()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`subList` returns a live view backed by `list`, so `sub.clear()` removes indices `1` and `2` directly from `list`!"),
                QuestionOption("b", "`sub.clear()` only clears a separate copy and leaves `list` untouched."),
                QuestionOption("c", "`sub.clear()` throws `UnsupportedOperationException`."),
                QuestionOption("d", "`sub.clear()` clears the entire `list`.")
            ),
            correctOptionId = "a",
            explanation = "`List.subList(from, to)` is a backed range view: mutations through `sub` write directly to the parent `list` (`list.subList(1, 3).clear()` is the idiomatic way to delete a slice from a `List`)."
        ),
        QuizQuestion(
            id = "jv_a_72",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens if you structurally modify the parent `ArrayList` directly (e.g., `list.add(\"x\")`) AFTER creating `List<String> sub = list.subList(1, 3)` and then access `sub.get(0)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`sub` automatically expands to include `\"x\"`."),
                QuestionOption("b", "Accessing `sub` throws `ConcurrentModificationException` because structural modifications to the backing list outside the `subList` view invalidate the `subList`."),
                QuestionOption("c", "`sub.get(0)` returns `null`."),
                QuestionOption("d", "Nothing; `sub` is an independent copy.")
            ),
            correctOptionId = "b",
            explanation = "`subList` tracks the parent list's `modCount` and throws `ConcurrentModificationException` if the parent list is structurally modified directly."
        ),
        QuizQuestion(
            id = "jv_a_73",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `BitSet` in `java.util` provide compared to `boolean[]`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A cryptographic hash function."),
                QuestionOption("b", "A thread-safe `Set<Boolean>` of size 2."),
                QuestionOption("c", "A dynamically sizing vector of bits packed into `long[]` words (1 bit per boolean flag instead of 1 byte per `boolean[]` element) with bulk bitwise operations (`and`, `or`, `xor`, `cardinality`, `nextSetBit`)."),
                QuestionOption("d", "An immutable fixed-length bit string.")
            ),
            correctOptionId = "c",
            explanation = "`BitSet` packs 64 flags into each 64-bit `long` and uses CPU `Long.bitCount` intrinsics for fast `cardinality()` and set operations."
        ),
        QuizQuestion(
            id = "jv_a_74",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `Integer.bitCount(29)` return (`29` in binary is `11101`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "1"),
                QuestionOption("b", "5"),
                QuestionOption("c", "29"),
                QuestionOption("d", "4 (the number of one-bits in the two's complement binary representation, also known as population count / Hamming weight).")
            ),
            correctOptionId = "d",
            explanation = "`Integer.bitCount(n)` (and `Long.bitCount`) is a JVM intrinsic (`POPCNT` instruction) returning the number of set `1` bits."
        ),
        QuizQuestion(
            id = "jv_a_75",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What do `Integer.numberOfLeadingZeros(1)` and `Integer.numberOfTrailingZeros(8)` return for 32-bit `int`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`31` and `3` (since `1` is `0...01` with 31 leading zeros, and `8` is `...01000` with 3 trailing zeros)."),
                QuestionOption("b", "`0` and `0`"),
                QuestionOption("c", "`32` and `4`"),
                QuestionOption("d", "`1` and `8`")
            ),
            correctOptionId = "a",
            explanation = "`numberOfLeadingZeros` and `numberOfTrailingZeros` inspect the 32-bit binary representation and map directly to CPU `LZCNT`/`TZCNT` instructions."
        ),
        QuizQuestion(
            id = "jv_a_76",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 9+, what does `Optional.ifPresentOrElse(val -> ..., () -> ...)` do?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Executes both lambdas in sequence."),
                QuestionOption("b", "Executes the first `Consumer` if a value is present, or executes the second `Runnable` empty-action if the `Optional` is empty."),
                QuestionOption("c", "Returns a new `Optional`."),
                QuestionOption("d", "Throws `NoSuchElementException` if the `Runnable` is called.")
            ),
            correctOptionId = "b",
            explanation = "`Optional.ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)` handles both present and empty cases cleanly without `isPresent()` / `get()`."
        ),
        QuizQuestion(
            id = "jv_a_77",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 9+, what does `Optional.stream()` enable when combined with `Stream.flatMap`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It returns a `Stream<Optional<T>>`."),
                QuestionOption("b", "It throws `NoSuchElementException` on empty `Optional`s."),
                QuestionOption("c", "It turns a present `Optional<T>` into a 1-element `Stream<T>` and an empty `Optional` into an empty `Stream<T>`, so `streamOfOptionals.flatMap(Optional::stream)` unwraps all present values cleanly."),
                QuestionOption("d", "It converts the `Optional` into an `IntStream`.")
            ),
            correctOptionId = "c",
            explanation = "`list.stream().flatMap(Optional::stream).toList()` filters out empty `Optional`s and unwraps non-empty values in a single step."
        ),
        QuizQuestion(
            id = "jv_a_78",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 9+, how do `Stream.takeWhile(predicate)` and `Stream.dropWhile(predicate)` behave on an ordered stream `Stream.of(2, 4, 1, 6)` with predicate `x -> x % 2 == 0`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both throw `IllegalStateException` if the stream is not sorted."),
                QuestionOption("b", "`takeWhile` yields `[2, 4, 6]` (same as `filter`)."),
                QuestionOption("c", "`dropWhile` yields `[1]`."),
                QuestionOption("d", "`takeWhile` yields `[2, 4]` and stops at `1`; `dropWhile` drops `2, 4` and yields the remaining elements `[1, 6]` starting from the first element that fails the predicate.")
            ),
            correctOptionId = "d",
            explanation = "Unlike `filter` (which tests every element), `takeWhile` short-circuits on the first failing element, and `dropWhile` stops dropping on the first failing element."
        ),
        QuizQuestion(
            id = "jv_a_79",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)` do?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Performs the downstream collection (`toList()`) and then applies a finishing transformation (`Collections::unmodifiableList`) to the final result."),
                QuestionOption("b", "Applies `unmodifiableList` to each element before collecting."),
                QuestionOption("c", "Runs two collectors in parallel."),
                QuestionOption("d", "Filters out `null` elements.")
            ),
            correctOptionId = "a",
            explanation = "`Collectors.collectingAndThen(downstream, finisher)` appends a final post-processing function to any `Collector`."
        ),
        QuizQuestion(
            id = "jv_a_80",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 12+, what does `Collectors.teeing(collector1, collector2, merger)` allow you to do in a single stream pass?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Splits a stream into two separate `Stream` objects."),
                QuestionOption("b", "Feeds every stream element into two independent downstream collectors simultaneously and merges their two final results using the `BiFunction` `merger` (e.g., computing `min` and `max` or `count` and `sum` in one pass)."),
                QuestionOption("c", "Logs each element to stdout while collecting."),
                QuestionOption("d", "Deduplicates elements across two streams.")
            ),
            correctOptionId = "b",
            explanation = "`Collectors.teeing` multiplexes a single stream pass into two collectors and combines their results at the end."
        ),
        QuizQuestion(
            id = "jv_a_81",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When implementing `Comparable<Task>` on a `Task` class, what does the `compareTo(Task other)` return value convention signify?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`true` or `false`."),
                QuestionOption("b", "Strictly `-1`, `0`, or `+1` only (returning `-5` is illegal)."),
                QuestionOption("c", "A negative integer if `this < other`, zero if `this == other` in sort order, and a positive integer if `this > other`."),
                QuestionOption("d", "A negative integer if `this > other`.")
            ),
            correctOptionId = "c",
            explanation = "`Comparable.compareTo` returns any negative `int`, `0`, or any positive `int` depending on whether `this` is less than, equal to, or greater than `other`."
        ),
        QuizQuestion(
            id = "jv_a_82",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `Optional.map` when the mapper function returns `null`?",
            codeSnippet = "Optional<String> opt = Optional.of(\"hello\")\n    .map(s -> (String) null);\nSystem.out.println(opt.isEmpty());",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Compilation error."),
                QuestionOption("b", "Throws `NullPointerException`."),
                QuestionOption("c", "false"),
                QuestionOption("d", "true (if the mapping function passed to `Optional.map` returns `null`, `Optional.map` automatically wraps it as `Optional.empty()`).")
            ),
            correctOptionId = "d",
            explanation = "Per `Optional.map` specification, if the mapping function returns `null`, `map` returns `Optional.empty()` (unlike `Stream.map`, which keeps `null` elements in the stream)."
        ),
        QuizQuestion(
            id = "jv_a_83",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does `Arrays.binarySearch(arr, target)` return a negative number `-(insertionPoint) - 1` (rather than simply `-1`) when `target` is not found in a sorted array?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "So the caller knows BOTH that `target` was not found (return value `< 0`) AND the exact index `insertionPoint = -result - 1` where `target` would be inserted to keep the array sorted; `-1` is needed to distinguish insertion index `0` from found index `0`!"),
                QuestionOption("b", "Because array indices start at `1`."),
                QuestionOption("c", "It always returns `-1` when not found."),
                QuestionOption("d", "To indicate an unsorted array.")
            ),
            correctOptionId = "a",
            explanation = "If `insertionPoint` were returned as `-insertionPoint`, insertion at index `0` would be `-0 == 0`, which is indistinguishable from finding `target` at index `0`!"
        ),
        QuizQuestion(
            id = "jv_a_84",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens if `Arrays.binarySearch(arr, target)` is called on an array that is NOT sorted in ascending order?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It automatically sorts the array first."),
                QuestionOption("b", "The result is undefined—it may return a negative value even when `target` is present in the array, without throwing an exception."),
                QuestionOption("c", "It falls back to a linear scan."),
                QuestionOption("d", "It throws `IllegalStateException`.")
            ),
            correctOptionId = "b",
            explanation = "`binarySearch` does not verify sortedness (which would take O(n) and defeat the O(log n) search); calling it on an unsorted array yields undefined results."
        ),
        QuizQuestion(
            id = "jv_a_85",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java, what is the difference between `Throwable.getCause()` and `Throwable.getSuppressed()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`getSuppressed()` returns the root cause."),
                QuestionOption("b", "They return the same exception."),
                QuestionOption("c", "`getCause()` returns the underlying exception that **caused** this exception to be thrown (vertical chaining), whereas `getSuppressed()` returns an array of sibling exceptions that were **suppressed** while delivering this primary exception (such as `close()` failures in `try-with-resources`)."),
                QuestionOption("d", "`getCause()` returns an array of exceptions.")
            ),
            correctOptionId = "c",
            explanation = "`cause` represents causal wrapping (`new ServiceException(sqlEx)`), while `suppressed` records secondary exceptions that occurred during cleanup (`try-with-resources`)."
        ),
        QuizQuestion(
            id = "jv_a_86",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `String.chars()` return on a Java `String`, and how does it differ from `String.codePoints()` for supplementary Unicode characters (like emojis `\"😀\"`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`codePoints()` returns UTF-8 bytes."),
                QuestionOption("b", "Both return a `Stream<Character>`."),
                QuestionOption("c", "`chars()` returns full 21-bit Unicode code points."),
                QuestionOption("d", "`chars()` returns an `IntStream` of 16-bit UTF-16 `char` code units (splitting a supplementary emoji surrogate pair into 2 ints), whereas `codePoints()` returns an `IntStream` of full Unicode code points (yielding 1 int for `\"😀\"`).")
            ),
            correctOptionId = "d",
            explanation = "Because Java `char` is UTF-16, characters above `U+FFFF` are stored as a high/low surrogate pair (`length() == 2`); `codePoints()` decodes surrogate pairs into single Unicode scalar values."
        ),
        QuizQuestion(
            id = "jv_a_87",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is `\"😀\".length()` vs `\"😀\".codePointCount(0, \"😀\".length())` in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`2` (two 16-bit UTF-16 surrogate `char`s) versus `1` (one Unicode code point `U+1F600`)."),
                QuestionOption("b", "`1` and `1`"),
                QuestionOption("c", "`4` and `1`"),
                QuestionOption("d", "`2` and `2`")
            ),
            correctOptionId = "a",
            explanation = "`String.length()` counts 16-bit UTF-16 code units; `codePointCount` counts actual Unicode code points."
        ),
        QuizQuestion(
            id = "jv_a_88",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `java.util.Properties`, why should `props.getProperty(key)` and `props.setProperty(key, val)` be used instead of the inherited `Hashtable` methods `get` and `put`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `get` and `put` throw `UnsupportedOperationException` on `Properties`."),
                QuestionOption("b", "Because `Properties` unfortunately extends `Hashtable<Object, Object>` for legacy reasons; `setProperty` enforces `String` keys and values, and `getProperty` also searches fallback default `Properties`."),
                QuestionOption("c", "Because `setProperty` writes directly to disk."),
                QuestionOption("d", "There is no difference.")
            ),
            correctOptionId = "b",
            explanation = "`getProperty(key)` delegates to the backing `defaults` table if the key is absent (and returns `null` if a non-`String` was accidentally inserted via `put`)."
        ),
        QuizQuestion(
            id = "jv_a_89",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `Random` vs `ThreadLocalRandom.current()` in a multi-threaded application, why is `ThreadLocalRandom.current()` strongly preferred?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`ThreadLocalRandom` is cryptographically secure like `SecureRandom`."),
                QuestionOption("b", "`Random` is not thread-safe and corrupts its seed."),
                QuestionOption("c", "A shared `java.util.Random` uses an `AtomicLong` seed that suffers severe CAS contention across threads, whereas `ThreadLocalRandom` maintains uncontended per-thread seed state."),
                QuestionOption("d", "`Random` cannot generate bounded ints.")
            ),
            correctOptionId = "c",
            explanation = "While `java.util.Random` is thread-safe via `AtomicLong` CAS retries, multiple threads calling it concurrently contend heavily on the same cache line; `ThreadLocalRandom` avoids all cross-thread contention."
        ),
        QuizQuestion(
            id = "jv_a_90",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `Map.entry(\"timeout\", 30)` (Java 9+) return?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A `record`."),
                QuestionOption("b", "A mutable `AbstractMap.SimpleEntry`."),
                QuestionOption("c", "A 1-element `HashMap`."),
                QuestionOption("d", "An unmodifiable `Map.Entry<String, Integer>` that forbids `null` keys/values and throws `UnsupportedOperationException` on `setValue(...)` (ideal for `Map.ofEntries(...)`).")
            ),
            correctOptionId = "d",
            explanation = "`Map.entry(k, v)` creates an immutable entry used with `Map.ofEntries(...)` when constructing unmodifiable maps with more than 10 entries."
        ),
        QuizQuestion(
            id = "jv_a_91",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many key-value pairs does the overloaded `Map.of(k1, v1, ...)` support before you must switch to `Map.ofEntries(Map.entry(k1, v1), ...)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Up to `10` key-value pairs (`Map.of` has overloads for 0 through 10 pairs; for 11+ pairs, use `Map.ofEntries`)."),
                QuestionOption("b", "Unlimited key-value pairs via varargs."),
                QuestionOption("c", "Up to 5 key-value pairs."),
                QuestionOption("d", "Up to 2 key-value pairs.")
            ),
            correctOptionId = "a",
            explanation = "Because Java cannot interleave two generic varargs types `(K... keys, V... values)`, `Map.of` provides fixed-arity overloads up to 10 entries and `Map.ofEntries(Map.Entry<? extends K, ? extends V>...)` for arbitrary sizes."
        ),
        QuizQuestion(
            id = "jv_a_92",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `Map.of(\"a\", 1, \"a\", 2)` is called with a duplicate key?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The second value `2` overwrites `1`."),
                QuestionOption("b", "It throws `IllegalArgumentException: duplicate key: a` at runtime (and `Set.of(\"a\", \"a\")` also throws `IllegalArgumentException`)."),
                QuestionOption("c", "The first value `1` is kept."),
                QuestionOption("d", "It fails to compile.")
            ),
            correctOptionId = "b",
            explanation = "Unmodifiable factory methods `Set.of` and `Map.of` reject duplicate keys/elements with `IllegalArgumentException` to catch configuration bugs early."
        ),
        QuizQuestion(
            id = "jv_a_93",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the output of this `Stream.peek` with short-circuiting `findFirst()`?",
            codeSnippet = "List<Integer> seen = new ArrayList<>();\nOptional<Integer> first = Stream.of(10, 20, 30)\n    .peek(seen::add)\n    .filter(x -> x >= 20)\n    .findFirst();\nSystem.out.println(first.orElse(-1) + \" \" + seen);",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "10 [10]"),
                QuestionOption("b", "20 [10, 20, 30]"),
                QuestionOption("c", "20 [10, 20]"),
                QuestionOption("d", "20 [20]")
            ),
            correctOptionId = "c",
            explanation = "Streams fuse intermediate operations vertically per element (loop fusion) and short-circuit on `findFirst()`: `10` is peeked and fails `filter`; `20` is peeked, passes `filter`, and satisfies `findFirst()`, so `30` is never processed!"
        ),
        QuizQuestion(
            id = "jv_a_94",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why can `Stream.of(1, 2, 3).peek(list::add).count()` in Java 9+ return `3` WITHOUT executing `list::add` at all?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `Stream.of` is empty."),
                QuestionOption("b", "Because `peek` only runs on parallel streams."),
                QuestionOption("c", "Because `count()` always returns `0` after `peek`."),
                QuestionOption("d", "`count()` on a stream with a known `SIZED` spliterator (and no size-altering stages like `filter` or `flatMap`) optimizes by returning the spliterator size in O(1) without traversing elements or running `peek`!")
            ),
            correctOptionId = "d",
            explanation = "Since Java 9, `Stream.count()` queries the pipeline's exact `SIZED` metadata when no size-modifying intermediate operations are present, eliding element traversal and side-effecting `peek` calls."
        ),
        QuizQuestion(
            id = "jv_a_95",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In Java 16+, why is it now legal to declare `static` methods and `static` fields inside a non-static inner class or local class (which was forbidden in Java 8–15)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Java 16 (JEP 395, alongside records) relaxed the historical restriction so inner classes, local classes, and anonymous classes can declare `static` members and local records/enums/interfaces."),
                QuestionOption("b", "It is still a compile error in Java 17."),
                QuestionOption("c", "Only `static final int` is allowed in Java 17."),
                QuestionOption("d", "Inner classes are now implicitly `static`.")
            ),
            correctOptionId = "a",
            explanation = "Java 16 lifted the longstanding restriction prohibiting static members in inner classes and allowed local records, local enums, and local interfaces inside methods."
        ),
        QuizQuestion(
            id = "jv_a_96",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `Collections.binarySearch(list, key)` do when passed a `LinkedList` (which does NOT implement `RandomAccess`) vs an `ArrayList`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It throws `IllegalArgumentException` on `LinkedList`."),
                QuestionOption("b", "For `ArrayList` (`RandomAccess`), it performs indexed binary search (`O(log n)` comparisons and `O(log n)` accesses); for `LinkedList`, it falls back to iterator-based binary search (`O(log n)` comparisons but `O(n)` node traversals)."),
                QuestionOption("c", "It runs in O(log n) total time on `LinkedList`."),
                QuestionOption("d", "It converts the `LinkedList` into an `ArrayList` first.")
            ),
            correctOptionId = "b",
            explanation = "`Collections.binarySearch` checks `list instanceof RandomAccess`: without O(1) random access, stepping an iterator to the midpoint takes O(n) pointer hops."
        ),
        QuizQuestion(
            id = "jv_a_97",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What marker interface does `ArrayList` implement so generic algorithms like `Collections.shuffle`, `Collections.binarySearch`, and `Collections.reverse` know `list.get(i)` is O(1)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`java.io.Serializable`"),
                QuestionOption("b", "`java.lang.Cloneable`"),
                QuestionOption("c", "`java.util.RandomAccess`"),
                QuestionOption("d", "`java.util.SequencedCollection`")
            ),
            correctOptionId = "c",
            explanation = "`RandomAccess` is a marker interface indicating that indexed access `list.get(i)` is faster than iterator traversal."
        ),
        QuizQuestion(
            id = "jv_a_98",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In `java.time`, what is the difference between `Instant.now()` and `LocalDateTime.now()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "They can be compared directly with `equals()`."),
                QuestionOption("b", "`LocalDateTime` stores the UTC epoch timestamp."),
                QuestionOption("c", "`Instant` uses the system default timezone offset."),
                QuestionOption("d", "`Instant` represents an unambiguous point on the global UTC timeline (epoch seconds + nanoseconds), whereas `LocalDateTime` has NO timezone or offset (`2025-05-19T14:30`) and cannot represent a specific global instant without a `ZoneId`.")
            ),
            correctOptionId = "d",
            explanation = "`LocalDateTime` is a wall-clock date+time description without a timezone (`ZoneId`), whereas `Instant` is an exact point on the UTC timeline."
        ),
        QuizQuestion(
            id = "jv_a_99",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When converting a `LocalDateTime` to a `ZonedDateTime` via `ZonedDateTime.of(localDateTime, zoneId)` during a Daylight Saving Time **spring-forward gap** (e.g., `02:30` when clocks jump from `02:00` to `03:00`), what does `java.time` do?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It shifts the time forward by the length of the gap (e.g., to `03:30` with the post-transition offset) rather than throwing an exception."),
                QuestionOption("b", "It throws `DateTimeException`."),
                QuestionOption("c", "It shifts backward to `01:30`."),
                QuestionOption("d", "It sets the time to midnight `00:00`.")
            ),
            correctOptionId = "a",
            explanation = "Per `ZonedDateTime.of` specification, in a DST gap the local time is pushed forward by the gap duration; in a fall-back overlap, the earlier offset is chosen by default."
        ),
        QuizQuestion(
            id = "jv_a_100",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `String.indent(4)` (Java 12+) do to a multi-line string?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Only indents the first line by 4 spaces."),
                QuestionOption("b", "Prepends 4 spaces to the beginning of every line and normalizes line terminators to `\\n` (and ensures a trailing `\\n`)."),
                QuestionOption("c", "Truncates each line to 4 characters."),
                QuestionOption("d", "Throws `IllegalArgumentException` on single-line strings.")
            ),
            correctOptionId = "b",
            explanation = "`String.indent(n)` adds `n` leading spaces to each line when `n > 0` (or removes up to `|n|` leading whitespace characters per line when `n < 0`)."
        )
    )

    private fun advancedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "jv_adv_16",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the Java Memory Model (JMM), what two guarantees does declaring a field `volatile` provide, and why is `volatile int count; count++;` STILL not thread-safe?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`volatile` locks the entire object monitor on read, but not on write."),
                QuestionOption("b", "`volatile` guarantees **visibility** (writes flush to main memory; reads see the latest write) and **ordering** (prevents instruction reordering across the volatile access via happens-before), but `count++` is a non-atomic 3-step read-modify-write sequence where two threads can read the same value and overwrite each other."),
                QuestionOption("c", "`volatile` only works on `boolean` fields, not `int`."),
                QuestionOption("d", "`volatile int count; count++;` IS atomic and thread-safe on 64-bit JVMs.")
            ),
            correctOptionId = "b",
            explanation = "A `volatile` write happens-before every subsequent `volatile` read of that field, but `count++` performs `load`, `add`, and `store` as separate operations; atomic increments require `AtomicInteger.incrementAndGet()` or `LongAdder`."
        ),
        QuizQuestion(
            id = "jv_adv_17",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the double-checked locking singleton pattern (`if (instance == null) { synchronized (Lock.class) { if (instance == null) instance = new Helper(); } }`), why MUST `instance` be declared `private static volatile Helper instance;`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `static` fields are cached in thread-local storage forever."),
                QuestionOption("b", "Because `synchronized` does not flush writes to main memory."),
                QuestionOption("c", "Without `volatile`, the JIT/CPU can reorder the write to the `instance` reference BEFORE the constructor stores inside `new Helper()` finish, allowing another thread on the outer unsynchronized check to observe a non-null but **partially constructed** `Helper`!"),
                QuestionOption("d", "`volatile` is not needed in Java 5+.")
            ),
            correctOptionId = "c",
            explanation = "Without a happens-before edge (`volatile` or `final`-field freeze), `instance = new Helper()` can publish the object reference before its non-final fields are initialized."
        ),
        QuizQuestion(
            id = "jv_adv_18",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What special initialization safety guarantee does the Java Memory Model (JSR-133, Java 5+) provide for `final` fields of an object?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`final` fields cannot be read by other threads."),
                QuestionOption("b", "`final` fields are only visible if the reference is stored in a `volatile` variable."),
                QuestionOption("c", "Non-final fields have the exact same guarantee as `final` fields."),
                QuestionOption("d", "If an object is properly constructed (its `this` reference does not **escape** during construction), any thread that sees a reference to the object—even via a data race without synchronization—is guaranteed to see the initialized values of its `final` fields.")
            ),
            correctOptionId = "d",
            explanation = "The JVM inserts a `Freeze` memory barrier at the end of a constructor that writes `final` fields, guaranteeing safe publication of `final` fields (and objects reachable through them) as long as `this` didn't escape the constructor."
        ),
        QuizQuestion(
            id = "jv_adv_19",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `CompletableFuture`, what is the difference between `future.thenApply(fn)` and `future.thenCompose(fn)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`thenApply` takes `T -> U` and returns `CompletableFuture<U>` (like `map`), whereas `thenCompose` takes `T -> CompletableFuture<U>` and flattens the dependent asynchronous stage into `CompletableFuture<U>` (like `flatMap`)."),
                QuestionOption("b", "`thenCompose` runs synchronously on the main thread, whereas `thenApply` spawns a new thread."),
                QuestionOption("c", "`thenApply` combines two independent futures in parallel."),
                QuestionOption("d", "They are aliases.")
            ),
            correctOptionId = "a",
            explanation = "`thenCompose` chains dependent asynchronous computations without producing nested `CompletableFuture<CompletableFuture<U>>`."
        ),
        QuizQuestion(
            id = "jv_adv_20",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `futureA.thenCombine(futureB, (a, b) -> ...)` differ from `futureA.thenCompose(a -> ...)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`thenCombine` cancels `futureB` when `futureA` finishes."),
                QuestionOption("b", "`thenCombine` runs `futureA` and `futureB` **independently/concurrently** and invokes the `BiFunction` when both complete; `thenCompose` starts the second future **sequentially** only after the first future completes because the second depends on the first's result."),
                QuestionOption("c", "`thenCombine` runs `futureB` only after `futureA` finishes."),
                QuestionOption("d", "`thenCompose` requires both futures to have the same return type.")
            ),
            correctOptionId = "b",
            explanation = "Use `thenCombine` for independent parallel tasks whose results are joined, and `thenCompose` when task B needs the output of task A to start."
        ),
        QuizQuestion(
            id = "jv_adv_21",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `CompletableFuture`, which thread pool executes `thenApplyAsync(fn)` when no explicit `Executor` is passed?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Always the caller's thread."),
                QuestionOption("b", "A single-threaded global event loop."),
                QuestionOption("c", "`ForkJoinPool.commonPool()` (provided its parallelism is `> 1`; otherwise a new thread per task)."),
                QuestionOption("d", "A cached `Executors.newCachedThreadPool()`.")
            ),
            correctOptionId = "c",
            explanation = "By default, `*Async` methods on `CompletableFuture` without an `Executor` argument submit tasks to `ForkJoinPool.commonPool()`."
        ),
        QuizQuestion(
            id = "jv_adv_22",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is running blocking I/O (such as JDBC queries or synchronous HTTP calls) inside `CompletableFuture.supplyAsync(...)` or `.parallelStream()` without a custom `Executor` dangerous?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Blocking I/O is automatically converted to non-blocking NIO in `commonPool()`."),
                QuestionOption("b", "Because `ForkJoinPool` throws `RejectedExecutionException` on I/O calls."),
                QuestionOption("c", "Because `commonPool()` has 10,000 threads by default."),
                QuestionOption("d", "Both share the process-wide `ForkJoinPool.commonPool()` (sized to `Runtime.availableProcessors() - 1`), so blocking those few threads on I/O can starve all other parallel streams and async tasks across the entire JVM.")
            ),
            correctOptionId = "d",
            explanation = "`ForkJoinPool.commonPool()` is designed for non-blocking CPU-bound work (or tasks using `ForkJoinPool.ManagedBlocker`); blocking I/O should use a dedicated `ExecutorService`."
        ),
        QuizQuestion(
            id = "jv_adv_23",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `CompletableFuture`, how do `.exceptionally(ex -> fallback)`, `.handle((res, ex) -> ...)`, and `.whenComplete((res, ex) -> ...)` differ?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`exceptionally` runs only on failure and can recover with a fallback value; `handle` runs on BOTH success and failure and transforms/recovers the result; `whenComplete` runs on both as a side-effect callback (`BiConsumer`) and preserves the original result/exception."),
                QuestionOption("b", "`whenComplete` swallows exceptions and returns `null`."),
                QuestionOption("c", "`handle` only runs when an exception occurs."),
                QuestionOption("d", "`exceptionally` runs even when the future succeeds.")
            ),
            correctOptionId = "a",
            explanation = "`handle(BiFunction)` can transform both normal results and exceptions into a new result, whereas `whenComplete(BiConsumer)` observes completion without changing the outcome (unless the callback itself throws)."
        ),
        QuizQuestion(
            id = "jv_adv_24",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is calling `map.computeIfAbsent(k1, k -> map.computeIfAbsent(k2, ...))` (recursive modification of the same `ConcurrentHashMap` inside a mapping lambda) forbidden in `ConcurrentHashMap`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `ConcurrentHashMap` uses a single global lock."),
                QuestionOption("b", "`ConcurrentHashMap.computeIfAbsent` holds a synchronized bin lock while executing the mapping function; recursively updating the same `ConcurrentHashMap` from inside the lambda can deadlock or throw `IllegalStateException: Recursive update`!"),
                QuestionOption("c", "Because `computeIfAbsent` is not atomic in `ConcurrentHashMap`."),
                QuestionOption("d", "It is allowed and never blocks.")
            ),
            correctOptionId = "b",
            explanation = "`ConcurrentHashMap` locks the hash bin header during `computeIfAbsent` to guarantee at-most-once atomic computation; mutating the map inside that lambda risks lock-order deadlock and triggers `IllegalStateException: Recursive update`."
        ),
        QuizQuestion(
            id = "jv_adv_25",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does `ConcurrentHashMap` forbid `null` keys and `null` values, unlike `HashMap`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `ConcurrentHashMap` uses `TreeMap` internally for all buckets."),
                QuestionOption("b", "Because `null` has hash code `-1`."),
                QuestionOption("c", "In a concurrent map, `map.get(key) == null` would be ambiguous (you cannot safely call `map.containsKey(key)` afterward because another thread could insert or remove the key between the two calls)."),
                QuestionOption("d", "`ConcurrentHashMap` allows `null` values, just not `null` keys.")
            ),
            correctOptionId = "c",
            explanation = "As Doug Lea explained, in concurrent collections a separate `containsKey` check after `get(k) == null` is a TOCTOU race condition, so `null` values are disallowed."
        ),
        QuizQuestion(
            id = "jv_adv_26",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When is `CopyOnWriteArrayList` an appropriate concurrency choice, and when is it a performance disaster?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It blocks all reader threads whenever a writer calls `add`."),
                QuestionOption("b", "It is ideal for write-heavy queues with thousands of `add`s per second."),
                QuestionOption("c", "Its `iterator().remove()` method is O(1)."),
                QuestionOption("d", "It is ideal for **read-heavy, write-rare** lists (such as event listener registries) because reads/iterations are completely lock-free on an immutable array snapshot, whereas every write (`add`, `set`, `remove`) locks and copies the entire backing array (`O(n)`).")
            ),
            correctOptionId = "d",
            explanation = "`CopyOnWriteArrayList` copies the entire `Object[]` array on every mutation, so iterators never throw `ConcurrentModificationException` and never block, at the cost of O(n) writes."
        ),
        QuizQuestion(
            id = "jv_adv_27",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `java.util.concurrent.locks.StampedLock`, how does an **optimistic read** (`long stamp = lock.tryOptimisticRead()`) work?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It reads a version stamp without acquiring a lock or blocking writers; after reading shared fields into local variables, the thread calls `if (!lock.validate(stamp))` to check if a write occurred mid-read, falling back to `readLock()` if validation fails."),
                QuestionOption("b", "It acquires an exclusive write lock."),
                QuestionOption("c", "It blocks all writers until `unlockRead(stamp)` is called."),
                QuestionOption("d", "`StampedLock` is reentrant just like `ReentrantReadWriteLock`.")
            ),
            correctOptionId = "a",
            explanation = "`StampedLock` optimistic reads avoid even the atomic CAS cache-line bouncing of a shared read lock when contention is low (note: `StampedLock` is NOT reentrant!)."
        ),
        QuizQuestion(
            id = "jv_adv_28",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Wait—what happens if a thread holding a `StampedLock` write lock calls `lock.writeLock()` a second time on the same `StampedLock`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It increments the hold count and succeeds immediately."),
                QuestionOption("b", "It **deadlocks** against itself because `StampedLock` is NOT reentrant (unlike `ReentrantLock` and `ReentrantReadWriteLock`)."),
                QuestionOption("c", "It throws `IllegalMonitorStateException`."),
                QuestionOption("d", "It downgrades the lock to a read lock.")
            ),
            correctOptionId = "b",
            explanation = "`StampedLock` does not track an owning thread or recursion count; attempting to re-acquire a lock already held by the same thread deadlocks."
        ),
        QuizQuestion(
            id = "jv_adv_29",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How do `CountDownLatch` and `CyclicBarrier` differ in `java.util.concurrent`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`CyclicBarrier` allows only 2 threads."),
                QuestionOption("b", "`CountDownLatch` can be reset with `.reset()`, whereas `CyclicBarrier` cannot."),
                QuestionOption("c", "`CountDownLatch` is a **single-use** gate where one or more threads `await()` until `countDown()` reaches zero (cannot be reset); `CyclicBarrier` is **reusable** across cycles where `N` peer threads `await()` each other at a rendezvous point (optionally running a barrier action)."),
                QuestionOption("d", "They are identical.")
            ),
            correctOptionId = "c",
            explanation = "`CountDownLatch` separates threads calling `countDown()` from threads calling `await()` and is one-shot; `CyclicBarrier` synchronizes a fixed party of threads that wait for each other and automatically resets for the next phase."
        ),
        QuizQuestion(
            id = "jv_adv_30",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can using `ThreadLocal<T>` in a web server backed by a long-lived thread pool cause a severe memory leak if `threadLocal.remove()` is not called in a `finally` block?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `WeakReference` objects are never collected."),
                QuestionOption("b", "Because `ThreadLocal` stores values in a global `static HashMap` keyed by thread name."),
                QuestionOption("c", "Because `ThreadLocal` disables garbage collection on the thread."),
                QuestionOption("d", "In `Thread.threadLocals` (`ThreadLocalMap`), the `Entry` holds a `WeakReference` to the `ThreadLocal` key, but a **strong reference** to the value `T`; because pooled worker threads stay alive, unremoved values (and their classloaders) remain strongly reachable until overwritten or removed.")
            ),
            correctOptionId = "d",
            explanation = "While the `Entry extends WeakReference<ThreadLocal<?>>`, the `Object value` field inside `Entry` is a strong reference attached to the long-lived pooled `Thread`."
        ),
        QuizQuestion(
            id = "jv_adv_31",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `AtomicInteger` / `AtomicReference`, what is the **ABA problem** in lock-free compare-and-swap (`compareAndSet(A, B)`), and which JDK class solves it?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A thread reads value `A`, gets preempted while another thread changes `A -> B -> A`, and then `compareAndSet(A, newVal)` succeeds even though the underlying data structure was modified; `AtomicStampedReference` (or `AtomicMarkableReference`) solves this by pairing the reference with a monotonically increasing version stamp."),
                QuestionOption("b", "The ABA problem is a deadlock between two `AtomicInteger` variables."),
                QuestionOption("c", "`VolatileReference` solves the ABA problem."),
                QuestionOption("d", "`compareAndSet` automatically checks modification history.")
            ),
            correctOptionId = "a",
            explanation = "In lock-free linked structures (like Treiber stacks), recycling a node `A` after `A -> B -> A` can corrupt pointers under plain CAS; `AtomicStampedReference` checks `(expectedRef, expectedStamp)` together."
        ),
        QuizQuestion(
            id = "jv_adv_32",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `LongAdder` (Java 8+) significantly faster than `AtomicLong` when dozens of threads concurrently increment a single counter (`adder.increment()`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`LongAdder` uses `synchronized` blocks instead of CAS."),
                QuestionOption("b", "`LongAdder` stripes updates across an array of padded `Cell` counters on contention so threads update different cells instead of failing CAS loops on one shared cache line, summing the base and cells only when `sum()` is called."),
                QuestionOption("c", "`LongAdder` drops increments when contention is high."),
                QuestionOption("d", "`LongAdder.sum()` is an atomic snapshot that blocks writers.")
            ),
            correctOptionId = "b",
            explanation = "Under high write contention, `LongAdder` dynamically allocates `@Contended` `Cell`s (hashed by thread probe) to eliminate CAS retry storms; `sum()` aggregates `base + sum(cells)`."
        ),
        QuizQuestion(
            id = "jv_adv_33",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In JVM class loading, how does the **Parent Delegation Model** work when `ClassLoader.loadClass(name)` is called?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "All classes are loaded by a single global class loader."),
                QuestionOption("b", "The child class loader always loads classes from its own JARs first before checking `Bootstrap`."),
                QuestionOption("c", "A class loader first delegates the lookup to its parent (`Application` -> `Platform` -> `Bootstrap` class loader) and only attempts `findClass(name)` itself if the parent hierarchy cannot find the class."),
                QuestionOption("d", "`loadClass` recompiles `.java` files at runtime.")
            ),
            correctOptionId = "c",
            explanation = "Parent delegation ensures core JDK classes like `java.lang.Object` or `java.lang.String` are always loaded by the Bootstrap class loader and cannot be spoofed by application JARs."
        ),
        QuizQuestion(
            id = "jv_adv_34",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When are two classes in the JVM considered the **exact same runtime type** (such that an instance of one can be cast to the other without `ClassCastException`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Whenever they implement the same interface loaded by different class loaders."),
                QuestionOption("b", "Whenever they have the same fully qualified class name, regardless of which `ClassLoader` loaded them."),
                QuestionOption("c", "Whenever their `.class` bytecode files have the same SHA-256 hash."),
                QuestionOption("d", "Only when they have BOTH the same binary class name AND were defined by the **exact same `ClassLoader` instance**.")
            ),
            correctOptionId = "d",
            explanation = "In the JVM, a class's runtime identity is the tuple `(DefiningClassLoader, FullyQualifiedClassName)`. Loading the same `com.App` bytecode in two sibling custom class loaders produces two incompatible types (`ClassCastException: com.App cannot be cast to com.App`)!"
        ),
        QuizQuestion(
            id = "jv_adv_35",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does the Java compiler generate a synthetic **bridge method** in `class IntNode extends Node<Integer>` when overriding `void setData(T data)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because type erasure erases `Node<T>.setData(T)` to `setData(Object)`, whereas `IntNode` declares `setData(Integer)`; to preserve polymorphism when called through a `Node` reference, the compiler generates a bridge method `void setData(Object o) { setData((Integer) o); }`."),
                QuestionOption("b", "To bypass `private` access checks."),
                QuestionOption("c", "To inline the method in JIT compilation."),
                QuestionOption("d", "Bridge methods are only generated for `static` methods.")
            ),
            correctOptionId = "a",
            explanation = "Without the synthetic `setData(Object)` bridge method, `IntNode.setData(Integer)` would have a different erased signature from `Node.setData(Object)` and would not override it at the bytecode level!"
        ),
        QuizQuestion(
            id = "jv_adv_36",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How are Java 8+ lambda expressions compiled and instantiated at the bytecode level (`invokedynamic`) compared to anonymous inner classes?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Lambdas generate `Outer\$Lambda\$1.class` files on disk during `javac` compilation."),
                QuestionOption("b", "Anonymous inner classes generate a separate `.class` file at compile time (`Outer\$1.class`), whereas lambdas emit an `invokedynamic` instruction that delegates to `LambdaMetafactory.metafactory` at runtime to spin/link the functional interface implementation dynamically (and reuse singletons for stateless lambdas)."),
                QuestionOption("c", "Lambdas use `java.lang.reflect.Proxy` on every invocation."),
                QuestionOption("d", "Lambdas are macro-expanded inline by `javac`.")
            ),
            correctOptionId = "b",
            explanation = "Using `invokedynamic` + `LambdaMetafactory` avoids classfile bloat on disk, caches stateless lambda instances, and allows the JVM to evolve lambda linkage strategies in future releases."
        ),
        QuizQuestion(
            id = "jv_adv_37",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What are the five method invocation bytecode instructions in the JVM, and which one is used to call an `interface` method vs a `private`/constructor/`super` method?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`invokespecial` is used for `interface` methods."),
                QuestionOption("b", "`invokevirtual` calls `static` methods and `invokestatic` calls constructors."),
                QuestionOption("c", "`invokeinterface` calls interface methods, `invokespecial` calls constructors (`<init>`), `private` methods, and `super.method()`, `invokevirtual` calls normal virtual instance methods, `invokestatic` calls `static` methods, and `invokedynamic` links dynamic call sites."),
                QuestionOption("d", "`invokedynamic` is used for `super()` constructor calls.")
            ),
            correctOptionId = "c",
            explanation = "Understanding `invokestatic`, `invokevirtual`, `invokeinterface`, `invokespecial`, and `invokedynamic` explains why static/private methods don't dynamically dispatch while interface and virtual methods do."
        ),
        QuizQuestion(
            id = "jv_adv_38",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In HotSpot JVM JIT optimization, what is **Escape Analysis**, and what two optimizations does it enable when an object does NOT escape a method or thread?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It converts `ArrayList` into `LinkedList`."),
                QuestionOption("b", "It moves all objects directly to Old Generation."),
                QuestionOption("c", "It disables garbage collection for the entire thread."),
                QuestionOption("d", "Escape Analysis proves an object reference never escapes the current method/thread, enabling **Scalar Replacement** (replacing the heap allocation with CPU registers/stack locals) and **Lock Elision** (removing uncontended `synchronized` locks on thread-local objects).")
            ),
            correctOptionId = "d",
            explanation = "Rather than raw stack allocation of full object headers, HotSpot's C2 compiler performs **Scalar Replacement**: decomposing a non-escaping object into its primitive/reference fields in registers so no object is allocated at all."
        ),
        QuizQuestion(
            id = "jv_adv_39",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In JVM Garbage Collection, what qualifies as a **GC Root** when tracing live object reachability?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Local variables and parameters on active thread stacks, active Java threads, `static` fields of loaded classes, and JNI references."),
                QuestionOption("b", "Any object with a non-null field."),
                QuestionOption("c", "Objects that override `finalize()`."),
                QuestionOption("d", "Entries inside a `WeakHashMap`.")
            ),
            correctOptionId = "a",
            explanation = "Tracing garbage collectors (G1, ZGC, Shenandoah) start from GC Roots (thread stacks, class statics, JNI globals) and mark all transitively reachable objects as live; unreachable cycles are reclaimed."
        ),
        QuizQuestion(
            id = "jv_adv_40",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How do `SoftReference<T>`, `WeakReference<T>`, and `PhantomReference<T>` differ in JVM garbage collection?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`PhantomReference.get()` returns the object until `System.gc()` is called."),
                QuestionOption("b", "`WeakReference` is cleared on the very next GC cycle once the referent is only weakly reachable; `SoftReference` is retained longer and cleared under memory pressure (before `OutOfMemoryError`); `PhantomReference.get()` ALWAYS returns `null` and is enqueued in a `ReferenceQueue` for post-mortem cleanup after the referent is finalized/unreachable."),
                QuestionOption("c", "`SoftReference` is cleared before `WeakReference`."),
                QuestionOption("d", "`WeakReference` prevents `OutOfMemoryError` by writing objects to disk.")
            ),
            correctOptionId = "b",
            explanation = "`SoftReference` is memory-sensitive, `WeakReference` is collected eagerly when no strong/soft refs remain, and `PhantomReference` (with `ReferenceQueue` or `Cleaner`) provides safe non-resurrecting resource cleanup."
        ),
        QuizQuestion(
            id = "jv_adv_41",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why was `Object.finalize()` deprecated in Java 9 andDeprecated-for-Removal in Java 18 in favor of `java.lang.ref.Cleaner` (or `try-with-resources`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `Cleaner` closes resources synchronously at the end of a method without GC."),
                QuestionOption("b", "Because `finalize()` runs immediately when a variable goes out of scope."),
                QuestionOption("c", "`finalize()` has unpredictable latency, slows allocation/collection of finalizable objects, swallows uncaught exceptions on finalizer threads, and allows accidental object resurrection (`this` leaked in `finalize`); `Cleaner` uses phantom references without exposing `this`."),
                QuestionOption("d", "Because `finalize()` is only called on primitive arrays.")
            ),
            correctOptionId = "c",
            explanation = "`Cleaner` registers a `Runnable` state action (which must NOT hold a reference to the cleaned object) backed by a `PhantomReference` queue, preventing object resurrection."
        ),
        QuizQuestion(
            id = "jv_adv_42",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java 7+ (since JDK 7u6), how does `String.substring(begin, end)` work in memory compared to JDK 6?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`substring` mutates the original `String`."),
                QuestionOption("b", "In Java 17, `substring` still shares the original `String`'s backing array with `offset` and `count` fields."),
                QuestionOption("c", "`substring` interns every returned string in the String Pool."),
                QuestionOption("d", "In Java 7u6+, `substring` allocates a **new backing `byte[]`/`char[]` array** copying only the requested range (`O(length)`), preventing a tiny substring from pinning a huge 10 MB parent `String` array in memory as happened in JDK 6.")
            ),
            correctOptionId = "d",
            explanation = "JDK 7u6 removed `offset` and `count` from `java.lang.String` and made `substring` copy the sub-range so small substrings cannot leak large source buffers."
        ),
        QuizQuestion(
            id = "jv_adv_43",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What optimization did **Compact Strings** (JEP 254, Java 9+) introduce to `java.lang.String`'s internal storage?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Replaced `char[]` with `byte[] value` plus a 1-byte `coder` field (`LATIN1` or `UTF16`): strings containing only ISO-8859-1 / Latin-1 characters use 1 byte per character instead of 2 bytes."),
                QuestionOption("b", "Compressed all strings using GZIP."),
                QuestionOption("c", "Stored all strings in UTF-8 variable-width encoding."),
                QuestionOption("d", "Limited strings to 256 characters.")
            ),
            correctOptionId = "a",
            explanation = "With Compact Strings (enabled by default in Java 9+), pure Latin-1 strings consume half the character buffer memory (`1 byte/char` vs `2 bytes/char` UTF-16)."
        ),
        QuizQuestion(
            id = "jv_adv_44",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java Serialization, what happens if a class implements `Serializable` without declaring `private static final long serialVersionUID`, and a new method or field is later added to the class?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Serialization fails to compile without an explicit `serialVersionUID`."),
                QuestionOption("b", "The JVM computes a default `serialVersionUID` hash from the class's fields, methods, and modifiers; changing the class alters the computed hash, causing deserialization of older payloads to fail with `InvalidClassException`."),
                QuestionOption("c", "The default `serialVersionUID` is always `1L`."),
                QuestionOption("d", "Adding a method never changes the default computed `serialVersionUID`.")
            ),
            correctOptionId = "b",
            explanation = "Declaring an explicit `private static final long serialVersionUID = ...L;` keeps the stream version identifier stable across compatible class evolution."
        ),
        QuizQuestion(
            id = "jv_adv_45",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When an object is deserialized via `ObjectInputStream.readObject()`, which constructor of the `Serializable` class is invoked?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The constructor with the most parameters."),
                QuestionOption("b", "The public no-arg constructor of the `Serializable` class."),
                QuestionOption("c", "**No constructor** of the `Serializable` class is invoked; instead, the JVM invokes the no-arg constructor of the first **non-serializable superclass** (e.g., `Object()`) and populates the serializable fields from the byte stream."),
                QuestionOption("d", "A synthetic `static` constructor.")
            ),
            correctOptionId = "c",
            explanation = "Standard classes bypass their own constructors during deserialization (Note: Java 16+ `record` serialization is an exception that DOES invoke the canonical record constructor!)."
        ),
        QuizQuestion(
            id = "jv_adv_46",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Wait—why is deserializing a Java 16+ `record` much safer than deserializing a traditional `Serializable` class?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Records ignore `serialVersionUID` mismatches only on primitives."),
                QuestionOption("b", "Records cannot implement `Serializable`."),
                QuestionOption("c", "Records encrypt their serialized bytes automatically."),
                QuestionOption("d", "Record deserialization ALWAYS invokes the record's **canonical constructor** (running all validation invariants in the constructor) rather than bypassing constructors and populating fields reflectively.")
            ),
            correctOptionId = "d",
            explanation = "Because `Record` deserialization extracts component values from the stream and passes them through the canonical constructor, invalid/tampered state is rejected by normal constructor validation."
        ),
        QuizQuestion(
            id = "jv_adv_47",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a `Serializable` singleton class, why is implementing `private Object readResolve()` (or using a 1-element `enum`) necessary to preserve the singleton property across deserialization?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`ObjectInputStream.readObject()` allocates a brand-new instance by default; defining `readResolve() { return INSTANCE; }` replaces the newly deserialized object with the canonical singleton (and an `enum` singleton guarantees this automatically by the JVM)."),
                QuestionOption("b", "Because singletons cannot implement `Serializable`."),
                QuestionOption("c", "`readResolve` prevents `writeObject` from running."),
                QuestionOption("d", "`readResolve` is called before serialization starts.")
            ),
            correctOptionId = "a",
            explanation = "Without `readResolve()` (or an `enum` singleton), every `readObject()` call creates a distinct duplicate instance of the singleton."
        ),
        QuizQuestion(
            id = "jv_adv_48",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `java.lang.reflect.Proxy.newProxyInstance(loader, interfaces, invocationHandler)` create dynamic proxies, and what is its main limitation?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It can proxy any concrete or `final` class."),
                QuestionOption("b", "It generates a proxy class at runtime that implements the specified **interfaces** and forwards all method calls to `InvocationHandler.invoke(...)`; it can ONLY proxy interfaces, not concrete classes (unlike bytecode libraries such as ByteBuddy/CGLIB)."),
                QuestionOption("c", "It modifies the target object's bytecode in place."),
                QuestionOption("d", "It only works on `Serializable` classes.")
            ),
            correctOptionId = "b",
            explanation = "JDK Dynamic Proxies extend `java.lang.reflect.Proxy` (consuming the single superclass slot), so they can only implement interfaces."
        ),
        QuizQuestion(
            id = "jv_adv_49",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java 9+ Modules (JPMS) and Java 17 strong encapsulation, why does calling `field.setAccessible(true)` on a private field of `java.lang.String` or `java.util.ArrayList` fail by default?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `private` fields are erased at runtime."),
                QuestionOption("b", "Because `setAccessible` was removed from the JDK in Java 17."),
                QuestionOption("c", "`setAccessible(true)` throws `InaccessibleObjectException` unless the target module explicitly **opens** the package (`opens pkg` in `module-info.java` or `--add-opens` on the JVM command line)."),
                QuestionOption("d", "It only fails if a `SecurityManager` is installed.")
            ),
            correctOptionId = "c",
            explanation = "Java 16/17 enabled strong encapsulation of JDK internals by default (`--illegal-access=deny`), requiring explicit `--add-opens` for deep reflection into non-open modules."
        ),
        QuizQuestion(
            id = "jv_adv_50",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a **heap pollution** warning (`Possible heap pollution from parameterized vararg type`), and why does `@SafeVarargs` only apply to `static`, `final`, or `private` methods (and constructors)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`@SafeVarargs` can be placed on any `abstract` interface method."),
                QuestionOption("b", "`@SafeVarargs` copies the varargs array into a `ThreadLocal`."),
                QuestionOption("c", "Heap pollution means the JVM heap is full."),
                QuestionOption("d", "Varargs `T... args` creates an `Object[]` (or upper-bound array) at runtime that could be aliased and mutated to store a wrong subtype; `@SafeVarargs` suppresses the warning when the method only reads `args` without leaking it, and is restricted to non-overridable methods because a subclass override might not be safe.")
            ),
            correctOptionId = "d",
            explanation = "Because method overriding could violate the varargs safety guarantee, `@SafeVarargs` is only permitted on constructors and `static`, `final`, or (Java 9+) `private` instance methods."
        ),
        QuizQuestion(
            id = "jv_adv_51",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `new T()` or `new T[10]` illegal for a generic type parameter `T` in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because type erasure erases `T` to its bound (`Object`) at runtime, whereas array allocation `new T[10]` and instance creation `new T()` require reified runtime type information (solved by passing `Class<T>` or `IntFunction<T[]>` such as `String[]::new`)."),
                QuestionOption("b", "Because arrays cannot hold reference types."),
                QuestionOption("c", "Because `T` is always a primitive type."),
                QuestionOption("d", "It is legal in Java 17.")
            ),
            correctOptionId = "a",
            explanation = "Notice `stream.toArray(String[]::new)` passes an `IntFunction<String[]>` constructor reference so the runtime can allocate a properly reified `String[]` array!"
        ),
        QuizQuestion(
            id = "jv_adv_52",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `stream.toArray(String[]::new)`, what argument is passed to the `String[]::new` generator function?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "An existing `String[]` array."),
                QuestionOption("b", "An `int` representing the exact size of the output array to allocate (`size -> new String[size]`)."),
                QuestionOption("c", "`0` followed by `stream.count()`."),
                QuestionOption("d", "A `List<String>`.")
            ),
            correctOptionId = "b",
            explanation = "`Stream.toArray(IntFunction<A[]> generator)` invokes `generator.apply(size)` to allocate an array of the exact runtime component type `A[]`."
        ),
        QuizQuestion(
            id = "jv_adv_53",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `java.lang.invoke.VarHandle` (Java 9+), what memory access modes does `VarHandle` provide beyond standard `volatile` fields?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It replaces `Reflection` for calling `private` constructors."),
                QuestionOption("b", "It only supports `volatile` reads and writes."),
                QuestionOption("c", "Fine-grained access modes: **Plain** (`get`/`set`), **Opaque** (`getOpaque`/`setOpaque`), **Acquire/Release** (`getAcquire`/`setRelease`), and **Volatile** (`getVolatile`/`setVolatile`), plus atomic CAS and fetch-and-add operations on fields and array elements without `sun.misc.Unsafe`."),
                QuestionOption("d", "It only works on `static` fields.")
            ),
            correctOptionId = "c",
            explanation = "`VarHandle` is the safe, standard replacement for `sun.misc.Unsafe` field/array atomics and C++11-style memory ordering modes (Plain, Opaque, Acquire/Release, Volatile)."
        ),
        QuizQuestion(
            id = "jv_adv_54",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when `Thread.interrupt()` is called on a thread that is currently blocked inside `Thread.sleep(...)`, `Object.wait()`, or `BlockingQueue.take()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`interrupt()` is ignored until `sleep()` finishes normally."),
                QuestionOption("b", "The thread is immediately terminated with `ThreadDeath`."),
                QuestionOption("c", "The interrupt flag remains `true` after `InterruptedException` is thrown."),
                QuestionOption("d", "The blocking method **clears** the thread's interrupt status flag and immediately throws `InterruptedException` (so a `catch (InterruptedException e)` handler that doesn't rethrow should restore the flag via `Thread.currentThread().interrupt()`).")
            ),
            correctOptionId = "d",
            explanation = "When a blocking JDK method throws `InterruptedException`, it clears the interrupted status flag; swallowing `InterruptedException` without calling `Thread.currentThread().interrupt()` loses the cancellation signal!"
        ),
        QuizQuestion(
            id = "jv_adv_55",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when `Thread.interrupt()` is called on a thread that is executing a CPU-bound loop or non-interruptible I/O (not inside a method that throws `InterruptedException`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It simply sets the thread's boolean **interrupt status flag** to `true` without throwing an exception; the running code must periodically check `Thread.currentThread().isInterrupted()` to stop cooperatively."),
                QuestionOption("b", "The JVM immediately throws an unchecked `InterruptedRuntimeException` in that thread."),
                QuestionOption("c", "The call to `thread.interrupt()` blocks until the target thread calls `sleep()`."),
                QuestionOption("d", "Nothing happens and the flag stays `false`.")
            ),
            correctOptionId = "a",
            explanation = "Interruption in Java is cooperative: if the thread is not in an interruptible blocking call, `interrupt()` merely sets its interrupt flag."
        ),
        QuizQuestion(
            id = "jv_adv_56",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the critical difference between `Thread.interrupted()` (static method) and `thread.isInterrupted()` (instance method)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`isInterrupted()` clears the flag and `Thread.interrupted()` does not."),
                QuestionOption("b", "`Thread.interrupted()` checks the current thread's interrupt status AND **clears** the flag back to `false`, whereas `isInterrupted()` reads the flag without clearing it."),
                QuestionOption("c", "`Thread.interrupted()` interrupts the current thread."),
                QuestionOption("d", "They are identical.")
            ),
            correctOptionId = "b",
            explanation = "Calling `Thread.interrupted()` has the side effect of clearing the current thread's interrupted status!"
        ),
        QuizQuestion(
            id = "jv_adv_57",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why must `obj.wait()` in Java ALWAYS be called inside a `while (!condition)` loop (inside a `synchronized (obj)` block) rather than an `if (!condition)` statement?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `if` statements are not allowed inside `synchronized` blocks."),
                QuestionOption("b", "Because `wait()` does not release the monitor lock on the first call."),
                QuestionOption("c", "Because of **spurious wakeups** (the OS/JVM allows a waiting thread to wake up without `notify`/`notifyAll`) and because another thread could acquire the monitor first after `notifyAll()` and falsify the condition before the awakened thread resumes."),
                QuestionOption("d", "Because `wait()` returns `false` on timeout.")
            ),
            correctOptionId = "c",
            explanation = "Both spurious wakeups and competing consumers waking on `notifyAll()` mean the predicate is not guaranteed to hold when `wait()` returns; re-checking in a `while` loop is mandatory."
        ),
        QuizQuestion(
            id = "jv_adv_58",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What exception is thrown if a thread calls `obj.wait()`, `obj.notify()`, or `obj.notifyAll()` WITHOUT currently holding the intrinsic monitor lock on `obj` (`synchronized (obj)`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`ConcurrentModificationException`"),
                QuestionOption("b", "`InterruptedException`"),
                QuestionOption("c", "`IllegalStateException`"),
                QuestionOption("d", "`IllegalMonitorStateException`")
            ),
            correctOptionId = "d",
            explanation = "A thread must own `obj`'s monitor via `synchronized (obj)` before calling `obj.wait()`, `obj.notify()`, or `obj.notifyAll()`, or `IllegalMonitorStateException` is thrown."
        )
    )

    private fun advancedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "jv_adv_59",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `Thread.sleep(100)` differ from `obj.wait(100)` when called inside a `synchronized (obj)` block?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`obj.wait(100)` **releases** the monitor lock on `obj` while waiting and re-acquires it before returning; `Thread.sleep(100)` **keeps holding** all monitor locks during the sleep."),
                QuestionOption("b", "`Thread.sleep(100)` releases all held monitor locks."),
                QuestionOption("c", "Neither releases the monitor lock."),
                QuestionOption("d", "Both release the monitor lock.")
            ),
            correctOptionId = "a",
            explanation = "`Thread.sleep` pauses the thread without releasing any locks; `Object.wait` atomically releases the target object's monitor and suspends the thread."
        ),
        QuizQuestion(
            id = "jv_adv_60",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `ThreadPoolExecutor`, in what order does the executor handle a newly submitted task relative to `corePoolSize`, the work `BlockingQueue`, and `maximumPoolSize`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "1) Spawn threads up to `maximumPoolSize` first; 2) Only enqueue tasks after `maximumPoolSize` is reached."),
                QuestionOption("b", "1) If running threads `< corePoolSize`, spawn a new core thread; 2) Else offer the task to the **work queue**; 3) Only if the work queue is **full** AND running threads `< maximumPoolSize`, spawn a non-core thread; 4) Otherwise invoke `RejectedExecutionHandler`."),
                QuestionOption("c", "Enqueue all tasks before creating the first thread."),
                QuestionOption("d", "Create a new thread for every task regardless of `maximumPoolSize`.")
            ),
            correctOptionId = "b",
            explanation = "A classic gotcha: `ThreadPoolExecutor` prefers queuing over spawning threads above `corePoolSize`! Thus, an unbounded `LinkedBlockingQueue` means `maximumPoolSize` is never used beyond `corePoolSize`."
        ),
        QuizQuestion(
            id = "jv_adv_61",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `ThreadPoolExecutor`, what happens if you configure `corePoolSize = 4`, `maximumPoolSize = 16`, and pass an **unbounded** `new LinkedBlockingQueue<>()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It throws `IllegalArgumentException` at construction time."),
                QuestionOption("b", "The pool immediately scales up to 16 threads under load."),
                QuestionOption("c", "The pool will NEVER create more than `4` threads (`corePoolSize`) because `queue.offer(task)` on an unbounded queue always succeeds, so the condition for spawning threads up to `maximumPoolSize` (`queue full`) is never triggered."),
                QuestionOption("d", "Tasks are rejected once 16 tasks are queued.")
            ),
            correctOptionId = "c",
            explanation = "Because non-core threads (`> corePoolSize`) are only spawned when `workQueue.offer(command)` returns `false`, an unbounded queue renders `maximumPoolSize` ineffective."
        ),
        QuizQuestion(
            id = "jv_adv_62",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Among the 4 standard `ThreadPoolExecutor` rejection policies (`AbortPolicy`, `CallerRunsPolicy`, `DiscardPolicy`, `DiscardOldestPolicy`), what does `CallerRunsPolicy` do when the queue and pool are full?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It spawns an temporary daemon thread."),
                QuestionOption("b", "It throws `RejectedExecutionException`."),
                QuestionOption("c", "It silently drops the task."),
                QuestionOption("d", "Unless the executor is shut down, it executes the task **synchronously on the submitting caller thread**, providing natural backpressure by slowing down the producer.")
            ),
            correctOptionId = "d",
            explanation = "`CallerRunsPolicy` throttles task submission naturally by making the producer thread run the overflow task itself."
        ),
        QuizQuestion(
            id = "jv_adv_63",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between a **user thread** (non-daemon) and a **daemon thread** (`thread.setDaemon(true)`) when the JVM decides whether to exit?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The JVM exits automatically as soon as all **non-daemon** (user) threads have finished, abruptly terminating any remaining daemon threads without running their `finally` blocks."),
                QuestionOption("b", "The JVM waits for all daemon threads to finish before exiting."),
                QuestionOption("c", "Daemon threads run at higher CPU priority."),
                QuestionOption("d", "`setDaemon(true)` can be called after `thread.start()`.")
            ),
            correctOptionId = "a",
            explanation = "Daemon threads are background support threads (like GC or timer threads) that do not keep the JVM process alive; `setDaemon(true)` must be called before `thread.start()`."
        ),
        QuizQuestion(
            id = "jv_adv_64",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a `ForkJoinPool` work-stealing deque, from which end of its own deque does a worker thread pop tasks vs from which end do idle thief threads steal tasks?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both owner and thief threads take from the head (FIFO)."),
                QuestionOption("b", "The owner worker thread pushes and pops tasks at the **tail** (LIFO, for locality and smaller subtasks), whereas thief threads steal from the **head** (FIFO, taking larger overarching subtasks and minimizing contention with the owner)."),
                QuestionOption("c", "Both take from the tail (LIFO)."),
                QuestionOption("d", "Thief threads steal from the middle of the deque.")
            ),
            correctOptionId = "b",
            explanation = "LIFO owner access + FIFO work stealing minimizes lock contention between the owner and thieves and steals the largest remaining work chunks first."
        ),
        QuizQuestion(
            id = "jv_adv_65",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can `Stream.parallel()` perform poorly or produce wrong results if the lambda passed to `forEach` or `map` mutates a shared unsynchronized `ArrayList` (`List<Integer> out = new ArrayList<>(); stream.parallel().forEach(out::add);`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`parallel()` throws `ConcurrentModificationException` before starting."),
                QuestionOption("b", "`parallel()` automatically synchronizes `out::add`."),
                QuestionOption("c", "`ArrayList.add` is not thread-safe, so concurrent threads in a parallel stream cause data races, lost elements, `null` gaps, or `ArrayIndexOutOfBoundsException` during internal array resizing; use stateless `.collect(Collectors.toList())` or `.toList()` instead!"),
                QuestionOption("d", "It only loses elements on 32-bit JVMs.")
            ),
            correctOptionId = "c",
            explanation = "Parallel stream reduction via `.collect(Collectors.toList())` accumulates into separate thread-local lists per subtask and merges them safely without shared mutable state."
        ),
        QuizQuestion(
            id = "jv_adv_66",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is **false sharing** in multi-threaded Java applications, and how does `@jdk.internal.vm.annotation.Contended` (or manual `long` padding, as used in `LongAdder` and `ForkJoinPool`) prevent it?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "When a `ReentrantLock` is acquired by two threads simultaneously."),
                QuestionOption("b", "When two threads share the same `ThreadLocal` object."),
                QuestionOption("c", "When two `String` literals share the same String Pool reference."),
                QuestionOption("d", "When two threads on different CPU cores frequently write to independent variables that reside on the **same 64-byte CPU cache line**, the hardware cache-coherence protocol (MESI) invalidates the entire cache line back and forth; padding separates the variables onto distinct cache lines.")
            ),
            correctOptionId = "d",
            explanation = "CPU caches track coherence at cache-line granularity (typically 64 bytes). Padding hot independent counters by 64–128 bytes prevents cache-line ping-ponging across cores."
        ),
        QuizQuestion(
            id = "jv_adv_67",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java's `ServiceLoader<S>` (SPI — Service Provider Interface), how are implementations of an interface `com.example.Plugin` discovered on the classpath (or module path)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Via `META-INF/services/com.example.Plugin` resource files listing the fully qualified implementation class names (or `provides ... with ...` directives in `module-info.java` in Java 9+)."),
                QuestionOption("b", "By scanning every class in every JAR on startup with reflection."),
                QuestionOption("c", "Via `@Autowired` annotations."),
                QuestionOption("d", "Via environment variables.")
            ),
            correctOptionId = "a",
            explanation = "`ServiceLoader.load(Plugin.class)` lazily discovers and instantiates provider classes declared in `META-INF/services/` or `module-info.java` (`uses` / `provides`)."
        ),
        QuizQuestion(
            id = "jv_adv_68",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `WeakHashMap<K, V>` use weak references for—its **keys** or its **values**—and what happens when a key is no longer strongly reachable outside the map?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Its values are held via `WeakReference` and keys are strongly referenced."),
                QuestionOption("b", "Its **keys** are held via `WeakReference` (while values are strongly referenced by the entry); once a key has no strong references elsewhere and is GC'd, the map purges that key-value entry on subsequent map operations."),
                QuestionOption("c", "Both keys and values are held via `WeakReference`."),
                QuestionOption("d", "Entries are never removed until `clear()` is called.")
            ),
            correctOptionId = "b",
            explanation = "`WeakHashMap`'s `Entry<K,V> extends WeakReference<Object>` wraps the key; note that if the `value` strongly references its own `key`, the key will never be garbage-collected!"
        ),
        QuizQuestion(
            id = "jv_adv_69",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `java.nio.ByteBuffer`, what do `flip()`, `clear()`, and `rewind()` do to the buffer's `position` and `limit`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`clear()` zeroes out all bytes in the underlying array."),
                QuestionOption("b", "`flip()` reverses the byte order (`BIG_ENDIAN` <-> `LITTLE_ENDIAN`)."),
                QuestionOption("c", "`flip()` sets `limit = position` and `position = 0` (switching from writing into the buffer to reading from it); `clear()` sets `position = 0` and `limit = capacity`; `rewind()` sets `position = 0` and leaves `limit` unchanged."),
                QuestionOption("d", "`rewind()` sets `limit = 0`.")
            ),
            correctOptionId = "c",
            explanation = "`flip()` prepares a newly written buffer to be drained (`limit = pos; pos = 0`); `clear()` resets indices for fresh writing without erasing the underlying bytes."
        ),
        QuizQuestion(
            id = "jv_adv_70",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between a **Heap `ByteBuffer`** (`ByteBuffer.allocate(n)`) and a **Direct `ByteBuffer`** (`ByteBuffer.allocateDirect(n)`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Direct `ByteBuffer` is garbage-collected immediately when the method returns."),
                QuestionOption("b", "Direct `ByteBuffer` is allocated on the thread stack."),
                QuestionOption("c", "Heap `ByteBuffer` cannot be larger than 64 KB."),
                QuestionOption("d", "A Heap `ByteBuffer` wraps a standard JVM `byte[]` on the garbage-collected heap, whereas a Direct `ByteBuffer` allocates off-heap native OS memory so native I/O channels can read/write directly via DMA without copying through a temporary native buffer.")
            ),
            correctOptionId = "d",
            explanation = "`ByteBuffer.allocateDirect` avoids intermediate JVM-heap-to-native-heap copies during OS socket/file `Channel` I/O, though allocation cost is higher so direct buffers are typically pooled or long-lived."
        ),
        QuizQuestion(
            id = "jv_adv_71",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the default byte order (`ByteOrder`) of a newly created `java.nio.ByteBuffer` on any hardware platform (even on little-endian x86_64 or ARM64)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`ByteOrder.BIG_ENDIAN` (network byte order), regardless of the host CPU's native endianness (`ByteOrder.nativeOrder()`)."),
                QuestionOption("b", "`ByteOrder.LITTLE_ENDIAN` on x86_64 and `BIG_ENDIAN` on SPARC."),
                QuestionOption("c", "Always `ByteOrder.nativeOrder()`."),
                QuestionOption("d", "Undefined until `buffer.order(...)` is called.")
            ),
            correctOptionId = "a",
            explanation = "For cross-platform determinism, `ByteBuffer` always defaults to `ByteOrder.BIG_ENDIAN` unless explicitly changed via `buffer.order(ByteOrder.LITTLE_ENDIAN)` or `ByteOrder.nativeOrder()`."
        ),
        QuizQuestion(
            id = "jv_adv_72",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java's `Phaser` synchronizer (Java 7+), what major advantage does `Phaser` have over `CyclicBarrier` and `CountDownLatch`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Phaser` only supports 2 threads."),
                QuestionOption("b", "`Phaser` supports **dynamic registration and deregistration** of parties (`register()`, `arriveAndDeregister()`) across multiple reusable phase numbers, and can be arranged in a tiered tree hierarchy to reduce contention."),
                QuestionOption("c", "`Phaser` cannot be reused after phase 0."),
                QuestionOption("d", "`Phaser` is a lock implementation like `ReentrantLock`.")
            ),
            correctOptionId = "b",
            explanation = "Unlike `CyclicBarrier` (which fixes the party count at construction), `Phaser` lets tasks dynamically join (`register`) and leave (`arriveAndDeregister`) across phases."
        ),
        QuizQuestion(
            id = "jv_adv_73",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `SynchronousQueue<E>` in `java.util.concurrent` have as its storage capacity?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "An unbounded capacity like `LinkedBlockingQueue`."),
                QuestionOption("b", "A default capacity of `1` element."),
                QuestionOption("c", "**Zero** capacity (`isEmpty()` is always `true`): every `put(e)` must wait for a matching `take()` by another thread (a direct handoff rendezvous), and vice versa."),
                QuestionOption("d", "A capacity equal to the number of CPU cores.")
            ),
            correctOptionId = "c",
            explanation = "`SynchronousQueue` has no internal buffer at all—each insertion operation must pair directly with a concurrent removal operation by another thread (used by `Executors.newCachedThreadPool()`)."
        ),
        QuizQuestion(
            id = "jv_adv_74",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `DelayQueue<E extends Delayed>`, when does `queue.take()` or `queue.poll()` return an element?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "After a fixed 1-second interval for all elements."),
                QuestionOption("b", "Immediately in FIFO order."),
                QuestionOption("c", "Only when the queue reaches full capacity."),
                QuestionOption("d", "Only when the element's remaining delay `getDelay(TimeUnit.NANOSECONDS)` has expired (`<= 0`); even if the queue is non-empty, `poll()` returns `null` if the head element's delay has not yet elapsed.")
            ),
            correctOptionId = "d",
            explanation = "`DelayQueue` orders elements by expiration time in a priority heap and only releases the head element once `getDelay(NANOSECONDS) <= 0`."
        ),
        QuizQuestion(
            id = "jv_adv_75",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when an uncaught `RuntimeException` or `Error` is thrown inside a task submitted via `executorService.submit(callableOrRunnable)` vs `executorService.execute(runnable)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`submit(...)` catches the exception and stores it inside the returned `Future<?>`, so the exception is NOT logged or sent to `UncaughtExceptionHandler` unless `future.get()` is called; `execute(...)` lets the exception reach the worker thread's `UncaughtExceptionHandler`."),
                QuestionOption("b", "`submit(...)` immediately crashes the JVM on any exception."),
                QuestionOption("c", "Both print the stack trace to `System.err` immediately."),
                QuestionOption("d", "`execute(...)` returns a `Future<?>` that swallows the exception.")
            ),
            correctOptionId = "a",
            explanation = "A common production bug: calling `executor.submit(task)` and ignoring the returned `Future` silently swallows all exceptions thrown by `task` until `future.get()` is inspected!"
        ),
        QuizQuestion(
            id = "jv_adv_76",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `ScheduledExecutorService`, what is the difference between `scheduleAtFixedRate(task, init, period, unit)` and `scheduleWithFixedDelay(task, init, delay, unit)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`scheduleAtFixedRate` spawns a concurrent overlapping run if a task takes longer than `period`."),
                QuestionOption("b", "`scheduleAtFixedRate` schedules runs relative to the **start** time of each execution (`t0, t0 + P, t0 + 2P`, though never overlapping a single task concurrently); `scheduleWithFixedDelay` waits a full `delay` **after the previous execution finishes** before starting the next."),
                QuestionOption("c", "`scheduleWithFixedDelay` cancels the task if it takes longer than `delay`."),
                QuestionOption("d", "They are identical.")
            ),
            correctOptionId = "b",
            explanation = "Fixed-rate measures start-to-start cadence (catching up if a run was delayed, without concurrent overlap of the same task); fixed-delay measures end-to-next-start pause."
        ),
        QuizQuestion(
            id = "jv_adv_77",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens to a periodic task scheduled with `ScheduledExecutorService.scheduleAtFixedRate` if one execution of its `Runnable` throws an uncaught exception?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The scheduler immediately retries the failed tick 3 times."),
                QuestionOption("b", "The scheduler logs the exception and continues running future ticks normally."),
                QuestionOption("c", "The periodic task is **silently suppressed from all future executions** (and its `ScheduledFuture.get()` throws `ExecutionException`); periodic tasks should wrap their body in `try / catch (Throwable t)` if they must keep running."),
                QuestionOption("d", "The entire `ScheduledExecutorService` shuts down.")
            ),
            correctOptionId = "c",
            explanation = "Per `ScheduledExecutorService.scheduleAtFixedRate` Javadoc: *If any execution of the task encounters an exception, subsequent executions are suppressed.*"
        ),
        QuizQuestion(
            id = "jv_adv_78",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `ReentrantReadWriteLock`, can a thread that currently holds the **write lock** acquire the **read lock** and then release the write lock (**lock downgrading**), and can a thread holding a **read lock** upgrade directly to a **write lock**?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Neither is supported."),
                QuestionOption("b", "Both lock upgrading and lock downgrading are supported."),
                QuestionOption("c", "Lock upgrading is supported, whereas lock downgrading deadlocks."),
                QuestionOption("d", "**Lock downgrading** (write -> acquire read -> unlock write) IS supported safely, whereas **lock upgrading** (holding a read lock and calling `writeLock().lock()`) is NOT supported and will deadlock!")
            ),
            correctOptionId = "d",
            explanation = "If two reader threads both tried to upgrade to a write lock while holding their read locks, neither could proceed until the other released its read lock (deadlock); downgrading from exclusive write to shared read is safe and supported."
        ),
        QuizQuestion(
            id = "jv_adv_79",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `Collections.checkedList(rawbackedList, String.class)` provide when passing a `List<String>` to legacy or untrusted code that uses raw types?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It wraps the list in a dynamic type-checking view that tests every inserted element with `String.class.cast(e)` at runtime, throwing `ClassCastException` **immediately at the point of insertion** rather than later when reading."),
                QuestionOption("b", "It makes the list unmodifiable."),
                QuestionOption("c", "It synchronizes all list methods."),
                QuestionOption("d", "It filters out non-`String` elements already in the list without throwing.")
            ),
            correctOptionId = "a",
            explanation = "Normally type erasure lets raw-type code insert an `Integer` into a `List<String>` undetected until a later read throws `ClassCastException`; `Collections.checkedList` fails fast at insertion time."
        ),
        QuizQuestion(
            id = "jv_adv_80",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java's `Spliterator` (used by `Stream`), what do the characteristics `SIZED`, `SUBSIZED`, `ORDERED`, `IMMUTABLE`, and `CONCURRENT` communicate to the stream execution engine?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "They control thread priority in `ForkJoinPool`."),
                QuestionOption("b", "Metadata about the source structure enabling optimizations—for example, `SIZED | SUBSIZED` allows parallel streams (`ArrayList`) to pre-allocate exact array slices and `count()` in O(1), whereas a `HashSet` spliterator is `SIZED` at the top level but not `SUBSIZED` after splitting."),
                QuestionOption("c", "They encrypt stream elements."),
                QuestionOption("d", "They are only used by `Iterator.remove()`.")
            ),
            correctOptionId = "b",
            explanation = "`Spliterator.characteristics()` bitmasks let the stream pipeline elide sorting (`SORTED`), elide `distinct()` (`DISTINCT`), elide traversal for `count()` (`SIZED`), and split balanced chunks (`SUBSIZED`)."
        ),
        QuizQuestion(
            id = "jv_adv_81",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does `Arrays.stream(intArray)` split much more efficiently for parallel stream execution than `Stream.iterate(0, n -> n + 1).limit(1_000_000)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Stream.iterate` cannot be used with `.parallel()`."),
                QuestionOption("b", "`Arrays.stream` uses GPU acceleration."),
                QuestionOption("c", "An array spliterator is `SIZED` and `SUBSIZED` with O(1) index-midpoint splitting (`trySplit`), whereas `Stream.iterate` is sequential/unindexed and must buffer batches into arrays to split, incurring heavy overhead."),
                QuestionOption("d", "Both split in O(1) time.")
            ),
            correctOptionId = "c",
            explanation = "Random-access array sources (`ArrayList`, `int[]`, `IntStream.range`) split at the exact index midpoint in O(1) with zero copying (`SUBSIZED`), making them ideal for parallel streams."
        ),
        QuizQuestion(
            id = "jv_adv_82",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java 9+, how does the 3-argument `Stream.iterate(seed, hasNextPredicate, nextUnaryOperator)` improve upon the 2-argument `Stream.iterate(seed, next)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It iterates backward."),
                QuestionOption("b", "It executes in parallel without boxing."),
                QuestionOption("c", "It caches all generated elements in a `Map`."),
                QuestionOption("d", "It produces a finite stream that terminates as soon as `hasNextPredicate` returns `false` (just like a `for (T x = seed; hasNext(x); x = next(x))` loop).")
            ),
            correctOptionId = "d",
            explanation = "`Stream.iterate(1, n -> n < 100, n -> n * 2)` (Java 9+) terminates cleanly via the predicate without needing `.takeWhile(...)`."
        ),
        QuizQuestion(
            id = "jv_adv_83",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `Stream.iterate(1, n -> n * 2).filter(n -> n < 100).toList()` an **infinite loop** whereas `Stream.iterate(1, n -> n * 2).takeWhile(n -> n < 100).toList()` terminates with `[1, 2, 4, 8, 16, 32, 64]`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`filter` does not know the stream is monotonically increasing and keeps pulling elements from the infinite `iterate` source forever looking for more matches, whereas `takeWhile` short-circuits and closes the stream on the first element (`128`) that fails the predicate."),
                QuestionOption("b", "Because `filter` is a terminal operation."),
                QuestionOption("c", "Because `takeWhile` only takes 7 elements maximum."),
                QuestionOption("d", "Both terminate with the same list.")
            ),
            correctOptionId = "a",
            explanation = "On an infinite stream, `filter` never terminates the stream on its own; `takeWhile` (or `limit` / 3-arg `iterate`) is required to bound termination."
        ),
        QuizQuestion(
            id = "jv_adv_84",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `ClassLoader`, what is the difference between `Class.forName(name)` and `Class.forName(name, false, loader)` (or `loader.loadClass(name)`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both run `static {}` blocks immediately."),
                QuestionOption("b", "1-arg `Class.forName(name)` loads, links, AND **initializes** the class (running its `static {}` blocks immediately), whereas `Class.forName(name, false, loader)` and `loader.loadClass(name)` load the class object WITHOUT running `static {}` initialization until first active use."),
                QuestionOption("c", "`loader.loadClass` runs `static {}` blocks, whereas `Class.forName` does not."),
                QuestionOption("d", "`Class.forName(name, false, loader)` throws `ClassNotFoundException` if the class has a `static {}` block.")
            ),
            correctOptionId = "b",
            explanation = "`initialize = false` in `Class.forName(name, false, loader)` defers `<clinit>` execution until the class is first instantiated or a non-constant static member is accessed."
        ),
        QuizQuestion(
            id = "jv_adv_85",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does referencing a compile-time constant `public static final int VERSION = 42;` or `public static final String ID = \"v1\";` on class `Config` NOT trigger `Config`'s `static {}` initializer block?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `static {}` blocks only run when `new Config()` is called."),
                QuestionOption("b", "Because `static final` fields are stored in `java.lang.Object`."),
                QuestionOption("c", "Compile-time constants (`static final` primitives and `String` literals initialized with constant expressions) are inlined directly into the caller's bytecode constant pool by `javac`, so `Config` is not even loaded or initialized at runtime for that read!"),
                QuestionOption("d", "Referencing `Config.VERSION` DOES run `Config`'s `static {}` block.")
            ),
            correctOptionId = "c",
            explanation = "Per the Java Language Specification (§12.4.1), reading a constant variable (`ConstantValue` attribute in classfile) does not trigger class initialization of the declaring class."
        ),
        QuizQuestion(
            id = "jv_adv_86",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Contrastingly, why DOES referencing `public static final Integer BOXED = 42;` or `public static final String DYNAMIC = UUID.randomUUID().toString();` trigger class initialization?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Neither triggers class initialization."),
                QuestionOption("b", "Because `Integer` is in `java.util`."),
                QuestionOption("c", "Because `UUID` is a `record`."),
                QuestionOption("d", "Because neither a boxed `Integer` nor a method call (`randomUUID()`) is a compile-time constant expression, so their values must be computed at runtime inside `<clinit>` when the class is initialized.")
            ),
            correctOptionId = "d",
            explanation = "Only `static final` primitive or `String` fields initialized with compile-time constant expressions are inlined at compile time."
        ),
        QuizQuestion(
            id = "jv_adv_87",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java's `MethodHandles.Lookup` API (`java.lang.invoke`), how does a `MethodHandle` differ from `java.lang.reflect.Method` regarding access checking?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`MethodHandles.Lookup` performs access control checks **once at lookup/creation time** (based on the caller class that created the `Lookup` object), whereas `Method.invoke` checks access on **every invocation** unless `setAccessible(true)` was called."),
                QuestionOption("b", "`MethodHandle` checks access on every `invokeExact` call."),
                QuestionOption("c", "`MethodHandle` bypasses all `private` access checks without `privateLookupIn`."),
                QuestionOption("d", "`Method` checks access only when `getMethod` is called.")
            ),
            correctOptionId = "a",
            explanation = "Because `MethodHandle` validates access at lookup time and has strongly typed `invokeExact` descriptors, the JIT can inline `MethodHandle` invocations much more effectively than reflective `Method.invoke`."
        ),
        QuizQuestion(
            id = "jv_adv_88",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when calling `methodHandle.invokeExact(arg)` if the static compile-time type of `arg` at the call site is `Object` (even if its runtime value is a `String` matching a `(String)int` handle)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It automatically casts `Object` to `String` and succeeds."),
                QuestionOption("b", "It throws `WrongMethodTypeException` at runtime because `invokeExact` requires an **exact** descriptor match between the call-site static types and the handle's `MethodType` (without automatic casts or boxing, unlike `.invoke(...)`)."),
                QuestionOption("c", "It fails to compile."),
                QuestionOption("d", "It returns `null`.")
            ),
            correctOptionId = "b",
            explanation = "`MethodHandle.invokeExact` requires the exact `MethodType` signature at the call site; `MethodHandle.invoke` performs loose conversions (casting and autoboxing) as needed."
        ),
        QuizQuestion(
            id = "jv_adv_89",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `java.util.concurrent.Exchanger<V>`, what happens when Thread A calls `exchanger.exchange(bufferA)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Thread A broadcasts `bufferA` to all waiting threads."),
                QuestionOption("b", "Thread A places `bufferA` in a queue and returns `null` immediately."),
                QuestionOption("c", "Thread A blocks until another Thread B calls `exchanger.exchange(bufferB)` on the same `Exchanger`, at which point they atomically swap objects (Thread A receives `bufferB` and Thread B receives `bufferA`)."),
                QuestionOption("d", "Thread A swaps `bufferA` with a copy of `bufferA`.")
            ),
            correctOptionId = "c",
            explanation = "`Exchanger<V>` is a two-thread synchronization point for swapping buffers (e.g., double-buffering between a producer filling a buffer and a consumer draining the previous buffer)."
        ),
        QuizQuestion(
            id = "jv_adv_90",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `LockSupport.park()` / `LockSupport.unpark(thread)` (the primitive underlying `AbstractQueuedSynchronizer` and `ReentrantLock`) do if `unpark(thread)` is called BEFORE `thread` calls `park()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Permits accumulate up to 100 so the next 100 `park()` calls return immediately."),
                QuestionOption("b", "The `unpark` signal is lost and `park()` blocks forever."),
                QuestionOption("c", "`unpark` throws `IllegalMonitorStateException`."),
                QuestionOption("d", "`unpark(thread)` makes a single **permit** available for `thread`, so the next call to `LockSupport.park()` by `thread` consumes that permit and returns **immediately without blocking** (unlike `Object.notify()` before `wait()`, which is lost!).")
            ),
            correctOptionId = "d",
            explanation = "`LockSupport` uses a binary permit (at most 1 permit stored): calling `unpark(t)` before `t` calls `park()` pre-grants the permit so `park()` does not suffer a lost-wakeup race."
        ),
        QuizQuestion(
            id = "jv_adv_91",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `AbstractQueuedSynchronizer` (AQS), what is the difference between **exclusive mode** (`acquire`/`release`) and **shared mode** (`acquireShared`/`releaseShared`), and which JDK classes use each?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Exclusive mode allows only one thread to hold the state at a time (`ReentrantLock`), whereas shared mode allows multiple threads to acquire concurrently (`Semaphore`, `CountDownLatch`, and the read lock of `ReentrantReadWriteLock`)."),
                QuestionOption("b", "`Semaphore` uses exclusive mode and `ReentrantLock` uses shared mode."),
                QuestionOption("c", "Shared mode is only used by `synchronized` blocks."),
                QuestionOption("d", "AQS only supports exclusive mode.")
            ),
            correctOptionId = "a",
            explanation = "AQS manages a single `volatile int state` and a CLH wait queue supporting both exclusive (`tryAcquire`) and shared (`tryAcquireShared`) acquisition semantics."
        ),
        QuizQuestion(
            id = "jv_adv_92",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When a `ReentrantLock` is created with `new ReentrantLock(true)` (**fair** mode) vs `new ReentrantLock(false)` (**non-fair** default), why does non-fair mode usually achieve much higher throughput under contention?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because fair mode uses `Thread.sleep(10)` on every `lock()` call."),
                QuestionOption("b", "In non-fair mode, a currently running thread requesting the lock can **barge** ahead and acquire a just-released lock immediately before a parked queued thread finishes the ~microseconds OS context-switch wakeup."),
                QuestionOption("c", "Because non-fair mode allows two threads inside the critical section at once."),
                QuestionOption("d", "Fair mode has higher throughput than non-fair mode.")
            ),
            correctOptionId = "b",
            explanation = "Waking a parked thread from the OS kernel takes thousands of CPU cycles; non-fair barging lets an already-running core utilize the lock during that wakeup window, at the cost of potential starvation."
        ),
        QuizQuestion(
            id = "jv_adv_93",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Wait—even on a **fair** `new ReentrantLock(true)`, which method intentionally does NOT honor fairness and will barge ahead if the lock happens to be free at that moment?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`lock.lock()`"),
                QuestionOption("b", "`lock.lockInterruptibly()`"),
                QuestionOption("c", "Zero-argument `lock.tryLock()` (whereas timed `lock.tryLock(0, TimeUnit.SECONDS)` DOES honor the fair queue!)."),
                QuestionOption("d", "`lock.unlock()`")
            ),
            correctOptionId = "c",
            explanation = "As documented in `ReentrantLock.tryLock()`, the untimed `tryLock()` always barges even on a fair lock; if fair polling is required, `tryLock(0, TimeUnit.SECONDS)` checks `hasQueuedPredecessors()`."
        ),
        QuizQuestion(
            id = "jv_adv_94",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when `Collections.synchronizedList(new ArrayList<>())` is iterated over by one thread using `for (String s : syncList)` while another thread calls `syncList.add(\"x\")`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It blocks `syncList.add(\"x\")` until the loop finishes."),
                QuestionOption("b", "`synchronizedList` automatically locks the list for the entire duration of the `for` loop."),
                QuestionOption("c", "`synchronizedList` copies the array on `iterator()` like `CopyOnWriteArrayList`."),
                QuestionOption("d", "It is a data race and can throw `ConcurrentModificationException` because `synchronizedList` synchronizes individual method calls (`get`, `add`, `size`), NOT multi-step `iterator()` traversal—the caller must manually wrap the iteration in `synchronized (syncList) { ... }`!")
            ),
            correctOptionId = "d",
            explanation = "As explicitly stated in `Collections.synchronizedList` Javadoc, iterating over the returned list is NOT automatically synchronized and must be guarded by `synchronized (syncList)`."
        ),
        QuizQuestion(
            id = "jv_adv_95",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java's `String` concatenation since Java 9 (JEP 280), how does `javac` compile `\"User: \" + name + \" (id=\" + id + \")\"` instead of emitting bytecode that instantiates `new StringBuilder().append(...)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It emits an `invokedynamic` call to `StringConcatFactory.makeConcatWithConstants`, which pre-calculates the exact output length and fills a single `byte[]` buffer directly without intermediate `StringBuilder` resizing!"),
                QuestionOption("b", "It calls `String.format` at runtime."),
                QuestionOption("c", "It still emits `new StringBuilder().append(...)` in Java 17."),
                QuestionOption("d", "It interns every concatenated string.")
            ),
            correctOptionId = "a",
            explanation = "JEP 280 (`StringConcatFactory`) replaces bytecode `StringBuilder` chains with an `invokedynamic` bootstrap recipe that computes exact buffer length and writes once."
        ),
        QuizQuestion(
            id = "jv_adv_96",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "However, why does `String s = \"\"; for (int i = 0; i < 10000; i++) { s += i; }` STILL run in O(n^2) time even with Java 9+ `StringConcatFactory`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because `StringConcatFactory` is disabled inside `for` loops."),
                QuestionOption("b", "Because each iteration of the loop executes a separate concatenation `s = s + i`, which must allocate a new `String` and copy the entire prefix `s` built so far; an explicit `StringBuilder` outside the loop is still required!"),
                QuestionOption("c", "It runs in O(n) time in Java 17."),
                QuestionOption("d", "Because `i` is a primitive `int`.")
            ),
            correctOptionId = "b",
            explanation = "`StringConcatFactory` optimizes a single concatenation expression (`a + b + c`), not loop-carried reassignment `s += i` across 10,000 iterations."
        ),
        QuizQuestion(
            id = "jv_adv_97",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `Thread.onSpinWait()` (Java 9+, JEP 285) hint to the JVM and CPU when called inside a short low-level spin-wait loop?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It releases all held `synchronized` locks."),
                QuestionOption("b", "It puts the thread to sleep for 1 millisecond like `Thread.sleep(1)`."),
                QuestionOption("c", "It hints that the thread is in a busy-wait spin loop, allowing the JIT to emit a hardware pause instruction (such as x86 `PAUSE` or ARM `YIELD`) to reduce power consumption, pipeline stalls, and memory-order violation penalties."),
                QuestionOption("d", "It terminates the thread if the spin exceeds 100 iterations.")
            ),
            correctOptionId = "c",
            explanation = "`Thread.onSpinWait()` is a JVM intrinsic that emits `PAUSE`/`YIELD` CPU instructions during tight spin loops."
        ),
        QuizQuestion(
            id = "jv_adv_98",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In `CompletableFuture`, what does `CompletableFuture.allOf(f1, f2, f3)` return, and what happens if `f2` completes exceptionally?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It ignores `f2`'s exception and completes normally."),
                QuestionOption("b", "It returns a `CompletableFuture<List<Object>>` containing the 3 results."),
                QuestionOption("c", "It cancels `f1` and `f3` immediately as soon as `f2` fails."),
                QuestionOption("d", "It returns a `CompletableFuture<Void>` that completes only after **all** three futures have completed (even if `f2` fails early, `allOf` still waits for `f1` and `f3` to finish and then completes the returned future exceptionally with `f2`'s exception).")
            ),
            correctOptionId = "d",
            explanation = "`CompletableFuture.allOf` waits for all input futures to finish before completing; to collect their typed results, map `Stream.of(f1, f2, f3).map(CompletableFuture::join).toList()` in `.thenApply(...)`."
        ),
        QuizQuestion(
            id = "jv_adv_99",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java 9+ `CompletableFuture`, what is the difference between `future.orTimeout(2, TimeUnit.SECONDS)` and `future.completeOnTimeout(fallback, 2, TimeUnit.SECONDS)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`orTimeout` completes the future **exceptionally** with a `TimeoutException` if not done within 2 seconds; `completeOnTimeout` completes the future **normally** with `fallback` if not done within 2 seconds."),
                QuestionOption("b", "Both throw `TimeoutException` immediately."),
                QuestionOption("c", "`completeOnTimeout` blocks the calling thread for 2 seconds."),
                QuestionOption("d", "`orTimeout` returns `Optional.empty()`.")
            ),
            correctOptionId = "a",
            explanation = "Java 9 added native non-blocking timeout support (`orTimeout` and `completeOnTimeout`) directly to `CompletableFuture`."
        ),
        QuizQuestion(
            id = "jv_adv_100",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When a class overrides `clone()` by calling `super.clone()` (`Object.clone()`), what kind of copy does `Object.clone()` perform?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A recursive deep copy of all nested objects."),
                QuestionOption("b", "A field-by-field **shallow copy** (allocating a new instance of the exact runtime class without calling constructors, copying primitive fields by value and reference fields as shared references—throwing `CloneNotSupportedException` if the class does not implement `Cloneable`)."),
                QuestionOption("c", "It invokes the class's copy constructor."),
                QuestionOption("d", "It serializes and deserializes the object.")
            ),
            correctOptionId = "b",
            explanation = "`Object.clone()` checks that the class implements the marker interface `Cloneable` and performs a shallow bitwise field copy without invoking constructors."
        )
    )

}
