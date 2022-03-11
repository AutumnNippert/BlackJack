import java.util.ArrayList;

public class RandBot implements Controller {
    public ArrayList<Card> hand;
    public Card selectedCard;
    private int total;

    public RandBot() {
        this.hand = new ArrayList<>();
        this.total = 0;
    }

    @Override
    public int getTotal() {
        //Checking if ace
        //If so, remove 10 from the total
        if (total > 21) {
            for (Card c : hand) {
                if (c.value == Card.Value.ACE) {
                    total -= 10;
                    break;
                }
            }
        }
        return total;
    }

    @Override
    public void addCard(Card c) {
        this.hand.add(c);
        this.total += c.value.val;
    }

    @Override
    public void play() {

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Hand: ");
        for (Card c : hand) {
            str.append(c).append(", ");
        }
        return str.toString();
    }
}
