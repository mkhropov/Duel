package dGraph;

import java.util.ArrayList;
import dMath.dmLinFunc;

public class dgAnimation {
	public int begX, begY;
	public int endX, endY;
	public long ends;

	public dmLinFunc x, y, a;

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

	public dgAnimation(dmLinFunc x, dmLinFunc y, dmLinFunc a) {
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
	}

	public dgAnimation(dgState s1, dgState s2, long t) {
		this.x = new LinFunc(s1.x, s2.x, 0, t);
		this.y = new LinFunc(s1.y, s2.y, 0, t);
		this.a = new LinFunc(s1.a, s2.a, 0, t);
		this.begX = (int) x.bv;
		this.begY = (int) y.bv;
		this.begA = (int) a.bv;
		this.endX = (int) x.ev;
		this.endY = (int) y.ev;
		this.endA = (int) a.ev;
		this.ends = max(x.end, y.end, a.end);
	}

	public void again(long time) {
		x.again(time);
		y.again(time);
		a.again(time);
		ends = max(x.end, y.end, a.end);
	}

	public boolean done(long time) {
		return (ends <= time);
	}

	public boolean hasBeg(dgState s) {
		return s.isBeg(this);
	}

	public boolean hasEnd(dgState s) {
		return s.isEnd(this);
	}

	public boolean canChain(dgAnimation a) {
		return hasEnd(new dgState(a));
	}
}
