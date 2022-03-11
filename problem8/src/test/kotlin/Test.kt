import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `turns a two digit string into integer`() {
        val str = "78"
        val num = 78

        assertEquals(num, solution.myAtoi(str))
    }

    @Test
    fun `turns a negative three digit string into negative integer`() {
        val str = "-623"
        val num = -623

        assertEquals(num, solution.myAtoi(str))
    }

    @Test
    fun `turns a two digit string with other words into integer`() {
        val str = "what what 702"
        val num = 702

        assertEquals(num, 702)
    }
}