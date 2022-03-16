import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the container with the most water`() {
        val heights = intArrayOf(
            2, 4, 1, 2, 6, 4, 7
        )
        val maxWater = 20

        assertEquals(maxWater, solution.maxArea(heights))
    }
}