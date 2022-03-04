class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null)
            throw IllegalArgumentException("both list nodes are null")
        var list1 = l1
        var list2 = l2

        var sum = (list1?.`val` ?: 0) + (list2?.`val` ?: 0)
        var num = sum % 10
        var carry = if (sum >= 10) 1 else 0

        var newList: ListNode? = ListNode(num)
        val headList = newList

        list1 = list1?.next
        list2 = list2?.next

        while (list1 != null || list2 != null || carry != 0) {
            sum = (list1?.`val` ?: 0) + (list2?.`val` ?: 0) + carry
            num = sum % 10
            carry = if (sum >= 10) 1 else 0
            newList?.next = ListNode(num)
            newList = newList?.next
            list1 = list1?.next
            list2 = list2?.next
        }

        return headList
    }
}