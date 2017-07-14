package dGraph;

import java.util.ArrayList;

private class dgNode {
	static int curr_id = 0;
	int id;
	dgAnimation an;
	ArrayList<int> next;

	public Node(dgAnimation an) {
		this.an = an;
		this.id = curr_id++;
		this.next = new ArrayList<>();
	}
}

