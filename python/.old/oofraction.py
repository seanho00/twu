
"""Fraction library, done the 'right' (object-oriented) way.

This defines a Fraction data structure and some basic operations.
Sean Ho for CMPT14x example
"""

class Fraction:
    def __init__(self, n=0, d=1):
        self.numer = int(n)
        if int(d) == 0:
            raise ZeroDivisionError
        self.denom = int(d)

    def __str__(self):
        """Return a string representation of this fraction."""
        return "%d / %d" % (self.numer, self.denom)

    def __mul__(self, f2):
        """Multiply two fractions.
        Does not reduce the result (i.e., cancel common factors).
        """
        product = Fraction()
        product.numer = self.numer * f2.numer
        product.denom = self.denom * f2.denom
        return product

    def multiply(self, f2):
        return self * f2

    def invert(self):
        """Return the reciprocal fraction."""
        if self.numer == 0:
            raise ZeroDivisionError
        return Fraction(self.denom, self.numer)

    def __div__(self, f2):
        """Divide by another fraction: self/f2."""
        return self.__mul__(f2.invert())
