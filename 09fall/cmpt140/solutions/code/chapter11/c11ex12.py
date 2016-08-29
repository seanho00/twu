# c11ex12.py

def main():
    # Get the list of censored words
    fname = raw_input("Enter the file of censored words: ")
    naughtyFile = open(fname,'r')
    naughtyWords = naughtyFile.read().split()
    naughtyFile.close()

    
    fname = raw_input("Enter file to censor: ")
    infile = open(fname, 'r')
    
    fname = raw_input("Enter file for censored output: ")
    outfile = open(fname, 'w')

    for line in infile:
        words = []
        for word in line.split():
            if word in naughtyWords:
                words.append("*"*len(word))
            else:
                words.append(word)
        newLine = " ".join(words)
        outfile.write(newLine+"\n")

    infile.close()
    outfile.close()
    print "Censored file written to", fname

main()

                     
            
