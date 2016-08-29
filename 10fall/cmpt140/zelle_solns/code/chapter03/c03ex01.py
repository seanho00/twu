# c03ex01.py
#    Volume and serface area of a sphere

import math

def main():
    print("This program computes the volume and surface area of a sphere")
    print()

    r = eval(input("Please enter the radius of the sphere: "))
    volume = 4.0/3.0 * math.pi * r**3
    area = 4 * math.pi * r**2

    print("The volume is", volume, "cubic units.")
    print("The surface area is", area, "square units.")

main()

