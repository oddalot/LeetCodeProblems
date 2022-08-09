class Solution {
    fun countAndSay(n: Int): String {
        var currentCount = "1"
        repeat(n - 1) {
            var numDigits = 1
            var previousDigit = currentCount[0]
            var newCount = StringBuilder()
            (1 until currentCount.length).forEach { i ->
                val currentDigit = currentCount[i]
                if (currentDigit != previousDigit) {
                    newCount.append(numDigits.toString())
                    newCount.append(previousDigit)
                    previousDigit = currentDigit
                    numDigits = 1
                } else {
                    numDigits++
                }
            }

            newCount.append(numDigits.toString())
            newCount.append(previousDigit)
            currentCount = newCount.toString()
        }

        return currentCount
    }
}