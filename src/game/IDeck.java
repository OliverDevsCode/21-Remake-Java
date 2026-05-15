package game;

public interface IDeck {
    public Card getCard();
    public void reset();
    public void shuffle();
}
