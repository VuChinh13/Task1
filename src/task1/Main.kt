package task1

fun main() {
    demoVariable()
    demoDatatype()
    demoOperator()
    demoConversion()
    demoString()
    demoWhenAndWhile()
    demoFor()
    demoScopeFunctions()
    demoList()
    demoMap()
    demoSet()
    demoCollectionExtensionFunction()
    collectionPipelineDemo()
}

// demo variable
fun demoVariable() {
    println("===== Demo Variable =====")
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
    println("===== Data type =====")
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
    println("===== Demo Operator =====")
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
    println("===== Demo Conversion =====")
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
    println("===== Demo String =====")
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
    println("===== Demo WhenAndWhile =====")
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
    println("===== Demo For =====")
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
    println("===== Demo List =====")
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
    println("===== Demo Map =====")
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
    println("last: $mutableMap.last()")
}

fun demoSet() {
    println("===== Demo Set =====")
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
    println("===== Demo Collection Extension Function =====")
    val list = mutableListOf(1, 2, 3, 4)

    val list1 = list.map { it * 2 }
    println("map: $list1")

    val list2 = list.filter { it % 2 == 0 }
    println("filter: $list2")

    val value = list.any { it % 2 == 0 }
    println("any (có số chẵn?): $value")

    val list3 = list.take(3)
    println("take(3): $list3")

    val first = list.first()
    println("first: $first")

    val last = list.last()
    println("last: $last")

    list.sortBy { it }         // sắp xếp tại chỗ
    println("sau sortBy: $list") // in ra list đã được sắp xếp

    val sort2 = list.sortedByDescending { it }
    println("sortedByDescending: $sort2")

    val sum = list.reduce { acc, next -> acc + next }
    println("reduce (sum): $sum")

    println("all > 0: ${list.all { it > 0 }}")

    println("none < 0: ${list.none { it < 0 }}")
}


fun collectionPipelineDemo() {
    println("===== Demo Collection Pipe =====")
    val list = mutableListOf(1, 2, 3, 4, 5, 6)

    // Lọc số chẵn → nhân 2 → sắp xếp giảm dần → lấy 3 phần tử đầu → tính tổng
    val sumTop3 = list
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .sortedDescending()
        .take(3)
        .sum()
    println("Sum top3 even*2: $sumTop3")

    // Lọc số lẻ → nhân 3 → distinct → groupBy theo (n % 3)
    val groupedOdds = list
        .filter { it % 2 == 1 }
        .map { it * 3 }
        .distinct()
        .groupBy { it % 3 }
    println("Grouped odds*3 by mod 3: $groupedOdds")
}


fun demoScopeFunctions() {
    println("===== Demo Scope Functions =====")

    val str = "hello"

    // let
    str.let {
        println("let: length of '$it' is ${it.length}")
    }

    // run
    val resultRun = str.run {
        length + 10
    }
    println("run: $resultRun")

    // apply
    val list = mutableListOf<Int>().apply {
        add(1)
        add(2)
        add(3)
    }
    println("apply: $list")

    // also
    val doubled = list.also {
        println("also: before map $it")
    }.map { it * 2 }
    println("also: after map $doubled")

    // with
    val sb = StringBuilder()
    val message = with(sb) {
        append("Kotlin ")
        append("Scope ")
        append("Functions")
        toString()
    }
    println("with: $message")
}


