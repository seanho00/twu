# c10ex15.py
#    Graphical view of cannonball

import time

from projectile import Projectile
from graphics import *

class Tracker:

    def __init__(self, window, objToTrack):
        self.obj = objToTrack
        # note: the marker object really should be a parameter as well
        self.marker = Circle(Point(self.obj.getX(), self.obj.getY()), 10)
        self.marker.draw(window)
        self.marker.setFill("red")

    def update(self):
        newx, newy = self.obj.getX(), self.obj.getY()
        center = self.marker.getCenter()
        currx, curry = center.getX(), center.getY()
        dx = newx - currx
        dy = newy - curry
        self.marker.move(dx,dy)


def getInputs():
    a = eval(input("Enter the launch angle (in degrees): "))
    v = eval(input("Enter the initial velocity (in meters/sec): "))
    h = eval(input("Enter the initial height (in meters): "))
    t = eval(input("Enter the time interval between position calculations: "))
    return a,v,h,t

def main():
    angle, vel, h0, interval = getInputs()
    cball = Projectile(angle, vel, h0)
    win = GraphWin("Cannon Ball", 400, 200)
    win.setCoords(0,-1,400,199)
    track = Tracker(win, cball)
    while cball.getY() >= 0:
        cball.update(interval)
        track.update()
        time.sleep(interval)
    print("\nDistance traveled: {0:0.1f} meters.".format(cball.getX()))

if __name__ == "__main__": main()


        
