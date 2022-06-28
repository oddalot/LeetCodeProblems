import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `returns true if is a valid sudoku`() {
        val board = arrayOf(
            charArrayOf('.', '8', '6', '.', '1', '.', '.', '4', '3'),
            charArrayOf('.', '.', '9', '.', '.', '7', '.', '6', '5'),
            charArrayOf('.', '5', '2', '6', '.', '3', '.', '.', '.'),
            charArrayOf('.', '7', '.', '.', '3', '.', '5', '.', '.'),
            charArrayOf('.', '.', '.', '5', '9', '.', '4', '3', '.'),
            charArrayOf('.', '3', '5', '.', '.', '4', '.', '1', '.'),
            charArrayOf('.', '.', '.', '8', '.', '1', '6', '.', '.'),
            charArrayOf('6', '2', '7', '3', '.', '.', '1', '.', '8'),
            charArrayOf('.', '9', '8', '.', '.', '6', '3', '7', '.'),
        )

        assertEquals(true, solution.isValidSudoku(board))
    }

    @Test
    fun `returns false if is an invalid sudoku`() {
        val board = arrayOf(
            charArrayOf('.', '8', '6', '.', '1', '.', '.', '4', '3'),
            charArrayOf('.', '.', '9', '.', '.', '7', '.', '6', '5'),
            charArrayOf('.', '5', '2', '6', '.', '3', '.', '.', '.'),
            charArrayOf('.', '7', '.', '.', '3', '.', '5', '.', '.'),
            charArrayOf('.', '.', '.', '5', '9', '.', '4', '3', '.'),
            charArrayOf('.', '3', '5', '.', '.', '4', '4', '1', '.'),
            charArrayOf('.', '.', '.', '8', '.', '1', '6', '.', '.'),
            charArrayOf('6', '2', '7', '3', '.', '.', '1', '.', '8'),
            charArrayOf('.', '9', '8', '.', '.', '6', '3', '7', '.'),
        )

        assertEquals(false, solution.isValidSudoku(board))
    }
}