# c02ex01.py
# Temperature conversion with an introduction

def main():
    print "This program converts Celsius temperatures to Fahrenheit."
    print
    celsius = input("What is the Celsius temperature? ")
    fahrenheit = 9.0 / 5.0 * celsius + 32
    print "The temperature is", fahrenheit, "degrees Fahrenheit."

main()
