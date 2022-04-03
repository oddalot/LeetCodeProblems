class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        var oldList = mutableListOf<String>("")
        var newList: MutableList<String>

        digits.forEach { digit ->
            newList = mutableListOf<String>()
            oldList.forEach { oldLetters ->
                val letters = lettersMap[digit]!!
                letters.forEach { newLetter ->
                    newList.add(oldLetters + newLetter)
                }
            }
            oldList = newList
        }

        return oldList
    }

    private val lettersMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
}