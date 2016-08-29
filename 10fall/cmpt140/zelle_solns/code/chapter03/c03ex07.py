# c03ex07.py
#    Calculates the distance between two points

import math

def main():
    print("This program calculates the distance between two points.")
    print()

    x1, y1 = eval(input("Enter coordinates of the first point (x,y): "))
    x2, y2 = eval(input("Enter coordinates of the second point(x,y): "))
    distance = math.sqrt((x2-x1)**2 + (y2-y1)**2)

    print()
    print("The distance between the points is", distance)

main()
