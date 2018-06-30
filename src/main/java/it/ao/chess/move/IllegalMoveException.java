package it.ao.chess.move;

public class IllegalMoveException extends RuntimeException {

	private static final long serialVersionUID = 8708725267342126507L;
	
	public IllegalMoveException() {
		super();
	}
	
	public IllegalMoveException(String message) {
		super(message);
	}

}
