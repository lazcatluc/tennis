package ro.contezi.tennis.game.play;

import ro.contezi.tennis.game.GameState;

class RegularGamePlay implements GamePlay {
	
	private final GameState original;
	
	public RegularGamePlay(GameState original) {
		this.original = original;
	}

	@Override
	public GameState winServe() {
		return new GameState(original.getServer().next(), original.getReceiver());
	}
	
	@Override
	public GameState loseServe() {
		return new GameState(original.getServer(), original.getReceiver().next());
	}
}
