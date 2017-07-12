package ro.contezi.tennis.game.play;

import ro.contezi.tennis.game.GameScore;
import ro.contezi.tennis.game.GameState;

public interface GamePlay {

	GameState winServe();

	GameState loseServe();
	
	static GamePlay forState(GameState original) {
		if (original.getServer() == GameScore.ADVANTAGE) {
			return new AdvantageServer();
		}
		if (original.getReceiver() == GameScore.ADVANTAGE) {
			return new AdvantageReceiver();
		}
		return new RegularGamePlay(original);
	}

}