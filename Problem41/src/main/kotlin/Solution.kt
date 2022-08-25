class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val posI = swapNegatives(nums)
        markPositivesWithNegatives(nums, posI)
        return findSmallestMissingPositive(nums, posI)
    }

    // 0 counts as negative for the sake of this problem
    private fun swapNegatives(nums: IntArray): Int {
        var negI = 0

        (0 until nums.size).forEach { i ->
            if (nums[i] <= 0) {
                nums[i] = nums[negI].also { nums[negI] = nums[i] }
                negI++
            }
        }

        return negI
    }

    private fun markPositivesWithNegatives(nums: IntArray, startIndex: Int) {
        (startIndex until nums.size).forEach { index ->

            val tempNumIndex = nums[index]
            val numIndex = if (tempNumIndex < 0) {
                -tempNumIndex + startIndex - 1
            }  else {
                tempNumIndex + startIndex - 1
            }
            if (numIndex < nums.size && numIndex >= 0) {
                val tempNumSwitch = nums[numIndex]
                if (tempNumSwitch > 0) nums[numIndex] = -tempNumSwitch
            }
        }
    }

    private fun findSmallestMissingPositive(nums: IntArray, startIndex: Int): Int {
        (startIndex until nums.size).forEach { index ->
            if (nums[index] > 0) return index - startIndex + 1
        }

        return nums.size - startIndex + 1
    }
}