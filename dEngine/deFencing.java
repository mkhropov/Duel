import java.util.Math;

public class Fencing {
	Sword s1, s2;
	ArrayList<String, Animation> moves;

	public Fencing() {
		s1 = new Sword(350, 275, 1, -Math.Pi/3);
		s2 = new Sword(450, 275, -1, Math.Pi/3);
		moves = new Map<>();
		Animation an;
		/* pierce high */
		an = new Animation(	new duLinFunc(0, 0, 0, 500),
							new duLinFunc(0, 0, 0, 10),
							new duLinFunc(0, -Math.Pi/3, 0, -Math.Pi/2));
		moves.add("pierce hi", an);
		/* pierce middle */
		an = new Animation(	new duLinFunc(0, 0, 0, 500),
							new duLinFunc(0, 0, 0, -50),
							new duLinFunc(0, -Math.Pi/3, 0, -Math.Pi/2));
		moves.add("pierce mi", an);
		/* pierce low */
		an = new Animation(	new duLinFunc(0, 0, 0, 500),
							new duLinFunc(0, 0, 0, -300),
							new duLinFunc(0, -Math.Pi/3, 0, -Math.Pi/2));
		moves.add("pierce lo", an);
		/* return high */
		an = new Animation(	new duLinFunc(0, 500, 0, 10),
							new duLinFunc(0, 10, 0, -50),
							new duLinFunc(0, -Math.Pi/2, 0, -Math.Pi/2));
		moves.add("return hi", an);
		/* return middle */
		an = new Animation(	new duLinFunc(0, 500, 0, 10),
							new duLinFunc(0, -50, 0, -50),
							new duLinFunc(0, -Math.Pi/2, 0, -Math.Pi/2));
		moves.add("return mi", an);
		/* return low */
		an = new Animation(	new duLinFunc(0, 500, 0, 10),
							new duLinFunc(0, -300, 0, -50),
							new duLinFunc(0, -Math.Pi/2, 0, -Math.Pi/2));
		moves.add("return lo", an);
		an = new Animation( new duLinFunc(0, 10, 0, 0),
							new duLinFunc(0, -50, 0, 0),
							 new duLinFunc(0, -Math.Pi/2, 0, -Math.Pi/3));
		moves.add("to guard");

		moves["pierce hi"].addNextPhase(moves["return hi"]);
		moves["pierce mi"].addNextPhase(moves["return mi"]);
		moves["pierce lo"].addNextPhase(moves["return lo"]);
		moves["return hi"].addNextPhase(moves["to guard"]);
		moves["return mi"].addNextPhase(moves["to guard"]);
		moves["return lo"].addNextPhase(moves["to guard"]);
		moves["to guard"].addNextPhase(moves["pierce hi"]);
		moves["to guard"].addNextPhase(moves["pierce mi"]);
		moves["to guard"].addNextPhase(moves["pierce lo"]);
	}

	void update() {
		if phase
}
