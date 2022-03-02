class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsMap = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            val foundIndex = numsMap[target - num]
            if (foundIndex != null)  {
                return intArrayOf(foundIndex, index)
            } else {
                numsMap[num] = index
            }
        }

        throw IllegalArgumentException("no target found in array")
    }
}