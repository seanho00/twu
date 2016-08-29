"""Calculate pi using Leibniz' infinite series.

The leibniz() function does the work; the body of this module
is a small test suite for the leibniz() function.
Sean Ho, CMPT140 6Oct2006.
"""

from math import pi     # as a double-check

def leibniz(num_terms):
    """Calculate pi using Leibniz' infinite series.
    pre: num_terms should be a positive integer.
    post: returns a float estimate of pi."""
    sum = 0.0
    for n in range(num_terms+1):
        sum += (-1)**n / (2*float(n) + 1)
    return sum*4

# Test suite for the leibniz() function
print "Let's estimate pi using Leibniz' formula!"

n = input("How many terms should I use (>=0, enter -1 to quit)? ")
while n >= 0:
    mypi = leibniz(n)
    print "pi = %.40f" % mypi
    print "error = %f" % (pi - mypi)
    n = input("How many terms should I use (>=0, enter -1 to quit)? ")

print "Bye!"
