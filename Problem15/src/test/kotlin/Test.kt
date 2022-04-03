import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns all triplets that sum to 0`() {
        val nums = intArrayOf(-3, -2, 0, 2, 3)
        val expected = listOf(listOf(-3, 0, 3), listOf(-2, 0, 2))

        assertEquals(expected, solution.threeSum(nums))
    }

    @Test
    fun `empty array returns empty array`() {
        val nums = intArrayOf()
        val expected = listOf<List<Int>>()

        assertEquals(expected, solution.threeSum(nums))
    }
}