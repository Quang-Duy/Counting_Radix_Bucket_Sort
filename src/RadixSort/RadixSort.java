package RadixSort;

/**
 * Models a radix sort
 * @author Quang-Duy Tran
 *
 */

public class RadixSort {
	/**
	 * Sort the given array by sorting the digits from LSD to MSD
	 * @param arr the given array
	 * @param digit the number of digits
	 */
	public void radix_sort(String[] arr, int digit)
	{
		CountingSort sort = new CountingSort();
		for(int i = 1; i <= digit; i++)
		{
			String[] arrB = new String[arr.length];
			sort.counting_sort(arr, arrB, i);
			
			//Copy the sorted-by-digit array B to arr so that we can use that result and sort the next n-th digit
			for(int j = 0; j < arrB.length; j++)
			{
				arr[j] = arrB[j];
			}
		}
	}
}
