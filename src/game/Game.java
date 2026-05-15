package game;
import java.util.Scanner;

public class Game implements IGame {
    int target;
    Player[] players;
    boolean roundOver;
    boolean gameOver;
    Deck deck;
    Player winner;

    public Game(int rounds){
        target = 21; //hardcoded to 21 to start with
        Player player1 = new Player(); //Player 1
        dealHand(player1);
        players[0] = player1;
        Player player2 = new Player(); // Player 2
        dealHand(player2);
        players[1]= player2;
        roundOver = false;
        gameOver = false;
        deck = new Deck();
        winner = null;
    }

    /**
     * Resets:
     * Player hands
     * Deck
     * Round Status
     */
    public void startRound(){
        players[0].resetHand();
        players[1].resetHand();
        deck.reset();
        roundOver = false;
    }

    /**
     * Checks for winner
     * Resets Round
     */
    public void nextRound(){
        //check if winner
        if(players[0].health == 0){
            winner = players[1];
            gameOver = true;
        }else if(players[1].health ==0){
            winner = players[0];
            gameOver = true;
        }
        for (Player player : players) {
            player.stand = false;
        }
        startRound();
    }

    public void dealHand(Player player){
        Card toDeal = deck.getCard();
        player.addCard(toDeal);
        toDeal = deck.getCard();
        player.addCard(toDeal);
    }

    /**
     * Asks player for an input
     *  Deal - adds card to player hand
     *  Stand - neutral
     * @throws IllegalArgumentException - If user option is incorrect
     */
    public void input(Player player) throws IllegalArgumentException{
        Scanner inputScanner = new Scanner(System.in);  
        System.out.println("Hit (H) || Stand (S)");
        String userChoice = inputScanner.nextLine(); 
        if(userChoice == "H"){
            Card toDeal = deck.getCard();
            player.addCard(toDeal);
        }else if(userChoice == "S"){
            System.out.println("Standing");
            player.stand = true;
        }else{
            throw new IllegalArgumentException("Not an option");
        }
    }

    public boolean getGameFinished(){
        return this.gameOver;
    }

    public boolean getRoundFinished(){
        return this.gameOver;
    }
}
