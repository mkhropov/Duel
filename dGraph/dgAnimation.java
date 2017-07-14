package dGraph;

import java.util.ArrayList;
import dUtils.duLinFunc;

public class dgAnimation {
	public int begX, begY;
	public int endX, endY;
	public float begA, endA;
	public long ends;

	public duLinFunc x, y, a;

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

	public dgAnimation(duLinFunc x, duLinFunc y, duLinFunc a) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.begX = Math.round(x.bv);
		this.begY = Math.round(y.bv);
		this.begA = a.bv;
		this.endX = Math.round(x.ev);
		this.endY = Math.round(y.ev);
		this.endA = a.ev;
		this.ends = max(x.end, y.end, a.end);
	}

	public dgAnimation(dgState s1, dgState s2, long t) {
		this.x = new duLinFunc(0, s1.x, t, s2.x);
		this.y = new duLinFunc(0, s1.y, t, s2.y);
		this.a = new duLinFunc(0, s1.a, t, s2.a);
		this.begX = Math.round(x.bv);
		this.begY = Math.round(y.bv);
		this.begA = a.bv;
		this.endX = Math.round(x.ev);
		this.endY = Math.round(y.ev);
		this.endA = a.ev;
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
