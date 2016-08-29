"""A simple bank account example for our template lab writeup.

Name: Nellie Hacker
Student Number: 922001
CMPT 140 Fall 2006
Lab 00
Bank Interest Computation
"""

# Welcome blurb
print "This program computes interest on an account", \
      "quarterly, and then allows for withdrawals."
print

# Get initial input
balance = input("What is the opening balance? $")
rate = input("What percent is the annual interest rate? ")
time = 0.25     #compound quarterly

# Input / computation for each quarter
for quarter in range(1,5):
    withdrawal = input("How much do you wish to withdraw in quarter number " +
                      str(quarter) + "? $")
    interest = balance * time * rate / 100
    balance = balance + interest
    balance = balance - withdrawal

# Final output
print "The final balance in your account is $", balance

# Pause before quitting so user can read output
raw_input("Press Enter to quit.")

