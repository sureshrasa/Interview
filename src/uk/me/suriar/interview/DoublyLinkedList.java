package uk.me.suriar.interview;

import java.util.NoSuchElementException;

public class DoublyLinkedList <T>{
	private final Node nodes;
	
	public class Node {
		Node prev;
		Node next;

		private T value;

		public Node(final T value) {
			this.value = value;
			prev = next = this;
		}

		public T getValue() {
			return value;
		}

		public void setValue(final T value) {
			this.value = value;
		}

		public void remove() {
			prev.next = next;
			next.prev = prev;
			
			next = prev = this;
		}
		
		public void insertAfter(final Node node)
		{
			remove();
			
			next = node.next;
			prev = node;
			
			next.prev = this;
			node.next = this;
		}
		
		public void insertBefore(final Node node)
		{
			remove();
			
			prev = node.prev;
			next = node;
			
			prev.next = this;
			node.prev = this;
		}
	}

	public DoublyLinkedList()
	{
		nodes = new Node(null);
	}

	public boolean isEmpty() {
		return nodes.prev == nodes;
	}

	public Node addFirst(final T value)
	{
		Node result = new Node(value);
		
		result.insertAfter(nodes);
		
		return result;
	}

	public Node addLast(final T value)
	{
		Node result = new Node(value);
		
		result.insertBefore(nodes);
		
		return result;
	}

	public Node getFirst()
	{
		if (isEmpty()) throw new NoSuchElementException("DoublyLinkedList::getFirst");
		return nodes.next;
	}

	public Node getLast()
	{
		if (isEmpty()) throw new NoSuchElementException("DoublyLinkedList::getLast");
		return nodes.prev;
	}
}
