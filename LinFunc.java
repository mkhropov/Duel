public class LinFunc {

	long beg, end;
	float bv, ev;
	float k;

	public LinFunc(long beg, float bv, long end, float ev) {
		this.beg = beg;
		this.bv = bv;
		this.end = end;
		this.ev = ev;
		this.k = (ev - bv) / (end - beg);
	}

	public boolean done(long t) {
		return (t > end);
	}

	public float get(long t) {
		return bv + ((ev - bv)*(t - beg))/(end - beg);
	}
}
