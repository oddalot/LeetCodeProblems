import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds longest valid parens`() {
        val s = "()())"
        val expected = 4

        val longest = solution.longestValidParentheses(s)
        assertEquals(expected, longest)
    }

    @Test
    fun `finds longest valid for longer parens`() {
        val s = "))(())(())(("
        val expected = 8

        val longest = solution.longestValidParentheses(s)
        assertEquals(expected, longest)
    }
}