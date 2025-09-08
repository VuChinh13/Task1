package task2

/**
 * Kế thừa (open class, override)
 * Interface & Abstract Class
 */

// Interface quy định các lớp con có thể vẽ
interface Drawable {
    fun draw()
}

// Abstract là khuôn mẫu cho các hinh học
abstract class Shape(val name: String) : Drawable {
    abstract fun area(): Double
    abstract fun perimeter(): Double

    open fun showInfor() {
        println("Hình: $name")
        println("Diện tích: ${area()}")
        println("Chu vi: ${perimeter()}")
    }
}

// Lớp con: Hình chữ nhật
class Rectangle(val with: Double, val height: Double) : Shape("Hình chữ nhật") {
    override fun area(): Double = with * height
    override fun perimeter(): Double = 2 * (with + height)
    override fun draw() {
        println("Vẽ hình chữ nhật bán kính $with x $height")
    }
}


// Lớp con: Hình tròn
class Circle(val radius: Double) : Shape("Hình tròn") {
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
    override fun draw() {
        println("Vẽ hình tròn bán kính $radius")
    }
}

fun main() {
    val shapes: List<Shape> = listOf(
        Rectangle(5.0, 3.0),
        Circle(4.0)
    )

    println("=== Thông tin và vẽ các hình ===")
    for (s in shapes) {
        s.showInfor()
        s.draw()
        println()
    }
}