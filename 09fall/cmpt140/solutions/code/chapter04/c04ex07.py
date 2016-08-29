# c04ex07.py
#     Numerology of a full name

import string

def main():
    print "This program computes the 'number value' of a name"
    print

    names = raw_input("Enter a name: ")

    # Create a string of all the letters -- avoids nested loop
    letters = string.join(string.split(names),"")
    sum = 0
    for letter in letters:
        sum = sum + ord(string.lower(letter)) - ord('a') + 1

    print "The value is:", sum

main()
