package uk.me.suriar.interview;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class LRUCache<K, V>
{
    private Map<K, BiNode<Pair<K, V>>> map = new HashMap<>();
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
	final BiNode<Pair<K, V>> prevNode = map.get(key);
	if (prevNode != null)
	{
	    prevNode.setValue(new Pair<>(key, value));
	}
	else
	{
	    map.put(key, values.addFirst(new Pair<>(key, value)));
	    if (map.size() > capacity)
	    {
		final BiNode<Pair<K, V>> last = values.getLast();
		map.remove(last.getValue().getKey());
		last.remove();
	    }
	}
    }

    public V get(final K key)
    {
	final BiNode<Pair<K, V>> node = map.get(key);

	if (node == null)
	    return null;

	node.insertBefore(values.getFirst());
	return node.getValue().getValue();
    }
}
