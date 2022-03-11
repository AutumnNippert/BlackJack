import java.util.ArrayList;
import java.util.Arrays;

/**
 * Allows for the creation of Black Jack games.
 */
public class BlackJackGame {
    ArrayList<Controller> controllers;
    Dealer dealer;

    /**
     * Constructor for a BlackJackGame.
     *
     * @param controllers Takes a variable amount of controllers
     */
    public BlackJackGame(Controller... controllers) {
        this.controllers = new ArrayList<>();
        this.controllers.addAll(Arrays.asList(controllers));
        this.dealer = new Dealer();
    }

    public void init() {
        System.out.println("Starting Game");
        //Dealing
        for (Controller c : this.controllers) {
            for (int j = 0; j < 2; j++) { //Deals this amount of cards to the controller
                Dealer.deal(c);
            }
        }
        Dealer.deal(dealer);
        Dealer.deal(dealer);

        //Game Loop
        for (int i = 0; i < controllers.size(); i++) {
            System.out.println("---------------------Starting Player " + (i + 1) + " turn---------------------");
            controllers.get(i).play();
            System.out.println("---------------------Continuing to next player---------------------");
        }
        for (int i = 0; i < controllers.size(); i++) {
            System.out.printf("Player %d | Total: %d\n", i + 1, controllers.get(i).getTotal());
        }
        dealer.play();
        System.out.println("---------------------Game Over---------------------");
        System.out.printf("Dealer | Total: %d | \n", dealer.getTotal());
        //Calculating if players won
        for (int i = 0; i < controllers.size(); i++) {
            String didWin;
            if (controllers.get(i).getTotal() <= 21 && controllers.get(i).getTotal() > dealer.getTotal()) {
                didWin = "Winner!";
            } else {
                didWin = "Loser!";
            }
            System.out.printf("Player %d | Total: %d | %s\n", i + 1, controllers.get(i).getTotal(), didWin);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < controllers.size(); i++) {
            str.append(String.format("Player %d: %s", i + 1, controllers.get(i) + "\n" + "Total: " + controllers.get(i).getTotal()));
        }
        return str.toString();
    }
}