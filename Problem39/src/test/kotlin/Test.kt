import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns all combinations found for candidates`() {
        val candidates = intArrayOf(3, 4, 5, 9)
        val target = 9
        val expectedOutput = listOf(listOf(3, 3, 3), listOf(4, 5), listOf(9))
        assertEquals(expectedOutput, solution.combinationSum(candidates, target))
    }

    @Test
    fun `returns empty list if no combinations found for candidates`() {
        val candidates = intArrayOf(7, 8, 9)
        val target = 10
        val expectedOutput: List<List<Int>> = emptyList()
        assertEquals(expectedOutput, solution.combinationSum(candidates, target))
    }
}