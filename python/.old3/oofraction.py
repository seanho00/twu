"""Class and testbed defining a Fraction.

Sean Ho for CMPT140 demo."""

class Fraction:
    """A Fraction object has an integer numerator and
    denominator, and represents their ratio."""
    
    def __init__(self, n=0, d=1):
        """Create a new Fraction, optionally with the
        specified integer numerator and denominator.
        pre: n, d must be integers, d != 0
        post: creates a new Fraction object."""
        self.__numer = n
        self.__denom = d
        self.__check()

    def __str__(self):
        """String representation of a Fraction."""
        return "(%d/%d)" % (self.__numer, self.__denom)

    def __float__(self):
        """Float approximation of a Fraction."""
        return 1.0 * self.__numer / self.__denom

    def __check(self):
        """Ensure constraints are met: denom != 0.
        pre: none
        post: none
        raises: ZeroDivisionError."""
        if self.__denom == 0:
            raise ZeroDivisionError

    def __reduce(self):
        """Simplify the Fraction to lowest terms."""
        def gcd(a, b):
            """Euclid's Greatest Common Denominator.
            pre: a, b: integers
            post: returns GCD of (a, b)."""
            if b == 0:
                return a
            return gcd(b, a%b)

        g = gcd(self.__numer, self.__denom)
        self.__numer /= g
        self.__denom /= g
        self.__check()

    def get_N(self):
        """Accessor: numer"""
        return self.__numer
    def get_D(self):
        """Accessor: denom"""
        return self.__denom

    def __add__(self, other):
        """Adds self to other Fraction and returns result
        as a new Fraction object.
        pre: other must be a Fraction."""
        s = Fraction( self.get_N() * other.get_D() +
                      self.get_D() * other.get_N() ,
                      self.get_D() * other.get_D() )
        s.__reduce()
        return s

    def __mul__(self, other):
        """Multiples self by other Fraction and returns
        result as a new Fraction object.
        pre: other must be a Fraction."""
        p = Fraction( self.get_N() * other.get_N(),
                      self.get_D() * other.get_D() )
        p.__reduce()
        return p

    def __div__(self, other):
        """Divides self by other Fraction and returns
        result as a new Fraction object.
        pre: other must be a Fraction."""
        return self * Fraction( other.get_D(), other.get_N() )
    
    def __sub__(self, other):
        """Subtracts other from self and returns result as
        a new Fraction object.
        pre: other must be a Fraction."""
        return self + Fraction(-1) * other
