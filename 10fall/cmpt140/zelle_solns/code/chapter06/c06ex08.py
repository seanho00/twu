# c06ex08.py
#  square roots

def nextGuess(guess, x):
    return (guess + x/guess) / 2.0

def sqrRoot(x, iters):
    guess = x / 2.0
    for i in range(iters):
        guess = nextGuess(guess, x)
    return guess
    

def main():
    x = eval(input("Enter the value to take the root of: "))
    n = eval(input("Enter the number of iterations: "))
    print("Square root is", sqrRoot(x, n))

main()
