package it.ao.chess.move;

import it.ao.chess.board.ChessBoard;
import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.pieces.Piece;
import it.ao.chess.pieces.Rook;

public class RookMoveValidator implements MoveValidator {

	@Override
	public void isValid(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to)
			throws IllegalMoveException {
		Piece piece = chessBoard.getChessBoardSquare(from).getPiece();
		if(!(piece instanceof Rook)) {
			return;
		}
		
		//if the row is different and the column is different
		if(from.getX() != to.getX() && from.getY() != to.getY()) {
			throw new IllegalMoveException("The Rook must move in the same row or in the same column!");
		}
		
		//////////////////////////////////////////////////
		//Check if there is a piece between start and end
		//////////////////////////////////////////////////
		int offset;
		//same column
		if(from.getX() == to.getX()) {
			if(to.getY() > from.getY()) { 
				offset = 1; //going ahead
			} else {
				offset = -1; //going backwards
			}
			for(int y = from.getY() + offset; y != to.getY(); y += offset) {
				if(!chessBoard.getChessBoardSquare(from.getX(), y).isEmpty()) {
					throw new IllegalMoveException("The Rook cannot overcome another piece!");
				}
			}
		}
		//same row
		if(from.getY() == to.getY()) {
			if(to.getX() > from.getX()) { 
				offset = 1; //going ahead
			} else {
				offset = -1; //going backwards
			}
			for(int x = from.getX() + offset; x != to.getX(); x += offset) {
				if(!chessBoard.getChessBoardSquare(x, from.getY()).isEmpty()) {
					throw new IllegalMoveException("The Rook cannot overcome another piece!");
				}
			}
		}
	}

}
