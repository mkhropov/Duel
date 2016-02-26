public class LinFunc {

	public long beg, end;
	public float bv, ev;
	float k;

	public LinFunc(long beg, float bv, long end, float ev) {
		this.beg = beg;
		this.bv = bv;
		this.end = end;
		this.ev = ev;
		this.k = (ev - bv) / (end - beg);
	}

	public void again(long t) {
		this.end = t + (end - beg);
		this.beg = t;
	}

	public boolean done(long t) {
		return (t > end);
	}

	public float get(long t) {
		return bv + ((ev - bv)*(t - beg))/(end - beg);
	}
}
