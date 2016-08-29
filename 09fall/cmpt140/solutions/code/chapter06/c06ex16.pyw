# c0616.py
#   simple animation using moveTo

from graphics import *

def moveTo(shape, newc):
    c = shape.getCenter()
    dx = newc.getX() - c.getX()
    dy = newc.getY() - c.getY()
    shape.move(dx, dy)

def main():
    w = GraphWin("Move It!", 400, 400)
    c = Circle(Point(200,200), 40)
    c.draw(w)
    
    for i in range(10):
        p = w.getMouse()
        moveTo(c, p)

    w.getMouse()
    w.close()

main()
