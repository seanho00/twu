# c06ex14.py
#    sum of squares from file

def toNumbers(strList):
    for i in range(len(strList)):
        strList[i] = eval(strList[i])

def sumList(nums):
    sum = 0
    for n in nums:
        sum = sum + n
    return sum

def squareEach(nums):
    for i in range(len(nums)):
        nums[i] = nums[i]**2

def main():
    print "Program to find sum of squares from numbers in a file"
    fname = raw_input("Enter filename: ")
    data = open(fname,'r').readlines()
    toNumbers(data)
    squareEach(data)
    print "Sum of squares:", sumList(data)

main()
