# c04ex15.py
#     Program to count lines, words and characters in a file.

import string

def main():
    print "File wordcount"
    print

    fname = raw_input("Enter filename: ")
    infile = open(fname, 'r')
    chars = infile.read()
    words = string.split(chars)
    lines = string.split(chars, "\n")

    print "Characters:", len(chars)
    print "Words:", len(words)
    print "Lines:", len(lines)

main()
