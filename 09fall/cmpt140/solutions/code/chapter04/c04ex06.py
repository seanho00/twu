# c04ex06.py
#     Numerology of a single name

import string

def main():
    print "This program computes the 'number value' of a name"
    print

    name = raw_input("Enter a single name: ")
    sum = 0
    for letter in name:
        sum = sum + ord(string.lower(letter)) - ord('a') + 1

    print "The value is:", sum

main()
