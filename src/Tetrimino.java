
public enum Tetrimino {

	I(4, new boolean[][][]{{{true, true, true, true}, 
							{false, false, false, false}, 
							{false, false, false, false},  
							{false, false, false, false}},
							{{false, true, false, false}, 
							 {false, true, false, false}, 
							 {false, true, false, false},  
							 {false, true, false, false}},
							{{true, true, true, true}, 
							{false, false, false, false}, 
							{false, false, false, false},  
							{false, false, false, false}},
							{{false, true, false, false}, 
							 {false, true, false, false}, 
							 {false, true, false, false},  
							 {false, true, false, false}}}),
	O(2, new boolean[][][]{{{true, true},
							{true, true}},
							{{true, true},
							{true, true}},
							{{true, true},
							{true, true}},
							{{true, true},
							{true, true}}}),
	T(3, new boolean[][][]{{{true, true, true}, 
							{false, true, false}, 
							{false, false, false}},
							{{false, false, true}, 
							 {false, true, true}, 
							 {false, false, true}},
							{{false, true, false}, 
							 {true, true, true}, 
							 {false, false, false}},
							{{true, false, false}, 
							 {true, true, false}, 
							 {true, false, false}}}),
	L(3, new boolean[][][]{{{true, true, true}, 
							{true, false, false}, 
							{false, false, false}},
							{{false, true, true}, 
							 {false, false, true}, 
							 {false, false, true}},
							{{false, false, true}, 
							 {true, true, true}, 
							 {false, false, false}},
							{{true, false, false}, 
							 {true, false, false}, 
							 {true, true, false}}}),
	J(3, new boolean[][][]{{{true, true, true}, 
							{false, false, true}, 
							{false, false, false}},
							{{false, false, true}, 
							 {false, false, true}, 
							 {false, true, true}},
							{{true, false, false}, 
							 {true, true, true}, 
							 {false, false, false}},
							{{true, true, false}, 
							 {true, false, false}, 
							 {true, false, false}}}),
	Z(3, new boolean[][][]{{{true, true, false}, 
							{false, true, true}, 
							{false, false, false}},
							{{false, false, true}, 
							 {false, true, true}, 
							 {false, true, false}},
							{{true, true, false}, 
							{false, true, true}, 
							{false, false, false}},
							{{false, false, true}, 
							 {false, true, true}, 
							 {false, true, false}}}),
	S(3, new boolean[][][]{{{false, true, true}, 
							{true, true, false}, 
							{false, false, false}},
							{{false, true, false}, 
							 {false, true, true}, 
							 {false, false, true}},
							{{false, true, true}, 
							{true, true, false}, 
							{false, false, false}},
							{{false, true, false}, 
							 {false, true, true}, 
							 {false, false, true}}});
	
	private final boolean[][][] forme;
	private final int taille;
	private int current_orientation;
	
	Tetrimino(int p_taille, boolean[][][] p_forme){
		forme = p_forme;
		taille = p_taille;
		current_orientation = 0;
	}
	
	public int getTaille(){
		return taille;
	}
	
	public int getCurrentForme(){
		return current_orientation;
	}
	
	public boolean[][] getTetrimino(){
		return forme[current_orientation];
	}
	
	public boolean isBrique(int x, int y){
		return this.getTetrimino()[x][y];
	}
	
	public void turn(){
		if(current_orientation == 3){
			current_orientation = 0;
		}else{
			current_orientation++;
		}
	}
}
