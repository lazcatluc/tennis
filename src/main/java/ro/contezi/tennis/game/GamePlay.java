package ro.contezi.tennis.game;

public class GamePlay {
	public GameState winServe(GameState original) {
		GameScore receiver = original.getReceiver();
		if (receiver == GameScore.ADVANTAGE) {
			return new GameState(GameScore.FORTY, GameScore.FORTY);
		}
		return new GameState(original.getServer().next(), receiver);
	}
	
	public GameState loseServe(GameState original) {
		return new GameState(original.getServer(), original.getReceiver().next());
	}
}
