''' This file contains an interface for doing windowy events. It should eventually
be cross platform but my linux box died so someone else will need to do that
unless it gets fixed.

http://msdn.microsoft.com/en-us/library/ms632595(v=VS.85).aspx
'''

import pygame
import platform

def _winid():
    return pygame.display.get_wm_info()['window']

def maximize_Windows():
    from ctypes import windll
    SW_MAXIMIZE = 3
    windll.user32.ShowWindow(_winid(), SW_MAXIMIZE)

def hasfocus_Windows():
    from ctypes import windll
    return windll.user32.GetActiveWindow() == _winid()

def maximize_Linux():
    pass

def hasfocus_Linux():
    return True

maximize = eval("maximize_" + platform.system())
hasfocus = eval("hasfocus_" + platform.system())
