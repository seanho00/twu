"""Find square root using Newton's method.

Author: Sean Ho for CMPT140
Newton's iterative root-finding method for square-roots.
"""

def newton(x, eps=1e-8):
    """Find square root.
    Pre: x is a positive number (int or float).
        eps is the (optional) level of precision.
    Post: returns square root (float)."""
    prevroot = 0
    root = x/2                          # initial guess
    while abs(root - prevroot) > eps:
        prevroot = root                 # save old guess
        root = (root + x/root)/2        # Newton's step
    return root

# Testbed (not needed for exam):
def main():
    print("Hi! Type a number, and I'll tell you the square root.")
    while True:
        instr = input("\nWhat's your number ('Q' to quit)? ")
        if instr.upper() == 'Q':
            break
        elif float(instr) < 0:
            print("I'm sorry, please type a positive number!")
            continue
        print("The square root is %.8f!" % newton(float(instr)))

main()
