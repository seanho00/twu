"""Display a histogram of a craps game.

Rolls a pair of dice a number of times and shows
the frequency with which each possible value (2-12) appears.

Sean Ho for CMPT140 exam."""

import random

# Helper function
def rolldie():
    """Return a random integer 1..6"""
    return int(random.random()*6)+1         # or use randrange()

# Initialize the table of frequencies
freqs = {}
for val in range(2, 13):
    freqs[val] = 0

numrolls = input("How many times should I roll the pair of dice? ")

# Roll dice!
count = 0
while count < numrolls:
    freqs[rolldie() + rolldie()] += 1
    count += 1

# Output (names are just for fun, not needed)
names = {2:"Snake Eyes", 3:"Ace Deuce", 4:"Four", 5:"Fever Five",
         6:"Six", 7:"Natural", 8:"Eight", 9:"Nina", 10:"Ten",
         11:"Yo", 12:"Boxcars"}
for val in range(2, 13):
    print "%2d (%-10s): %5d" % (val, names[val], freqs[val])
