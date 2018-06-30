package it.ao.chess.player;

import it.ao.chess.Color;

public class PlayerWhite implements Player {
	
	private static final Color chessColor = Color.WHITE;
	private final String name;

	public PlayerWhite(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Color getChessColor() {
		return PlayerWhite.chessColor;
	}
	
}
