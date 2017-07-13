package ro.contezi.tennis.runner;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;
import ro.contezi.tennis.game.GameTreeEvaluator;
import ro.contezi.tennis.set.SetState;
import ro.contezi.tennis.set.SetTreeEvaluator;

public class Main {
	public static void main(String[] args) {
		System.out.println(new GameTreeEvaluator(0.6).getEstimatedScore(new GameState(GameScore.ZERO, GameScore.ZERO)));
		System.out.println(new SetTreeEvaluator(0.6, 0.55).getEstimatedScore(new SetState(0, 0)));
	}
}
