package uk.me.suriar.interview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ContiniousMedian
{
    final Queue<Double> minHeap = new PriorityQueue<>();
    final Queue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    
    public Double getMedian()
    {
	if (!minHeap.isEmpty())
	{
	    if (!maxHeap.isEmpty())
	    {
		if (minHeap.size() > maxHeap.size()) return minHeap.peek();
		if (minHeap.size() == maxHeap.size()) return (minHeap.peek()+maxHeap.peek())/2;
		return maxHeap.peek();
	    }
	    else
	    {
		return minHeap.peek();
	    }
	}
	else if (!maxHeap.isEmpty())
	{
	    return maxHeap.peek();
	}
	
	return null;
    }

    public void add(final Double value)
    {
	final Double currMedian = getMedian();
	
	if (currMedian == null)
	{
	    maxHeap.add(value);
	}
	else if (value < currMedian)
	{
	    maxHeap.add(value);
	    if (maxHeap.size() > minHeap.size()+1)
	    {
		minHeap.add(maxHeap.remove());
	    }
	}
	else
	{
	    minHeap.add(value);
	    if (minHeap.size() > maxHeap.size()+1)
	    {
		maxHeap.add(minHeap.remove());
	    }
	}
    }
}
