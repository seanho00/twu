"""Compute partial sum of the harmonic series.

Sean Ho for CMPT140 09FA Midterm 1
This file is in Python 2.
"""

def harmonic(n):
    """Compute partial sum of the harmonic series:
    1/1 + 1/2 + 1/3 + 1/4 + ... + 1/n.
    Pre: n must be an integer > 0.
    Post: Returns the harmonic sum, as a float.
    """
    sum = 0.0
    for i in range(int(n)):
        sum += 1.0 / (i+1)
    return sum

# The rest of this is a testbed program;
# the exam did not require this.

n = input("Compute harmonic sum up to (n>0) n=")	# Py3: int(input(...
print "The sum is: %.10f" % harmonic(n)			# Py3: print(...
