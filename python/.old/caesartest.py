"""Testbed for substitution library.

Sean Ho
CMPT14x example 2006.
"""

from substitution import *

print "Let's test out our substitution.py library!"

#myKey = 'QAZXSWEDCVFRTGBNHYUJMKIOLP'
myKey = 'FCHDAJIEBGKLMNOPQRSTUVWXYZ'
print "The key we're using is:", myKey

while True:
    print str(decode_key(myKey))
    plaintext = raw_input("What would you like to encrypt (blank to quit)? ")
    if plaintext == "":
        break
    ciphertext = encode(plaintext, myKey)
    print "Encoded:", ciphertext
    plaintext = decode(ciphertext, myKey)
    print "Decoded:", plaintext

print "Bye!"
