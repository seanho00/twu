# c05ex02.py
#    Quiz grader

def main():
    print("Five point quiz grader")
    score = eval(input("Enter the score: "))
    grade = "FFDCBA"[score]
    print("The grade is", grade)

main()
