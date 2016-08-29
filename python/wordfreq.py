"""List frequencies of most common words in a text.

Sean Ho for CMPT140 demo."""

wordfreq = {}

# Read file one line at a time
with open("charter.txt") as myFile:
    for line in myFile:
        line = line.lower()
        for ch in '!"#$%&()*+,-./:;<=>?@[\\]^_`{|}~0123456789':
            line = line.replace(ch, ' ')
        for word in line.split():
            wordfreq[word] = wordfreq.get(word,0) + 1

# Output
sortedlist = sorted(wordfreq, key=wordfreq.get)
for i in range(1,20):
    print("%-10s%5d" % (sortedlist[-i], wordfreq[sortedlist[-i]]))
