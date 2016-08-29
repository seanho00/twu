"""Class and testbed defining a Fraction.

Sean Ho for CMPT140 demo."""

class Fraction:
    """A Fraction object has an integer numerator and
    denominator, and represents their ratio.
    Instance attributes: __numer, __denom.
    Public methods: getN(), getD()"""
    
    def __init__(self, n=0, d=1):
        """Create a new Fraction, optionally with the
        specified integer numerator and denominator.
        pre: n, d must be integers, d != 0
        post: creates a new Fraction object."""
        self.__numer = int(n)
        self.__denom = int(d)
        self.__reduce()

    def __str__(self):
        """String representation of a Fraction."""
        return "%d/%d" % (self.__numer, self.__denom)

    def __float__(self):
        """Float approximation of a Fraction."""
        return 1.0 * self.__numer / self.__denom

    def getN(self):
        """Accessor: numer"""
        return self.__numer
    def getD(self):
        """Accessor: denom"""
        return self.__denom

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

    def __add__(self, other):
        """Adds self to other Fraction and returns result
        as a new Fraction object.
        pre: other must be a Fraction."""
        s = Fraction( self.getN() * other.getD() +
                      self.getD() * other.getN() ,
                      self.getD() * other.getD() )
        s.__reduce()
        return s

    def __mul__(self, other):
        """Multiples self by other Fraction and returns
        result as a new Fraction object.
        pre: other must be a Fraction."""
        p = Fraction( self.getN() * other.getN(),
                      self.getD() * other.getD() )
        p.__reduce()
        return p

    def __truediv__(self, other):
        """Divides self by other Fraction and returns
        result as a new Fraction object.
        pre: other must be a Fraction."""
        return self * Fraction( other.getD(), other.getN() )
    
    def __sub__(self, other):
        """Subtracts other from self and returns result as
        a new Fraction object.
        pre: other must be a Fraction."""
        return self + Fraction(-1) * other

def runtests():
    """Testbed for Fraction class."""
    # list of tests to run
    tests = [ "Fraction()",
              "Fraction(2)",
              "Fraction(3,2)",
              "Fraction(4,6)",
              "Fraction(2.5)",
              "float(Fraction(3,5))",
              "Fraction(1,3) + Fraction(1,6)",
              "Fraction(7,3) - Fraction(1,3)",
              "Fraction(2,3) * Fraction(9,8)",
              "Fraction(4,3) / Fraction(2,5)" ]
    for test in tests:
        print(test, '=', eval(test))

    # trickier to test errors:
    try:
        ZDEtest = "Fraction(2,0)"
        f1 = eval(ZDEtest)
    except ZeroDivisionError:
        print(ZDEtest, "correctly raised ZDE")
    else:
        print("ERROR!", ZDEtest, "should have raised ZDE",
              "but yielded", f1)

