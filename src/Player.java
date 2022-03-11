import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Controller {
    public ArrayList<Card> hand;
    private int total;

    public Player() {
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
    public void play() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.printf("Total: %d\n", getTotal());
            if (getTotal() == 21) {
                System.out.println("You have 21. Ending turn.");
                isRunning = false;
            } else if (getTotal() > 21) {
                System.out.println("Bust. Ending turn");
                isRunning = false;
            } else {
                System.out.print("(1) Hit\n(2) Stay\n>>> ");
                int input = new Scanner(System.in).nextInt();
                if (input == 1) {
                    System.out.println("Hit selected");
                    Dealer.deal(this);
                } else if (input == 2) {
                    System.out.println("Stay selected");
                    isRunning = false;
                } else {
                    System.out.println("Invalid selection");
                }
            }
        }
    }

    @Override
    public void addCard(Card c) {
        this.hand.add(c);
        this.total += c.value.val;
    }

//    @Override
//    public void selectCard() {
//        System.out.println(this.toString());
//        System.out.println("Please select a card index: ");
//        int index = new Scanner(System.in).nextInt() - 1;
//        this.selectedCard = hand.get(index);
//    }
//
//    @Override
//    public Card playCard() {
//        hand.remove(selectedCard);
//        return selectedCard;
//    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Hand: \n");
        for (int i = 0; i < hand.size(); i++) {
            str.append("(").append(i + 1).append(") ").append(hand.get(i)).append("\n");
        }
        return str.toString();
    }
}
