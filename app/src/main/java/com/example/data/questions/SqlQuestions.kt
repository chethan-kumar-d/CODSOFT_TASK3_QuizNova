package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object SqlQuestions {
    val questions: List<QuizQuestion> = listOf(
        // ==================== FOUNDATION (15) ====================
        QuizQuestion(
            id = "sql_f_01",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In standard ANSI SQL, what is the fundamental difference between the `WHERE` clause and the `HAVING` clause?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "`WHERE` filters individual rows before grouping (`GROUP BY`), whereas `HAVING` filters grouped rows or aggregate results after `GROUP BY`."),
                QuestionOption("b", "`HAVING` runs before `WHERE` to speed up index scans."),
                QuestionOption("c", "`WHERE` can contain aggregate functions like `SUM(amount) > 100`, whereas `HAVING` cannot."),
                QuestionOption("d", "They are completely interchangeable in all SQL queries.")
            ),
            correctOptionId = "a",
            explanation = "`WHERE` evaluates row-level predicates prior to `GROUP BY` aggregation; `HAVING` evaluates predicates on groups and aggregate functions (`COUNT`, `SUM`, `AVG`) after grouping."
        ),
        QuizQuestion(
            id = "sql_f_02",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why does `WHERE manager_id = NULL` fail to match rows whose `manager_id` is `NULL` in standard SQL?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "In SQL three-valued logic, comparing anything to `NULL` with `=` or `<>` yields `UNKNOWN`, so `IS NULL` must be used instead."),
                QuestionOption("b", "`NULL` is stored as the integer `0`, so `WHERE manager_id = 0` is required."),
                QuestionOption("c", "The `=` operator only works on `VARCHAR` columns."),
                QuestionOption("d", "`NULL` values can only be filtered inside a `HAVING` clause.")
            ),
            correctOptionId = "a",
            explanation = "`NULL` represents an unknown/missing value. Any equality comparison `x = NULL` evaluates to `UNKNOWN` (which `WHERE` filters out); `IS NULL` and `IS NOT NULL` test nullability."
        ),
        QuizQuestion(
            id = "sql_f_03",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How does `LEFT JOIN` (or `LEFT OUTER JOIN`) differ from `INNER JOIN` between a left table `customers` and a right table `orders`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "`LEFT JOIN` returns all rows from `customers` even when they have no matching row in `orders` (filling `orders` columns with `NULL`), whereas `INNER JOIN` returns only matching pairs."),
                QuestionOption("b", "`LEFT JOIN` returns all rows from `orders` and drops unmatched `customers`."),
                QuestionOption("c", "`INNER JOIN` fills unmatched columns with `0` instead of `NULL`."),
                QuestionOption("d", "`LEFT JOIN` automatically deduplicates rows in `customers`.")
            ),
            correctOptionId = "a",
            explanation = "An `INNER JOIN` requires a match in both tables, while a `LEFT JOIN` preserves every row of the left table (`customers`) and populates right-table attributes with `NULL` when no match exists."
        ),
        QuizQuestion(
            id = "sql_f_04",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `COUNT(*)` and `COUNT(bonus)` on a table where some rows have `bonus IS NULL`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "`COUNT(*)` counts all rows in the group including `NULL`s, whereas `COUNT(bonus)` counts only rows where `bonus` is non-NULL."),
                QuestionOption("b", "`COUNT(bonus)` sums the numeric values of `bonus`, whereas `COUNT(*)` counts columns."),
                QuestionOption("c", "`COUNT(*)` ignores rows that contain any `NULL` column anywhere in the row."),
                QuestionOption("d", "Both always return the exact same number.")
            ),
            correctOptionId = "a",
            explanation = "`COUNT(*)` counts total rows regardless of `NULL` values, while `COUNT(expression)` ignores rows where `expression` evaluates to `NULL`."
        ),
        QuizQuestion(
            id = "sql_f_05",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `UNION` and `UNION ALL` in SQL?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "`UNION` removes duplicate rows across the combined result set, whereas `UNION ALL` retains all rows including duplicates."),
                QuestionOption("b", "`UNION ALL` removes duplicates, whereas `UNION` keeps duplicates."),
                QuestionOption("c", "`UNION` joins columns horizontally like `INNER JOIN`, whereas `UNION ALL` stacks rows vertically."),
                QuestionOption("d", "`UNION ALL` can combine queries with different numbers of columns.")
            ),
            correctOptionId = "a",
            explanation = "`UNION` performs a distinct deduplication pass over the combined rows, whereas `UNION ALL` simply concatenates the result sets without deduplicating (making it faster when duplicates are acceptable or impossible)."
        ),
        QuizQuestion(
            id = "sql_f_06",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How does a `PRIMARY KEY` constraint differ from a `UNIQUE` constraint in standard SQL (such as PostgreSQL/MySQL)?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "A table can have at most one `PRIMARY KEY` and its columns are implicitly `NOT NULL`, whereas a table can have multiple `UNIQUE` constraints which permit `NULL` unless marked `NOT NULL`."),
                QuestionOption("b", "A `PRIMARY KEY` allows duplicate values as long as they are positive integers."),
                QuestionOption("c", "A `UNIQUE` constraint can only be applied to `VARCHAR` columns."),
                QuestionOption("d", "A `PRIMARY KEY` cannot be referenced by a `FOREIGN KEY`.")
            ),
            correctOptionId = "a",
            explanation = "Every table has at most one primary key (which enforces uniqueness + `NOT NULL`), while multiple `UNIQUE` constraints can coexist on a table."
        ),
        QuizQuestion(
            id = "sql_f_07",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If an `ORDER BY score` clause does not specify `ASC` or `DESC`, in what order are the rows sorted?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Ascending order (`ASC`), from lowest to highest."),
                QuestionOption("b", "Descending order (`DESC`), from highest to lowest."),
                QuestionOption("c", "Random order on each query execution."),
                QuestionOption("d", "The query fails with a syntax error unless `ASC` or `DESC` is written.")
            ),
            correctOptionId = "a",
            explanation = "In standard SQL, `ASC` (ascending) is the default sort direction when neither `ASC` nor `DESC` is explicitly specified in `ORDER BY`."
        ),
        QuizQuestion(
            id = "sql_f_08",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the pattern `WHERE code LIKE '_A%'` match in SQL?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Any string whose second character is `'A'`, followed by zero or more characters."),
                QuestionOption("b", "Any string that starts with an literal underscore `'_'` followed by `'A'`."),
                QuestionOption("c", "Any string that ends with `'A'`."),
                QuestionOption("d", "Only 2-character strings ending in `'A'`.")
            ),
            correctOptionId = "a",
            explanation = "In SQL `LIKE` patterns, `_` matches any single character and `%` matches any sequence of zero or more characters. Thus `_A%` requires exactly one character before `'A'`."
        ),
        QuizQuestion(
            id = "sql_f_09",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens if you run `UPDATE accounts SET status = 'inactive';` without a `WHERE` clause?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Every row in the `accounts` table has its `status` updated to `'inactive'`."),
                QuestionOption("b", "Only the first row in the `accounts` table is updated."),
                QuestionOption("c", "Standard SQL rejects `UPDATE` statements that omit a `WHERE` clause."),
                QuestionOption("d", "Only rows where `status IS NULL` are updated.")
            ),
            correctOptionId = "a",
            explanation = "Without a `WHERE` clause, an `UPDATE` (or `DELETE`) statement applies to all rows in the target table."
        ),
        QuizQuestion(
            id = "sql_f_10",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `SELECT DISTINCT dept, role FROM employees;` return?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Unique `(dept, role)` combinations across all rows in `employees`."),
                QuestionOption("b", "Unique `dept` values paired with an arbitrary `role` from each department."),
                QuestionOption("c", "A syntax error because `DISTINCT` only applies to a single column."),
                QuestionOption("d", "Only departments that have exactly one employee.")
            ),
            correctOptionId = "a",
            explanation = "`SELECT DISTINCT col1, col2` applies across the entire projected tuple of selected columns, deduplicating identical `(dept, role)` pairs."
        ),
        QuizQuestion(
            id = "sql_f_11",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `COALESCE(preferred_phone, mobile_phone, 'Unlisted')` return?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "The first non-NULL argument from left to right, or `'Unlisted'` if both phone columns are `NULL`."),
                QuestionOption("b", "All three strings concatenated together with spaces."),
                QuestionOption("c", "`NULL` if any of the arguments is `NULL`."),
                QuestionOption("d", "The longest string among the three arguments.")
            ),
            correctOptionId = "a",
            explanation = "`COALESCE(a, b, c, ...)` evaluates arguments in order from left to right and returns the first non-NULL value (or `NULL` if all arguments are `NULL`)."
        ),
        QuizQuestion(
            id = "sql_f_12",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, is `WHERE points BETWEEN 10 AND 20` inclusive or exclusive of the endpoints `10` and `20`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Inclusive of both endpoints: equivalent to `points >= 10 AND points <= 20`."),
                QuestionOption("b", "Exclusive of both endpoints: equivalent to `points > 10 AND points < 20`."),
                QuestionOption("c", "Inclusive of `10` but exclusive of `20` (like Python `range`)."),
                QuestionOption("d", "Exclusive of `10` but inclusive of `20`.")
            ),
            correctOptionId = "a",
            explanation = "In standard SQL, `x BETWEEN a AND b` is always inclusive of both `a` and `b` (`x >= a AND x <= b`)."
        ),
        QuizQuestion(
            id = "sql_f_13",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What integrity rule does a `FOREIGN KEY (dept_id) REFERENCES departments(id)` constraint enforce?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Every non-NULL `dept_id` in the child table must match an existing `id` in the `departments` table."),
                QuestionOption("b", "`dept_id` values in the child table must be unique across all rows."),
                QuestionOption("c", "The `departments` table cannot have more rows than the child table."),
                QuestionOption("d", "`dept_id` is automatically incremented on every insert.")
            ),
            correctOptionId = "a",
            explanation = "Referential integrity via a `FOREIGN KEY` prevents orphaned child rows by ensuring any non-NULL foreign key value references a valid parent row in `departments`."
        ),
        QuizQuestion(
            id = "sql_f_14",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the main operational difference between `DELETE FROM logs;` and `DROP TABLE logs;`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "`DELETE FROM logs;` removes the rows while keeping the table schema, columns, and indexes intact; `DROP TABLE logs;` removes the entire table definition and its data."),
                QuestionOption("b", "`DROP TABLE logs;` removes only the rows, whereas `DELETE FROM logs;` deletes the table schema."),
                QuestionOption("c", "`DELETE FROM` cannot be rolled back inside a transaction."),
                QuestionOption("d", "`DROP TABLE` leaves all indexes intact.")
            ),
            correctOptionId = "a",
            explanation = "`DELETE` is a DML operation that removes rows from an existing table; `DROP TABLE` is a DDL operation that completely removes the table structure and data from the database catalog."
        ),
        QuizQuestion(
            id = "sql_f_15",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which aggregate function calculates the arithmetic mean of non-NULL numeric values in a column?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "`AVG(column_name)`"),
                QuestionOption("b", "`MEAN(column_name)`"),
                QuestionOption("c", "`MEDIAN(column_name)`"),
                QuestionOption("d", "`MID(column_name)`")
            ),
            correctOptionId = "a",
            explanation = "Standard SQL uses `AVG(col)` to compute the average of non-NULL values in `col`."
        ),

        // ==================== APPLIED (15) ====================
        QuizQuestion(
            id = "sql_a_01",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given a `sales` table with 4 rows whose `discount` values are `10`, `20`, `NULL`, and `30`, what does `SELECT AVG(discount), COUNT(*), COUNT(discount) FROM sales;` return?",
            languageNote = "ANSI SQL / PostgreSQL",
            options = listOf(
                QuestionOption("a", "`20`, `4`, `3`"),
                QuestionOption("b", "`15`, `4`, `3`"),
                QuestionOption("c", "`20`, `3`, `3`"),
                QuestionOption("d", "`NULL`, `4`, `3`")
            ),
            correctOptionId = "a",
            explanation = "`AVG(discount)` ignores `NULL` rows and divides `10 + 20 + 30 = 60` by `3` non-NULL rows = `20`. `COUNT(*)` is `4`, and `COUNT(discount)` is `3`."
        ),
        QuizQuestion(
            id = "sql_a_02",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why can a column alias defined in `SELECT` NOT be referenced inside the `WHERE` clause of the same query?",
            codeSnippet = """
                SELECT salary * 12 AS annual_pay
                FROM employees
                WHERE annual_pay > 100000; -- Fails in standard SQL
            """.trimIndent(),
            languageNote = "ANSI SQL / PostgreSQL",
            options = listOf(
                QuestionOption("a", "In logical query processing order, `FROM` and `WHERE` are evaluated before `SELECT`, so `annual_pay` does not exist yet when `WHERE` runs."),
                QuestionOption("b", "Aliases created with `AS` can only be strings, not numbers."),
                QuestionOption("c", "Aliases can only be used inside `JOIN ON` clauses."),
                QuestionOption("d", "The `AS` keyword is only valid for table aliases, not column aliases.")
            ),
            correctOptionId = "a",
            explanation = "Logical SQL evaluation order is `FROM -> JOIN -> WHERE -> GROUP BY -> HAVING -> SELECT -> DISTINCT -> ORDER BY -> LIMIT`. Because `WHERE` runs before `SELECT`, aliases defined in `SELECT` are not yet in scope."
        ),
        QuizQuestion(
            id = "sql_a_03",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between placing `AND o.status = 'SHIPPED'` in the `ON` clause versus the `WHERE` clause of a `LEFT JOIN`?",
            codeSnippet = """
                -- Query 1:
                SELECT c.id, o.id FROM customers c
                LEFT JOIN orders o ON c.id = o.customer_id AND o.status = 'SHIPPED';

                -- Query 2:
                SELECT c.id, o.id FROM customers c
                LEFT JOIN orders o ON c.id = o.customer_id
                WHERE o.status = 'SHIPPED';
            """.trimIndent(),
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Query 1 still returns customers with no shipped orders (with `o.id` as `NULL`), whereas Query 2 filters out those `NULL` rows in `WHERE`, turning the `LEFT JOIN` into an effective `INNER JOIN`."),
                QuestionOption("b", "Query 1 and Query 2 always return the exact same rows."),
                QuestionOption("c", "Query 1 throws a syntax error because `ON` only allows primary key equality."),
                QuestionOption("d", "Query 2 returns more rows than Query 1.")
            ),
            correctOptionId = "a",
            explanation = "In a `LEFT JOIN`, predicates in `ON` determine which right-table rows match while still preserving unmatched left-table rows with `NULL`s. Filtering `WHERE o.status = 'SHIPPED'` afterward eliminates all rows where `o.status` is `NULL`."
        ),
        QuizQuestion(
            id = "sql_a_04",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens when `WHERE id NOT IN (10, 20, NULL)` is evaluated for a row with `id = 30`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "The row is NOT returned (0 rows match), because `30 <> 10 AND 30 <> 20 AND 30 <> NULL` evaluates to `TRUE AND TRUE AND UNKNOWN`, which is `UNKNOWN`."),
                QuestionOption("b", "The row with `id = 30` IS returned normally because `30` is neither `10` nor `20`."),
                QuestionOption("c", "Only rows where `id IS NULL` are returned."),
                QuestionOption("d", "The database raises a division-by-zero error.")
            ),
            correctOptionId = "a",
            explanation = "`x NOT IN (a, b, NULL)` expands to `x <> a AND x <> b AND x <> NULL`. Since `x <> NULL` is always `UNKNOWN`, the entire `AND` conjunction is never `TRUE`, causing `NOT IN` to return zero rows whenever the list/subquery contains a `NULL`."
        ),
        QuizQuestion(
            id = "sql_a_05",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Look at this self-join query. What does it return?",
            codeSnippet = """
                SELECT e.name AS employee, m.name AS manager
                FROM staff e
                INNER JOIN staff m ON e.manager_id = m.id;
            """.trimIndent(),
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Each employee paired with their manager's name, excluding top-level staff whose `manager_id` is `NULL`."),
                QuestionOption("b", "All staff members, showing `'None'` for top-level staff without a manager."),
                QuestionOption("c", "Only managers who do not report to anyone."),
                QuestionOption("d", "Every possible pair of staff members in the company.")
            ),
            correctOptionId = "a",
            explanation = "Joining `staff e` to `staff m` on `e.manager_id = m.id` with an `INNER JOIN` matches each employee to their manager row, while omitting employees where `e.manager_id IS NULL` (use `LEFT JOIN` to keep them)."
        ),
        QuizQuestion(
            id = "sql_a_06",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is the following `SELECT` query invalid in standard SQL (and PostgreSQL)?",
            codeSnippet = """
                SELECT department, employee_name, AVG(salary)
                FROM employees
                GROUP BY department;
            """.trimIndent(),
            languageNote = "ANSI SQL / PostgreSQL",
            options = listOf(
                QuestionOption("a", "`employee_name` is neither included in `GROUP BY` nor wrapped in an aggregate function, so there is no single well-defined value per department."),
                QuestionOption("b", "`AVG(salary)` cannot be used alongside `GROUP BY`."),
                QuestionOption("c", "`GROUP BY` requires columns to be listed by numeric position (`GROUP BY 1`)."),
                QuestionOption("d", "A query with `GROUP BY` must always include a `HAVING` clause.")
            ),
            correctOptionId = "a",
            explanation = "When `GROUP BY` is used, every selected column must either be a grouping key (or functionally dependent on one) or aggregated (`MIN`, `MAX`, `COUNT`, etc.)."
        ),
        QuizQuestion(
            id = "sql_a_07",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does this conditional aggregation query compute for each department?",
            codeSnippet = """
                SELECT
                    dept,
                    SUM(CASE WHEN score >= 80 THEN 1 ELSE 0 END) AS high_achievers
                FROM results
                GROUP BY dept;
            """.trimIndent(),
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "The count of rows in each `dept` where `score >= 80` (returning `0` for departments that exist but have no scores ≥ 80)."),
                QuestionOption("b", "The sum of the actual `score` values that are ≥ 80."),
                QuestionOption("c", "The average score per department."),
                QuestionOption("d", "Only departments where every single student scored ≥ 80.")
            ),
            correctOptionId = "a",
            explanation = "Summing `1` when a condition holds and `0` otherwise (`SUM(CASE WHEN ... THEN 1 ELSE 0 END)`) is the standard SQL idiom for counting matching rows per group without filtering out groups that have zero matches."
        ),
        QuizQuestion(
            id = "sql_a_08",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given scores `95, 90, 90, 85`, what ranks do `RANK()`, `DENSE_RANK()`, and `ROW_NUMBER()` assign to those four rows when ordered by `score DESC`?",
            languageNote = "ANSI SQL Window Functions",
            options = listOf(
                QuestionOption("a", "`RANK`: `1, 2, 2, 4` • `DENSE_RANK`: `1, 2, 2, 3` • `ROW_NUMBER`: `1, 2, 3, 4`"),
                QuestionOption("b", "`RANK`: `1, 2, 2, 3` • `DENSE_RANK`: `1, 2, 2, 4` • `ROW_NUMBER`: `1, 2, 3, 4`"),
                QuestionOption("c", "`RANK`: `1, 2, 3, 4` • `DENSE_RANK`: `1, 2, 2, 3` • `ROW_NUMBER`: `1, 2, 2, 4`"),
                QuestionOption("d", "All three assign `1, 2, 2, 3`.")
            ),
            correctOptionId = "a",
            explanation = "`RANK()` gives ties the same rank (`2, 2`) and skips the next rank (`4`). `DENSE_RANK()` gives ties the same rank (`2, 2`) without gaps (`3`). `ROW_NUMBER()` assigns distinct sequential integers (`1, 2, 3, 4`)."
        ),
        QuizQuestion(
            id = "sql_a_09",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Suppose table `A` has 2 rows: `(1), (1)`, and table `B` has 3 rows: `(1), (1), (2)`. How many rows are returned by `SELECT * FROM A INNER JOIN B ON A.x = B.x;`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "4 rows"),
                QuestionOption("b", "2 rows"),
                QuestionOption("c", "3 rows"),
                QuestionOption("d", "1 row")
            ),
            correctOptionId = "a",
            explanation = "Each of the 2 rows with `x = 1` in table `A` matches each of the 2 rows with `x = 1` in table `B` (2 × 2 = 4 matching row pairs). The row `(2)` in `B` has no match."
        ),
        QuizQuestion(
            id = "sql_a_10",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Which rows are returned when `LIMIT 5 OFFSET 10` is applied to an ordered query?",
            languageNote = "PostgreSQL / SQLite / MySQL",
            options = listOf(
                QuestionOption("a", "Skips the first 10 rows and returns the next 5 rows (rows 11 through 15)."),
                QuestionOption("b", "Skips the first 5 rows and returns the next 10 rows (rows 6 through 15)."),
                QuestionOption("c", "Returns rows 5 through 10 inclusive (6 rows)."),
                QuestionOption("d", "Returns the first 5 rows and last 10 rows.")
            ),
            correctOptionId = "a",
            explanation = "`OFFSET 10` discards the first 10 rows of the sorted result set, and `LIMIT 5` takes at most 5 rows starting from row 11."
        ),
        QuizQuestion(
            id = "sql_a_11",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the expression `amount / NULLIF(quantity, 0)` accomplish in SQL?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Avoids division-by-zero errors: when `quantity` is `0`, `NULLIF(quantity, 0)` returns `NULL`, so the division safely evaluates to `NULL`."),
                QuestionOption("b", "Replaces a `NULL` `quantity` with `0` before dividing."),
                QuestionOption("c", "Rounds the division result to `0` decimal places."),
                QuestionOption("d", "Returns `0` whenever `amount` is `NULL`.")
            ),
            correctOptionId = "a",
            explanation = "`NULLIF(a, b)` returns `NULL` if `a = b`, and returns `a` otherwise. Thus `NULLIF(quantity, 0)` converts a `0` divisor into `NULL`, yielding `amount / NULL = NULL` instead of a divide-by-zero runtime error."
        ),
        QuizQuestion(
            id = "sql_a_12",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does this correlated `NOT EXISTS` query return?",
            codeSnippet = """
                SELECT c.id, c.name
                FROM customers c
                WHERE NOT EXISTS (
                    SELECT 1 FROM invoices i
                    WHERE i.customer_id = c.id
                );
            """.trimIndent(),
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "All customers who have zero matching rows in `invoices` (an anti-join)."),
                QuestionOption("b", "All customers who have at least one invoice."),
                QuestionOption("c", "An error because `SELECT 1` is not a valid column in `invoices`."),
                QuestionOption("d", "An empty result if any row in `invoices` has `customer_id IS NULL`.")
            ),
            correctOptionId = "a",
            explanation = "`NOT EXISTS` tests whether the correlated subquery returns any rows for the current `c.id`. Unlike `NOT IN`, `NOT EXISTS` handles `NULL`s in `invoices.customer_id` safely and implements a clean relational anti-join."
        ),
        QuizQuestion(
            id = "sql_a_13",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a multi-branch `CASE WHEN ... THEN ... END` expression, what happens if multiple `WHEN` conditions are true for the same row?",
            codeSnippet = """
                SELECT CASE
                    WHEN score >= 50 THEN 'Pass'
                    WHEN score >= 90 THEN 'Distinction'
                    ELSE 'Fail'
                END AS grade
                FROM exams WHERE score = 95;
            """.trimIndent(),
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Returns `'Pass'` because `CASE` evaluates `WHEN` clauses top-to-bottom and stops at the first matching condition."),
                QuestionOption("b", "Returns `'Distinction'` because `90` is a more specific threshold than `50`."),
                QuestionOption("c", "Returns two rows: `'Pass'` and `'Distinction'`."),
                QuestionOption("d", "Raises an error for overlapping `WHEN` conditions.")
            ),
            correctOptionId = "a",
            explanation = "SQL `CASE` expressions short-circuit on the first `WHEN` clause that evaluates to `TRUE`. Because `95 >= 50` is checked first, `'Pass'` is returned and `score >= 90` is never reached."
        ),
        QuizQuestion(
            id = "sql_a_14",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the standard SQL set operator `EXCEPT` (or `MINUS` in Oracle) return in `SELECT id FROM all_users EXCEPT SELECT user_id FROM banned_users;`?",
            languageNote = "ANSI SQL / PostgreSQL / SQLite",
            options = listOf(
                QuestionOption("a", "Distinct `id` values present in `all_users` that do not appear in `banned_users`."),
                QuestionOption("b", "`id` values that appear in both `all_users` and `banned_users`."),
                QuestionOption("c", "`id` values present in `banned_users` that are missing from `all_users`."),
                QuestionOption("d", "All rows from both tables except duplicates.")
            ),
            correctOptionId = "a",
            explanation = "`A EXCEPT B` performs set difference, returning distinct rows from the left query `A` that are not present in the right query `B`."
        ),
        QuizQuestion(
            id = "sql_a_15",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How does `SUM(bonus) OVER (PARTITION BY dept_id)` differ from `SUM(bonus) ... GROUP BY dept_id`?",
            languageNote = "ANSI SQL Window Functions",
            options = listOf(
                QuestionOption("a", "The window function `OVER (PARTITION BY dept_id)` computes the department sum while preserving every individual employee row, whereas `GROUP BY dept_id` collapses each department into a single summary row."),
                QuestionOption("b", "`OVER (PARTITION BY ...)` physically splits the table into separate disk partitions."),
                QuestionOption("c", "`OVER (PARTITION BY ...)` only works when there is a `GROUP BY` clause."),
                QuestionOption("d", "`SUM(...) OVER (...)` ignores rows where `bonus` is positive.")
            ),
            correctOptionId = "a",
            explanation = "Window functions (`OVER (...)`) compute aggregates across a window of rows related to the current row without collapsing the query's output rows."
        ),

        // ==================== ADVANCED (15) ====================
        QuizQuestion(
            id = "sql_x_01",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "A table `orders` has a composite B-tree index on `(region, status, created_at)`. Which of the following `WHERE` predicates can directly use the leading prefix of this B-tree index for an index range/lookup scan?",
            languageNote = "PostgreSQL / MySQL / SQLite B-Tree Indexing",
            options = listOf(
                QuestionOption("a", "`WHERE region = 'APAC' AND status = 'PAID'`"),
                QuestionOption("b", "`WHERE status = 'PAID' AND created_at >= '2026-01-01'`"),
                QuestionOption("c", "`WHERE created_at = '2026-01-01'`"),
                QuestionOption("d", "`WHERE LOWER(region) = 'apac'` (when no functional/expression index exists)")
            ),
            correctOptionId = "a",
            explanation = "A composite B-tree index on `(region, status, created_at)` is sorted first by `region`, then `status`, then `created_at` (the leftmost prefix rule). Queries filtering on `(region, status)` match the leftmost prefix, whereas skipping `region` or wrapping `region` in `LOWER(...)` prevents standard leftmost B-tree lookup."
        ),
        QuizQuestion(
            id = "sql_x_02",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL window functions, what is the default window frame when an `ORDER BY` is specified inside `OVER(...)`, such as `SUM(amount) OVER (ORDER BY tx_date)`?",
            languageNote = "ANSI SQL / PostgreSQL / SQLite",
            options = listOf(
                QuestionOption("a", "`RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW` (which includes all peer rows tied with the current row's `tx_date`)."),
                QuestionOption("b", "`ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING` (the entire partition)."),
                QuestionOption("c", "`ROWS BETWEEN 1 PRECEDING AND CURRENT ROW`."),
                QuestionOption("d", "`ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING`.")
            ),
            correctOptionId = "a",
            explanation = "When `ORDER BY` is present inside `OVER(...)` without an explicit `ROWS` or `RANGE` clause, ANSI SQL defaults the frame to `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`. This produces a running total where tied `tx_date` peers share the same cumulative sum."
        ),
        QuizQuestion(
            id = "sql_x_03",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Because of the default `RANGE` frame behavior, why does `LAST_VALUE(salary) OVER (PARTITION BY dept ORDER BY salary)` often surprise developers by returning the current row's salary instead of the highest salary in the department?",
            languageNote = "ANSI SQL Window Functions",
            options = listOf(
                QuestionOption("a", "With `ORDER BY salary`, the default frame ends at `CURRENT ROW`, so the 'last value' in the frame is just the current row (or its last peer). Extending the frame to `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING` fixes it."),
                QuestionOption("b", "`LAST_VALUE` sorts values in reverse order automatically."),
                QuestionOption("c", "`LAST_VALUE` returns `NULL` unless `GROUP BY` is also used."),
                QuestionOption("d", "`LAST_VALUE` only inspects the first row of each partition.")
            ),
            correctOptionId = "a",
            explanation = "Because `ORDER BY` in `OVER(...)` defaults the frame upper bound to `CURRENT ROW`, `LAST_VALUE` only sees rows up to the current row unless you specify `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING`."
        ),
        QuizQuestion(
            id = "sql_x_04",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a Recursive Common Table Expression (`WITH RECURSIVE`), why is it important to understand the difference between `UNION ALL` and `UNION` between the anchor member and the recursive member?",
            languageNote = "ANSI SQL / PostgreSQL / SQLite",
            options = listOf(
                QuestionOption("a", "`UNION` deduplicates generated rows and can prevent infinite loops on cyclic graphs with finite nodes, whereas `UNION ALL` does not deduplicate and will loop infinitely on cycles unless cycle detection or a depth limit is added."),
                QuestionOption("b", "`UNION ALL` is forbidden in `WITH RECURSIVE` queries."),
                QuestionOption("c", "`UNION` stops recursion after exactly 1 iteration."),
                QuestionOption("d", "`UNION ALL` automatically sorts the hierarchy from leaf to root.")
            ),
            correctOptionId = "a",
            explanation = "In `WITH RECURSIVE`, `UNION` discards rows that have already been produced, terminating traversal over finite cycles on the projected columns, while `UNION ALL` keeps appending rows every step until the working table is empty."
        ),
        QuizQuestion(
            id = "sql_x_05",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Under ANSI SQL transaction isolation levels, which phenomenon can still occur at `READ COMMITTED` that is prevented by `REPEATABLE READ`?",
            languageNote = "ANSI SQL Transactions",
            options = listOf(
                QuestionOption("a", "Non-repeatable reads: re-reading the same row twice within the same transaction can return different values if another transaction committed an `UPDATE` in between."),
                QuestionOption("b", "Dirty reads: reading uncommitted changes made by another active transaction."),
                QuestionOption("c", "Syntax errors when running two `SELECT` statements in one transaction."),
                QuestionOption("d", "Automatic table dropping on rollback.")
            ),
            correctOptionId = "a",
            explanation = "`READ COMMITTED` prevents dirty reads (only committed data is visible), but each statement sees a fresh snapshot of committed data, allowing non-repeatable reads. `REPEATABLE READ` guarantees that rows read once keep the same values throughout the transaction."
        ),
        QuizQuestion(
            id = "sql_x_06",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a **covering index** (index-only scan) in relational databases?",
            languageNote = "Database Internals / SQL Optimization",
            options = listOf(
                QuestionOption("a", "An index that contains all columns needed by a query's `SELECT`, `WHERE`, and `JOIN` clauses, allowing the engine to answer the query directly from the index without fetching rows from the main table heap."),
                QuestionOption("b", "An index that automatically indexes every table in the entire database schema."),
                QuestionOption("c", "An index that encrypts all columns on disk."),
                QuestionOption("d", "A full-text index that only works on `BLOB` columns.")
            ),
            correctOptionId = "a",
            explanation = "When all columns referenced by a query are stored in the index entries (and visibility permits), the optimizer can perform an Index-Only Scan, avoiding random I/O lookups back to the table pages."
        ),
        QuizQuestion(
            id = "sql_x_07",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `WHERE created_at >= '2026-01-01' AND created_at < '2027-01-01'` considered **SARGable** (Search Argument Able) on an indexed `created_at` column, whereas `WHERE EXTRACT(YEAR FROM created_at) = 2026` is generally not?",
            languageNote = "SQL Query Optimization",
            options = listOf(
                QuestionOption("a", "Applying a function like `EXTRACT(YEAR FROM created_at)` to the indexed column prevents a standard B-tree index range scan on `created_at`, forcing a full scan (unless an expression index exists), whereas the range comparison scans a contiguous slice of the B-tree."),
                QuestionOption("b", "`EXTRACT(YEAR FROM ...)` returns a string instead of a number."),
                QuestionOption("c", "Range comparisons (`>=` and `<`) never use indexes in SQL."),
                QuestionOption("d", "`EXTRACT` modifies the underlying table data during a `SELECT`.")
            ),
            correctOptionId = "a",
            explanation = "Keeping the indexed column bare on one side of a range predicate (`created_at >= ... AND created_at < ...`) lets the optimizer seek directly to `'2026-01-01'` in the B-tree and scan sequentially up to `'2027-01-01'`."
        ),
        QuizQuestion(
            id = "sql_x_08",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does the following query using `LAG()` compute for each row?",
            codeSnippet = """
                SELECT
                    day,
                    revenue,
                    revenue - LAG(revenue, 1, 0) OVER (ORDER BY day) AS delta
                FROM daily_metrics;
            """.trimIndent(),
            languageNote = "ANSI SQL Window Functions",
            options = listOf(
                QuestionOption("a", "The day-over-day change in `revenue`, using `0` as the fallback previous revenue for the very first day."),
                QuestionOption("b", "The average revenue of all previous days."),
                QuestionOption("c", "The difference between the current day's revenue and the final day's revenue."),
                QuestionOption("d", "Always `0` because `LAG` looks at the current row.")
            ),
            correctOptionId = "a",
            explanation = "`LAG(revenue, 1, 0) OVER (ORDER BY day)` accesses the `revenue` value from 1 row prior in `day` order, returning default `0` when no prior row exists (row 1)."
        ),
        QuizQuestion(
            id = "sql_x_09",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How can two concurrent transactions cause a **deadlock** in a relational database using row-level locks?",
            languageNote = "SQL Concurrency & Locking",
            options = listOf(
                QuestionOption("a", "Transaction 1 locks Row A and waits to lock Row B, while Transaction 2 simultaneously holds the lock on Row B and waits to lock Row A, forming a circular wait."),
                QuestionOption("b", "Both transactions run read-only `SELECT` queries without locking any rows."),
                QuestionOption("c", "A single transaction updates the same row twice in a row."),
                QuestionOption("d", "Deadlocks only happen when a database has no primary keys.")
            ),
            correctOptionId = "a",
            explanation = "A deadlock arises when transactions acquire locks in conflicting orders, creating a cycle in the wait-for graph. Acquiring row locks in a consistent canonical order (e.g., ascending `account_id`) prevents this cycle."
        ),
        QuizQuestion(
            id = "sql_x_10",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, why does `SELECT * FROM employees WHERE ROWNUM_OR_RANK <= 2` require a subquery or CTE when using a window function like `DENSE_RANK() OVER (PARTITION BY dept ORDER BY salary DESC) AS rnk`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "Window functions are evaluated in the `SELECT` phase—after `WHERE`, `GROUP BY`, and `HAVING`—so you cannot filter on a window function result in the same query's `WHERE` clause."),
                QuestionOption("b", "`DENSE_RANK()` can only be used inside `INSERT` statements."),
                QuestionOption("c", "`WHERE` only accepts string comparisons when window functions are present."),
                QuestionOption("d", "Window functions run before `FROM`, so table columns are not available.")
            ),
            correctOptionId = "a",
            explanation = "Because window functions execute after `WHERE`, `GROUP BY`, and `HAVING`, filtering on `rnk <= 2` requires wrapping the windowed query in a CTE or subquery and filtering in the outer `WHERE`."
        ),
        QuizQuestion(
            id = "sql_x_11",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In database normalization, what violation does **Third Normal Form (3NF)** eliminate beyond Second Normal Form (2NF)?",
            languageNote = "Relational Database Theory",
            options = listOf(
                QuestionOption("a", "Transitive dependencies where a non-key attribute depends on another non-key attribute rather than directly on candidate keys."),
                QuestionOption("b", "Having more than three columns in a single table."),
                QuestionOption("c", "Using `FOREIGN KEY` constraints between tables."),
                QuestionOption("d", "Storing integer primary keys instead of UUIDs.")
            ),
            correctOptionId = "a",
            explanation = "2NF removes partial dependencies on a composite candidate key; 3NF further eliminates transitive functional dependencies (Key → NonKey1 → NonKey2), reducing update and deletion anomalies."
        ),
        QuizQuestion(
            id = "sql_x_12",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the behavior of `ON DELETE CASCADE` on a foreign key `order_items.order_id REFERENCES orders(id) ON DELETE CASCADE`?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "When a row in `orders` is deleted, all child rows in `order_items` referencing that `order_id` are automatically deleted as part of the operation."),
                QuestionOption("b", "Deleting a child row in `order_items` automatically deletes the parent row in `orders`."),
                QuestionOption("c", "Deleting a row in `orders` is blocked with an error if any `order_items` exist."),
                QuestionOption("d", "Child rows in `order_items` have their `order_id` set to `NULL`.")
            ),
            correctOptionId = "a",
            explanation = "`ON DELETE CASCADE` propagates deletions from the parent table (`orders`) to dependent rows in the child table (`order_items`). (`RESTRICT`/`NO ACTION` blocks deletion, and `SET NULL` sets the foreign key to `NULL`)."
        ),
        QuizQuestion(
            id = "sql_x_13",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does the standard SQL expression `x IS NOT DISTINCT FROM y` evaluate to when both `x` and `y` are `NULL`?",
            languageNote = "ANSI SQL / PostgreSQL / SQLite",
            options = listOf(
                QuestionOption("a", "`TRUE` (it treats two `NULL` values as equal and never returns `UNKNOWN`)."),
                QuestionOption("b", "`UNKNOWN` (identical to `x = y`)."),
                QuestionOption("c", "`FALSE`."),
                QuestionOption("d", "Raises a null-comparison exception.")
            ),
            correctOptionId = "a",
            explanation = "`IS NOT DISTINCT FROM` is SQL's null-safe equality operator: it returns `TRUE` if both operands are `NULL` or if both are non-NULL and equal, and `FALSE` otherwise."
        ),
        QuizQuestion(
            id = "sql_x_14",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Suppose an `accounts` table has a `CHECK (balance >= 0)` constraint. What happens when an `UPDATE` statement sets `balance` to `NULL` (assuming the column is not marked `NOT NULL`)?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "The `UPDATE` succeeds because a `CHECK` constraint only fails when its condition evaluates to `FALSE`; `NULL >= 0` evaluates to `UNKNOWN`, which passes `CHECK`."),
                QuestionOption("b", "The `UPDATE` is rejected because `CHECK` requires the expression to evaluate strictly to `TRUE`."),
                QuestionOption("c", "`balance` is automatically converted to `0`."),
                QuestionOption("d", "The `CHECK` constraint is permanently disabled.")
            ),
            correctOptionId = "a",
            explanation = "In ANSI SQL, a `CHECK` constraint is satisfied as long as its boolean expression does not evaluate to `FALSE`. When `balance` is `NULL`, `balance >= 0` is `UNKNOWN`, so the row is accepted unless `NOT NULL` is also specified."
        ),
        QuizQuestion(
            id = "sql_x_15",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `SELECT dept, COUNT(*) FROM staff GROUP BY dept HAVING COUNT(*) > ALL (SELECT AVG(cnt) FROM (SELECT COUNT(*) AS cnt FROM staff GROUP BY dept) t);` find?",
            languageNote = "ANSI SQL",
            options = listOf(
                QuestionOption("a", "All departments whose headcount is strictly greater than the average department headcount."),
                QuestionOption("b", "Only the single largest department, breaking ties randomly."),
                QuestionOption("c", "Departments with zero employees."),
                QuestionOption("d", "Every department in the `staff` table.")
            ),
            correctOptionId = "a",
            explanation = "The inner subquery computes each department's headcount (`cnt`), the middle query computes the average headcount across departments, and `HAVING COUNT(*) > ...` keeps departments exceeding that average."
        )
    )
}
