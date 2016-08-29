# c05ex05.py
#     Numerology of a single name


def main():
    print("This program computes the 'number value' of a name")
    print()

    name = input("Enter a single name: ")
    sum = 0
    for letter in name:
        sum = sum + ord(letter.lower()) - ord('a') + 1

    print("The value is:", sum)

main()
