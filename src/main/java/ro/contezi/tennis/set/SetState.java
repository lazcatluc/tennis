package ro.contezi.tennis.set;

public class SetState {
    private final int firstServerGamesWon;
    private final int firstReceiverGamesWon;
    
    public SetState() {
        this(0, 0);
    }
    
    public SetState(int firstServerGamesWon, int firstReceiverGamesWon) {
        this.firstServerGamesWon = firstServerGamesWon;
        this.firstReceiverGamesWon = firstReceiverGamesWon;
    }
    
    public SetResult getResult() {
        return SetResult.UNDECIDED;
    }
}
