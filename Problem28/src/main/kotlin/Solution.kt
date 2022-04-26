class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty() || needle.length > haystack.length) return -1
        var i = 0
        while (i + needle.length <= haystack.length) {
            val check = haystack[i]
            if (check == needle[0]) {
                if (haystack.substring(i, i + needle.length) == needle) {
                    return i
                }
            }
            i++
        }
        return -1
    }
}