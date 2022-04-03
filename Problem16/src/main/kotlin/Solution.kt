class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closestTarget = Int.MAX_VALUE
        var closestSum = Int.MAX_VALUE


        (nums.indices).forEach { i ->
            (nums.indices).forEach { j ->
                (nums.indices).forEach { k ->
                    if (i != j && j != k && k != i) {
                        val sum = nums[i] + nums[j] + nums[k]
                        val targetDiff = (sum - target).abs
                        if (targetDiff < closestTarget) {
                            closestTarget = targetDiff
                            closestSum = sum
                        }
                    }
                }
            }
        }

        return closestSum
    }

    private val Int.abs: Int
        get() = if (this < 0) -this else this
}