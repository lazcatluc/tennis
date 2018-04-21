package ro.contezi.tennis.tiebreak;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import ro.contezi.tennis.game.GameResult;

public class TiebreakGameEvaluator {
    static final int POINTS_TO_WIN = 6;

    private final Map<TiebreakState, Double> estimatedScore = new HashMap<>();
    private final double probabilityOfFirstServerWinningAPointWhenServing;
    private final double probabilityOfFirstReceiverWinningAPointWhenServing;

    public TiebreakGameEvaluator(double probabilityOfFirstServerWinningAPointWhenServing,
                                 double probabilityOfFirstReceiverWinningAPointWhenServing) {
        this.probabilityOfFirstServerWinningAPointWhenServing = probabilityOfFirstServerWinningAPointWhenServing;
        this.probabilityOfFirstReceiverWinningAPointWhenServing = probabilityOfFirstReceiverWinningAPointWhenServing;
        estimatedScore.put(new TiebreakState(POINTS_TO_WIN, POINTS_TO_WIN), computeDeuceValue());
    }

    private Double computeDeuceValue() {
        double p = probabilityOfFirstServerWinningAPointWhenServing;
        double q = probabilityOfFirstReceiverWinningAPointWhenServing;

        return p*(q-1)/((2*p-1)*q-p);
    }

    protected BiFunction<Integer, Integer, ? extends TiebreakState> stateFactory() {
        return TiebreakState::new;
    }

    public Double getEstimatedScore(TiebreakState tiebreakState) {
        return estimatedScore.computeIfAbsent(tiebreakState, state -> {
            if (tiebreakState.getResult() == GameResult.SERVER_WINS) {
                return 1.0;
            }
            if (tiebreakState.getResult() == GameResult.RECEIVER_WINS) {
                return 0.0;
            }
            Double firstServerWins = getEstimatedScore(
                    stateFactory().apply(state.getFirstServerPoints() + 1, state.getFirstReceiverPoints()));
            Double firstReceiverWins = getEstimatedScore(
                    stateFactory().apply(state.getFirstServerPoints(), state.getFirstReceiverPoints() + 1));
            if (tiebreakState.firstServerServesNow()) {
                return probabilityOfFirstServerWinningAPointWhenServing * firstServerWins +
                        (1 - probabilityOfFirstServerWinningAPointWhenServing) * firstReceiverWins;
            }
            return (1 - probabilityOfFirstReceiverWinningAPointWhenServing) * firstServerWins +
                    probabilityOfFirstReceiverWinningAPointWhenServing * firstReceiverWins;
        });
    }

}
