"""Pseudo-random number generator.

Sean Ho
CMPT14x example 2006.
"""

from math import exp, log, pi

seed = 0.0	# persistent across calls to Random()

def init_seed (x):
    """Initialize the number generator seed.
    Accessor (set) function for seed."""
    global seed
    seed = x

def random ():
    """Returns a random float between 0 and 1."""
    global seed
    # Try to scramble up seed as much as possible
    seed += pi
    seed **= 7

    # Just keep fractional part, in range 0..1
    seed = seed - int (seed)
    return seed
