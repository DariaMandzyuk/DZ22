interface Attachment {
    val type: String
}

class AudioAttachment(
    override val type: String = "Audio",
    val audio: Audio
) : Attachment

class Audio(
    val id: Int = 1,
    val ownerId: Int = 1,
    val artist: String = "La-La-La",
    val title: String = "100"
)

class VideoAttachment(
    override val type: String = "Video",
    val video: Video
) : Attachment

class Video(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String = "A Funny Video",
    val duration: Int = 30
)

class PhotoAttachment(
    override val type: String = "Photo",
    val photo: Photo
) : Attachment

class Photo(
    val id: Int = 1,
    val ownerId: Int = 1,
    val photo130: String = "https://vk.com/some_photo_link",
    val photo604: String = "https://vk.com/another_photo_link"
)

class DocumentAttachment(
    override val type: String = "Document",
    val document: Document
) : Attachment

class Document(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String = "Doc",
    val size: Int = 600,
    val ext: String = "txt"
)

class AttachedLink(
    override val type: String = "Attached Link",
    val attachedLink: Link
) : Attachment

class Link(
    val url: String = "ssilka",
    val title: String = "title",
    val caption: String = "Kaption",
    val description: String = "opisanie"
)

