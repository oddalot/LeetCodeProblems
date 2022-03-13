import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns true for match in string`() {
        val str = "abcc"
        val match ="abc*"
        val expected = true

        assertEquals(expected, solution.isMatch(str, match))
    }

    @Test
    fun `return false for no match found in string`() {
        val str = "abcc"
        val match = "abc"
        val expected = false

        assertEquals(expected, solution.isMatch(str, match))
    }
}