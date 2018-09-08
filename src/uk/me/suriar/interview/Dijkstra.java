package uk.me.suriar.interview;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Dijkstra
{
    private final Queue<Node> nextNodes = new ArrayDeque<>();
    private final Map<Node, Edge> route = new HashMap<>();

    public String findShortestPath(final Node start, final Node end)
    {

	route.put(start, new Edge(start, 0));

	addPaths(start, end);

	while (!nextNodes.isEmpty())
	{
	    final Node node = nextNodes.remove();
	    addPaths(node, end);
	}

	final Edge lastPath = route.get(end);
	return (lastPath == null) ? "" : buildPath(new StringBuilder(end.getId()), lastPath).reverse().toString();
    }

    private StringBuilder buildPath(final StringBuilder path, final Edge lastPath)
    {
	if (lastPath.getWeight() == 0)
	    return path;

	path.append(lastPath.getNode().getId());

	return buildPath(path, route.get(lastPath.getNode()));
    }

    private void addPaths(final Node node, final Node end)
    {
	if (node == end)
	    return;

	assert (route.containsKey(node));
	final int pathWeight = route.get(node).getWeight();

	final Edge lastPath = route.get(end);

	node.getEdges().stream().forEach(e -> {
	    final int newWeight = e.getWeight() + pathWeight;

	    final Node currNode = e.getNode();
	    final Edge bestPath = route.get(currNode);

	    if (bestPath == null || bestPath.getWeight() > newWeight)
	    {
		System.out.println(String.format("Best weight so far for %s = %s", currNode.getId(), newWeight));
		/* if (lastPath == null || newWeight < lastPath.getWeight()) */ {
		    System.out.println(
			    String.format("Node %s may have better route to %s", currNode.getId(), end.getId()));
		    route.put(currNode, new Edge(node, newWeight));
		    if (bestPath == null)
			nextNodes.add(currNode);
		}
	    }
	});
    }

}
