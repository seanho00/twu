# c08ex09.py
#   Program to figure out gas mileage overa multiple-leg journey.

def main():
    print "This program calculates fuel efficiency over a multi-leg journey."
    print "You should enter the gallons of gas consumed and miles traveled"
    print "for each leg. Just hit <Enter> to signal the end of the trip."
    print
    

    distance, fuel = 0.0, 0.0
    inStr = raw_input("Enter gallons and miles (with a comma between): ")
    while inStr != "":
        gallons,miles = eval(inStr)
        print "MPG for this leg: %0.1f" % (float(miles)/gallons)
        distance = distance + miles
        fuel = fuel + gallons
        inStr = raw_input("Enter gallons and miles (with a comma between): ")

    print
    print "You traveled a total of %0.1f miles on %0.1f gallons." % \
          (distance, fuel)
    print "The fuel efficiency was %0.1f miles per gallon." %(distance/fuel)

if __name__ == '__main__':
    main()
