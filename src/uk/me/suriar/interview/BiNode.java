package uk.me.suriar.interview;

public class BiNode<T>
{
    private BiNode<T> prev;
    private BiNode<T> next;

    private T value;

    public static <T> BiNode<T> of(final T value)
    {
	return new BiNode<T>(value);
    }
    
    public BiNode(final T value)
    {
        this.value = value;
        clear();
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(final T value)
    {
        this.value = value;
    }

    public void remove()
    {
        prev.next = next;
        next.prev = prev;

        clear();
    }

    public void clear()
    {
	next = prev = this;
    }

    public void insertAfter(final BiNode<T> node)
    {
        remove();

        next = node.next;
        prev = node;

        next.prev = this;
        node.next = this;
    }
    
    public void insertBefore(final BiNode<T> node)
    {
        remove();

        prev = node.prev;
        next = node;

        prev.next = this;
        node.prev = this;
    }

    public void spliceAfter(final BiNode<T> other)
    {
	final BiNode<T> prevOfThis = this.prev;
	final BiNode<T> nextOfOther = other.next;
	
	this.prev = other;
	other.next = this;
	
	prevOfThis.next = nextOfOther;
	nextOfOther.prev = prevOfThis;
    }

    public BiNode<T> next()
    {
	return next;
    }

    public BiNode<T> prev()
    {
	return prev;
    }

    public BiNode<T> setLeft(final BiNode<T> child)
    {
	prev = child;
	return this;
    }
    
    public BiNode<T> setRight(final BiNode<T> child)
    {
	next = child;
	return this;
    }
}