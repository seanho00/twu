# c03ex13.py
#    Sum of numbers entered by the user.

def main():
    print("This program allows you to total up some numbers")
    print()

    n = eval(input("How many numbers do you have? "))
    sum = 0
    for i in range(n):
        num = eval(input("Enter a number: "))
        sum = sum + num

    print()
    print("The sum of the numbers is:", sum)

main()

