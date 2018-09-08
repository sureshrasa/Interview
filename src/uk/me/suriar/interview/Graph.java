package uk.me.suriar.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Graph
{
    private final HashMap<String, Node> nodes = new HashMap<>();

    public void addNode(Node... nodes)
    {
	Arrays.stream(nodes).collect(Collectors.toMap(Node::getId, Function.identity(), (a, b) -> a, () -> this.nodes));
    }
}
