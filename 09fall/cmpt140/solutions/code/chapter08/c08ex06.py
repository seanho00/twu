# c08ex06.py
#    primes to n

from c08ex05 import isPrime

def main():
    print "This program finds all prime numbers up to N\n"
    n = input("Enter the upper limit, n: ")
    print "primes: ",
    for i in range(2,n+1):
        if isPrime(i):
            print i,
    print "Done"

if __name__ == '__main__':
    main()

