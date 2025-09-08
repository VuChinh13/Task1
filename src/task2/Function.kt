package task2

import kotlin.math.sqrt

/**
 * 1) Hàm thông thường
 * 2) Hàm 1 dòng
 * 3) Default Parameter & Named Parameter
 * 4) Extention function
 * 5) Lambda function & Higher - order function
 */

fun main(args: Array<String>) {
    // 1) Demo hàm thông thường
    println("Có phải số nguyên tố không: ${isPrime(2)}")

    // 2) Demo hàm 1 dòng
    println("Tổng của 2 số là: ${sum(1, 2)}")

    // 3) Demo default parameter
    sendNotification("Bạn có tin nhắn mới!")

    // 3) Demo Named Parameter
    sendNotification(message = "Bạn có tin nhắn mới!", isImportant = true)

    // 4) Demo extension function
    val phone1 = "0985674536"
    println("Số điện thoại là : ${phone1.maskPhone()}")

    // 5) Demo Lambda function & Higher - order function
    val sum = operate(5, 3) { a, b -> a + b }
    println("Tổng: $sum")

    val max = operate(5, 3) { a, b -> if (a > b) a else b }
    println("Số lớn hơn: $max")
}

// Hàm thông thường - kiểm tra xem số nhập vào có phải số nguyên tố không
fun isPrime(value: Int): Boolean {
    if (value < 2) return false
    for (i in 2..sqrt(value.toDouble()).toInt()) {
        if (value % i == 0) return false
    }
    return true
}

// Hàm 1 dòng
fun sum(value1: Int, value2: Int) = value1 + value2

// Default Parameter
fun sendNotification(message: String, title: String = "Thông báo", isImportant: Boolean = false) {
    val tag = if (isImportant) "[!!!]" else ""
    println("$title $tag: $message")
}

// Extension function
// Hàm này dùng để ẩn số điện thoại chỉ hiển thị 3 số đầu và 2 số cuối
fun String.maskPhone(): String {
    val start = this.take(3)
    val end = this.takeLast(2)
    val hidden = "*".repeat(this.length - 5)

    return start + hidden + end
}

// Lambda function & Higher - order function
fun operate(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}



