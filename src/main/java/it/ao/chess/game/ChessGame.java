package it.ao.chess.game;

import java.util.ArrayList;
import java.util.List;

import it.ao.chess.board.ChessBoard;
import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.move.IllegalMoveException;
import it.ao.chess.pieces.Piece;
import it.ao.chess.player.Player;
import it.ao.chess.player.PlayerBlack;
import it.ao.chess.player.PlayerWhite;

public class ChessGame implements GameState {

	private final PlayerWhite playerWhite;
	private final PlayerBlack playerBlack;
	private Player winner;
	private final ChessBoard chessBoard;
	private final List<Piece> piecesTaken = new ArrayList<>();
	
	//states
	private GameReady gameReady;
	private GameTurnWhite gameTurnWhite;
	private GameTurnBlack gameTurnBlack;
	private GameEnded gameEnded;
	private GameState gameState;

	public ChessGame(PlayerWhite playerWhite, PlayerBlack playerBlack, ChessBoard chessBoard) {
		super();
		this.playerWhite = playerWhite;
		this.playerBlack = playerBlack;
		this.chessBoard = chessBoard;
		
		//TODO
		//It's not a good idea to pass 'this' in the constructor
		//better in PostConstruct, like using Spring
		this.gameReady = new GameReady(this);
		this.gameTurnBlack = new GameTurnBlack(this);
		this.gameTurnWhite = new GameTurnWhite(this);
		this.gameEnded = new GameEnded(this);
		this.gameState = this.gameReady;
	}

	public void move(ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException {
		this.gameState.move(from, to);
	}

	@Override
	public void start() {
		this.gameState.start();
	}

	@Override
	public void resign() {
		this.gameState.resign();
	}
	
	public Player getWinner() {
		return winner;
	}

	void setWinner(Player winner) {
		this.winner = winner;
	}

	void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	GameState getGameTurnWhite() {
		return this.gameTurnWhite;
	}
	
	GameState getGameTurnBlack() {
		return this.gameTurnBlack;
	}

	GameState getGameEnded() {
		return this.gameEnded;
	}

	GameState getGameReady() {
		return this.gameReady;
	}

	PlayerWhite getPlayerWhite() {
		return playerWhite;
	}

	PlayerBlack getPlayerBlack() {
		return playerBlack;
	}

	ChessBoard getChessBoard() {
		return chessBoard;
	}
	
	void addPieceTaken(Piece piece) {
		this.piecesTaken.add(piece);
	}
	
	public void printGameState() {
		System.out.println(this.gameState.getClass().getSimpleName());
	}
	
	public void printTakenPieces() {
		System.out.println("Pieces that have been taken during the match: " + this.piecesTaken);
	}
	
	public void printWinner() {
		System.out.println(String.format("And the winner is player %s!", this.getWinner().getName()));
	}
	
}
