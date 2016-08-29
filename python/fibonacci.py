"""Compute Fibonacci numbers.

Sean Ho for CMPT140 demo of recursion.
"""

# recursive version
def rFib(n):
    """Compute nth Fibonacci number:
    fib(0) == 1, fib(1) == 1, etc.
    pre: n must be a positive int.
    post: returns nth Fibonacci number (int>0)."""
    n = int(n)
    if n <= 1:
        return 1
    return rFib(n-2) + rFib(n-1)

# caching version
fibCache = {0:1, 1:1}
def cFib(n):
    """Compute nth Fibonacci number, with caching:
    fib(0) == 1, fib(1) == 1, etc.
    pre: n must be a positive int.
    post: returns nth Fibonacci number (int>0)."""
    n = int(n)
    if n in fibCache:
        return fibCache[n]
    fibCache[n] = cFib(n-2) + cFib(n-1)
    return fibCache[n]

# iterative version
def iFib(n):
    """Compute nth Fibonacci number, iteratively:
    fib(0) == 1, fib(1) == 1, etc.
    pre: n must be a positive int.
    post: returns nth Fibonacci number (int>0)."""
    prev = 1
    cur = 1
    for i in range(int(n/2)):
        cur += prev
        prev += cur
    if n % 2 == 0:
        return cur
    else:
        return prev
