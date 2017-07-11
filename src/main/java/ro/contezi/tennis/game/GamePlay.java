package ro.contezi.tennis.game;

public class GamePlay {
	public GameState winServe(GameState original) {
		return new GameState(original.getServer().next(), original.getReceiver());
	}
	
	public GameState loseServe(GameState original) {
		return new GameState(original.getServer(), original.getReceiver().next());
	}
}
