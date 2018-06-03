package com.example.preston.kotlindice

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `rolls to whatever is correct`() {
        assertEquals("4 + 2 = 6", rollsToString(listOf(4, 2)))
        assertEquals("6 + 6 = 12", rollsToString(listOf(6, 6)))
    }
}
