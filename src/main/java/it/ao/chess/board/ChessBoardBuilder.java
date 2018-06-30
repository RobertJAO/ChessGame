package it.ao.chess.board;

public interface ChessBoardBuilder {

	public void fillWithSquares();
	public void fillWithWithePieces();
	public void fillWithBlackPieces();
	public ChessBoard getChessBoard();
	
}
