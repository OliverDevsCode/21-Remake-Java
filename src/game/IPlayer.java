package game;

public interface IPlayer {
    public void resetHand();
    public void addCard(Card card);
    public void dealDamage(int health);
    public int handSum();
    public int getValue(CardValue value);
    String toString();
}

