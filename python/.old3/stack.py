"""Stacks using plain arrays.
CMPT140 demo."""

class Stack:
    """Stack implementation using arrays."""
    
    def __init__(self, size=10):
        """Create a stack, with optional
        maximum size."""
        self.__list = range(size)
        self.__top = -1

    def __str__(self):
        return str(self.__list[0:self.__top+1])
        
    def push(self, item):
        """Add a new item onto the stack.
        pre: stack must not be full.
        post: item is on top of stack."""
        if self.__top < len(self.__list)-1:
            self.__top += 1
            self.__list[self.__top] = item
            
    def pop(self):
        """Remove top item and return it.
        pre: stack not empty.
        post: stack is smaller by 1."""
        if self.__top >= 0:
            item = self.__list[self.__top]
            self.__top -= 1
            return item
