package it.ao.chess.game;

import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.move.IllegalMoveException;

class GameEnded implements GameState {

	@SuppressWarnings("unused")
	private final ChessGame chessGame;
	
	public GameEnded(ChessGame chessGame) {
		super();
		this.chessGame = chessGame;
	}

	@Override
	public void move(ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException {
		throw new IllegalStateException();
	}

	@Override
	public void resign() {
		throw new IllegalStateException();
	}

	@Override
	public void start() {
		throw new IllegalStateException();
	}

}
