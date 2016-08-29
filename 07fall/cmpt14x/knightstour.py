"""KnightsTour module - find a knight's tour of a chessboard

In chess, a knight's move is two spaces in any direction, one space in a
perpendicular direction.  A tour is a sequence of consecutive moves which
touches each position in a board exactly once.  This module finds knight's
tours for square chessboards of a given size, given a starting position.

Sean Ho for CMPT14x 2006

>>> k = KnightsTour(3, 4, (0,0))
 1  4  7 10 
12  9  2  5 
 3  6 11  8 
<BLANKLINE>
"""

class KnightsTour:
    def __init__(self, nrows=8, ncols=0, (x0,y0)=(-1,-1)):
        if ncols <= 0:
            ncols = nrows
        self.nrows = nrows
        self.ncols = ncols
        self.clear()
        if self.legal_pos(x0, y0):
            if self.tour((x0, y0)):
                print self
            else:
                print "No solution from (%d,%d)" % (x0, y0)

    def clear(self):
        """Initialize the board."""
        self.board = range(self.nrows)
        for row in range(len(self.board)):
            self.board[row] = [0] * self.ncols

    def __str__(self):
        """Print the board."""
        string = ''
        for row in range(self.nrows):
            for col in range(self.ncols):
                string += '%2d ' % self.board[row][col]
            string += '\n'
        return string

    def legal_pos(self, x, y):
        """check if the coordinates are on the board."""
        return (x >= 0) and (x < self.nrows) and \
               (y >= 0) and (y < self.ncols)

    # Legal moves for a knight
    moves = [(1,2), (2,1), (1,-2), (2,-1), (-1,2), (-2,1), (-1,-2), (-2,-1)]
        
    def tour(self, (x0, y0)=(0,0), moveNum=1):
        """Calculate if a knight's tour is possible from the given
        starting point.  If found, the tour is in self.board .
        """
        
        if not self.legal_pos(x0,y0) or self.board[x0][y0] != 0:
            return False

        # Flag this square as taken
        self.board[x0][y0] = moveNum

        # Check if we've filled the whole board
        if moveNum >= self.nrows*self.ncols:
            return True

        # Try each possible knight's move
        for move in self.moves:
            x = x0 + move[0]
            y = y0 + move[1]
            if self.tour((x,y), moveNum+1):
                return True

        # If we got this far, none of the moves worked
        self.board[x0][y0] = 0
        return False

# DocTest automated testing
def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    _test()
