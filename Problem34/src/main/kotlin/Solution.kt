class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.size == 0) return intArrayOf(-1, -1)
        if (nums.size == 1) {
            if (nums[0] == target) {
                return intArrayOf(0, 0)
            } else {
                return intArrayOf(-1, -1)
            }
        }

        if (nums.size == 2) {
            if (nums[0] == target && nums[1] != target) {
                return intArrayOf(0, 0)
            }
            if (nums[1] == target && nums[0] != target) {
                return intArrayOf(1, 1)
            }
            if (nums[0] == target && nums[1] == target) {
                return intArrayOf(0, 1)
            }

            return intArrayOf(-1, -1)
        }

        var foundLo: Int = -1
        var foundHi: Int = -1
        var sameLoHiMid = false

        var lo = 0
        var hi = nums.size - 1
        var mid = ((hi - lo) / 2) + lo

        while (!sameLoHiMid) {
            val midNum = nums[mid]
            val lessMidNum = if (mid == 0) {
                null
            } else {
                nums[mid - 1]
            }

            val loNum = nums[lo]
            val lessLoNum = if (lo == 0) {
                null
            } else {
                nums[lo - 1]
            }

            val hiNum = nums[hi]
            val lessHiNum = if (hi == 0) {
                null
            } else {
                nums[hi - 1]
            }

            val tempLo = lo
            val tempHi = hi
            val tempMid = mid
            if (midNum == target && lessMidNum != target) {
                foundLo = mid
                break
            } else if (loNum == target && lessLoNum != target) {
                foundLo = lo
                break
            } else if (hiNum == target && lessHiNum != target) {
                foundLo = hi
                break
            }  else if (midNum >= target) {
                lo = lo
                hi = mid
                mid = ((hi - lo) / 2) + lo
            } else if (midNum < target) {
                lo = mid
                hi = hi
                mid = ((hi - lo) / 2) + lo
            }

            if (tempLo == lo && tempHi == hi && tempMid == mid) break
        }

        lo = 0
        hi = nums.size - 1
        mid = ((hi - lo) / 2) + lo
        sameLoHiMid = false

        while (!sameLoHiMid) {
            val midNum = nums[mid]
            val moreMidNum = if (mid + 1 >= nums.size) {
                null
            } else {
                nums[mid + 1]
            }
            val loNum = nums[lo]
            val moreLoNum = if (lo + 1 >= nums.size) {
                null
            } else {
                nums[lo + 1]
            }
            val hiNum = nums[hi]
            val moreHiNum = if (hi + 1 >= nums.size) {
                null
            } else {
                nums[hi + 1]
            }


            val tempLo = lo
            val tempHi = hi
            val tempMid = mid
            if (midNum == target && moreMidNum != target) {
                foundHi = mid
                break
            } else if (loNum == target && moreLoNum != target) {
                foundHi = lo
                break
            } else if (hiNum == target && moreHiNum != target) {
                foundHi = hi
                break
            } else if (midNum > target) {
                lo = lo
                hi = mid
                mid = ((hi - lo) / 2) + lo
            } else if (midNum <= target) {
                lo = mid
                hi = hi
                mid = ((hi - lo) / 2) + lo
            }

            if (tempLo == lo && tempHi == hi && tempMid == mid) break
        }

        return intArrayOf(foundLo, foundHi)
    }
}