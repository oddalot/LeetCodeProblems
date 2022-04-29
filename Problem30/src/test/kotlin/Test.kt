import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns list of indexes for words concatenated`() {
        val s = "bigbadwofbadwofbigbadbadwofbig"
        val words = arrayOf("big", "bad", "wof")
        val expectedIndexes = listOf(0, 9, 12, 21)

        println(solution.findSubstring(s, words))
        assertContentEquals(expectedIndexes, solution.findSubstring(s, words))
    }
}