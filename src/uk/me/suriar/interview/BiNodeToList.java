package uk.me.suriar.interview;

public class BiNodeToList<T>
{
    public BiNode<T> convert(final BiNode<T> tree)
    {
	if (tree == null)
	    return null;
	
	final BiNode<T> prev = tree.prev();
	final BiNode<T> next = tree.next();
	
	if (next == tree)
	{
	    if (prev == tree)
	    {
		return tree;
	    }
	    else
	    {
		final BiNode<T> left = convert(prev);
		tree.clear();
		tree.insertBefore(left);
		return left;
	    }
	}
	else if (prev == tree)
	{
	    final BiNode<T> right = convert(next);
	    tree.clear();
	    tree.insertBefore(right);
	    return tree;
	}
	else
	{
	    final BiNode<T> left = convert(prev);
	    final BiNode<T> right = convert(next);
	    tree.clear();
	    tree.insertBefore(right);
	    tree.spliceAfter(left.prev());

	    return left;
	}
    }
}
