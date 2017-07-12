package dEngine;

import dGraph.*;

public class deSword extends dgSword {
	public int pos;
	public int ids[10];
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

	public AnimationGraph ag;

	public deSword() {
		super();
		this.ag = new AnimationGraph();
		Animation an;
		an = new Animation(); an.setDescription("Pierce bk");
		id[0] = ag.addAnimation(an);
		an = new Animation(); an.setDescription("Pierce fw");
		id[1] = ag.addAnimation(an);
		ag.setFollowup(id[0], 0, id[1]);
		an = new Animation(); an.setDescription("Pierce rtr");
		id[2] = ag.addAnimation(an);
		ag.setFollowup(id[1], 0, id[2]);
		ag.setFollowup(id[2], 0, id[0]);

		an = new Animation(); an.setDescription("Swing bk");
		id[3] = ag.addAnimation(an);
		ag.setFollowup(id[2], 1, id[3]);
		an = new Animation(); an.setDescription("Swing fw hi");
		id[4] = ag.addAnimation(an);
		ag.setFollowup(id[3], 0, id[4]);
		an = new Animation(); an.setDescription("Swing fw lo");
		id[5] = ag.addAnimation(an);
		ag.setFollowup(id[3], 1, id[5]);
		an = new Animation(); an.setDescription("Swing rtr hi");
		id[6] = ag.addAnimation(an);
		ag.setFollowup(id[4], 0, id[6]);
		an = new Animation(); an.setDescription("Swing rtr lo");
		id[7] = ag.addAnimation(an);
		ag.setFollowup(id[5], 0, id[7]);

	}

	public void draw() {
		super.draw();
	}

	public void update(long t, long dt) {
		super.update(t, dt);
	}
}
