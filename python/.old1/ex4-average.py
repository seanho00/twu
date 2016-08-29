"""Read in numbers from a file and print their average.
The file 'input.txt' must contain float numbers, one to a line, no blank lines."""
fileHandle = open('input.txt', 'r')
stringList = fileHandle.readlines()
sum = 0.0
for s in stringList:
        sum += float(s)
print "The average is", sum/len(stringList)
