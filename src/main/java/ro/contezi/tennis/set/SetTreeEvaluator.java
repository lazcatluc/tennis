package ro.contezi.tennis.set;

import java.util.HashMap;
import java.util.Map;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;
import ro.contezi.tennis.game.GameTreeEvaluator;

public class SetTreeEvaluator {
    private final Map<GameState, Double> estimatedScore = new HashMap<>();
    private final double probabilityOfFirstServerWinningAPointWhenServing;
    private final double probabilityOfFirstReceiverWinningAPointWhenServing;
    
    public SetTreeEvaluator(double probabilityOfFirstServerWinningAPointWhenServing,
            double probabilityOfFirstReceiverWinningAPointWhenServing) {
        this.probabilityOfFirstServerWinningAPointWhenServing = probabilityOfFirstServerWinningAPointWhenServing;
        this.probabilityOfFirstReceiverWinningAPointWhenServing = probabilityOfFirstReceiverWinningAPointWhenServing;
    }
    
    protected Double computeDeuceValue() {
        double p1 = winGameOnServeProbability(probabilityOfFirstServerWinningAPointWhenServing);
        double p2 = winGameOnServeProbability(probabilityOfFirstReceiverWinningAPointWhenServing);
        double probabilityFirstServerWinsBoth = p1 * (1 - p2);
        double probabilityFirstServerWinsOnlyFirst = p1 * p2;
        double probabilityFirstServerWinsOnlySecond = (1 - p1) * (1 - p2);
        double probabilityGoBackToDeuce = probabilityFirstServerWinsOnlyFirst + probabilityFirstServerWinsOnlySecond;
        return probabilityFirstServerWinsBoth / (1 - probabilityGoBackToDeuce);
    }

    private double winGameOnServeProbability(double winServeProbability) {
        return new GameTreeEvaluator(winServeProbability)
                .getEstimatedScore(new GameState(GameScore.ZERO, GameScore.ZERO));
    }
}
