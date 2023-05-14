data class Message (
    val id: Int,
    val chatId: Int,
    val date: Int = 1,
    var text: String = "Текст",
    var isRead: Boolean = false,
    var isDeleted: Boolean = false,
    var incoming: Boolean = false,
    var outgoing: Boolean = false
)