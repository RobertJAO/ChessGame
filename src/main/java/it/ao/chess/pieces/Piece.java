package it.ao.chess.pieces;

import it.ao.chess.Color;

public interface Piece {
	
	public Color getColor();
	public boolean isTaken();
	public void setTaken(boolean taken);
	
}
