public class Casino {
    public static void main(String[] args) {
        Controller p1 = new Player();
        Controller p2 = new Player();
        BlackJackGame bj = new BlackJackGame(p1, p2);
        bj.init();
    }
}
