package ru.netology

import Comments
import Post
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

    private fun returnPost(id: Int): Post{
        return Post(id, 1, 1, 1, 1, "Hello", 1, 1, true,
            Comments(1,1,1), null, null, "Hello", null, null, 4, null, 4,
            4, 4, 4, 4, true)
    }
}
