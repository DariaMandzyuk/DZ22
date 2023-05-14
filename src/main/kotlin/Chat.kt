data class Chat(
    var id: Int,
    var userId: Int,
    var isDeleted: Boolean = false,
    var isRead: Boolean = false,
    var messages: List<Message> = mutableListOf(),
)