try:
    for tries in range(3):
        if input('Guess a number: ') == 5:
            raise ZeroDivisionError
except ZeroDivisionError:
    print 'You got it!'
else:
    print 'Too bad, you ran out of tries!'
finally:
    print 'Bye!'
