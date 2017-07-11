package ro.contezi.tennis.game;

public class GameState {
	private final GameScore server;
	private final GameScore receiver;
	private final GameResult result;
	
	public GameState(GameScore server, GameScore receiver) {
		this.server = server;
		this.receiver = receiver;
		this.result = computeResult();
	}

	private GameResult computeResult() {
		if (server == GameScore.ADVANTAGE && receiver.compareTo(GameScore.FORTY) < 0) {
			return GameResult.SERVER_WINS;
		}
		if (receiver == GameScore.ADVANTAGE && server.compareTo(GameScore.FORTY) < 0) {
			return GameResult.RECEIVER_WINS;
		}
		return GameResult.UNDECIDED;
	}

	public GameResult getResult() {
		return result;
	}
	
	
}
