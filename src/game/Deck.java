package game;
import java.util.ArrayList;

public class Deck implements IDeck {
    ArrayList<Card>  deck;
    ArrayList<Card> remaining;

    /**
    *Creates a version of the class
    */
    public Deck(){
        this.deck = new ArrayList<>();
        this.remaining = new ArrayList<>();
        for(CardValue value: CardValue.values()){
            Card newCard = new Card(value);
            deck.add(newCard);
            remaining.add(newCard);
        }
        
    }
    /**
    Returns a card from the remaining deck
    *@return Card
     */
    public Card getCard(){
        int cardIndex = shuffle();
        Card cardToReturn = remaining.remove(cardIndex);
        return cardToReturn;
    }


     /**
    *Resets the cards avaiable for players to use
     */
    public void reset(){
        remaining.clear();
        remaining = (ArrayList<Card>) deck.clone();
    }

     /**
    *Simulates shuffle
    *@return int - the position of next card to pick
     */
    public int shuffle(){
        int max = remaining.size()-1;
        int random = Math.round((int)Math.random()*max);
        return random;
    }
}
