package it.ao.chess.game;

import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.move.IllegalMoveException;

class GameReady implements GameState {

	private final ChessGame chessGame;
	
	public GameReady(ChessGame chessGame) {
		super();
		this.chessGame = chessGame;
	}
	
	@Override
	public void start() {
		this.chessGame.setGameState(this.chessGame.getGameTurnWhite()); //white moves first
	}

	@Override
	public void move(ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException {
		throw new IllegalStateException();
	}

	@Override
	public void resign() {
		throw new IllegalStateException();
	}

}
