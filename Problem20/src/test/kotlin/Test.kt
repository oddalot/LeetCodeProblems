import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns valid parens for single paren set`() {
        val parens = "{}"
        val expected = true

        assertEquals(expected, solution.isValid(parens))
    }

    @Test
    fun `returns valid parens for nested parens`() {
        val parens = "()(())({{[]}})"
        val expected = true

        assertEquals(expected, solution.isValid(parens))
    }

    @Test
    fun `returns invalid parens for invalid parens`() {
        val parens = "(){{}}["
        val expected = false

        assertEquals(expected, solution.isValid(parens))
    }
}