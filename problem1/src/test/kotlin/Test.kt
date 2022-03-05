import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test {
    private val solution = Solution()

    @Test
    fun `finds target in array`() {
        val nums = intArrayOf(1, 9, 0, 16)
        val target = 9
        assertContentEquals(intArrayOf(1, 2), solution.twoSum(nums, target))
    }

    @Test
    fun `throws IllegalArgumentException when target not found`() {
        val nums = intArrayOf(2, 4, 9, 1)
        val target = 15
        assertThrows<java.lang.IllegalArgumentException> {
            solution.twoSum(nums, 15)
        }
    }


    @Test
    fun `finds target in array on size 2`() {
        val nums = intArrayOf(5, 5)
        val target = 10
        assertContentEquals(intArrayOf(0, 1), solution.twoSum(nums, target))
    }
}