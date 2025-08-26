fun main() {
    val rooms = mutableListOf<Room>()
    rooms.add(Room(101, "Single", 300_000.0, "Trong"))
    rooms.add(Room(102, "Double", 450_000.0, "Trong"))
    rooms.add(Room(201, "VIP", 900_000.0, "Dang thue"))

    val bookings = mutableMapOf<Int, Pair<String, Int>>()

    while (true) {
        println("===== QUAN LY KHACH SAN =====")
        println("1. Them phong")
        println("2. Xoa phong")
        println("3. Chinh sua thong tin phong")
        println("4. Hien thi danh sach phong")
        println("5. Tim kiem phong")
        println("6. Dat phong (Check-in)")
        println("7. Tra phong (Check-out)")
        println("8. Sap xep theo gia")
        println("9. Loc theo tinh trang")
        println("0. Thoat")
        print("Moi chon chuc nang: ")

        val choice = readLine()?.toIntOrNull() ?: -1
        when (choice) {
            1 -> {
                print("Nhap ID phong: ");
                val id = readLine()?.toIntOrNull() ?: returnUnit()
                if (rooms.any { it.id == id }) {
                    println("ID da ton tai."); continue
                }
                print("Nhap loai phong: ");
                val type = readLine().orEmpty()
                print("Nhap gia phong: ");
                val price = readLine()?.toDoubleOrNull() ?: 0.0
                print("Nhap tinh trang (Trong/Dang thue): ");
                val status = readLine().orEmpty()
                rooms.add(Room(id, type, price, status))
                println("Da them phong.")
            }

            2 -> {
                print("Nhap ID phong can xoa: ");
                val id = readLine()?.toIntOrNull() ?: returnUnit()
                val removed = rooms.removeIf { it.id == id }
                bookings.remove(id)
                println(if (removed) "Da xoa phong." else "Khong tim thay phong.")
            }

            3 -> {
                print("Nhap ID phong can sua: ");
                val id = readLine()?.toIntOrNull() ?: returnUnit()
                val r = rooms.find { it.id == id }
                if (r == null) {
                    println("Khong tim thay phong."); continue
                }
                print("Loai phong moi (${r.type}): ");
                val t = readLine().orEmpty()
                print("Gia phong moi (${r.price}): ");
                val pIn = readLine();
                val p = pIn?.toDoubleOrNull()
                print("Tinh trang moi (${r.status}): ");
                val s = readLine().orEmpty()
                if (t.isNotBlank()) r.type = t
                if (p != null) r.price = p
                if (s.isNotBlank()) r.status = s
                println("Da cap nhat.")
            }

            4 -> {
                showRooms(rooms)
            }

            5 -> {
                println("5.1 Tim theo ID | 5.2 Tim theo loai | 5.3 Tim theo khoang gia")
                print("Chon 5.1/5.2/5.3: ")
                when (readLine()) {
                    "5.1" -> {
                        print("Nhap ID: ");
                        val id = readLine()?.toIntOrNull() ?: returnUnit()
                        val r = rooms.find { it.id == id }
                        if (r == null) println("Khong tim thay.")
                        else showRooms(listOf(r))
                    }

                    "5.2" -> {
                        print("Nhap loai (vd: Single): ");
                        val t = readLine().orEmpty()
                        showRooms(rooms.filter { it.type.equals(t, ignoreCase = true) })
                    }

                    "5.3" -> {
                        print("Gia tu: ");
                        val from = readLine()?.toDoubleOrNull() ?: 0.0
                        print("Den: ");
                        val to = readLine()?.toDoubleOrNull() ?: Double.MAX_VALUE
                        showRooms(rooms.filter { it.price in from..to })
                    }

                    else -> println("Lua chon khong hop le.")
                }
            }

            6 -> {
                print("Nhap ID phong can dat: ");
                val id = readLine()?.toIntOrNull() ?: returnUnit()
                val r = rooms.find { it.id == id }
                if (r == null) {
                    println("Khong tim thay phong."); continue
                }
                if (r.status != "Trong") {
                    println("Phong khong trong."); continue
                }
                print("Ten khach: ");
                val name = readLine().orEmpty()
                print("So dem: ");
                val nights = readLine()?.toIntOrNull() ?: 1
                r.status = "Dang thue"
                bookings[id] = name to nights
                println("Da dat phong cho $name, $nights dem.")
            }

            7 -> {
                print("Nhap ID phong tra: ");
                val id = readLine()?.toIntOrNull() ?: returnUnit()
                val r = rooms.find { it.id == id }
                if (r == null) {
                    println("Khong tim thay phong."); continue
                }
                if (r.status != "Dang thue") {
                    println("Phong khong o trang thai Dang thue."); continue
                }
                val info = bookings[id]
                val nights = info?.second ?: 1
                val total = r.price * nights
                println("Tien tam tinh: $total")
                r.status = "Trong"
                bookings.remove(id)
                println("Da tra phong.")
            }

            8 -> {
                println("8.1 Tang dan | 8.2 Giam dan")
                print("Chon: ")
                when (readLine()) {
                    "8.1" -> showRooms(rooms.sortedBy { it.price })
                    "8.2" -> showRooms(rooms.sortedByDescending { it.price })
                    else -> println("Lua chon khong hop le.")
                }
            }

            9 -> {
                println("9.1 Chi hien phong Trong | 9.2 Chi hien phong Dang thue")
                print("Chon: ")
                when (readLine()) {
                    "9.1" -> showRooms(rooms.filter { it.status == "Trong" })
                    "9.2" -> showRooms(rooms.filter { it.status == "Dang thue" })
                    else -> println("Lua chon khong hop le.")
                }
            }

            0 -> {
                println("Thoat chuong trinh.")
                break
            }

            else -> println("Lua chon khong hop le.")
        }
        println()
    }
}

private fun showRooms(list: List<Room>) {
    if (list.isEmpty()) {
        println("Khong co du lieu.")
        return
    }
    println("ID | Loai     | Gia       | Tinh trang")
    list.forEach { println("${it.id} | ${it.type} | ${"%.2f".format(it.price)} | ${it.status}") }
}

private fun returnUnit(): Int {
    println("Nhap khong hop le.")
    return 0
}
