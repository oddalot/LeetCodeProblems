class Solution {
    fun myAtoi(s: String): Int {
        var newS = s.trim()
        if (newS.isEmpty()) return 0
        var isNegative = false
        var num = 0
        if (newS[0] == '+') {
            newS = newS.substring(1)
        } else if (newS[0] == '-') {
            isNegative = true
            newS = newS.substring(1)
        }
        newS.forEach { char ->
            when {
                numMap.contains(char) -> {
                    val numChar = numMap[char]!!
                    if ((num > (Int.MAX_VALUE - numChar) / 10)) {
                        return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
                    }

                    num = (num * 10) + numChar
                }
                else -> {
                    return if (isNegative) -num else num
                }
            }
        }

        return if (isNegative) -num else num
    }

    private val numMap = mutableMapOf(
        '0' to 0,
        '1' to 1,
        '2' to 2,
        '3' to 3,
        '4' to 4,
        '5' to 5,
        '6' to 6,
        '7' to 7,
        '8' to 8,
        '9' to 9
    )
}