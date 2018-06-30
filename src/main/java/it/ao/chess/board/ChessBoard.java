package it.ao.chess.board;

import it.ao.chess.pieces.Piece;

public class ChessBoard {
	
	private final int width;
	private final int height;
	private final ChessBoardSquare[][] squares;
	
	public ChessBoard(int width, int height) {
		this.width = width;
		this.height = height;
		squares = new ChessBoardSquare[this.height][this.width];
	}
	
	public void addPiece(Piece piece, int x, int y) {
		squares[y-1][x-1].setPiece(piece);
	}
	
	public ChessBoardSquare getChessBoardSquare(ChessBoardSquareCoordinates coordinates) {
		return this.getChessBoardSquare(coordinates.getX(), coordinates.getY());
	}
	
	public ChessBoardSquare getChessBoardSquare(int x, int y) {
		return squares[y-1][x-1];
	}

	public ChessBoardSquare[][] getSquares() {
		return squares;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void draw() {
		for(int i = 0; i < this.height; i++) {
			for(int u = 0; u < this.width; u++) {
				squares[i][u].draw();
			}
			System.out.println();
		}
	}

}
