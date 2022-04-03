import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds all combinations of given digits`() {
        val digits = "56"
        val expectedOutput = listOf("jm", "jn", "jo", "km", "kn", "ko", "lm", "ln", "lo")

        assertEquals(expectedOutput, solution.letterCombinations(digits))
    }
}