# c03ex02.py
#   Cost per square inch of a pizza

import math

def main():
    print("This program computes the cost per square inch of a pizza.")
    print()

    diam = eval(input("Enter the diameter of the pizza (in inches): "))
    price = eval(input("Enter the price of the pizza (in cents): "))
    area = math.pi * (diam/2.0)**2
    cost = price /area
    print() 
    print("The cost is", cost, "cents per square inch.")

main()

    
