import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `adds two three digit number`() {
        // 456
        val four = ListNode(4)
        val five = ListNode(5)
        val six = ListNode(6)
        six.next = five
        five.next = four
        val num456 = six

        // 123
        val one = ListNode(1)
        val two = ListNode(2)
        val three = ListNode(3)
        three.next = two
        two.next = one
        val num123 = three

        var num579 = solution.addTwoNumbers(num456, num123)

        assertEquals(9, num579?.`val`)
        num579 = num579?.next
        assertEquals(7, num579?.`val`)
        num579 = num579?.next
        assertEquals(5, num579?.`val`)
    }

    @Test
    fun `throws IllegalArgumentException if l1 and l1 are null`() {
        assertThrows<IllegalArgumentException> {
            solution.addTwoNumbers(null, null)
        }
    }
}