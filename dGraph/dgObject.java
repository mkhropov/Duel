package dGraph;

import org.lwjgl.opengl.GL11;
import java.lang.Math;

public abstract class dgObject implements dgDrawable, dgUpdatable {
	private int x, y;
	private float a;
	private dgAnimation an;
	float ca, sa;
	boolean draw;
	int flip;
	int glType;

	int[][] model;


	public dgObject(int flip, int glType)
	{
		this.flip = flip;
//		this.draw = false;
		this.draw = true;
		this.glType = glType;
	}

	public dgObject(int flip)
	{
		this(flip, GL11.GL_TRIANGLE_STRIP);
	}

	public dgObject()
	{
		this(1);
	}

	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
		System.out.println("dgObject.setXY("+x+","+y+")");
	}

	public void addXY(int dx, int dy)
	{
		this.x += dx;
		this.y += dy;
	}

	public void setA(float a)
	{
		this.a = a;
		this.ca = (float)Math.cos(flip * a);
		this.sa = (float)Math.sin(flip * a);

	}

	public void addA(float da)
	{
		this.a += da;
		this.ca = (float)Math.cos(flip * a);
		this.sa = (float)Math.sin(flip * a);
	}

	public void setAnimation(dgAnimation an)
	{
		this.draw = true;
		this.an = an;
	}

	public void resetAnimation()
	{
		this.draw = false;
	}

	public void update(long t, long dt)
	{
		if (this.an == null || this.an.done(t))
			return;

		this.x = Math.round(an.x.get(t));
		this.y = Math.round(an.y.get(t));
		this.a = an.a.get(t);
		this.ca = (float)Math.cos(flip * a);
		this.sa = (float)Math.sin(flip * a);
	}

	/* unconditional */
	public void draw_()
	{
//		System.out.println("dgObject.draw_()");
		GL11.glBegin(glType);
		for (int i = 0; i < model.length; i++)
			GL11.glVertex2d(x + model[i][0]*ca - model[i][1]*sa,
							y + model[i][1]*ca + model[i][0]*sa);
		GL11.glEnd();
	}

	public void draw()
	{
		if (this.draw)
			draw_();
	}

}
