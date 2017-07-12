package ro.contezi.tennis.game.play;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;

class AdvantageReceiver implements GamePlay {

	@Override
	public GameState winServe() {
		return new GameState(GameScore.FORTY, GameScore.FORTY);
	}

	@Override
	public GameState loseServe() {
		return new GameState(GameScore.THIRTY, GameScore.ADVANTAGE);
	}

}
