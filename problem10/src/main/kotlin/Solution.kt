class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return isMatchRecursive(s, p)
    }

    private fun isMatchRecursive(s: String, p: String): Boolean {
        if (p == "") return s == ""

        if (p.length >= 2 && p[1] == '*' && s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')) {
            return isMatchRecursive(s.substring(1), p) || isMatchRecursive(s, p.substring(2))
        } else if (p.length >= 2 && p[1] == '*') {
            return isMatchRecursive(s, p.substring(2))
        }

        return if (s.isNotEmpty()) {
            if (s[0] == p[0] || p[0] == '.') {
                isMatchRecursive(s.substring(1), p.substring(1))
            } else {
                false
            }
        } else {
            false
        }
    }
}