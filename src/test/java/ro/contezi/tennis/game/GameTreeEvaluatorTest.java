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
	public void whenReceiverHasWonScoreIsZero() {
		assertThat(new GameTreeEvaluator(0).getEstimatedScore(new GameState(GameScore.THIRTY, GameScore.ADVANTAGE)))
			.isEqualTo(0);
	}
	
	@Test
	public void deuceScoreIs1WhenWinProbabilityIs1() throws Exception {
		assertThat(new GameTreeEvaluator(1).getEstimatedScore(new GameState(GameScore.FORTY, GameScore.FORTY)))
			.isEqualTo(1);
				
	}
	
	@Test
	public void deuceScoreIs0WhenWinProbabilityIs0() throws Exception {
		assertThat(new GameTreeEvaluator(0).getEstimatedScore(new GameState(GameScore.FORTY, GameScore.FORTY)))
			.isEqualTo(0);
				
	}
	
	@Test
	public void deuceScoreIsEqualWhenWinProbabilityIsEqual() throws Exception {
		assertThat(new GameTreeEvaluator(0.5).getEstimatedScore(new GameState(GameScore.FORTY, GameScore.FORTY)))
			.isEqualTo(0.5);
				
	}
	
	@Test
	public void initialStateScoreIsEqualWhenWinProbabilityIsEqual() throws Exception {
		assertThat(new GameTreeEvaluator(0.5).getEstimatedScore(new GameState(GameScore.ZERO, GameScore.ZERO)))
			.isEqualTo(0.5);
				
	}
}
