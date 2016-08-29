# c05ex06.py
#     Numerology of a full name


def main():
    print("This program computes the 'number value' of a name")
    print()

    names = input("Enter a name: ")

    # Create a string of all the letters -- avoids nested loop
    letters = "".join(names.split())
    sum = 0
    for letter in letters:
        sum = sum + ord(letter.lower()) - ord('a') + 1

    print("The value is:", sum)

main()
