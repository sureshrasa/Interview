package uk.me.suriar.interview;

import java.util.ArrayList;
import java.util.List;

public class Node
{

    private final String id;

    private final List<Edge> edges = new ArrayList<Edge>();

    public Node(final String id)
    {
	this.id = id;
    }

    public boolean equals(final Object other)
    {
	if (other == this)
	    return true;

	if (other == null)
	    return false;

	if (!(other instanceof Node))
	    return false;

	return ((Node) other).id.equals(this.id);
    }

    public int hashcode()
    {
	return id.hashCode();
    }

    public void addEdge(final Edge edge)
    {
	edges.add(edge);
    }

    public String getId()
    {
	return id;
    }

    public List<Edge> getEdges()
    {
	return edges;
    }
}
