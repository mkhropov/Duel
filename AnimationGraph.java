package main;

public AnimationGraph {
	private Node {
		static int curr_id = 0;
		int id;
		Animation an;
		ArrayMap<int>> next;
		public Node(Animation an) {
			this.an = an;
			id = curr_id++;
			next = new ArrayMap<int>();
		}
	}

	private ArrayMap<Node> nodes;

	public AnimationGraph() {
		nodes = new ArrayMap<Node>();
	}

	private Node getNode(int id) {
		if (id > Node.curr_id)
			return null;
		for (Node n : nodes)
			if (n.id == id)
				return n;
		sys.out.println("Incorrect animation id");
		return null;
	}

	public int addAnimation(Animation an) {
		Node n = new Node(an);
		nodes.add(n);
		return n.id;
	}

	public Animation getAnimation(int id) {
		return getNode(id).an;
	}

	public boolean setFollowup(int id, int key, int followupId) {
		Node n = getNode(id);
		assert (n != null);
		Node fn = getNode(followupId);
		assert (fn != null);
		assert(n.an.matches(fn.an));
		assert(n.next[key] == null);
		n.next[key] = followupId;
	}

	public int getFollowup(int id, int key) {
		Node n = getNode(id);
		assert (n != null);
		return n.next[key];
	}
}

