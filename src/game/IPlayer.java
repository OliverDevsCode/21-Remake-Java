package game;

public interface IPlayer {
    public void resetHand();
    public void addCard(Card card);
    @Override
    String toString();
}

