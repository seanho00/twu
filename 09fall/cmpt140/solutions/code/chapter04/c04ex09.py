# c04ex09.py
#    Caesar cipher (circular version)

import string

def main():
    print "Caesar cipher"
    print

    key = input("Enter the key value: ")
    plain = raw_input("Enter the phrase to encode: ")

    chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz"

    cipher = ""
    for letter in plain:
        pos = string.find(chars, letter)
        newpos = (pos + key) % len(chars)
        cipher = cipher + chars[newpos]

    print "Encoded message follows:"
    print cipher

main()
