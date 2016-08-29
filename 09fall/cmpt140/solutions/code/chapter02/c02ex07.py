# c02ex07.py
#    Future value with multiple compounding periods

def main():
    print "This program calculates the future value of an investment."
    print
    
    principal = input("Enter the initial principal: ")
    rate = input("Enter the interest rate: ")
    periods = input("Enter the number of compounding periods per year: ")
    years = input("Enter the number of years: ")

    for i in range(years * periods):
        principal = principal * (1 + rate/periods)

    print "The amount in", years, "years is:", principal

main()
