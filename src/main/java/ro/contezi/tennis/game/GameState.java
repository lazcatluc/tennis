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
		if (hasDecisiveAdvantage(server, receiver)) {
			return GameResult.SERVER_WINS;
		}
		if (hasDecisiveAdvantage(receiver, server)) {
			return GameResult.RECEIVER_WINS;
		}
		return GameResult.UNDECIDED;
	}
	
	private boolean hasDecisiveAdvantage(GameScore advantaged, GameScore disadvantaged) {
		return advantaged == GameScore.ADVANTAGE && disadvantaged.compareTo(GameScore.FORTY) < 0;
	}

	public GameResult getResult() {
		return result;
	}
	
}
