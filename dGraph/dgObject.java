import org.lwjgl.opengl.GL11;
import java.lang.Math;

public class dgObject implements Drawable, Updatable {
	int x, y;
	LinFunc lx, ly;
	float a;
	LinFunc la;
	float ca, sa;
	int flip;

	int[][2] model;


	public dgObject(int flip = 1, int glType = GL11.GL_TRIANGLE_STRIP) {
		this.flip = flip;
		this.draw = false;
		this.glType = type;
	}

	public void setAnimation(Animation an) {
		this.draw = true;
		this.lx = an.x;
		this.ly = an.y;
		this.la = an.a;
	}

	public void resetAnimation() {
		this.draw = false;
	}

	public void update(long t, long dt) {
		this.lx.update(t);
		this.ly.update(t);
		this.la.update(t);

		this.x = Math.round(lx.get(t));
		this.y = Math.round(ly.get(t));
		this.a = la.get(t);
		this.ca = (float)Math.cos(d*alpha);
		this.sa = (float)Math.sin(d*alpha);
	}

	public void draw() {
		if (this.draw) {
			GL11.glBegin(glType);
			for (int i = 0; i < model.length; i++)
				GL11.glVertex2d(x + model[i][0]*c - model[i][1]*s,
								y + model[i][1]*c + model[i][0]*s);
			GL11.glEnd();
		}
	}

	/* unconditional */
	public void draw_() {
		GL11.glBegin(glType);
		for (int i = 0; i < model.length; i++)
			GL11.glVertex2d(x + model[i][0]*c - model[i][1]*s,
							y + model[i][1]*c + model[i][0]*s);
		GL11.glEnd();
	}
}
