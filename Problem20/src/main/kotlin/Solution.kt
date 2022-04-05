class Solution {
    fun isValid(s: String): Boolean {
        if (s.length == 0) return false
        if (s.length == 1) return false
        val parenStack = mutableListOf<Char>()

        s.forEach { paren ->
            when (paren) {
                '(', '{', '[' -> {
                    parenStack.add(paren)
                }
                ')' -> {
                    if (parenStack.lastOrNull() != '(') {
                        return false
                    }
                    parenStack.removeLast()
                }
                '}' -> {
                    if (parenStack.lastOrNull() != '{') {
                        return false
                    }
                    parenStack.removeLast()
                }
                ']' -> {
                    if (parenStack.lastOrNull() != '[') {
                        return false
                    }
                    parenStack.removeLast()
                }
                else -> {
                    throw NoSuchElementException("Character is not a valid parenthesis.")
                }
            }
        }

        return parenStack.isEmpty()
    }

    private fun <T> MutableList<T>.removeLast(): T = if (isEmpty()) throw NoSuchElementException("List is empty.") else removeAt(lastIndex)
}