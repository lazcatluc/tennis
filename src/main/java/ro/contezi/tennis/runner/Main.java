package ro.contezi.tennis.runner;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;
import ro.contezi.tennis.game.GameTreeEvaluator;

public class Main {
	public static void main(String[] args) {
		System.out.println(new GameTreeEvaluator(0.6).getEstimatedScore(new GameState(GameScore.ZERO, GameScore.ZERO)));
	}
}
