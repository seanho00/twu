# File: c01ex5.py
# Chaos program that prints a variable number of terms

def main():
    print "This program illustrates a chaotic function"
    x = input("Enter a number between 0 and 1: ")
    n = input("How many numbers should I print? ")
    for i in range(n):
        x = 3.9 * x * (1 - x)
        print x

main()
