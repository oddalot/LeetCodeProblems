import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `converts decimal number into roman numeral`() {
        val decimalNum = 577
        val romanNum = "DLXXVII"

        assertEquals(expected = romanNum, solution.intToRoman(decimalNum))
    }
}