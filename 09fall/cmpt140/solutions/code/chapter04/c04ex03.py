# c04ex03.py
#    Quiz grader

def main():
    print "Five point quiz grader"
    score = input("Enter the score: ")
    grade = "FFDCBA"[score]
    print "The grade is", grade

main()
