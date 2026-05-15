package game;

public class Card implements ICard{
    CardValue value;

    public Card(CardValue value){
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }
}
