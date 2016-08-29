"""Interactive velocity/distance calculator."""
def find_d(a, u, v):
        """Find the distance travelled, given accel and init/final velocities."""
        return (v*v - u*u)/(2*a)

def find_a(d, u, v):
        """Find the accel, given distance and init/final velocities."""
        return (v*v - u*u)/(2*d)
  
print "Welcome!  Let's do some physics!"
u = float(input("What's the initial velocity?"))
v = float(input("What's the final velocity?"))
key = ''
while key != 'd' and key != 'a':
        key = raw_input("Do you know the distance (d), or the acceleration (a)?")
        if key == 'd':
                d = float(input("What's the distance travelled?"))
                print "The acceleration is", find_a(d, u, v)
        elif key == 'a':
                a = float(input("What's the acceleration?"))
                print "The distance travelled is", find_d(a, u, v)
        else:
                print "Please type either 'd' or 'a'"
print "Hope you had fun!"
