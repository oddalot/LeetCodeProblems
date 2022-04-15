class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        var previousNode: ListNode? = null
        var thirdNode = head.next?.next
        var secondNode = head.next
        var firstNode = head
        var isFirst = true
        var returnHead: ListNode? = null

        while (secondNode != null) {
            firstNode?.next = thirdNode
            secondNode.next = firstNode
            previousNode?.next = secondNode
            previousNode = firstNode
            firstNode = thirdNode
            if (isFirst) {
                returnHead = secondNode
                isFirst = false
            }
            secondNode = firstNode?.next
            thirdNode = secondNode?.next
        }

        return returnHead
    }
}