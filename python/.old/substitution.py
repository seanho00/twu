"""Caesar substitution cipher.

Sean Ho
CMPT14x example 2006.
"""

# Internal helper functions

def alpha_pos (ch):
    """Return index of a letter in the range 0 .. 25"""
    if ch.isupper():
        return ord(ch) - ord('A')
    elif ch.islower():
        return ord(ch) - ord('a')
    else:
        return -1               # not a letter

def decode_key (enckey):
    """Create a decode key from an encoding key"""
    deckey = range(26)             # initialize a blank key
    for idx in range(26):
        deckey[alpha_pos(enckey[idx])] = chr(ord('A') + idx)
    return deckey

# Main public functions
def encode(src, key):
    """Encode the source string using the given codestring.
    Returns the encoded string.
    pre: src must be a string;
    key must be a permutation of the 26 letters.
    """
    dst = ""
    for ch in src:
        if ch.isalpha():
            dst += key[alpha_pos(ch)]
        else:
            dst += ch
    return dst

def decode (src, key):
    """Decode the source string using the given codestring.
    Returns the decoded string.
    pre: src must be a string;
    key must be a permutation of the 26 letters.
    """
    return encode(src, decode_key(key))

