data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int = 1,
    val text: String = "String",
    val donut: Donut? = null,
    val replyToUser: Int = 1,
    val replyToComment: Int = 1,
    val attachments: Array<Attachment> = emptyArray(),
    val parentsStack: Array<Int> = emptyArray(),
    val threadComments: ThreadComments? = null
)

data class ThreadComments(
    val count: Int,
    val items: Array<Comment>,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)

data class Donut(
    val isDon: Boolean,
    val placeHolder: String
)

data class ParentsStack(
    val parentsID: Int
)
 data class Items(
   val Items: Array<Comment>
 )