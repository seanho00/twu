"""Example of scope and namespaces.

Sean Ho for CMPT14x 2006
"""

# Global to this module
G1 = 'global one'

# Function definition starts a local scope
def fun1(P1):
    global G1
    G1 = 'numApples'
    L1 = 'local one'
    from string import upper

    # Function definitions can be nested
    def fun2(P2):
        L2 = 'local two'
        G1 = 'local reassign'
        print 'G1: %s; P1: %s; L1: %s; P2: %s; L2: %s' % \
              (G1, P1, L1, P2, L2)
        return upper(P2)

    ret = fun2(P1)
    print 'G1: %s; P1: %s; L1: %s' % (G1, P1, L1)
    return ret

