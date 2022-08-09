import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `count and say for 2 returns 11`() {
        val expected = "11"
        val given = solution.countAndSay(2)

        assertEquals(expected, given)
    }

    @Test
    fun `count and say for 3 returns 21`() {
        val expected = "21"
        val given = solution.countAndSay(3)

        assertEquals(expected, given)
    }

    @Test
    fun `count and say for 5 returns 111221`() {
        val expected = "111221"
        val given = solution.countAndSay(5)

        assertEquals(expected, given)
    }
}