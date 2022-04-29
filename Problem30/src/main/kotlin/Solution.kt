class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val substringMatch = SubstringMatch(words)
        val wordsSet = words.toSet()
        val wordLength = words[0].length
        val indexList = mutableListOf<Int>()

        (0..(s.length - (wordLength * words.size))).forEach { i ->
            if (wordsSet.contains(s.substring(i, i + wordLength))) {
                if (substringMatch.checkWords(s.substring(i, i + (wordLength * words.size)))) {
                    indexList.add(i)
                }
            }
        }

        return indexList
    }

    class SubstringMatch(words: Array<String>) {
        private val _words: Map<String, Int>
        private var _wordsCheck: MutableMap<String, Int>
        private val wordLength = words.get(0)!!.length

        init {
            val wordMap = mutableMapOf<String, Int>()
            words.forEach { word ->
                val foundCount = wordMap[word]

                if (foundCount != null) {
                    wordMap[word] = foundCount + 1
                } else {
                    wordMap[word] = 1
                }
            }
            _words = wordMap.toMap()
            _wordsCheck = _words.toMutableMap()
        }

        fun resetWords() {
            _wordsCheck = _words.toMutableMap()
        }

        fun checkWords(words: String): Boolean {
            (0 until words.length step wordLength).forEach { i ->
                val word = words.substring(i, i + wordLength)

                val foundCount = _wordsCheck[word]
                if (foundCount != null) {
                    _wordsCheck[word] = foundCount - 1
                    if (_wordsCheck[word] == 0) _wordsCheck.remove(word)
                } else {
                    _wordsCheck = _words.toMutableMap()
                    return false
                }
            }

            val hasWords = _wordsCheck.isEmpty()
            _wordsCheck = _words.toMutableMap()
            return hasWords
        }
    }
}