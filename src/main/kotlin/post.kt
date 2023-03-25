data class Post(
    var id: Int,
    val ownerId: Int,
    val text: String,
    val isFavorite: Boolean,
    val friendsOnly: Boolean,
    val date: Int,
    val createdBy: Int?,
    val fromId: Int,
    val postType: String,
    val likes: Int,
    val original: Post?,
    var attachmentArray: Array<Attachment>
)




