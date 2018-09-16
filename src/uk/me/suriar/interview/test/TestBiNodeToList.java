package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import uk.me.suriar.interview.BiNode;
import uk.me.suriar.interview.BiNodeToList;

public class TestBiNodeToList
{
    @Test
    public void testNull()
    {
	assertNull(new BiNodeToList<>().convert(null));
    }
    
    @Test
    public void testSingleNode()
    {
	final BiNode<String> tree = BiNode.of("A");
	assertEquals(tree, new BiNodeToList<String>().convert(tree));
    }
    
    @Test
    public void testLeftChildNode()
    {
	final BiNode<String> tree = BiNode.of("A");
	tree.setLeft(BiNode.of("B"));
	assertEquals("BA", getPath(new BiNodeToList<String>().convert(tree)));
    }
    
    @Test
    public void testRightChildNode()
    {
	final BiNode<String> tree = BiNode.of("A");
	tree.setRight(BiNode.of("B"));
	assertEquals("AB", getPath(new BiNodeToList<String>().convert(tree)));
    }

    @Test
    public void testManyNodes()
    {
	final BiNode<String> left = BiNode.of("B").setLeft(
		BiNode.of("C").setLeft(BiNode.of("E"))
		).setRight(BiNode.of("D"));
	
	final BiNode<String> right = BiNode.of("E").setLeft(BiNode.of("G")).setRight(BiNode.of("F"));
	
	assertEquals("ECBDAGEF", getPath(new BiNodeToList<String>().convert(BiNode.of("A").setLeft(left).setRight(right))));
    }

    private String getPath(final BiNode<String> list)
    {
	if (list == null) return "";
	
	final StringBuilder result = new StringBuilder(list.getValue());
	
	BiNode<String> curr = list.next();
	while(curr != list)
	{
	    result.append(curr.getValue());
	    curr = curr.next();
	}
	
	return result.toString();
    }
}
