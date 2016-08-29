# c06ex10.py
#   Acronym generator using functions

import string

def acronym(phrase):
    ans = ""
    for word in string.split(phrase):
        ans = ans + word[0]
    return string.upper(ans)

def main():
    print "Acronym Builder"
    words = raw_input("Enter a phrase: ")
    print "Acronym:", acronym(words)

main()
