fun main() {
    val post1 = Post(1, 1, "Hello", true, true, 13, 2, 1, "answer", 10, null)
    val post2 = post1.copy(ownerId = post1.ownerId + 4)
    val post3 = post1.copy(text = post1.text + " World!")


    println(WallService.add(post1))
    println(WallService.add(post2))
    println(WallService.update(post3))
}