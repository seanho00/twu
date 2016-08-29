# c08ex02.py
#   Windchill Table

def windChill(t, v):
    return 35.74 + 0.6215*t - 35.75*(v**0.16) + 0.4275*t*(v**0.16)

def main():

    # Print table headings
    print "Wind Chill Table\n\n"
    print "Temperature".center(70)
    print "MPH|",
    temps = range(-20,61,10)
    for t in temps:
        print "%5d" % t,
    print "\n---+" + 55 * '-'

    # Print lines in table
    for vel in range(5,51,5):
        print "%3d|" %vel,
        for temp in temps:
            print "%5.0f" % windChill(temp, vel),
        print
    print

main()
