from Tkinter import *
from random import randrange

class App:
    """
    A simple Tk application that plots random lines
    """

    def __init__(self, master):
        # create the main frame
        frame = Frame(master)
        frame.pack()

        # create a canvas within the frame
        self.canvas = Canvas(frame, width=400, height=400)
        self.canvas.pack(side=TOP)

        # create a button below the canvas and within the frame
        # method add_line() is invoked if the button is clicked
        button = Button(frame, text="Add line",
                               command=self.add_line)
        button.pack(side=BOTTOM)

    def add_line(self):
        """
        Adds a random line in the canvas
        """
        self.canvas.create_line(randrange(0,400),
                                randrange(0,400),
                                randrange(0,400),
                                randrange(0,400),
                                fill="blue")

#
# MAIN
#

# Initialize the graphical toolkit
root = Tk()

# Create the sample graphical application
app  = App(root)

# Use in stand-alone programs, not in IDLE
root.mainloop()
