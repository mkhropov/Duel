public interface Updatable {
	/*	time: current time at the call moment
		dt: time since last call */
	public void update(long time, long dt);
}
