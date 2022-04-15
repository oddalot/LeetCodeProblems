import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `reverse k nodes at a time in linked list`() {
        val node1 = ListNode(4)
        val node2 = ListNode(5)
        val node3 = ListNode(6)
        val node4 = ListNode(7)
        val node5 = ListNode(9)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val outputNode1 = ListNode(5)
        val outputNode2 = ListNode(4)
        val outputNode3 = ListNode(7)
        val outputNode4 = ListNode(6)
        val outputNode5 = ListNode(9)
        outputNode1.next = outputNode2
        outputNode2.next = outputNode3
        outputNode3.next = outputNode4
        outputNode4.next = outputNode5

        var outputNode: ListNode? = outputNode1
        var head = solution.reverseKGroup(node1, 2)

        while (head != null) {
            assertEquals(outputNode?.`val`, head.`val`)
            outputNode = outputNode?.next
            head = head.next
        }
    }
}