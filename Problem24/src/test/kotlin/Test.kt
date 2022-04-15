import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `swaps adjacent nodes in linked list`() {
        val node1 = ListNode(5)
        val node2 = ListNode(6)
        val node3 = ListNode(9)
        val node4 = ListNode(10)
        node1.next = node2
        node2.next = node3
        node3.next = node4

        val outputNode1 = ListNode(6)
        val outputNode2 = ListNode(5)
        val outputNode3 = ListNode(10)
        val outputNode4 = ListNode(9)
        outputNode1.next = outputNode2
        outputNode2.next = outputNode3
        outputNode3.next = outputNode4

        var outputNode: ListNode? = outputNode1
        var swappedNode = solution.swapPairs(node1)

        while (swappedNode != null) {
            assertEquals(outputNode?.`val`, swappedNode.`val`)
            outputNode = outputNode?.next
            swappedNode = swappedNode.next
        }
    }
}