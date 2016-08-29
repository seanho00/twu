"""Complex number library.

Sean Ho
CMPT14x example 2006.
"""

import random

# Main public functions
def cplx(re,im):
    """Create a complex number object with the given real and imaginary parts."""
    return (float(re), float(im))

def real(c):
    """Return the real part of a complex number."""
    return c[0]

def imag(c):
    """Return the imaginary part of a complex number."""
    return c[1]

def neg(c):
    """Negate a complex number: -c."""
    return cplx(-real(c), -imag(c))

def add(c1, c2):
    """Add two complex numbers."""
    return cplx(real(c1)+real(c2), imag(c1)+imag(c2))

def sub(c1, c2):
    """Subtract two complex numbers: c1 - c2."""
    return add(c1, neg(c2))

def mul(c1, c2):
    """Multiply two complex numbers: c1 * c2."""
    return cplx(real(c1)*real(c2) - imag(c1)*imag(c2),
                real(c1)*imag(c2) + imag(c1)*real(c2))

def intpow(c, n):
    """Raise the complex number c to the positive power n."""
    result = cplx(1,0)
    for i in range(n):
        result = mul(result, c)
    return result

def rand():
    """Return a random complex number with real and imaginary parts between
    0 and 1."""
    return cplx(random.random(), random.random())

def string(c):
    """Return pretty-printed string representation of the complex number.
    c: a complex number such as created by cplx()."""
    return "%.2f + %.2fj" % (real(c), imag(c))
