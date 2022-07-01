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
    private val boxes = Array(9) { boxIndex ->
        // 0, 1, 2, 9, 10, 11, 18, 19, 20
        // 3, 4, 5, 12, 13, 14, 21, 22, 23
        // 6, 7, 8, 15, 16, 17, 24, 25, 26
        // 27, 28, 29, 36, 37, 38, 45, 46, 47
        val rowScale = ((boxIndex % 3) * 3) + (27 * (boxIndex / 3))

        arrayOf(
            cells[0 + rowScale],
            cells[1 + rowScale],
            cells[2 + rowScale],
            cells[9 + rowScale],
            cells[10 + rowScale],
            cells[11 + rowScale],
            cells[18 + rowScale],
            cells[19 + rowScale],
            cells[20 + rowScale]
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

        boxes.forEach { box ->
            println("boxes: $boxes")
            box.forEach { cell ->
                println("box cell: ${cell.location}, ${cell.value}")
            }
        }
    }

    fun printFriendlyBoard() {
        println("-------------------------------------------------------")
        rows.forEach { row ->
            row.forEach { cell ->
                print("|")
                print(cell.value)
            }
            println("|")
            println("-------------------------------------------------------")
        }

    }
}

class Cell(var value: Value, val location: Int)

enum class Value {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;

    override fun toString(): String {
        return when (this) {
            EMPTY -> "EMPTY"
            ONE -> "-ONE-"
            TWO -> "-TWO-"
            THREE -> "THREE"
            FOUR -> "-FOUR"
            FIVE -> "-FIVE"
            SIX -> "-SIX-"
            SEVEN -> "SEVEN"
            EIGHT -> "EIGHT"
            NINE -> "-NINE"
        }
    }
}