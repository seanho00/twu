"""Calculate e.

Sean Ho for CMPT14x 2007.
"""

# Helper function: factorial (iterative solution)
def factorial(n):
  """Return n! = n(n-1)(n-2)...(1).
  Pre: n must be a positive integer.
  Post: returns n! as a float."""
  result = 1.0
  for i in range(1,n+1):
    result *= i
  return result

# Calculate e, the base of the natural logarithm
def e_sum(n):
  """Return an estimate of e, using terms up to 1/n!
  Pre: n must be a positive integer."""
  result = 0
  for k in range(n+1):
    result += 1.0/factorial(k)
  return result

# Main program: interactive testbed for e_sum()
Welcome = """Welcome! This program estimates e, the base of
the natural logarithm, using the Taylor series sum(1/k!).
e is approximately equal to 2.718281828459045...
You can specify the largest value of k you'd like to use:
"""

Prompt = """Type a positive integer, or just enter to end.
Calculate e up to k="""

print Welcome

while True:
  user_input = raw_input(Prompt)

  # Input error-checking
  if user_input == "":
    break
  num_terms = int(user_input)
  if num_terms < 0:
    break

  # Calculate using e_sum()
  print "e =~ %.40f" % e_sum(num_terms)

raw_input("Goodbye!  Press Enter to close this window.")
