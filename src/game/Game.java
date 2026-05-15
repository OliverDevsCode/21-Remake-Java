package game;
import java.util.Scanner;

public class Game implements IGame {
    int target;
    Player[] players;
    boolean roundOver;
    boolean gameOver;
    Deck deck;
    Player winner;

    public Game(int rounds,int startHealth){
        target = 21; //hardcoded to 21 to start with
        Player player1 = new Player(startHealth); //Player 1
        players[0] = player1;
        Player player2 = new Player(startHealth); // Player 2
        players[1]= player2;
        roundOver = false;
        gameOver = false;
        deck = new Deck();
        winner = null;
    }

    /**
     * Starts the game
     */
    public void startGame(){
        while(!gameOver){
            startRound();
            while (!roundOver) {
                input(players[0]);
                input(players[1]);
                if(players[0].stand == true && players[1].stand == true){
                    //CHECK WINNER
                    processRound();
                    nextRound();
                }
            }
        }
    }

    /**
     * Calculates winner
     */
    public void processRound(){
        Player player1 = players[0];
        Player player2 = players[1];
        int p1_dist = modulus(player1.handSum(), this.target);
        int p2_dist = modulus(player2.handSum(), this.target);
        if(player1.handSum() > 21){
            if(player2.handSum() > 21){
                if(p1_dist < p2_dist){
                    //PLAYER 1 WINS
                    player2.health -= 1;
                }else{
                    //PLAYER 2 WINDS
                    player1.health -= 1;

                }
            }else{
                //PLAYER 2 WINS
            }
        }else if(player2.handSum() > 21){
                if(p1_dist < p2_dist){
                    //PLAYER 1 WINS
                    player2.health -= 1;
                }else{
                    //PLAYER 2 WINDS
                    player1.health -= 1;
                }
            }
        else{
            if(p1_dist < p2_dist){
                    //PLAYER 1 WINS
                    player2.health -= 1;
                }else{
                    //PLAYER 2 WINDS
                    player1.health -= 1;
                }
        }
    }

    private int modulus(int value,int target){
        int distance = target - value;
        return (int) Math.abs(distance);
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
        dealHand(players[0]);
        dealHand(players[1]);

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
        System.out.println("Your hand:");
        System.out.println(player.toString());
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
