import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the longest palindrome substring`() {
        val str = "brrtenetbrr"
        val palindrome = "tenet"

        assertEquals(palindrome, solution.longestPalindrome(str))
    }

    @Test
    fun `if string length is 0 throws IllegalArgumentException`() {
        val str = ""

        assertThrows<IllegalArgumentException> {
            solution.longestPalindrome(str)
        }
    }
}