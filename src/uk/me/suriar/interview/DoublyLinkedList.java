package uk.me.suriar.interview;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T>
{
    private final BiNode<T> nodes;

    public DoublyLinkedList()
    {
	nodes = new BiNode<T>(null);
    }

    public boolean isEmpty()
    {
	return nodes.prev() == nodes;
    }

    public BiNode<T> addFirst(final T value)
    {
	BiNode<T> result = new BiNode<T>(value);

	result.insertAfter(nodes);

	return result;
    }

    public BiNode<T> addLast(final T value)
    {
	BiNode<T> result = new BiNode<T>(value);

	result.insertBefore(nodes);

	return result;
    }

    public BiNode<T> getFirst()
    {
	if (isEmpty())
	    throw new NoSuchElementException("DoublyLinkedList::getFirst");
	return nodes.next();
    }

    public BiNode<T> getLast()
    {
	if (isEmpty())
	    throw new NoSuchElementException("DoublyLinkedList::getLast");
	return nodes.prev();
    }
}
