package ro.contezi.tennis.game;

public class GamePlay {
	public GameState winServe(GameState original) {
		GameScore receiver = original.getReceiver();
		GameScore server = original.getServer();
		if (receiver == GameScore.ADVANTAGE) {
			return new GameState(GameScore.FORTY, GameScore.FORTY);
		}
		if (server == GameScore.ADVANTAGE) {
			return new GameState(GameScore.ADVANTAGE, GameScore.THIRTY);
		}
		return new GameState(server.next(), receiver);
	}
	
	public GameState loseServe(GameState original) {
		GameScore server = original.getServer();
		GameScore receiver = original.getReceiver();
		if (receiver == GameScore.ADVANTAGE) {
			return new GameState(GameScore.THIRTY, GameScore.ADVANTAGE);
		}
		if (server == GameScore.ADVANTAGE) {
			return new GameState(GameScore.FORTY, GameScore.FORTY);
		}
		return new GameState(server, receiver.next());
	}
}
