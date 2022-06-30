class Board {
    private val cells = Array(81) { location -> Cell(Value.EMPTY, location) }
    private val rows = Array(9) { columnIndex ->
        val columnScale = columnIndex * 9
        arrayOf(
            cells[0 + columnScale],
            cells[1 + columnScale],
            cells[2 + columnScale],
            cells[3 + columnScale],
            cells[4 + columnScale],
            cells[5 + columnScale],
            cells[6 + columnScale],
            cells[7 + columnScale],
            cells[8 + columnScale]
        )
    }
    private val columns = Array(9) { rowIndex ->
        arrayOf(
            cells[rowIndex],
            cells[rowIndex + (9 * 1)],
            cells[rowIndex + (9 * 2)],
            cells[rowIndex + (9 * 3)],
            cells[rowIndex + (9 * 4)],
            cells[rowIndex + (9 * 5)],
            cells[rowIndex + (9 * 6)],
            cells[rowIndex + (9 * 7)],
            cells[rowIndex + (9 * 8)]
        )
    }

    fun printBoard() {
        cells.forEach { cell ->
            println("cell: ${cell.location}, ${cell.value}")
        }

        rows.forEach { row ->
            println("row: $row")
            row.forEach { cell ->
                println("row cell: ${cell.location}, ${cell.value}")
            }
        }

        columns.forEach { column ->
            println("column: $column")
            column.forEach { cell ->
                println("column cell: ${cell.location}, ${cell.value}")
            }
        }
    }
}

class Cell(val value: Value, val location: Int)

enum class Value {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}