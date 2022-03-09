class Solution {
    fun reverse(x: Int): Int {
        val newX: Int
        val isNegative = if (x < 0) {
            newX = -x
            true
        } else {
            newX = x
            false
        }

        val reversedX = newX.toString().reversed()
        return if (isNegative) {
            try {
                ("-$reversedX").toInt()
            } catch(e: NumberFormatException) {
                0
            }
        } else {
            try {
                reversedX.toInt()
            } catch (e: NumberFormatException) {
                0
            }
        }
    }
}