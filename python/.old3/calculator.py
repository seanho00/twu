"""A simple graphical RPN calculator.
Sean Ho for CMPT140, inspired by Zelle's text.
Uses Zelle's graphics.py library:
  http://mcsp.wartburg.edu/zelle/python/
"""

from graphics import *
from button import Button
import operator

class Calculator:
    """A simple graphical RPN calculator.
    This is a self-contained window."""
    
    # Attributes (for display):
    # __win: the window into which the calculator is drawn
    # __buttons: list of all action buttons
    # __display: Text widget for output
    # __stackDisp: text representation of the stack
    # Attributes (for computation)
    # __stack: stack of stored values for RPN calculator
    # __entry: current number being entered (not yet pushed on stack)
    # __ops: map button labels to Python operators
    # __running: set to False to quit

    def __init__(self, width=300, height=300):
        """Create a new calculator window."""
        self.__win = GraphWin("RPN Calculator", width, height)
        self.__win.setBackground('slategray')
        # Use normalized coordinate system: left, bot, right, top
        self.__win.setCoords(-0.6, 4.5, 4.5, -0.6)

        self.__createDisplay()
        self.__createButtons()

        # Initialize the stack that stores our calculations
        self.__stack = []
        self.__entry = ""
        self.__updateDisplay()
        self.__running = True
        
    def __createDisplay(self):
        """Create widgets for the text output display."""
        # Background bezel
        bezel = Rectangle(Point(-0.4, -0.35), Point(4.4, 0.4) )
        bezel.setFill('white')
        bezel.setWidth(0)
        bezel.draw(self.__win)

        # The main output display
        self.__display = Text( Point(2, 0), "." )
        self.__display.setFace('courier')
        self.__display.setStyle('bold')
        self.__display.setSize(16)
        self.__display.draw(self.__win)

        # A tiny representation of the stack
        self.__stackDisp = Text( Point(2, 0.25), "" )
        self.__stackDisp.setFace('courier')
        self.__stackDisp.setSize(8)
        self.__stackDisp.draw(self.__win)

    def __createButtons(self):
        """Create widgets for the calculator buttons."""
        # Configuration list: "label":(x,y)
        buttonConfig = {
            "7":(0,1), "8":(1,1), "9":(2,1), "<--":(3,1), "C":(4,1),
            "4":(0,2), "5":(1,2), "6":(2,2), "*"  :(3,2), "/":(4,2),
            "1":(0,3), "2":(1,3), "3":(2,3), "+"  :(3,3), "-":(4,3),
            "Quit":(0,4), "0":(1,4), ".":(2,4) }

        # Map buttons to Python operators
        self.__ops = { '+':operator.add, '-':operator.sub,
                       '*':operator.mul, '/':operator.div }

        # Create all the buttons
        self.__buttons = []
        for (label, (x,y)) in buttonConfig.items():
            self.__buttons.append(
                Button(self.__win, Point(x,y), 0.9, 0.9, label) )

        # 'Enter' button is larger
        self.__buttons.append(
            Button(self.__win, Point(3.5, 4), 1.9, 0.9, "Enter") )

        # Activate all the buttons
        for btn in self.__buttons:
            btn.activate()

    def __del__(self):
        """Destructor: cleanup"""
        self.__win.close()

    def __str__(self):
        """Print the stack for the RPN calculator."""
        return str(self.__stack)

    def __updateDisplay(self):
        """Ensure the display widgets reflect the internals."""
        self.__display.setText( str(self.__entry) )
        stackTxt = ""
        for val in self.__stack:
            stackTxt += "%d, " % val
        self.__stackDisp.setText( stackTxt )

    def push(self, value):
        """Push a value onto the RPN stack.  Converts to float."""
        self.__stack.append(float(value))

    def pop(self):
        """Returns the top value from the RPN stack,
        and removes it from the stack."""
        if len(self.__stack) > 0:
            return self.__stack.pop()
        else:
            return None

    def getKeyPress(self):
        """Wait for user to click a button; return label of button"""
        while True:
            pt = self.__win.getMouse()      # wait for click
            for btn in self.__buttons:
                if btn.clicked(pt):
                    return btn.getLabel()

    def processKey(self, key):
        """Act on the given keypress."""
        if '0' <= key <= '9':       # append digit to current entry
            self.__entry += key
            self.__updateDisplay()
            
        elif key == '.':            # can only have one decimal pt
            if self.__entry.count(key) == 0:
                self.__entry += key
                
        elif key == '<--':          # backspace: remove last char
            if len(self.__entry) > 0:
                self.__entry = self.__entry[:-1]
            self.__updateDisplay()

        elif key == 'C':            # clear all
            self.__stack = []
            self.__entry = ""
            self.__updateDisplay()

        elif key == 'Quit':         # exit the main event loop
            self.__running = False
                
        elif key == 'Enter':        # push entry onto stack
            if len(self.__entry) > 0:
                self.push(self.__entry)
                self.__entry = ""
                self.__updateDisplay()
            
        elif key in self.__ops:     # operator: take two top entries
            if len(self.__entry) > 0:
                self.push(self.__entry)
                self.__entry = ""
                self.__updateDisplay()
            if len(self.__stack) >= 2:
                arg2 = self.pop()
                arg1 = self.pop()
                try:
                    self.push( self.__ops[key]( arg1, arg2 ) )
                except ZeroDivisionError:
                    print "Dividing by zero!"
                    self.push( 0 )
                self.__updateDisplay()
                self.__display.setText(str(self.__stack[-1]))
        else:
            print "Invalid key pressed!"

    def run(self):
        """Main event loop for the calculator."""
        self.__running = True
        while self.__running:
            key = self.getKeyPress()
            self.processKey(key)

# Main Program (testbed)
if __name__ == '__main__':
    theCalc = Calculator()
    theCalc.run()
    del theCalc
