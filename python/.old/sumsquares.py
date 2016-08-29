"""Calculate the sum of squares up to an integer.

Sean Ho
CMPT14x Fall 2008
"""

def sum_squares(n):
    """Return the sum of squares from 1**2 up to n**2.
    n must be a positive integer."""
    sum = 0
    for counter in range(n+1):
        sum += counter*counter
    return sum

# Main program
num = 1
while True:
    num = input("Enter a positive integer [0 to quit]: ")
    if type(num) != type(0) or num <= 0:
        break
    print "  Sum from 1**2 up to %d**2 = %d." % (num, sum_squares(num))

print "Goodbye!  Press <Enter> to close."
raw_input()
