# c11ex13.py
#   Print cards input from a file in rank/suit order.

class Card:

    def __init__(self, rank, suit):
        self.rank = rank
        self.suit = suit

    def getRank(self):
        return self.rank

    def getSuit(self):
        return self.suit

    def BJValue(self):
        if self.getRank() < 10:
            return self.rank
        else:
            return 10

    def __str__(self):
        ranks = [None, "Ace", "Two", "Three", "Four", "Five", "Six",
                 "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"]
        rankStr = ranks[self.rank]
        if self.suit == 'c':
            suitStr = "Clubs"
        elif self.suit == 'd':
            suitStr = "Diamonds"
        elif self.suit == 'h':
            suitStr = "Hearts"
        else:
            suitStr = "Spades"
        return "%s of %s" % (rankStr, suitStr)


def cmpRank(c1, c2):
    return cmp(c1.getRank(),c2.getRank())

def cmpSuit(c1, c2):
    return cmp(c1.getSuit(), c2.getSuit())
    

def main():
    fname = raw_input("Enter name of file with card values: ")
    infile = open(fname,"r")

    # read the file to create a hand of cards
    hand = []
    for line in infile:
        rank, suit = line.split()
        theCard = Card(int(rank),suit)
        hand.append(theCard)
    infile.close()

    # sort the cards by rank and suit
    hand.sort(cmpRank)
    hand.sort(cmpSuit)

    # print them out
    for card in hand:
        print card

if __name__ == '__main__':
    main()


