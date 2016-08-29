# c11ex07.py
#   Inner product of two lists

def innerProd(lst1, lst2):
    prod = 0
    for i in range(len(lst1)):
        prod = prod + lst1[i]*lst2[i]
    return prod

def main():
    x = input("Enter first list: ")
    y = input("Enter second list: ")
    print "The inner product is: ", innerProd(x,y)

if __name__ == '__main__':
    main()

