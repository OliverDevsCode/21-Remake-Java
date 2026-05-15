package game;

public interface IGame {
    public void startRound();
    public void nextRound();
    public void dealHand(Player player);
    public void input(Player player);
    public boolean getGameFinished();
    public boolean getRoundFinished();
}
