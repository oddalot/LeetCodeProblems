class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        solveSudokuHelper(board)
    }

    private fun solveSudokuHelper(board: Array<CharArray>): Boolean {
        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { cellIndex, cell ->
                if (cell == '.') {
                    ('1'..'9').forEach { i ->
                        board[rowIndex][cellIndex] = i
                        if (isValidSudoku(board) && solveSudokuHelper(board)) {
                            return true
                        } else {
                            board[rowIndex][cellIndex] = '.'
                        }
                    }

                    return false
                }
            }
        }

        return true
    }

    private fun isValidSudoku(board: Array<CharArray>): Boolean {
        val boxArrays = Array(9, { CharArray(9) { '.' } })
        val columnArrays = Array(9, { CharArray(9) { '.' } })

        board.forEachIndexed { rowIndex, charArray ->
            val startIndex = when (rowIndex) {
                0, 3, 6 -> 0
                1, 4, 7 -> 3
                2, 5, 8 -> 6
                else -> throw IndexOutOfBoundsException(rowIndex.toString() + " not within index")
            }

            if (!isValidArray(charArray)) return false

            charArray.forEachIndexed { columnIndex, char ->
                val box = when (rowIndex) {
                    0, 1, 2 -> {
                        when (columnIndex) {
                            0, 1, 2 -> 0
                            3, 4, 5 -> 1
                            6, 7, 8 -> 2
                            else -> throw IndexOutOfBoundsException(columnIndex.toString() + " not within index")
                        }
                    }
                    3, 4, 5 -> {
                        when (columnIndex) {
                            0, 1, 2 -> 3
                            3, 4, 5 -> 4
                            6, 7, 8 -> 5
                            else -> throw IndexOutOfBoundsException(columnIndex.toString() + " not within index")
                        }
                    }
                    6, 7, 8 -> {
                        when (columnIndex) {
                            0, 1, 2 -> 6
                            3, 4, 5 -> 7
                            6, 7, 8 -> 8
                            else -> throw IndexOutOfBoundsException(columnIndex.toString() + " not within index")
                        }
                    }
                    else -> throw IndexOutOfBoundsException(rowIndex.toString() + " not within index")
                }

                val boxIndex = startIndex + when (columnIndex) {
                    0, 1, 2 -> columnIndex
                    3, 4, 5 -> columnIndex - 3
                    6, 7, 8 -> columnIndex - 6
                    else -> throw IndexOutOfBoundsException(columnIndex.toString() + " not within index")
                }

                boxArrays[box][boxIndex] = char
                columnArrays[columnIndex][rowIndex] = char
            }
        }

        boxArrays.forEach {
            if (!isValidArray(it)) return false
        }

        columnArrays.forEach {
            if (!isValidArray(it)) return false
        }

        return true
    }

    private fun isValidArray(box: CharArray): Boolean {
        val boxCheck = BooleanArray(9) { false }

        box.forEach { char ->
            val digit = Character.getNumericValue(char)
            if (digit.toInt() <= 9 && digit.toInt() >= 1) {
                if (boxCheck[digit - 1] == true) return false
                boxCheck[digit - 1] = true
            }
        }

        return true
    }
}
