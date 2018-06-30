package it.ao.chess.board;

public class ChessBoardDirector {
	
	private final ChessBoardBuilder chessBoardBuilder;

	public ChessBoardDirector(ChessBoardBuilder chessBoardBuilder) {
		super();
		this.chessBoardBuilder = chessBoardBuilder;
	}

	public ChessBoard build() {
		chessBoardBuilder.fillWithSquares();
		chessBoardBuilder.fillWithWithePieces();
		chessBoardBuilder.fillWithBlackPieces();
		return this.chessBoardBuilder.getChessBoard();
	}
	
}
