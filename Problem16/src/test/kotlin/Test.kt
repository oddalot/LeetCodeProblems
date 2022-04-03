import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds number that sums closest to target`() {
        val nums = intArrayOf(-2, -1, 0, 1, 4)
        val target = 6
        val expectedTriplet = 5

        assertEquals(expectedTriplet, solution.threeSumClosest(nums, target))
    }
}