import org.junit.jupiter.api.Assertions.assertArrayEquals
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Test {
    private val solution = Solution()

    @Test
    fun `solves easy board`() {
        val boardEasy = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        val boardEasySolved = arrayOf(
            charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
            charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
            charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
            charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
            charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
            charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
            charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
            charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
            charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
        )

        solution.solveSudoku(boardEasy)

        assertArrayEquals(boardEasySolved, boardEasy)
    }

    @Test
    fun `solves medium board`() {
        val boardMedium = arrayOf(
            charArrayOf('.', '7', '4', '.', '.', '.', '8', '5', '.'),
            charArrayOf('.', '5', '.', '7', '.', '1', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '8', '5', '7', '.', '2'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '.', '.'),
            charArrayOf('.', '3', '.', '5', '7', '.', '.', '9', '6'),
            charArrayOf('.', '.', '1', '.', '.', '6', '5', '.', '4'),
            charArrayOf('3', '.', '6', '.', '1', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '6', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '8', '5', '4', '6', '1', '3')
        )

        val boardMediumSolved = arrayOf(
            charArrayOf('2', '7', '4', '6', '9', '3', '8', '5', '1'),
            charArrayOf('6', '5', '8', '7', '2', '1', '3', '4', '9'),
            charArrayOf('9', '1', '3', '4', '8', '5', '7', '6', '2'),
            charArrayOf('5', '6', '7', '1', '4', '9', '2', '3', '8'),
            charArrayOf('4', '3', '2', '5', '7', '8', '1', '9', '6'),
            charArrayOf('8', '9', '1', '2', '3', '6', '5', '7', '4'),
            charArrayOf('3', '8', '6', '9', '1', '7', '4', '2', '5'),
            charArrayOf('1', '4', '5', '3', '6', '2', '9', '8', '7'),
            charArrayOf('7', '2', '9', '8', '5', '4', '6', '1', '3')
        )

        solution.solveSudoku(boardMedium)

        assertArrayEquals(boardMediumSolved, boardMedium)
    }
}




