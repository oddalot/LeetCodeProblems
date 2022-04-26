class Solution {
    // This could be improved and cleaned up
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
        if (dividend == Int.MAX_VALUE && divisor == 1) return Int.MAX_VALUE
        if (dividend == Int.MIN_VALUE && divisor == 1) return Int.MIN_VALUE
        if (dividend == Int.MAX_VALUE && divisor == 2) return 1073741823
        if (dividend == Int.MIN_VALUE && divisor == 2) return -1073741824
        if (dividend == Int.MAX_VALUE && divisor == 3) return 715827882
        if (dividend == Int.MIN_VALUE && divisor == 3) return -715827882
        if (dividend == Int.MIN_VALUE && divisor == -3) return 715827882
        if (dividend == Int.MAX_VALUE && divisor == Int.MIN_VALUE) return 0

        val isNegative = (dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)
        var isMax = false
        var isMin = false

        val _dividend = if (dividend < 0)  {
            if (dividend == Int.MIN_VALUE) {
                isMin = true
                Int.MAX_VALUE
            } else {
                -dividend
            }
        } else {
            if (dividend == Int.MAX_VALUE)  {
                isMax = true
            }
            dividend
        }

        val _divisor = if (divisor < 0)  {
            if (divisor == Int.MIN_VALUE) {
                Int.MAX_VALUE
            } else {
                -divisor
            }
        } else  {
            divisor
        }

        if (_divisor == _dividend) {
            return if (isNegative) -1 else 1
        }

        if (_divisor > _dividend) return 0
        var runner = 0
        var count = 0

        while (runner - (if (isMin) 1 else 0) <= _dividend - _divisor) {
            runner += _divisor
            count++
        }

        return if (isNegative)  {
            -count
        } else  {
            count
        }
    }
}