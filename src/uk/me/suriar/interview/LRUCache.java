package uk.me.suriar.interview;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class LRUCache<K, V>
{
    private Map<K, DoublyLinkedList<Pair<K, V>>.Node> map = new HashMap<>();
    private DoublyLinkedList<Pair<K, V>> values = new DoublyLinkedList<>();

    private final int capacity;

    public LRUCache()
    {
	this(16);
    }

    public LRUCache(final int capacity)
    {
	this.capacity = capacity;
    }

    public boolean isEmpty()
    {
	return values.isEmpty();
    }

    public void put(final K key, final V value)
    {
	final DoublyLinkedList<Pair<K, V>>.Node prevNode = map.get(key);
	if (prevNode != null)
	{
	    prevNode.setValue(new Pair<>(key, value));
	}
	else
	{
	    map.put(key, values.addFirst(new Pair<>(key, value)));
	    if (map.size() > capacity)
	    {
		final DoublyLinkedList<Pair<K, V>>.Node last = values.getLast();
		map.remove(last.getValue().getKey());
		last.remove();
	    }
	}
    }

    public V get(final K key)
    {
	final DoublyLinkedList<Pair<K, V>>.Node node = map.get(key);

	if (node == null)
	    return null;

	node.insertBefore(values.getFirst());
	return node.getValue().getValue();
    }
}
