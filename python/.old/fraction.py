"""Fraction library.

This defines a Fraction data structure and some basic operations.
Sean Ho for CMPT14x example
"""

def create(numer, denom):
    """Return a new fraction object.
    pre: numer and denom must be integers; denom cannot be zero.
    """
    return (numer, denom)

def get_n(frac):
    """Return the top of the fraction."""
    return frac[0]

def get_d(frac):
    """Return the bottom of the fraction."""
    return frac[1]

def to_string(frac):
    """Return a string representation of a fraction."""
    return "%d / %d" % (get_n(frac), get_d(frac))

def mult(f1, f2):
    """Multiply two fractions.
    Does not reduce the result (i.e., cancel common factors).
    """
    return (get_n(f1)*get_n(f2), get_d(f1)*get_d(f2))

def invert(frac):
    """Return the reciprocal fraction."""
    if get_n(frac) == 0:
        return 1/0          # raise ZeroDivisionError
    return (get_d(frac), get_n(frac))

def divide(f1, f2):
    """Divide two fractions: f1/f2."""
    return mult(f1, invert(f2))
