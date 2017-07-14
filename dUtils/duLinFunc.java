package dUtils;

public class duLinFunc {

	public long beg, end, len;
	public float bv, ev;
	float k;

	public duLinFunc(long beg, float bv, long end, float ev) {
		this.beg = beg;
		this.bv = bv;
		this.end = end;
		this.ev = ev;
		this.len = end - beg;
		this.k = (ev - bv) / len;
	}

	public void again(long time) {
		this.beg = time;
		this.end = time + len;
	}

	public boolean done(long time) {
		return (end <= time);
	}

	public float get(long time) {
		return bv + ((ev - bv) * (time - beg)) / len;
	}
}
