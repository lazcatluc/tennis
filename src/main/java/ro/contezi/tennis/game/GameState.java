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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		GameState other = (GameState) obj;
		if (receiver != other.receiver || server != other.server)
			return false;
		return true;
	}

	public GameScore getReceiver() {
		return receiver;
	}

	public GameScore getServer() {
		return server;
	}
	
}
