package ro.contezi.tennis.set;

public class TieBreakSetState extends SetState {

    public TieBreakSetState() {
        super();
    }
    
    public TieBreakSetState(int firstServerGamesWon, int firstReceiverGamesWon) {
        super(firstServerGamesWon, firstReceiverGamesWon);
    }
    
    @Override
    protected boolean hasDecisiveLead(int leader, int follower) {
        return leader == SetState.GAMES_TO_WIN + 1 || super.hasDecisiveLead(leader, follower);
    }

}
