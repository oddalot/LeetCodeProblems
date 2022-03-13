class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var reversed = 0
        var num = x
        while (num > 0) {
            val digit = num % 10
            reversed = (reversed * 10) + digit
            num /= 10
        }

        return reversed == x
    }
}