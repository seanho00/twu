"""Fibonacci numbers.

Sean Ho for CMPT14x 2006 example
"""

def fib(n):
    """Calculate the nth Fibonacci number.  (n >= 0)."""
    if n == 0 or n == 1:
        return 1
    return fib(n-1) + fib(n-2)

# base case for hinting Fibonacci
fibHints = {0:1, 1:1}

def hFib(n):
    """Calculate the nth Fibonacci number, with hinting. (n >= 0)."""
    if n in fibHints:
        return fibHints[n]
    fibHints[n] = hFib(n-1) + hFib(n-2)
    return fibHints[n]

# Even better: use iteration instead of recursion
def iFib(n):
    """Calculate the nth Fibonacci number, with loops. (n >= 0)."""
    current = 1
    parent = 1
    grandparent = 0
    for i in range(int(n)):
        current = grandparent + parent
        grandparent = parent
        parent = current
    return current
