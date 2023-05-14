interface Attachment {
    val type: String
}

data class AudioAttachment(
    override val type: String = "Audio",
    val audio: Audio
) : Attachment

data class Audio(
    val id: Int = 1,
    val ownerId: Int = 1,
    val artist: String = "La-La-La",
    val title: String = "100"
)

data class VideoAttachment(
    override val type: String = "Video",
    val video: Video
) : Attachment

data class Video(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String = "A Funny Video",
    val duration: Int = 30
)

data class PhotoAttachment(
    override val type: String = "Photo",
    val photo: Photo
) : Attachment

data class Photo(
    val id: Int = 1,
    val ownerId: Int = 1,
    val photo130: String = "https://vk.com/some_photo_link",
    val photo604: String = "https://vk.com/another_photo_link"
)

data class DocumentAttachment(
    override val type: String = "Document",
    val document: Document
) : Attachment

data class Document(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String = "Doc",
    val size: Int = 600,
    val ext: String = "txt"
)

data class AttachedLink(
    override val type: String = "Attached Link",
    val attachedLink: Link
) : Attachment

data class Link(
    val url: String = "ssilka",
    val title: String = "title",
    val caption: String = "Kaption",
    val description: String = "opisanie"
)

