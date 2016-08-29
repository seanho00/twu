"""Simple object oriented graphics library for
Introduction to Programming using Python
by John Zelle, Ph.D."""

# Version 1.6
#     Fixed Entry so StringVar uses _root as master, solve weird
#            interaction with shell in Idle
#     Fixed bug in setCoords. X and Y coordinates can increase in
#           "non-intuitive" direction.
#     Tweaked wm_protocol so window is not resizable and kill box closes.

# Version 1.5
#     Fixed bug in Entry. Can now define entry before creating a
#     GraphWin. All GraphWins are now toplevel windows and share
#     a fixed root (called _root).

# Version 1.4
#     Fix Garbage collection of Tkinter images bug.
#     Add ability to set text atttributes.
#     Add Entry boxes.


import Tkinter
tk = Tkinter

from copy import copy

OBJ_ALREADY_DRAWN = "Graphics Error: Object already visible"
UNSUPPORTED_METHOD = "Graphics Error: Object doesn't support operation"
BAD_OPTION = "Graphics Error: Illegal option value"

# Default values for various item configuration options. Only a subset of
#   keys may be present in the configuration dictionary for a given item
DEFAULT_CONFIG = {"fill":"",
		  "outline":"black",
		  "width":"1",
		  "arrow":"none",
		  "text":"",
		  "justify":"center",
                  "font": ("helvetica", 12, "normal")}

class GraphicsObject:
    
    def __init__(self, options):
        self.canvas = None
        self.id = None
        config = {}
        for option in options:
            config[option] = DEFAULT_CONFIG[option]
        self.config = config
        
    def setFill(self, color): self._reconfig("fill", color)
        
    def setOutline(self, color): self._reconfig("outline", color)
        
    def setWidth(self, width): self._reconfig("width", width)

    def draw(self, canvas):
        if self.canvas: raise OBJ_ALREADY_DRAWN
        self.canvas=canvas
        self.id = self._draw(canvas, self.config)

    def undraw(self):
        if not self.canvas: return
        self.canvas.delete(self.id)
        self.canvas = None
        self.id = None
        
    def move(self, dx, dy):
        self._move(dx,dy)
        canvas = self.canvas
        if canvas:
            trans = canvas.trans
            if trans:
                x = dx/ trans.xscale 
                y = -dy / trans.yscale
            else:
                x = dx
                y = dy
            self.canvas.move(self.id, x, y)
           
    def _reconfig(self, option, setting):
        if not self.config.has_key(option): raise UNSUPPORTED_METHOD
        options = self.config
        options[option] = setting
        if self.canvas: self.canvas.itemconfig(self.id, options)
         
class Point(GraphicsObject):
    def __init__(self, x, y):
        GraphicsObject.__init__(self, ["outline", "fill"])
        self.setFill = self.setOutline
        self.x = x
        self.y = y
        
    def _draw(self, canvas, options):
        x,y = canvas.toScreen(self.x,self.y)
        return canvas.create_rectangle(x,y,x+1,y+1,options)
        
    def _move(self, dx, dy):
        self.x = self.x + dx
        self.y = self.y + dy
        
    def clone(self):
        other = Point(self.x,self.y)
        other.config = self.config
        return other
                
    def getX(self): return self.x
    def getY(self): return self.y

class _BBox(GraphicsObject):
    def __init__(self, p1, p2, options=["outline","width","fill"]):
        GraphicsObject.__init__(self, options)
        self.p1 = p1.clone()
	self.p2 = p2.clone()

    def _move(self, dx, dy):
        self.p1.x = self.p1.x + dx
        self.p1.y = self.p1.y + dy
        self.p2.x = self.p2.x + dx
        self.p2.y = self.p2.y  + dy
                
    def getP1(self): return self.p1

    def getP2(self): return self.p2
    
    def getCenter(self):
        p1 = self.p1
        p2 = self.p2
        return Point((p1.x+p2.x)/2.0, (p1.y+p2.y)/2.0)
    
class Rectangle(_BBox):
    
    def __init__(self, p1, p2):
        _BBox.__init__(self, p1, p2)
    
    def _draw(self, canvas, options):
        p1 = self.p1
        p2 = self.p2
        x1,y1 = canvas.toScreen(p1.x,p1.y)
        x2,y2 = canvas.toScreen(p2.x,p2.y)
        return canvas.create_rectangle(x1,y1,x2,y2,options)
        
    def clone(self):
        other = Rectangle(self.p1, self.p2)
        other.config = self.config
        return other
        
class Oval(_BBox):
    
    def __init__(self, p1, p2):
        _BBox.__init__(self, p1, p2)
        
    def clone(self):
        other = Oval(self.p1, self.p2)
        other.config = self.config
        return other
   
    def _draw(self, canvas, options):
        p1 = self.p1
        p2 = self.p2
        x1,y1 = canvas.toScreen(p1.x,p1.y)
        x2,y2 = canvas.toScreen(p2.x,p2.y)
        return canvas.create_oval(x1,y1,x2,y2,options)

class Polygon(GraphicsObject):
    
    def __init__(self, *points):
        self.points = map(Point.clone, points)
        GraphicsObject.__init__(self, ["outline", "width", "fill"])
        
    def clone(self):
        other = apply(Polygon, self.points)
        other.config = self.config
        return other

    def getPoints(self):
        return map(Point.clone, self.points)

    def _move(self, dx, dy):
        for p in self.points:
            p.move(dx,dy)
   
    def _draw(self, canvas, options):
        args = [canvas]
        for p in self.points:
            x,y = canvas.toScreen(p.x,p.y)
            args.append(x)
            args.append(y)
        args.append(options)
        return apply(GraphWin.create_polygon, args) 
    
class Circle(Oval):
    
    def __init__(self, center, radius):
        p1 = Point(center.x-radius, center.y-radius)
        p2 = Point(center.x+radius, center.y+radius)
        Oval.__init__(self, p1, p2)
        self.radius = radius
        
    def clone(self):
        other = Circle(self.getCenter(), self.radius)
        other.config = self.config
        return other
        
    def getRadius(self):
        return self.radius
              
class Line(_BBox):
    
    def __init__(self, p1, p2):
        _BBox.__init__(self, p1, p2, ["arrow","fill","width"])
        self.setFill(DEFAULT_CONFIG['outline'])
        self.setOutline = self.setFill
   
    def clone(self):
        other = Line(self.p1, self.p2)
        other.config = self.config
        return other
	
    def _draw(self, canvas, options):
        p1 = self.p1
        p2 = self.p2
        x1,y1 = canvas.toScreen(p1.x,p1.y)
        x2,y2 = canvas.toScreen(p2.x,p2.y)
        return canvas.create_line(x1,y1,x2,y2,options)
        
    def setArrow(self, option):
        if not option in ["first","last","both","none"]:
            raise BAD_OPTION
        self._reconfig("arrow", option)
        

class Text(GraphicsObject):
    
    	def __init__(self, p, text):
    		GraphicsObject.__init__(self, ["justify","fill","text","font"])
    		self.setText(text)
    		self.anchor = p.clone()
    		self.setFill(DEFAULT_CONFIG['outline'])
                self.setOutline = self.setFill
    		
    	def _draw(self, canvas, options):
    		p = self.anchor
    		x,y = canvas.toScreen(p.x,p.y)
    		return canvas.create_text(x,y,options)
    		
    	def _move(self, dx, dy):
    		self.anchor.move(dx,dy)
    		
    	def clone(self):
    		other = Text(self.anchor, self.text)
    		other.config = self.config
    		return other

    	def setText(self,text):
    		self._reconfig("text", text)
    		
    	def getText(self):
    		return self.config["text"]
    	    	
    	def getAnchor(self):
    		return self.anchor.clone()

        def setFace(self, face):
            if face in ['helvetica','arial','courier','times roman']:
                f,s,b = self.config['font']
                self._reconfig("font",(face,s,b))
            else:
                raise BAD_OPTION

        def setSize(self, size):
            if 5 <= size <= 36:
                f,s,b = self.config['font']
                self._reconfig("font", (f,size,b))
            else:
                raise BAD_OPTION

        def setStyle(self, style):
            if style in ['bold','normal','italic', 'bold italic']:
                f,s,b = self.config['font']
                self._reconfig("font", (f,s,style))
            else:
                raise BAD_OPTION


class Entry(GraphicsObject):

    def __init__(self, p, width):
        GraphicsObject.__init__(self, [])
        self.anchor = p.clone()
        #print self.anchor
        self.width = width
        self.text = tk.StringVar(_root)
        self.text.set("")
        self.fill = "gray"

    def _draw(self, canvas, options):
        p = self.anchor
        x,y = canvas.toScreen(p.x,p.y)
        frm = tk.Frame(canvas.master)
        self.entry = tk.Entry(frm, width=self.width, textvariable=self.text)
        self.entry.pack()
        self.setFill(self.fill)
        return canvas.create_window(x,y,window=frm)

    def getText(self):
        return self.text.get()

    def _move(self, dx, dy):
        self.anchor.move(dx,dy)

    def getAnchor(self):
        return self.anchor.clone()

    def clone(self):
        other = Entry(self.anchor, self.width)
        other.config = self.config
        other.text = tk.StringVar()
        other.text.set(self.text.get())
        other.fill = self.fill
        return other

    def setText(self, t):
        self.text.set(t)
            
    def setFill(self, color):
        self.fill = color
        self.entry.config(bg=color)

    		
class Image(GraphicsObject):

    idCount = 0
    imageCache = {}  # keep images here to avoid gc
    
    def __init__(self, p, file=None):
        GraphicsObject.__init__(self, [])
        self.file = file
        self.anchor = p.clone()
        self.imageId = Image.idCount
        Image.idCount = Image.idCount + 1
    		
    def _draw(self, canvas, options):
        p = self.anchor
        x,y = canvas.toScreen(p.x,p.y)
        img = tk.PhotoImage(file=self.file, master=canvas)
        self.imageCache[self.imageId] = img  # save in cache to avoid gc 
        return canvas.create_image(x,y,image=img)
    
    def _move(self, dx, dy):
        self.anchor.move(dx,dy)

    def undraw(self):
        del self.imageCache[self.imageId]  # allow gc of tk photoimage
        GraphicsObject.undraw(self)

    def getAnchor(self):
        return self.anchor.clone()
    		
    def clone(self):
        other = Image(self.anchor, self.file)
        other.config = self.config
        return other

class GraphWin(tk.Canvas):
    
    def __init__(self, title="Graphics Window", width=200, height=200):
        master = tk.Toplevel(_root)
        master.protocol("WM_DELETE_WINDOW", self.close)
        tk.Canvas.__init__(self, master, width=width, height=height)
        self.master.title(title)
        self.pack()
        master.resizable(0,0)
        self.foreground = "black"
        self.items = []
        self.mouseX = None
        self.mouseY = None
        self.bind("<Button-1>", self._onClick)
        self.height = height
        self.width = width
        self._mouseCallback = None
        self.trans = None
        
    def setBackground(self, color):
        self.config(bg=color)
        
    def setCoords(self, x1, y1, x2, y2):
        self.trans = Transform(self.width, self.height, x1, y1, x2, y2)
        
    def close(self):
        self.master.destroy()
    
    def plot(self, x, y, color="black"):
        xs,ys = self.toScreen(x,y)
        self.create_line(xs,ys,xs+1,ys, fill=color)
        
    def plotPixel(self, x, y, color="black"):
    	self.create_line(x,y,x+1,y, fill=color)
    	
    def flush(self):
        self.update_idletasks()
        
    def getMouse(self):
        self.mouseX = None
        self.mouseY = None
        while self.mouseX == None or self.mouseY == None:
            self.update()
        x,y = self.toWorld(self.mouseX, self.mouseY)
        return Point(x,y)
    
    def getHeight(self):
        return self.height
        
    def getWidth(self):
        return self.width
    
    def toScreen(self, x, y):
        trans = self.trans
        if trans:
            return self.trans.screen(x,y)
        else:
            return x,y
                      
    def toWorld(self, x, y):
        trans = self.trans
        if trans:
            return self.trans.world(x,y)
        else:
            return x,y
        
    def setMouseHandler(self, func):
        self._mouseCallback = func
        
    def _onClick(self, e):
        self.mouseX = e.x
        self.mouseY = e.y
        if self._mouseCallback:
            self._mouseCallback(Point(e.x, e.y)) 
                      
class Transform:
    def __init__(self, w, h, xlow, ylow, xhigh, yhigh):
        xspan = (xhigh-xlow)
        yspan = (yhigh-ylow)
        self.xbase = xlow
        self.ybase = yhigh
        self.xscale = xspan/float(w-1)
        self.yscale = yspan/float(h-1)
        
    def screen(self,x,y):
        xs = (x-self.xbase) / self.xscale
        ys = (self.ybase-y) / self.yscale
        return int(xs+0.5),int(ys+0.5)
        
    def world(self,xs,ys):
        x = xs*self.xscale + self.xbase
        y = self.ybase - ys*self.yscale
        return x,y
        
from math import sin, cos, pi

RADFACTOR = pi/180
TWOPI = 2 * pi

class Turtle:
    
    def __init__(self, window):
        self.window = window
        self.angle = 0
        self.image = None
        x,y = window.toWorld(window.width/2, window.height/2)
        if window.trans:
            self.__size = window.trans.xscale*10
        else:
            self.__size = 10
        self.location = Point(x,y)
        self.color = "black"
        self.width = 1
        self.visible = 0
        self.penIsDown = 1
        
    def _redraw(self):
        if self.image and self.visible:
            self.image.undraw()
        self.image = None
        if self.visible:
            tip=self._nextPoint(self.__size)
            image = self.image = Line(self.location, tip)
            image.setArrow("last")
            image.setFill(self.color)
            image.setWidth(self.width)
            image.draw(self.window)
        self.window.update()
    
    def hide(self):
        if self.image and self.visible:
            self.image.undraw()
        self.visible = 0
    
    def show(self):
        self.visible = 1
        if self.image:
            self.image.draw(self.window)
        else:
            self._redraw()
        
    def turn(self, degrees):
        rads = degrees * RADFACTOR
        self.angle = self.angle + rads
        while self.angle > TWOPI:
            self.angle = self.angle - TWOPI
        while self.angle < 0:
            self.angle = self.angle + TWOPI
        self._redraw()
        
    def turnTo(self, degrees):
        rads = degrees * RADFACTOR
        self.angle = rads
        self._redraw()
        
    def setLocation(self, p):
        self.location = p
        self._redraw()
        
    def getLocation(self):
        return self.location
        
    def setWidth(self, width):
        self.width = width
        self._redraw()
        
    def setColor(self, color):
        self.color = color
        self._redraw()
        
    def move(self, units):
        next = self._nextPoint(units)
        if self.penIsDown:
            line = Line(self.location, next)
            line.setOutline(self.color)
            line.setWidth(self.width)
            line.draw(self.window)
        self.location=next
        self._redraw()
        
    def moveTo(self, next):
        if self.penIsDown:
            line = Line(self.location, next)
            line.setOutline(self.color)
            line.setWidth(self.width)
            line.draw(self.window)
        self.location=next
        self._redraw()
        
    def penUp(self):
        self.penIsDown = 0
        
    def penDown(self):
        self.penIsDown = 1     
 
    def _nextPoint(self, dist):
        curr = self.location
        dx = dist*cos(self.angle)
        dy = dist*sin(self.angle)
        return Point(curr.x+dx, curr.y+dy)
            
def color_rgb(r,g,b):
    return "#%02x%02x%02x" % (r,g,b)

# create an invisible main root for all windows
_root = tk.Tk()
_root.withdraw()

def test():
    win = GraphWin()
    win.setCoords(0,0,10,10)
    t = Text(Point(5,5), "Centered Text")
    t.draw(win)
    p = Polygon(Point(1,1), Point(5,3), Point(2,7))
    p.draw(win)
    e = Entry(Point(5,6), 10)
    e.draw(win)
    win.getMouse()
    p.setFill("red")
    p.setOutline("blue")
    p.setWidth(2)
    s = ""
    for pt in p.getPoints():
        s = s + "(%0.1f,%0.1f) " % (pt.getX(), pt.getY())
    t.setText(e.getText())
    e.setFill("green")
    e.setText("Spam!")
    e.move(2,0)
    win.getMouse()
    p.move(2,3)
    s = ""
    for pt in p.getPoints():
        s = s + "(%0.1f,%0.1f) " % (pt.getX(), pt.getY())
    t.setText(s)
    win.getMouse()
    p.undraw()
    e.undraw()
    t.setStyle("bold")
    win.getMouse()
    t.setStyle("normal")
    win.getMouse()
    t.setStyle("italic")
    win.getMouse()
    t.setStyle("bold italic")
    win.getMouse()
    t.setSize(14)
    win.getMouse()
    t.setFace("arial")
    t.setSize(20)
    win.getMouse()
    win.close()

if __name__ == "__main__":
    test()
