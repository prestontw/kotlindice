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

    @Test
    fun `36 rolls gives identity`() {
        assertEquals(rollProportions.map { p -> p.key to p.value.toFloat() }.toMap(), idealNumRolls(36))
    }

    @Test
    fun `empty rolls gives zeros compared to identity`() {
        val ideal = idealNumRolls(36)
        val rolls = HashMap<Int, Int>().toMap()
        assertEquals("2: 0/1\n" +
                "3: 0/2\n" +
                "4: 0/3\n" +
                "5: 0/4\n" +
                "6: 0/5\n" +
                "7: 0/6\n" +
                "8: 0/5\n" +
                "9: 0/4\n" +
                "10: 0/3\n" +
                "11: 0/2\n" +
                "12: 0/1\n", mapsToReport(rolls, ideal))
    }
}
