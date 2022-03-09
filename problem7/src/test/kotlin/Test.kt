import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    val solution = Solution()

    @Test
    fun `reverses a positive three digit number`() {
        val num = 856
        val reversedNum = 658

        assertEquals(reversedNum, solution.reverse(num))
    }

    @Test
    fun `reverse a negative three digit number`() {
        val num = -856
        val reversedNum = -658

        assertEquals(reversedNum, solution.reverse(num))
    }

    @Test
    fun `reversing a number outside of 32-bit range returns 0`() {
        val num = Int.MAX_VALUE
        val outOfRangeNum = 0

        assertEquals(outOfRangeNum, solution.reverse(num))
    }
}