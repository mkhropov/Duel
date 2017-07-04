package dGraph;

public class dgState {
	public float x, y, a;
	public int ix, iy;
	public static final float AERR = 1e-6f;

	public dgState(float x, float y, float a) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.ix = Math.floor((double) x);
		this.iy = Math.floor((double) y);
	}

	public dgState(dmLinFunc x, dmLinFunc y, dmLinFunc a, beg = true) {
		if (beg) {
			this.x = x.bv;
			this.y = y.bv;
			this.a = a.bv;
		} else {
			this.x = x.ev;
			this.y = y.ev;
			this.a = a.ev;
		}
		this.ix = Math.floor((double) x);
		this.iy = Math.floor((double) y);
	}

	public dgState(dgAnimation an, beg = true) {
		if (beg) {
			this.x = an.x.bv;
			this.y = an.y.bv;
			this.a = an.a.bv;
		} else {
			this.x = an.x.ev;
			this.y = an.y.ev;
			this.a = an.a.ev;
		}
		this.ix = Math.floor((double) x);
		this.iy = Math.floor((double) y);
	}

	public boolean equals(dgState s) {
		return (
			(this.ix == s.ix) &&
			(this.iy == s.iy) &&
			(Math.abs(this.a - s.a) < AERR)
		);
	}

	public isBeg(dgAnimation a) {
		return (
			(this.ix == Math.floor(a.x.bv)) &&
			(this.iy == Math.floor(a.y.bv)) &&
			(Math.abs(this.a - a.a.bv) < AERR)
		);
	}

	public isEnd(dgAnimation a) {
		return (
			(this.ix == Math.floor(a.x.ev)) &&
			(this.iy == Math.floor(a.y.ev)) &&
			(Math.abs(this.a - a.a.ev) < AERR)
		);
	}

}
