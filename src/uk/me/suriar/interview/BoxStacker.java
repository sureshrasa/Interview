package uk.me.suriar.interview;

import java.util.List;

public class BoxStacker
{
    public int stack(final List<Box> list)
    {
	list.sort((a, b) -> -Integer.compare(a.getHeight(), b.getHeight()));

	return stackFrom(list.toArray(new Box[] {}));
    }

    private int stackFrom(final Box[] boxes)
    {
	final int[] cache = new int[boxes.length];

	int maxHeight = 0;
	for (int i = 0; i < boxes.length; ++i)
	{
	    maxHeight = Math.max(maxHeight, stackFitting(cache, boxes, i));
	}

	return maxHeight;
    }

    private int stackFitting(final int[] cache, final Box[] boxes, final int from)
    {
	if (from >= boxes.length)
	{
	    return 0;
	}

	if (cache[from] > 0)
	    return cache[from];

	final Box topBox = boxes[from];

	for (int i = from + 1; i < boxes.length; ++i)
	{
	    if (isFitting(boxes[i], topBox))
	    {
		cache[from] = Math.max(cache[from], stackFitting(cache, boxes, i));
	    }
	}
	cache[from] += topBox.getHeight();

	return cache[from];
    }

    private boolean isFitting(final Box box, final Box topBox)
    {
	return box.getDepth() < topBox.getDepth() && box.getWidth() < topBox.getWidth();
    }

}
