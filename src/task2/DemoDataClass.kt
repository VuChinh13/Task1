package task2

/**
 * Data Class
 * Singleton & Companion Object
 */

// Data class dùng để chứa dữ liệu người dùng
data class User(val id: Int, val name: String, val email: String) {
    companion object {
        fun createGuest(): User {
            return User(0, "Guest", "guest@example.com")
        }
    }
}

// Singleton object API: chỉ có 1 instance duy nhất của chương trình
object UserApi {
    private val users = listOf(
        User(1, "Alice", "alice@example.com"),
        User(2, "Bob", "bob@example.com"),
        User(3, "Charlie", "charlie@example.com")
    )

    fun fetchUsers(): List<User> = users
    fun findUserById(id: Int): User? = users.find { it.id == id }
}

fun main(args: Array<String>) {
    val guest = User.createGuest()
    println("User mặc định: $guest")
    println()

    val users = UserApi.fetchUsers()
    users.forEach { println(it) }
    println()

    val user = UserApi.findUserById(2)
    println(user ?: "Không tìm thấy user")
}