package task2


sealed class ApiState {
    object Loading : ApiState()
    data class Success(val data: List<String>) : ApiState()
    data class Error(val error: String) : ApiState()
}

// Hàm giả lập khi gọi API
fun fetchData(success: Boolean): ApiState {
    if (success) {
        return ApiState.Success(listOf("Người dùng 1", "Người dùng 2", "Người dùng 3", "Người dùng 4"))
    } else {
        return ApiState.Error("Đã xảy ra lỗi không thể nào kết nối")
    }
}

// Giả xử trường hợp nếu mà có UI rồi mà cho hiển thị lên trên UI
fun renderUI(state: ApiState) {
    when (state) {
        is ApiState.Loading -> println("Dữ liệu đang được tải")
        is ApiState.Success -> println("Tải dữ liệu thành công: ${state.data}")
        is ApiState.Error -> println(state.error)
    }
}

fun main(args: Array<String>) {
    renderUI(ApiState.Loading)

    val successState = fetchData(true)
    renderUI(successState)

    val errorState = fetchData(false)
    renderUI(errorState)
}

