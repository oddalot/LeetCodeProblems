import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `divides two numbers and truncates the result`() {
        val dividend = 45
        val divisor = 4
        val expectedResult = 11

        assertEquals(expectedResult, solution.divide(dividend, divisor))
    }
}