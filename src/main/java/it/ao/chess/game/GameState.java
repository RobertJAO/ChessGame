package it.ao.chess.game;

import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.move.IllegalMoveException;

public interface GameState {

	public void start();
	
	public void move(ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException;

	public void resign();
	
}
