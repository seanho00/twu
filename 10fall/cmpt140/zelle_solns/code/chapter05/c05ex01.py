#c05ex01.py
#    dateconvert2 using string formatting 


def main():
    # get the day month and year
    day, month, year = eval(input("Please enter the day, month and year numbers (day, month, year): "))

    date1 = "{0}/{1}/{2}".format(month,day,year)

    months = ["January", "February", "March", "April", "May", "June",
              "July", "August", "September", "October", "November", "December"]
    date2 = "{0} {1}, {2}".format(months[month-1],day,year)

    print("The date is {0} or {1}.".format(date1, date2))

main()

