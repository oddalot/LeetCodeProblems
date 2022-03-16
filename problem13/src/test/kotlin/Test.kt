import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `converts roman numeral to decimal number`() {
        val romanNum = "DLXIV"
        val decimalNum = 564

        assertEquals(decimalNum, solution.romanToInt(romanNum))
    }
}