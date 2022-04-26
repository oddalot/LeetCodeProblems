import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns index of needle in haystack`() {
        val haystack = "unbelievable"
        val needle = "vab"
        val expectedIndex = 7

        assertEquals(expectedIndex, solution.strStr(haystack, needle))
    }

    @Test
    fun `returns -1 if needle not found in haystack`() {
        val haystack = "unbelievable"
        val needle = "cat"
        val expectedIndex = -1

        assertEquals(expectedIndex, solution.strStr(haystack, needle))
    }
}