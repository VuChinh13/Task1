package task2

/**
 * Constructor (Primary & Secondary)
 */

// primary constructor + default
class Coupon(
    val code: String,
    val percent: Int = 5,
    val maxDiscount: Double = 100_000.0
) {
    var note: String = "—"

    // secondary constructor ủy quyền về primary
    constructor(code: String, note: String) : this(code, percent = 10, maxDiscount = 200_000.0) {
        this.note = note
    }

    fun describe(): String =
        "Coupon(code='$code', percent=$percent%, cap=${"%,.0f".format(maxDiscount)}, note='$note')"
}

fun main(args: Array<String>) {
    println("=== Constructors (Primary & Secondary) ===")
    val coupon1 = Coupon(code = "WELCOME")
    val coupon2 = Coupon(code = "SUPER10", note = "Sinh nhật khách hàng")
    println(coupon1.describe())
    println(coupon2.describe())
    println()
}

