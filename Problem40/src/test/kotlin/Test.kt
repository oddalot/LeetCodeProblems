import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `using only a candidate once it finds all unique combinations that sum to target`() {
        val candidates = intArrayOf(1, 2, 3, 9, 10)
        val target = 12

        val expectedCombinations = listOf(
            listOf(1, 2, 9),
            listOf(2, 10),
            listOf(3, 9),
        )

        assertContentEquals(expectedCombinations, solution.combinationSum2(candidates, target))
    }
}