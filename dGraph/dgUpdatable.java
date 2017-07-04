package dGraph;
/* FIXME probably shouldn't be in this package,
 * but atm this interface isn'n needed anywhere else,
 * and I don't want to mess with cross-dependencies
 */

public interface dgUpdatable {
	/*	time: current time at the call moment
		dt: time since last call */
	public void update(long time, long dt);
}
