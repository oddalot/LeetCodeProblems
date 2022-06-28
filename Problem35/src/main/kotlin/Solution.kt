class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.size == 0) return -1
        if (nums.size == 1) {
            if (target == nums[0]) {
                return 0
            } else if (target > nums[0]) {
                return 1

            } else {
                return 0

            }
        }

        var lo = 0
        var hi = nums.size - 1
        var mid = (hi - lo) / 2 + lo

        while (lo <= hi) {
            if (nums[mid] == target) {
                return mid
            } else if (target < nums[mid]) {
                hi = mid - 1
                mid = (hi - lo) / 2 + lo
            } else {
                lo = mid + 1
                mid = (hi - lo) / 2 + lo
            }
        }

        return mid
    }
}