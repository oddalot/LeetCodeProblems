class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        var currentIndex = 0

        (1 until nums.size).forEach { i ->
            val currentHigh = nums[currentIndex]
            val num = nums[i]

            if (num > currentHigh) {
                nums[++currentIndex] = num
            }
        }

        return currentIndex + 1
    }
}