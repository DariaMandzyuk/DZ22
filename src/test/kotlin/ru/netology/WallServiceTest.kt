package ru.netology

import Comment
import Donut
import Post
import PostNotFoundException
import ThreadComments
import Video
import VideoAttachment
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val result = WallService.add(returnPost(5))
        assertEquals(result.id, 1)
    }

    @Test
    fun shouldBeTrueWhileUpdate() {

        WallService.add(returnPost(1))
        WallService.add(returnPost(2))
        WallService.add(returnPost(3))

        val update = returnPost(2)

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Test
    fun shouldBeFalseWhileUpdate() {
        WallService.add(returnPost(1))
        WallService.add(returnPost(2))
        WallService.add(returnPost(3))

        val update = returnPost(8)

        val result = WallService.update(update)

        assertFalse(result)
    }

    private fun returnPost(id: Int): Post {
        return Post(
            id, 1, 1, 1, 1, "Hello", 1, 1, true,
            Comment(1, 1), null, null, "Hello", null, null, 4, null, 4,
            4, 4, 4, 4, true
        )
    }

    @Test
    fun shouldNotThrowException() {
        WallService.add(returnPost(1))
        WallService.createComment(1, Comment(1, 1))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowException() {
        WallService.createComment(
            2, Comment(1, 1)
        )
    }
}
