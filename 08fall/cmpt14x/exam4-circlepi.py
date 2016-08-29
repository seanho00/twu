"""Estimate pi by calculating area of unit quarter-circle.

Sean Ho
CMPT14x example 2006.
"""

from random import random
import sys

def circle_pi(count, freq):
    """Estimate pi by generating 'count' # of points and counting how many lie
    within the unit quarter-circle.  Print the approximation every 'freq' pts."""
    incircle = 0L
    i = 1L
    while i <= count:
        if random()**2 + random()**2 < 1:
            incircle += 1
        if i%freq == 0:
            print 4.0*incircle/i
        i += 1
    return 4.0*incircle/count

max_count = input("How many iterations should I use to approximate pi? ")
frequency = input("How often would you like updates? ")

sys.stdout = open("circlepi.log", "w")
circle_pi(max_count, frequency)
sys.stdout.close()
