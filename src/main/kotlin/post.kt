data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comment: Comment,
    val likes: Likes?,
    val reposts: Reposts?,
    val postType: String,
    val postSource: PostSourse?,
    val geo: Geo?,
    val signerId: Int,
    val copyHistory: Array<CopyHistory>?,
    val canPin: Int,
    val canDelete: Int,
    val canEdit: Int?,
    val isPinned: Int,
    val markedAsAds: Int,
    val isFavorite: Boolean,
)




