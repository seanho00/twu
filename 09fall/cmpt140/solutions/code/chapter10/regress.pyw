# regress.pyw
# This program graphically plots a regression line.
# By: Leo-sweeting, Maho Fujita, Alan Simmer, Erica Powless

from graphics import *

# These two "constants" are defined here so they can be used in multiple
#    functions to draw the done button and check to see if it is clicked in.

DoneX = 1.0   # x coordinate of done button upper right
DoneY = 0.75  # y coordinate of done button upper right
from graphics import *

def createWindow():
    win=GraphWin("Linear Regression",500,500)
    win.setCoords(0,0,10,10)
    button=Rectangle(Point(0.05,0),Point(DoneX,DoneY))
    text=Text(Point(.5,.375),"Done")
    text.draw(win)
    button.draw(win)
    return win


def getPoint(w):
    p1 = w.getMouse()
    if inDoneButton(p1):
        return None
    else:
        p1.draw(w)
        return p1

def slope(xb, yb, xx, xy, n):
    m = float(xy - n*xb*yb)/(xx - n*(xb**2))
    return m

def predict(x, xb, yb, m):
    y = yb + m*(x-xb)
    return y

def getPoints(w):
    sumx = 0
    sumy = 0
    sumxy = 0
    sumxx = 0
    count = 0
    p = getPoint(w)
    while p != None:
        x,y = p.getX(), p.getY()
        sumx = sumx + x
        sumy = sumy + y
        sumxy = sumxy + x*y
        sumxx = sumxx + x**2
        count = count + 1
        p = getPoint(w)
    return float(sumx)/count, float(sumy)/count, sumxx, sumxy, count

def inDoneButton(p):
    x = p.getX()
    y = p.getY()
    if x <= DoneX and y <= DoneY:
        return True
    else:
        return False

def main():
    # create a window, and allow user to click points
    win = createWindow()
    xbar, ybar, sumXsq, sumXY, n = getPoints(win)

    # calulate line of best fit
    m = slope(xbar, ybar, sumXsq, sumXY, n)
    y1 = predict(0, xbar, ybar, m)
    y2 = predict(10, xbar, ybar, m)

    # draw the line
    regLine = Line(Point(0,y1), Point(10,y2))
    regLine.setWidth(2)
    regLine.draw(win)

    # close up shop
    win.getMouse()
    win.close()

main()

