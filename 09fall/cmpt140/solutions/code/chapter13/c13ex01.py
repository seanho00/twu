# c13ex01.py
# a program that traces the fib function

# The answer to the question is that fib(10) calls
# fib(3) 21 times

def fib(n):
    print "Computing fib(%d)"%n
    if n<3:
        return_value = 1
    else:
        return_value = fib(n-1)+fib(n-2)

    print "Leaving fib(%d) returning %d"%(n,return_value)
    return return_value

def main():
    print
    print "Let's trace the function that computes Fibonacci numbers"
    print
    
    n = input("Computing the n-th Fibonacci number. Enter n. ")
    f = fib(n)
    
    print
    print "Fib(%d) is %d"%(n,f)
    print

main()
