package dGraph;

import java.util.ArrayList;

class dgNode {
	static Integer curr_id = new Integer(0);
	Integer id;
	dgAnimation an;
	ArrayList<Integer> next;

	public dgNode(dgAnimation an) {
		this.an = an;
		this.id = curr_id++;
		this.next = new ArrayList<>();
	}
}

