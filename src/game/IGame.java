package game;

public interface IGame {
    public String getInput();
    public void startRound();
    public void nextRound();
    public void input();
    public void process();
    public boolean getGameFinished();
    public boolean getRoundFinished();
}
