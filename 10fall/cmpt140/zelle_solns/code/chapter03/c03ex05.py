# c03ex05.py
#   Calculate the price of coffee shipments
#   Note: output is ugly. Chapter 4 covers formatting.


def main():
    print("Welcome to the Konditorei!")
    print()

    amount = eval(input("How many pounds of coffee do you want? "))
    coffeeCost = 10.5 * amount
    shipping = 0.86 * amount + 1.5

    print()
    print("Cost of coffee:", coffeeCost)
    print("Shipping:      ", shipping)
    print("-------------------------------")
    print("Total due:     ", coffeeCost + shipping)

main()
