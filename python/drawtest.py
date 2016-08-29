"""Fun with Zelle's graphics.py library.

Sean Ho demo for CMPT140."""

# fetch from http://mcsp.wartburg.edu/zelle/python/
from graphics import *

win = GraphWin("Demo!", 400, 300)   # main window

ctr = Point(200, 150)       # centre of win

# A big coloured disk in the middle:
bigball = Circle(ctr, 75)
bigball.setWidth(3)
bigball.setOutline('green')
bigball.setFill('skyblue')
bigball.draw(win)

# A line coming out from the disk:
slantyline = Line(ctr, Point(275, 225))
slantyline.setWidth(4)
slantyline.setOutline( color_rgb(255, 0, 200) )
slantyline.draw(win)

# Caption for the figure
Text(Point(200, 250), "Hey look, I drew a Q!").draw(win)
