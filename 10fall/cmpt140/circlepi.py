"""Estimate pi by calculating area of unit quarter-circle.

Sean Ho
CMPT14x example 2010.
"""

import unittest

def circle_pi(count):
    """Estimate pi by generating 'count' # of points 
    and counting what fraction within the unit quarter-circle.
    Pre: count should be a positive integer.
    Post: Returns an estimate of pi as a float."""

    from random import random
    if count < 1:
            raise ValueError
    incircle = 0
    for i in range(count):
        if random()**2 + random()**2 < 1:
            incircle += 1
    return 4*incircle/count

class CircleTests(unittest.TestCase):
    """Unit tests for the circle_pi() function."""

    def test_0(self):
        """Raise an exception if count is zero."""
        self.assertRaises( ValueError, circle_pi, 0 )

    def test_neg(self):
        """Raise an exception if count is negative."""
        self.assertRaises( ValueError, circle_pi, -1 )

    def test_float(self):
        """Count cannot be a float."""
        self.assertRaises( TypeError, circle_pi, 1.0 )

    def test_str(self):
        """Count cannot be a string."""
        self.assertRaises( TypeError, circle_pi, '' )

    def test_1(self):
        """Return either 0 or 4 if only one point is used."""
        self.assertIn( circle_pi(1), [0, 4] )

    def test_good(self):
        """Approximation should be pretty close for large counts."""
        from math import pi
        self.assertAlmostEqual( circle_pi(int(1e7)), pi, 3 )

if __name__ == '__main__':
      unittest.main()

