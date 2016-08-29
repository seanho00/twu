"""Frequency histogram of letters in text file.
Sean Ho demo for CMPT140.
"""

def count_letters( srctext ):
    """Count how many times each letter shows up in srctext.
    Non-letters are ignored.
    pre: srctext is a string
    post: returns a dictionary of letters ==> frequences."""

    freqs = {}              # initialize dict to be returned

    for char in srctext:
        if char.isalpha():
            lchar = char.lower()
            # increment count (initialize at 0)
            freqs[lchar] = freqs.get(lchar, 0) + 1

    return freqs

# Helper function to create a single ASCII-art bar
def makebar( length, label='', char='#' ):
    """ASCII-art horizontal bar of the given length.
    Pre: length must be a positive integer.
        label (optional) is a string put before the bar.
        char (optional) is string to use for ASCII-art bar.
    Post: returns a single bar as a string."""

    if label:
        label += ' '
    return label + char*length

def barchart( data, maxwidth=70 ):
    """Print a bar-chart using ASCII-art hash marks.
    Pre: data: list of (key,value) pairs; all values must be positive.
        maxwidth (optional): number of hash marks for longest bar.
    Post: returns a big string with the ASCII-art bar-chart."""

    # Transpose data list to separate keys from values
    (keys, values) = zip(*data)

    # Calculate length of bars
    maxval = max(values)
    barLen = [ round(val / maxval * maxwidth) for val in values ]

    # Format labels for each bar
    barLabel = [ "%s: %5d" % (key, val) for (key, val) in data ]

    # Create list of bars
    bars = map(makebar, barLen, barLabel)

    # Concatenate using newlines
    return '\n'.join(bars)

# Main program (testbed)
def main():
    from operator import itemgetter
    
    with open(input("Enter filename to read: ")) as srcFile:
        freqs = count_letters(srcFile.read())

        # sort letters by frequency (in descending order)
        sortedLetters = sorted(freqs.items(), key=itemgetter(1), reverse=True)

        # print histogram
        print( barchart( sortedLetters ) )

main()
