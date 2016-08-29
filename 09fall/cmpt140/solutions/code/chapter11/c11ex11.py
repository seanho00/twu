# c11ex11.py

def main():
    fname = raw_input("Enter file to censor: ")
    infile = open(fname, 'r')
    
    fname = raw_input("Enter file for censored output: ")
    outfile = open(fname, 'w')

    for line in infile:
        words = []
        for word in line.split():
            if len(word) == 4:
                words.append("****")
            else:
                words.append(word)
        newLine = " ".join(words)
        outfile.write(newLine+"\n")

    infile.close()
    outfile.close()
    print "Censored file written to", fname

main()

                     
            
