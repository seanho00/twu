"""Apply ROT13 encoding.

Demo for CMPT140, by Sean Ho.  Python3 version.
"""

def rot13(plaintext):
    """Convert text to ROT13.
    Pre: plaintext is string you want encoded.
    Post: returns ROT13 ciphertext string."""
    ciphertext = ''             # initialize output to empty
    for char in plaintext:      # iterate over string
        code = ord(char)        # convert to integer ASCII code
        if char.islower():      # lowercase letter
            code += 13
            if code > ord('z'): # wraparound
                code -= 26
        elif char.isupper():    # uppercase letter
            code += 13
            if code > ord('Z'): # wraparound
                code -= 26
        char = chr(code)        # convert back to character
        ciphertext += char      # append to output
    return ciphertext

def main():
    """Testbed for ROT13."""
    print("Welcome to our ROT13 encrypter!")
    print("  Input an empty string (press return) to quit.")

    while True:
        text = input("Input text? ")
        if len(text) == 0:
            break
        print("ROT13:", rot13(text))

main()
