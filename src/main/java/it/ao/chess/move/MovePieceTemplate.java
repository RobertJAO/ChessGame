package it.ao.chess.move;

import java.util.ArrayList;
import java.util.List;

import it.ao.chess.board.ChessBoard;
import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.pieces.Piece;

public abstract class MovePieceTemplate {
	
	private final List<MoveValidator> moveValidators;
	
	public MovePieceTemplate() {
		super();
		this.moveValidators = new ArrayList<>();
		this.moveValidators.add(new RookMoveValidator());
	}

	protected final void move(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) throws IllegalMoveException {
		//check if there is something in the starting square
		this.checkStartingSquare(chessBoard, from, to);
		
		//check turn
		this.checkGameTurn(chessBoard, from, to);
		
		//check if there is a piece of the same color in the arrival square
		this.checkArrivalSquare(chessBoard, from, to);
		
		//move validation logic
		for(MoveValidator moveValidator : this.moveValidators) {
			moveValidator.isValid(chessBoard, from, to);
		}
		
		//take the piece in the arrival square
		if(!chessBoard.getChessBoardSquare(to).isEmpty()) {
			//taken
			Piece piece2 = chessBoard.getChessBoardSquare(to).getPiece();
			chessBoard.getChessBoardSquare(to).setPiece(null);
			piece2.setTaken(true);
			addPieceTaken(piece2);
		}
		
		//ok
		//move piece
		movePiece(chessBoard, from, to);
		
		//the game turn changes
		changeGameTurn();
	}
	
	protected void checkStartingSquare(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) {
		if (chessBoard.getChessBoardSquare(from).isEmpty()) {
			throw new IllegalMoveException("There is nothing in the starting square!");
		}
	}
	
	protected void checkArrivalSquare(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) {
		Piece piece = chessBoard.getChessBoardSquare(from).getPiece();
		if((!chessBoard.getChessBoardSquare(to).isEmpty()) && 
				piece.getColor().equals(chessBoard.getChessBoardSquare(to).getPiece().getColor())) {
			throw new IllegalMoveException("There is already a piece of the same color in the arrival square!");
		}
	}
	
	protected void movePiece(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to) {
		chessBoard.getChessBoardSquare(to).setPiece(chessBoard.getChessBoardSquare(from).getPiece());
		chessBoard.getChessBoardSquare(from).setPiece(null);
	}
	
	protected abstract void checkGameTurn(ChessBoard chessBoard, ChessBoardSquareCoordinates from, ChessBoardSquareCoordinates to);
	
	protected abstract void changeGameTurn();
	
	protected abstract void addPieceTaken(Piece piece);
	
}
