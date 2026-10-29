class Solution:
    def divide(self, dividend, divisor):
        INT_MAX = 2**31 - 1
        INT_MIN = -(2**31)

        if dividend == INT_MIN and divisor == -1:
            return INT_MAX

        negative = (dividend < 0) != (divisor < 0)
        a, b = abs(dividend), abs(divisor)
        quotient = 0

        while a >= b:
            value = b
            multiple = 1

            while a >= (value << 1):
                value <<= 1
                multiple <<= 1

            a -= value
            quotient += multiple

        return -quotient if negative else quotient