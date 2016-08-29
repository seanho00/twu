"""Evaluate a random number generator using a graphical plot.

Sean Ho
CMPT14x 2006 demo
"""

# Import libraries
import pseudorandom     # my own library
import random, time, math, turtle

print "Click on the window to exit."

pen = turtle.Turtle()
width = pen.window_width()
height = pen.window_height()

def drawDot():
    x = pseudorandom.random()
    y = pseudorandom.random()
    pen.up()
    pen.goto((x-0.5)*width,(y-0.5)*height)
    pen.down()
    pen.circle(2)
    pen.screen.ontimer(drawDot)

pseudorandom.init_seed(time.time())
pen.tracer(1000,1)
pen.screen.ontimer(drawDot)
pen.screen.exitonclick()
