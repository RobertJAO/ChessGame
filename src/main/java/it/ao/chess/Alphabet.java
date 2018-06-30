package it.ao.chess;

public enum Alphabet {
	
	A, B, C, D, E, F, G, H, I, L, M, N, O, P, Q, R, S, T, U, V, Z;
	
	public char toChar() {
		return this.name().toLowerCase().charAt(0);
	}
	
}
