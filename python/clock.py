"""A clock object.

Demo of Zelle's graphics.py library
and creating a class."""

from graphics import *

class Clock:
    """A circle and two lines, representing a clock!
    Angles for hands of the clock are in radians,
    starting at 0 pointing to the right, and increasing clockwise."""
    
    def __init__(self, center=None, radius=0., hrAng=0., mnAng=0.):
        """Create a new Circle.
        center is a Point, radius should be >0,
        and hrAng, mnAng should be between 0 and 2pi."""
        if center == None:
            center = Point(0,0)             # create new Point object
        if radius < 0:                      # validate input
            radius = 0

        # Copy values from parameters into object attributes
        self.center, self.radius, self.hrAng, self.mnAng = \
            center, radius, hrAng, mnAng

    def draw(self, win):
        """Draw the clock into the given GraphWin."""
        from math import sin, cos

        # Specify geometry of the objects composing the clock
        hrRatio = 0.6       # length of hands, relative to clock radius
        mnRatio = 0.9
        face = Circle(self.center, self.radius)
        hrHand = Line( self.center, Point( \
            self.center.x + hrRatio*self.radius*cos(self.hrAng),
            self.center.y + hrRatio*self.radius*sin(self.hrAng) ) )
        mnHand = Line( self.center, Point( \
            self.center.x + mnRatio*self.radius*cos(self.mnAng),
            self.center.y + mnRatio*self.radius*sin(self.mnAng) ) )

        # Set parameters for the graphic objects
        face.setWidth(2)
        hrHand.setWidth(4)
        mnHand.setWidth(4)

        # Render the components of the clock to the window
        face.draw(win)
        hrHand.draw(win)
        mnHand.draw(win)
        
def main():
    """Testbed for Clock."""
    from math import pi
    win = GraphWin("Clock Test", 400, 300)
    c = Clock(Point(200, 150), 70, pi/3, pi/2)
    c.draw(win)

main()
