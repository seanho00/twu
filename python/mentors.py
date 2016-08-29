"""Mentoring database.

Students and mentors (many:1 relationship).
Sean Ho for CMPT140 demo."""

import pickle           # for MentorDB.save()/load()

class Student:
    """A Student has bio info, plus a reference to
    a Mentor."""

    def __init__(self, name='', mentor=None):
        """Setup a new Student.
        mentor should be a reference to a Mentor object,
        or None if the student doesn't have a mentor."""
        self.__name = str(name)
        self.__mentor = mentor

    def __str__(self):
        """Pretty-print this Student's info."""
        return "<Student: %s; mentor=%s>" % \
            (self.__name, self.__mentor)

    def getName(self):
        return self.__name
    def getMentor(self):
        return self.__mentor

    def setName(self, name=''):
        """Change the Student's name."""
        self.__name = str(name)
    def setMentor(self, mentor=None):
        """Change the Student's mentor (set to None
        if this student doesn't have a mentor)."""
        self.__mentor = mentor

class Mentor:
    """A Mentor just has bio info.
    The mentoring relationships with students are
    stored in the Student objects."""

    def __init__(self, name='', company=''):
        """Setup a new Mentor.
        name and company should be strings."""
        self.__name = str(name)
        self.__company = str(company)

    def __str__(self):
        """Pretty-print this Mentor's info."""
        return "<Mentor: %s at %s>" % \
            (self.__name, self.__company)

    def getName(self):
        return self.__name
    def getCompany(self):
        return self.__company

    def setName(self, name=''):
        self.__name = str(name)
    def setCompany(self, company=''):
        self.__company = company

class MentorDB:
    """Stores a list of Students and a list of Mentors,
    and allows manipulation of the relationships."""

    def __init__(self):
        """Create an empty database."""
        self.__students = []
        self.__mentors = []

    def printStudents(self):
        """Format the list of Students for display."""
        output = '=== Students:\n'
        for student in self.__students:
            output += str(student) + '\n'
        return output

    def printMentors(self):
        """Format the list of Mentors for display."""
        output = '=== Mentors:\n'
        for mentor in self.__mentors:
            output += str(mentor) + '\n'
        return output

    def __str__(self):
        """Format the DB for display."""
        return self.printStudents() + self.printMentors()

    def addStudent(self, newStudent):
        """Add a Student into the database.
        Parameter must be a Student object."""
        if newStudent is not None:
            self.__students.append(newStudent)

    def addMentor(self, newMentor):
        """Add a Mentor into the database.
        Parameter must be a Mentor object."""
        if newMentor is not None:
            self.__mentors.append(newMentor)

    def findStudent(self, targetName):
        """Return first Student record in database
        whose name matches the given string.
        Returns None if no record matches."""
        for student in self.__students:
            if student.getName() == targetName:
                return student
        return None

    def findMentor(self, targetName):
        """Return first Mentor record in database
        whose name matches the given string.
        Returns None if no record matches."""
        for mentor in self.__mentors:
            if mentor.getName() == targetName:
                return mentor
        return None

    def getMentees(self, mentor):
        """Return a (potentially empty) list of Students
        who are matched with the given Mentor object.
        Use findMentor() to lookup a mentor by name."""
        mentees = []
        for student in self.__students:
            if student.getMentor() == mentor:
                mentees.append(student)
        return mentees

    def save(self, file):
        """Write the DB to the given file (overwriting contents).
        Raises IOError if problems with the file."""
        import pickle
        with open(file, 'wb') as dbFile:
            pickle.dump(self.__students, dbFile)
            pickle.dump(self.__mentors, dbFile)

    def load(self, file):
        """Read in a previously-saved DB from file,
        overwriting current DB."""
        import pickle
        with open(file, 'rb') as dbFile:
            self.__students = pickle.load(dbFile)
            self.__mentors = pickle.load(dbFile)

def runtests():
    """Testbed for mentorship database."""
    billG = Mentor("Bill G.", "MilliSoft")
    joe = Student("Joe Smith", billG)
    bob = Student("Bob Jones", billG)

    myDB = MentorDB()
    myDB.addMentor(billG)
    myDB.addStudent(joe)
    myDB.addStudent(bob)
    print(myDB)
    print("findStudent:", myDB.findStudent("Joe Smith"))
    print("getMentees:")
    for mentee in myDB.getMentees(billG):
        print(mentee)
    myDB.save('mentors.db')
