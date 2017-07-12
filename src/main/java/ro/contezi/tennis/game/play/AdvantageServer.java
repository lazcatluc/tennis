package ro.contezi.tennis.game.play;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;

class AdvantageServer implements GamePlay {

	@Override
	public GameState winServe() {
		return new GameState(GameScore.ADVANTAGE, GameScore.THIRTY);
	}

	@Override
	public GameState loseServe() {
		return new GameState(GameScore.FORTY, GameScore.FORTY);
	}

}
