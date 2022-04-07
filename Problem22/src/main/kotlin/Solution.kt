class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) return emptyList()
        var parenSet = mutableSetOf<String>("()")
        if (n == 1) return parenSet.toList()
        (2..n).forEach { _ ->
            val newParenSet = mutableSetOf<String>()
            parenSet.forEach { parens->
                newParenSet.addAll(getParens(parens))
            }
            parenSet = newParenSet
        }

        return parenSet.toList()
    }

    private fun getParens(parens: String): Set<String> {
        val parenSet = mutableSetOf<String>()
        (0..parens.length).forEach { i ->
            parenSet.add(parens.insert(i, "()"))
        }

        return parenSet
    }

    private fun String.insert(index: Int, string: String): String {
        return this.substring(0, index) + string + this.substring(index, this.length)
    }
}