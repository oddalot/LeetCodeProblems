class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val foundList = mutableSetOf<List<Int>>()
        val numsMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            numsMap[num] = index
        }

        (nums.indices).forEach { i ->
            val num = nums[i]
            val foundNumsList = twoSum(nums, -num, i, numsMap)
            foundNumsList.forEach { foundNums ->
                if (foundNums.size == 2) {
                    val firstNum = nums[foundNums[0]]
                    val secondNum = nums[foundNums[1]]

                    foundList.add(listOf(num, firstNum, secondNum).sorted())
                }
            }
        }

        return foundList.toList()
    }

    private fun twoSum(nums: IntArray, target: Int, targetIndex: Int, numsMap: Map<Int, Int>): List<IntArray> {
        val numsList = mutableListOf<IntArray>()

        nums.forEachIndexed { index, num ->
            if (index != targetIndex) {
                val foundIndex = numsMap[target - num]
                if (foundIndex != null && foundIndex != targetIndex && foundIndex != index)  {
                    numsList.add(intArrayOf(foundIndex, index))
                }
            }
        }

        return numsList
    }
}