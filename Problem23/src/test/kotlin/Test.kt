import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `merges 3 linked lists successfully`() {
        val nodeOne1 = ListNode(3)
        val nodeOne2 = ListNode(5)
        val nodeOne3 = ListNode(6)
        nodeOne1.next = nodeOne2
        nodeOne2.next = nodeOne3

        val nodeTwo1 = ListNode(4)
        val nodeTwo2 = ListNode(7)
        nodeTwo1.next = nodeTwo2

        val nodeThree1 = ListNode(2)
        val nodeThree2 = ListNode(8)
        nodeThree1.next = nodeThree2

        val outputNode1 = ListNode(2)
        val outputNode2 = ListNode(3)
        val outputNode3 = ListNode(4)
        val outputNode4 = ListNode(5)
        val outputNode5 = ListNode(6)
        val outputNode6 = ListNode(7)
        val outputNode7 = ListNode(8)
        outputNode1.next = outputNode2
        outputNode2.next = outputNode3
        outputNode3.next = outputNode4
        outputNode4.next = outputNode5
        outputNode5.next = outputNode6
        outputNode6.next = outputNode7

        var head = solution.mergeKLists(arrayOf(nodeOne1, nodeTwo1, nodeThree1))
        var outputHead: ListNode? = outputNode1

        while (head != null) {
            assertEquals(outputHead?.`val`, head.`val`)

            head = head.next
            outputHead = outputHead?.next
        }
    }
}