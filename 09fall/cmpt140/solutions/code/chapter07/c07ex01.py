# c07ex1.py
#    overtime pay


def main():
    print "Weekly pay calculator\n"
    hours = input("Enter hours worked: ")
    wage = input("Enter hourly wage: ")
    if hours <= 40:
        pay = hours * wage
    else:
        pay = 40 * wage + (hours-40) * 1.5* wage

    print "Your week's pay is $%0.2f" % pay

if __name__ == '__main__':
    main()

