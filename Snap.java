import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import java.util.Random;
import java.util.Date;
import java.util.ArrayList;

import dGraph.dgUpdatable;
import dGraph.dgDrawable;

import dEngine.deSword;

/* this class describes an interactive animation editor */

public class Snap {

	private int screenW, screenH;

	private boolean mousePressed;
	private int mouseX, mouseY;

	long fps, lastFPS;
	long lastTime, newTime, deltaT;

	public ArrayList<dgUpdatable> toUpdate;
	public ArrayList<dgDrawable> toDraw;

	deSword sw;

	public Snap() {
		screenW = 800;
		screenH = 600;
		mousePressed = false;

		toUpdate = new ArrayList<>();
		toDraw = new ArrayList<>();
		sw = new deSword();
//		sw.la = new LinFunc();
		sw.setAnimation(null);
		sw.setA(0.f);
		toUpdate.add(sw);
		toDraw.add(sw);
	}

	public static void main(String[] args) {
		Snap game = new Snap();
		game.start();
	}

	public long getTime() {
		return System.nanoTime() / 1000000;
	}

	public void updateFPS(long dT) {
		if (lastFPS > 1000) {
			Display.setTitle("Duel (" + fps + "fps)");
			fps = 0; //reset the FPS counter
			lastFPS = 0; //add one second
		}
		lastFPS += dT;
		fps++;
	}

	void input(long t, long dt) {
		int x = Mouse.getEventX();
		int y = Mouse.getEventY();

/* Mouse event poll */
/* for setting approximal angle */
		boolean mouseMoved = (Math.abs(mouseX-x)+Math.abs(mouseY-y) > 10.);
		if (mousePressed && mouseMoved) {
			sw.setA((float)Math.atan2(mouseX-x, mouseY-y));
		}
/* for setting approximal position */
		while (Mouse.next()) {
			if (Mouse.getEventButton() == 0) { /* left button */
				if (Mouse.getEventButtonState()) { /* pressed */
					mousePressed = true;
					mouseX = x;
					mouseY = y;
				} else {
					mousePressed = false;
					if (!mouseMoved) {
						/* move model */
						System.out.println("Click at ("+x+","+y+")");
						sw.setXY(x, screenH-y);
					}
				}
			}
		}

/* Keyboard continuous press poll */
/* for precise movements */
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			sw.addXY(0, -1 - (int)(50 * dt / 1000.));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			sw.addXY(-1 - (int)(50 * dt / 1000.), 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			sw.addXY(0, 1 + (int)(50 * dt / 1000.));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			sw.addXY(1 + (int)(50 * dt / 1000.), 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			sw.addA((float)(0.15 * dt / 1000.));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			sw.addA((float)(-0.15 * dt / 1000.));
		}

/* Keyboard event poll */
/* Unused
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				// Key pressed
				switch(Keyboard.getEventKey()) {
				case Keyboard.KEY_Z:
				case Keyboard.KEY_SPACE:
				case Keyboard.KEY_F4:
				case Keyboard.KEY_F5:
				default:
					break;
				}
			} else {
				// Key released
				switch (Keyboard.getEventKey()) {
				case Keyboard.KEY_SPACE:
				case Keyboard.KEY_H:
				case Keyboard.KEY_F3:
				default:
					break;
		        }
			}
		}
*/
	}

	void update(long t, long dt) {
		for (int i = 0; i < toUpdate.size(); i++)
			toUpdate.get(i).update(t, dt);
	}

	public void draw() {
		GL11.glClearColor(1.f, 1.f, 1.f, 1.f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
//		sw.draw();
		for (int i = 0; i < toDraw.size(); i++)
			toDraw.get(i).draw();
	}

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(screenW, screenH));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Display created. OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));

		lastFPS = getTime();
		lastTime = getTime();

/*		// init OpenGL
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		//Set up lighting
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_LIGHT0);

		float light_ambient[] = { 0.7f, 0.7f, 0.7f, 1.0f };

		ByteBuffer temp = ByteBuffer.allocateDirect(4*4);
		temp.order(ByteOrder.nativeOrder());
		FloatBuffer buffer = temp.asFloatBuffer();
		buffer.put(light_ambient); buffer.flip();
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, buffer);
*/

		GL11.glViewport(0,0,800,600);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glColor3d(0., 0., 0.);

		while (!Display.isCloseRequested()) {
			newTime = getTime();
			deltaT = newTime - lastTime;
			lastTime = newTime;
//			System.out.print(deltaT+"  ");
			//iterate
			input(newTime, deltaT);
			update(newTime, deltaT);
			draw();

			Display.update();
			updateFPS(deltaT);
//			Display.sync(60);
		}

		Display.destroy();
	}
}
