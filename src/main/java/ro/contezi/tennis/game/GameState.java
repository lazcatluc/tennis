package ro.contezi.tennis.game;

public class GameState {
	private final GameScore server;
	private final GameScore receiver;
	private final GameResult result;
	
	public GameState(GameScore server, GameScore receiver) {
		this.server = server;
		this.receiver = receiver;
		this.result = GameResult.UNDECIDED;
	}

	public GameResult getResult() {
		return result;
	}
	
	
}
