class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) throw IllegalArgumentException("Input string can not be empty")
        var longestPalindrome = ""
        (0 until s.length).forEach { i ->
            val palindromeOdd = findLongestPalindromeOdd(i, s)
            if (palindromeOdd.length > longestPalindrome.length) {
                longestPalindrome = palindromeOdd
            }
            if (i > 0) {
                val palindromeEven = findLongestPalindromeEven(i, s)
                if (palindromeEven.length > longestPalindrome.length) {
                    longestPalindrome = palindromeEven
                }
            }
        }

        return longestPalindrome
    }

    private fun findLongestPalindromeOdd(index: Int, s: String): String {
        var longestPalindrome = s[index].toString()
        var i = index + 1
        var j = index - 1
        while (i < s.length && j >= 0) {
            if (s[i] != s[j]) return longestPalindrome
            longestPalindrome = s.substring(j, i + 1)
            i++
            j--
        }

        return longestPalindrome
    }

    private fun findLongestPalindromeEven(index: Int, s: String): String {
        var longestPalindrome = ""
        var j = index - 1
        var i = index

        while (i < s.length && j >= 0) {
            if (s[i] != s[j]) return longestPalindrome
            longestPalindrome = s.substring(j, i + 1)
            i++
            j--
        }

        return longestPalindrome
    }

    private val String.isPalindrome: Boolean
        get() {
            var i = 0
            while (i < (this.length / 2)) {
                val j = this.length - 1 - i
                if (this[i] != this[j]) return false
                i++
            }

            return true
        }
}