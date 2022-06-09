class Solution {
    fun longestValidParentheses(s: String): Int {
        var left = 0
        var right = 0
        var longestFound = 0

        (0..(s.length - 1)).forEach { i ->
            when (s[i]) {
                '(' -> {
                    left++
                }
                ')' -> {
                    right++
                    if (right > left) {
                        left = 0
                        right = 0
                    } else if (left == right) {
                        val longest = left * 2
                        if (longest > longestFound) {
                            longestFound = longest
                        }
                    }
                }
            }
        }

        left = 0
        right = 0

        ((s.length - 1) downTo 0).forEach { i ->
            when (s[i]) {
                ')' -> {
                    right++
                }
                '(' -> {
                    left++
                    if (left > right) {
                        left++
                        if (left > right) {
                            right = 0
                            left = 0
                        }
                    } else if (right == left) {
                        val longest = right * 2
                        if (longest > longestFound) {
                            longestFound = longest
                        }
                    }
                }
            }
        }

        return longestFound
    }
}