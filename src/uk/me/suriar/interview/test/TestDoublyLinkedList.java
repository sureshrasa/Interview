package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import uk.me.suriar.interview.DoublyLinkedList;

public class TestDoublyLinkedList
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEmpty()
    {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
	assertTrue(list.isEmpty());
	thrown.expect(NoSuchElementException.class);
	thrown.expectMessage("DoublyLinkedList::getFirst");
	list.getFirst();
    }

    @Test
    public void testOneFirst()
    {
	final DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

	final DoublyLinkedList<Integer>.Node node = list.addFirst(Integer.valueOf(3));

	assertNotNull(node);
	assertEquals(Integer.valueOf(3), node.getValue());
	assertFalse(list.isEmpty());
	assertEquals(node, list.getFirst());
	assertEquals(node, list.getLast());

	node.remove();
	assertTrue(list.isEmpty());
	assertEquals(Integer.valueOf(3), node.getValue());
    }

    @Test
    public void testOneLast()
    {
	final DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

	final DoublyLinkedList<Integer>.Node node = list.addLast(Integer.valueOf(3));

	assertNotNull(node);
	assertEquals(Integer.valueOf(3), node.getValue());
	assertFalse(list.isEmpty());
	assertEquals(node, list.getFirst());
	assertEquals(node, list.getLast());

	node.remove();
	assertTrue(list.isEmpty());
	assertEquals(Integer.valueOf(3), node.getValue());
    }

    @Test
    public void testAddManyFirst()
    {
	final DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

	final DoublyLinkedList<Integer>.Node node1 = list.addFirst(Integer.valueOf(3));
	final DoublyLinkedList<Integer>.Node node2 = list.addFirst(Integer.valueOf(4));

	assertNotNull(node1);
	assertNotNull(node2);
	assertEquals(Integer.valueOf(3), node1.getValue());
	assertEquals(Integer.valueOf(4), node2.getValue());
	assertFalse(list.isEmpty());
	assertEquals(node2, list.getFirst());
	assertEquals(node1, list.getLast());

	node1.remove();
	assertEquals(Integer.valueOf(3), node1.getValue());
	assertFalse(list.isEmpty());
	assertEquals(node2, list.getFirst());
	assertEquals(node2, list.getLast());

	node1.insertAfter(node2);
	assertFalse(list.isEmpty());
	assertEquals(node2, list.getFirst());
	assertEquals(node1, list.getLast());

	node1.insertBefore(node2);
	assertFalse(list.isEmpty());
	assertEquals(node1, list.getFirst());
	assertEquals(node2, list.getLast());
    }

    @Test
    public void testAddManyLast()
    {
	final DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

	final DoublyLinkedList<Integer>.Node node1 = list.addLast(Integer.valueOf(3));
	final DoublyLinkedList<Integer>.Node node2 = list.addLast(Integer.valueOf(4));

	assertNotNull(node1);
	assertNotNull(node2);
	assertEquals(Integer.valueOf(3), node1.getValue());
	assertEquals(Integer.valueOf(4), node2.getValue());
	assertFalse(list.isEmpty());
	assertEquals(node1, list.getFirst());
	assertEquals(node2, list.getLast());

	node1.remove();
	assertEquals(Integer.valueOf(3), node1.getValue());
	assertFalse(list.isEmpty());
	assertEquals(node2, list.getFirst());
	assertEquals(node2, list.getLast());
    }
}
