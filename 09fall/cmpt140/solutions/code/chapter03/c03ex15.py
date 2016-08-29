# c03ex15.py
#    Approximation of pi using Taylor series.

import math

def main():
    print "This program approximates the value of pi by summing a fixed"
    print "number of terms in a series."
    print
    
    n = input("How many terms should I use? ")

    sum = 0.0
    sgn = 1.0   # used to alternate sign of terms
    for denom in range(1, 2*n, 2):
        sum = sum + sgn * 4.0/denom
        sgn = -sgn #flip the sign

    print "Approximation to pi is:", sum
    print "Difference from math.pi:", math.pi - sum

main()
        
