import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds target in rotated array`() {
        val nums = intArrayOf(9, 10, 11, 0, 5, 6, 7)
        val expected = 3
        val actual = solution.search(nums, 0)
        assertEquals(expected, actual)
    }

    @Test
    fun `returns -1 if target not found in array`() {
        val nums = intArrayOf(9, 10, 11, 0, 5, 6, 7)
        val expected = -1
        val actual = solution.search(nums, 4)
        assertEquals(expected, actual)
    }
}