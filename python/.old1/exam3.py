a = 1
def f(p):
	global a
	from math import sqrt
	a = p
class C:
	a = 2
	b = 3
	def __init__(self, d=4):
		f(5)
		a = 6
		b = 7
		self.e = 8
g = C()
