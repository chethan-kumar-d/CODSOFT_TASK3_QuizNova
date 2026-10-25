package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object JavaQuestions {
    val questions: List<QuizQuestion> = listOf(
        // ==================== FOUNDATION (15) ====================
        QuizQuestion(
            id = "jv_f_01",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java 17, what is the key difference between comparing two `String` variables with `==` versus `.equals()`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`==` checks whether both references point to the exact same object, whereas `String.equals()` compares their character sequences."),
                QuestionOption("b", "`==` compares character sequences case-insensitively, whereas `.equals()` is case-sensitive."),
                QuestionOption("c", "`.equals()` compares memory addresses, whereas `==` compares character values."),
                QuestionOption("d", "There is no difference in Java 17 because `==` is overloaded for `String`.")
            ),
            correctOptionId = "a",
            explanation = "For reference types in Java, `==` always tests reference identity. `String.equals(Object)` overrides `Object.equals` to compare the actual characters of the two strings."
        ),
        QuizQuestion(
            id = "jv_f_02",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which statement accurately describes a `final` reference variable in Java, such as `final List<String> names = new ArrayList<>();`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`names` cannot be reassigned to point to a different `List` instance, but elements can still be added to or removed from the list."),
                QuestionOption("b", "Both the reference `names` and the contents of the `ArrayList` become completely immutable."),
                QuestionOption("c", "Elements cannot be added to `names`, but `names` can be reassigned to `null`."),
                QuestionOption("d", "The `final` keyword only applies to primitive variables and causes a compile error on `List`.")
            ),
            correctOptionId = "a",
            explanation = "`final` on a variable prevents rebinding the variable reference (`names = ...` is a compile error), but it does not freeze the internal mutable state of the object it points to."
        ),
        QuizQuestion(
            id = "jv_f_03",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When an array `int[] scores = new int[4];` is allocated in Java, what are its elements initialized to before any explicit assignments?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "All four elements are initialized to `0`."),
                QuestionOption("b", "The elements contain arbitrary uninitialized memory values."),
                QuestionOption("c", "All four elements are initialized to `null`."),
                QuestionOption("d", "Accessing `scores[0]` throws a `NullPointerException` until assigned.")
            ),
            correctOptionId = "a",
            explanation = "Java guarantees default initialization for array components: numeric primitive arrays default to `0` (or `0.0`), `boolean[]` to `false`, and reference arrays to `null`."
        ),
        QuizQuestion(
            id = "jv_f_04",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between method overloading and method overriding in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Overloading defines methods with the same name but different parameter lists; overriding replaces an inherited superclass method with the exact same signature."),
                QuestionOption("b", "Overloading requires the `@Override` annotation; overriding does not."),
                QuestionOption("c", "Overriding only changes the return type while keeping a different parameter list."),
                QuestionOption("d", "Overloading is resolved at runtime via dynamic dispatch, while overriding is resolved at compile time.")
            ),
            correctOptionId = "a",
            explanation = "Method overloading uses different parameter types/counts and is resolved at compile time; method overriding provides a subclass implementation for the same method signature and is dispatched dynamically at runtime."
        ),
        QuizQuestion(
            id = "jv_f_05",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In Java, how many classes can a single class directly extend, and how many interfaces can it implement?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It can directly extend at most one class, and it can implement multiple interfaces."),
                QuestionOption("b", "It can directly extend multiple classes, but implement at most one interface."),
                QuestionOption("c", "It can extend at most one class and implement at most one interface."),
                QuestionOption("d", "It can extend multiple classes only if they are `abstract`.")
            ),
            correctOptionId = "a",
            explanation = "Java supports single inheritance of class implementation (`extends` one class) and multiple inheritance of type/interface contracts (`implements` any number of interfaces)."
        ),
        QuizQuestion(
            id = "jv_f_06",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary distinction between a checked exception (such as `IOException`) and an unchecked exception (such as `IllegalArgumentException`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Checked exceptions must be either caught or declared in the method's `throws` clause at compile time; unchecked exceptions (`RuntimeException` subclasses) do not."),
                QuestionOption("b", "Unchecked exceptions cannot be caught with a `try-catch` block."),
                QuestionOption("c", "Checked exceptions occur at compile time, whereas unchecked exceptions occur at runtime."),
                QuestionOption("d", "Checked exceptions immediately terminate the JVM without running `finally` blocks.")
            ),
            correctOptionId = "a",
            explanation = "All exceptions occur at runtime, but the Java compiler enforces that checked exceptions (`Exception` subclasses excluding `RuntimeException`) are either handled or declared with `throws`."
        ),
        QuizQuestion(
            id = "jv_f_07",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why does `List<int>` fail to compile in Java, requiring `List<Integer>` instead?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Java generic type arguments must be reference types (`Object` subtypes), not primitive types."),
                QuestionOption("b", "`List` only accepts `String` elements in Java."),
                QuestionOption("c", "`int` is a package-private keyword that `java.util.List` cannot see."),
                QuestionOption("d", "`List<int>` is only valid when using `LinkedList<int>`.")
            ),
            correctOptionId = "a",
            explanation = "Java generics are implemented via type erasure to `Object` (or an upper bound), so type parameters cannot be primitive types like `int` or `double`; wrapper classes like `Integer` are used instead."
        ),
        QuizQuestion(
            id = "jv_f_08",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which visibility level applies when a class member in Java has no explicit access modifier (`public`, `protected`, or `private`)?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Package-private: accessible only to classes within the same package."),
                QuestionOption("b", "Private: accessible only within the declaring class."),
                QuestionOption("c", "Protected: accessible to classes in the same package and subclasses anywhere."),
                QuestionOption("d", "Public: accessible from any class in the module.")
            ),
            correctOptionId = "a",
            explanation = "Omitting an access modifier gives a field, method, or constructor package-private (default) access, making it visible only within its own package."
        ),
        QuizQuestion(
            id = "jv_f_09",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why cannot a `static` method directly access a non-static instance field `this.count`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A `static` method belongs to the class rather than any specific instance, so there is no implicit `this` object."),
                QuestionOption("b", "Instance fields are stored in read-only memory when `static` methods run."),
                QuestionOption("c", "`static` methods execute at compile time before objects exist."),
                QuestionOption("d", "Non-static fields can only be accessed inside constructors.")
            ),
            correctOptionId = "a",
            explanation = "Because a `static` method is invoked on the class without requiring an instance, it has no `this` reference unless an object instance is explicitly passed to it."
        ),
        QuizQuestion(
            id = "jv_f_10",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why is `StringBuilder` preferred over repeated `+` concatenation on a `String` inside a large loop?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`String` is immutable, so each loop iteration creates a new intermediate object and copies characters, whereas `StringBuilder` mutates a resizable buffer."),
                QuestionOption("b", "The `+` operator on `String` is not allowed inside `for` or `while` loops."),
                QuestionOption("c", "`StringBuilder` automatically compresses strings using gzip."),
                QuestionOption("d", "`String` objects cannot exceed 255 characters in length.")
            ),
            correctOptionId = "a",
            explanation = "Repeatedly reassigning `str = str + part` in a loop allocates a new `String` and copies existing characters on each iteration (O(n²) total copying), while `StringBuilder.append` amortizes appends in O(n)."
        ),
        QuizQuestion(
            id = "jv_f_11",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which `java.util.Set` implementation preserves the exact insertion order of elements while preventing duplicates?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`LinkedHashSet`"),
                QuestionOption("b", "`HashSet`"),
                QuestionOption("c", "`TreeSet`"),
                QuestionOption("d", "`ArrayList`")
            ),
            correctOptionId = "a",
            explanation = "`LinkedHashSet` maintains a doubly-linked list running through its hash table entries, preserving insertion order. `HashSet` has no order guarantee, and `TreeSet` sorts elements."
        ),
        QuizQuestion(
            id = "jv_f_12",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does a `record` declaration like `public record Coordinate(int x, int y) {}` automatically generate in Java 17?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`private final` fields, a canonical constructor, `x()` and `y()` accessors, and value-based `equals()`, `hashCode()`, and `toString()`."),
                QuestionOption("b", "Mutable `private` fields along with `getX()`, `setX()`, `getY()`, and `setY()` methods."),
                QuestionOption("c", "An abstract base class that subclasses can extend to add fields."),
                QuestionOption("d", "A database table schema for SQLite.")
            ),
            correctOptionId = "a",
            explanation = "Java records (finalized in Java 16) are shallowly immutable data carriers that automatically synthesize `private final` component fields, accessor methods (`x()`, `y()`), and canonical `equals`/`hashCode`/`toString`."
        ),
        QuizQuestion(
            id = "jv_f_13",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a Java constructor, what rule applies when calling another constructor via `this(...)` or a superclass constructor via `super(...)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The `this(...)` or `super(...)` invocation must be the first statement in the constructor body."),
                QuestionOption("b", "Both `this(...)` and `super(...)` must be called in the same constructor."),
                QuestionOption("c", "`super(...)` must always be placed at the very end of the constructor body."),
                QuestionOption("d", "`this(...)` can be called from any regular instance method.")
            ),
            correctOptionId = "a",
            explanation = "In Java 17, an explicit constructor invocation (`this(...)` or `super(...)`) must be the first statement in the constructor, and a constructor cannot directly contain both."
        ),
        QuizQuestion(
            id = "jv_f_14",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the requirement for a custom resource class to be usable inside a `try-with-resources` statement `try (MyResource r = new MyResource()) { ... }`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`MyResource` must implement `AutoCloseable` (or its subinterface `Closeable`)."),
                QuestionOption("b", "`MyResource` must extend `RuntimeException`."),
                QuestionOption("c", "`MyResource` must implement `Serializable`."),
                QuestionOption("d", "`MyResource` must override `Object.finalize()`.")
            ),
            correctOptionId = "a",
            explanation = "`try-with-resources` requires any declared resource type to implement `java.lang.AutoCloseable`, whose `close()` method is invoked automatically when exiting the `try` block."
        ),
        QuizQuestion(
            id = "jv_f_15",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the pattern-matching `instanceof` expression `if (obj instanceof String s && s.length() > 3)` do in Java 17?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Checks whether `obj` is a non-null `String`, binds it to the typed variable `s` without an explicit cast, and evaluates `s.length() > 3`."),
                QuestionOption("b", "Throws a `ClassCastException` if `obj` is an `Integer`."),
                QuestionOption("c", "Returns `true` when `obj` is `null`."),
                QuestionOption("d", "Converts `obj` into a new `String` using `obj.toString()`.")
            ),
            correctOptionId = "a",
            explanation = "Pattern matching for `instanceof` (standardized in Java 16) tests if `obj` is an instance of `String` (`null` always evaluates to `false`) and brings pattern variable `s` into scope where the test succeeded."
        ),

        // ==================== APPLIED (15) ====================
        QuizQuestion(
            id = "jv_a_01",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by the following Java code?",
            codeSnippet = """
                Integer a = 100;
                Integer b = 100;
                Integer c = 200;
                Integer d = 200;
                System.out.println((a == b) + " " + (c == d) + " " + c.equals(d));
            """.trimIndent(),
            languageNote = "Java 17 LTS (default JVM settings)",
            options = listOf(
                QuestionOption("a", "true false true"),
                QuestionOption("b", "true true true"),
                QuestionOption("c", "false false true"),
                QuestionOption("d", "false true false")
            ),
            correctOptionId = "a",
            explanation = "Autoboxing calls `Integer.valueOf(int)`, which caches `Integer` instances in the range `-128` to `127` by default. Thus `a` and `b` share the same cached object (`a == b` is `true`), while `200` allocates distinct objects (`c == d` is `false`, `c.equals(d)` is `true`)."
        ),
        QuizQuestion(
            id = "jv_a_02",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does this Java Stream pipeline output?",
            codeSnippet = """
                List<Integer> nums = List.of(1, 2, 3, 4);
                int sum = nums.stream()
                    .filter(n -> n % 2 == 1)
                    .mapToInt(n -> n * 10)
                    .sum();
                System.out.println(sum);
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "40"),
                QuestionOption("b", "60"),
                QuestionOption("c", "100"),
                QuestionOption("d", "4")
            ),
            correctOptionId = "a",
            explanation = "`filter(n -> n % 2 == 1)` keeps odd numbers (`1` and `3`). `mapToInt(n -> n * 10)` transforms them to `10` and `30`, and `.sum()` returns `40`."
        ),
        QuizQuestion(
            id = "jv_a_03",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when the following code runs?",
            codeSnippet = """
                List<String> tags = List.of("java", "kotlin");
                tags.add("sql");
                System.out.println(tags.size());
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Throws `UnsupportedOperationException` at runtime."),
                QuestionOption("b", "Prints `3`."),
                QuestionOption("c", "Prints `2` and silently ignores `.add(\"sql\")`."),
                QuestionOption("d", "Fails to compile because `List` has no `.add()` method.")
            ),
            correctOptionId = "a",
            explanation = "`List.of(...)` creates an unmodifiable list. Calling mutating methods like `add`, `remove`, or `set` throws `UnsupportedOperationException` at runtime."
        ),
        QuizQuestion(
            id = "jv_a_04",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is printed by this polymorphic method dispatch and field access example?",
            codeSnippet = """
                class Base {
                    String tag = "Base";
                    String name() { return "Base"; }
                }
                class Sub extends Base {
                    String tag = "Sub";
                    @Override String name() { return "Sub"; }
                }

                Base ref = new Sub();
                System.out.println(ref.tag + "-" + ref.name());
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Base-Sub"),
                QuestionOption("b", "Sub-Sub"),
                QuestionOption("c", "Base-Base"),
                QuestionOption("d", "Sub-Base")
            ),
            correctOptionId = "a",
            explanation = "Instance methods (`ref.name()`) are dynamically dispatched based on the runtime object type (`Sub`), whereas fields (`ref.tag`) are shadowed, not overridden, and resolve against the compile-time reference type (`Base`)."
        ),
        QuizQuestion(
            id = "jv_a_05",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the key difference between `opt.orElse(computeDefault())` and `opt.orElseGet(() -> computeDefault())` when `opt` is `Optional.of(\"Ready\")`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`orElse(computeDefault())` always evaluates `computeDefault()` before calling `orElse`, whereas `orElseGet(...)` only invokes the supplier if `opt` is empty."),
                QuestionOption("b", "`orElseGet(...)` always evaluates `computeDefault()`, whereas `orElse(...)` is lazy."),
                QuestionOption("c", "`orElse(...)` throws `NoSuchElementException` when `opt` is non-empty."),
                QuestionOption("d", "There is no difference in when `computeDefault()` is called.")
            ),
            correctOptionId = "a",
            explanation = "`orElse(T other)` takes an eagerly evaluated argument, so `computeDefault()` executes even when `opt` already contains a value. `orElseGet(Supplier)` evaluates the supplier lazily only when `opt` is empty."
        ),
        QuizQuestion(
            id = "jv_a_06",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when you remove an element directly from an `ArrayList` while iterating with a for-each loop?",
            codeSnippet = """
                List<String> items = new ArrayList<>(List.of("A", "B", "C"));
                for (String item : items) {
                    if (item.equals("B")) {
                        items.remove(item);
                    }
                }
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Throws `ConcurrentModificationException` on the next iterator step."),
                QuestionOption("b", "Cleanly removes `\"B\"` without any exception."),
                QuestionOption("c", "Fails to compile because `items` is used inside a for-each loop."),
                QuestionOption("d", "Removes `\"C\"` instead of `\"B\"`.")
            ),
            correctOptionId = "a",
            explanation = "Mutating an `ArrayList` structurally during a for-each loop (without using `Iterator.remove()` or `items.removeIf(...)`) increments `modCount`, causing the iterator's next `next()` check to throw `ConcurrentModificationException`."
        ),
        QuizQuestion(
            id = "jv_a_07",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following Java 17 switch expression print?",
            codeSnippet = """
                int code = 2;
                String status = switch (code) {
                    case 1, 2 -> "Active";
                    case 3 -> "Pending";
                    default -> "Unknown";
                };
                System.out.println(status);
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Active"),
                QuestionOption("b", "ActivePending"),
                QuestionOption("c", "Pending"),
                QuestionOption("d", "Unknown")
            ),
            correctOptionId = "a",
            explanation = "Arrow labels (`case L ->`) in Java switch expressions match multiple comma-separated constants (`case 1, 2 ->`) and never fall through to subsequent cases."
        ),
        QuizQuestion(
            id = "jv_a_08",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the value of `map` after executing this `computeIfAbsent` snippet?",
            codeSnippet = """
                Map<String, Integer> map = new HashMap<>();
                map.put("a", 10);
                map.computeIfAbsent("a", k -> 99);
                map.computeIfAbsent("b", k -> k.length() * 5);
                System.out.println(map.get("a") + " " + map.get("b"));
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "10 5"),
                QuestionOption("b", "99 5"),
                QuestionOption("c", "10 null"),
                QuestionOption("d", "99 1")
            ),
            correctOptionId = "a",
            explanation = "`computeIfAbsent` only runs the mapping function if the key is missing (or mapped to `null`). Since `'a'` already has `10`, it stays `10`; `'b'` is missing, so `'b'.length() * 5 = 5` is inserted."
        ),
        QuizQuestion(
            id = "jv_a_09",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does the following lambda fail to compile in Java?",
            codeSnippet = """
                int total = 0;
                List<Integer> values = List.of(1, 2, 3);
                values.forEach(v -> total += v);
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Local variables referenced from a lambda expression must be `final` or effectively final, so `total` cannot be reassigned."),
                QuestionOption("b", "`List.forEach` only accepts method references, not lambda expressions."),
                QuestionOption("c", "The `+=` operator does not work on primitive `int` inside lambdas."),
                QuestionOption("d", "`values` must be a `LinkedList` to use `forEach`.")
            ),
            correctOptionId = "a",
            explanation = "Java lambdas capture local variables by value and require captured local variables to be `final` or effectively final (never reassigned after initialization)."
        ),
        QuizQuestion(
            id = "jv_a_10",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when this Java Stream code is executed?",
            codeSnippet = """
                List<String> logged = new ArrayList<>();
                Stream<String> pipeline = Stream.of("x", "y")
                    .filter(s -> {
                        logged.add(s);
                        return true;
                    });
                System.out.println(logged.size());
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Prints `0` because intermediate stream operations like `filter` are lazy and do not execute until a terminal operation is invoked."),
                QuestionOption("b", "Prints `2` because `Stream.of` immediately pushes elements through `filter`."),
                QuestionOption("c", "Prints `1` because streams evaluate only the first element eagerly."),
                QuestionOption("d", "Throws `IllegalStateException` because no terminal operation was added.")
            ),
            correctOptionId = "a",
            explanation = "Intermediate operations (`filter`, `map`, `sorted`, `peek`) are lazy in Java Streams. Without a terminal operation (`toList()`, `count()`, `forEach()`), the predicate never runs and `logged` remains empty (`0`)."
        ),
        QuizQuestion(
            id = "jv_a_11",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the result of modifying an array backed by `Arrays.asList(...)`?",
            codeSnippet = """
                String[] arr = {"one", "two"};
                List<String> list = Arrays.asList(arr);
                list.set(0, "ZERO");
                System.out.println(arr[0]);
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Prints `ZERO` because `Arrays.asList` returns a fixed-size list view backed directly by the original array."),
                QuestionOption("b", "Prints `one` because `Arrays.asList` makes an independent copy of the array."),
                QuestionOption("c", "Throws `UnsupportedOperationException` on `list.set(0, \"ZERO\")`."),
                QuestionOption("d", "Throws `ArrayIndexOutOfBoundsException`.")
            ),
            correctOptionId = "a",
            explanation = "`Arrays.asList` wraps the existing array in a fixed-size `List` view: `add`/`remove` throw `UnsupportedOperationException`, but `set(index, element)` writes through directly to `arr`."
        ),
        QuizQuestion(
            id = "jv_a_12",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the following method overload resolution print?",
            codeSnippet = """
                class Printer {
                    static String describe(Object o) { return "Object"; }
                    static String describe(String s) { return "String"; }
                }

                Object item = "hello";
                System.out.println(Printer.describe(item));
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Object"),
                QuestionOption("b", "String"),
                QuestionOption("c", "hello"),
                QuestionOption("d", "Fails to compile due to ambiguous method call")
            ),
            correctOptionId = "a",
            explanation = "Method overloading is resolved at compile time based on the declared static type of the argument (`Object item`), not the runtime type (`String`)."
        ),
        QuizQuestion(
            id = "jv_a_13",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What occurs when this unboxing statement executes?",
            codeSnippet = """
                Map<String, Integer> scores = new HashMap<>();
                int current = scores.get("missing");
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Throws `NullPointerException` when attempting to unbox the `null` `Integer` into a primitive `int`."),
                QuestionOption("b", "Assigns `0` to `current`."),
                QuestionOption("c", "Throws `NoSuchElementException`."),
                QuestionOption("d", "Assigns `-1` to `current`.")
            ),
            correctOptionId = "a",
            explanation = "`scores.get(\"missing\")` returns `null`. Unboxing `null` to `int` compiles to `((Integer) null).intValue()`, which immediately throws `NullPointerException`."
        ),
        QuizQuestion(
            id = "jv_a_14",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Which rule does the `sealed` class declaration below enforce in Java 17?",
            codeSnippet = """
                public sealed interface Shape permits Circle, Rectangle {}
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Only `Circle` and `Rectangle` may directly implement `Shape`, and each must be declared `final`, `sealed`, or `non-sealed`."),
                QuestionOption("b", "`Circle` and `Rectangle` cannot have any fields or constructors."),
                QuestionOption("c", "Any class in any package can implement `Shape` without restriction."),
                QuestionOption("d", "`Shape` instances are automatically serialized to JSON.")
            ),
            correctOptionId = "a",
            explanation = "Java 17 `sealed` classes and interfaces restrict which types may extend or implement them to those listed in `permits`, and every permitted subtype must explicitly declare its sealing modifier (`final`, `sealed`, or `non-sealed`)."
        ),
        QuizQuestion(
            id = "jv_a_15",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a Java 17 text block (`\"\"\" ... \"\"\"`), how is incidental leading indentation handled?",
            codeSnippet = """
                String json = \"\"\"
                        {
                          "id": 1
                        }
                        \"\"\";
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "The compiler strips the common leading whitespace shared by all non-blank lines and the closing `\"\"\"` delimiter."),
                QuestionOption("b", "All leading spaces on every line are preserved exactly from column 0 of the source file."),
                QuestionOption("c", "All whitespace and newlines are removed, producing a single-line string."),
                QuestionOption("d", "Every line is automatically indented by 4 spaces regardless of where `\"\"\"` is placed.")
            ),
            correctOptionId = "a",
            explanation = "Java text blocks automatically remove incidental leading indentation based on the leftmost non-whitespace character across the content lines and the closing `\"\"\"` line."
        ),

        // ==================== ADVANCED (15) ====================
        QuizQuestion(
            id = "jv_x_01",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens if a class overrides `equals(Object)` based on an `id` field, but leaves `hashCode()` un-overridden (`Object.hashCode()`), and two distinct instances with the same `id` are inserted into a `HashSet`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Both instances will likely have different hash codes and land in different hash buckets, allowing the `HashSet` to contain two objects that are `.equals()` to each other."),
                QuestionOption("b", "`HashSet.add()` ignores `hashCode()` and scans every element with `equals()`, so the duplicate is still rejected."),
                QuestionOption("c", "The JVM throws an `IllegalStateException` when the class is loaded."),
                QuestionOption("d", "The Java compiler自動的に generates a matching `hashCode()` for every normal class.")
            ),
            correctOptionId = "a",
            explanation = "`Object.hashCode()` contract requires that if `a.equals(b)` is `true`, then `a.hashCode() == b.hashCode()`. `HashSet` first probes the bucket for `hashCode()`; if the hashes differ, `equals()` is never even called between them."
        ),
        QuizQuestion(
            id = "jv_x_02",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why do `(new ArrayList<String>()).getClass() == (new ArrayList<Integer>()).getClass()` evaluate to `true` at runtime in Java?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Because of type erasure, both generic instantiations compile to the same raw runtime class `java.util.ArrayList`."),
                QuestionOption("b", "Because `String` and `Integer` share the same runtime `Class` object."),
                QuestionOption("c", "Because `==` on `Class` objects only compares package names."),
                QuestionOption("d", "It actually evaluates to `false` in Java 17.")
            ),
            correctOptionId = "a",
            explanation = "Java generics are erased at compile time; at runtime there is only a single `Class` object `ArrayList.class` shared by all parameterized instantiations of `ArrayList<T>`."
        ),
        QuizQuestion(
            id = "jv_x_03",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Under the PECS principle (Producer `extends`, Consumer `super`), what is allowed on a parameter declared as `List<? extends Number> nums`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "You can safely read elements as `Number`, but you cannot add arbitrary `Integer` or `Double` elements (only `null`)."),
                QuestionOption("b", "You can add any `Integer` or `Double`, but reading elements only returns `Object`."),
                QuestionOption("c", "You can both add any `Number` subtype and read elements as `Integer`."),
                QuestionOption("d", "You cannot call `.size()` or `.isEmpty()` on `nums`.")
            ),
            correctOptionId = "a",
            explanation = "`List<? extends Number>` might at runtime be a `List<Double>`, so the compiler forbids `nums.add(Integer.valueOf(1))` to preserve type safety, while guaranteeing every element read from `nums` is at least a `Number`."
        ),
        QuizQuestion(
            id = "jv_x_04",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the Java Memory Model (JMM), what does declaring a field `volatile boolean running = true;` guarantee, and what does it NOT guarantee?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "It guarantees cross-thread visibility and a happens-before ordering for reads/writes of `running`, but it does NOT make compound actions like `count++` atomic."),
                QuestionOption("b", "It guarantees that all methods in the enclosing class become mutually exclusive like `synchronized`."),
                QuestionOption("c", "It makes compound read-modify-write operations like `count++` completely atomic across threads."),
                QuestionOption("d", "It pins the variable to a single CPU core's L1 cache so other threads cannot read it.")
            ),
            correctOptionId = "a",
            explanation = "`volatile` establishes a happens-before relationship (writes are immediately visible to subsequent reads by other threads and instruction reordering across barriers is prevented), but `count++` (read-add-write) still requires synchronization or `AtomicInteger`."
        ),
        QuizQuestion(
            id = "jv_x_05",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a `try-with-resources` block, if BOTH the `try` body throws `exTry` AND `resource.close()` throws `exClose`, which exception propagates to the caller?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`exTry` is thrown as the primary exception, and `exClose` is attached to it via `exTry.addSuppressed(exClose)`."),
                QuestionOption("b", "`exClose` overwrites `exTry`, and `exTry` is completely discarded."),
                QuestionOption("c", "`exClose` is thrown as the primary exception, and `exTry` is added as suppressed."),
                QuestionOption("d", "The JVM wraps both in a `CompositeException`.")
            ),
            correctOptionId = "a",
            explanation = "Unlike a manual `finally` block (where an exception in `finally` masks the `try` exception), `try-with-resources` preserves the original `try` body exception (`exTry`) and attaches `close()` exceptions to `exTry.getSuppressed()`."
        ),
        QuizQuestion(
            id = "jv_x_06",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In what exact order do initialization blocks and constructors execute when `new Child()` is called for the first time?",
            codeSnippet = """
                class Parent {
                    static { System.out.print("PS "); }
                    { System.out.print("PI "); }
                    Parent() { System.out.print("PC "); }
                }
                class Child extends Parent {
                    static { System.out.print("CS "); }
                    { System.out.print("CI "); }
                    Child() { System.out.print("CC "); }
                }
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "P_S C_S P_I P_C C_I C_C (written as: `PS CS PI PC CI CC`)"),
                QuestionOption("b", "PS PI PC CS CI CC"),
                QuestionOption("c", "PS CS PI CI PC CC"),
                QuestionOption("d", "CS PS CI CC PI PC")
            ),
            correctOptionId = "a",
            explanation = "First, class loading runs static initializers from parent to child (`PS CS`). Next, instance creation runs `Parent`'s instance initializer and constructor (`PI PC`), followed by `Child`'s instance initializer and constructor (`CI CC`)."
        ),
        QuizQuestion(
            id = "jv_x_07",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Java 8+ `HashMap`, how are bucket collisions handled when many distinct keys hash to the same bucket index and the table capacity is at least 64?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Once a bucket's linked list reaches the treeify threshold (8 nodes), it converts into a balanced Red-Black Tree reducing worst-case lookup from O(n) to O(log n)."),
                QuestionOption("b", "The `HashMap` throws a `BufferOverflowException` when a bucket exceeds 8 entries."),
                QuestionOption("c", "It uses open addressing with linear probing into adjacent array slots."),
                QuestionOption("d", "It discards older keys in the bucket using an LRU eviction policy.")
            ),
            correctOptionId = "a",
            explanation = "To mitigate hash-collision denial-of-service degradation, `java.util.HashMap` transforms long collision chains (≥ 8 nodes when table capacity ≥ 64) from linked lists into Red-Black Trees (`TreeNode`)."
        ),
        QuizQuestion(
            id = "jv_x_08",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can an inner class or anonymous class retained by a background task cause a memory leak in Java if it is NOT declared `static`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "A non-static inner class holds an implicit synthetic reference (`Outer.this`) to its enclosing instance, preventing the outer object from being garbage-collected."),
                QuestionOption("b", "Non-static inner classes are allocated in permanent Metaspace and are never garbage-collected."),
                QuestionOption("c", "The garbage collector skips any class whose bytecode name contains an inner class separator."),
                QuestionOption("d", "Non-static inner classes automatically pin all CPU threads.")
            ),
            correctOptionId = "a",
            explanation = "Every instance of a non-static inner class carries a hidden outer-instance reference to the enclosing object. If the inner instance outlives the outer object's intended lifecycle, the outer object remains strongly reachable."
        ),
        QuizQuestion(
            id = "jv_x_09",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between `CompletableFuture.thenApply(fn)` and `CompletableFuture.thenCompose(fn)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`thenApply` maps `T -> U` synchronously (like `Stream.map`), whereas `thenCompose` flat-maps `T -> CompletionStage<U>` without nesting futures."),
                QuestionOption("b", "`thenCompose` blocks the calling thread immediately, whereas `thenApply` is non-blocking."),
                QuestionOption("c", "`thenApply` only runs when an exception occurs, whereas `thenCompose` runs on success."),
                QuestionOption("d", "They are aliases with identical method signatures.")
            ),
            correctOptionId = "a",
            explanation = "If `fn` returns another `CompletableFuture<U>`, `thenApply(fn)` produces a nested `CompletableFuture<CompletableFuture<U>>`, whereas `thenCompose(fn)` flattens the asynchronous stage into `CompletableFuture<U>`."
        ),
        QuizQuestion(
            id = "jv_x_10",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when `Collectors.toMap(Item::key, Item::val)` encounters two stream elements with the exact same key and no merge function is provided?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Throws `IllegalStateException` (`Duplicate key ...`) at runtime."),
                QuestionOption("b", "The later value silently overwrites the earlier value."),
                QuestionOption("c", "The earlier value is kept and the later value is ignored."),
                QuestionOption("d", "Both values are stored in a `List` under that key.")
            ),
            correctOptionId = "a",
            explanation = "Unlike `Map.put`, the two-argument `Collectors.toMap(keyMapper, valueMapper)` throws `IllegalStateException` on duplicate keys unless a third `mergeFunction` argument (e.g., `(v1, v2) -> v2`) is supplied."
        ),
        QuizQuestion(
            id = "jv_x_11",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why must a parallel stream reduction `stream.parallel().reduce(identity, accumulator, combiner)` use an associative operation and a true identity value?",
            codeSnippet = """
                // Example of broken identity:
                int bad = List.of(1, 2, 3, 4).parallelStream()
                    .reduce(10, Integer::sum);
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Each parallel worker task starts its partial reduction with `identity`, so a non-identity seed like `10` gets added multiple times (once per split subtask)."),
                QuestionOption("b", "The code throws `UnsupportedOperationException` whenever `reduce` is called on a `parallelStream()`."),
                QuestionOption("c", "Parallel streams ignore the `identity` argument completely and always use `0`."),
                QuestionOption("d", "A non-zero identity forces the parallel stream to execute sequentially on a single thread.")
            ),
            correctOptionId = "a",
            explanation = "In `parallelStream().reduce(identity, op)`, `identity` must satisfy `op(identity, x) == x` because the ForkJoin framework seeds every parallel partition with `identity` before combining partial results."
        ),
        QuizQuestion(
            id = "jv_x_12",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How does `CopyOnWriteArrayList` achieve thread-safe iteration without throwing `ConcurrentModificationException`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Every mutating operation (`add`, `set`, `remove`) allocates and modifies a fresh copy of the underlying array, while active iterators read an immutable snapshot array."),
                QuestionOption("b", "It acquires a global `synchronized` lock for the entire duration of any `for` loop."),
                QuestionOption("c", "It silently skips elements that are being modified by other threads."),
                QuestionOption("d", "It clones every element using `Object.clone()` whenever `get(i)` is called.")
            ),
            correctOptionId = "a",
            explanation = "`CopyOnWriteArrayList` stores elements in a `volatile` array reference. Mutations copy the array under a lock and swap the reference, so iterators traverse the unchanged array snapshot that existed when `iterator()` was called."
        ),
        QuizQuestion(
            id = "jv_x_13",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens when `Thread.currentThread().interrupt()` is called on a thread that is currently blocked inside `Thread.sleep(1000)`?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "`Thread.sleep` immediately wakes up and throws `InterruptedException`, AND clears the thread's interrupted status flag back to `false`."),
                QuestionOption("b", "`Thread.sleep` throws `InterruptedException` while keeping the thread's interrupted status flag set to `true`."),
                QuestionOption("c", "The thread terminates immediately without running `catch` or `finally` blocks."),
                QuestionOption("d", "Nothing happens until the full 1000ms sleep completes.")
            ),
            correctOptionId = "a",
            explanation = "Blocking methods that declare `throws InterruptedException` (`sleep`, `wait`, `join`) clear the thread's interrupted status flag before throwing `InterruptedException`, which is why handlers should either rethrow or call `Thread.currentThread().interrupt()`."
        ),
        QuizQuestion(
            id = "jv_x_14",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a bridge method in Java bytecode, and why does the compiler synthesize one for `class StringBox extends Box<String>`?",
            codeSnippet = """
                class Box<T> {
                    void set(T value) {}
                }
                class StringBox extends Box<String> {
                    @Override void set(String value) {}
                }
            """.trimIndent(),
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "After type erasure, `Box.set` has signature `set(Object)`. The compiler generates a synthetic `set(Object)` bridge method in `StringBox` that casts to `String` and delegates to `set(String)` to preserve polymorphism."),
                QuestionOption("b", "Bridge methods allow `private` methods to be called via JNI without reflection."),
                QuestionOption("c", "Bridge methods convert `StringBox` into a Java `record` at runtime."),
                QuestionOption("d", "Bridge methods prevent `ClassCastException` when an `Integer` is passed to `Box<String>`.")
            ),
            correctOptionId = "a",
            explanation = "Because `Box<T>.set(T)` erases to `set(Object)`, `StringBox.set(String)` would otherwise have a different bytecode descriptor and fail to override `set(Object)`. The compiler emits a synthetic `set(Object)` bridge method that casts `(String)` and invokes `set(String)`."
        ),
        QuizQuestion(
            id = "jv_x_15",
            category = QuizCategory.JAVA,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a Java `enum`, when and how are the enum constants constructed?",
            languageNote = "Java 17 LTS",
            options = listOf(
                QuestionOption("a", "Each enum constant is instantiated once as a `public static final` singleton field when the enum class is initialized, and enum constructors are implicitly `private`."),
                QuestionOption("b", "A new enum instance is allocated on the heap every time `MyEnum.VALUE` is referenced."),
                QuestionOption("c", "Enum constructors are `public` so external classes can instantiate additional enum constants with `new`."),
                QuestionOption("d", "Enum constants are primitive `int` constants at runtime and cannot have fields or methods.")
            ),
            correctOptionId = "a",
            explanation = "Java `enum` types compile to subclasses of `java.lang.Enum` with `private` constructors. Their constants are initialized once during `<clinit>` class initialization as `public static final` singleton instances."
        )
    )
}
