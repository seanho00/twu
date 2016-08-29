# c04ex11.py
#   Average word length

import string

def main():
    print "Average word length"
    print

    phrase = raw_input("Enter a phrase: ")

    # using accumulator loop
    count = 0
    sum = 0.0
    for word in string.split(phrase):
        sum = sum + len(word)
        count = count + 1

    print "Average word length", sum / count

main()
