import org.lwjgl.opengl.GL11;

public class Sword implements Updatable, Drawable {
	int x;
	int y;
//	float alpha;

	public Sword(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update(long t, long dt) {
	}

	public void draw() {
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x+8, y+35);
        GL11.glVertex2d(x-8, y+35);
        GL11.glVertex2d(x+7, y+200);
        GL11.glVertex2d(x-7, y+200);
        GL11.glEnd();
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
		GL11.glVertex2d(x+16, y+200);
		GL11.glVertex2d(x+16, y+205);
		GL11.glVertex2d(x-16, y+200);
		GL11.glVertex2d(x-16, y+205);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
		GL11.glVertex2d(x+5, y+200);
		GL11.glVertex2d(x+5, y+250);
		GL11.glVertex2d(x-5, y+200);
		GL11.glVertex2d(x-5, y+250);
		GL11.glEnd();
	}
}
