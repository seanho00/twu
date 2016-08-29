"""Construct a histogram of random values.

Sean Ho
CMPT14x Fall 2006 demo
"""

# Import libraries
import pseudorandom     # my own library
import random, time, math

# Declare functions
def histogram(generator, count, numbins):
    """Build a histogram of numbers.
    generator: a function that returns floats between 0 and 1.
    count: number of times to call generator.
    numbins: number of buckets into which to divide the interval 0..1
    Returns a list of bucket counts.
    """
    buckets = [0] * numbins
    for i in range(count):
        buckets[int(generator()*numbins)] += 1
    return buckets

def stddev(thelist):
    """Calculate standard deviation of a list of numbers."""
    mean = sum(thelist)/len(thelist)
    devs = 0.
    for num in thelist:
        devs += (num - mean)**2
    return math.sqrt(devs/(len(thelist)-1))

# Main program
print "Compare my pseudorandom with built-in random(), using histograms!"

pseudorandom.init_seed(time.time())      # seed my random

while True:
    histo_size = input("How many random numbers to generate (0 to quit)? ")
    if histo_size < 1:
        break
    n_bins = input("How many buckets to use? ")
    
    my_histo = histogram(pseudorandom.random, histo_size, n_bins)
    yr_histo = histogram(random.random, histo_size, n_bins)

    # Relative histogram: percentages
    for i in range(n_bins):
        my_histo[i] /= float(histo_size)/n_bins
        yr_histo[i] /= float(histo_size)/n_bins

    print "mine: SD=%.3f%%, std: SD=%.3f%%" % \
          (10*stddev(my_histo), 10*stddev(yr_histo))
    
