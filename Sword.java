import org.lwjgl.opengl.GL11;
import java.lang.Math;

public class Sword implements Updatable, Drawable {
	int x, y;
	LinFunc lx, ly;
	int d;
	public static final int DIR_LR = 1;
	public static final int DIR_RL = -1;
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


	public Sword(int x, int y, int dir, float alpha, long t) {
		this.x = x;
		this.y = y;
		this.d = dir;
		this.alpha = alpha;
		this.lx = new LinFunc(t, (float)x, t+1000, (float)x);
		this.ly = new LinFunc(t, (float)y, t+1000, (float)y);
		this.la = new LinFunc(t, alpha, t+10000, (float)(alpha + Math.PI));
	}

	public void update(long t, long dt) {
		x = Math.round(lx.get(t));
		y = Math.round(ly.get(t));
		alpha = la.get(t);
		System.out.print(alpha + "  ");
		c = (float)Math.cos(d*alpha);
		s = (float)Math.sin(d*alpha);
	}

	public void draw() {
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
		for (int i = 0; i < model.length; i+=2)
			GL11.glVertex2d(x+model[i]*c-model[i+1]*s,
							y+model[i+1]*c+model[i]*s);
		GL11.glEnd();
	}
}
