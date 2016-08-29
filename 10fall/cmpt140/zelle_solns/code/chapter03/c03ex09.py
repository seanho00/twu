# c03ex09.py
#    Area of triangle using Heron's formula

import math

def main():
    print("This program calculates the are of a triangle.")
    print()

    a, b, c = eval(input("Enter the lengths of the sides (a,b,c): "))
    s = (a+b+c)/2
    area = math.sqrt(s*(s-a)*(s-b)*(s-c))

    print()
    print("The area is", area, "square units.")

main()
