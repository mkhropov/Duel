package dGraph;

import java.util.ArrayList;

public class dgAnimationGraph {
	private ArrayList<dgNode> nodes;

	public dgAnimationGraph() {
		nodes = new ArrayList<>();
	}

	private dgNode getNode(int id) {
		if (id > dgNode.curr_id)
			return null;
		for (dgNode n : nodes)
			if (n.id == id)
				return n;
		System.out.println("Incorrect animation id");
		return null;
	}

	public int addAnimation(dgAnimation an) {
		dgNode n = new dgNode(an);
		nodes.add(n);
		return n.id;
	}

	public dgAnimation getAnimation(int id) {
		return getNode(id).an;
	}

	public boolean setFollowup(int id, int key, int followupId) {
		dgNode n = getNode(id);
		assert (n != null);
		dgNode fn = getNode(followupId);
		assert (fn != null);
//		assert(n.next.get(key) == null);
		if (n.an.canChain(fn.an)) {
			n.next.set(key, followupId);
			return true;
		} else {
			return false;
		}
	}

	public int getFollowup(int id, int key) {
		dgNode n = getNode(id);
		assert (n != null);
		return n.next.get(key);
	}
}

