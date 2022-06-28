import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns index if found target`() {
        val nums = intArrayOf(0, 5, 7, 8, 9)
        val target = 8

        val index = solution.searchInsert(nums, target)

        assertEquals(3, index)
    }

    @Test
    fun `returns index of location it would be if target not found`() {
        val nums = intArrayOf(0, 5, 7, 8, 9)
        val target = 4

        val index = solution.searchInsert(nums, target)

        assertEquals(1, index)
    }
}