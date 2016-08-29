""" Demonstrate alias vs. shallow copy vs. deep copy
    Sample solutions to exam3.

    Sean Ho
    CMPT145 Fall 2008
"""

class Date:
	"""A calendar date: month/day/year."""
	def __init__(self, m=1, d=1, y=2000):
		"""Create a new Date object.
		Params (all optional, numeric): month, day, year."""
		self.m = m
		self.d = d
		self.y = y
class Student:
	"""A student record: name and date of birth."""
	def __init__(self, name="", dob=None):
		"""Create a new Student record.
		Params (all optional): full name, date of birth (Date object)."""
		self.name = name
		self.dob = dob
		if self.dob is None:
			self.dob = Date()

larry = Student("Larry", Date(2, 14, 2000))

bob = larry			# alias
bob.name = "Bob"		# linked to larry

import copy
junior = copy.copy(larry)	# shallow copy
junior.name = "Junior"		# separate from larry/bob
junior.dob.y = 2006		# linked to larry/bob

paGrape = copy.deepcopy(larry)	# deep copy
paGrape.name = "Pa Grape"	# separate from everyone
paGrape.dob.m = 12
paGrape.dob.d = 25

