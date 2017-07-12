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
        if (firstServerGamesWon == 6 && firstReceiverGamesWon < 5) {
            return SetResult.FIRST_SERVER_WINS;
        }
        
        if (firstReceiverGamesWon == 6 && firstServerGamesWon < 5) {
            return SetResult.FIRST_RECEIVER_WINS;
        }
        return SetResult.UNDECIDED;
    }
}
