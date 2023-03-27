fun main() {
    val comments = Comments(1, 1, 1)
    val audio = Audio()
    val attachment = AudioAttachment(audio = audio)
    println(attachment)
    val post1 = Post(
        1, 1, 1, 1, 1, "Hello", 1, 1, true,
        comments, null, null, "Hello", null, null, 4, null, 4,
        4, 4, 4, 4, true
    )
    val post2 = post1.copy(ownerId = post1.ownerId + 4)
    val post3 = post1.copy(text = post1.text + " World!")

    println(WallService.add(post1))
    println(WallService.add(post2))
    println(WallService.update(post3))
}

