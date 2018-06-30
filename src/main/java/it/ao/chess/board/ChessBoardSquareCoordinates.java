package it.ao.chess.board;

import it.ao.chess.Alphabet;

public class ChessBoardSquareCoordinates {

	private final int x;
	private final int y;
	
	public ChessBoardSquareCoordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean bothAreZero() {
		if((x == 0) && (y == 0)) {
			return true;
		}
		return false;
	}
	
	public boolean bothAreEven() {
		if((x % 2 == 0) && (y % 2 == 0)) {
			return true;
		}
		return false;
	}
	
	public boolean bothAreOdd() {
		if((x % 2 != 0) && (y % 2 != 0)) {
			return true;
		}
		return false;
	}
	
	public char getXasChar() {
		return Alphabet.values()[this.x-1].toChar();
	}
	
}
