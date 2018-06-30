package it.ao.chess.move;

import it.ao.chess.board.ChessBoard;
import it.ao.chess.board.ChessBoardSquareCoordinates;

public interface MoveValidator {

	public void isValid(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException;
	
}
