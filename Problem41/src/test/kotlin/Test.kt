import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the first positive integer missing from array`() {
        val nums = intArrayOf(-1, -2, -9, 0, 1, 2, 3)
        val expected = 4

        assertEquals(expected, solution.firstMissingPositive(nums))
    }

    @Test
    fun `returns 1 which is to be expected if that is missing`() {
        val nums = intArrayOf(2, 3, 4, 5)
        val expected = 1

        assertEquals(expected, solution.firstMissingPositive(nums))
    }
}