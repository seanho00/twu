# c06ex12.py
#    function to sum numbers in a list

def sumList(nums):
    sum = 0
    for n in nums:
        sum = sum + n
    return sum

def test():
    nums = list(range(10))
    print(sumList(nums))

test()
