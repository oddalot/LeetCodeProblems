class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) {
            if (nums[0] == target) return 0
            return -1
        }

        if (nums.size == 2) {
            if (nums[0] == target) return 0
            if (nums[1] == target) return 1
            return -1
        }

        val pivot = findPivot(nums)
        println(pivot)
        return binarySearch(nums, target, pivot + 1)
    }

    private fun binarySearch(nums: IntArray, target: Int, pivot: Int): Int {
        var _lo = 0
        var _hi = nums.size - 1
        var _mid = (_hi - _lo) / 2
        var lo = (_lo + pivot) % nums.size
        var hi = (_hi + pivot) % nums.size
        var mid = (_mid + pivot) % nums.size

        if (target == nums[mid]) return mid

        while (target != nums[mid]) {
            println("hi: " + hi)
            println("lo: " + lo)
            println("mid: " + mid)
            if (lo == mid || hi == mid) {
                return -1
            } else if (target > nums[mid]) {
                _hi = _hi
                _lo = _mid
                _mid = (_hi - _mid) / 2
            } else if (target < nums[mid]) {
                _hi = _mid
                _lo = _lo
                _mid = (_hi - _mid) / 2
            }

            lo = (_lo + pivot) % nums.size
            hi = (_hi + pivot) % nums.size
            mid = (_mid + pivot) % nums.size
            if (target == nums[mid]) return mid
        }

        return -1
    }

    private fun findPivot(nums: IntArray): Int {
        var hi = nums.size
        var lo = 0
        var mid = (hi - lo) / 2

        while (nums[(hi - mid) / 2] < nums[mid] || nums[(mid - lo) / 2] > nums[mid]) {
            println("hi: " + hi)
            println("lo: " + lo)
            println("mid: " + mid)
            println("num[mid]: " + nums[mid])
            println("num[mid + 1]: " + nums[mid + 1])
            if (nums[mid + 1] < nums[mid]) return mid

            if (nums[(hi - mid) / 2] < nums[mid]) {
                hi = hi
                lo = mid
                mid = (hi - lo) / 2
            } else {
                hi = mid
                lo = lo
                mid = (hi - lo) / 2
            }
        }

        return -1
    }
}