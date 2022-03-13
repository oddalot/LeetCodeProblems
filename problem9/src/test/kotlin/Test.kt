import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns true for a integer palindrome`() {
        val intPalindrome = 8237328
        val expected = true

        assertEquals(expected, solution.isPalindrome(intPalindrome))
    }

    @Test
    fun `returns false if integer is not a palindrome`() {
        val notIntPalindrome = 378999
        val expected = false

        assertEquals(expected, solution.isPalindrome(notIntPalindrome))
    }
}