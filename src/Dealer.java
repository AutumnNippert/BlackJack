import java.util.ArrayList;
import java.util.Random;

public class Dealer implements Controller {
    public ArrayList<Card> hand;
    private int total;

    public Dealer() {
        this.hand = new ArrayList<>();
        this.total = 0;
    }

    /**
     * Deals a card to Controller c.
     * @param c controller
     */
    public static void deal(Controller c) {
        Random r = new Random();
        c.addCard(new Card(Card.Value.values()[r.nextInt(13)], Card.Suit.values()[r.nextInt(4)])); //Generating random card since no real deck is needed for blackjack
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
        boolean isRunning = true;
        while (isRunning) {
            System.out.printf("Total: %d\n", getTotal());
            if (getTotal() == 21) {
                System.out.println("Dealer has 21. Ending turn.");
                isRunning = false;
            } else if (getTotal() > 21) {
                System.out.println("Bust.");
                isRunning = false;
            } else {
                if (total < 17) {
                    Dealer.deal(this);
                } else {
                    isRunning = false;
                }
            }
        }
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
