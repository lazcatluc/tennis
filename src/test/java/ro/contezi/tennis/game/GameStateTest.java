package ro.contezi.tennis.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractComparableAssert;
import org.junit.Test;

public class GameStateTest {

	@Test
	public void gameIsUndecidedInTheBeginning() {
		assertResultOf(GameScore.ZERO, GameScore.ZERO).isEqualTo(GameResult.UNDECIDED);
	}

	@Test
	public void serverWinsWithAdvantageToThirty() throws Exception {
		assertResultOf(GameScore.ADVANTAGE, GameScore.THIRTY).isEqualTo(GameResult.SERVER_WINS);
	}
	
	@Test
	public void gameIsUndecidedWithAdvantageToForty() throws Exception {
		assertResultOf(GameScore.ADVANTAGE, GameScore.FORTY).isEqualTo(GameResult.UNDECIDED);
	}
	
	@Test
	public void receiverWinsWithThirtyToAdvantage() throws Exception {
		assertResultOf(GameScore.THIRTY, GameScore.ADVANTAGE).isEqualTo(GameResult.RECEIVER_WINS);
	}
	
	@Test
	public void gameIsUndecidedWithFortyToAdvantage() throws Exception {
		assertResultOf(GameScore.FORTY, GameScore.ADVANTAGE).isEqualTo(GameResult.UNDECIDED);
	}

	private AbstractComparableAssert<?, GameResult> assertResultOf(GameScore server, GameScore receiver) {
		return assertThat(new GameState(server, receiver).getResult());
	}
}
