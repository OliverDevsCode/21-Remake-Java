import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Game gameInstance = new Game(3);
        gameInstance.startGame();
    }
}
