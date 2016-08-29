"""Testbed for cplx library.

Sean Ho
CMPT14x example 2007.
"""

import cplx

c1 = cplx.cplx(2, 3)     # 2 + 3i
c2 = cplx.cplx(0, -1)    # -i

print "c1:", cplx.string(c1), "; c2:", cplx.string(c2)

print "c1+c2:", cplx.string(cplx.add(c1, c2))
print "c1-c2:", cplx.string(cplx.sub(c1, c2))
print "c1*c2:", cplx.string(cplx.mul(c1, c2))
print "c1**4:", cplx.string(cplx.intpow(c1, 4))
print "c1**0:", cplx.string(cplx.intpow(c1, 0))
print "random:", cplx.string(cplx.rand())
