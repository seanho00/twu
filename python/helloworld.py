"""A baby Python program.

Name: Sean Ho
Get the user's name and reply with a friendly greeting.
This program is a simple demo for beginning Python.
"""

# Import any needed libraries
import math

def get_name():
    """Ask the user for his/her name.
    Pre: none.
    Post: returns user's name as a string."""
    return input("What is your name? ")

def say_hello(name):
    """Greet the user by name.
    Pre: name: user's name (string).
    Post: prints greeting on the console."""
    print("Nice to meet you, %s!" % name)

username = get_name()
say_hello(username)

# or simply: say_hello(get_name())

