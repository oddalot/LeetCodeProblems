class Solution {
    fun romanToInt(s: String): Int {
        var sum = 0
        var place = 0
        ((s.length - 1) downTo 0).forEach { i ->
            val roman = s[i]
            val romanValue = romanMap[roman] ?: throw RuntimeException("roman not in map")
            val placeValue = placeMap[roman] ?: throw RuntimeException("place not in map")

            if (placeValue >= place) {
                sum += romanValue
            } else {
                sum -= romanValue
            }
            place = placeValue
        }

        return sum
    }

    private val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    private val placeMap = mapOf(
        'I' to 1,
        'V' to 2,
        'X' to 3,
        'L' to 4,
        'C' to 5,
        'D' to 6,
        'M' to 7
    )
}