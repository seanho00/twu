"""Button class: a clickable button.
Uses Zelle's graphics.py: http://mcsp.wartburg.edu/zelle/python/
Original by Zelle; modified by Sean Ho for CMPT140.
"""

from graphics import *

class Button:
    """A button is a labelled box that can respond to clicks."""
    # Attributes:
    #   __rect: Rectangle object (outline of box)
    #   __label: Text object (goes inside box)
    #   __active: whether button responds to clicks

    def __init__(self, win, centre=None,
                 width=None, height=None, label="Button"):
        """Create a new rectangular button."""

        # Set default values for parameters
        if centre == None:
            centre = Point( win.getWidth()/2.0,
                            win.getHeight()/2.0 )
        if width == None:
            width = win.getWidth()/8.0
        if height == None:
            height = win.getHeight()/3.0

        # Calculate bounding box
        left   = centre.getX() - width /2.0
        right  = centre.getX() + width /2.0
        top    = centre.getY() - height/2.0
        bottom = centre.getY() + height/2.0
        lt = Point(left, top)
        lb = Point(left, bottom)
        rt = Point(right, top)
        rb = Point(right, bottom)
        
        # Draw the 3D shadows/highlights
##        self.__edges = [ Line(lt, lb), Line(lt, rt),
##                         Line(rt, rb), Line(lb, rb) ]
##        for edge in self.__edges:
##            edge.setWidth(2)
##            edge.setOutline('grey10')
##            edge.draw(win)
##        for edge in self.__edges[0:2]:
##            edge.setOutline('white')
        
        # Create and draw the button and label
        self.__rect = Rectangle( lt, rb )
        self.__rect.setWidth(0)
        self.__rect.draw(win)
        self.__label = Text( centre, label )
        self.__label.draw(win)

        self.deactivate()

    def move(self, dx, dy):
        """Move right/down by dx/dy (as in graphics.py)"""
        for obj in [self.__rect, self.__label] + self.__edges:
            obj.move(dx, dy)

    def __str__(self):
        """String representation of a Button."""
        return '(%d,%d,%d,%d): "%s"' % (
            self.getLeft() , self.getTop(),
            self.getRight(), self.getBottom(),
            self.getLabel() )

    def getLabel(self):
        """Return the text of the label."""
        return self.__label.getText()

    def getLeft(self):
        """Return left bounds of the drawn button."""
        return self.__rect.getP1().getX()

    def getRight(self):
        """Return right bounds of the drawn button."""
        return self.__rect.getP2().getX()

    def getTop(self):
        """Return top bounds of the drawn button."""
        return self.__rect.getP1().getY()

    def getBottom(self):
        """Return bottom bounds of the drawn button."""
        return self.__rect.getP2().getY()

    def activate(self):
        """Enable the button for clicking."""
        self.__label.setFill('black')
        self.__label.setStyle('bold')
        self.__rect.setFill('grey90')
        self.__active = True

    def deactivate(self):
        """Disable the button for clicking."""
        self.__label.setFill('darkgrey')
        self.__label.setStyle('normal')
        self.__rect.setFill('lightgrey')
        self.__active = False

    def clicked(self, p):
        """Return True if button active and Point p is inside."""
        return self.__active and \
               self.getLeft() <= p.getX() <= self.getRight() and \
               self.getTop()  <= p.getY() <= self.getBottom()
    
