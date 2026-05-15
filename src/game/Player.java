package game;
import java.util.ArrayList;

public class Player implements IPlayer{
    ArrayList<Card> hand;
    int health;
    boolean stand;

    public Player(int health){
        hand = new ArrayList<Card>();
        this.health = health;
        stand = false;
    }
    public void resetHand(){
        hand.clear();
    }
    public void addCard(Card card){
        hand.add(card);
    }
    public void dealDamage(int amount){
        this.health -= amount;
    }
    public int getValue(CardValue value){
        switch (value) {
        case ACE:
                return 1;
            case TWO:
                return 2;
        case THREE:
                return 3;
        case FOUR:
                return 4;
        case FIVE:
                return 5;
        case SIX:
                return 6;
        case SEVEN:
                return 7;
        case EIGHT:
                return 8;
        case NINE:
                return 9;
        case TEN:
                return 10;
        case JACK:
                return 10;
        case QUEEN:
                return 10;
        case KING:
                return 10;
        default:
            return 0;
       }
    }
    public int handSum(){
        int sum = 0;
        for (Card card : hand) {
            sum += getValue(card.value);
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuffer output = new StringBuffer();
        for(int i =0; i < hand.size();){
            Card toDisplay = hand.get(i);
            output.append("{");
            output.append(toDisplay.toString());
            output.append("}");
        }
        return output.toString();
    }
}
