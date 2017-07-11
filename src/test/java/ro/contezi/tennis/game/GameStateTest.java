package ro.contezi.tennis.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GameStateTest {

	@Test
	public void gameIsUndecidedInTheBeginning() {
		assertThat(new GameState(GameScore.ZERO, GameScore.ZERO).getResult()).isEqualTo(GameResult.UNDECIDED);
	}

	@Test
	public void serverWinsWithAdvantageToThirty() throws Exception {
		assertThat(new GameState(GameScore.ADVANTAGE, GameScore.THIRTY).getResult()).isEqualTo(GameResult.SERVER_WINS);
	}
}
