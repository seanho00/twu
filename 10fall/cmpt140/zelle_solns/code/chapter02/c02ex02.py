# c02ex02.py
# Average 3 exam scores

def main():
    print("This program computes the average of three exam scores.")
    print()

    score1, score2, score3 = eval(input("Enter three scores separated by a comma: "))
    average = (score1 + score2 + score3) / 3.0

    print("The average of the scores is:", average)

main()
