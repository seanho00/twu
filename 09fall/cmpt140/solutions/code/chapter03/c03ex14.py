# c03ex14.py
#    Average of numbers entered by the user.

def main():
    print "Program to calculate average"
    print

    n = input("How many numbers do you have? ")
    sum = 0.0  # float here ensures float division below
    for i in range(n):
        num = input("Enter a number: ")
        sum = sum + num

    print
    print "The average of the numbers is:", sum/n

main()

