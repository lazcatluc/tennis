package ro.contezi.tennis.game.play;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;

public class GamePlayTest {

	@Test
	public void winningTheServeMovesInitialToFifteenZero() {
		assertThat(GamePlay.forState(new GameState(GameScore.ZERO, GameScore.ZERO)).winServe())
				.isEqualTo(new GameState(GameScore.FIFTEEN, GameScore.ZERO));
	}

	@Test
	public void losingTheServeMovesInitialToZeroFifteen() {
		assertThat(GamePlay.forState(new GameState(GameScore.ZERO, GameScore.ZERO)).loseServe())
				.isEqualTo(new GameState(GameScore.ZERO, GameScore.FIFTEEN));
	}
	
	@Test
	public void winningTheServeWhenReceiverHasAdvantageMovesToDeuce() {
		assertThat(GamePlay.forState(new GameState(GameScore.FORTY, GameScore.ADVANTAGE)).winServe())
				.isEqualTo(new GameState(GameScore.FORTY, GameScore.FORTY));
	}
	
	@Test
	public void losingTheServeWhenServerHasAdvantageMovesToDeuce() {
		assertThat(GamePlay.forState(new GameState(GameScore.ADVANTAGE, GameScore.FORTY)).loseServe())
				.isEqualTo(new GameState(GameScore.FORTY, GameScore.FORTY));
	}
	
	@Test
	public void winningTheServeWhenServerHasAdvantageMovesToServerWin() {
		assertThat(GamePlay.forState(new GameState(GameScore.ADVANTAGE, GameScore.FORTY)).winServe())
				.isEqualTo(new GameState(GameScore.ADVANTAGE, GameScore.THIRTY));
	}
	
	@Test
	public void losingTheServeWhenReceiverHasAdvantageMovesToReceiverWin() {
		assertThat(GamePlay.forState(new GameState(GameScore.FORTY, GameScore.ADVANTAGE)).loseServe())
				.isEqualTo(new GameState(GameScore.THIRTY, GameScore.ADVANTAGE));
	}
}
