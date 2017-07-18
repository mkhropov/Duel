package dGraph;


public class dgSword extends dgObject {

	private void _dgSword() {
		model = new int[][]
			{{  0,    0},
			 {  8,   35},
			 { -8,   35},
			 {  7,  200},
			 { -7,  200},
			 { 16,  200},
			 {-16,  200},
			 { 16,  205},
			 {-16,  205},
			 {  5,  205},
			 { -5,  205},
			 {  5,  250},
			 { -5,  250},};
	}

	public dgSword(int flip, int glType) {
		super(flip, glType);
		_dgSword();
	}

	public dgSword(int flip) {
		super(flip);
		_dgSword();
	}

	public dgSword() {
		super();
		_dgSword();
	}
}
