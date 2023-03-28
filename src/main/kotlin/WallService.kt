object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

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