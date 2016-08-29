# c05ex08.pyw
#    Line segment info.

import math

from graphics import *

def main():
    win = GraphWin("Line Segment Info", 400, 400)
    win.setCoords(-10,-10,10,10)

    msg = Text(Point(0,-9.5), "Click on endpoints of a line segment.")
    msg.draw(win)

    p1 = win.getMouse()
    p1.draw(win)

    p2 = win.getMouse()
    p2.draw(win)

    line = Line(p1,p2)
    line.draw(win)

    mark = Circle(line.getCenter(),0.15)
    mark.setFill("cyan")
    mark.draw(win)

    dx = p2.getX() - p1.getX()
    dy = p2.getY() - p1.getY()
    slope = float(dy)/dx
    length = math.sqrt(dx*dx + dy*dy)

    msg.setText("Length: %0.2f    Slope: %0.2f" % (length, slope))
    win.getMouse()
    win.close()

main()
              
