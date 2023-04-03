object WallService {
    private var posts = emptyArray<Post>()
    private var commentMassive = emptyArray<Comment>()
    private var lastId = 0

    fun findById(id: Int): Post? {
        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        return null
    }

    fun createComment(postId: Int, commentVneshnii: Comment): Comment {
        val post = findById(postId)
        if (post != null) {
            commentMassive += commentVneshnii
            return commentMassive.last()
        } else {
            throw PostNotFoundException()
        }

    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }

    fun update(post1: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post1.id == post.id) {
                posts[index] = post1.copy()
                return true
            }
        }
        return false
    }
}