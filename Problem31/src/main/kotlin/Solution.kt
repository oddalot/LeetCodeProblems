class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.isEmpty() || nums.size == 1) return
        val sortedList = mutableListOf<Int>()
        var greatestSoFarI = nums.size - 1
        var greatestSoFar = nums[greatestSoFarI]
        sortedList.add(greatestSoFar)

        ((nums.size - 2) downTo 0).forEach { i ->
            val num = nums[i]

            if (num >= greatestSoFar) {
                greatestSoFarI = i
                greatestSoFar = nums[greatestSoFarI]
                sortedList.add(greatestSoFar)
            } else {
                sortedList.forEachIndexed { index, foundNum ->
                    if (foundNum > num) {
                        println(1)
                        nums[i] = foundNum
                        sortedList[index] = num
                        var k = 0
                        ((nums.size - sortedList.size)..(nums.size - 1)).forEach { j ->
                            nums[j] = sortedList[k++]
                        }
                        return
                    }
                }
            }
        }

        (0 until nums.size).forEach { j ->
            nums[j] = sortedList[j]
        }
        return
    }

    private fun <T> MutableList<T>.removeLast(): T = if (isEmpty()) throw NoSuchElementException("List is empty.") else removeAt(lastIndex)
}