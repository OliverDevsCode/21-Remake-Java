package game;
import java.util.ArrayList;

public class Player implements IPlayer{
    ArrayList<Card> hand;
    int health;
    boolean stand;

    public Player(){
        hand = new ArrayList<Card>();
        health = 3;
        stand = false;
    }
    public void resetHand(){
        hand.clear();
    }
    public void addCard(Card card){
        hand.add(card);
    }
    @Override
    public String toString(){
        StringBuffer output = new StringBuffer();
        for(int i =0; i < hand.size();){
            output.append("{");
            
        }
    }
}
