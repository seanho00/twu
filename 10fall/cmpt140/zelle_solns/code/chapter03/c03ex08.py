# c03ex08.py
#   Gregorian epact

def main():
    print("This program calculates the Gregorian epact value of year.")
    print()

    year = eval(input("Enter the year (e.g. 2012): "))
    c = year // 100
    epact = (8+(c//4) - c + ((8*c + 13)//25) + 11 * (year % 19)) % 30

    print()
    print("The epact value is", epact, "days.")

main()
