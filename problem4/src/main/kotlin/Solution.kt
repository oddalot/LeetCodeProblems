class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.isEmpty() || nums2.isEmpty()) {
            throw IllegalArgumentException("Input arrays can not be empty")
        }
        val numList = mutableListOf<Int>()
        val totalSize = nums1.size + nums2.size
        val medianWillBe = totalSize / 2
        val isEven = totalSize % 2 == 0

        var i1 = 0
        var i2 = 0

        while (i1 < nums1.size || i2 < nums2.size) {
            if ((i2 >= nums2.size) || i1 < nums1.size && nums1[i1] < nums2[i2]) {
                numList.add(nums1[i1++])
            } else {
                numList.add(nums2[i2++])
            }

            if ((numList.size - 1) == medianWillBe) break
        }

        return if (isEven) {
            val median = (numList[medianWillBe] + numList[medianWillBe - 1]) / 2.0
            median
        } else {
            val median = numList[medianWillBe]
            median.toDouble()
        }
    }
}