# c05ex03.py
#    Exam grader

def main():
    print("Exam Grader")
    score = eval(input("Enter the score (out of 100): "))
    grades = 60*"F"+10*"D"+10*"C"+10*"B"+11*"A"
    print("The grade is", grades[score])

main()
