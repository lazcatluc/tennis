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
	
	@Test
	public void winningTheServeWhenReceiverHasAdvantageMovesToDeuce() {
		assertThat(gamePlay.winServe(new GameState(GameScore.FORTY, GameScore.ADVANTAGE)))
				.isEqualTo(new GameState(GameScore.FORTY, GameScore.FORTY));
	}
	
	@Test
	public void losingTheServeWhenServerHasAdvantageMovesToDeuce() {
		assertThat(gamePlay.loseServe(new GameState(GameScore.ADVANTAGE, GameScore.FORTY)))
				.isEqualTo(new GameState(GameScore.FORTY, GameScore.FORTY));
	}
	
	@Test
	public void winningTheServeWhenServerHasAdvantageMovesToServerWin() {
		assertThat(gamePlay.winServe(new GameState(GameScore.ADVANTAGE, GameScore.FORTY)))
				.isEqualTo(new GameState(GameScore.ADVANTAGE, GameScore.THIRTY));
	}
	
	@Test
	public void losingTheServeWhenReceiverHasAdvantageMovesToReceiverWin() {
		assertThat(gamePlay.loseServe(new GameState(GameScore.FORTY, GameScore.ADVANTAGE)))
				.isEqualTo(new GameState(GameScore.THIRTY, GameScore.ADVANTAGE));
	}
}
