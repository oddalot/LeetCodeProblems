import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns array of unique quadruplets that equal target`() {
        val nums = intArrayOf(-3, -1, 0, 1, 2, 3)
        val target = 1
        val expectedOutput = listOf(listOf(-3, -1, 2, 3), listOf(-3, 0, 1, 3))

        assertEquals(expectedOutput, solution.fourSum(nums, target))
    }
}