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
       switch (value) {
        case ACE:
                output.append("ace");
        break;
        case TWO:
                output.append("2");
        break;
        case THREE:
                output.append("3");
        break;
        case FOUR:
                output.append("4");
        break;
        case FIVE:
                output.append("5");
        break;
        case SIX:
                output.append("6");
        break;
        case SEVEN:
                output.append("7");
        break;
        case EIGHT:
                output.append("8");
        break;
        case NINE:
                output.append("9");
        break;
        case TEN:
                output.append("10");
        break;
        case JACK:
                output.append("Jack");
        break;
        case QUEEN:
                output.append("Queen");
        break;
        case KING:
                output.append("King");
        break;
       
        default:
            output.append("NULL");
            break;
       }
       return output.toString();
    }
}
