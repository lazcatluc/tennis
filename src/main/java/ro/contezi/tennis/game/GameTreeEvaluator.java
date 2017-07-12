package ro.contezi.tennis.game;

import java.util.HashMap;
import java.util.Map;

public class GameTreeEvaluator {
	private final GameState deuce = new GameState(GameScore.FORTY, GameScore.FORTY);
	private final Map<GameState, Double> estimatedScore = new HashMap<>();
	private final double probabilityOfServerWinningAPoint;

	public GameTreeEvaluator(double probabilityOfServerWinningAPoint) {
		this.probabilityOfServerWinningAPoint = probabilityOfServerWinningAPoint;
		estimatedScore.put(deuce, computeDeuceValue());
	}

	private Double computeDeuceValue() {
		double p = probabilityOfServerWinningAPoint;
		return (2 * p - 1) / (2 * p * p - 2 * p + 1);
	}

	public double getEstimatedScore(GameState state) {
		if (state.getServer() == GameScore.ADVANTAGE) {
			return 1;
		}
		if (state.getReceiver() == GameScore.ADVANTAGE) {
			return -1;
		}
		return estimatedScore.get(state);
	}
}
