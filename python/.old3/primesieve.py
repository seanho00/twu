"""Find all primes up to a given number, using Eratosthenes' prime sieve."""

from math import sqrt

size = input("Find all primes up to: ")

# Initialize: all numbers except 0, 1 are prime
primeFlags = range(size+1)      # so pF[size] exists

for num in range(size+1):
    primeFlags[num] = True
primeFlags[0] = False
primeFlags[1] = False

# Computation: eliminate non-primes
for num in range(2, int(sqrt(size))+1):
    if primeFlags[num]:			# got a prime
        for multiple in range(num**2, size+1, num):
            primeFlags[multiple] = False

# Output
print "Your primes, sir/madam:",
for num in range(2, size+1):
    if primeFlags[num]:
        print num,
