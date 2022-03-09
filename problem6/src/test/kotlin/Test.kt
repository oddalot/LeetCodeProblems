import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `converts a three row string correctly`() {
        val str = "WHATISTHEDEALHERE"
        val convertedStr = "WIELEHTSHDAHRATEE"

        assertEquals(convertedStr, solution.convert(str, 3))
    }

    @Test
    fun `converts a one row string correctly`() {
        val str = "W"
        val convertedStr = "W"

        assertEquals(convertedStr, solution.convert(str, 1))
    }

    @Test
    fun `converts a zero row string correctly`() {
        val str = ""
        val convertedStr = ""

        assertEquals(convertedStr, solution.convert(str, 0))
    }
}