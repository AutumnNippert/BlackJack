/**
 * Controller! Controls someone who plays blackjack
 */
public interface Controller {
    /**
     * Calculates the total in the players hand, accounting for Ace 1 or 11.
     * @return int total in controllers hand
     */
    int getTotal();

    /**
     * Adds card c to hand of controller.
     * @param c Card
     */
    void addCard(Card c);

    /**
     * The logic for hitting or staying.
     */
    void play();

    /**
     * Returns controllers hand.
     * @return String hand
     */
    String toString();
}
