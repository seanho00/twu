# c04ex12.py
# Chaos program to print formatted side-by-side values

def main():
    print "This program illustrates a chaotic function"
    x1 = input("Enter the first seed between 0 and 1: ")
    x2 = input("Enter the second seed between 0 and 1: ")
    print
    print "index     ", x1, "       ", x2
    print "-------------------------------"
    for i in range(1, 11):
        x1 = 3.9 * x1 * (1 - x1)
        x2 = 3.9 * x2 * (1 - x2)
        print "%2d %15.6f %10.6f" % (i, x1, x2)

main()
