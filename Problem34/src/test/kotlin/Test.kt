import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns correct range if target found in array`() {
        val nums = intArrayOf(1, 2, 6, 7, 8, 9, 9, 9, 10)
        val expected = intArrayOf(5, 7)
        val actual = solution.searchRange(nums, 9)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `returns range of -1 if target not found in array`() {
        val nums = intArrayOf(1, 2, 6, 7, 8, 9, 9, 9, 10)
        val expected = intArrayOf(-1, -1)
        val actual = solution.searchRange(nums, 4)
        assertContentEquals(expected, actual)
    }
}