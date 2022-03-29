import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the longest common prefix amongst strings`() {
        val strs = arrayOf("chair", "chart", "chime")
        val prefix = "ch"

        assertEquals(prefix, solution.longestCommonPrefix(strs))
    }

    @Test
    fun `returns empty string if no common prefix found`() {
        val strs = arrayOf("chair", "shoe", "movie")
        val prefix = ""

        assertEquals(prefix, solution.longestCommonPrefix(strs))
    }
}