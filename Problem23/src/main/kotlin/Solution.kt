class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var head: ListNode? = null
        var tail: ListNode? = null

        var isNotEmpty = true

        while (isNotEmpty) {
            var localIsNotEmpty = false

            var leastElement = Pair(-1, Int.MAX_VALUE)
            lists.forEachIndexed { index, list ->
                if (list != null) localIsNotEmpty = true

                val first = list?.`val`
                if (first != null) {
                    if (first < leastElement.second) {
                        leastElement = Pair(index, first)
                    }
                }
            }

            if (localIsNotEmpty) {
                if (tail == null) {
                    head = ListNode(leastElement.second)
                    tail = head
                } else {
                    tail.next = ListNode(leastElement.second)
                    tail = tail.next
                }
                lists[leastElement.first] = lists[leastElement.first]?.next
            }

            isNotEmpty = localIsNotEmpty
        }

        return head
    }
}