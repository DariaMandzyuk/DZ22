package ru.netology

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
        val result = WallService.add((Post(7, 1, "Hello", true, true, 13, 2, 1, "answer",10, null, arrayOf())))
        assertEquals(result.id, 1)
    }

    @Test
    fun shouldBeTrueWhileUpdate() {

        WallService.add(Post(1, 1, "Hello", true, true, 13, 2, 1, "answer", 10, null, arrayOf()))
        WallService.add(Post(2, 5, "Nice", true, true, 20, 3, 1, "type", 9, null, arrayOf()))
        WallService.add(Post(4, 7, "Parrot", true, false, 13, 2, 1, "top", 1, null, arrayOf()))

        val update = Post(2, 6, "Nice", true, true, 14, 7, 2, "type", 10, null, arrayOf())

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Test
    fun shouldBeFalseWhileUpdate() {
        WallService.add(Post(1, 1, "Hello", true, true, 13, 2, 1, "answer", 10, null, arrayOf()))
        WallService.add(Post(2, 5, "Nice", true, true, 20, 3, 1, "type", 9, null, arrayOf()))
        WallService.add(Post(4, 7, "Parrot", true, false, 13, 2, 1, "top", 1, null, arrayOf()))

        val update = Post(8, 6, "Nice", true, true, 14, 7, 2, "type", 10, null, arrayOf())

        val result = WallService.update(update)

        assertFalse(result)
    }
}
