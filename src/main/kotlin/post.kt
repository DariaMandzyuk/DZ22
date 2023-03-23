data class Likes(
    val count: Int
)

data class Post(
    var id: Int, val ownerId: Int, val text: String, val isFavorite: Boolean, val friendsOnly: Boolean,
    val date: Int, val createdBy: Int, val fromId: Int, val postType: String, val likes: Likes
)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId, likes = post.likes.copy())
        return posts.last()
    }

    fun update(post1: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post1.id == post.id) {
                posts[index] = post1.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }
}

fun main() {
    val post1 = Post(1, 1, "Hello", true, true, 13, 2, 1, "answer", Likes(10))
    val post2 = post1.copy(ownerId = post1.ownerId + 4)
    val post3 = post1.copy(text = post1.text + " World!")

    println(WallService.add(post1))
    println(WallService.add(post2))
    println(WallService.update(post3))
}



