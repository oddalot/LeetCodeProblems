class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val numSet = mutableSetOf<List<Int>>()

        iLoop@ for (i in 0..(nums.size - 4)) {
            if (i > 0 && nums[i] == nums[i - 1]) continue@iLoop
            jLoop@ for (j in (i + 1)..(nums.size -3 )) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue@jLoop
                kLoop@ for (k in (j + 1)..(nums.size - 2)) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue@kLoop
                    lLoop@ for (l in (k + 1)..(nums.size - 1)) {
                        if (l > k + 1 && nums[l] == nums[l - 1]) continue@lLoop
                        val num = nums[i] + nums[j] + nums[k] + nums[l]
                        if (num == target)  {
                            val numList = listOf(nums[i], nums[j], nums[k], nums[l]).sorted()
                            numSet.add(numList)
                        }
                    }
                }
            }
        }

        return numSet.toList()
    }
}