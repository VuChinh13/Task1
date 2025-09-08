package task2

/**
 * 1) Nullable (?) vs Non-nullable
 * 2) Safe Call (?.)
 * 3) Elvis Operator (?:)
 * 4) Not-null Assertion (!!)
 */

fun main(args: Array<String>) {
    demoNullableVsNonNull()
    demoSafeCall()
    demoElvis()
    demoNotNullAssertion()
}

// Nullable (?) và Non-nullable
fun demoNullableVsNonNull() {
    println("=== Nullable vs Non-nullable ===")
    val nonNull: String = "Kotlin"
    println("Non-null string: $nonNull (length = ${nonNull.length})")

    var nullable: String? = null
    println("Nullable ban đầu: $nullable")
    println()
}

// Safe Call (?.)
fun demoSafeCall() {
    println("=== Safe Call (?.) ===")
    var nullable: String? = null
    println("Độ dài nullable (safe call): ${nullable?.length}")  // null

    nullable = "hello world"
    println("Nullable sau khi gán: $nullable")
    println("Độ dài nullable (safe call): ${nullable?.length}")  // 11
    println("Uppercase (safe call): ${nullable?.uppercase()}")   // HELLO WORLD
    println()
}

// Elvis Operator (?:)
fun demoElvis() {
    println("=== Elvis Operator (?:) ===")
    val nullable: String? = null
    val lengthOrZero = nullable?.length ?: 0
    println("Độ dài với Elvis: $lengthOrZero")
    println()
}

// Not-null Assertion (!!)
fun demoNotNullAssertion() {
    println("=== Not-null Assertion (!!) ===")
    val nullable: String? = null
    try {
        println("Thử dùng '!!' trên null: ${nullable!!.length}")
    } catch (e: NullPointerException) {
        println("Bị crash do dùng '!!' trên null: ${e::class.simpleName}")
    }
    println()
}
