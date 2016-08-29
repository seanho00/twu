# c03ex03.py
#   Calculates molecular weight of a hydrocarbon

def main():
    print "This program calculates the molecular weight of a hydrocarbon."
    print

    h = input("Enter the number of hydrogen atoms: ")
    c = input("Enter the number of carbon atoms: ")
    ox = input("Enter the number of oxygen atoms: ")
    weight = 1.0079 * h + 12.001 * c + 15.9994 * ox

    print
    print "The molecular weight is:", weight

main()
