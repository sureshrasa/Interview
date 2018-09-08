package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.Dijkstra;
import uk.me.suriar.interview.Edge;
//import uk.me.suriar.interview.Graph;
import uk.me.suriar.interview.Node;


public class TestDijkstra {
	@Test
	public void testDijkstra()
	{
		//final Graph g = new Graph();
		
		final Node a = new Node("A");
		final Node b = new Node("B");
		final Node c = new Node("C");
		final Node d = new Node("D");
		final Node e = new Node("E");
		final Node f = new Node("F");
		final Node g = new Node("G");
		
		//g.addNode(a,b,c,d,e,f);
		
		a.addEdge(new Edge(b,7));
		a.addEdge(new Edge(c,9));
		a.addEdge(new Edge(d,14));
		
		b.addEdge(new Edge(a,7));
		b.addEdge(new Edge(c,10));
		b.addEdge(new Edge(e,15));

		c.addEdge(new Edge(a, 9));
		c.addEdge(new Edge(b, 10));
		c.addEdge(new Edge(d, 2));
		c.addEdge(new Edge(e, 11));
		
		d.addEdge(new Edge(f, 9));
		
		e.addEdge(new Edge(f, 6));
		
		f.addEdge(new Edge(e, 6));
		f.addEdge(new Edge(g, 3));
		
		//assertEquals("ACDF", new Dijkstra().findShortestPath(a, f));
		//assertEquals("CDF", new Dijkstra().findShortestPath(c, f));
		//assertEquals("A", new Dijkstra().findShortestPath(a, a));
		assertEquals("", new Dijkstra().findShortestPath(g, e));
	}
}
