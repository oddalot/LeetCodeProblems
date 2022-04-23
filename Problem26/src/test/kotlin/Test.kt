import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `removes duplicates from array`() {
        val nums = intArrayOf(1, 2, 2, 4, 1, 5, 6)
        val expectedNums = intArrayOf(1, 2, 4, 5, 6, 5, 6)

        solution.removeDuplicates(nums)

        assertContentEquals(expectedNums, nums)
    }
}