package it.ao.chess;

public enum Color {
		
	WHITE {
		@Override
		public String toString() {
			return "W";
		}
	}, BLACK {
		@Override
		public String toString() {
			return "B";
		}
	};
	
}
