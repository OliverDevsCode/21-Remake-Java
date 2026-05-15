package game;

public interface IGame {
    public void startRound();
    public void startGame();
    public void processRound();
    public void nextRound();
    public void dealHand(Player player);
    public void input(Player player);
    public boolean getGameFinished();
    public boolean getRoundFinished();
}
