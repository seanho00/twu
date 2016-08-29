# c03ex06.py
#    Determine slope of a line through two poitns

def main():
    print "This program calculates the slope of a line."
    print

    x1, y1 = input("Enter coordinates of the first point (x,y): ")
    x2, y2 = input("Enter coordinates of the second point(x,y): ")
    slope = float(y2 - y1) / (x2 - x1)

    print
    print "The slope of the line is", slope

main()
