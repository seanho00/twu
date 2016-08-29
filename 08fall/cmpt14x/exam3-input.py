""" Robust input(): don't crash if user just types <Enter>
    Sample solutions to exam3.

    Sean Ho
    CMPT145 Fall 2008
"""

try:
    x = input("Please type a message: ")
except SyntaxError:
    print "Please make sure you type something."
else:
    print "Thank you!"
finally:
    print "OK, we're done; thanks for coming!"
    
