import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `removes value from array`() {
        val nums = intArrayOf(2, 4, 5, 5, 6, 7, 5, 8)
        val expectedNums = intArrayOf(2, 4, 6, 7, 8, 7, 5, 8)

        solution.removeElement(nums, 5)

        assertContentEquals(expectedNums, nums)
    }
}