import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `removes 2nd node from end of list`() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        node1.next = node2
        node2.next = node3
        val outputNode1 = ListNode(1)
        val outputNode2 = ListNode(3)
        outputNode1.next = outputNode2
        solution.removeNthFromEnd(node1, 2)
        var head: ListNode? = node1
        var expectedHead: ListNode? = outputNode1

        while (head != null) {
            assertEquals(expectedHead?.`val`, head.`val`)
            head = head.next
            expectedHead = expectedHead?.next
        }
    }
}