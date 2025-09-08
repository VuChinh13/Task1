package task2

enum class Month(val days: Int) {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    fun isSummer(): Boolean {
        return this == JUNE || this == JULY || this == AUGUST
    }
}

fun main() {
    val currentMonth = Month.SEPTEMBER
    println("Tháng hiện tại: $currentMonth, số ngày: ${currentMonth.days}")
    println("Có phải mùa hè không? ${currentMonth.isSummer()}")

    println("\n--- Danh sách tháng ---")
    for (m in Month.values()) {
        println("${m.ordinal + 1}. $m có ${m.days} ngày")
    }

    println("\n--- Dùng when với enum ---")
    when (currentMonth) {
        Month.DECEMBER, Month.JANUARY, Month.FEBRUARY -> println("Mùa đông")
        Month.MARCH, Month.APRIL, Month.MAY -> println("Mùa xuân")
        Month.JUNE, Month.JULY, Month.AUGUST -> println("Mùa hè")
        Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER -> println("Mùa thu")
    }
}
