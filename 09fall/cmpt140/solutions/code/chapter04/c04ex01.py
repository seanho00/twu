# c043x01.py
#  numbers2text using a list accumulator

import string  

def main():
    print "This program converts a sequence of ASCII numbers into"
    print "the string of text that it represents."
    print
    
    # Get the message to encode
    inString = raw_input("Please enter the ASCII-encoded message: ")

    # Loop through each substring and build ASCII message
    msgList = []
    for numStr in string.split(inString):
        # convert the (sub)string to a number
        asciiNum = eval(numStr)
        # append character to message
        msgList.append(chr(asciiNum))

    # join characters of message into a single string
    message = string.join(msgList,"")

    print "The decoded message is:",message

main()
