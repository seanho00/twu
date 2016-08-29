"""Count letters in text.
Sean Ho demo for CMPT140.
"""

def count_letters( srctext ):
    """Count how many times each letter shows up in srctext.
    Ignores non-letters.
    pre: srctext is a string
    post: returns a dictionary of letters ==> frequences."""

    # Initialize
    freqs = {}
    for ascii in range( ord('a'), ord('z')+1 ):
        freqs[ chr(ascii) ] = 0

    # Iterate through each character of string
    for char in srctext:
        if char.isalpha():
            freqs[ char.lower() ] += 1

    return freqs

# Main program (testbed)
with open(raw_input("Enter filename to read: ")) as srcFile:
    freqs = count_letters(srcFile.read())

    # sort letters by frequency and print histogram
    sortedLetters = sorted(freqs, key=freqs.get, reverse=True)
    maxFreq = freqs[sortedLetters[0]]
    for letter in sortedLetters:
#        print "%s: %5d" % (letter, freqs[letter])
        numHashes = int( freqs[letter] * 70.0 / maxFreq )
        print "%s: %5d %s" % (letter, freqs[letter], '#'*numHashes)
