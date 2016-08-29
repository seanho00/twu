# c03ex14.py
#    Average of numbers entered by the user.

def main():
    print("Program to calculate average")
    print()

    n = eval(input("How many numbers do you have? "))
    sum = 0
    for i in range(n):
        num = eval(input("Enter a number: "))
        sum = sum + num

    print()
    print("The average of the numbers is:", sum/n)

main()

