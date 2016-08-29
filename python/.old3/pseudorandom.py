"""Pseudo-random number generator.

Sean Ho
CMPT14x example 2006.
"""

__seed = 0.0	# persistent across calls to random()

def init_seed(s):
    """Initialize the number generator seed.
    Accessor (set) function for seed."""
    global __seed
    __seed = s

def random():
    """Returns a random float between 0 and 1."""
    from math import pi
    global __seed
    # Try to scramble up seed as much as possible
    __seed += pi
    __seed **= 11

    # Just keep fractional part, in range 0..1
    __seed %= 1
    return __seed
