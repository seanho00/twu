"""Definitions for a student info record.
Sean Ho for CMPT140 demo.
"""

class Date:
    def __init__(self, y=2000, m=1, d=1):
        """Setup a new date object,
        optionally with the given year/month/day.
        pre: y/m/d must be integers in the appropriate range.
        See also: datetime.date:
            http://docs.python.org/library/datetime.html"""
        self.year = y
        self.month = m
        self.day = d
    def __str__(self):
        """Return a human-readable string representation."""
        return "%02d/%02d/%04d" % \
               (self.day, self.month, self.year)

class Student:
    def __init__(self, f='', l='', i=0, bd=None, g=4.0):
        """Setup a new Student, optionally with the
        given first/last name, ID#, and birthdate."""
        self.first = f
        self.last = l
        self.ID = i
        self.GPA = g
        if bd != None:
            self.birthdate = bd
        else:
            self.birthdate = Date()
    def __str__(self):
        """Return a human-readable string representation."""
        return "ID# %06d: %s %s (%s) GPA=%4.2f" % \
               (self.ID, self.first, self.last, self.birthdate, self.GPA)
    
