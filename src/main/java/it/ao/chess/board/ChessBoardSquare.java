package it.ao.chess.board;

import it.ao.chess.Color;
import it.ao.chess.pieces.Piece;

public class ChessBoardSquare {

	private final ChessBoardSquareCoordinates coordinates;
	private final Color color;
	private Piece piece;
	
	public ChessBoardSquare(ChessBoardSquareCoordinates coordinates, Color color) {
		super();
		this.coordinates = coordinates;
		this.color = color;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public ChessBoardSquareCoordinates getCoordinates() {
		return coordinates;
	}

	public Color getColor() {
		return color;
	}
	
	public boolean isEmpty() {
		if(this.piece == null) {
			return true;
		}
		return false;
	}
	
	public void draw() {
		System.out.print("[");
		System.out.print(
			""	
			+ this.coordinates.getXasChar()
			+ this.coordinates.getY()
			+ "color:" + this.color.toString()
		);
		System.out.print(this.piece != null ? this.piece : "");
		System.out.print("]");
	}
	
}
