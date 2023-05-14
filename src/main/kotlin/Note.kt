data class Note(
    var id: Int,
    val ownerId: Int,
    var title: String = "Заметка1",
    var text: String = "Заметки бывают разные",
    val date: Int = 4,
    val commentsNumber: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String = "Урл",
    val privacyView: String = "Прайваси",
    val canComment: Int = 0,
    val textWiki: String = "Вики",
    var comments: MutableList<Comment> = mutableListOf(),
    var isDeleted: Boolean = false
)