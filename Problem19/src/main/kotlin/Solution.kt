class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var node = head
        var count = 1

        while (node?.next != null) {
            node = node.next
            count++
        }

        if (count == n) return head?.next

        node = head
        (1 until (count - n)).forEach { _ ->
            node = node?.next
        }

        node?.next = node?.next?.next

        return head
    }
}