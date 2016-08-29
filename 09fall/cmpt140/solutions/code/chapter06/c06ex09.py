# c06ex09.py

def grade(score):
    return "FFDCBA"[score]

def main():
    print "Quiz Grader"
    score = input("Enter the score (0-5): ")
    print "The grade is", grade(score)

main()

    
