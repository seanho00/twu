from math import sqrt
try:
    while True:
        num = input('Find sqrt of: ')
        print 'The square root is', sqrt(num)
except ValueError:
    print "Can't take square root of", num
