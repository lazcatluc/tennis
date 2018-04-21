package ro.contezi.tennis.set;

import ro.contezi.tennis.tiebreak.TiebreakGameEvaluator;
import ro.contezi.tennis.tiebreak.TiebreakState;

public class TiebreakSetTreeEvaluator extends SetTreeEvaluator {
    public TiebreakSetTreeEvaluator(double probabilityOfFirstServerWinningAPointWhenServing,
                                       double probabilityOfFirstReceiverWinningAPointWhenServing) {
        super(probabilityOfFirstServerWinningAPointWhenServing, probabilityOfFirstReceiverWinningAPointWhenServing,
                new TiebreakGameEvaluator(probabilityOfFirstServerWinningAPointWhenServing,
                        probabilityOfFirstReceiverWinningAPointWhenServing)
                .getEstimatedScore(new TiebreakState(0, 0)));
    }
}
