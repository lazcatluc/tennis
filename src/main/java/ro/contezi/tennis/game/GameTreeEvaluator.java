package ro.contezi.tennis.game;

import java.util.HashMap;
import java.util.Map;

import ro.contezi.tennis.game.play.GamePlay;

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
		return (p * p) / (2 * p * p - 2 * p + 1);
	}

	public double getEstimatedScore(GameState state) {
		if (state.getResult() == GameResult.SERVER_WINS) {
			return 1;
		}
		if (state.getResult() == GameResult.RECEIVER_WINS) {
			return 0;
		}
		return estimatedScore.computeIfAbsent(state, uncomputed -> {
			GamePlay forState = GamePlay.forState(uncomputed);
			double winScore = getEstimatedScore(forState.winServe());
			double loseScore = getEstimatedScore(forState.loseServe());
			return winScore * probabilityOfServerWinningAPoint + loseScore * (1 - probabilityOfServerWinningAPoint);
		});
	}
}
