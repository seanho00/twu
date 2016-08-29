# c03ex04.py
#    Calculate distance to a lightning strike

def main():
    print "This program calculates the distance from a lightning strike."
    print

    seconds = input("Enter number of seconds between flash and crash: ")
    feet = 1100 * seconds
    miles = feet / 5280.0

    print
    print "The lightning is approximately", miles, "miles away."

main()
