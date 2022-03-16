class Solution {
    fun intToRoman(num: Int): String {
        var place = 1
        var numCheck = num

        return buildString {
            while (numCheck >= 1) {
                val numPlace = numCheck % 10
                numCheck /= 10
                insert(0, romanFromPlace(numPlace, place))
                place++
            }
        }
    }

    private fun romanFromPlace(num: Int, place: Int): String {
        return when (place) {
            1 -> {
                romanOnes(num)
            }
            2 -> {
                romanTens(num)
            }
            3 -> {
                romanHundreds(num)
            }
            4 -> {
                romanThousands(num)
            }
            else -> {
                throw ArithmeticException("only roman numerals up to thousands place supported")
            }
        }
    }

    private fun romanOnes(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "I"
            2 -> "II"
            3 -> "III"
            4 -> "IV"
            5 -> "V"
            6 -> "VI"
            7 -> "VII"
            8 -> "VIII"
            9 -> "IX"
            else -> {
                throw IndexOutOfBoundsException("ones place out of index")
            }
        }
    }

    private fun romanTens(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "X"
            2 -> "XX"
            3 -> "XXX"
            4 -> "XL"
            5 -> "L"
            6 -> "LX"
            7 -> "LXX"
            8 -> "LXXX"
            9 -> "XC"
            else -> {
                throw IndexOutOfBoundsException("tens place out of index")
            }
        }
    }

    private fun romanHundreds(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "C"
            2 -> "CC"
            3 -> "CCC"
            4 -> "CD"
            5 -> "D"
            6 -> "DC"
            7 -> "DCC"
            8 -> "DCCC"
            9 -> "CM"
            else -> {
                throw IndexOutOfBoundsException("hundreds place out of index")
            }
        }
    }

    private fun romanThousands(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "M"
            2 -> "MM"
            3 -> "MMM"
            else -> {
                throw IndexOutOfBoundsException("thousands place out of index, only up to 3 supported")
            }
        }
    }
}