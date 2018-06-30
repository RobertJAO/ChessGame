package it.ao.chess.game;

import it.ao.chess.Color;
import it.ao.chess.board.ChessBoard;
import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.move.IllegalMoveException;
import it.ao.chess.move.MovePieceTemplate;
import it.ao.chess.pieces.Piece;

class GameTurnBlack extends MovePieceTemplate implements GameState {

	private final ChessGame chessGame;
	private static final Color GAME_TURN_COLOR = Color.BLACK;
	
	public GameTurnBlack(ChessGame chessGame) {
		super();
		this.chessGame = chessGame;
	}
	
	@Override
	public void start() {
		throw new IllegalStateException();
	}

	@Override
	public void move(ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException {
		ChessBoard chessBoard = this.chessGame.getChessBoard();
		this.move(chessBoard, from, to);
	}

	@Override
	public void resign() {
		this.chessGame.setWinner(this.chessGame.getPlayerWhite());
		this.chessGame.setGameState(this.chessGame.getGameEnded());
	}

	@Override
	protected void checkGameTurn(ChessBoard chessBoard, ChessBoardSquareCoordinates from,
			ChessBoardSquareCoordinates to) {
		Piece piece = chessBoard.getChessBoardSquare(from).getPiece();
		if(!GAME_TURN_COLOR.equals(piece.getColor())) {
			throw new IllegalMoveException("Wrong game turn!");
		}
	}

	@Override
	protected void changeGameTurn() {
		//the game turn passes to white
		this.chessGame.setGameState(this.chessGame.getGameTurnWhite());
	}

	@Override
	protected void addPieceTaken(Piece piece) {
		this.chessGame.addPieceTaken(piece);
	}

}
