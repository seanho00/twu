#c04ex02.py
#    dateconvert2 using string formatting 

import string

def main():
    # get the day month and year
    day, month, year = input("Please enter the day, month and year numbers (day, month, year): ")

    date1 = "%d/%d/%d" % (month,day,year)

    months = ["January", "February", "March", "April", "May", "June",
              "July", "August", "September", "October", "November", "December"]
    date2 = "%s %d, %d" % (months[month-1],day,year)

    print "The date is %s or %s." % (date1, date2)

main()

