package it.ao.chess.player;

import it.ao.chess.Color;

public class PlayerBlack implements Player {
	
	private static final Color chessColor = Color.BLACK;
	private final String name;

	public PlayerBlack(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Color getChessColor() {
		return PlayerBlack.chessColor;
	}

}
