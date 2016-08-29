"""PyUnit test suite for factorial.

Sean Ho demo for CMPT140.
See http://docs.python.org/py3k/library/unittest.html
"""

from factorialtest import factorial
import unittest

class FactorialTests(unittest.TestCase):
    def setUp(self):
        """Fixture: prep for all test cases"""
        self.inputList = [0, 1, 5, 6]

    def tearDown(self):
        """Fixture: cleanup after test cases"""
        del self.inputList      # not really needed

    def test_list(self):
        """Find a bunch of factorials"""
        self.assertEqual(
            [factorial(n) for n in self.inputList],
            [1, 1, 120, 720])

    def test_big(self):
        """Test a big (but valid) factorial"""
        self.assertEqual(
            factorial(30),
            265252859812191058636308480000001)

    def test_neg(self):
        """Test factorial of a negative number (error)"""
        self.assertRaises(ValueError, factorial, -1)

if __name__ == '__main__':
    unittest.main()
    
