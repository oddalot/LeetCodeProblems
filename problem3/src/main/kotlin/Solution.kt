class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) return s.length
        val letterSet = mutableSetOf<Char>()
        var longestLength = 1
        var i = 0
        var j = 0


        while (j < s.length) {
            val jLetter = s[j]

            while (letterSet.contains(jLetter)) {
                letterSet.remove(s[i])
                i++
            }

            j++
            letterSet.add(jLetter)

            if (letterSet.size > longestLength) longestLength = letterSet.size
        }

        return longestLength
    }
}