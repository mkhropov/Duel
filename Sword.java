import org.lwjgl.opengl.GL11;
import java.lang.Math;

public class Sword implements Updatable, Drawable {
	int x0, y0, x, y;
	LinFunc lx, ly;
	int d;
	public static final int DIR_LR = 1;
	public static final int DIR_RL = -1;
	public int pos;
	public static final int POS0 = 0; /* at ready */
	public static final int POS1 = 1; /* swing attack start */
	public static final int POS2 = 2; /* pierce attack start */
	public static final int POS3 = 3; /* high attack end */
	public static final int POS4 = 4; /* middle attack end */
	public static final int POS5 = 5; /* low attack end */
	public static final int POS6 = 6; /* pierce attack withdraw */
	public static final int POS7 = 7; /* swing attack withdraw */
	public static final int POS8 = 8; /* high attack block */
	public static final int POS9 = 9; /* middle attack block */
	public static final int POS10 = 10; /* low attack block */
	float alpha;
	LinFunc la;
	float c, s;
	public static final float ALPHA_0 = (float)(Math.PI / 4.);
	static int[] model = {	 0,   0,
							 8,   35,
							-8,   35,
							 7,  200,
							-7,  200,
							 16, 200,
							-16, 200,
							 16, 205,
							-16, 205,
							 5,  205,
							-5,  205,
							 5,  250,
							-5,  250, };


	public Sword(int x, int y, int dir) {
		this.x0 = x;
		this.y0 = y;
		this.x = x;
		this.y = y;
		this.d = dir;
		this.pos = POS0;
		this.alpha = -Math.PI/3;
		this.lx = new LinFunc(0, 0.f, 1, 0.f);
		this.ly = new LinFunc(0, 0.f, 1, 0.f);
		this.la = new LinFunc(0, 0.f, 1, 0.f);
	}

	public void setAnimation(Animation an) {
		this.lx = an.x;
		this.ly = an.y;
		this.la = an.a;
	}

	public void update(long t, long dt) {
		if (!lx.done(t))
			x = x0 + Math.round(lx.get(t));
		if (!ly.done(t))
			y = y0 + Math.round(ly.get(t));
		if (!la.done(t)) {
			alpha = la.get(t);
			c = (float)Math.cos(d*alpha);
			s = (float)Math.sin(d*alpha);
		}
	}

	public void draw() {
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
		for (int i = 0; i < model.length; i+=2)
			GL11.glVertex2d(x+model[i]*c-model[i+1]*s,
							y+model[i+1]*c+model[i]*s);
		GL11.glEnd();
	}
}
