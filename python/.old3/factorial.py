"""Functions to compute n!.

Demo by Sean Ho for CMPT140.
"""

# Iterative solution
def iFact(n):
    """Compute n! (factorial).
    pre: n must be integer >= 0.
    post: returns n! (integer)."""
    prod = 1
    for idx in range(1,n+1):
        prod *= idx
    return prod

# Recursive solution
def rFact(n):
    """Compute n! (factorial).
    pre: n must be integer >= 0.
    post: returns n! (integer)."""
    if n < 2:
        return 1
    else:
        return n*rFact(n-1)

# Caching recursive solution
factorialCache = {0:1}
def cFact(n):
    """Compute n! (factorial).
    pre: n must be integer >= 0.
    post: returns n! (integer)."""
    if n in factorialCache.keys():
        return factorialCache[n]
    factorialCache[n] = n*cFact(n-1)
    return factorialCache[n]
