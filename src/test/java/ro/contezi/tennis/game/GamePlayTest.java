package ro.contezi.tennis.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GamePlayTest {

	private GamePlay gamePlay = new GamePlay();

	@Test
	public void winningTheServeMovesInitialToFifteenZero() {
		assertThat(gamePlay.winServe(new GameState(GameScore.ZERO, GameScore.ZERO)))
				.isEqualTo(new GameState(GameScore.FIFTEEN, GameScore.ZERO));
	}

	@Test
	public void losingTheServeMovesInitialToZeroFifteen() {
		assertThat(gamePlay.loseServe(new GameState(GameScore.ZERO, GameScore.ZERO)))
				.isEqualTo(new GameState(GameScore.ZERO, GameScore.FIFTEEN));
	}
}
