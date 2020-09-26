package RadixSort;

/**
 * Test the radix sort
 * @author Quang-Duy Tran
 *
 */

import java.util.Arrays;
import java.util.Random;

public class RadixSortTester {
	public static Integer ARRAY_SIZE = 30;
	
	/**
	 * Generate 30 5-digit hex numbers and call radix sort
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		Random rnd = new Random();
		String[] arr = new String[ARRAY_SIZE];
		RadixSort sort = new RadixSort();
		
		//Randomly generate a 5-digit hex numbers and put it in array
		for(int i = 0; i < ARRAY_SIZE; i++) {
			String str = "";
			for(int j = 0; j < 5; j++)
			{
				str += Integer.toHexString(rnd.nextInt(16)).toUpperCase();
			}
			arr[i] = str;
		}
		
		System.out.println("Initial array: " + Arrays.toString(arr) + "\n");
		sort.radix_sort(arr, String.valueOf(arr[0]).length());
	}
}
