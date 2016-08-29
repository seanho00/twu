# c04ex14.py
#    Batch Caesar cipher
#    Input file format: first line is key value;
#                       remaining lines are text to encode.

import string

def main():
    print "Batch Caesar cipher"
    print

    inName = raw_input("Enter name of the input file: ")
    infile = open(inName,'r')
    key = eval(infile.readline())

    outName = raw_input("Enter name of output file: ")
    outfile = open(outName, 'w')
    

    chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz"

    for line in infile:
        for letter in line[:-1]:
            pos = string.find(chars, letter)
            newpos = (pos + key) % len(chars)
            outfile.write(chars[newpos])
        outfile.write('\n')

    infile.close()
    outfile.close()
    print "Done"

main()
