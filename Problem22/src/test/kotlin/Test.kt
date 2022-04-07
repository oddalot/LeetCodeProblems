import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `generates all combinations of parens`() {
        val n = 2
        val expectedParens = listOf(
            "()()",
            "(())"
        )
        assertEquals(expectedParens, solution.generateParenthesis(n))
    }
}