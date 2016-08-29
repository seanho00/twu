# c05ex10.py
#   Average word length


def main():
    print("Average word length")
    print()

    phrase = input("Enter a phrase: ")

    # using accumulator loop
    count = 0
    sum = 0
    for word in phrase.split():
        sum = sum + len(word)
        count = count + 1

    print("Average word length", sum / count)

main()
