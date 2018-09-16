package uk.me.suriar.interview;

public class QuickSort
{
    public void sort(final int[] elems)
    {
	sortRegion(elems, 0, elems.length-1);
    }

    private void sortRegion(final int[] elems, final int first, final int last)
    {
	if (first >= last) return;
	
	final int pivotPos = partition(elems, first, last);
	sortRegion(elems, first, pivotPos);
	sortRegion(elems, pivotPos+1, last);
    }

    private int partition(final int[] elems, final int first, final int last)
    {
	final int pivot = elems[first];
	
	int low = first - 1;
	int high = last + 1;
	
	for(;;)
	{
	    do ++low; while (elems[low] < pivot);
	    do --high; while (elems[high] > pivot);
	    
	    if (low >= high) return low ;
	    
	    swap(elems, low, high);
	}
    }
    
    private void swap(int[] elems, int from, int to)
    {
	final int temp = elems[from];
	elems[from] = elems[to];
	elems[to] = temp;
    }
}
