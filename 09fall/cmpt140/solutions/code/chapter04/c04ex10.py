# c04ex10.py
#    Count words in sentence

import string

def main():
    print "Word counter"
    print

    phrase = raw_input("Enter a phrase: ")

    # using accumulator loop
    count = 0
    for i in string.split(phrase):
        count = count + 1

    # alternatives: count = len(string.split(phrase))
    #               count = string.count(phrase," ") + 1

    print "Number of words:", count

main()
