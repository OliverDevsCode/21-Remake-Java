package game;

public class Card implements ICard{
    CardValue value;
    /**
     * Create Instance of card
     * @param value - type CardValue
     */
    public Card(CardValue value){
        this.value = value;
    }
    /**
     * Get Value of card
     * @return CardValue
     */
    public CardValue getValue() {
        return value;
    }

    /**
     * Outputs the string
     */
    @Override
    public String toString(){
        StringBuffer output = new StringBuffer();
        for(CardValue value: CardValue.values()){
            if(value == this.value){
                output.append(value.name());
            }
        }
       return output.toString();
    }
}
