# c06ex07.py

def fibo(n):
    curr, prev = 1,1
    for i in range(n-2):
        curr, prev = curr+prev, curr
    return curr

def main():
    print "Nth Fbonacci number\n"
    n = input("Enter n: ")
    print fibo(n)

main()
