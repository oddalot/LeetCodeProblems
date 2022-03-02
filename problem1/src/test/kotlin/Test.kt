import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds target in array`() {
        val nums = intArrayOf(2, 7, 11, 15)
        assertContentEquals(intArrayOf(0, 1), solution.twoSum(nums, 9))
    }

    @Test
    fun `throws IllegalArgumentException when target not found`() {
        val nums = intArrayOf(2, 4, 9, 1)
        assertThrows<java.lang.IllegalArgumentException> {
            solution.twoSum(nums, 9)
        }
    }


    @Test
    fun `finds target in array on size 2`() {
        val nums = intArrayOf(3, 3)
        assertContentEquals(intArrayOf(0, 1), solution.twoSum(nums, 6))
    }
}