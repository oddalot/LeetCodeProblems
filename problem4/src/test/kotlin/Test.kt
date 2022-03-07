import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds the median of two arrays`() {
        val arr1 = intArrayOf(4, 5, 6)
        val arr2 = intArrayOf(7, 8)
        val median = 6.0

        assertEquals(median, solution.findMedianSortedArrays(arr1, arr2))
    }

    @Test
    fun `finds median of two arrays mixed up`() {
        val arr1 = intArrayOf(4, 7, 9)
        val arr2 = intArrayOf(1, 5, 8)
        val median = 6.0

        assertEquals(median, solution.findMedianSortedArrays(arr1, arr2))
    }

    @Test
    fun `if input array is empty throws IllegalArgumentException`() {
        val arr1 = intArrayOf()
        val arr2 = intArrayOf(1)
        val median = 0.0

        assertThrows<IllegalArgumentException> {
            solution.findMedianSortedArrays(arr1, arr2)
        }
    }
}