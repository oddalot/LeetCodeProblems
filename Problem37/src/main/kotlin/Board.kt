class Board(board: Array<CharArray>) {
    private val cells = Array(81) { position -> Cell(position = position) }
    private val rows = Array(9) { columnIndex ->
        val columnScale = columnIndex * 9
        ValueSet(
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
        )
    }
    private val columns = Array(9) { rowIndex ->
        ValueSet(
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
        )
    }
    private val boxes = Array(9) { boxIndex ->
        // 0, 1, 2, 9, 10, 11, 18, 19, 20
        // 3, 4, 5, 12, 13, 14, 21, 22, 23
        // 6, 7, 8, 15, 16, 17, 24, 25, 26
        // 27, 28, 29, 36, 37, 38, 45, 46, 47
        val rowScale = ((boxIndex % 3) * 3) + (27 * (boxIndex / 3))

        ValueSet(
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
        )
    }

    init {
        var i = 0
        board.forEach { row ->
            row.forEach { cellChar ->
                this.setCellValue(i++, cellChar.toValue())
            }
        }
    }

    fun printBoard() {
        cells.forEach { cell ->
            println("cell: ${cell.position}, ${cell.value}")
        }

        rows.forEach { row ->
            println("row: $row")
            row.cells.forEach { cell ->
                println("row cell: ${cell.position}, ${cell.value}")
            }
        }

        columns.forEach { column ->
            println("column: $column")
            column.cells.forEach { cell ->
                println("column cell: ${cell.position}, ${cell.value}")
            }
        }

        boxes.forEach { box ->
            println("boxes: $boxes")
            box.cells.forEach { cell ->
                println("box cell: ${cell.position}, ${cell.value}")
            }
        }
    }

    fun printFriendlyBoard() {
        println("-------------------------------------------------------")
        rows.forEach { row ->
            row.cells.forEach { cell ->
                print("|")
                print(cell.value)
            }
            println("|")
            println("-------------------------------------------------------")
        }

    }

    fun printPossibleValuesForPosition(position: Int) {
        val rowValues = rows[position / 9].values
        val columnValues = columns[position % 9].values
        val boxValues = boxes[((position / 3) % 3) + ((position / 27) * 3)].values
        println(allPossibleValues - rowValues - columnValues - boxValues)
    }

    private fun setCellValue(position: Int, value: Value) {
        cells[position].setValue(value)
        rows[position / 9].updateValues(value)
        columns[position % 9].updateValues(value)
        // 0, 1, 2, 3, 4, 5, 6, 7, 8
        // 0, 0, 0, 1, 1, 1, 2, 2, 2

        // 9, 10, 11, 12, 13, 14, 15, 16, 17
        // 0,  0,  0,  1,  1,  1,  2,  2,  2
        boxes[((position / 3) % 3) + ((position / 27) * 3)].updateValues(value)
    }
}

interface ValueSetInterface {
    val cells: Array<Cell>

    val values: Set<Value>
    val possibleValues: Set<Value>

    fun updateValues(value: Value)
}

class ValueSet(override val cells: Array<Cell>) : ValueSetInterface {
    private val _values = mutableSetOf<Value>()
    override val values: Set<Value> = _values

    override val possibleValues: Set<Value>
        get() = allPossibleValues - values

    override fun updateValues(value: Value) {
        if (value != Value.EMPTY) _values.add(value)
    }

}

private val allPossibleValues = setOf(
    Value.ONE,
    Value.TWO,
    Value.THREE,
    Value.FOUR,
    Value.FIVE,
    Value.SIX,
    Value.SEVEN,
    Value.EIGHT,
    Value.NINE
)

class Cell(val position: Int) {
    var value: Value = Value.EMPTY
        private set

    fun setValue(value: Value) {
        this.value = value
    }
}

enum class Value {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;

    override fun toString(): String {
        return when (this) {
            EMPTY -> "--.--"
            ONE -> "--1--"
            TWO -> "--2--"
            THREE -> "--3--"
            FOUR -> "--4--"
            FIVE -> "--5--"
            SIX -> "--6--"
            SEVEN -> "--7--"
            EIGHT -> "--8--"
            NINE -> "--9--"
        }
    }
}

private fun Char.toValue(): Value {
    return when (this) {
        '1' -> Value.ONE
        '2' -> Value.TWO
        '3' -> Value.THREE
        '4' -> Value.FOUR
        '5' -> Value.FIVE
        '6' -> Value.SIX
        '7' -> Value.SEVEN
        '8' -> Value.EIGHT
        '9' -> Value.NINE
        else -> Value.EMPTY
    }
}