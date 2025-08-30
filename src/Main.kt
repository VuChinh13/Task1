fun main() {
    val rooms = mutableListOf<Room>()

    // khởi tạo dữ liệu mặc định
    rooms.add(Room(101, "Single", 300_000.0, "Trong"))
    rooms.add(Room(102, "Double", 450_000.0, "Trong"))
    rooms.add(Room(201, "VIP", 900_000.0, "Dang thue"))

    val bookings = mutableMapOf<Int, Pair<String, Int>>()

    while (true) {

        // Hiển thị Menu
        showMenu()

        val choice = readlnOrNull()?.toIntOrNull() ?: -1

        when (choice) {

            // Them phong
            1 -> {
                val room = readRoomFromInput()
                if (room == null) {
                    println("Nhap khong hop le.")
                    continue
                }
                if (addRoomIfNotExists(rooms, room)) {
                    println("Da them phong.")
                } else {
                    print("Phong da ton tai.")
                }
            }

            // Xoa phong
            2 -> {
                print("Nhap ID phong can xoa: ")
                val id = readlnOrNull()?.toIntOrNull() ?: returnUnit()
                val removed = rooms.removeIf { it.id == id }
                bookings.remove(id)
                if (removed) {
                    println("Da xoa phong.")
                } else {
                    println("Khong tim thay phong.")
                }
            }

            // Chinh sua thong tin phong
            3 -> {
                print("Nhap ID phong can sua: ")
                val roomId = readlnOrNull()?.toIntOrNull() ?: returnUnit()
                val updated = updateRoom(rooms, roomId)
                if (!updated) continue
            }

            // Hien thi danh sach phong
            4 -> {
                showRooms(rooms)
            }

            // Tim kiem phong
            5 -> {
                println("5.1 Tim theo ID | 5.2 Tim theo loai | 5.3 Tim theo khoang gia")
                print("Chon 5.1/5.2/5.3: ")

                when (readlnOrNull()) {
                    "5.1" -> searchRoomById(rooms)
                    "5.2" -> searchRoomByType(rooms)
                    "5.3" -> searchRoomByPrice(rooms)
                    else -> println("Lua chon khong hop le.")
                }

            }

            // Dat Phong
            6 -> {
                bookRoom(rooms, bookings)
            }

            // Tra phong
            7 -> {
                returnBookedRoom(rooms, bookings)
            }

            // Sap xep
            8 -> {
                println("8.1 Tang dan | 8.2 Giam dan")
                print("Chon: ")
                when (readlnOrNull()) {
                    "8.1" -> showRooms(rooms.sortedBy { it.price })
                    "8.2" -> showRooms(rooms.sortedByDescending { it.price })
                    else -> println("Lua chon khong hop le.")
                }
            }

            // Loc phong
            9 -> {
                println("9.1 Chi hien phong Trong | 9.2 Chi hien phong Dang thue")
                print("Chon: ")
                when (readlnOrNull()) {
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

private fun showMenu() {
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
}

private fun readRoomFromInput(): Room? {
    print("Nhap ID phong: ")
    val id = readlnOrNull()?.toIntOrNull() ?: return null

    print("Nhap loai phong: ")
    val type = readlnOrNull().orEmpty()

    print("Nhap gia phong: ")
    val price = readlnOrNull()?.toDoubleOrNull() ?: return null

    print("Nhap tinh trang (Trong/Dang thue): ")
    val status = readlnOrNull().orEmpty()

    return Room(id, type, price, status)
}

private fun addRoomIfNotExists(rooms: MutableList<Room>, room: Room): Boolean {
    if (rooms.any { it.id == room.id }) return false
    rooms.add(room)
    return true
}

// demo for (collection)
private fun updateRoom(rooms: MutableList<Room>, roomId: Int): Boolean {
    var roomToUpdate: Room? = null
    for (room in rooms) {
        if (room.id == roomId) {
            roomToUpdate = room
            break
        }
    }

    if (roomToUpdate == null) {
        println("Khong tim thay phong.")
        return false
    }

    print("Loai phong moi (${roomToUpdate.type}): ")
    val newType = readlnOrNull().orEmpty()

    print("Gia phong moi (${roomToUpdate.price}): ")
    val priceInput = readlnOrNull()
    val newPrice = priceInput?.toDoubleOrNull()

    print("Tinh trang moi (${roomToUpdate.status}): ")
    val newStatus = readlnOrNull().orEmpty()

    if (newType.isNotBlank()) roomToUpdate.type = newType
    if (newPrice != null) roomToUpdate.price = newPrice
    if (newStatus.isNotBlank()) roomToUpdate.status = newStatus

    println("Da cap nhat phong.")
    return true
}


// demo for (until)
private fun findRoomByIdUsingUntil(rooms: List<Room>, targetId: Int): Room? {
    var result: Room? = null
    for (index in 0 until rooms.size) {
        val currentRoom = rooms[index]
        if (currentRoom.id == targetId) {
            result = currentRoom
            break
        }
    }
    return result
}


private fun searchRoomById(rooms: List<Room>) {
    print("Nhap ID: ")
    val roomId = readlnOrNull()?.toIntOrNull() ?: returnUnit()

    val foundRoom = findRoomByIdUsingUntil(rooms, roomId)
    if (foundRoom == null) {
        println("Khong tim thay.")
    } else {
        showRooms(listOf(foundRoom))
    }
}


private fun searchRoomByType(rooms: List<Room>) {
    // demo for (step)
    print("Nhap loai (vd: Single): ")
    val typeQuery = readlnOrNull().orEmpty()
    val roomFilter = mutableListOf<Room>()
    for (i in 0..<rooms.size step 1) {
        if (rooms[i].type == typeQuery) {
            roomFilter.add(rooms[i])
        }
    }
    showRooms(roomFilter)
}


private fun searchRoomByPrice(rooms: List<Room>) {
    // demo for (indices)
    print("Gia tu: ")
    val minPrice = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Den: ")
    val maxPrice = readlnOrNull()?.toDoubleOrNull() ?: Double.MAX_VALUE

    val roomFilter = mutableListOf<Room>()
    for (i in rooms.indices) {
        if (rooms[i].price in minPrice..maxPrice) {
            roomFilter.add(rooms[i])
        }
    }
    showRooms(roomFilter)
}


private fun getRoomToBook(rooms: List<Room>): Room? {
    print("Nhap ID phong can dat: ")
    val roomId = readlnOrNull()?.toIntOrNull() ?: return null

    val room = rooms.find { it.id == roomId }
    if (room == null) {
        println("Khong tim thay phong.")
        return null
    }

    if (room.status != "Trong") {
        println("Phong khong trong.")
        return null
    }

    return room
}


private fun getBookingInfo(): Pair<String, Int> {
    print("Ten khach: ")
    val name = readlnOrNull().orEmpty()
    print("So dem: ")
    val nights = readlnOrNull()?.toIntOrNull() ?: 1
    return name to nights
}


private fun bookRoom(rooms: MutableList<Room>, bookings: MutableMap<Int, Pair<String, Int>>) {
    val roomToBook = getRoomToBook(rooms) ?: return
    val (name, nights) = getBookingInfo()

    roomToBook.status = "Dang thue"
    bookings[roomToBook.id] = name to nights
    println("Da dat phong cho $name, $nights dem.")
}


private fun getRoomToReturn(rooms: List<Room>): Room? {
    print("Nhap ID phong tra: ")
    val roomId = readlnOrNull()?.toIntOrNull() ?: return null

    val room = rooms.find { it.id == roomId }
    if (room == null) {
        println("Khong tim thay phong.")
        return null
    }

    if (room.status != "Dang thue") {
        println("Phong khong o trang thai Dang thue.")
        return null
    }

    return room
}

private fun returnRoom(room: Room, bookings: MutableMap<Int, Pair<String, Int>>) {
    val info = bookings[room.id]
    val nights = info?.second ?: 1
    val total = room.price * nights
    println("Tien tam tinh: $total")

    room.status = "Trong"
    bookings.remove(room.id)
    println("Da tra phong.")
}

private fun returnBookedRoom(rooms: MutableList<Room>, bookings: MutableMap<Int, Pair<String, Int>>) {
    val roomToReturn = getRoomToReturn(rooms) ?: return
    returnRoom(roomToReturn, bookings)
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
