package uk.me.suriar.interview;

public class Edge {

	private final Node node;
	private final int weight;

	public Edge(final Node node, final int weight) {
		this.node = node;
		this.weight = weight;
	}

	public Node getNode() {
		return node;
	}
	
	public int getWeight() {
		return weight;
	}
}
