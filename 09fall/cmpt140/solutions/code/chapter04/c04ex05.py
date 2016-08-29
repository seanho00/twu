# c04ex05.py
#   Acronym builder

import string

def main():
    print "This program builds acronyms"
    phrase = raw_input("Enter a phrase: ")
    acronym = ""
    for word in string.split(phrase):
        acronym = acronym+word[0]
    acronym = string.upper(acronym)

    print "The acronym is", acronym

main()
