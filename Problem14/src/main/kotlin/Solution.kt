class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var longestPrefix = strs[0]

        strs.forEach { str ->
            if (longestPrefix.length > str.length) {
                longestPrefix = longestPrefix.substring(0, str.length)
            }
            while (str.substring(0, longestPrefix.length) != longestPrefix) {
                longestPrefix = longestPrefix.substring(0, longestPrefix.length - 1)
                if (longestPrefix == "") return longestPrefix
            }
        }

        return longestPrefix
    }
}