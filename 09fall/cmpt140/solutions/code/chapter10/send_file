# deck.py

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

class Deck:

    def __init__(self):
        self.cards = []
        for suit in 'cdhs':
            # add each card of suit to self.cards
            for rank in range(1,14):
                card = Card(rank, suit)
                self.cards.append(card)

def main():
    n = input(">   ")
    myDeck = Deck()
    myDeck.shuffle()
    for i in range(n):
        print myDeck.dealCard()


