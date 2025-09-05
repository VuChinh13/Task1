package task1

fun main() {
    demoVariable()
    demoDatatype()
    demoOperator()
    demoConversion()
    demoString()
    demoWhenAndWhile()
    demoFor()
    demoList()
    demoMap()
    demoSet()
    demoCollectionExtensionFunction()
}

// demo variable
fun demoVariable() {
    //var - mutable
    var valueVar = 0
    valueVar = 1
    print("Value of var: $valueVar")

    //val - immutable
    val valueVal = 2
    print("Value of val: $valueVal")
}

// demo data type
fun demoDatatype() {
    val valueInt: Int = 2
    println(valueInt)

    val valueFloat: Float = 3.8f
    println(valueFloat)

    val valueBoolean: Boolean = true
    println(valueBoolean)

    val valueString: String = "string"
    println(valueString)

    val valueChar: Char = 'c'
    println(valueChar)

    val valueDouble: Double = 2.1
    println(valueDouble)

    val valueLong: Long = 20000000
    println(valueLong)
}

// demo operator
fun demoOperator() {
    val value1 = 10
    val value2 = 20

    println("Operator + : ${value1 + value2}")
    println("Operator - : ${value2 - value1}")
    println("Operator * : ${value1 * value2}")
    println("Operator / : ${value1 / value2}")
    println("Operator % : ${value1 % value2}")

    var value3 = 0
    value3 += value1
    println("Operator += : ${value3}")

    value3 -= value1
    println("Operator -= : ${value3}")

    println("Operator == : ${value1 == value2}")

    println("Operator != : ${value1 == value2}")

    println("Operator > : ${value1 > value2}")

    println("Operator < : ${value1 < value2}")

    println("Operator && : ${value1 == 10 && value2 == 20}")

    println("Operator || : ${value1 == 10 || value2 == 20}")
}

// demo Conversion
fun demoConversion() {
    var valueDouble = 2.32323

    val valueInt = valueDouble.toInt()
    println("to Int(): $valueInt")

    val valueString = valueDouble.toString()
    println("to String(): $valueString")

    valueDouble = valueInt.toDouble()
    println("to Double(): $valueDouble")

    val valueLong = valueDouble.toLong()
    println("to Long(): $valueLong")
}

// demo String and String template
fun demoString() {
    val valueString = " Demo string"

    println("length: ${valueString.length}")
    println("substring: ${valueString.take(4)}")
    println("startsWith : ${valueString.startsWith("Demo")}")
    println("endsWith: ${valueString.endsWith("h")}")
    println("toUpperCase: ${valueString.uppercase()}")
    println("toLowerCase: ${valueString.lowercase()}")

    val value1 = 10
    val value2 = 10
    println("Sum $value1 and $value2 : ${value1 + value2}")
}

fun demoWhenAndWhile() {
    while (true) {
        print("Enter value: ")
        val value = readlnOrNull()?.toIntOrNull() ?: 0
        when (value) {
            1 -> {
                println("Value is 1")
            }

            in 2..3 -> {
                println("Between 2 and 3")
            }

            0 -> {
                println("Exit")
                break
            }

            else -> {
                println("Something else")
            }

        }
    }
}

fun demoFor() {
    // until
    for (i in 0 until 4) {
        print("$i, ")
    }
    println()

    // downTo
    for (i in 4 downTo 0) {
        print("$i, ")
    }
    println()

    // until
    for (i in 2..6 step 2) {
        print("$i, ")
    }
    println()

    // for in list
    val list = mutableListOf<Int>(2, 3, 4, 5, 6)
    for (i in list) {
        print("$i, ")
    }

    // indices
    for (i in list.indices) {
        print("$i, ")
    }
}

fun demoList() {
    // immutable List
    val immutableList = listOf<Int>()

    // mutable List
    val mutableList = mutableListOf<Int>()
    mutableList.add(1)
    mutableList.add(2)
    mutableList.removeAt(0)
    println("size: $mutableList.size")
    println("get: ${mutableList.get(0)}")
    mutableList.clear()
}

fun demoMap() {
    // immutable Map
    val immutableMap = mapOf<String, String>()

    // mutable Map
    val mutableMap = mutableMapOf<String, String>(
        "No1" to "Content1",
        "No2" to "Content2",
        "No3" to "Content3"
    )
    mutableMap["No4"] = "Content4"
    mutableMap.remove("No4")
}

fun demoSet() {
    // immutable Set
    val immutableSet = setOf<String>()

    // mutable Set
    val mutableSet = mutableSetOf<String>()
    mutableSet.add("No1")
    mutableSet.add("No2")
    mutableSet.add("No3")

    mutableSet.remove("No3")
    println("last: $mutableSet.last()")
}

fun demoCollectionExtensionFunction() {
    val list = mutableListOf<Int>(1, 2, 3, 4)

    val list1 = list.map { it * 2 }
    println(list1)

    val list2 = list.filter { it % 2 == 0 }
    println(list2)

    val value = list.any { it % 2 == 0 }
    println(value)

    val list3 = list.take(3)
    println(list3)

    val first = list.first()
    println(first)

    val last = list.last()
    println(last)

    val sort1 = list.sortBy { it }
    println(sort1)

    val sort2 = list.sortedByDescending { it }
    println(sort2)

    val sum = list.reduce { acc, next -> acc + next }
    println(sum)
}



