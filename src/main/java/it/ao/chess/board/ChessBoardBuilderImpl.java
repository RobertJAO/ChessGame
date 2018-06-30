package it.ao.chess.board;

import it.ao.chess.Color;
import it.ao.chess.pieces.Bishop;
import it.ao.chess.pieces.Pawn;
import it.ao.chess.pieces.Piece;
import it.ao.chess.pieces.Rook;

//build a chess board 8X8 filled with pieces in the start position
public class ChessBoardBuilderImpl implements ChessBoardBuilder {
	
	private final ChessBoard chessBoard;
	private static int WIDTH = 8;
	private static int HEIGHT = 8;
	
	public ChessBoardBuilderImpl() {
		super();
		this.chessBoard = new ChessBoard(WIDTH, HEIGHT);
	}

	@Override
	public void fillWithSquares() {
		ChessBoardSquare[][] squares = this.chessBoard.getSquares();
		for(int i = 0; i < HEIGHT; i++) {
			for(int u = 0; u < WIDTH; u++) {
				ChessBoardSquareCoordinates coordinates = new ChessBoardSquareCoordinates(u+1, i+1);
				Color color = (coordinates.bothAreEven() || coordinates.bothAreOdd()) ? Color.BLACK : Color.WHITE;
				squares[i][u] = new ChessBoardSquare(coordinates, color);
			}
		}
	}
	
	@Override
	public void fillWithWithePieces() {
		final Color color = Color.WHITE;
		Piece bishop = new Bishop(color);
		this.chessBoard.addPiece(bishop, 3, 1);
		Piece rook = new Rook(color);
		this.chessBoard.addPiece(rook, 1, 1);
		//TODO
	}

	@Override
	public void fillWithBlackPieces() {
		final Color color = Color.BLACK;
		Piece rook = new Rook(color);
		this.chessBoard.addPiece(rook, 1, 8);
		Piece pawn = new Pawn(color);
		this.chessBoard.addPiece(pawn, 1, 7);
	}
	
	@Override
	public ChessBoard getChessBoard() {
		return this.chessBoard;
	}

}
