package task2

/**
 * Class & Object
 */

class Product(
    var name: String,
    var price: Double,
    var count: Int
) {

    // Phương thức tính tổng tiền
    fun totalPrice(): Double {
        return price * count
    }

    // Phương thức giảm giá theo %
    fun discount(percent: Double): Double {
        return totalPrice() * (1 - percent / 100)
    }


    // Phương thức nhập thêm hàng
    fun addStock(quantity: Int) {
        count += quantity
    }

    // Phương thức hiển thị thông tin sản phẩm
    fun showInfo() {
        println("Tên sản phẩm: $name")
        println("Giá: $price")
        println("Số lượng: $count")
        println("Tổng tiền: ${totalPrice()}")
    }
}

fun main() {
    val product = Product("Tai nghe Bluetooth", 399_000.0, 2)

    product.showInfo()

    println("Sau khi giảm giá 10%: ${product.discount(10.0)}")

    product.addStock(3)
    println("Sau khi nhập thêm: ${product.count}")

}
