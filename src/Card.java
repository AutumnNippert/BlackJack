public class Card {
    public enum Value {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), KING(10), QUEEN(10), ACE(11);

        int val;
        Value(int val) {
            this.val = val;
        }
    }

    public enum Suit {
        CLUBS, DIAMONDS, SPADES, HEARTS
    }

    Value value;
    Suit suit;
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return " (" + value + " of " + suit + ") ";
    }
}
