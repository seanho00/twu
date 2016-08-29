# c11ex02.py
#    A program to sort student grade information in various orders.


from gpa import Student, makeStudent

def readStudents(filename):
    infile = open(filename, 'r')
    students = []
    for line in infile:
        students.append(makeStudent(line))
    infile.close()
    return students

def writeStudents(students, filename):
    outfile = open(filename, 'w')
    for s in students:
        outfile.write("%s\t%f\t%f\n" %
                      (s.getName(), s.getHours(), s.getQPoints()))
    outfile.close()
                      
def cmpGPA(s1, s2):
    return cmp(s1.gpa(), s2.gpa())

def cmpName(s1, s2):
    return cmp(s1.getName(), s2.getName())

def cmpHours(s1, s2):
    return cmp(s1.getHours(), s2.getHours())

def main():
    print "This program sorts student grade information by GPA"
    filename = raw_input("Enter the name of the data file: ")
    data = readStudents(filename)
    sortBy = raw_input("Enter field to sort on (gpa, name, or credits): ")
    choice = sortBy[0].lower()
    if choice == 'n':
        print "Sorting by name."
        data.sort(cmpName)
    elif choice == 'c':
        print "Sorting by credits."
    else:
        print "Sorting by GPA."
        data.sort(cmpGPA)
    
    filename = raw_input("Enter a name for the output file: ")
    writeStudents(data, filename)
    print "The data has been written to", filename

if __name__ == '__main__':
    main()
    
