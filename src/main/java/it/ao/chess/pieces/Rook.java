package it.ao.chess.pieces;

import it.ao.chess.Color;

public class Rook implements Piece {
	
	private final Color color;
	private boolean taken;
	
	public Rook(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean isTaken() {
		return this.taken;
	}

	@Override
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
	@Override
	public String toString() {
		return "(R)";
	}
	
}
