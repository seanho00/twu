class MyException(Exception):
    cnumtries = 0
    def __init__(self, t=0, n=""):
        self.numtries = t
        self.name = n
    def __str__(self):
        return "MyException: %d tries" % self.numtries

try:
    for tries in range(1, 6):
        if input('Guess a number: ') == 5:
            x = MyException(tries)
            raise x
except MyException, e:
    print 'You got it in only %d tries!' % e.numtries
else:
    print 'Too bad, you ran out of tries!'
