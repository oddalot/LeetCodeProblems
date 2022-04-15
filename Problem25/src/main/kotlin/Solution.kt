class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var runner = head
        var previousNode: ListNode? = null
        var isFirst = true
        var returnHead: ListNode? = null
        while (runner != null) {
            val nodeStack = mutableListOf<ListNode>()
            (1..k).forEach {
                if (runner == null) {
                    previousNode?.next = nodeStack.first()

                    return returnHead
                }
                runner?.let {
                    nodeStack.add(it)
                }
                runner = runner?.next
            }

            var lastNode = nodeStack.removeLast()
            previousNode?.next = lastNode
            if (isFirst) {
                isFirst = false
                returnHead = lastNode
            }
            while (nodeStack.isNotEmpty()) {
                val nextNode = nodeStack.removeLast()
                lastNode.next = nextNode
                lastNode = nextNode
            }

            previousNode = lastNode
        }


        previousNode?.next = null
        return returnHead
    }
}
