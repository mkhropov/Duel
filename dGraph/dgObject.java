package dGraph;

import org.lwjgl.opengl.GL11;
import java.lang.Math;

public abstract class dgObject implements dgDrawable, dgUpdatable {
	private int x, y;
	private float a;
	private dgAnimation an;
	float ca, sa;
	int flip;

	int[][2] model;


	public dgObject(int flip = 1, int glType = GL11.GL_TRIANGLE_STRIP) {
		this.flip = flip;
		this.draw = false;
		this.glType = type;
	}

	public void setAnimation(dgAnimation an) {
		this.draw = true;
		this.an = an;
	}

	public void resetAnimation() {
		this.draw = false;
	}

	public void update(long t, long dt) {
		if (this.an.done(t))
			return;

		this.an.set(t);

		this.x = Math.round(an.x.get(t));
		this.y = Math.round(an.y.get(t));
		this.a = an.a.get(t);
		this.ca = (float)Math.cos(d*alpha);
		this.sa = (float)Math.sin(d*alpha);
	}

	/* unconditional */
	public void draw_() {
		GL11.glBegin(glType);
		for (int i = 0; i < model.length; i++)
			GL11.glVertex2d(x + model[i][0]*c - model[i][1]*s,
							y + model[i][1]*c + model[i][0]*s);
		GL11.glEnd();
	}

	public void draw() {
		if (this.draw) {
			draw_();
		}
	}

}
