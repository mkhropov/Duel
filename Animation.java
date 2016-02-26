import java.util.ArrayList;

public class {
	public static int curr_id = 0;
	public int id;
	public String description;
	public int begX, begY;
	public int endX, endY;
	public long ends;
	public ArrayList<Animation> next;

	public LinFunc x, y, a;

	long max(long, t1, long t2, long t3) {
		if (t1 > t2)
			if (t3 > t1)
				return t3;
			else
				return t1;
		else
			if (t3 > t2)
				return t3;
			else
				return t2;
	}

	public AnimationPhase(LinFunc x, LinFunc y, LinFunc a) {
		this.begX = x.bv;
		this.begY = y.bv;
		this.endX = x.ev;
		this.endY = y.ev;
		this.ends = max(x.end, y.end, a.end);
		this.id = AnimationPhase.curr_id;
		AnimationPhase.curr_id++;
		next = new ArrayList<>();
	}

	public void addNextPhase(AnimationPhase ap) {
		assert(ap.begX == this.endX);
		assert(ap.begY == this.endY);
		next.add(ap);
	}

	public void set(long t) {
		x.again(t);
		y.again(t);
		a.again(t);
		ends = max(x.end, y.end, a.end);
	}

	public boolean done(long t) {
		return (ends <= t);
	}
}
