package ro.contezi.tennis.game;

public enum GameScore {
	ZERO, FIFTEEN, THIRTY, FORTY, ADVANTAGE;

	public GameScore next() {
		return GameScore.values()[this.ordinal() + 1];
	}
}
