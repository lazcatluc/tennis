package ro.contezi.tennis.tiebreak;

import static ro.contezi.tennis.tiebreak.TiebreakGameEvaluator.POINTS_TO_WIN;

import java.util.Objects;
import ro.contezi.tennis.game.GameResult;

public class TiebreakState {
    private final int firstServerPoints;
    private final int firstReceiverPoints;

    public TiebreakState(int firstServerPoints, int firstReceiverPoints) {
        this.firstServerPoints = firstServerPoints;
        this.firstReceiverPoints = firstReceiverPoints;
    }

    public GameResult getResult() {
        if (hasDecisiveLead(firstServerPoints, firstReceiverPoints)) {
            return GameResult.SERVER_WINS;
        }

        if (hasDecisiveLead(firstReceiverPoints, firstServerPoints)) {
            return GameResult.RECEIVER_WINS;
        }
        return GameResult.UNDECIDED;
    }

    protected boolean hasDecisiveLead(int leader, int follower) {
        return leader >= POINTS_TO_WIN && leader - follower > 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiebreakState that = (TiebreakState) o;
        return firstServerPoints == that.firstServerPoints &&
                firstReceiverPoints == that.firstReceiverPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstServerPoints, firstReceiverPoints);
    }

    public int getFirstServerPoints() {
        return firstServerPoints;
    }

    public int getFirstReceiverPoints() {
        return firstReceiverPoints;
    }

    public boolean firstServerServesNow() {
        if (firstReceiverPoints + firstServerPoints == 0) {
            return true;
        }
        int serverIndex = (firstServerPoints + firstReceiverPoints - 1) % 4;
        return serverIndex >= 2;
    }
}
