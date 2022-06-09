import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the next largest permutation`() {
        val nums = intArrayOf(4, 5, 6, 7)

        solution.nextPermutation(nums)
        val expectedNums = intArrayOf(4, 5, 7, 6)
        assertContentEquals(expectedNums, nums)
    }

    @Test
    fun `finds the smallest if no largest permutation`() {
        val nums = intArrayOf(8, 7, 6, 5)

        solution.nextPermutation(nums)
        val expectedNums = intArrayOf(5, 6, 7, 8)
        assertContentEquals(expectedNums, nums)
    }
}