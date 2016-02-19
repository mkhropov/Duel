import java.util.Math;

public class Fencing {
	Sword s1, s2;

	public Fencing() {
		s1 = new Sword(350, 275, 1, -Math.Pi/3);
		s2 = new Sword(450, 275, -1, Math.Pi/3);
	}
}
