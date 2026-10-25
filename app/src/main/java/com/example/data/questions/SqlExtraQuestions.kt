package com.example.data.questions

import com.example.model.QuestionOption
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object SqlExtraQuestions {
    val questions: List<QuizQuestion> by lazy {
        foundationBatch1() + foundationBatch2() +
            appliedBatch1() + appliedBatch2() +
            advancedBatch1() + advancedBatch2()
    }

    private fun foundationBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "sql_f_16",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ANSI SQL, which keyword is used with SELECT to return only unique rows from a query result?",
            options = listOf(
                QuestionOption("a", "DISTINCT"),
                QuestionOption("b", "UNIQUE"),
                QuestionOption("c", "DIFFERENT"),
                QuestionOption("d", "SINGLE")
            ),
            correctOptionId = "a",
            explanation = "SELECT DISTINCT removes duplicate rows from the result set."
        ),
        QuizQuestion(
            id = "sql_f_17",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, which clause is used to filter rows BEFORE any grouping (GROUP BY) takes place?",
            options = listOf(
                QuestionOption("a", "HAVING"),
                QuestionOption("b", "ORDER BY"),
                QuestionOption("c", "LIMIT"),
                QuestionOption("d", "WHERE")
            ),
            correctOptionId = "d",
            explanation = "WHERE filters individual rows before GROUP BY aggregates them."
        ),
        QuizQuestion(
            id = "sql_f_18",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, which clause is used to filter groups created by a GROUP BY clause based on an aggregate condition?",
            options = listOf(
                QuestionOption("a", "GROUP FILTER"),
                QuestionOption("b", "WHEN"),
                QuestionOption("c", "HAVING"),
                QuestionOption("d", "WHERE")
            ),
            correctOptionId = "c",
            explanation = "HAVING filters aggregated groups after GROUP BY has been applied."
        ),
        QuizQuestion(
            id = "sql_f_19",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ANSI SQL, what is the default sort order when `ORDER BY salary` is specified without ASC or DESC?",
            options = listOf(
                QuestionOption("a", "Random order"),
                QuestionOption("b", "Ascending (lowest to highest)"),
                QuestionOption("c", "Descending (highest to lowest)"),
                QuestionOption("d", "Insertion order in the table")
            ),
            correctOptionId = "b",
            explanation = "ORDER BY defaults to ASC (ascending order) when no direction keyword is provided."
        ),
        QuizQuestion(
            id = "sql_f_20",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL aggregate function returns the total number of rows matching a query, including rows containing NULL values?",
            options = listOf(
                QuestionOption("a", "COUNT(*)"),
                QuestionOption("b", "COUNT(column_name)"),
                QuestionOption("c", "SUM(*)"),
                QuestionOption("d", "TOTAL(*)")
            ),
            correctOptionId = "a",
            explanation = "COUNT(*) counts all rows in the group regardless of NULL values, whereas COUNT(col) ignores NULLs in col."
        ),
        QuizQuestion(
            id = "sql_f_21",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given table `orders(amount INT)` with rows `100`, `NULL`, `200`, what does `SELECT COUNT(amount), COUNT(*) FROM orders;` return?",
            options = listOf(
                QuestionOption("a", "3 and 3"),
                QuestionOption("b", "2 and 2"),
                QuestionOption("c", "NULL and 3"),
                QuestionOption("d", "2 and 3")
            ),
            correctOptionId = "d",
            explanation = "COUNT(amount) ignores the NULL row and returns 2; COUNT(*) counts all 3 rows."
        ),
        QuizQuestion(
            id = "sql_f_22",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given table `scores(pts INT)` with rows `10`, `NULL`, `20`, what does `SELECT AVG(pts) FROM scores;` return in standard SQL?",
            options = listOf(
                QuestionOption("a", "NULL"),
                QuestionOption("b", "30"),
                QuestionOption("c", "15"),
                QuestionOption("d", "10")
            ),
            correctOptionId = "c",
            explanation = "Aggregate functions like AVG ignore NULL values, averaging 10 and 20 to return 15."
        ),
        QuizQuestion(
            id = "sql_f_23",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, which operator is used in a WHERE clause to test whether a column value is NULL?",
            options = listOf(
                QuestionOption("a", "EQUALS NULL"),
                QuestionOption("b", "IS NULL"),
                QuestionOption("c", "= NULL"),
                QuestionOption("d", "== NULL")
            ),
            correctOptionId = "b",
            explanation = "Comparisons with NULL using = yield UNKNOWN; IS NULL or IS NOT NULL must be used."
        ),
        QuizQuestion(
            id = "sql_f_24",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ANSI SQL, what does the expression `NULL = NULL` evaluate to in a WHERE clause?",
            options = listOf(
                QuestionOption("a", "UNKNOWN (so the row is not returned)"),
                QuestionOption("b", "TRUE"),
                QuestionOption("c", "FALSE"),
                QuestionOption("d", "A syntax error")
            ),
            correctOptionId = "a",
            explanation = "In SQL three-valued logic, comparing NULL with = produces UNKNOWN, which filters out the row in WHERE."
        ),
        QuizQuestion(
            id = "sql_f_25",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, which operator checks whether a value falls within an inclusive range `low` to `high`?",
            options = listOf(
                QuestionOption("a", "IN RANGE (low, high)"),
                QuestionOption("b", "WITHIN low TO high"),
                QuestionOption("c", "FROM low TO high"),
                QuestionOption("d", "BETWEEN low AND high")
            ),
            correctOptionId = "d",
            explanation = "BETWEEN low AND high is inclusive of both boundary values (`col >= low AND col <= high`)."
        ),
        QuizQuestion(
            id = "sql_f_26",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL `WHERE city IN ('Pune', 'Delhi', 'Chennai')`, what is the `IN` operator shorthand for?",
            options = listOf(
                QuestionOption("a", "city LIKE 'PuneDelhiChennai'"),
                QuestionOption("b", "city BETWEEN 'Pune' AND 'Chennai'"),
                QuestionOption("c", "city = 'Pune' OR city = 'Delhi' OR city = 'Chennai'"),
                QuestionOption("d", "city = 'Pune' AND city = 'Delhi' AND city = 'Chennai'")
            ),
            correctOptionId = "c",
            explanation = "IN matches if the column equals any value in the provided list."
        ),
        QuizQuestion(
            id = "sql_f_27",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL pattern matching with the `LIKE` operator, what does the percent wildcard `%` match?",
            options = listOf(
                QuestionOption("a", "Only whitespace characters"),
                QuestionOption("b", "Zero, one, or more characters"),
                QuestionOption("c", "Exactly one character"),
                QuestionOption("d", "Only numeric digits")
            ),
            correctOptionId = "b",
            explanation = "In LIKE patterns, % matches any sequence of zero or more characters."
        ),
        QuizQuestion(
            id = "sql_f_28",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL pattern matching with the `LIKE` operator, what does the underscore wildcard `_` match?",
            options = listOf(
                QuestionOption("a", "Exactly one single character"),
                QuestionOption("b", "Zero or more characters"),
                QuestionOption("c", "An literal underscore only"),
                QuestionOption("d", "Word boundaries")
            ),
            correctOptionId = "a",
            explanation = "In LIKE patterns, _ matches any single character."
        ),
        QuizQuestion(
            id = "sql_f_29",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL pattern matches any string that starts with `'Pro'` followed by at least one character?",
            options = listOf(
                QuestionOption("a", "LIKE 'Pro%'"),
                QuestionOption("b", "LIKE '_Pro%'"),
                QuestionOption("c", "LIKE '%Pro'"),
                QuestionOption("d", "LIKE 'Pro_%'")
            ),
            correctOptionId = "d",
            explanation = "Pro_% requires 'Pro', then at least one character (_), then zero or more characters (%)."
        ),
        QuizQuestion(
            id = "sql_f_30",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL statement is used to add a new row of data into an existing table?",
            options = listOf(
                QuestionOption("a", "CREATE ROW IN table_name (...)"),
                QuestionOption("b", "APPEND TO table_name VALUES (...)"),
                QuestionOption("c", "INSERT INTO table_name VALUES (...)"),
                QuestionOption("d", "ADD ROW INTO table_name (...)")
            ),
            correctOptionId = "c",
            explanation = "INSERT INTO adds one or more new rows to a table."
        ),
        QuizQuestion(
            id = "sql_f_31",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL statement modifies existing values in rows of a table?",
            options = listOf(
                QuestionOption("a", "ALTER ROW table_name SET col = val"),
                QuestionOption("b", "UPDATE table_name SET col = val WHERE ..."),
                QuestionOption("c", "MODIFY table_name SET col = val WHERE ..."),
                QuestionOption("d", "CHANGE table_name col = val WHERE ...")
            ),
            correctOptionId = "b",
            explanation = "UPDATE ... SET ... WHERE modifies existing table rows."
        ),
        QuizQuestion(
            id = "sql_f_32",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens if you execute `UPDATE employees SET bonus = 500;` WITHOUT a `WHERE` clause?",
            options = listOf(
                QuestionOption("a", "Every row in the `employees` table has its `bonus` set to 500"),
                QuestionOption("b", "Only the first row is updated"),
                QuestionOption("c", "SQL rejects the query with a syntax error"),
                QuestionOption("d", "No rows are updated")
            ),
            correctOptionId = "a",
            explanation = "Omitting the WHERE clause in an UPDATE applies the change to all rows in the table."
        ),
        QuizQuestion(
            id = "sql_f_33",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What happens if you execute `DELETE FROM logs;` WITHOUT a `WHERE` clause?",
            options = listOf(
                QuestionOption("a", "The `logs` table and its schema are completely dropped"),
                QuestionOption("b", "Only the oldest row is deleted"),
                QuestionOption("c", "A syntax error occurs"),
                QuestionOption("d", "All rows are removed from `logs`, but the table structure remains")
            ),
            correctOptionId = "d",
            explanation = "DELETE FROM without WHERE removes all rows while preserving the table, columns, and indexes."
        ),
        QuizQuestion(
            id = "sql_f_34",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which DDL statement completely removes a table, its data, and its schema definition from the database?",
            options = listOf(
                QuestionOption("a", "TRUNCATE TABLE table_name"),
                QuestionOption("b", "REMOVE TABLE table_name"),
                QuestionOption("c", "DROP TABLE table_name"),
                QuestionOption("d", "DELETE TABLE table_name")
            ),
            correctOptionId = "c",
            explanation = "DROP TABLE deletes both the rows and the table schema/metadata."
        ),
        QuizQuestion(
            id = "sql_f_35",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL DDL statement removes all rows from a table quickly without logging individual row deletions, while keeping the table structure?",
            options = listOf(
                QuestionOption("a", "EMPTY TABLE table_name"),
                QuestionOption("b", "TRUNCATE TABLE table_name"),
                QuestionOption("c", "DROP TABLE table_name"),
                QuestionOption("d", "CLEAR TABLE table_name")
            ),
            correctOptionId = "b",
            explanation = "TRUNCATE TABLE deallocates data pages or resets the table while keeping its schema intact."
        ),
        QuizQuestion(
            id = "sql_f_36",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL statement is used to add a new column to an existing table?",
            options = listOf(
                QuestionOption("a", "ALTER TABLE table_name ADD COLUMN col_name data_type"),
                QuestionOption("b", "UPDATE TABLE table_name ADD col_name data_type"),
                QuestionOption("c", "MODIFY TABLE table_name INSERT col_name data_type"),
                QuestionOption("d", "CHANGE TABLE table_name ADD col_name data_type")
            ),
            correctOptionId = "a",
            explanation = "ALTER TABLE modifies the schema of an existing table, such as adding or dropping columns."
        ),
        QuizQuestion(
            id = "sql_f_37",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What constraint uniquely identifies each row in a relational database table and implicitly enforces `NOT NULL` and `UNIQUE`?",
            options = listOf(
                QuestionOption("a", "FOREIGN KEY"),
                QuestionOption("b", "CHECK"),
                QuestionOption("c", "DEFAULT"),
                QuestionOption("d", "PRIMARY KEY")
            ),
            correctOptionId = "d",
            explanation = "A PRIMARY KEY enforces uniqueness and disallows NULL values on the key column(s)."
        ),
        QuizQuestion(
            id = "sql_f_38",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "How many `PRIMARY KEY` constraints can a single SQL table have?",
            options = listOf(
                QuestionOption("a", "Up to two"),
                QuestionOption("b", "Unlimited"),
                QuestionOption("c", "At most one (though it may be composite across multiple columns)"),
                QuestionOption("d", "One per column")
            ),
            correctOptionId = "c",
            explanation = "A table can have only one primary key, which can consist of a single column or multiple columns (composite key)."
        ),
        QuizQuestion(
            id = "sql_f_39",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, can a column with a `UNIQUE` constraint contain `NULL` values (in standard ANSI SQL / PostgreSQL / SQLite)?",
            options = listOf(
                QuestionOption("a", "Only for integer columns"),
                QuestionOption("b", "Yes, multiple NULLs are allowed because NULL is not equal to NULL"),
                QuestionOption("c", "No, UNIQUE automatically implies NOT NULL"),
                QuestionOption("d", "Only if PRIMARY KEY is also set")
            ),
            correctOptionId = "b",
            explanation = "Standard SQL allows NULLs in a UNIQUE column because NULL represents an unknown value distinct from other NULLs."
        ),
        QuizQuestion(
            id = "sql_f_40",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does a `FOREIGN KEY` constraint enforce in a relational database?",
            options = listOf(
                QuestionOption("a", "Referential integrity between a child column and a referenced parent key"),
                QuestionOption("b", "That a column is automatically indexed in descending order"),
                QuestionOption("c", "That a column cannot be queried with SELECT"),
                QuestionOption("d", "That a column stores JSON strings")
            ),
            correctOptionId = "a",
            explanation = "A FOREIGN KEY ensures values in the child table match an existing key in the parent table (or are NULL)."
        ),
        QuizQuestion(
            id = "sql_f_41",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the `NOT NULL` column constraint prevent?",
            options = listOf(
                QuestionOption("a", "Inserting duplicate values in that column"),
                QuestionOption("b", "Inserting zero or empty string '' in that column"),
                QuestionOption("c", "Dropping the table"),
                QuestionOption("d", "Inserting or updating a row with a NULL value in that column")
            ),
            correctOptionId = "d",
            explanation = "NOT NULL requires every row to have a non-null value for that column."
        ),
        QuizQuestion(
            id = "sql_f_42",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the `DEFAULT` constraint on a column do during an `INSERT`?",
            options = listOf(
                QuestionOption("a", "Forces all rows to have the exact same value"),
                QuestionOption("b", "Automatically creates a primary key"),
                QuestionOption("c", "Supplies a specified fallback value when the INSERT statement omits that column"),
                QuestionOption("d", "Prevents the column from ever being updated")
            ),
            correctOptionId = "c",
            explanation = "DEFAULT assigns the configured value when no explicit value is provided on INSERT."
        ),
        QuizQuestion(
            id = "sql_f_43",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does a `CHECK (age >= 18)` constraint on a table column enforce?",
            options = listOf(
                QuestionOption("a", "It only validates existing rows when the table is dropped"),
                QuestionOption("b", "Every inserted or updated row must satisfy `age >= 18` (or be NULL)"),
                QuestionOption("c", "Rows with `age < 18` are silently hidden from SELECT queries"),
                QuestionOption("d", "The database automatically rounds `age` up to 18")
            ),
            correctOptionId = "b",
            explanation = "A CHECK constraint rejects INSERT or UPDATE operations where the boolean expression evaluates to FALSE."
        ),
        QuizQuestion(
            id = "sql_f_44",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL JOIN returns only the rows that have matching values in BOTH joined tables?",
            options = listOf(
                QuestionOption("a", "INNER JOIN"),
                QuestionOption("b", "LEFT OUTER JOIN"),
                QuestionOption("c", "RIGHT OUTER JOIN"),
                QuestionOption("d", "FULL OUTER JOIN")
            ),
            correctOptionId = "a",
            explanation = "INNER JOIN returns only rows where the join predicate matches in both tables."
        ),
        QuizQuestion(
            id = "sql_f_45",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL JOIN returns all rows from the left table, and matched rows from the right table (with NULLs when there is no match)?",
            options = listOf(
                QuestionOption("a", "INNER JOIN"),
                QuestionOption("b", "RIGHT JOIN"),
                QuestionOption("c", "CROSS JOIN"),
                QuestionOption("d", "LEFT JOIN (or LEFT OUTER JOIN)")
            ),
            correctOptionId = "d",
            explanation = "LEFT JOIN preserves all rows from the left table and fills unmatched right-side columns with NULL."
        ),
        QuizQuestion(
            id = "sql_f_46",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL JOIN returns the Cartesian product of two tables (every row of table A paired with every row of table B)?",
            options = listOf(
                QuestionOption("a", "NATURAL JOIN"),
                QuestionOption("b", "SELF JOIN"),
                QuestionOption("c", "CROSS JOIN"),
                QuestionOption("d", "INNER JOIN")
            ),
            correctOptionId = "c",
            explanation = "CROSS JOIN produces M * N rows when table A has M rows and table B has N rows."
        ),
        QuizQuestion(
            id = "sql_f_47",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "If table `A` has 4 rows and table `B` has 5 rows, how many rows does `SELECT * FROM A CROSS JOIN B;` return?",
            options = listOf(
                QuestionOption("a", "5"),
                QuestionOption("b", "20"),
                QuestionOption("c", "9"),
                QuestionOption("d", "4")
            ),
            correctOptionId = "b",
            explanation = "A Cartesian product of 4 rows and 5 rows returns 4 * 5 = 20 rows."
        ),
        QuizQuestion(
            id = "sql_f_48",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what is the purpose of an alias created with the `AS` keyword (e.g., `SELECT price * qty AS total`)?",
            options = listOf(
                QuestionOption("a", "To give a temporary display name to a column or table in the query"),
                QuestionOption("b", "To permanently rename the column in the database schema"),
                QuestionOption("c", "To cast the column to a string data type"),
                QuestionOption("d", "To create an index on the expression")
            ),
            correctOptionId = "a",
            explanation = "Aliases rename output columns or provide shorthand table references within a single query."
        ),
        QuizQuestion(
            id = "sql_f_49",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL aggregate function returns the largest value in a column?",
            options = listOf(
                QuestionOption("a", "TOP()"),
                QuestionOption("b", "HIGHEST()"),
                QuestionOption("c", "UPPER()"),
                QuestionOption("d", "MAX()")
            ),
            correctOptionId = "d",
            explanation = "MAX(col) returns the maximum non-null value in the group."
        ),
        QuizQuestion(
            id = "sql_f_50",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL aggregate function returns the smallest value in a column?",
            options = listOf(
                QuestionOption("a", "BOTTOM()"),
                QuestionOption("b", "LEAST_AGG()"),
                QuestionOption("c", "MIN()"),
                QuestionOption("d", "LOWEST()")
            ),
            correctOptionId = "c",
            explanation = "MIN(col) returns the minimum non-null value in the group."
        ),
        QuizQuestion(
            id = "sql_f_51",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL aggregate function returns the arithmetic total of numeric values in a column?",
            options = listOf(
                QuestionOption("a", "ACCUMULATE()"),
                QuestionOption("b", "SUM()"),
                QuestionOption("c", "TOTAL_COUNT()"),
                QuestionOption("d", "ADD()")
            ),
            correctOptionId = "b",
            explanation = "SUM(col) adds all non-null numeric values in the group."
        ),
        QuizQuestion(
            id = "sql_f_52",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQLite, PostgreSQL, and MySQL, which clause limits the maximum number of rows returned by a `SELECT` query?",
            options = listOf(
                QuestionOption("a", "LIMIT"),
                QuestionOption("b", "STOP AT"),
                QuestionOption("c", "MAXROWS"),
                QuestionOption("d", "RESTRICT")
            ),
            correctOptionId = "a",
            explanation = "LIMIT n restricts the output to at most n rows."
        ),
        QuizQuestion(
            id = "sql_f_53",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In `SELECT * FROM products ORDER BY id LIMIT 10 OFFSET 20;`, which rows are returned?",
            options = listOf(
                QuestionOption("a", "Rows 1 through 10"),
                QuestionOption("b", "Rows 10 through 20"),
                QuestionOption("c", "Every 10th row starting at 20"),
                QuestionOption("d", "Rows 21 through 30 (skips the first 20 rows, then returns the next 10)")
            ),
            correctOptionId = "d",
            explanation = "OFFSET 20 skips the first 20 rows, and LIMIT 10 takes the subsequent 10 rows."
        ),
        QuizQuestion(
            id = "sql_f_54",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ANSI SQL, which operator concatenates two character strings?",
            options = listOf(
                QuestionOption("a", "++"),
                QuestionOption("b", "::"),
                QuestionOption("c", "|| (double pipe) or CONCAT()"),
                QuestionOption("d", "&&")
            ),
            correctOptionId = "c",
            explanation = "Standard SQL uses `||` (supported by PostgreSQL, SQLite, Oracle) or the `CONCAT()` function."
        ),
        QuizQuestion(
            id = "sql_f_55",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the SQL function `COALESCE(a, b, c)` return?",
            options = listOf(
                QuestionOption("a", "TRUE if a, b, and c are all equal"),
                QuestionOption("b", "The first non-NULL argument from left to right (or NULL if all are NULL)"),
                QuestionOption("c", "The sum of a, b, and c"),
                QuestionOption("d", "A concatenated string of a, b, and c")
            ),
            correctOptionId = "b",
            explanation = "COALESCE evaluates its arguments in order and returns the first non-null value."
        ),
        QuizQuestion(
            id = "sql_f_56",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `SELECT COALESCE(NULL, NULL, 'fallback', 'backup');` return?",
            options = listOf(
                QuestionOption("a", "'fallback'"),
                QuestionOption("b", "NULL"),
                QuestionOption("c", "'backup'"),
                QuestionOption("d", "2")
            ),
            correctOptionId = "a",
            explanation = "COALESCE skips the first two NULLs and returns the first non-null argument, 'fallback'."
        ),
        QuizQuestion(
            id = "sql_f_57",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the ANSI SQL function `NULLIF(expr1, expr2)` return?",
            options = listOf(
                QuestionOption("a", "`expr2` if `expr1` is NULL"),
                QuestionOption("b", "TRUE if both expressions are NULL"),
                QuestionOption("c", "Zero if either expression is NULL"),
                QuestionOption("d", "NULL if `expr1 = expr2`; otherwise `expr1`")
            ),
            correctOptionId = "d",
            explanation = "NULLIF returns NULL when the two arguments are equal, commonly used to prevent division by zero: `x / NULLIF(y, 0)`."
        ),
        QuizQuestion(
            id = "sql_f_58",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `SELECT NULLIF(10, 10), NULLIF(10, 5);` return?",
            options = listOf(
                QuestionOption("a", "0 and 5"),
                QuestionOption("b", "TRUE and FALSE"),
                QuestionOption("c", "NULL and 10"),
                QuestionOption("d", "10 and 5")
            ),
            correctOptionId = "c",
            explanation = "Since 10 = 10, NULLIF(10, 10) is NULL; since 10 != 5, NULLIF(10, 5) returns the first argument 10."
        )
    )

    private fun foundationBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "sql_f_59",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, which expression allows conditional `if / then / else` logic inside a `SELECT`, `WHERE`, or `ORDER BY` clause?",
            options = listOf(
                QuestionOption("a", "CONDITIONAL WHEN ... END"),
                QuestionOption("b", "CASE WHEN ... THEN ... ELSE ... END"),
                QuestionOption("c", "IF (...) { ... } ELSE { ... }"),
                QuestionOption("d", "SWITCH ... CASE ... END")
            ),
            correctOptionId = "b",
            explanation = "The standard SQL CASE expression evaluates conditions sequentially and returns the matching THEN result."
        ),
        QuizQuestion(
            id = "sql_f_60",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a SQL `CASE WHEN x > 0 THEN 'Pos' END` expression with no `ELSE` clause, what is returned when `x` is `-5`?",
            options = listOf(
                QuestionOption("a", "NULL"),
                QuestionOption("b", "'' (empty string)"),
                QuestionOption("c", "0"),
                QuestionOption("d", "An error is raised")
            ),
            correctOptionId = "a",
            explanation = "If no WHEN condition matches and ELSE is omitted, a CASE expression returns NULL."
        ),
        QuizQuestion(
            id = "sql_f_61",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL set operator combines the result sets of two queries and removes duplicate rows by default?",
            options = listOf(
                QuestionOption("a", "UNION ALL"),
                QuestionOption("b", "JOIN"),
                QuestionOption("c", "MERGE"),
                QuestionOption("d", "UNION")
            ),
            correctOptionId = "d",
            explanation = "UNION combines two compatible result sets and eliminates duplicate rows."
        ),
        QuizQuestion(
            id = "sql_f_62",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL set operator combines the result sets of two queries and retains all duplicate rows?",
            options = listOf(
                QuestionOption("a", "INTERSECT"),
                QuestionOption("b", "EXCEPT"),
                QuestionOption("c", "UNION ALL"),
                QuestionOption("d", "UNION DISTINCT")
            ),
            correctOptionId = "c",
            explanation = "UNION ALL concatenates both result sets without deduplicating, making it faster than UNION."
        ),
        QuizQuestion(
            id = "sql_f_63",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What requirement must two `SELECT` queries satisfy to be combined with `UNION` or `UNION ALL`?",
            options = listOf(
                QuestionOption("a", "They must both contain a GROUP BY clause"),
                QuestionOption("b", "They must have the same number of columns with compatible data types in corresponding positions"),
                QuestionOption("c", "They must query the exact same table"),
                QuestionOption("d", "They must have identical WHERE clauses")
            ),
            correctOptionId = "b",
            explanation = "Set operations require union-compatible column counts and data types."
        ),
        QuizQuestion(
            id = "sql_f_64",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL string function converts all characters of a string to uppercase?",
            options = listOf(
                QuestionOption("a", "UPPER()"),
                QuestionOption("b", "TO_CAPS()"),
                QuestionOption("c", "CAPITALIZE()"),
                QuestionOption("d", "UCASE_ALL()")
            ),
            correctOptionId = "a",
            explanation = "UPPER(str) returns the string in uppercase characters."
        ),
        QuizQuestion(
            id = "sql_f_65",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL string function converts all characters of a string to lowercase?",
            options = listOf(
                QuestionOption("a", "DOWNCASE()"),
                QuestionOption("b", "SMALL()"),
                QuestionOption("c", "TO_LOWER()"),
                QuestionOption("d", "LOWER()")
            ),
            correctOptionId = "d",
            explanation = "LOWER(str) returns the string in lowercase characters."
        ),
        QuizQuestion(
            id = "sql_f_66",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does the SQL `TRIM('   hello   ')` function return?",
            options = listOf(
                QuestionOption("a", "'hello   '"),
                QuestionOption("b", "5"),
                QuestionOption("c", "'hello' (leading and trailing spaces removed)"),
                QuestionOption("d", "'   hello'")
            ),
            correctOptionId = "c",
            explanation = "TRIM removes leading and trailing whitespace (or specified characters) from a string."
        ),
        QuizQuestion(
            id = "sql_f_67",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ANSI SQL / PostgreSQL / SQLite, what does `LENGTH('Database')` (or `CHAR_LENGTH('Database')`) return?",
            options = listOf(
                QuestionOption("a", "0"),
                QuestionOption("b", "8"),
                QuestionOption("c", "7"),
                QuestionOption("d", "9")
            ),
            correctOptionId = "b",
            explanation = "'Database' has 8 characters."
        ),
        QuizQuestion(
            id = "sql_f_68",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what is the index of the first character in `SUBSTRING('SQLNova', 1, 3)` (or `SUBSTR('SQLNova', 1, 3)`)?",
            options = listOf(
                QuestionOption("a", "1-based, so it returns 'SQL'"),
                QuestionOption("b", "0-based, so it returns 'QLN'"),
                QuestionOption("c", "1-based, so it returns 'SQ'"),
                QuestionOption("d", "Negative-based")
            ),
            correctOptionId = "a",
            explanation = "SQL string positions are 1-based; starting at 1 with length 3 extracts 'SQL'."
        ),
        QuizQuestion(
            id = "sql_f_69",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL numeric function rounds a decimal number to a specified number of decimal places, such as `ROUND(12.346, 2)`?",
            options = listOf(
                QuestionOption("a", "TRUNC(12.346, 2) -> 12.35"),
                QuestionOption("b", "FLOOR(12.346, 2) -> 12.35"),
                QuestionOption("c", "CEIL(12.346, 2) -> 12.35"),
                QuestionOption("d", "ROUND(12.346, 2) -> 12.35")
            ),
            correctOptionId = "d",
            explanation = "ROUND(x, d) rounds x to d decimal places."
        ),
        QuizQuestion(
            id = "sql_f_70",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What do `FLOOR(4.8)` and `CEIL(4.2)` (or `CEILING(4.2)`) return in SQL?",
            options = listOf(
                QuestionOption("a", "4 and 4"),
                QuestionOption("b", "5 and 5"),
                QuestionOption("c", "4 and 5"),
                QuestionOption("d", "5 and 4")
            ),
            correctOptionId = "c",
            explanation = "FLOOR rounds down to the nearest integer <= x (4), and CEIL rounds up to the nearest integer >= x (5)."
        ),
        QuizQuestion(
            id = "sql_f_71",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `ABS(-42)` return in SQL?",
            options = listOf(
                QuestionOption("a", "NULL"),
                QuestionOption("b", "42"),
                QuestionOption("c", "-42"),
                QuestionOption("d", "0")
            ),
            correctOptionId = "b",
            explanation = "ABS(x) returns the absolute (non-negative) value of x."
        ),
        QuizQuestion(
            id = "sql_f_72",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In ANSI SQL, how do you convert a value from one data type to another, such as converting string `'125'` to an integer?",
            options = listOf(
                QuestionOption("a", "CAST('125' AS INTEGER)"),
                QuestionOption("b", "CONVERT_INT('125')"),
                QuestionOption("c", "INT('125')"),
                QuestionOption("d", "PARSE('125', INT)")
            ),
            correctOptionId = "a",
            explanation = "CAST(expression AS target_type) is the ANSI SQL standard for type conversion."
        ),
        QuizQuestion(
            id = "sql_f_73",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the difference between `CHAR(10)` and `VARCHAR(10)` in SQL?",
            options = listOf(
                QuestionOption("a", "CHAR(10) stores integers while VARCHAR(10) stores text"),
                QuestionOption("b", "VARCHAR(10) pads strings with zeros"),
                QuestionOption("c", "CHAR(10) can hold up to 10 megabytes"),
                QuestionOption("d", "CHAR(10) is fixed-length (padded with spaces), whereas VARCHAR(10) is variable-length up to 10 characters")
            ),
            correctOptionId = "d",
            explanation = "CHAR(n) allocates fixed length n, while VARCHAR(n) stores only the actual string characters up to length n."
        ),
        QuizQuestion(
            id = "sql_f_74",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "For storing exact monetary amounts like `199.95` where floating-point rounding errors are unacceptable, which SQL data type is appropriate?",
            options = listOf(
                QuestionOption("a", "REAL"),
                QuestionOption("b", "DOUBLE PRECISION"),
                QuestionOption("c", "DECIMAL(10, 2) or NUMERIC(10, 2)"),
                QuestionOption("d", "FLOAT")
            ),
            correctOptionId = "c",
            explanation = "DECIMAL/NUMERIC is an exact fixed-point type, avoiding binary floating-point representation inaccuracies."
        ),
        QuizQuestion(
            id = "sql_f_75",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In `DECIMAL(8, 3)`, what do the numbers `8` (precision) and `3` (scale) represent?",
            options = listOf(
                QuestionOption("a", "Minimum value 3 and maximum value 8"),
                QuestionOption("b", "8 total significant digits, with 3 digits after the decimal point (so up to 5 before it)"),
                QuestionOption("c", "8 digits before the decimal point and 3 digits after it"),
                QuestionOption("d", "8 bytes of storage and 3 decimal places")
            ),
            correctOptionId = "b",
            explanation = "Precision is the total number of digits; scale is the number of digits to the right of the decimal point."
        ),
        QuizQuestion(
            id = "sql_f_76",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what is a `VIEW`?",
            options = listOf(
                QuestionOption("a", "A virtual table defined by a stored SELECT query"),
                QuestionOption("b", "A physical copy of a table stored on a separate disk"),
                QuestionOption("c", "A backup file of the database"),
                QuestionOption("d", "A trigger that runs on DELETE")
            ),
            correctOptionId = "a",
            explanation = "A standard VIEW stores a query definition and dynamically presents its result set like a virtual table."
        ),
        QuizQuestion(
            id = "sql_f_77",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL statement creates a virtual table named `active_users` from a `SELECT` query?",
            options = listOf(
                QuestionOption("a", "MAKE VIRTUAL TABLE active_users FROM SELECT * FROM users;"),
                QuestionOption("b", "INSERT VIEW active_users SELECT * FROM users;"),
                QuestionOption("c", "DEFINE VIEW active_users (SELECT * FROM users);"),
                QuestionOption("d", "CREATE VIEW active_users AS SELECT * FROM users WHERE active = 1;")
            ),
            correctOptionId = "d",
            explanation = "CREATE VIEW view_name AS SELECT ... defines a database view."
        ),
        QuizQuestion(
            id = "sql_f_78",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is the primary benefit of creating an `INDEX` on a column frequently used in `WHERE` and `JOIN` clauses?",
            options = listOf(
                QuestionOption("a", "Faster INSERT, UPDATE, and DELETE operations on every column"),
                QuestionOption("b", "Automatic encryption of the column"),
                QuestionOption("c", "Faster data retrieval (avoids full table scans)"),
                QuestionOption("d", "Reduced disk space usage")
            ),
            correctOptionId = "c",
            explanation = "Indexes (such as B-trees) speed up lookups, joins, and ordering at the cost of extra disk space and write overhead."
        ),
        QuizQuestion(
            id = "sql_f_79",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is a trade-off of adding too many indexes to a write-heavy SQL table?",
            options = listOf(
                QuestionOption("a", "Foreign keys stop enforcing referential integrity"),
                QuestionOption("b", "INSERT, UPDATE, and DELETE operations become slower and additional storage is consumed"),
                QuestionOption("c", "SELECT queries become unable to use WHERE clauses"),
                QuestionOption("d", "The table can no longer have a PRIMARY KEY")
            ),
            correctOptionId = "b",
            explanation = "Every index must be maintained when indexed data changes, increasing write latency and storage."
        ),
        QuizQuestion(
            id = "sql_f_80",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In database transactions, what does the `COMMIT` statement do?",
            options = listOf(
                QuestionOption("a", "Permanently saves all changes made during the current transaction"),
                QuestionOption("b", "Undoes all changes made during the current transaction"),
                QuestionOption("c", "Starts a new read-only session"),
                QuestionOption("d", "Drops temporary tables only")
            ),
            correctOptionId = "a",
            explanation = "COMMIT makes all modifications in the current transaction permanent and visible to other transactions."
        ),
        QuizQuestion(
            id = "sql_f_81",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In database transactions, what does the `ROLLBACK` statement do?",
            options = listOf(
                QuestionOption("a", "Re-executes the previous transaction"),
                QuestionOption("b", "Deletes the transaction log file"),
                QuestionOption("c", "Commits half of the transaction"),
                QuestionOption("d", "Undoes all changes made in the current transaction since it began (or to a savepoint)")
            ),
            correctOptionId = "d",
            explanation = "ROLLBACK aborts the current transaction and restores the database to its pre-transaction state."
        ),
        QuizQuestion(
            id = "sql_f_82",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In the ACID properties of database transactions, what does the acronym `ACID` stand for?",
            options = listOf(
                QuestionOption("a", "Authentication, Caching, Indexing, Deduplication"),
                QuestionOption("b", "Accuracy, Completeness, Immutability, Dependability"),
                QuestionOption("c", "Atomicity, Consistency, Isolation, Durability"),
                QuestionOption("d", "Availability, Concurrency, Integrity, Distribution")
            ),
            correctOptionId = "c",
            explanation = "ACID stands for Atomicity, Consistency, Isolation, and Durability."
        ),
        QuizQuestion(
            id = "sql_f_83",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which ACID property guarantees that either ALL operations in a transaction succeed or NONE of them take effect?",
            options = listOf(
                QuestionOption("a", "Consistency"),
                QuestionOption("b", "Atomicity"),
                QuestionOption("c", "Isolation"),
                QuestionOption("d", "Durability")
            ),
            correctOptionId = "b",
            explanation = "Atomicity ensures a transaction is treated as an indivisible unit ('all or nothing')."
        ),
        QuizQuestion(
            id = "sql_f_84",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which ACID property guarantees that once a transaction is committed, its changes survive power loss or system crashes?",
            options = listOf(
                QuestionOption("a", "Durability"),
                QuestionOption("b", "Atomicity"),
                QuestionOption("c", "Isolation"),
                QuestionOption("d", "Consistency")
            ),
            correctOptionId = "a",
            explanation = "Durability ensures committed data is persisted (e.g., via write-ahead logs) even across crashes."
        ),
        QuizQuestion(
            id = "sql_f_85",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what is a self-join?",
            options = listOf(
                QuestionOption("a", "Joining two identical databases across servers"),
                QuestionOption("b", "A join that requires no ON clause"),
                QuestionOption("c", "Automatically duplicating every row in a table"),
                QuestionOption("d", "Joining a table to itself using two different table aliases")
            ),
            correctOptionId = "d",
            explanation = "A self-join joins a table to itself (e.g., `FROM employees e JOIN employees m ON e.manager_id = m.id`)."
        ),
        QuizQuestion(
            id = "sql_f_86",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL clause specifies the join condition between two tables in an explicit `JOIN`?",
            options = listOf(
                QuestionOption("a", "MATCHING"),
                QuestionOption("b", "WITH"),
                QuestionOption("c", "ON"),
                QuestionOption("d", "WHEREVER")
            ),
            correctOptionId = "c",
            explanation = "The ON clause defines the boolean predicate linking columns of the joined tables."
        ),
        QuizQuestion(
            id = "sql_f_87",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "When joining two tables that share the exact same column name `dept_id`, which shorthand clause can be used instead of `ON a.dept_id = b.dept_id`?",
            options = listOf(
                QuestionOption("a", "BY (dept_id)"),
                QuestionOption("b", "USING (dept_id)"),
                QuestionOption("c", "WITH (dept_id)"),
                QuestionOption("d", "COMMON (dept_id)")
            ),
            correctOptionId = "b",
            explanation = "JOIN ... USING (dept_id) joins on equality of the named column(s) present in both tables and deduplicates the column in SELECT *."
        ),
        QuizQuestion(
            id = "sql_f_88",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, if a `SELECT` query has a `GROUP BY dept_id` clause, what can legally appear in the `SELECT` list?",
            options = listOf(
                QuestionOption("a", "`dept_id` and aggregate functions (like `COUNT(*)`, `AVG(salary)`)"),
                QuestionOption("b", "Any arbitrary non-aggregated column without restriction in strict ANSI SQL"),
                QuestionOption("c", "Only `COUNT(*)` and nothing else"),
                QuestionOption("d", "Only columns NOT listed in `GROUP BY`")
            ),
            correctOptionId = "a",
            explanation = "In standard SQL, non-aggregated columns in SELECT must appear in the GROUP BY clause (or be functionally dependent on it)."
        ),
        QuizQuestion(
            id = "sql_f_89",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Why is `SELECT dept_id, COUNT(*) FROM emp WHERE COUNT(*) > 5 GROUP BY dept_id;` invalid in SQL?",
            options = listOf(
                QuestionOption("a", "`COUNT(*)` is not a valid function in SQL"),
                QuestionOption("b", "`GROUP BY` must always come before `WHERE`"),
                QuestionOption("c", "`dept_id` cannot be selected alongside `COUNT(*)`"),
                QuestionOption("d", "Aggregate functions like `COUNT(*)` cannot be used in the `WHERE` clause; `HAVING COUNT(*) > 5` must be used")
            ),
            correctOptionId = "d",
            explanation = "WHERE executes before grouping and cannot evaluate aggregates; HAVING filters groups after aggregation."
        ),
        QuizQuestion(
            id = "sql_f_90",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what is the syntactic order in which clauses must be WRITTEN in a `SELECT` statement?",
            options = listOf(
                QuestionOption("a", "SELECT -> WHERE -> FROM -> HAVING -> GROUP BY -> ORDER BY"),
                QuestionOption("b", "SELECT -> FROM -> GROUP BY -> WHERE -> HAVING -> ORDER BY"),
                QuestionOption("c", "SELECT -> FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY -> LIMIT"),
                QuestionOption("d", "FROM -> WHERE -> SELECT -> GROUP BY -> ORDER BY -> HAVING -> LIMIT")
            ),
            correctOptionId = "c",
            explanation = "The lexical order in SQL syntax is SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY, LIMIT."
        ),
        QuizQuestion(
            id = "sql_f_91",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In a relational database, what is a candidate key?",
            options = listOf(
                QuestionOption("a", "Any column with a DEFAULT value"),
                QuestionOption("b", "A minimal set of one or more columns that can uniquely identify every row in a table"),
                QuestionOption("c", "A foreign key that allows NULL values"),
                QuestionOption("d", "An index that allows duplicate values")
            ),
            correctOptionId = "b",
            explanation = "A candidate key is a minimal superkey; one candidate key is chosen as the PRIMARY KEY."
        ),
        QuizQuestion(
            id = "sql_f_92",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What is a composite primary key?",
            options = listOf(
                QuestionOption("a", "A primary key made up of two or more columns combined"),
                QuestionOption("b", "Two separate PRIMARY KEY constraints on the same table"),
                QuestionOption("c", "A primary key that also has a CHECK constraint"),
                QuestionOption("d", "An auto-incrementing integer column")
            ),
            correctOptionId = "a",
            explanation = "A composite key uses the combination of multiple columns to guarantee row uniqueness."
        ),
        QuizQuestion(
            id = "sql_f_93",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "What does `SELECT 15 % 4;` (or `MOD(15, 4)`) return in SQL?",
            options = listOf(
                QuestionOption("a", "3.75"),
                QuestionOption("b", "4"),
                QuestionOption("c", "1"),
                QuestionOption("d", "3")
            ),
            correctOptionId = "d",
            explanation = "Modulo returns the remainder of dividing 15 by 4, which is 3."
        ),
        QuizQuestion(
            id = "sql_f_94",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what happens when any arithmetic expression involves `NULL`, such as `SELECT 100 + NULL;`?",
            options = listOf(
                QuestionOption("a", "It evaluates to 0"),
                QuestionOption("b", "It throws a division by zero error"),
                QuestionOption("c", "It evaluates to NULL"),
                QuestionOption("d", "It evaluates to 100")
            ),
            correctOptionId = "c",
            explanation = "Arithmetic with an unknown (NULL) operand produces NULL unless wrapped in COALESCE."
        ),
        QuizQuestion(
            id = "sql_f_95",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Given `WHERE status NOT IN ('closed', 'cancelled')`, what does this condition match?",
            options = listOf(
                QuestionOption("a", "All rows in the table"),
                QuestionOption("b", "Rows where `status` is non-null and is neither `'closed'` nor `'cancelled'`"),
                QuestionOption("c", "Rows where `status` is NULL"),
                QuestionOption("d", "Rows where `status` is `'closed'`")
            ),
            correctOptionId = "b",
            explanation = "NOT IN (a, b) is equivalent to `status <> a AND status <> b`, which excludes both listed values (and NULLs)."
        ),
        QuizQuestion(
            id = "sql_f_96",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, which keyword is used to sort a column from highest to lowest value?",
            options = listOf(
                QuestionOption("a", "DESC"),
                QuestionOption("b", "ASC"),
                QuestionOption("c", "HIGH"),
                QuestionOption("d", "REVERSE")
            ),
            correctOptionId = "a",
            explanation = "ORDER BY col DESC sorts in descending order."
        ),
        QuizQuestion(
            id = "sql_f_97",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Can `ORDER BY` sort by multiple columns, such as `ORDER BY dept ASC, salary DESC`?",
            options = listOf(
                QuestionOption("a", "No; `ORDER BY` only accepts a single column"),
                QuestionOption("b", "Yes, but both columns must use the same direction (both ASC or both DESC)"),
                QuestionOption("c", "Only if both columns are in the PRIMARY KEY"),
                QuestionOption("d", "Yes; it sorts by `dept` ascending first, and breaks ties by `salary` descending")
            ),
            correctOptionId = "d",
            explanation = "Each column in ORDER BY can specify its own ASC or DESC direction; later columns break ties from earlier ones."
        ),
        QuizQuestion(
            id = "sql_f_98",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, how are single-line comments written?",
            options = listOf(
                QuestionOption("a", "## comment text"),
                QuestionOption("b", "rem comment text"),
                QuestionOption("c", "-- comment text"),
                QuestionOption("d", "// comment text")
            ),
            correctOptionId = "c",
            explanation = "Double hyphen (`--`) starts a single-line comment in standard SQL."
        ),
        QuizQuestion(
            id = "sql_f_99",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "In SQL, what does a scalar subquery in a `SELECT` list (e.g., `SELECT name, (SELECT MAX(sal) FROM emp) FROM dept`) return per row?",
            options = listOf(
                QuestionOption("a", "A boolean trigger"),
                QuestionOption("b", "A single value (at most one row and one column)"),
                QuestionOption("c", "Multiple columns and multiple rows"),
                QuestionOption("d", "A new physical table")
            ),
            correctOptionId = "b",
            explanation = "A scalar subquery returns at most one row and one column, allowing it to be used where a single value expression is expected."
        ),
        QuizQuestion(
            id = "sql_f_100",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            prompt = "Which SQL statement is used to remove a specific column `temp_notes` from an existing table `customers`?",
            options = listOf(
                QuestionOption("a", "ALTER TABLE customers DROP COLUMN temp_notes;"),
                QuestionOption("b", "DELETE COLUMN temp_notes FROM customers;"),
                QuestionOption("c", "REMOVE temp_notes FROM TABLE customers;"),
                QuestionOption("d", "DROP customers.temp_notes;")
            ),
            correctOptionId = "a",
            explanation = "ALTER TABLE ... DROP COLUMN removes a column from the table schema."
        )
    )

    private fun appliedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "sql_a_16",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is the logical order of query execution (as opposed to written order) for a `SELECT` query?",
            options = listOf(
                QuestionOption("a", "FROM / JOIN -> WHERE -> GROUP BY -> HAVING -> SELECT -> DISTINCT -> ORDER BY -> LIMIT"),
                QuestionOption("b", "SELECT -> FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY -> LIMIT"),
                QuestionOption("c", "WHERE -> FROM -> GROUP BY -> HAVING -> SELECT -> ORDER BY"),
                QuestionOption("d", "FROM -> SELECT -> WHERE -> GROUP BY -> HAVING -> ORDER BY")
            ),
            correctOptionId = "a",
            explanation = "Logically, SQL resolves tables in FROM/JOIN first, filters rows in WHERE, groups in GROUP BY, filters groups in HAVING, projects SELECT expressions, applies DISTINCT, sorts in ORDER BY, and limits rows."
        ),
        QuizQuestion(
            id = "sql_a_17",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why can a column alias defined in the `SELECT` list usually NOT be referenced inside the `WHERE` clause of the same query in standard SQL?",
            options = listOf(
                QuestionOption("a", "Because aliases can only be integers"),
                QuestionOption("b", "Because `WHERE` only accepts primary key columns"),
                QuestionOption("c", "Because `AS` is only valid in `ORDER BY`"),
                QuestionOption("d", "Because `WHERE` is logically evaluated BEFORE the `SELECT` projection list is computed")
            ),
            correctOptionId = "d",
            explanation = "Since WHERE runs before SELECT in logical query processing, aliases defined in SELECT do not exist yet when WHERE executes (though ORDER BY runs after SELECT and can use them)."
        ),
        QuizQuestion(
            id = "sql_a_18",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given table `items(id INT, price INT)` with 3 rows and `tags(item_id INT)` with rows `(1), (2), (NULL)`, how many rows does `SELECT * FROM items WHERE id NOT IN (SELECT item_id FROM tags);` return?",
            options = listOf(
                QuestionOption("a", "2 rows"),
                QuestionOption("b", "3 rows"),
                QuestionOption("c", "0 rows (because `id <> NULL` evaluates to UNKNOWN in `NOT IN`)"),
                QuestionOption("d", "1 row")
            ),
            correctOptionId = "c",
            explanation = "`x NOT IN (1, 2, NULL)` expands to `x <> 1 AND x <> 2 AND x <> NULL`. Because `x <> NULL` is UNKNOWN, the entire conjunction is never TRUE, returning 0 rows!"
        ),
        QuizQuestion(
            id = "sql_a_19",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why is `NOT EXISTS` generally preferred over `NOT IN (subquery)` when the subquery column is nullable?",
            options = listOf(
                QuestionOption("a", "`NOT EXISTS` returns duplicate rows"),
                QuestionOption("b", "`NOT EXISTS` checks row existence and is not tripped up by NULL values in the subquery"),
                QuestionOption("c", "`NOT EXISTS` automatically deletes NULL rows from the table"),
                QuestionOption("d", "`NOT IN` is a syntax error in ANSI SQL")
            ),
            correctOptionId = "b",
            explanation = "NOT EXISTS evaluates to TRUE when no correlated row matches, avoiding the three-valued logic trap of NOT IN with NULLs."
        ),
        QuizQuestion(
            id = "sql_a_20",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `emp(dept, sal)` with `(IT, 100), (IT, 100), (IT, 80)`, what do `ROW_NUMBER()`, `RANK()`, and `DENSE_RANK()` over `(ORDER BY sal DESC)` assign to the `80` row?",
            options = listOf(
                QuestionOption("a", "ROW_NUMBER = 3, RANK = 3, DENSE_RANK = 2"),
                QuestionOption("b", "ROW_NUMBER = 2, RANK = 2, DENSE_RANK = 3"),
                QuestionOption("c", "ROW_NUMBER = 3, RANK = 2, DENSE_RANK = 2"),
                QuestionOption("d", "ROW_NUMBER = 2, RANK = 3, DENSE_RANK = 3")
            ),
            correctOptionId = "a",
            explanation = "The two 100s tie at rank 1. ROW_NUMBER gives 1, 2, 3; RANK skips a rank after ties (1, 1, 3); DENSE_RANK does not skip ranks (1, 1, 2)."
        ),
        QuizQuestion(
            id = "sql_a_21",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a SQL window function, what does the `PARTITION BY dept_id` clause inside `OVER (PARTITION BY dept_id ORDER BY salary DESC)` do?",
            options = listOf(
                QuestionOption("a", "Collapses the entire query result into one row per `dept_id` like `GROUP BY`"),
                QuestionOption("b", "Physically partitions the table across multiple hard drives"),
                QuestionOption("c", "Filters out rows where `dept_id` is NULL"),
                QuestionOption("d", "Divides the rows into independent window partitions per `dept_id` without collapsing rows into one per group")
            ),
            correctOptionId = "d",
            explanation = "Unlike GROUP BY, window functions with PARTITION BY compute rankings or aggregates per partition while preserving every individual detail row."
        ),
        QuizQuestion(
            id = "sql_a_22",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `LAG(salary, 1, 0) OVER (ORDER BY hire_date)` return for each row?",
            options = listOf(
                QuestionOption("a", "The minimum salary in the table"),
                QuestionOption("b", "The difference between the current salary and previous salary"),
                QuestionOption("c", "The `salary` from 1 row BEFORE the current row in `hire_date` order (or `0` for the first row)"),
                QuestionOption("d", "The `salary` from 1 row AFTER the current row")
            ),
            correctOptionId = "c",
            explanation = "LAG(expr, offset, default) accesses a column value from a preceding row within the window partition."
        ),
        QuizQuestion(
            id = "sql_a_23",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `LEAD(salary, 1) OVER (ORDER BY hire_date)` return for the very last row in the partition?",
            options = listOf(
                QuestionOption("a", "The last row's own salary"),
                QuestionOption("b", "NULL (since no default value was specified and there is no next row)"),
                QuestionOption("c", "0"),
                QuestionOption("d", "The first row's salary (wrapping around)")
            ),
            correctOptionId = "b",
            explanation = "LEAD accesses a subsequent row; when no row exists at the offset and no default argument is given, it returns NULL."
        ),
        QuizQuestion(
            id = "sql_a_24",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, how do you compute a running total of `amount` ordered by `txn_date` using a window function?",
            options = listOf(
                QuestionOption("a", "SUM(amount) OVER (ORDER BY txn_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)"),
                QuestionOption("b", "SUM(amount) GROUP BY txn_date"),
                QuestionOption("c", "COUNT(amount) OVER (PARTITION BY txn_date)"),
                QuestionOption("d", "RUNNING_TOTAL(amount, txn_date)")
            ),
            correctOptionId = "a",
            explanation = "An ordered window frame from UNBOUNDED PRECEDING to CURRENT ROW accumulates the running sum row by row."
        ),
        QuizQuestion(
            id = "sql_a_25",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is a Common Table Expression (CTE) introduced by the `WITH` keyword?",
            options = listOf(
                QuestionOption("a", "A permanent table stored in the system catalog"),
                QuestionOption("b", "A database trigger that runs before SELECT"),
                QuestionOption("c", "A replacement for the WHERE clause"),
                QuestionOption("d", "A named temporary result set scoped to a single statement (SELECT, INSERT, UPDATE, or DELETE)")
            ),
            correctOptionId = "d",
            explanation = "A CTE (`WITH cte_name AS (SELECT ...)`) improves readability and modularity and can be referenced multiple times in the main query."
        ),
        QuizQuestion(
            id = "sql_a_26",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a LEFT JOIN `FROM orders o LEFT JOIN refunds r ON o.id = r.order_id`, what is the difference between putting `r.status = 'approved'` in the `ON` clause versus the `WHERE` clause?",
            options = listOf(
                QuestionOption("a", "Putting it in `ON` is a syntax error"),
                QuestionOption("b", "Putting it in `WHERE` duplicates unmatched rows"),
                QuestionOption("c", "In `WHERE`, unmatched orders (where `r.status` is NULL) are filtered out, effectively turning the LEFT JOIN into an INNER JOIN; in `ON`, all orders are kept"),
                QuestionOption("d", "There is no difference; both return the exact same rows")
            ),
            correctOptionId = "c",
            explanation = "Predicates in ON are evaluated during the join before outer rows are padded with NULLs, whereas WHERE filters the joined result and eliminates NULL-padded rows."
        ),
        QuizQuestion(
            id = "sql_a_27",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you find all customers who have NEVER placed an order using a `LEFT JOIN` between `customers c` and `orders o`?",
            options = listOf(
                QuestionOption("a", "SELECT c.* FROM customers c CROSS JOIN orders o;"),
                QuestionOption("b", "SELECT c.* FROM customers c LEFT JOIN orders o ON c.id = o.customer_id WHERE o.id IS NULL;"),
                QuestionOption("c", "SELECT c.* FROM customers c INNER JOIN orders o ON c.id = o.customer_id WHERE o.id IS NULL;"),
                QuestionOption("d", "SELECT c.* FROM customers c LEFT JOIN orders o ON c.id = o.customer_id WHERE o.id = NULL;")
            ),
            correctOptionId = "b",
            explanation = "A LEFT JOIN followed by `WHERE right_table.pk IS NULL` (an anti-join pattern) isolates left-table rows with no match on the right."
        ),
        QuizQuestion(
            id = "sql_a_28",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the SQL set operator `INTERSECT` return?",
            options = listOf(
                QuestionOption("a", "Only distinct rows that appear in BOTH the first query's result and the second query's result"),
                QuestionOption("b", "All rows from both queries including duplicates"),
                QuestionOption("c", "Rows from the first query that do not appear in the second query"),
                QuestionOption("d", "Rows that appear in either query but not both")
            ),
            correctOptionId = "a",
            explanation = "INTERSECT returns the set intersection (common distinct rows) of two query results."
        ),
        QuizQuestion(
            id = "sql_a_29",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the ANSI SQL set operator `EXCEPT` (called `MINUS` in Oracle) return?",
            options = listOf(
                QuestionOption("a", "Rows that appear in both queries"),
                QuestionOption("b", "All rows except NULL rows"),
                QuestionOption("c", "The symmetric difference of both queries"),
                QuestionOption("d", "Distinct rows from the first (left) query that do NOT appear in the second (right) query")
            ),
            correctOptionId = "d",
            explanation = "EXCEPT performs set subtraction: rows in query A minus rows present in query B."
        ),
        QuizQuestion(
            id = "sql_a_30",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you calculate the conversion rate or conditional count of paid orders in a single pass over the `orders` table?",
            options = listOf(
                QuestionOption("a", "SUM(status = 'paid') in all ANSI databases"),
                QuestionOption("b", "HAVING status = 'paid'"),
                QuestionOption("c", "SUM(CASE WHEN status = 'paid' THEN 1 ELSE 0 END) (or COUNT(*) FILTER (WHERE status = 'paid'))"),
                QuestionOption("d", "COUNT(WHERE status = 'paid')")
            ),
            correctOptionId = "c",
            explanation = "Conditional aggregation using `SUM(CASE WHEN ... THEN 1 ELSE 0 END)` or `COUNT(CASE WHEN ... THEN 1 END)` computes multiple filtered metrics in one table scan."
        ),
        QuizQuestion(
            id = "sql_a_31",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `COUNT(CASE WHEN score >= 50 THEN 1 END)` return when there are 10 rows total and 4 rows have `score >= 50`?",
            options = listOf(
                QuestionOption("a", "NULL"),
                QuestionOption("b", "4 (because the omitted `ELSE` defaults to `NULL`, and `COUNT(expr)` ignores `NULL`s)"),
                QuestionOption("c", "10"),
                QuestionOption("d", "6")
            ),
            correctOptionId = "b",
            explanation = "Without ELSE, unmatched rows produce NULL; COUNT(expr) counts only non-null evaluations, returning 4."
        ),
        QuizQuestion(
            id = "sql_a_32",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why would `COUNT(CASE WHEN score >= 50 THEN 1 ELSE 0 END)` be a bug if you wanted to count only passing scores?",
            options = listOf(
                QuestionOption("a", "Because `COUNT(0)` still counts the `0` as a non-NULL value, so it would count every row!"),
                QuestionOption("b", "Because `COUNT` cannot wrap a `CASE` expression"),
                QuestionOption("c", "Because `0` is treated as `NULL` in SQL"),
                QuestionOption("d", "It is not a bug; `COUNT` ignores `0`")
            ),
            correctOptionId = "a",
            explanation = "COUNT(expr) counts any non-NULL value, including 0 and FALSE. Use SUM(... ELSE 0 END) or COUNT(... ELSE NULL END)."
        ),
        QuizQuestion(
            id = "sql_a_33",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is a correlated subquery?",
            options = listOf(
                QuestionOption("a", "Two independent queries joined with `UNION`"),
                QuestionOption("b", "A subquery in the `FROM` clause with no outer references"),
                QuestionOption("c", "A view that joins two tables"),
                QuestionOption("d", "A subquery that references one or more columns from the outer query and is logically evaluated per outer row")
            ),
            correctOptionId = "d",
            explanation = "A correlated subquery depends on values from the outer query (e.g., `WHERE sal > (SELECT AVG(sal) FROM emp e2 WHERE e2.dept = e1.dept)`)."
        ),
        QuizQuestion(
            id = "sql_a_34",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When a subquery is placed inside the `FROM` clause (e.g., `SELECT * FROM (SELECT dept, AVG(sal) AS avg_s FROM emp GROUP BY dept) AS t`), what is it called?",
            options = listOf(
                QuestionOption("a", "A correlated trigger"),
                QuestionOption("b", "A materialized index"),
                QuestionOption("c", "A derived table (or inline view)"),
                QuestionOption("d", "A scalar subquery")
            ),
            correctOptionId = "c",
            explanation = "A subquery in the FROM clause acts as a derived table and typically requires a table alias in standard SQL."
        ),
        QuizQuestion(
            id = "sql_a_35",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a table with `FOREIGN KEY (dept_id) REFERENCES departments(id) ON DELETE CASCADE`, what happens when a row in `departments` is deleted?",
            options = listOf(
                QuestionOption("a", "The child table schema is dropped"),
                QuestionOption("b", "All child rows referencing that `dept_id` are automatically deleted as well"),
                QuestionOption("c", "The delete on `departments` is blocked with an error"),
                QuestionOption("d", "Child rows have their `dept_id` set to `NULL`")
            ),
            correctOptionId = "b",
            explanation = "ON DELETE CASCADE propagates deletions from the parent row to all dependent child rows."
        ),
        QuizQuestion(
            id = "sql_a_36",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a table with `FOREIGN KEY (dept_id) REFERENCES departments(id) ON DELETE SET NULL`, what happens when a referenced parent department row is deleted?",
            options = listOf(
                QuestionOption("a", "The `dept_id` column in matching child rows is automatically updated to `NULL`"),
                QuestionOption("b", "Matching child rows are deleted"),
                QuestionOption("c", "The parent row cannot be deleted"),
                QuestionOption("d", "The child table's primary key becomes `NULL`")
            ),
            correctOptionId = "a",
            explanation = "ON DELETE SET NULL keeps the child rows intact and sets their foreign key reference to NULL (provided the column is nullable)."
        ),
        QuizQuestion(
            id = "sql_a_37",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the default `ON DELETE` behavior of a `FOREIGN KEY` constraint when no `ON DELETE` action is specified?",
            options = listOf(
                QuestionOption("a", "CASCADE"),
                QuestionOption("b", "SET NULL"),
                QuestionOption("c", "SET DEFAULT"),
                QuestionOption("d", "RESTRICT / NO ACTION (prevents deleting a parent row if child rows still reference it)")
            ),
            correctOptionId = "d",
            explanation = "By default, relational databases enforce RESTRICT / NO ACTION, rejecting parent deletions that would leave orphan child rows."
        ),
        QuizQuestion(
            id = "sql_a_38",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is a First Normal Form (1NF) violation in relational schema design?",
            options = listOf(
                QuestionOption("a", "Having a foreign key to another table"),
                QuestionOption("b", "Having more than 5 columns in a table"),
                QuestionOption("c", "Storing a comma-separated list of multiple phone numbers inside a single `phone_numbers` column"),
                QuestionOption("d", "Having a composite primary key")
            ),
            correctOptionId = "c",
            explanation = "1NF requires atomic (indivisible) column values and no repeating groups within a single row/column."
        ),
        QuizQuestion(
            id = "sql_a_39",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does Second Normal Form (2NF) require on top of 1NF?",
            options = listOf(
                QuestionOption("a", "All text columns must be stored in uppercase"),
                QuestionOption("b", "Every non-key attribute must be fully functionally dependent on the ENTIRE candidate key (no partial dependencies on part of a composite key)"),
                QuestionOption("c", "No foreign keys may exist in the table"),
                QuestionOption("d", "Every table must have at least two primary keys")
            ),
            correctOptionId = "b",
            explanation = "2NF eliminates partial dependencies where a non-key column depends on only one column of a composite primary key."
        ),
        QuizQuestion(
            id = "sql_a_40",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does Third Normal Form (3NF) eliminate on top of 2NF?",
            options = listOf(
                QuestionOption("a", "Transitive dependencies (where a non-key attribute depends on another non-key attribute rather than directly on the key)"),
                QuestionOption("b", "All composite keys"),
                QuestionOption("c", "All numeric columns"),
                QuestionOption("d", "All NULL values")
            ),
            correctOptionId = "a",
            explanation = "3NF ensures non-key attributes depend only on the key ('the key, the whole key, and nothing but the key')."
        ),
        QuizQuestion(
            id = "sql_a_41",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In database design, how is a many-to-many (M:N) relationship between `students` and `courses` properly modeled?",
            options = listOf(
                QuestionOption("a", "Adding `course_1, course_2, course_3` columns to `students`"),
                QuestionOption("b", "Putting a `student_ids` array column inside `courses`"),
                QuestionOption("c", "Making `student_id` the primary key of `courses`"),
                QuestionOption("d", "Using a junction (associative / bridge) table `enrollments(student_id, course_id)` with foreign keys to both tables")
            ),
            correctOptionId = "d",
            explanation = "A junction table decomposes a many-to-many relationship into two one-to-many relationships."
        ),
        QuizQuestion(
            id = "sql_a_42",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you find the second highest distinct salary from an `employees(salary)` table using standard `LIMIT` and `OFFSET`?",
            options = listOf(
                QuestionOption("a", "SELECT MAX(salary) FROM employees OFFSET 1;"),
                QuestionOption("b", "SELECT TOP 2 salary FROM employees;"),
                QuestionOption("c", "SELECT DISTINCT salary FROM employees ORDER BY salary DESC LIMIT 1 OFFSET 1;"),
                QuestionOption("d", "SELECT salary FROM employees ORDER BY salary DESC LIMIT 2;")
            ),
            correctOptionId = "c",
            explanation = "DISTINCT deduplicates tied top salaries, ORDER BY DESC sorts highest first, OFFSET 1 skips the highest, and LIMIT 1 returns the second highest."
        ),
        QuizQuestion(
            id = "sql_a_43",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can you also find the second highest salary using pure ANSI aggregate functions without `LIMIT` or window functions?",
            options = listOf(
                QuestionOption("a", "SELECT MAX(salary) - 1 FROM employees;"),
                QuestionOption("b", "SELECT MAX(salary) FROM employees WHERE salary < (SELECT MAX(salary) FROM employees);"),
                QuestionOption("c", "SELECT AVG(salary) FROM employees;"),
                QuestionOption("d", "SELECT MIN(salary) FROM employees WHERE salary > 0;")
            ),
            correctOptionId = "b",
            explanation = "The maximum salary strictly less than the overall maximum salary is the second highest distinct salary."
        ),
        QuizQuestion(
            id = "sql_a_44",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you find duplicate email addresses in a `users(id, email)` table?",
            options = listOf(
                QuestionOption("a", "SELECT email, COUNT(*) FROM users GROUP BY email HAVING COUNT(*) > 1;"),
                QuestionOption("b", "SELECT DISTINCT email FROM users WHERE COUNT(*) > 1;"),
                QuestionOption("c", "SELECT email FROM users HAVING email > 1;"),
                QuestionOption("d", "SELECT email FROM users GROUP BY id WHERE COUNT(email) > 1;")
            ),
            correctOptionId = "a",
            explanation = "Grouping by email and filtering with HAVING COUNT(*) > 1 returns all email values that occur in multiple rows."
        ),
        QuizQuestion(
            id = "sql_a_45",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `NULLS LAST` in `ORDER BY completed_at DESC NULLS LAST` accomplish?",
            options = listOf(
                QuestionOption("a", "Deletes rows where `completed_at` is NULL"),
                QuestionOption("b", "Replaces NULL with the current timestamp"),
                QuestionOption("c", "Throws an error if any NULL exists"),
                QuestionOption("d", "Places rows where `completed_at` is NULL at the end of the result set after all non-null timestamps")
            ),
            correctOptionId = "d",
            explanation = "NULLS FIRST / NULLS LAST explicitly controls whether NULL values sort before or after non-null values."
        ),
        QuizQuestion(
            id = "sql_a_46",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, how can you safely prevent division-by-zero errors when computing `revenue / units_sold`?",
            options = listOf(
                QuestionOption("a", "revenue / ABS(units_sold)"),
                QuestionOption("b", "IF_ZERO(revenue / units_sold)"),
                QuestionOption("c", "revenue / NULLIF(units_sold, 0)"),
                QuestionOption("d", "revenue / COALESCE(units_sold, 0)")
            ),
            correctOptionId = "c",
            explanation = "NULLIF(units_sold, 0) turns 0 into NULL, and dividing by NULL safely yields NULL instead of a division-by-zero error."
        ),
        QuizQuestion(
            id = "sql_a_47",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `employees(id, name, manager_id)`, what does `SELECT e.name, m.name AS manager FROM employees e LEFT JOIN employees m ON e.manager_id = m.id;` do for the CEO (whose `manager_id` is NULL)?",
            options = listOf(
                QuestionOption("a", "Fails with a circular reference error"),
                QuestionOption("b", "Includes the CEO row with `manager` as `NULL` (whereas an INNER JOIN would exclude the CEO)"),
                QuestionOption("c", "Excludes the CEO row"),
                QuestionOption("d", "Sets the CEO's manager to their own name")
            ),
            correctOptionId = "b",
            explanation = "Using LEFT JOIN in an employee-manager self-join preserves top-level employees whose manager_id is NULL."
        ),
        QuizQuestion(
            id = "sql_a_48",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a composite B-tree index on `(last_name, first_name)`, which query predicate can most effectively use the index's leftmost prefix?",
            options = listOf(
                QuestionOption("a", "WHERE last_name = 'Sharma' AND first_name = 'Asha' (or WHERE last_name = 'Sharma')"),
                QuestionOption("b", "WHERE first_name = 'Asha' (without filtering on `last_name`)"),
                QuestionOption("c", "WHERE LOWER(first_name) = 'asha'"),
                QuestionOption("d", "WHERE first_name LIKE '%sha'")
            ),
            correctOptionId = "a",
            explanation = "A B-tree index on (last_name, first_name) is sorted by last_name first, then first_name; queries filtering on the leading column(s) use the index efficiently."
        ),
        QuizQuestion(
            id = "sql_a_49",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does a predicate like `WHERE YEAR(order_date) = 2025` often prevent a standard B-tree index on `order_date` from being used?",
            options = listOf(
                QuestionOption("a", "B-tree indexes cannot store `DATE` columns"),
                QuestionOption("b", "`YEAR()` returns a string instead of a number"),
                QuestionOption("c", "Indexes are only used in `ORDER BY`, never in `WHERE`"),
                QuestionOption("d", "Applying a function to the indexed column makes the predicate non-sargable; `order_date >= '2025-01-01' AND order_date < '2026-01-01'` should be used instead")
            ),
            correctOptionId = "d",
            explanation = "Wrapping an indexed column in a function hides the raw column order from a standard B-tree index unless a functional/expression index exists; range predicates are sargable."
        ),
        QuizQuestion(
            id = "sql_a_50",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why does `WHERE name LIKE '%kumar'` (with a leading `%` wildcard) prevent a standard B-tree index range scan on `name`?",
            options = listOf(
                QuestionOption("a", "Because `%` is only valid in `HAVING`"),
                QuestionOption("b", "Because B-tree indexes only work on integers"),
                QuestionOption("c", "Because the prefix of the string is unknown, so the B-tree sort order cannot narrow down a starting range"),
                QuestionOption("d", "Because `LIKE` never uses indexes under any circumstances")
            ),
            correctOptionId = "c",
            explanation = "A trailing wildcard (`'kumar%'`) is a prefix range scan in a B-tree, whereas a leading wildcard (`'%kumar'`) requires scanning entries or using a trigram/full-text index."
        ),
        QuizQuestion(
            id = "sql_a_51",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is a covering index for a query?",
            options = listOf(
                QuestionOption("a", "An index that encrypts table backups"),
                QuestionOption("b", "An index that contains all columns requested by the query's `SELECT`, `WHERE`, and `JOIN` clauses, enabling an index-only scan without fetching table heap pages"),
                QuestionOption("c", "An index created on every single table in the database"),
                QuestionOption("d", "A primary key constraint that spans more than 10 columns")
            ),
            correctOptionId = "b",
            explanation = "When an index covers all columns needed by a query, the database engine can answer the query directly from the index (Index-Only Scan)."
        ),
        QuizQuestion(
            id = "sql_a_52",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what does `GROUP BY dept_id, role` do?",
            options = listOf(
                QuestionOption("a", "Forms one aggregate group for each unique `(dept_id, role)` pair"),
                QuestionOption("b", "Forms two separate result sets: one grouped by `dept_id` and another by `role`"),
                QuestionOption("c", "Groups by `dept_id` and sorts by `role` without grouping by `role`"),
                QuestionOption("d", "Throws an error because `GROUP BY` only accepts one column")
            ),
            correctOptionId = "a",
            explanation = "GROUP BY with multiple columns groups rows that share identical values across all specified grouping columns."
        ),
        QuizQuestion(
            id = "sql_a_53",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given table `t(val INT)` with rows `10, 20, 20, 30`, what is the difference between `SELECT SUM(val) FROM t;` and `SELECT SUM(DISTINCT val) FROM t;`?",
            options = listOf(
                QuestionOption("a", "Both return `80`"),
                QuestionOption("b", "`SUM(DISTINCT val)` is a syntax error"),
                QuestionOption("c", "`SUM(DISTINCT val)` returns `3`"),
                QuestionOption("d", "`SUM(val)` returns `80`, while `SUM(DISTINCT val)` deduplicates the two `20`s and returns `60`")
            ),
            correctOptionId = "d",
            explanation = "Aggregate functions like SUM, COUNT, and AVG support DISTINCT inside the parentheses to aggregate only unique non-null values."
        ),
        QuizQuestion(
            id = "sql_a_54",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `sales(region, amount)` where `region` has 3 distinct non-null values and 2 rows have `region IS NULL`, how many rows does `SELECT region, SUM(amount) FROM sales GROUP BY region;` return?",
            options = listOf(
                QuestionOption("a", "5 rows (each NULL forms its own separate group)"),
                QuestionOption("b", "0 rows"),
                QuestionOption("c", "4 rows (3 for the non-null regions plus 1 group for all NULL regions)"),
                QuestionOption("d", "3 rows (GROUP BY discards NULL rows)")
            ),
            correctOptionId = "c",
            explanation = "Unlike `WHERE a = b`, `GROUP BY` treats all `NULL` values in the grouping column as belonging to a single group!"
        ),
        QuizQuestion(
            id = "sql_a_55",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, why do `GROUP BY` and `DISTINCT` treat two `NULL` values as equal (putting them in the same group), whereas `WHERE x = y` treats `NULL = NULL` as `UNKNOWN`?",
            options = listOf(
                QuestionOption("a", "They do not; `GROUP BY` drops all `NULL` rows"),
                QuestionOption("b", "SQL distinguishes between equality comparisons in predicates (`UNKNOWN`) and grouping/distinctness equivalence (`IS NOT DISTINCT FROM`)"),
                QuestionOption("c", "Because `GROUP BY` converts `NULL` to `0`"),
                QuestionOption("d", "Because `DISTINCT` deletes `NULL` rows")
            ),
            correctOptionId = "b",
            explanation = "By SQL specification, grouping and DISTINCT use distinctness semantics where two NULLs are not distinct from each other."
        ),
        QuizQuestion(
            id = "sql_a_56",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does the standard ANSI SQL predicate `a IS NOT DISTINCT FROM b` (or `a <=> b` in MySQL) evaluate to when both `a` and `b` are `NULL`?",
            options = listOf(
                QuestionOption("a", "TRUE (it performs a NULL-safe equality comparison)"),
                QuestionOption("b", "UNKNOWN"),
                QuestionOption("c", "FALSE"),
                QuestionOption("d", "NULL")
            ),
            correctOptionId = "a",
            explanation = "`IS NOT DISTINCT FROM` returns TRUE when both operands are equal OR when both operands are NULL, always returning TRUE or FALSE (never UNKNOWN)."
        ),
        QuizQuestion(
            id = "sql_a_57",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens if a scalar subquery `WHERE salary = (SELECT salary FROM employees WHERE dept = 'Sales')` returns MORE than one row at runtime?",
            options = listOf(
                QuestionOption("a", "It automatically picks the first row"),
                QuestionOption("b", "It automatically converts `=` into `IN`"),
                QuestionOption("c", "It returns 0 rows silently"),
                QuestionOption("d", "The database raises a runtime error ('more than one row returned by a subquery used as an expression')")
            ),
            correctOptionId = "d",
            explanation = "A scalar subquery with `=` requires at most 1 row; if multiple rows can be returned, `IN`, `ANY`, or `ALL` must be used."
        ),
        QuizQuestion(
            id = "sql_a_58",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what does `WHERE salary > ALL (SELECT salary FROM employees WHERE dept_id = 10)` mean?",
            options = listOf(
                QuestionOption("a", "`salary` is equal to the sum of salaries in department 10"),
                QuestionOption("b", "`salary` is greater than the average salary"),
                QuestionOption("c", "`salary` is strictly greater than the maximum salary in department 10 (and TRUE if department 10 has 0 employees)"),
                QuestionOption("d", "`salary` is greater than the minimum salary in department 10")
            ),
            correctOptionId = "c",
            explanation = "`> ALL (subquery)` requires the value to exceed every value returned by the subquery."
        )
    )

    private fun appliedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "sql_a_59",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what does `WHERE salary > ANY (SELECT salary FROM employees WHERE dept_id = 10)` (or `> SOME`) mean?",
            options = listOf(
                QuestionOption("a", "It selects a random employee"),
                QuestionOption("b", "`salary` is strictly greater than at least one salary (i.e., greater than the minimum salary) in department 10"),
                QuestionOption("c", "`salary` is greater than every salary in department 10"),
                QuestionOption("d", "`salary` can be any value including NULL")
            ),
            correctOptionId = "b",
            explanation = "`> ANY (subquery)` succeeds if the value is greater than at least one row returned by the subquery."
        ),
        QuizQuestion(
            id = "sql_a_60",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between `DELETE FROM t;` and `TRUNCATE TABLE t;` in most relational DBMSs?",
            options = listOf(
                QuestionOption("a", "`DELETE` scans and logs row-by-row deletions and fires row-level `DELETE` triggers, whereas `TRUNCATE` deallocates pages in bulk with minimal logging"),
                QuestionOption("b", "`TRUNCATE` drops the table schema whereas `DELETE` keeps it"),
                QuestionOption("c", "`DELETE` cannot be rolled back inside a transaction"),
                QuestionOption("d", "`TRUNCATE` supports a `WHERE` clause")
            ),
            correctOptionId = "a",
            explanation = "TRUNCATE is a bulk operation that does not accept a WHERE clause and skips row-by-row DELETE triggers."
        ),
        QuizQuestion(
            id = "sql_a_61",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a transaction using `SAVEPOINT sp1;`, what does `ROLLBACK TO SAVEPOINT sp1;` do?",
            options = listOf(
                QuestionOption("a", "Commits everything before `sp1` and ends the transaction"),
                QuestionOption("b", "Aborts the entire transaction from the very beginning"),
                QuestionOption("c", "Deletes the database table"),
                QuestionOption("d", "Undoes changes made AFTER `sp1` was created while keeping earlier changes in the transaction active")
            ),
            correctOptionId = "d",
            explanation = "Savepoints allow partial rollbacks within an open transaction without aborting work done prior to the savepoint."
        ),
        QuizQuestion(
            id = "sql_a_62",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, how do you insert the results of a `SELECT` query into an existing table `archived_orders(id, total)`?",
            options = listOf(
                QuestionOption("a", "COPY orders TO archived_orders WHERE year < 2023;"),
                QuestionOption("b", "UPDATE archived_orders FROM SELECT id, total FROM orders;"),
                QuestionOption("c", "INSERT INTO archived_orders (id, total) SELECT id, total FROM orders WHERE year < 2023;"),
                QuestionOption("d", "INSERT INTO archived_orders VALUES (SELECT id, total FROM orders);")
            ),
            correctOptionId = "c",
            explanation = "`INSERT INTO target (cols) SELECT ...` inserts all rows returned by the query into the target table."
        ),
        QuizQuestion(
            id = "sql_a_63",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does an `UPSERT` (`INSERT ... ON CONFLICT (id) DO UPDATE SET ...` in PostgreSQL/SQLite) do?",
            options = listOf(
                QuestionOption("a", "Always inserts a duplicate row by incrementing `id`"),
                QuestionOption("b", "Inserts a new row, or updates the existing row if a uniqueness/primary key conflict occurs on `id`"),
                QuestionOption("c", "Deletes the conflicting row and aborts the transaction"),
                QuestionOption("d", "Drops the unique constraint on `id`")
            ),
            correctOptionId = "b",
            explanation = "UPSERT atomically handles insert-or-update when a unique key constraint would be violated."
        ),
        QuizQuestion(
            id = "sql_a_64",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL window functions, what does `FIRST_VALUE(name) OVER (PARTITION BY dept ORDER BY salary DESC)` return?",
            options = listOf(
                QuestionOption("a", "The `name` of the highest-paid employee in each `dept` partition"),
                QuestionOption("b", "The alphabetical first `name` in the entire table"),
                QuestionOption("c", "A boolean indicating whether the row is first"),
                QuestionOption("d", "The sum of salaries in `dept`")
            ),
            correctOptionId = "a",
            explanation = "FIRST_VALUE evaluates the expression for the first row of the window frame (here, the highest salary in the department)."
        ),
        QuizQuestion(
            id = "sql_a_65",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL window functions, why does `LAST_VALUE(name) OVER (PARTITION BY dept ORDER BY salary DESC)` often surprise developers by returning the current row's own `name`?",
            options = listOf(
                QuestionOption("a", "Because `LAST_VALUE` is an alias for `FIRST_VALUE`"),
                QuestionOption("b", "Because `LAST_VALUE` ignores `PARTITION BY`"),
                QuestionOption("c", "Because `ORDER BY DESC` reverses `LAST_VALUE`"),
                QuestionOption("d", "Because the default window frame when `ORDER BY` is present is `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`, so the 'last' row of the default frame is the current row!")
            ),
            correctOptionId = "d",
            explanation = "To get the last value of the entire partition with LAST_VALUE, you must specify `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING`."
        ),
        QuizQuestion(
            id = "sql_a_66",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `NTILE(4) OVER (ORDER BY score DESC)` do in SQL?",
            options = listOf(
                QuestionOption("a", "Multiplies `score` by 4"),
                QuestionOption("b", "Returns every 4th row"),
                QuestionOption("c", "Divides the ordered partition into 4 approximately equal buckets (quartiles) numbered 1, 2, 3, and 4"),
                QuestionOption("d", "Returns only the top 4 rows")
            ),
            correctOptionId = "c",
            explanation = "NTILE(n) assigns each row a bucket number from 1 to n, distributing rows as evenly as possible."
        ),
        QuizQuestion(
            id = "sql_a_67",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between a standard `VIEW` and a `MATERIALIZED VIEW` (supported in PostgreSQL/Oracle)?",
            options = listOf(
                QuestionOption("a", "A standard `VIEW` can have indexes created directly on it in all databases"),
                QuestionOption("b", "A `MATERIALIZED VIEW` physically stores the cached query results on disk and can be refreshed, whereas a standard `VIEW` re-runs the underlying query on every read"),
                QuestionOption("c", "A standard `VIEW` stores data on disk whereas a `MATERIALIZED VIEW` does not"),
                QuestionOption("d", "A `MATERIALIZED VIEW` cannot be queried with `SELECT`")
            ),
            correctOptionId = "b",
            explanation = "Materialized views precompute and persist query results for fast analytical reads, requiring `REFRESH MATERIALIZED VIEW` to update."
        ),
        QuizQuestion(
            id = "sql_a_68",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is a `NATURAL JOIN` and why is it generally discouraged in production code?",
            options = listOf(
                QuestionOption("a", "It automatically joins on ALL columns with matching names between both tables; adding a new column like `updated_at` to a table can silently break or alter the join!"),
                QuestionOption("b", "It joins on primary keys only"),
                QuestionOption("c", "It is faster than `INNER JOIN` because it skips all conditions"),
                QuestionOption("d", "It only works on tables with no indexes")
            ),
            correctOptionId = "a",
            explanation = "NATURAL JOIN implicitly matches all identically named columns, making queries fragile whenever table schemas evolve."
        ),
        QuizQuestion(
            id = "sql_a_69",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Suppose `TableA` has rows `(1), (1)` and `TableB` has rows `(1), (1), (1)`. How many rows does `SELECT * FROM TableA INNER JOIN TableB ON TableA.x = TableB.x;` return?",
            options = listOf(
                QuestionOption("a", "2 rows"),
                QuestionOption("b", "3 rows"),
                QuestionOption("c", "5 rows"),
                QuestionOption("d", "6 rows (2 matching rows in A multiplied by 3 matching rows in B)")
            ),
            correctOptionId = "d",
            explanation = "When duplicate join keys exist on both sides, an inner join produces the Cartesian product of the matching key groups: 2 * 3 = 6 rows."
        ),
        QuizQuestion(
            id = "sql_a_70",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Suppose `TableA` has rows `(1), (2), (NULL)` and `TableB` has rows `(1), (3), (NULL)`. How many rows does `SELECT * FROM TableA INNER JOIN TableB ON TableA.x = TableB.x;` return?",
            options = listOf(
                QuestionOption("a", "3 rows"),
                QuestionOption("b", "0 rows"),
                QuestionOption("c", "1 row (only `1 = 1` matches; `NULL = NULL` is UNKNOWN and does NOT match in an `ON` equality condition)"),
                QuestionOption("d", "2 rows")
            ),
            correctOptionId = "c",
            explanation = "Join predicates `a.x = b.x` do not match NULL with NULL unless `IS NOT DISTINCT FROM` is used."
        ),
        QuizQuestion(
            id = "sql_a_71",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Using the same `TableA(1, 2, NULL)` and `TableB(1, 3, NULL)`, how many rows does `SELECT * FROM TableA LEFT JOIN TableB ON TableA.x = TableB.x;` return?",
            options = listOf(
                QuestionOption("a", "6 rows"),
                QuestionOption("b", "3 rows (`1` matched with `1`, plus unmatched `2` and `NULL` from `TableA` padded with NULLs)"),
                QuestionOption("c", "1 row"),
                QuestionOption("d", "2 rows")
            ),
            correctOptionId = "b",
            explanation = "LEFT JOIN preserves all 3 rows from TableA; `1` matches `1`, while `2` and `NULL` have no match and are padded with NULL on the right."
        ),
        QuizQuestion(
            id = "sql_a_72",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Using `TableA(1, 2)` and `TableB(2, 3)`, how many rows does `SELECT * FROM TableA FULL OUTER JOIN TableB ON TableA.x = TableB.x;` return?",
            options = listOf(
                QuestionOption("a", "3 rows: `(1, NULL)`, `(2, 2)`, and `(NULL, 3)`"),
                QuestionOption("b", "4 rows"),
                QuestionOption("c", "2 rows"),
                QuestionOption("d", "1 row")
            ),
            correctOptionId = "a",
            explanation = "FULL OUTER JOIN returns matched rows plus unmatched rows from both the left and right tables."
        ),
        QuizQuestion(
            id = "sql_a_73",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How many rows does `SELECT COUNT(*), COUNT(val) FROM (SELECT NULL AS val) t;` return, and what are the values?",
            options = listOf(
                QuestionOption("a", "0 rows"),
                QuestionOption("b", "1 row with values `0` and `0`"),
                QuestionOption("c", "1 row with values `1` and `1`"),
                QuestionOption("d", "1 row with values `1` and `0`")
            ),
            correctOptionId = "d",
            explanation = "An aggregate query without GROUP BY always returns 1 row; COUNT(*) counts the 1 row, and COUNT(val) ignores NULL to return 0."
        ),
        QuizQuestion(
            id = "sql_a_74",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `SELECT SUM(val) FROM empty_table;` return when `empty_table` has 0 rows?",
            options = listOf(
                QuestionOption("a", "0 rows"),
                QuestionOption("b", "An exception"),
                QuestionOption("c", "1 row containing `NULL` (whereas `COUNT(*)` returns `0`)"),
                QuestionOption("d", "1 row containing `0`")
            ),
            correctOptionId = "c",
            explanation = "In SQL, `SUM`, `AVG`, `MIN`, and `MAX` over an empty set return `NULL` (use `COALESCE(SUM(val), 0)` if `0` is needed)."
        ),
        QuizQuestion(
            id = "sql_a_75",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why can joining a customer to BOTH `orders` and `support_tickets` in a single query (`FROM customers c LEFT JOIN orders o ... LEFT JOIN tickets t ...`) produce inflated `SUM(o.amount)` totals?",
            options = listOf(
                QuestionOption("a", "It does not; `SUM` automatically deduplicates joined rows"),
                QuestionOption("b", "Because a customer with 3 orders and 4 tickets produces 3 * 4 = 12 rows (a fan-out / chasm trap), multiplying each order amount by 4!"),
                QuestionOption("c", "Because `SUM` cannot be used with `LEFT JOIN`"),
                QuestionOption("d", "Because `LEFT JOIN` converts amounts to floats")
            ),
            correctOptionId = "b",
            explanation = "Joining two independent one-to-many relationships creates a Cartesian fan-out per parent key; aggregate each child table in a CTE/subquery before joining."
        ),
        QuizQuestion(
            id = "sql_a_76",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you fix the fan-out problem when computing both `total_order_amount` and `ticket_count` per customer?",
            options = listOf(
                QuestionOption("a", "Aggregate `orders` by `customer_id` and `tickets` by `customer_id` in separate CTEs or subqueries first, then `LEFT JOIN` those 1-row-per-customer summaries to `customers`"),
                QuestionOption("b", "Use `FULL OUTER JOIN` instead of `LEFT JOIN`"),
                QuestionOption("c", "Add `ORDER BY c.id` at the end"),
                QuestionOption("d", "Use `SUM(DISTINCT o.amount)` (which is wrong if two distinct orders have the same dollar amount)")
            ),
            correctOptionId = "a",
            explanation = "Pre-aggregating each 1:N child table to the parent grain before joining guarantees 1 row per customer and exact sums."
        ),
        QuizQuestion(
            id = "sql_a_77",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what does `EXISTS (SELECT 1 FROM orders o WHERE o.customer_id = c.id)` evaluate?",
            options = listOf(
                QuestionOption("a", "Returns the integer `1`"),
                QuestionOption("b", "Counts all matching rows before returning"),
                QuestionOption("c", "Returns `FALSE` if the subquery selects `NULL`"),
                QuestionOption("d", "Returns `TRUE` as soon as at least one matching row is found in `orders`, regardless of what is in the `SELECT` list of the subquery")
            ),
            correctOptionId = "d",
            explanation = "EXISTS only checks whether the subquery produces at least one row; `SELECT 1`, `SELECT *`, or even `SELECT NULL` inside EXISTS behaves identically."
        ),
        QuizQuestion(
            id = "sql_a_78",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Wait: what does `WHERE EXISTS (SELECT NULL FROM dual_or_one_row_table)` evaluate to?",
            options = listOf(
                QuestionOption("a", "UNKNOWN"),
                QuestionOption("b", "A syntax error"),
                QuestionOption("c", "TRUE! Because `EXISTS` checks whether a row is returned, NOT whether the selected column value is non-null"),
                QuestionOption("d", "FALSE")
            ),
            correctOptionId = "c",
            explanation = "EXISTS tests row existence, not column value non-nullability; a row containing NULL still exists."
        ),
        QuizQuestion(
            id = "sql_a_79",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is a `CHECK` constraint's behavior when its boolean condition evaluates to `UNKNOWN` (because a column is `NULL`)?",
            options = listOf(
                QuestionOption("a", "It converts the `NULL` to `0`"),
                QuestionOption("b", "The constraint PASSES! In SQL, `CHECK` only rejects rows where the condition evaluates to `FALSE` (whereas `WHERE` requires `TRUE`)"),
                QuestionOption("c", "The constraint FAILS and rejects the row"),
                QuestionOption("d", "The database crashes")
            ),
            correctOptionId = "b",
            explanation = "A subtle SQL rule: `WHERE` keeps rows where the predicate is `TRUE`, whereas `CHECK` allows rows where the predicate is NOT `FALSE` (so `TRUE` and `UNKNOWN` both pass!)."
        ),
        QuizQuestion(
            id = "sql_a_80",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Given `CREATE TABLE items (price INT CHECK (price > 0));`, can you insert `INSERT INTO items VALUES (NULL);`?",
            options = listOf(
                QuestionOption("a", "Yes! Because `NULL > 0` is `UNKNOWN` (not `FALSE`), and `NOT NULL` was not specified"),
                QuestionOption("b", "No; `CHECK (price > 0)` implicitly adds `NOT NULL`"),
                QuestionOption("c", "Only in SQLite"),
                QuestionOption("d", "No; `NULL` is treated as `-1`")
            ),
            correctOptionId = "a",
            explanation = "To disallow NULLs as well, you must explicitly specify `price INT NOT NULL CHECK (price > 0)`."
        ),
        QuizQuestion(
            id = "sql_a_81",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is the purpose of `GROUPING SETS`, `ROLLUP`, or `CUBE`?",
            options = listOf(
                QuestionOption("a", "To encrypt grouped columns"),
                QuestionOption("b", "To physically sort table rows on disk"),
                QuestionOption("c", "To create foreign keys automatically"),
                QuestionOption("d", "To generate multiple levels of subtotals and a grand total in a single `GROUP BY` query")
            ),
            correctOptionId = "d",
            explanation = "`GROUP BY ROLLUP(region, city)` produces aggregates for `(region, city)`, subtotals for `(region)`, and a grand total `()`."
        ),
        QuizQuestion(
            id = "sql_a_82",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When using `GROUP BY ROLLUP(dept, role)`, how can you distinguish a real `NULL` value in `role` from a `NULL` generated by `ROLLUP` for a department subtotal row?",
            options = listOf(
                QuestionOption("a", "Using `COALESCE(role, 'Subtotal')`"),
                QuestionOption("b", "It is impossible to distinguish them"),
                QuestionOption("c", "Using the `GROUPING(role)` function, which returns `1` for a super-aggregate subtotal row and `0` for a regular grouped row"),
                QuestionOption("d", "Using `role IS NULL`")
            ),
            correctOptionId = "c",
            explanation = "GROUPING(col) returns 1 when the NULL in col was produced by ROLLUP/CUBE/GROUPING SETS aggregation, and 0 otherwise."
        ),
        QuizQuestion(
            id = "sql_a_83",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In PostgreSQL and SQLite, what does the `RETURNING` clause on an `INSERT`, `UPDATE`, or `DELETE` statement do?",
            options = listOf(
                QuestionOption("a", "Returns the table schema definition"),
                QuestionOption("b", "Returns columns from the inserted, updated, or deleted rows (such as generated IDs) without needing a separate `SELECT` query"),
                QuestionOption("c", "Rolls back the statement after returning"),
                QuestionOption("d", "Loops the query in a recursive cycle")
            ),
            correctOptionId = "b",
            explanation = "`INSERT INTO users(name) VALUES ('Dev') RETURNING id;` atomically inserts the row and returns the generated primary key."
        ),
        QuizQuestion(
            id = "sql_a_84",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is an SQL Injection vulnerability?",
            options = listOf(
                QuestionOption("a", "When untrusted user input is concatenated directly into a SQL query string, allowing an attacker to alter the query's structure and execute arbitrary SQL"),
                QuestionOption("b", "When a query takes too long and times out"),
                QuestionOption("c", "When two transactions deadlock"),
                QuestionOption("d", "When a foreign key constraint fails")
            ),
            correctOptionId = "a",
            explanation = "String concatenation of user input (e.g., `\"WHERE user = '\" + input + \"'\"`) allows inputs like `' OR '1'='1` to bypass logic."
        ),
        QuizQuestion(
            id = "sql_a_85",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the primary defense against SQL Injection in application code?",
            options = listOf(
                QuestionOption("a", "Stripping spaces from user input"),
                QuestionOption("b", "Using `UPPER()` on all strings"),
                QuestionOption("c", "Running all queries inside `LEFT JOIN`"),
                QuestionOption("d", "Using parameterized queries (prepared statements with bind parameters like `?` or `:param`)")
            ),
            correctOptionId = "d",
            explanation = "Prepared statements separate the compiled SQL query structure from the parameter data, so user input is never interpreted as SQL syntax."
        ),
        QuizQuestion(
            id = "sql_a_86",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what does `SELECT EXTRACT(YEAR FROM DATE '2025-08-15');` return?",
            options = listOf(
                QuestionOption("a", "15"),
                QuestionOption("b", "'2025-08-15'"),
                QuestionOption("c", "2025"),
                QuestionOption("d", "8")
            ),
            correctOptionId = "c",
            explanation = "EXTRACT(field FROM datetime) extracts the requested date/time component such as YEAR, MONTH, or DAY."
        ),
        QuizQuestion(
            id = "sql_a_87",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the difference between `TIMESTAMP WITHOUT TIME ZONE` and `TIMESTAMP WITH TIME ZONE` (`TIMESTAMPTZ` in PostgreSQL)?",
            options = listOf(
                QuestionOption("a", "There is no difference"),
                QuestionOption("b", "`TIMESTAMPTZ` normalizes/stores instants relative to UTC and converts for display, whereas `TIMESTAMP` stores a bare calendar date/time without time-zone context"),
                QuestionOption("c", "`TIMESTAMPTZ` only stores the time zone string like `'Asia/Kolkata'` without a date"),
                QuestionOption("d", "`TIMESTAMP` is accurate to days while `TIMESTAMPTZ` is accurate to seconds")
            ),
            correctOptionId = "b",
            explanation = "For event timestamps across regions, storing UTC instants (`TIMESTAMPTZ` or UTC epoch/ISO-8601) avoids daylight-saving and time-zone ambiguities."
        ),
        QuizQuestion(
            id = "sql_a_88",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQLite, what is unusual about column data types compared to strict databases like PostgreSQL?",
            options = listOf(
                QuestionOption("a", "SQLite uses dynamic typing with type affinity (unless a table is declared `STRICT` in SQLite 3.37+)"),
                QuestionOption("b", "SQLite only supports `TEXT` columns and cannot store numbers"),
                QuestionOption("c", "SQLite requires every column to be `CHAR(255)`"),
                QuestionOption("d", "SQLite does not support `INTEGER PRIMARY KEY`")
            ),
            correctOptionId = "a",
            explanation = "Historically SQLite uses type affinity per value, though modern SQLite also supports `CREATE TABLE ... STRICT`."
        ),
        QuizQuestion(
            id = "sql_a_89",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQLite, is foreign key enforcement (`PRAGMA foreign_keys`) enabled or disabled by default on a new database connection (unless configured)?",
            options = listOf(
                QuestionOption("a", "Always enabled and impossible to disable"),
                QuestionOption("b", "Enabled only for `DELETE`, not `INSERT`"),
                QuestionOption("c", "SQLite does not parse `FOREIGN KEY` syntax"),
                QuestionOption("d", "Disabled by default for backwards compatibility; `PRAGMA foreign_keys = ON;` must be executed per connection (or via Room's `ForeignKey` config)")
            ),
            correctOptionId = "d",
            explanation = "SQLite requires `PRAGMA foreign_keys = ON;` on the connection (Room automatically enables this when `@ForeignKey` annotations are declared on `@Entity`)."
        ),
        QuizQuestion(
            id = "sql_a_90",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "When calculating a 7-day moving average of daily revenue in SQL, which window frame specification is appropriate (assuming 1 row per day)?",
            options = listOf(
                QuestionOption("a", "AVG(revenue) OVER (ORDER BY day ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)"),
                QuestionOption("b", "SUM(revenue) / 7 GROUP BY day"),
                QuestionOption("c", "AVG(revenue) OVER (ORDER BY day ROWS BETWEEN 6 PRECEDING AND CURRENT ROW)"),
                QuestionOption("d", "AVG(revenue) OVER (PARTITION BY day)")
            ),
            correctOptionId = "c",
            explanation = "6 PRECEDING plus the CURRENT ROW includes at most 7 consecutive rows ending at the current row."
        ),
        QuizQuestion(
            id = "sql_a_91",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What does `PERCENT_RANK() OVER (ORDER BY score)` compute for each row in a partition?",
            options = listOf(
                QuestionOption("a", "Always `0.5`"),
                QuestionOption("b", "The relative rank `(rank - 1) / (total_rows - 1)` as a value from `0.0` to `1.0`"),
                QuestionOption("c", "The row's `score` divided by `100`"),
                QuestionOption("d", "The percentage of total `SUM(score)` contributed by the row")
            ),
            correctOptionId = "b",
            explanation = "PERCENT_RANK computes the relative standing of a row within its partition on a 0-to-1 scale."
        ),
        QuizQuestion(
            id = "sql_a_92",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How do you compute each row's percentage share of its department's total payroll in a single `SELECT` using window functions?",
            options = listOf(
                QuestionOption("a", "salary * 100.0 / SUM(salary) OVER (PARTITION BY dept_id)"),
                QuestionOption("b", "salary * 100.0 / SUM(salary) GROUP BY dept_id"),
                QuestionOption("c", "PERCENT_RANK() OVER (PARTITION BY dept_id ORDER BY salary)"),
                QuestionOption("d", "AVG(salary) OVER (PARTITION BY dept_id)")
            ),
            correctOptionId = "a",
            explanation = "`SUM(salary) OVER (PARTITION BY dept_id)` gives the department total alongside each individual row's `salary`."
        ),
        QuizQuestion(
            id = "sql_a_93",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "Why do you write `salary * 100.0 / total` instead of `(salary / total) * 100` when both `salary` and `total` are `INTEGER` columns in SQL (e.g., PostgreSQL, SQLite, SQL Server)?",
            options = listOf(
                QuestionOption("a", "Because `*` has lower precedence than `/`"),
                QuestionOption("b", "Because SQL does not allow parentheses around division"),
                QuestionOption("c", "There is no difference; SQL always uses 64-bit floats for `/`"),
                QuestionOption("d", "Because integer division `salary / total` truncates fractional results to `0` when `salary < total`!")
            ),
            correctOptionId = "d",
            explanation = "In most SQL engines, dividing two integers performs truncating integer division; multiplying by `100.0` (or casting to numeric/float) promotes to decimal division."
        ),
        QuizQuestion(
            id = "sql_a_94",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is a correlated `UPDATE` using a subquery (e.g., updating `denorm_count` on `departments` from `employees`)?",
            options = listOf(
                QuestionOption("a", "INSERT INTO departments.denorm_count SELECT COUNT(*) FROM employees;"),
                QuestionOption("b", "SELECT COUNT(*) INTO departments FROM employees;"),
                QuestionOption("c", "UPDATE departments SET denorm_count = (SELECT COUNT(*) FROM employees e WHERE e.dept_id = departments.id);"),
                QuestionOption("d", "UPDATE departments JOIN COUNT(employees);")
            ),
            correctOptionId = "c",
            explanation = "A correlated scalar subquery in `SET col = (SELECT ...)` computes the new value for each updated row."
        ),
        QuizQuestion(
            id = "sql_a_95",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What happens if a correlated `UPDATE` runs without a `WHERE` clause on the outer `UPDATE` statement, and the correlated subquery returns `NULL` for rows with no match?",
            options = listOf(
                QuestionOption("a", "Unmatched outer rows are deleted"),
                QuestionOption("b", "Unmatched outer rows have their target column overwritten with `NULL`! (Use a `WHERE EXISTS (...)` or `COALESCE` if they should be preserved)"),
                QuestionOption("c", "Unmatched outer rows are automatically skipped"),
                QuestionOption("d", "The `UPDATE` fails with a syntax error")
            ),
            correctOptionId = "b",
            explanation = "Without an outer WHERE filter, UPDATE modifies every row in the target table, setting unmatched rows to whatever the subquery returns (NULL)."
        ),
        QuizQuestion(
            id = "sql_a_96",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, what is a `SURROGATE KEY` versus a `NATURAL KEY`?",
            options = listOf(
                QuestionOption("a", "A surrogate key is a system-generated identifier (like an auto-incrementing ID or UUID) with no business meaning, whereas a natural key is formed from real-world attributes (like an ISO country code)"),
                QuestionOption("b", "A surrogate key is a foreign key, whereas a natural key is a primary key"),
                QuestionOption("c", "A natural key is only used in `NATURAL JOIN`"),
                QuestionOption("d", "A surrogate key allows duplicate values")
            ),
            correctOptionId = "a",
            explanation = "Surrogate keys remain immutable even when business attributes (like email or phone number) change."
        ),
        QuizQuestion(
            id = "sql_a_97",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "What is the effect of `SELECT DISTINCT a, b FROM t;`?",
            options = listOf(
                QuestionOption("a", "Deduplicates column `a` only and picks a random `b`"),
                QuestionOption("b", "Requires `a` and `b` to have the same value"),
                QuestionOption("c", "Applies `DISTINCT` to `a` and sorts by `b`"),
                QuestionOption("d", "Returns unique combinations of `(a, b)` pairs across both columns")
            ),
            correctOptionId = "d",
            explanation = "DISTINCT applies to the entire selected row tuple `(a, b)`, not just the first column."
        ),
        QuizQuestion(
            id = "sql_a_98",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In SQL, how can you pivot rows of `(dept, quarter, revenue)` into columns `q1_rev, q2_rev, q3_rev, q4_rev` per `dept` using standard ANSI SQL?",
            options = listOf(
                QuestionOption("a", "Using `CROSS JOIN` four times without `GROUP BY`"),
                QuestionOption("b", "Using `UNION ALL`"),
                QuestionOption("c", "GROUP BY dept with conditional aggregation: `SUM(CASE WHEN quarter = 1 THEN revenue ELSE 0 END) AS q1_rev`, etc."),
                QuestionOption("d", "Using `ORDER BY quarter ASC`")
            ),
            correctOptionId = "c",
            explanation = "GROUP BY combined with `SUM(CASE WHEN ...)` is the portable ANSI SQL way to pivot rows into columns."
        ),
        QuizQuestion(
            id = "sql_a_99",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "How can you unpivot columns `(id, q1, q2)` into rows `(id, quarter, amount)` using standard SQL?",
            options = listOf(
                QuestionOption("a", "ALTER TABLE t UNPIVOT (q1, q2)"),
                QuestionOption("b", "SELECT id, 'Q1' AS quarter, q1 AS amount FROM t UNION ALL SELECT id, 'Q2', q2 FROM t"),
                QuestionOption("c", "SELECT id, GROUP BY q1, q2 FROM t"),
                QuestionOption("d", "SELECT DISTINCT q1, q2 FROM t")
            ),
            correctOptionId = "b",
            explanation = "`UNION ALL` (or a `CROSS JOIN LATERAL (VALUES ...)` in PostgreSQL) turns multiple columns into normalized rows."
        ),
        QuizQuestion(
            id = "sql_a_100",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.APPLIED,
            prompt = "In a SQL query with both `WHERE` and `HAVING`, which strategy generally yields better performance when filtering on a grouping column `dept_id = 10`?",
            options = listOf(
                QuestionOption("a", "Putting `dept_id = 10` in `WHERE` so non-matching rows are eliminated BEFORE grouping and aggregation"),
                QuestionOption("b", "Putting `dept_id = 10` in `HAVING` so all departments are grouped first"),
                QuestionOption("c", "Putting it in `ORDER BY`"),
                QuestionOption("d", "Performance is always slower with `WHERE`")
            ),
            correctOptionId = "a",
            explanation = "Filtering rows in WHERE reduces the number of rows that must be hashed or sorted during GROUP BY."
        )
    )

    private fun advancedBatch1(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "sql_adv_16",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a recursive CTE (`WITH RECURSIVE org AS (anchor_query UNION ALL recursive_query)`), what is the role of the anchor member vs. the recursive member?",
            options = listOf(
                QuestionOption("a", "The anchor member produces the initial base rows (e.g., root nodes), and the recursive member repeatedly joins against the working table until an iteration returns 0 new rows"),
                QuestionOption("b", "The recursive member runs first and the anchor member runs last"),
                QuestionOption("c", "Both queries execute only once in parallel"),
                QuestionOption("d", "The anchor member deletes rows from the recursive member")
            ),
            correctOptionId = "a",
            explanation = "A recursive CTE evaluates the non-recursive anchor query once, then iteratively executes the recursive term on newly produced rows until fixed point."
        ),
        QuizQuestion(
            id = "sql_adv_17",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens in a recursive CTE if the underlying graph contains a cycle (e.g., manager A reports to B and B reports to A) and `UNION ALL` is used without cycle detection?",
            options = listOf(
                QuestionOption("a", "SQL automatically ignores cycles in `UNION ALL`"),
                QuestionOption("b", "The query immediately returns 0 rows"),
                QuestionOption("c", "The database drops the table"),
                QuestionOption("d", "The query enters an infinite loop (until hitting a recursion depth limit, timeout, or memory limit)")
            ),
            correctOptionId = "d",
            explanation = "With UNION ALL, cyclic graphs generate new rows indefinitely unless you track visited node paths or use `CYCLE` / `UNION` where applicable."
        ),
        QuizQuestion(
            id = "sql_adv_18",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL window frames, what is the critical difference between `ROWS BETWEEN ...` and `RANGE BETWEEN ...` when `ORDER BY score` has duplicate (tied) `score` values?",
            options = listOf(
                QuestionOption("a", "`RANGE` only works with string columns"),
                QuestionOption("b", "`ROWS` ignores the `ORDER BY` clause"),
                QuestionOption("c", "`ROWS` counts physical rows relative to the current row, whereas `RANGE` groups all peer rows that share the same `score` value together in the frame!"),
                QuestionOption("d", "There is no difference; `ROWS` and `RANGE` are synonyms")
            ),
            correctOptionId = "c",
            explanation = "With `ORDER BY score`, the default frame is `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`, which includes all tied peers of the current row's `score` in the running aggregate!"
        ),
        QuizQuestion(
            id = "sql_adv_19",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Given rows with `score` values `10, 20, 20, 30`, what does `SUM(score) OVER (ORDER BY score)` (using the default `RANGE` frame) return for the FIRST `20` row?",
            options = listOf(
                QuestionOption("a", "80"),
                QuestionOption("b", "50 (because `RANGE` includes all peers with `score = 20`: `10 + 20 + 20 = 50`!)"),
                QuestionOption("c", "30 (`10 + 20`)"),
                QuestionOption("d", "20")
            ),
            correctOptionId = "b",
            explanation = "Because the default frame with ORDER BY is `RANGE ... CURRENT ROW`, both `20` rows are peers and both see `10 + 20 + 20 = 50`. Using `ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW` gives `30` then `50`."
        ),
        QuizQuestion(
            id = "sql_adv_20",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the ANSI SQL transaction isolation hierarchy, which isolation phenomena are defined by the standard?",
            options = listOf(
                QuestionOption("a", "Dirty Read, Non-Repeatable Read (Fuzzy Read), and Phantom Read (plus Serialization Anomalies like Write Skew)"),
                QuestionOption("b", "Syntax Error, Foreign Key Error, and Deadlock"),
                QuestionOption("c", "Full Table Scan, Index Scan, and Bitmap Scan"),
                QuestionOption("d", "Cold Cache, Warm Cache, and Hot Cache")
            ),
            correctOptionId = "a",
            explanation = "Standard isolation levels are defined by whether they permit Dirty Reads, Non-Repeatable Reads, and Phantom Reads."
        ),
        QuizQuestion(
            id = "sql_adv_21",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Dirty Read` in concurrent database transactions?",
            options = listOf(
                QuestionOption("a", "Transaction T1 reads a table that has no primary key"),
                QuestionOption("b", "Transaction T1 reads expired cache data after T2 has committed"),
                QuestionOption("c", "Two transactions insert the same primary key"),
                QuestionOption("d", "Transaction T1 reads uncommitted data written by Transaction T2, which T2 might subsequently roll back")
            ),
            correctOptionId = "d",
            explanation = "Dirty reads occur under READ UNCOMMITTED when a transaction sees uncommitted modifications of another concurrent transaction."
        ),
        QuizQuestion(
            id = "sql_adv_22",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Non-Repeatable Read` (Fuzzy Read)?",
            options = listOf(
                QuestionOption("a", "A query returns rows in a different order because `ORDER BY` was omitted"),
                QuestionOption("b", "A disk read fails with a checksum error"),
                QuestionOption("c", "Transaction T1 reads a specific row twice within the same transaction, and gets different values because Transaction T2 updated and committed that row in between"),
                QuestionOption("d", "Transaction T1 reads uncommitted data from T2")
            ),
            correctOptionId = "c",
            explanation = "In READ COMMITTED, re-reading the same row after another transaction commits an UPDATE can return the newly committed value."
        ),
        QuizQuestion(
            id = "sql_adv_23",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Phantom Read`?",
            options = listOf(
                QuestionOption("a", "A deadlock between two `UPDATE` statements"),
                QuestionOption("b", "Transaction T1 re-executes a range/predicate query (`WHERE dept = 'IT'`) and sees new or missing rows because Transaction T2 inserted or deleted matching rows and committed"),
                QuestionOption("c", "Reading a row that was never inserted by any transaction"),
                QuestionOption("d", "Reading a dropped table")
            ),
            correctOptionId = "b",
            explanation = "Phantoms occur when concurrent inserts/deletes change the set of rows satisfying a search predicate between two reads in the same transaction."
        ),
        QuizQuestion(
            id = "sql_adv_24",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Multiversion Concurrency Control (MVCC, used by PostgreSQL, InnoDB, SQLite WAL), what is a key advantage for concurrent workloads?",
            options = listOf(
                QuestionOption("a", "Readers do not block writers and writers do not block readers (reads see a consistent snapshot of committed data)"),
                QuestionOption("b", "Tables never require indexes"),
                QuestionOption("c", "Deadlocks between two writers become completely impossible"),
                QuestionOption("d", "Transactions never need to be committed")
            ),
            correctOptionId = "a",
            explanation = "MVCC maintains multiple row versions so read queries observe a point-in-time snapshot without acquiring locks that block concurrent writes."
        ),
        QuizQuestion(
            id = "sql_adv_25",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Write Skew` under Snapshot Isolation (`REPEATABLE READ` in MVCC systems without Serializable Snapshot Isolation)?",
            options = listOf(
                QuestionOption("a", "Two transactions updating the exact same row simultaneously"),
                QuestionOption("b", "Reading uncommitted data from another transaction"),
                QuestionOption("c", "A corrupted B-tree index page"),
                QuestionOption("d", "Two concurrent transactions read overlapping data (e.g., checking that at least 1 doctor is on call), and each updates a disjoint row based on its snapshot, violating an invariant when both commit")
            ),
            correctOptionId = "d",
            explanation = "Because the two transactions update different rows (Doctor A vs. Doctor B), row-level write-conflict detection does not stop them, leaving 0 doctors on call unless `SERIALIZABLE` or explicit locking is used."
        ),
        QuizQuestion(
            id = "sql_adv_26",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How do two concurrent transactions cause a database `Deadlock`, and how can application code prevent it?",
            options = listOf(
                QuestionOption("a", "By creating an index on a foreign key"),
                QuestionOption("b", "Deadlocks only happen in single-threaded databases"),
                QuestionOption("c", "T1 locks row A then waits for row B while T2 locks row B then waits for row A; prevent it by acquiring locks on rows/tables in a consistent canonical order (e.g., sorted by `id`)"),
                QuestionOption("d", "By running two `SELECT` queries without `FOR UPDATE`")
            ),
            correctOptionId = "c",
            explanation = "Locking resources in a deterministic ascending order across all transactions breaks circular wait conditions."
        ),
        QuizQuestion(
            id = "sql_adv_27",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `SELECT ... FOR UPDATE` do inside a transaction?",
            options = listOf(
                QuestionOption("a", "Commits the transaction automatically"),
                QuestionOption("b", "Acquires an exclusive row-level lock on the selected rows so other transactions cannot modify or lock them until the transaction finishes"),
                QuestionOption("c", "Immediately updates all selected columns to `NULL`"),
                QuestionOption("d", "Runs the `SELECT` query without reading any indexes")
            ),
            correctOptionId = "b",
            explanation = "`SELECT ... FOR UPDATE` prevents lost updates when reading a row with the intention of updating it based on the read value."
        ),
        QuizQuestion(
            id = "sql_adv_28",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In relational algebra and SQL, how is `Relational Division` (e.g., 'Find students who have completed ALL required courses') expressed using `GROUP BY`?",
            options = listOf(
                QuestionOption("a", "Join student completions to required courses, `GROUP BY student_id`, and filter with `HAVING COUNT(DISTINCT course_id) = (SELECT COUNT(*) FROM required_courses)`"),
                QuestionOption("b", "Use `WHERE course_id IN (SELECT course_id FROM required_courses)` without `GROUP BY`"),
                QuestionOption("c", "Use `CROSS JOIN` between `students` and `required_courses`"),
                QuestionOption("d", "Use `LEFT JOIN` and check `IS NULL`")
            ),
            correctOptionId = "a",
            explanation = "Counting distinct matched required courses per student and equating to the total number of required courses (or using double `NOT EXISTS`) implements relational division."
        ),
        QuizQuestion(
            id = "sql_adv_29",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How is Relational Division ('students who took ALL required courses') expressed using double `NOT EXISTS`?",
            options = listOf(
                QuestionOption("a", "SELECT s.id FROM students s WHERE EXISTS (SELECT 1 FROM enrollments e WHERE e.student_id = s.id)"),
                QuestionOption("b", "SELECT s.id FROM students s WHERE s.id NOT IN (SELECT course_id FROM required_courses)"),
                QuestionOption("c", "SELECT s.id FROM students s NATURAL JOIN required_courses"),
                QuestionOption("d", "SELECT s.id FROM students s WHERE NOT EXISTS (SELECT 1 FROM required_courses r WHERE NOT EXISTS (SELECT 1 FROM enrollments e WHERE e.student_id = s.id AND e.course_id = r.id))")
            ),
            correctOptionId = "d",
            explanation = "'There does NOT exist a required course that the student has NOT enrolled in' is the logical equivalence of universal quantification (`FOR ALL`)."
        ),
        QuizQuestion(
            id = "sql_adv_30",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what is the 'Gaps and Islands' problem, and what is the classic window-function technique to group consecutive integers `seq` into islands?",
            options = listOf(
                QuestionOption("a", "Use `LAG(seq)` inside `GROUP BY` directly"),
                QuestionOption("b", "Use `NTILE(100)`"),
                QuestionOption("c", "Subtract `ROW_NUMBER() OVER (ORDER BY seq)` from `seq`; consecutive numbers share the exact same difference `seq - rn`!"),
                QuestionOption("d", "Add `RANK()` to `DENSE_RANK()`")
            ),
            correctOptionId = "c",
            explanation = "When `seq` increments by 1 and `ROW_NUMBER()` also increments by 1, their difference `seq - ROW_NUMBER() OVER (ORDER BY seq)` remains constant across each contiguous island!"
        ),
        QuizQuestion(
            id = "sql_adv_31",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `LAG()` or `ROW_NUMBER()` NOT allowed directly inside a `WHERE` or `GROUP BY` clause in SQL?",
            options = listOf(
                QuestionOption("a", "They ARE allowed directly in `WHERE` in ANSI SQL"),
                QuestionOption("b", "Because window functions are logically evaluated in the `SELECT` / `ORDER BY` phase AFTER `WHERE`, `GROUP BY`, and `HAVING` have already completed"),
                QuestionOption("c", "Because window functions return strings instead of numbers"),
                QuestionOption("d", "Because `OVER` is a reserved keyword in `WHERE`")
            ),
            correctOptionId = "b",
            explanation = "Window functions execute after `WHERE`, `GROUP BY`, and `HAVING`; to filter or group by a window function's result, wrap it in a CTE or derived table."
        ),
        QuizQuestion(
            id = "sql_adv_32",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How do you return the top 3 highest-paid employees per department (including ties or strict count) in SQL?",
            options = listOf(
                QuestionOption("a", "Compute `rn = ROW_NUMBER() OVER (PARTITION BY dept_id ORDER BY salary DESC)` (or `DENSE_RANK()`) inside a CTE, then filter `WHERE rn <= 3` in the outer query"),
                QuestionOption("b", "Use `GROUP BY dept_id LIMIT 3`"),
                QuestionOption("c", "Use `HAVING COUNT(*) <= 3`"),
                QuestionOption("d", "Use `WHERE ROWNUM <= 3` after `ORDER BY salary DESC` without partitioning")
            ),
            correctOptionId = "a",
            explanation = "Ranking inside a partitioned window in a CTE and filtering `WHERE rn <= 3` in the outer query solves the Top-N-per-group problem cleanly."
        ),
        QuizQuestion(
            id = "sql_adv_33",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In PostgreSQL and standard SQL:1999+, what does a `LATERAL` join (`CROSS JOIN LATERAL` or `LEFT JOIN LATERAL`) allow that a regular subquery in `FROM` does not?",
            options = listOf(
                QuestionOption("a", "It joins tables across different physical servers without network calls"),
                QuestionOption("b", "It automatically indexes both tables in memory"),
                QuestionOption("c", "It ignores `WHERE` conditions"),
                QuestionOption("d", "The right-hand subquery in `FROM` can reference columns from tables appearing to its left in the `FROM` clause, executing per left row")
            ),
            correctOptionId = "d",
            explanation = "LATERAL allows a derived table in `FROM` to be correlated with preceding `FROM` items (e.g., fetching the top 3 recent orders per customer)."
        ),
        QuizQuestion(
            id = "sql_adv_34",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL query execution plans, what are the three classic physical join algorithms used by relational query optimizers?",
            options = listOf(
                QuestionOption("a", "DFS Join, BFS Join, and Dijkstra Join"),
                QuestionOption("b", "Primary Join, Secondary Join, and Tertiary Join"),
                QuestionOption("c", "Nested Loop Join, Hash Join, and Sort-Merge Join"),
                QuestionOption("d", "Quick Join, Bubble Join, and Heap Join")
            ),
            correctOptionId = "c",
            explanation = "Optimizers choose between Nested Loop Join (great for small outer sets + indexed inner), Hash Join (great for large unsorted equi-joins), and Sort-Merge Join (great for pre-sorted inputs or range/equi-joins)."
        ),
        QuizQuestion(
            id = "sql_adv_35",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When does a query optimizer typically prefer a `Hash Join` over a `Nested Loop Join`?",
            options = listOf(
                QuestionOption("a", "When there is no `ON` clause (`CROSS JOIN`)"),
                QuestionOption("b", "When joining two large tables on an equality condition (`a.id = b.id`) without selective filters or pre-existing sort order"),
                QuestionOption("c", "When the outer table has only 2 rows and the inner table has a unique B-tree index"),
                QuestionOption("d", "When the join condition is an inequality like `a.price < b.price`")
            ),
            correctOptionId = "b",
            explanation = "Hash Join builds an in-memory hash table on the smaller input (build phase) and scans the larger input (probe phase) in O(M + N) time for equi-joins."
        ),
        QuizQuestion(
            id = "sql_adv_36",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can a standard `Hash Join` NOT be used directly for a pure inequality join predicate like `ON a.start_time < b.end_time`?",
            options = listOf(
                QuestionOption("a", "Because hash functions map exact equality keys to buckets and do not preserve ordering for `<` or `>` comparisons"),
                QuestionOption("b", "Because timestamps cannot be hashed"),
                QuestionOption("c", "Because `Hash Join` only works on `LEFT JOIN`"),
                QuestionOption("d", "It can; `Hash Join` is optimal for `<`")
            ),
            correctOptionId = "a",
            explanation = "Hash tables only support exact key equality lookups; inequality joins require Sort-Merge Join, Nested Loop Join, or band-join techniques."
        ),
        QuizQuestion(
            id = "sql_adv_37",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is it important to index `FOREIGN KEY` columns on child tables in a relational database?",
            options = listOf(
                QuestionOption("a", "Because primary keys automatically index all child foreign keys"),
                QuestionOption("b", "Because foreign keys are illegal without a unique index"),
                QuestionOption("c", "Only to speed up `INSERT` into the child table"),
                QuestionOption("d", "Without an index on the child foreign key, joining parent-to-child OR deleting/updating a parent key requires a full table scan of the child table to check referential integrity!")
            ),
            correctOptionId = "d",
            explanation = " Databases automatically index PRIMARY KEY and UNIQUE constraints, but most (like PostgreSQL and SQLite) do NOT automatically create an index on a FOREIGN KEY column."
        ),
        QuizQuestion(
            id = "sql_adv_38",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Keyset Pagination` (Seek Method) and why does it outperform `LIMIT 20 OFFSET 100000` on large tables?",
            options = listOf(
                QuestionOption("a", "Keyset pagination does not require an `ORDER BY` clause"),
                QuestionOption("b", "Keyset pagination loads the entire table into RAM"),
                QuestionOption("c", "Using `WHERE (created_at, id) < (:last_ts, :last_id) ORDER BY created_at DESC, id DESC LIMIT 20` uses a B-tree index seek directly to the cursor position, whereas `OFFSET 100000` must scan and discard 100,000 rows!"),
                QuestionOption("d", "`OFFSET` is a syntax error when > 10,000")
            ),
            correctOptionId = "c",
            explanation = "Large OFFSET values scale linearly O(offset) because the engine must still walk past skipped rows; keyset pagination jumps directly via index in O(log N)."
        ),
        QuizQuestion(
            id = "sql_adv_39",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In Keyset Pagination `WHERE (created_at, id) < (:last_ts, :last_id)`, why is the tie-breaker column `id` (the primary key) necessary alongside `created_at`?",
            options = listOf(
                QuestionOption("a", "It is not necessary; `created_at` is always unique"),
                QuestionOption("b", "If multiple rows share the exact same `created_at` timestamp across a page boundary, filtering on `created_at < :last_ts` alone would either skip or duplicate tied rows!"),
                QuestionOption("c", "Because SQL does not allow `<` on timestamps alone"),
                QuestionOption("d", "Because `id` must always be the first column in `ORDER BY`")
            ),
            correctOptionId = "b",
            explanation = "A deterministic, strictly unique ordering key `(created_at, id)` guarantees that no rows are skipped or duplicated when paginating across ties."
        ),
        QuizQuestion(
            id = "sql_adv_40",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQLite and PostgreSQL, what is a `Partial Index` (Filtered Index), such as `CREATE INDEX idx_open_orders ON orders(created_at) WHERE status = 'open';`?",
            options = listOf(
                QuestionOption("a", "An index that only includes rows satisfying the `WHERE` predicate, keeping the index much smaller and faster when most rows are `'closed'`"),
                QuestionOption("b", "An index that only indexes the first half of the string"),
                QuestionOption("c", "An index that is only updated once per day"),
                QuestionOption("d", "A corrupt index that needs rebuilding")
            ),
            correctOptionId = "a",
            explanation = "Partial indexes drastically reduce index size and write overhead when queries frequently filter on a small subset of table rows (e.g., active/unprocessed items)."
        ),
        QuizQuestion(
            id = "sql_adv_41",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In PostgreSQL / SQLite, what is an `Expression Index` (Functional Index), such as `CREATE INDEX idx_lower_email ON users(LOWER(email));`?",
            options = listOf(
                QuestionOption("a", "An index that stores SQL query strings"),
                QuestionOption("b", "An index that automatically converts the column in the table to lowercase"),
                QuestionOption("c", "A trigger that validates email format"),
                QuestionOption("d", "An index built on the result of an expression or function, allowing queries with `WHERE LOWER(email) = 'a@b.com'` to use an index scan")
            ),
            correctOptionId = "d",
            explanation = "Indexing `LOWER(email)` allows case-insensitive searches using `WHERE LOWER(email) = ...` to perform a fast B-tree lookup."
        ),
        QuizQuestion(
            id = "sql_adv_42",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does the `EXPLAIN` (vs. `EXPLAIN ANALYZE` in PostgreSQL) command do?",
            options = listOf(
                QuestionOption("a", "`EXPLAIN` optimizes the table on disk"),
                QuestionOption("b", "`EXPLAIN ANALYZE` only checks syntax without running the query"),
                QuestionOption("c", "`EXPLAIN` shows the estimated query execution plan WITHOUT running the query, whereas `EXPLAIN ANALYZE` actually executes the query and reports real timing and row counts"),
                QuestionOption("d", "Both execute the query and delete the result")
            ),
            correctOptionId = "c",
            explanation = "Be careful with `EXPLAIN ANALYZE` on `UPDATE`/`DELETE` statements: because it actually executes the query, wrap it in `BEGIN; EXPLAIN ANALYZE ...; ROLLBACK;`!"
        ),
        QuizQuestion(
            id = "sql_adv_43",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a query plan, why might the optimizer legitimately choose a `Sequential Scan` (Full Table Scan) even when a valid B-tree index exists on the `WHERE` column?",
            options = listOf(
                QuestionOption("a", "Because `SELECT *` deletes indexes"),
                QuestionOption("b", "When the table is very small or the predicate matches a large fraction of the table, sequential page reads are cheaper than random index-to-heap lookups"),
                QuestionOption("c", "Because the optimizer ignores indexes unless forced by hints"),
                QuestionOption("d", "Because B-tree indexes only work on `JOIN`, never `WHERE`")
            ),
            correctOptionId = "b",
            explanation = "Reading 40% of a table via random B-tree pointer lookups touches nearly every data page anyway, making a sequential scan faster."
        ),
        QuizQuestion(
            id = "sql_adv_44",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Cardinality Estimation` in a SQL query optimizer, and what happens when table statistics become severely outdated?",
            options = listOf(
                QuestionOption("a", "The optimizer estimates how many rows each step will produce; stale statistics can cause it to pick a Nested Loop Join over millions of rows instead of a Hash Join"),
                QuestionOption("b", "It counts the number of columns in a table"),
                QuestionOption("c", "It checks whether foreign keys are valid"),
                QuestionOption("d", "It encrypts query plans")
            ),
            correctOptionId = "a",
            explanation = "Commands like `ANALYZE` update column histograms and distinct counts so the cost-based optimizer can accurately estimate selectivity."
        ),
        QuizQuestion(
            id = "sql_adv_45",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is `Boyce-Codd Normal Form (BCNF)` and how is it stricter than `Third Normal Form (3NF)`?",
            options = listOf(
                QuestionOption("a", "BCNF forbids tables from having more than 2 columns"),
                QuestionOption("b", "BCNF requires denormalizing all tables into one giant table"),
                QuestionOption("c", "BCNF allows partial dependencies on composite keys"),
                QuestionOption("d", "In BCNF, for EVERY non-trivial functional dependency `X -> Y`, `X` must be a superkey (3NF allows `X -> Y` if `Y` is a prime attribute belonging to some candidate key)")
            ),
            correctOptionId = "d",
            explanation = "A 3NF table with overlapping candidate keys can still have anomalies if a non-superkey determines part of a candidate key; BCNF eliminates this."
        ),
        QuizQuestion(
            id = "sql_adv_46",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL window frames, what does `GROUPS BETWEEN 1 PRECEDING AND 1 FOLLOWING` (introduced in SQL:2011, supported in PostgreSQL/SQLite) do?",
            options = listOf(
                QuestionOption("a", "Same as `ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING`"),
                QuestionOption("b", "Throws a syntax error because `GROUPS` is not a keyword"),
                QuestionOption("c", "Includes the current peer group of tied `ORDER BY` values, plus the entire immediately preceding peer group and immediately following peer group"),
                QuestionOption("d", "Groups rows by primary key modulo 3")
            ),
            correctOptionId = "c",
            explanation = "`ROWS` counts individual rows, `RANGE` uses value offsets, and `GROUPS` counts distinct peer groups of tied `ORDER BY` values."
        ),
        QuizQuestion(
            id = "sql_adv_47",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL window functions, what does the `EXCLUDE CURRENT ROW` clause in `OVER (ORDER BY x ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING EXCLUDE CURRENT ROW)` do?",
            options = listOf(
                QuestionOption("a", "Skips the first row of the partition"),
                QuestionOption("b", "Computes the window function over the neighboring rows in the frame while excluding the current row itself"),
                QuestionOption("c", "Deletes the current row from the query output"),
                QuestionOption("d", "Excludes NULL values from the table")
            ),
            correctOptionId = "b",
            explanation = "Window frame exclusion (`EXCLUDE CURRENT ROW`, `EXCLUDE GROUP`, `EXCLUDE TIES`, `EXCLUDE NO OTHERS`) omits specific rows from the frame calculation."
        ),
        QuizQuestion(
            id = "sql_adv_48",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Given `scores(val INT)` with rows `10, 20, 30, 40`, how can you compute the exact `Median` in SQL?",
            options = listOf(
                QuestionOption("a", "Use `PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY val)` (or average the middle row(s) using `ROW_NUMBER()` and `COUNT(*) OVER ()`)"),
                QuestionOption("b", "Use `AVG(val)`"),
                QuestionOption("c", "Use `MIDDLE(val)`"),
                QuestionOption("d", "Use `NTILE(2)` and take the maximum of bucket 2")
            ),
            correctOptionId = "a",
            explanation = "Ordered-set aggregate `PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY val)` interpolates the 50th percentile (`(20 + 30) / 2.0 = 25.0`)."
        ),
        QuizQuestion(
            id = "sql_adv_49",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between `PERCENTILE_CONT(0.5)` and `PERCENTILE_DISC(0.5)` on the even-sized dataset `10, 20, 30, 40`?",
            options = listOf(
                QuestionOption("a", "`PERCENTILE_DISC` returns `25.0` and `PERCENTILE_CONT` returns `20`"),
                QuestionOption("b", "Both return `30`"),
                QuestionOption("c", "`PERCENTILE_DISC` sorts in descending order"),
                QuestionOption("d", "`PERCENTILE_CONT(0.5)` interpolates continuously to return `25.0`, whereas `PERCENTILE_DISC(0.5)` returns an actual discrete value from the dataset (`20`)")
            ),
            correctOptionId = "d",
            explanation = "CONT (continuous) linearly interpolates between adjacent values; DISC (discrete) picks the first dataset value whose cumulative distribution >= 0.5."
        ),
        QuizQuestion(
            id = "sql_adv_50",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `CUME_DIST() OVER (ORDER BY score)` compute for each row?",
            options = listOf(
                QuestionOption("a", "A value starting at `0.0` for the first row (like `PERCENT_RANK`)"),
                QuestionOption("b", "The cumulative sum of `score`"),
                QuestionOption("c", "The fraction of rows in the partition with a `score` less than or equal to the current row's `score` (`count(<= current) / total_rows`, always > 0 and <= 1.0)"),
                QuestionOption("d", "The distance between the current score and the previous score")
            ),
            correctOptionId = "c",
            explanation = "Unlike PERCENT_RANK (which starts at 0.0), CUME_DIST is `number of rows <= current peer group / total partition rows`, so it is strictly positive and ends at 1.0."
        ),
        QuizQuestion(
            id = "sql_adv_51",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what is a `Temporal Overlap` predicate to test whether two half-open intervals `[start1, end1)` and `[start2, end2)` overlap?",
            options = listOf(
                QuestionOption("a", "start1 = start2 AND end1 = end2"),
                QuestionOption("b", "start1 < end2 AND start2 < end1"),
                QuestionOption("c", "start1 <= start2 AND end1 >= end2"),
                QuestionOption("d", "start1 > end2 OR start2 > end1")
            ),
            correctOptionId = "b",
            explanation = "Two intervals `[s1, e1)` and `[s2, e2)` overlap if and only if each starts before the other ends: `s1 < e2 AND s2 < e1`."
        ),
        QuizQuestion(
            id = "sql_adv_52",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When merging overlapping date intervals `[start_dt, end_dt]` in SQL using window functions, how do you identify where a new non-overlapping island starts?",
            options = listOf(
                QuestionOption("a", "Order by `start_dt, end_dt`, compute the running maximum `MAX(end_dt) OVER (ORDER BY start_dt, end_dt ROWS BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING)`, and flag a new island whenever `start_dt > prev_max_end`!"),
                QuestionOption("b", "Compare `start_dt` only with `LAG(end_dt, 1)` (which fails when an earlier wide interval encompasses a shorter nested interval!)"),
                QuestionOption("c", "Group by `start_dt`"),
                QuestionOption("d", "Use `DENSE_RANK() OVER (ORDER BY end_dt)`")
            ),
            correctOptionId = "a",
            explanation = "Comparing only with `LAG(end_dt, 1)` fails if row 1 is `[Jan 1, Jan 30]`, row 2 is `[Jan 2, Jan 5]`, and row 3 is `[Jan 10, Jan 15]`; you must compare against the running `MAX(end_dt)` of all preceding rows!"
        ),
        QuizQuestion(
            id = "sql_adv_53",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does simply checking `start_dt > LAG(end_dt) OVER (ORDER BY start_dt)` fail when merging intervals `(1, 10)`, `(2, 4)`, `(5, 8)`?",
            options = listOf(
                QuestionOption("a", "Because `LAG` returns `NULL` on the third row"),
                QuestionOption("b", "Because `(2, 4)` sorts after `(5, 8)`"),
                QuestionOption("c", "It does not fail; `LAG(end_dt)` is always sufficient"),
                QuestionOption("d", "For `(5, 8)`, `LAG(end_dt)` is `4` (from `(2, 4)`), so `5 > 4` falsely starts a new island even though `(1, 10)` still covers `(5, 8)`!")
            ),
            correctOptionId = "d",
            explanation = "Because `(1, 10)` extends past `(2, 4)`, the running maximum end date before `(5, 8)` is `10`, not `4`."
        ),
        QuizQuestion(
            id = "sql_adv_54",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQLite and PostgreSQL, what does `GROUP_CONCAT(name, ', ')` / `STRING_AGG(name, ', ' ORDER BY name)` do?",
            options = listOf(
                QuestionOption("a", "Concatenates two columns within the same single row"),
                QuestionOption("b", "Counts the number of commas in a string"),
                QuestionOption("c", "Aggregates string values from multiple rows in a group into a single delimiter-separated string"),
                QuestionOption("d", "Splits a comma-separated string into multiple rows")
            ),
            correctOptionId = "c",
            explanation = "STRING_AGG (PostgreSQL/SQL Server) and GROUP_CONCAT (SQLite/MySQL) aggregate row values into a single concatenated string per group."
        ),
        QuizQuestion(
            id = "sql_adv_55",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQLite Write-Ahead Logging (`PRAGMA journal_mode = WAL;`), how are changes written compared to the legacy rollback journal mode?",
            options = listOf(
                QuestionOption("a", "Transactions can no longer be rolled back"),
                QuestionOption("b", "Modifications are appended sequentially to a separate `-wal` file while the original database pages remain untouched until a checkpoint, allowing concurrent readers alongside a writer"),
                QuestionOption("c", "The entire database file is copied before every single `INSERT`"),
                QuestionOption("d", "Durability is completely disabled")
            ),
            correctOptionId = "b",
            explanation = "WAL mode appends changes to the write-ahead log and periodically checkpoints them back to the main database file, enabling concurrent reads and higher write throughput."
        ),
        QuizQuestion(
            id = "sql_adv_56",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a B+Tree database index, why are all actual data pointers (or row payloads in a clustered index) stored in the leaf nodes linked in a doubly linked list?",
            options = listOf(
                QuestionOption("a", "So range queries (`WHERE id BETWEEN 100 AND 500`) can traverse the tree once to find `100` and then scan sequentially along the leaf-node linked list!"),
                QuestionOption("b", "Because internal nodes cannot store integers"),
                QuestionOption("c", "To make `DROP INDEX` faster"),
                QuestionOption("d", "Because B+Trees only have a height of 1")
            ),
            correctOptionId = "a",
            explanation = "B+Trees keep internal nodes compact (keys + child pointers only, maximizing fan-out) and link leaf nodes horizontally for fast ordered range scans."
        ),
        QuizQuestion(
            id = "sql_adv_57",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between a `Clustered Index` (like SQLite `WITHOUT ROWID` or InnoDB Primary Key) and a `Secondary (Non-Clustered) Index`?",
            options = listOf(
                QuestionOption("a", "A table can have 10 clustered indexes"),
                QuestionOption("b", "A secondary index cannot be used in `WHERE` clauses"),
                QuestionOption("c", "A clustered index only works on text columns"),
                QuestionOption("d", "A clustered index determines the physical/logical storage order of the table rows themselves (the leaf nodes ARE the data rows), whereas a secondary index stores key values plus row locators/primary keys")
            ),
            correctOptionId = "d",
            explanation = "Because the table rows themselves can only be stored in one physical order, a table can have at most one clustered index."
        ),
        QuizQuestion(
            id = "sql_adv_58",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In InnoDB or SQLite `WITHOUT ROWID` tables (clustered on the Primary Key), why can an oversized `PRIMARY KEY` (like `VARCHAR(255)`) bloat all secondary indexes?",
            options = listOf(
                QuestionOption("a", "Because `VARCHAR` keys disable B-tree compression"),
                QuestionOption("b", "It only bloats the primary key, not secondary indexes"),
                QuestionOption("c", "Because every secondary index leaf entry stores the clustered `PRIMARY KEY` value as its row locator pointer!"),
                QuestionOption("d", "Because secondary indexes are not allowed on clustered tables")
            ),
            correctOptionId = "c",
            explanation = "In clustered-index storage engines, secondary indexes point to rows by storing their primary key value rather than a physical heap Tuple ID (TID)."
        )
    )

    private fun advancedBatch2(): List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "sql_adv_59",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In PostgreSQL, what is `HOT (Heap-Only Tuple)` update optimization, and when can it occur?",
            options = listOf(
                QuestionOption("a", "When a query uses `ORDER BY` without `LIMIT`"),
                QuestionOption("b", "When an `UPDATE` does not modify any indexed column and the new row version fits on the same 8KB heap page, avoiding the need to insert new entries into every index on the table"),
                QuestionOption("c", "When a table is stored entirely in CPU cache"),
                QuestionOption("d", "When `TRUNCATE` is used instead of `DELETE`")
            ),
            correctOptionId = "b",
            explanation = "Updating an indexed column forces new index entries to be written; updating only unindexed columns allows PostgreSQL to chain the tuple on the same page."
        ),
        QuizQuestion(
            id = "sql_adv_60",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what is a `Sargable` (Search ARGument ABLE) predicate?",
            options = listOf(
                QuestionOption("a", "A predicate structured so the storage engine can use an index seek/range scan (e.g., `col >= 100` instead of `col + 5 >= 105`)"),
                QuestionOption("b", "A predicate that contains at least three `OR` conditions"),
                QuestionOption("c", "A query that uses `SELECT *`"),
                QuestionOption("d", "A subquery inside `HAVING`")
            ),
            correctOptionId = "a",
            explanation = "Isolating the indexed column on one side of comparison operators (`col = val`, `col >= val`) keeps the predicate sargable."
        ),
        QuizQuestion(
            id = "sql_adv_61",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "How do you rewrite the non-sargable predicate `WHERE price * 2 > 100` to make it sargable on an index over `price`?",
            options = listOf(
                QuestionOption("a", "WHERE 2 * price > 100"),
                QuestionOption("b", "WHERE CAST(price * 2 AS TEXT) > '100'"),
                QuestionOption("c", "HAVING price * 2 > 100"),
                QuestionOption("d", "WHERE price > 50 (or `price > 100 / 2.0`)")
            ),
            correctOptionId = "d",
            explanation = "Moving the arithmetic to the constant side (`price > 50`) allows the engine to perform a direct B-tree range scan starting at 50."
        ),
        QuizQuestion(
            id = "sql_adv_62",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why can `WHERE col_a = 10 OR col_b = 20` fail to use a single B-tree index scan efficiently, and how do optimizers or developers resolve it?",
            options = listOf(
                QuestionOption("a", "Because a composite index on `(col_a, col_b)` always seeks directly on `col_b = 20`"),
                QuestionOption("b", "Because `OR` automatically drops indexes"),
                QuestionOption("c", "A single B-tree cannot range-scan two unrelated columns at once; engines use a `BitmapOr` combining two separate indexes (on `col_a` and `col_b`) or rewrite as `UNION`"),
                QuestionOption("d", "Because `OR` is not supported in SQL")
            ),
            correctOptionId = "c",
            explanation = "With separate indexes on `col_a` and `col_b`, the planner can combine two index scans via BitmapOr or `SELECT ... WHERE col_a = 10 UNION SELECT ... WHERE col_b = 20`."
        ),
        QuizQuestion(
            id = "sql_adv_63",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When deduplicating a table `events(id, email, created_at)` to keep ONLY the most recent row per `email`, which window function pattern identifies the rows to delete?",
            options = listOf(
                QuestionOption("a", "Delete rows where `COUNT(email) > 1`"),
                QuestionOption("b", "Assign `rn = ROW_NUMBER() OVER (PARTITION BY email ORDER BY created_at DESC, id DESC)` and delete rows where `rn > 1`"),
                QuestionOption("c", "Assign `rn = RANK() OVER (ORDER BY email)` and delete where `rn = 1`"),
                QuestionOption("d", "Use `GROUP BY email` inside `DELETE`")
            ),
            correctOptionId = "b",
            explanation = "Partitioning by the natural key `email` and ordering by `created_at DESC, id DESC` numbers the latest row `1` and all older duplicates `2, 3, ...`."
        ),
        QuizQuestion(
            id = "sql_adv_64",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the subtle trap when using `RANK()` instead of `ROW_NUMBER()` to deduplicate rows with identical `(email, created_at)` timestamps?",
            options = listOf(
                QuestionOption("a", "If two duplicate rows have the exact same `created_at`, `RANK()` assigns `1` to BOTH rows, failing to deduplicate them!"),
                QuestionOption("b", "`RANK()` deletes both rows"),
                QuestionOption("c", "`RANK()` throws an exception on ties"),
                QuestionOption("d", "There is no difference")
            ),
            correctOptionId = "a",
            explanation = "ROW_NUMBER() always assigns distinct integers 1, 2, 3 even when the ORDER BY values tie, guaranteeing exactly one survivor (`rn = 1`) per partition."
        ),
        QuizQuestion(
            id = "sql_adv_65",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what is a `Semi-Join` and how is it typically written in queries?",
            options = listOf(
                QuestionOption("a", "A `LEFT JOIN` that returns only half the columns"),
                QuestionOption("b", "A `CROSS JOIN` with `LIMIT`"),
                QuestionOption("c", "A join on a partial string match"),
                QuestionOption("d", "An operation that returns rows from the left table where at least one match exists in the right table, without duplicating left rows when multiple right rows match (written with `EXISTS` or `IN`)")
            ),
            correctOptionId = "d",
            explanation = "Unlike an `INNER JOIN` (which multiplies left rows if multiple right rows match), a Semi-Join (`WHERE EXISTS (...)` or `WHERE id IN (...)`) returns each matching left row at most once."
        ),
        QuizQuestion(
            id = "sql_adv_66",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is an `Anti-Join` (or `Anti-Semi-Join`) in SQL query execution?",
            options = listOf(
                QuestionOption("a", "A `FULL OUTER JOIN`"),
                QuestionOption("b", "A query without a `FROM` clause"),
                QuestionOption("c", "An operation that returns rows from the left table that have NO matching row in the right table (written with `NOT EXISTS` or `LEFT JOIN ... WHERE right.pk IS NULL`)"),
                QuestionOption("d", "A join that uses `<>` in the `ON` clause")
            ),
            correctOptionId = "c",
            explanation = "An Anti-Join finds unmatched left rows and stops probing the right side for a given left row as soon as the first match is found."
        ),
        QuizQuestion(
            id = "sql_adv_67",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `SELECT DISTINCT c.id, c.name FROM customers c INNER JOIN orders o ON c.id = o.customer_id;` often less efficient than `SELECT c.id, c.name FROM customers c WHERE EXISTS (SELECT 1 FROM orders o WHERE o.customer_id = c.id);`?",
            options = listOf(
                QuestionOption("a", "`DISTINCT` is illegal with `INNER JOIN`"),
                QuestionOption("b", "The `INNER JOIN + DISTINCT` may generate all matching order rows per customer and then sort/hash them to deduplicate, whereas `EXISTS` (Semi-Join) can stop scanning orders for a customer after the very first match"),
                QuestionOption("c", "`INNER JOIN` returns wrong results"),
                QuestionOption("d", "`EXISTS` does not use indexes")
            ),
            correctOptionId = "b",
            explanation = "An EXISTS semi-join short-circuits on the first matching child row per customer without generating and deduplicating N intermediate joined rows."
        ),
        QuizQuestion(
            id = "sql_adv_68",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Given a table `sales(year, month, revenue)`, what does `LAG(revenue, 12) OVER (ORDER BY year, month)` compute (assuming 1 row per month with no missing months)?",
            options = listOf(
                QuestionOption("a", "The revenue from the same month in the previous year (Year-over-Year comparison)"),
                QuestionOption("b", "The average revenue of the last 12 months"),
                QuestionOption("c", "The sum of 12 months of revenue"),
                QuestionOption("d", "The revenue from 12 days ago")
            ),
            correctOptionId = "a",
            explanation = "With one row per month in chronological order, an offset of 12 rows looks back exactly 12 months."
        ),
        QuizQuestion(
            id = "sql_adv_69",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens to `LAG(revenue, 12) OVER (ORDER BY year, month)` if one month had zero sales and is completely MISSING as a row in the `sales` table?",
            options = listOf(
                QuestionOption("a", "`LAG` automatically detects missing months from the integer values"),
                QuestionOption("b", "SQL inserts a `0` row automatically"),
                QuestionOption("c", "The query fails with an error"),
                QuestionOption("d", "Every subsequent `LAG(..., 12)` shifts by one row and compares against 13 months ago instead of 12 months ago! (Use a calendar/date spine with `LEFT JOIN` or a `RANGE` interval frame)")
            ),
            correctOptionId = "d",
            explanation = "`LAG(expr, N)` counts physical rows, not calendar intervals; joining against a complete calendar spine or using `RANGE` interval frames prevents row-shift errors."
        ),
        QuizQuestion(
            id = "sql_adv_70",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, how can you generate a complete contiguous sequence of dates or integers (a 'date spine' or 'tally table') in pure ANSI SQL / SQLite without a helper table?",
            options = listOf(
                QuestionOption("a", "Using `GROUP BY 1..365`"),
                QuestionOption("b", "Using `HAVING COUNT(*) = 365`"),
                QuestionOption("c", "Using a recursive CTE: `WITH RECURSIVE seq(n) AS (SELECT 1 UNION ALL SELECT n + 1 FROM seq WHERE n < 365) SELECT n FROM seq;`"),
                QuestionOption("d", "Using `SELECT * FROM 1 TO 365;`")
            ),
            correctOptionId = "c",
            explanation = "A recursive CTE starting at 1 (or a start date) and adding 1 while `< N` generates a contiguous sequence of rows on the fly."
        ),
        QuizQuestion(
            id = "sql_adv_71",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In PostgreSQL/SQLite, what does a `VALUES (1, 'A'), (2, 'B'), (3, 'C')` clause allow when used as a standalone query or inside a CTE?",
            options = listOf(
                QuestionOption("a", "Drops three columns"),
                QuestionOption("b", "Constructs an inline constant table of rows without needing to create or query a physical table"),
                QuestionOption("c", "Updates three rows in an existing table"),
                QuestionOption("d", "Creates a trigger with three arguments")
            ),
            correctOptionId = "b",
            explanation = "`VALUES (...), (...)` constructs an ad-hoc relation of rows that can be queried in a CTE, joined, or used in `INSERT`."
        ),
        QuizQuestion(
            id = "sql_adv_72",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the `Halloween Problem` in database engine implementation?",
            options = listOf(
                QuestionOption("a", "An `UPDATE` statement (e.g., `UPDATE emp SET salary = salary * 1.1 WHERE salary < 50000`) scanning an index on `salary` encounters the same row multiple times because the update moves the row's index entry forward into the scan's path!"),
                QuestionOption("b", "A query running at midnight on October 31 returning NULL"),
                QuestionOption("c", "A deadlock between `DROP TABLE` and `SELECT`"),
                QuestionOption("d", "A backup failing due to disk space")
            ),
            correctOptionId = "a",
            explanation = "Database engines prevent the Halloween Problem by separating the read phase (or spooling target row IDs / using MVCC snapshots) so an updated row is never updated twice by the same statement."
        ),
        QuizQuestion(
            id = "sql_adv_73",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In MVCC databases like PostgreSQL, why is periodic `VACUUM` (or autovacuum) necessary?",
            options = listOf(
                QuestionOption("a", "Because PostgreSQL stores all tables in RAM until `VACUUM` writes them to disk"),
                QuestionOption("b", "Because `VACUUM` drops unused columns automatically"),
                QuestionOption("c", "Because indexes are deleted after every commit"),
                QuestionOption("d", "Because `UPDATE` and `DELETE` create obsolete dead tuple versions rather than overwriting in place; `VACUUM` reclaims dead tuple space and prevents Transaction ID (XID) wraparound")
            ),
            correctOptionId = "d",
            explanation = "In MVCC, old row versions must remain until no active transaction snapshot can see them; VACUUM marks that space reusable."
        ),
        QuizQuestion(
            id = "sql_adv_74",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQLite, what does the `VACUUM;` command do?",
            options = listOf(
                QuestionOption("a", "Drops all foreign keys"),
                QuestionOption("b", "Rolls back the last committed transaction"),
                QuestionOption("c", "Rebuilds the database file into a new compact file, reclaiming free pages left by deleted data and defragmenting tables/indexes"),
                QuestionOption("d", "Deletes all rows from all tables")
            ),
            correctOptionId = "c",
            explanation = "In SQLite, `VACUUM` repacks the database into a minimal contiguous file and frees unused `freelist` pages back to the OS."
        ),
        QuizQuestion(
            id = "sql_adv_75",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is the difference between `Optimistic Concurrency Control` (using a `version` column) and `Pessimistic Locking` (`SELECT ... FOR UPDATE`)?",
            options = listOf(
                QuestionOption("a", "Optimistic concurrency only works on `DELETE` statements"),
                QuestionOption("b", "Optimistic concurrency skips read locks and checks `UPDATE t SET ..., version = version + 1 WHERE id = :id AND version = :read_version` (checking `rows_affected == 1`), whereas pessimistic locking blocks concurrent transactions upfront"),
                QuestionOption("c", "Optimistic concurrency never checks for conflicts and overwrites blindly"),
                QuestionOption("d", "Pessimistic locking does not use transactions")
            ),
            correctOptionId = "b",
            explanation = "Optimistic locking avoids holding database locks across user think-time or network hops by validating the row's `version` number on write."
        ),
        QuizQuestion(
            id = "sql_adv_76",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In the optimistic locking query `UPDATE accounts SET balance = :new_bal, version = version + 1 WHERE id = :id AND version = :expected_ver;`, how does the application know a concurrent modification occurred?",
            options = listOf(
                QuestionOption("a", "The `UPDATE` statement affects `0` rows (even though `id = :id` exists), signaling a version mismatch so the app can retry"),
                QuestionOption("b", "The database throws a syntax error"),
                QuestionOption("c", "The `UPDATE` affects `2` rows"),
                QuestionOption("d", "The `version` column becomes negative")
            ),
            correctOptionId = "a",
            explanation = "If another transaction already incremented `version`, the `WHERE id = :id AND version = :expected_ver` predicate matches 0 rows."
        ),
        QuizQuestion(
            id = "sql_adv_77",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what happens when you compare two row constructors (tuple comparison) using `WHERE (a, b) > (10, 20)` in PostgreSQL / SQLite / MySQL?",
            options = listOf(
                QuestionOption("a", "It is equivalent to `a > 10 AND b > 20`"),
                QuestionOption("b", "It compares `a + b > 10 + 20`"),
                QuestionOption("c", "It is a syntax error in all databases"),
                QuestionOption("d", "It performs a lexicographical comparison equivalent to `a > 10 OR (a = 10 AND b > 20)`!")
            ),
            correctOptionId = "d",
            explanation = "Row-value comparison `(a, b) > (x, y)` compares `a` first and breaks ties with `b`, which matches composite B-tree index ordering for keyset pagination!"
        ),
        QuizQuestion(
            id = "sql_adv_78",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why is `WHERE a >= 10 AND (a > 10 OR b > 20)` (or `WHERE (a, b) > (10, 20)`) much more index-friendly on a composite index `(a, b)` than `WHERE a > 10 OR (a = 10 AND b > 20)` in simpler query planners?",
            options = listOf(
                QuestionOption("a", "Because `AND` is slower than `OR`"),
                QuestionOption("b", "They always produce identical plans in every engine"),
                QuestionOption("c", "Including the bounding predicate `a >= 10` (or native row-value `(a, b) > (10, 20)`) lets the planner immediately do a single index range scan starting at `(10, 20)` instead of struggling with top-level `OR` branches"),
                QuestionOption("d", "Because `>=` does not use the index")
            ),
            correctOptionId = "c",
            explanation = "Row-value syntax `(a, b) > (10, 20)` maps directly to composite B-tree key ordering."
        ),
        QuizQuestion(
            id = "sql_adv_79",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `COUNT(DISTINCT a, b)` or `COUNT(DISTINCT (a, b))` vs `COUNT(DISTINCT a)` do when `a` and `b` can be NULL?",
            options = listOf(
                QuestionOption("a", "It throws a division by zero error"),
                QuestionOption("b", "In composite distinct counting, a row is ignored if ANY of the arguments is NULL (or for a row constructor in PostgreSQL, when all fields are NULL); be careful with `COALESCE` or derived `SELECT COUNT(*) FROM (SELECT DISTINCT a, b FROM t)`!"),
                QuestionOption("c", "It returns the sum of `COUNT(DISTINCT a)` and `COUNT(DISTINCT b)`"),
                QuestionOption("d", "It counts only rows where `a = b`")
            ),
            correctOptionId = "b",
            explanation = "`SELECT COUNT(*) FROM (SELECT DISTINCT a, b FROM t) sub` is the portable ANSI way to count distinct `(a, b)` tuples including NULL combinations."
        ),
        QuizQuestion(
            id = "sql_adv_80",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what is the `Chasm Trap` vs `Fan Trap` in entity-relationship modeling?",
            options = listOf(
                QuestionOption("a", "A Fan Trap occurs when one master entity joins to two independent 1:N child entities (multiplying rows); a Chasm Trap occurs when a path between entities has an optional (partial) relationship where an `INNER JOIN` drops entities with no link"),
                QuestionOption("b", "They are two types of hardware disk failures"),
                QuestionOption("c", "A Fan Trap happens when CPU cooling fails during `GROUP BY`"),
                QuestionOption("d", "A Chasm Trap happens when a table has more than 100 columns")
            ),
            correctOptionId = "a",
            explanation = "Recognizing Fan Traps (use pre-aggregated subqueries) and Chasm Traps (use `LEFT JOIN` or union paths) prevents silent data loss or double-counting."
        ),
        QuizQuestion(
            id = "sql_adv_81",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Suppose table `nums(n INT)` has rows `1, 2, 3, 4, 5`. What does `SELECT n, SUM(n) OVER () AS total, SUM(n) OVER (ORDER BY n) AS running FROM nums;` return for `n = 2`?",
            options = listOf(
                QuestionOption("a", "`total = 3` and `running = 15`"),
                QuestionOption("b", "`total = 2` and `running = 2`"),
                QuestionOption("c", "`total = 15` and `running = 15`"),
                QuestionOption("d", "`total = 15` and `running = 3` (`1 + 2`)")
            ),
            correctOptionId = "d",
            explanation = "An empty `OVER ()` has an unbounded frame over the entire result set (`15`), while `OVER (ORDER BY n)` defaults to a cumulative frame up to the current value (`1 + 2 = 3`)."
        ),
        QuizQuestion(
            id = "sql_adv_82",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what does a `FILTER (WHERE condition)` clause attached to an aggregate function (e.g., `COUNT(*) FILTER (WHERE status = 'done')`, supported in SQL:2003, PostgreSQL, SQLite 3.30+) do?",
            options = listOf(
                QuestionOption("a", "Creates a partial index on `status`"),
                QuestionOption("b", "Removes duplicate values like `DISTINCT`"),
                QuestionOption("c", "Feeds only rows satisfying the `FILTER` condition into that specific aggregate function, providing a cleaner syntax than `CASE WHEN`"),
                QuestionOption("d", "Filters the entire query result set like a global `WHERE` clause")
            ),
            correctOptionId = "c",
            explanation = "Aggregate `FILTER (WHERE ...)` is standard SQL:2003 syntax supported by PostgreSQL and modern SQLite for conditional aggregation."
        ),
        QuizQuestion(
            id = "sql_adv_83",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Can the `FILTER (WHERE ...)` clause also be used with window aggregate functions in PostgreSQL and SQLite (e.g., `SUM(amount) FILTER (WHERE type = 'credit') OVER (PARTITION BY acct_id)`)?",
            options = listOf(
                QuestionOption("a", "It throws a runtime error"),
                QuestionOption("b", "Yes! It computes the window sum over only the rows in the window frame that match the `FILTER` condition"),
                QuestionOption("c", "No; `FILTER` cannot be combined with `OVER`"),
                QuestionOption("d", "Only if `GROUP BY` is also present")
            ),
            correctOptionId = "b",
            explanation = "Both PostgreSQL and SQLite 3.30+ support `FILTER (WHERE ...)` before `OVER (...)` on aggregate window functions."
        ),
        QuizQuestion(
            id = "sql_adv_84",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL window definitions, what is the purpose of the named `WINDOW w AS (PARTITION BY dept_id ORDER BY salary DESC)` clause placed after `HAVING`?",
            options = listOf(
                QuestionOption("a", "Allows multiple window functions in `SELECT` (`RANK() OVER w`, `AVG(salary) OVER w`) to reuse the same window specification without repeating it"),
                QuestionOption("b", "Creates a persistent GUI window in the database client"),
                QuestionOption("c", "Creates a materialized view named `w`"),
                QuestionOption("d", "Limits the query to 10 rows")
            ),
            correctOptionId = "a",
            explanation = "The `WINDOW` clause defines reusable named window specifications within a `SELECT` query."
        ),
        QuizQuestion(
            id = "sql_adv_85",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What happens if you use `UNION` (instead of `UNION ALL`) between two queries where the first query itself contains duplicate rows (`(1), (1)`) and the second query returns `(2)`?",
            options = listOf(
                QuestionOption("a", "`UNION` keeps `(1), (1)` because they came from the same query, and only deduplicates across the boundary"),
                QuestionOption("b", "`UNION` returns only `(1)`"),
                QuestionOption("c", "`UNION` raises an error"),
                QuestionOption("d", "`UNION` removes ALL duplicate rows across the entire combined result, including duplicates that originated within the first query alone (returning `1, 2`)!")
            ),
            correctOptionId = "d",
            explanation = "Set operator `UNION` deduplicates the entire resulting set, even if duplicates came from the same input branch."
        ),
        QuizQuestion(
            id = "sql_adv_86",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL set operations (`SELECT ... UNION SELECT ... INTERSECT SELECT ...`), which operator has higher precedence in standard ANSI SQL (and PostgreSQL)?",
            options = listOf(
                QuestionOption("a", "All set operators always have strictly equal left-to-right precedence in ANSI SQL"),
                QuestionOption("b", "`EXCEPT` always runs first"),
                QuestionOption("c", "`INTERSECT` has higher precedence than `UNION` and `EXCEPT` (so `A UNION B INTERSECT C` is evaluated as `A UNION (B INTERSECT C)`)"),
                QuestionOption("d", "`UNION` has higher precedence than `INTERSECT`")
            ),
            correctOptionId = "c",
            explanation = "Per ANSI SQL, `INTERSECT` binds tighter than `UNION` and `EXCEPT`; always use explicit parentheses when mixing set operators."
        ),
        QuizQuestion(
            id = "sql_adv_87",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL three-valued logic (`TRUE`, `FALSE`, `UNKNOWN`), what do `TRUE OR UNKNOWN` and `FALSE AND UNKNOWN` evaluate to?",
            options = listOf(
                QuestionOption("a", "Both raise a NULL pointer exception"),
                QuestionOption("b", "`TRUE OR UNKNOWN` is `TRUE`, and `FALSE AND UNKNOWN` is `FALSE`!"),
                QuestionOption("c", "Both evaluate to `UNKNOWN`"),
                QuestionOption("d", "`TRUE OR UNKNOWN` is `UNKNOWN`, and `FALSE AND UNKNOWN` is `TRUE`")
            ),
            correctOptionId = "b",
            explanation = "Because TRUE dominates OR regardless of the other operand, `TRUE OR UNKNOWN` is `TRUE`; because FALSE dominates AND, `FALSE AND UNKNOWN` is `FALSE`."
        ),
        QuizQuestion(
            id = "sql_adv_88",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What do `FALSE OR UNKNOWN` and `TRUE AND UNKNOWN` evaluate to in SQL three-valued logic?",
            options = listOf(
                QuestionOption("a", "Both evaluate to `UNKNOWN` (because the result depends on what the unknown value actually is)"),
                QuestionOption("b", "`FALSE` and `TRUE` respectively"),
                QuestionOption("c", "Both evaluate to `FALSE`"),
                QuestionOption("d", "Both evaluate to `TRUE`")
            ),
            correctOptionId = "a",
            explanation = "When the known operand does not short-circuit the boolean operator, combining with `UNKNOWN` yields `UNKNOWN`."
        ),
        QuizQuestion(
            id = "sql_adv_89",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What does `NOT UNKNOWN` evaluate to in SQL three-valued logic?",
            options = listOf(
                QuestionOption("a", "`TRUE`"),
                QuestionOption("b", "`FALSE`"),
                QuestionOption("c", "0"),
                QuestionOption("d", "`UNKNOWN`! (This is why `WHERE NOT (col = NULL)` is still `UNKNOWN` and returns 0 rows)")
            ),
            correctOptionId = "d",
            explanation = "Negating `UNKNOWN` remains `UNKNOWN` in Kleene three-valued logic."
        ),
        QuizQuestion(
            id = "sql_adv_90",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Why does `SELECT * FROM users WHERE age > 20 OR age <= 20;` NOT necessarily return every row in the `users` table?",
            options = listOf(
                QuestionOption("a", "Because `OR` is not allowed on integer columns"),
                QuestionOption("b", "It DOES always return every row regardless of NULLs"),
                QuestionOption("c", "Because rows where `age IS NULL` evaluate to `UNKNOWN OR UNKNOWN` = `UNKNOWN`, so they are excluded!"),
                QuestionOption("d", "Because `age = 20` is excluded by `> 20 OR <= 20`")
            ),
            correctOptionId = "c",
            explanation = "The law of the excluded middle (`P OR NOT P`) does not hold in three-valued logic when `age` is `NULL`."
        ),
        QuizQuestion(
            id = "sql_adv_91",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, how can you swap the values of two columns `col_a` and `col_b` in an `UPDATE` statement in standard SQL / PostgreSQL / SQLite?",
            options = listOf(
                QuestionOption("a", "Using `ALTER TABLE t RENAME`"),
                QuestionOption("b", "`UPDATE t SET col_a = col_b, col_b = col_a;` (because standard SQL evaluates `SET` expressions using the pre-update row values!)"),
                QuestionOption("c", "You must create a third temporary column first because `col_a = col_b` immediately overwrites `col_a` before `col_b = col_a` runs in ANSI SQL"),
                QuestionOption("d", "Using `SWAP(col_a, col_b)`")
            ),
            correctOptionId = "b",
            explanation = "In ANSI SQL (and PostgreSQL, SQLite, Oracle, SQL Server), all right-hand expressions in `SET` reference the original row values prior to the update! (Note: MySQL is the famous historical exception that evaluates `SET` left-to-right)."
        ),
        QuizQuestion(
            id = "sql_adv_92",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When designing a schema for hierarchical tree data (e.g., nested comments or categories), what is a major advantage of an `Adjacency List` (`parent_id` column) combined with a `Recursive CTE` over the `Nested Sets` (`lft, rgt`) model?",
            options = listOf(
                QuestionOption("a", "Inserting or moving a single node in an Adjacency List is an O(1) single-row write with referential integrity, whereas inserting a node in Nested Sets requires renumbering `lft`/`rgt` on up to half the table!"),
                QuestionOption("b", "Adjacency Lists do not support foreign keys"),
                QuestionOption("c", "Nested Sets cannot be queried with `SELECT`"),
                QuestionOption("d", "Adjacency Lists cannot have more than 2 levels of depth")
            ),
            correctOptionId = "a",
            explanation = "Modern SQL's `WITH RECURSIVE` makes Adjacency Lists practical to query while preserving fast O(1) localized writes and foreign key enforcement."
        ),
        QuizQuestion(
            id = "sql_adv_93",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "What is a `Materialized Path` (e.g., storing `path = '/1/4/19/'`) or `Closure Table` (`ancestor_id, descendant_id, depth`) pattern for trees in SQL?",
            options = listOf(
                QuestionOption("a", "Ways to encrypt database backups"),
                QuestionOption("b", "Join algorithms used by the query optimizer"),
                QuestionOption("c", "Isolation levels in ACID transactions"),
                QuestionOption("d", "Alternative hierarchical patterns that trade extra storage/write maintenance for fast subtree queries without recursion")
            ),
            correctOptionId = "d",
            explanation = "A Closure Table stores all ancestor-descendant pairs with a composite index, making subtree and ancestor queries simple indexed joins."
        ),
        QuizQuestion(
            id = "sql_adv_94",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQLite (and Android Room), why does batching 5,000 `INSERT` statements inside a single explicit transaction (`BEGIN TRANSACTION; ... COMMIT;`) run orders of magnitude faster than 5,000 autocommit inserts?",
            options = listOf(
                QuestionOption("a", "Because SQLite deletes the table before committing"),
                QuestionOption("b", "Because `BEGIN TRANSACTION` runs queries on the GPU"),
                QuestionOption("c", "Autocommit wraps every single `INSERT` in its own transaction, forcing thousands of synchronous disk flushes (`fsync`), whereas a single transaction flushes to disk once on `COMMIT`!"),
                QuestionOption("d", "Because transactions disable all data type checks")
            ),
            correctOptionId = "c",
            explanation = "Disk synchronization (`fsync`) at transaction commit is the dominant cost; batching writes into one transaction amortizes that cost across all 5,000 rows."
        ),
        QuizQuestion(
            id = "sql_adv_95",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL, what is a `Deferred Constraint` (`DEFERRABLE INITIALLY DEFERRED` in PostgreSQL / SQLite)?",
            options = listOf(
                QuestionOption("a", "A constraint that is dropped after 24 hours"),
                QuestionOption("b", "A constraint (such as a foreign key or unique constraint) that is checked at `COMMIT` time rather than immediately after each individual statement inside the transaction"),
                QuestionOption("c", "A constraint that is never checked"),
                QuestionOption("d", "A constraint that only runs on `SELECT` queries")
            ),
            correctOptionId = "b",
            explanation = "Deferred constraints allow circular foreign keys or multi-row key swaps (`UPDATE t SET seq = seq + 1`) to succeed cleanly at transaction commit."
        ),
        QuizQuestion(
            id = "sql_adv_96",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "Given a table `logs(id, status, updated_at)`, what is the difference between a `Row-Level Trigger` (`FOR EACH ROW`) and a `Statement-Level Trigger` (`FOR EACH STATEMENT`) when an `UPDATE` modifies 0 rows?",
            options = listOf(
                QuestionOption("a", "A `FOR EACH ROW` trigger fires 0 times when 0 rows are modified, whereas a `FOR EACH STATEMENT` trigger still fires once for the executed statement!"),
                QuestionOption("b", "Both fire 0 times"),
                QuestionOption("c", "Both fire once"),
                QuestionOption("d", "`FOR EACH ROW` fires once even when 0 rows match")
            ),
            correctOptionId = "a",
            explanation = "Row-level triggers fire once per affected row (0 times if no rows match); statement-level triggers fire once per SQL statement invocation."
        ),
        QuizQuestion(
            id = "sql_adv_97",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a `BEFORE UPDATE` row-level trigger (in PostgreSQL / SQLite / MySQL), what do the `OLD` and `NEW` pseudo-records represent?",
            options = listOf(
                QuestionOption("a", "`OLD` is the previous row in primary key order, and `NEW` is the next row"),
                QuestionOption("b", "`OLD` is the parent table and `NEW` is the child table"),
                QuestionOption("c", "They are aliases for `MIN` and `MAX`"),
                QuestionOption("d", "`OLD` holds the row's column values before the update, and `NEW` holds the proposed new column values after the update")
            ),
            correctOptionId = "d",
            explanation = "Inside update triggers, `OLD.col` accesses the prior value and `NEW.col` accesses the incoming value."
        ),
        QuizQuestion(
            id = "sql_adv_98",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In SQL analytics, what is a `Cohort Retention Query` typically structured around?",
            options = listOf(
                QuestionOption("a", "Deleting inactive users from the database"),
                QuestionOption("b", "Sorting users alphabetically by name"),
                QuestionOption("c", "Identifying each user's `first_activity_month` (cohort) via `MIN(activity_month)` per user, then joining user activity months and grouping by `(cohort_month, months_since_first)`"),
                QuestionOption("d", "Using `CROSS JOIN` on the `users` table without any dates")
            ),
            correctOptionId = "c",
            explanation = "Cohort analysis assigns each entity to its acquisition cohort (`MIN(date)`) and tracks active distinct entities across relative time offsets."
        ),
        QuizQuestion(
            id = "sql_adv_99",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "When computing `COUNT(DISTINCT user_id)` across multiple dimensions in massive analytical queries, why can it be a memory and performance bottleneck compared to `SUM` or `COUNT(*)`?",
            options = listOf(
                QuestionOption("a", "It is not; `COUNT(DISTINCT)` uses less memory than `COUNT(*)`"),
                QuestionOption("b", "`SUM` and `COUNT(*)` only require a single scalar accumulator per group, whereas exact `COUNT(DISTINCT)` must track the set of all unique values seen per group in memory or via sorting"),
                QuestionOption("c", "Because `DISTINCT` performs a network call"),
                QuestionOption("d", "Because `user_id` cannot be indexed")
            ),
            correctOptionId = "b",
            explanation = "Exact distinct counting requires hash sets or sorting per group (which is why analytical engines also offer approximate `HyperLogLog` functions for huge datasets)."
        ),
        QuizQuestion(
            id = "sql_adv_100",
            category = QuizCategory.SQL,
            difficulty = QuizDifficulty.ADVANCED,
            prompt = "In a query `SELECT dept_id, AVG(salary) FROM employees GROUP BY dept_id HAVING AVG(salary) > (SELECT AVG(salary) FROM employees);`, what does this query return?",
            options = listOf(
                QuestionOption("a", "Every department whose department average salary is strictly greater than the overall company-wide average salary"),
                QuestionOption("b", "Every employee whose salary is above their department average"),
                QuestionOption("c", "Only the single department with the maximum salary"),
                QuestionOption("d", "The average of the department averages")
            ),
            correctOptionId = "a",
            explanation = "The uncorrelated scalar subquery in `HAVING` computes the company-wide `AVG(salary)`, and `HAVING` filters for departments whose group average exceeds it."
        )
    )

}
