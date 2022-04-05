import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `merges two linked lists together`() {
        val nodeOne1 = ListNode(3)
        val nodeOne2 = ListNode(5)
        val nodeOne3 = ListNode(7)
        nodeOne1.next = nodeOne2
        nodeOne2.next = nodeOne3

        val nodeTwo1 = ListNode(4)
        val nodeTwo2 = ListNode(6)
        nodeTwo1.next = nodeTwo2

        val outputNode1 = ListNode(3)
        val outputNode2 = ListNode(4)
        val outputNode3 = ListNode(5)
        val outputNode4 = ListNode(6)
        val outputNode5 = ListNode(7)
        outputNode1.next = outputNode2
        outputNode2.next = outputNode3
        outputNode3.next = outputNode4
        outputNode4.next = outputNode5

        var output: ListNode? = outputNode1
        var head: ListNode? = solution.mergeTwoLists(nodeOne1, nodeTwo1)

        while (head != null) {
            assertEquals(output?.`val`,  head.`val`)
            output = output?.next
            head = head.next
        }
    }
}