package game;
import java.util.ArrayList;

public class Player implements IPlayer{
    ArrayList<Card> hand;
    int health;

    public Player(){
        hand = new ArrayList<Card>();
        health = 3;
    }
    public void resetHand(){
        hand.clear();
    }
    public void addCard(Card card){
        hand.add(card);
    }
    @Override
    String toString(){
        
    }
}
