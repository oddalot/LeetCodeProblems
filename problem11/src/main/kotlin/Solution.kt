class Solution {
    fun maxArea(height: IntArray): Int {
        if (height.size < 2) return 0

        val leftMax = maximumSweep(height)
        height.reverse()
        val rightMax = maximumSweep(height)

        return if (leftMax > rightMax) leftMax else rightMax
    }

    private fun maximumSweep(height: IntArray): Int {
        val heightSet = mutableSetOf<HeightPair>()
        var maxArea = 0

        var currentMaxHeight = 0
        (0 until height.size).forEach { i ->
            val currentHeight = height[i]

            heightSet.forEach { (index, firstHeight) ->
                if (currentHeight >= firstHeight)  {
                    val currentArea = firstHeight * (i - index)
                    if (currentArea > maxArea) {
                        maxArea = currentArea
                    }
                }
            }
            if (currentHeight > currentMaxHeight) {
                heightSet.add(HeightPair(i, currentHeight))
                currentMaxHeight = currentHeight
            }
        }

        return maxArea
    }


    private data class HeightPair(val index: Int, val firstHeight: Int)
}