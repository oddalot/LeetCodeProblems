import Value.*

class Board(board: Array<CharArray>) {
    private val cells = Array(81) { position -> Cell(position = position) }
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

    init {
        var i = 0
        board.forEach { row ->
            row.forEach { cellChar ->
                val value = cellChar.toValue()
                cells[i++].setUniqueValue(value)
            }
        }

        printFriendlyBoard()

        var valueFilled = true
        while (valueFilled) {
            valueFilled = false
            cells.forEach { cell ->
                if (cell.value == EMPTY) {
                    if (cell.position == 2) {
                        //println(cell.possibleValues)
                    }
                    if (cell.solveSoleCandidate() || cell.solveUniqueCandidate()) {
                        valueFilled = true
                    }
                }
            }

            rows.forEach { row ->
                val nakedSubsets: MutableMap<Pair<Value, Value>, Int> = mutableMapOf()
                row.forEach { cell ->
                    if (cell.possibleValues.size == 2) {
                        val first = if (cell.possibleValues.first() < cell.possibleValues.last()) {
                            cell.possibleValues.first()
                        } else {
                            cell.possibleValues.last()
                        }
                        val second = if (first == cell.possibleValues.first()) {
                            cell.possibleValues.last()
                        } else {
                            cell.possibleValues.first()
                        }
                        val foundSubset = nakedSubsets[Pair(first, second)]
                        if (foundSubset == null) {
                            nakedSubsets[Pair(first, second)] = 1
                        } else {
                            nakedSubsets[Pair(first, second)] = foundSubset + 1
                        }
                    }
                }

                nakedSubsets.forEach { (pair, value) ->
                    if (value == 2) {
                        row.forEach { cell ->
                            if (cell.possibleValues.size > 2 && cell.possibleValues.contains(pair.first) && cell.possibleValues.contains(
                                    pair.second
                                )
                            ) {
                                println("inhere1 :" + cell.position)
                                valueFilled = true
                                cell.removeValue(pair.first)
                                cell.removeValue(pair.second)
                            }
                        }
                    }
                }
            }
        }

        println("solved")

        printFriendlyBoard()
    }

    fun printBoard() {
        cells.forEach { cell ->
            println("cell: ${cell.position}, ${cell.value}")
        }

        rows.forEach { row ->
            println("row: $row")
            row.forEach { cell ->
                println("row cell: ${cell.position}, ${cell.value}")
            }
        }

        columns.forEach { column ->
            println("column: $column")
            column.forEach { cell ->
                println("column cell: ${cell.position}, ${cell.value}")
            }
        }

        boxes.forEach { box ->
            println("boxes: $boxes")
            box.forEach { cell ->
                println("box cell: ${cell.position}, ${cell.value}")
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

    /*
    private val Cell.possibleValues: Set<Value>
        get() {
            val rowValues = rows[position / 9]
            val columnValues = columns[position % 9]
            val boxValues = boxes[((position / 3) % 3) + ((position / 27) * 3)]

            return allPossibleValues - rowValues - columnValues - boxValues
        }

    private val Cell.otherBoxPossibleValues: Set<Value>
        get() {
            val boxValues = boxes[((position / 3) % 3) + ((position / 27) * 3)]
            val otherPossibleValues = mutableSetOf<Value>()
            boxValues.cells.forEach { cell ->
                if (cell.position != position) {
                    otherPossibleValues.addAll(cell.possibleValues)
                }
            }

            return otherPossibleValues
        }

    private val Cell.otherRowPossibleValues: Set<Value>
        get() {
            val rowValues = rows[position / 9]
            val otherPossibleValues = mutableSetOf<Value>()
            rowValues.cells.forEach { cell ->
                if (cell.position != position) {
                    otherPossibleValues.addAll(cell.possibleValues)
                }
            }

            return otherPossibleValues
        }
    private val Cell.otherColumnPossibleValues: Set<Value>
        get() {
            val columnValues = columns[position % 9]
            val otherPossibleValues = mutableSetOf<Value>()
            columnValues.cells.forEach { cell ->
                if (cell.position != position) {
                    otherPossibleValues.addAll(cell.possibleValues)
                }
            }

            return otherPossibleValues
        }


    fun printPossibleValuesForPosition(position: Int) {
        val rowValues = rows[position / 9].values
        val columnValues = columns[position % 9].values
        val boxValues = boxes[((position / 3) % 3) + ((position / 27) * 3)].values
        println(allPossibleValues - rowValues - columnValues - boxValues)
    }


     */

    private fun Cell.setUniqueValue(value: Value) {
        if (value == EMPTY) return
        rows[position / 9].forEach { cell ->
            if (cell.position == this.position) {
                cell.removeOtherValues(value)
            } else {
                cell.removeValue(value)
            }
        }
        columns[position % 9].forEach { cell ->
            if (cell.position == this.position) {
                cell.removeOtherValues(value)
            } else {
                cell.removeValue(value)
            }
        }
        boxes[((position / 3) % 3) + ((position / 27) * 3)].forEach { cell ->
            if (cell.position == this.position) {
                cell.removeOtherValues(value)
            } else {
                cell.removeValue(value)
            }
        }

        println("this pos and val " + this.position + " " + this.possibleValues)
    }

    private fun Cell.solveSoleCandidate(): Boolean {
        val otherPossibleValues = mutableSetOf(
            ONE,
            TWO,
            THREE,
            FOUR,
            FIVE,
            SIX,
            SEVEN,
            EIGHT,
            NINE
        )
        rows[position / 9].forEach { cell ->
            if (cell.position != this.position) {
                if (cell.value != EMPTY) otherPossibleValues.remove(cell.value)
            }
        }
        columns[position % 9].forEach { cell ->
            if (cell.position != this.position) {
                if (cell.value != EMPTY) otherPossibleValues.remove(cell.value)
            }
        }
        boxes[((position / 3) % 3) + ((position / 27) * 3)].forEach { cell ->
            if (cell.position != this.position) {
                if (cell.value != EMPTY) otherPossibleValues.remove(cell.value)
            }
        }

        return if (otherPossibleValues.size == 1) {
            //println("otherpos: " + this.position)
            //println("otherpos values:" + this.possibleValues)
            if (this.position == 40) println("solve40 " + otherPossibleValues.first())
            this.setUniqueValue(otherPossibleValues.first())
            //println("otherpos values after:" + this.possibleValues)
            true
        } else {
            false
        }
    }

    private fun Cell.solveUniqueCandidate(): Boolean {
        val otherPossibleValues = mutableSetOf<Value>()
        rows[position / 9].forEach { cell ->
            if (cell.position != this.position) {
                otherPossibleValues.addAll(cell.possibleValues)
            }
        }
        columns[position % 9].forEach { cell ->
            if (cell.position != this.position) {
                otherPossibleValues.addAll(cell.possibleValues)
            }
        }
        boxes[((position / 3) % 3) + ((position / 27) * 3)].forEach { cell ->
            if (cell.position != this.position) {
                otherPossibleValues.addAll(cell.possibleValues)
            }
        }

        val candidates = this.possibleValues - otherPossibleValues
        return if (candidates.size == 1) {
            this.setUniqueValue(candidates.first())
            true
        } else {
            false
        }
    }
}

private val allPossibleValues = setOf(
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE
)

class Cell(val position: Int) {
    private val _possibleValues = mutableSetOf(
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE
    )
    val possibleValues: Set<Value> = _possibleValues

    fun removeValue(value: Value) {
        if (position == 40) println("removing40Value: " + value)
        _possibleValues.remove(value)
    }

    fun removeOtherValues(value: Value) {
        if (position == 40) println("removing40ValueAll: " + value)
        _possibleValues.removeIf { possibleValue ->
            possibleValue != value
        }
    }
}

val Cell.value: Value
    get() {
        return if (this.possibleValues.size == 1) {
            this.possibleValues.first()
        } else {
            EMPTY
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
        '1' -> ONE
        '2' -> TWO
        '3' -> THREE
        '4' -> FOUR
        '5' -> FIVE
        '6' -> SIX
        '7' -> SEVEN
        '8' -> EIGHT
        '9' -> NINE
        else -> EMPTY
    }
}