package uk.me.suriar.interview;

import java.util.Arrays;

public class SmallestK
{

    public int find(final int[] nums, final int k)
    {
	return findInRange(nums, 0, nums.length-1, k);
    }

    private int findInRange(final int[] nums, int lowBound, int highBound, final int k)
    {
	int low = lowBound;
	int high = highBound;
	
	System.out.println(String.format("nums=%s, [%s,%s] k=%s", Arrays.toString(nums), low, high, k));
	
	final int pivot = nums[(low+high)/2];
	
	int mid = low;
	while (mid <= high)
	{
	    if (nums[mid] <  pivot)
	    {
		swap(nums, mid, low);
		mid++;
		low++;
	    }
	    else if (nums[mid] > pivot)
	    {
		swap(nums, mid, high);
		--high;
	    }
	    else
	    {
		++mid;
	    }
	}
	
	if (mid <= k) return findInRange(nums, mid, highBound, k);
	if (low > k) return findInRange(nums, lowBound, low-1, k);
	    
	return nums[low];
    }

    private void swap(final int[] nums, final int index1, int index2)
    {
	final int temp = nums[index1];
	nums[index1] = nums[index2];
	nums[index2] = temp;
    }

}
