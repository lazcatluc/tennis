package ro.contezi.tennis.set;

public class SetState {
    public static final int GAMES_TO_WIN = 6;
    
    private final int firstServerGamesWon;
    private final int firstReceiverGamesWon;
    
    public SetState(int firstServerGamesWon, int firstReceiverGamesWon) {
        this.firstServerGamesWon = firstServerGamesWon;
        this.firstReceiverGamesWon = firstReceiverGamesWon;
    }
    
    public SetResult getResult() {
        if (hasDecisiveLead(firstServerGamesWon, firstReceiverGamesWon)) {
            return SetResult.FIRST_SERVER_WINS;
        }
        
        if (hasDecisiveLead(firstReceiverGamesWon, firstServerGamesWon)) {
            return SetResult.FIRST_RECEIVER_WINS;
        }
        return SetResult.UNDECIDED;
    }
    
    protected boolean hasDecisiveLead(int leader, int follower) {
        return leader >= GAMES_TO_WIN && leader - follower > 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + firstReceiverGamesWon;
        result = prime * result + firstServerGamesWon;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SetState other = (SetState) obj;
        if (firstReceiverGamesWon != other.firstReceiverGamesWon || 
                firstServerGamesWon != other.firstServerGamesWon) {
            return false;
        }
        return true;
    }
    
    public int getFirstServerGamesWon() {
        return firstServerGamesWon;
    }

    public int getFirstReceiverGamesWon() {
        return firstReceiverGamesWon;
    }
}
