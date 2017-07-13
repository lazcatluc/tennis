package ro.contezi.tennis.set;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;
import ro.contezi.tennis.game.GameTreeEvaluator;

public class SetTreeEvaluator {
    private final Map<SetState, Double> estimatedScore = new HashMap<>();
    private final double probabilityOfFirstServerWinningAPointWhenServing;
    private final double probabilityOfFirstReceiverWinningAPointWhenServing;
    
    public SetTreeEvaluator(double probabilityOfFirstServerWinningAPointWhenServing,
            double probabilityOfFirstReceiverWinningAPointWhenServing) {
        this.probabilityOfFirstServerWinningAPointWhenServing = probabilityOfFirstServerWinningAPointWhenServing;
        this.probabilityOfFirstReceiverWinningAPointWhenServing = probabilityOfFirstReceiverWinningAPointWhenServing;
        estimatedScore.put(new SetState(SetState.GAMES_TO_WIN, SetState.GAMES_TO_WIN), computeDeuceValue());
    }
    
    private Double computeDeuceValue() {
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
    
    protected BiFunction<Integer, Integer, ? extends SetState> stateFactory() {
        return SetState::new;
    }
    
    public Double getEstimatedScore(SetState setState) {
        return estimatedScore.computeIfAbsent(setState, state -> {
            if (setState.getResult() == SetResult.FIRST_SERVER_WINS) {
                return 1.0;
            }
            if (setState.getResult() == SetResult.FIRST_RECEIVER_WINS) {
                return 0.0;
            }
            Double firstServerWins = getEstimatedScore(
                    stateFactory().apply(state.getFirstServerGamesWon() + 1, state.getFirstReceiverGamesWon()));
            Double firstReceiverWins = getEstimatedScore(
                    stateFactory().apply(state.getFirstServerGamesWon(), state.getFirstReceiverGamesWon() + 1));
            boolean firstServerServesNow = (state.getFirstServerGamesWon() + state.getFirstReceiverGamesWon()) % 2 == 0;
            if (firstServerServesNow) {
                return probabilityOfFirstServerWinningAPointWhenServing * firstServerWins +
                       (1 - probabilityOfFirstServerWinningAPointWhenServing) * firstReceiverWins;
            }
            return (1 - probabilityOfFirstReceiverWinningAPointWhenServing) * firstServerWins +
                    probabilityOfFirstReceiverWinningAPointWhenServing * firstReceiverWins;
        });
    }
}
