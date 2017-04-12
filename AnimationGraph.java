package main;

public AnimationGraph {
	private Node {
		static int curr_id = 0;
		int id;
		Animation an;
		ArrayMap<int> nextId;
		ArrayMap<String> nextKey;
		public GraphNode(Animation an) {
			this.an = an;
			id = curr_id++;
			nextId = new ArrayMap<int>();
			nextKey = new ArrayMap<String>();
		}
	}

	private ArrayMap<Node> nodes;

	public AnimationGraph() {
		nodes = new ArrayMap<Node>();
	}

	public int addAnimation(Animation an) {
		Node n = new Node(an);
		nodes.add(n);
		return n.id;
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


	public Animation getAnimation(int id) {
		return getNode(id).an;
	}

	public boolean setFollowup(int id, int key, int followupId) {
		Node n = getNode(id);
		Node fn = getNode(followupId);
		assert(n.an.matches(fn.an));
		n.nextId.add(followupId);
		n.nextKey.add(key);
		assert(n.nextId.length == n.nextKey.length);
	}
}

