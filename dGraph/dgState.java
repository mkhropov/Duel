package dGraph;

import dUtils.duLinFunc;

public class dgState {
	public float x, y, a;
	public int ix, iy;
	public static final float AERR = 1e-6f;

	public dgState(float x, float y, float a)
	{
		this.x = x;
		this.y = y;
		this.a = a;
		this.ix = (int) x;
		this.iy = (int) y;
	}

	public dgState(duLinFunc x, duLinFunc y, duLinFunc a,
		boolean beg)
	{
		if (beg) {
			this.x = x.bv;
			this.y = y.bv;
			this.a = a.bv;
		} else {
			this.x = x.ev;
			this.y = y.ev;
			this.a = a.ev;
		}
		this.ix = (int) this.x;
		this.iy = (int) this.y;
	}

	public dgState(duLinFunc x, duLinFunc y, duLinFunc a)
	{
		this(x, y, a, true);
	}

	public dgState(dgAnimation an, boolean beg)
	{
		if (beg) {
			this.x = an.x.bv;
			this.y = an.y.bv;
			this.a = an.a.bv;
		} else {
			this.x = an.x.ev;
			this.y = an.y.ev;
			this.a = an.a.ev;
		}
		this.ix = (int) x;
		this.iy = (int) y;
	}

	public dgState(dgAnimation an)
	{
		this(an, true);
	}

	public boolean equals(dgState s)
	{
		return (
			(this.ix == s.ix) &&
			(this.iy == s.iy) &&
			(Math.abs(this.a - s.a) < AERR)
		);
	}

	public boolean isBeg(dgAnimation a)
	{
		return (
			(this.ix == Math.floor(a.x.bv)) &&
			(this.iy == Math.floor(a.y.bv)) &&
			(Math.abs(this.a - a.a.bv) < AERR)
		);
	}

	public boolean isEnd(dgAnimation a)
	{
		return (
			(this.ix == Math.floor(a.x.ev)) &&
			(this.iy == Math.floor(a.y.ev)) &&
			(Math.abs(this.a - a.a.ev) < AERR)
		);
	}

}
