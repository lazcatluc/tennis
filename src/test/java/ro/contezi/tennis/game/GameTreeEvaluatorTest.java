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
	
	@Test
	public void deuceScoreIs1WhenWinProbabilityIs1() throws Exception {
		assertThat(new GameTreeEvaluator(1).getEstimatedScore(new GameState(GameScore.FORTY, GameScore.FORTY)))
			.isEqualTo(1);
				
	}
	
	@Test
	public void deuceScoreIsMinus1WhenWinProbabilityIs0() throws Exception {
		assertThat(new GameTreeEvaluator(0).getEstimatedScore(new GameState(GameScore.FORTY, GameScore.FORTY)))
			.isEqualTo(-1);
				
	}
	
	@Test
	public void deuceScoreIsZero1WhenWinProbabilityIsEqual() throws Exception {
		assertThat(new GameTreeEvaluator(0.5).getEstimatedScore(new GameState(GameScore.FORTY, GameScore.FORTY)))
			.isEqualTo(0);
				
	}
}
