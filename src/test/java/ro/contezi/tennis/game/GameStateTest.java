package ro.contezi.tennis.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GameStateTest {

	@Test
	public void gameIsUndecidedInTheBeginning() {
		assertThat(new GameState(GameScore.ZERO, GameScore.ZERO).getResult()).isEqualTo(GameResult.UNDECIDED);
	}

}
