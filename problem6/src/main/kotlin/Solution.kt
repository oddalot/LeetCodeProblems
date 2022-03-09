class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 0) return ""
        if (numRows == 1) return s
        val strArray = Array(numRows) { "" }
        s.forEachIndexed { index, letter ->
            appendToArray(index, letter, numRows, strArray)
        }

        return buildString {
            strArray.forEach { str ->
                append(str)
            }
        }
    }

    private fun appendToArray(index: Int, letter: Char, numRows: Int, strArray: Array<String>) {
        val modLength = (numRows * 2) - 2
        val modIndex = index % modLength
        val newIndex = if (modIndex >= (numRows - 1)) {
            modLength - modIndex
        } else {
            modIndex
        }
        strArray[newIndex] = strArray[newIndex] + letter
    }
}