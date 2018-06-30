package chessGame;

import org.junit.Test;

import it.ao.chess.board.ChessBoard;
import it.ao.chess.board.ChessBoardBuilderImpl;
import it.ao.chess.board.ChessBoardDirector;
import it.ao.chess.board.ChessBoardSquareCoordinates;
import it.ao.chess.game.ChessGame;
import it.ao.chess.player.PlayerBlack;
import it.ao.chess.player.PlayerWhite;

public class ChessTest {

	@Test
	public void test() {
		PlayerWhite p1 = new PlayerWhite("p1");
		PlayerBlack p2 = new PlayerBlack("p2");
		ChessBoardBuilderImpl chessBoardBuilder = new ChessBoardBuilderImpl();
		ChessBoardDirector chessBoardDirector = new ChessBoardDirector(chessBoardBuilder);
		ChessBoard chessBoard = chessBoardDirector.build();
		chessBoard.draw();
		ChessGame game = new ChessGame(p1, p2, chessBoard);
		game.printGameState();
		game.start();
		game.printGameState();
		System.out.println("Moving...");
		game.move(new ChessBoardSquareCoordinates(1, 1), new ChessBoardSquareCoordinates(1, 7));
		game.printGameState();
		chessBoard.draw();
		game.printTakenPieces();
		game.resign();
		game.printGameState();
		game.printWinner();
	}
	
}
