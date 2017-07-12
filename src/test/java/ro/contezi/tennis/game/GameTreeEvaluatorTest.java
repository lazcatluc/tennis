package ro.contezi.tennis.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GameTreeEvaluatorTest {

	@Test
	public void whenServerHasWonScoreIsOne() {
		assertThat(new GameTreeEvaluator(0).getEstimatedScore(new GameState(GameScore.ADVANTAGE, GameScore.THIRTY)))
			.isEqualTo(1);
	}

	@Test
	public void whenReceiverHasWonScoreIsMinusOne() {
		assertThat(new GameTreeEvaluator(0).getEstimatedScore(new GameState(GameScore.THIRTY, GameScore.ADVANTAGE)))
			.isEqualTo(-1);
	}
}
