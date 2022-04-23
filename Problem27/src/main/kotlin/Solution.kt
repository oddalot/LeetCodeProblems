class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        var currentIndex = 0
        (0 until nums.size).forEach { i ->
            val num = nums[i]
            if (num != `val`) {
                nums[currentIndex++] = num
            }

        }


        return currentIndex
    }
}