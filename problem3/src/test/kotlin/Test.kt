import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the longest substring of given string`() {
        val str = "twicettwe"
        assertEquals(5, solution.lengthOfLongestSubstring(str))
    }

    @Test
    fun `returns 1 if string is length 1`() {
        val str = "a"
        assertEquals(1, solution.lengthOfLongestSubstring(str))
    }

    @Test
    fun `returns 0 if string is empty`() {
        val str = ""
        assertEquals(0, solution.lengthOfLongestSubstring(str))
    }
}