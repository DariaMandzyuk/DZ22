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

    fun add(post: Post): Post { // здесь передаю класс пост и возвращаю объект класса пост
        posts += post.copy(id = ++lastId) // массиву я прибавляю копию поста с измененным айди
        // .copy - вызов метода copy у дата класса, при копировании мы можем изменять поля нового объекта
        // .copy(изменяем поле id =  ++lastId )
        return posts.last() //  возвращаю последний элемент этого массива
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