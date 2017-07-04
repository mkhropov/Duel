package dGraph;


public class Sword extends dgObject {
	/* deprecated, will be moved to AnimationGraph instance */
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

	@Override
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
}
