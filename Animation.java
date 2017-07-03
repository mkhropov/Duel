import java.util.ArrayList;

public class Animation {
	String description;
	public int begX, begY;
	public int endX, endY;
	public long ends;

	public LinFunc x, y, a;

	private long max(long t1, long t2, long t3) {
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

	public Animation(LinFunc x, LinFunc y, LinFunc a) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.begX = (int) x.bv;
		this.begY = (int) y.bv;
		this.begA = (int) a.bv;
		this.endX = (int) x.ev;
		this.endY = (int) y.ev;
		this.endA = (int) a.ev;
		this.ends = max(x.end, y.end, a.end);
		this.description = "Unnamed animation";
	}

	public void setDescription(String s) {
		this.description = s;
	}

	public String getDescription() {
		return this.description;
	}

	public void set(long time) {
		x.again(time);
		y.again(time);
		a.again(time);
		ends = max(x.end, y.end, a.end);
	}

	public boolean done(long time) {
		return (ends <= time);
	}

	public boolean matches(Animation next) {
		return (
			(this.endX == next.begX) &&
			(this.endY == next.endY) &&
			(this.endA == next.begA)
		);
	}
}
