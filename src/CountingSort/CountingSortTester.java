package CountingSort;

/**
 * Test the counting sort
 * @author Quang-Duy Tran
 *
 */

public class CountingSortTester {
	
	/**
	 * Initialize the array with given values and call counting sort method
	 * @param args
	 */
	public static void main(String[] args)
	{
		CountingSort sort = new CountingSort();
		int[][] arr = new int[][] {
			{7, 7, 2, 8, 4, 2, 3, 5, 4, 8, 3, 6, 4, 6, 2}, //numbers that need to be sorted
			{1, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 3, 2, 3}  //relative index/position of the number
		};
		int[][] result = new int[arr.length][arr[0].length];
		
		print2DArray(arr, "Original array");
		sort.counting_sort(arr, result, getLargestNum(arr));
	}
	
	/**
	 * Get the largest number in the given array
	 * @param arr the given array
	 * @return the largest number
	 */
	private static int getLargestNum(int[][] arr)
	{
		int largest = 0;
		for(int i = 0; i < arr[0].length; i++)
		{
			if(arr[0][i] > largest)
				largest = arr[0][i];
		}
		return largest;
	}
	
	/**
	 * Print 2D array
	 * I don't use Arrays.deepToString() because it prints 2 columns in one line, hard to compare with first column
	 * @param arr the given 2D array
	 * @param nameOfArray the name of the 2D array
	 */
	private static void print2DArray(int[][] arr, String nameOfArray)
	{
		System.out.printf("%n%-19s", nameOfArray + ": ");
		System.out.print("[" + arr[0][0]);
		for(int i = 1; i < arr[0].length; i++)
		{
			System.out.print(", " + arr[0][i]);
		}
		System.out.println("]");
		
		System.out.print("Relative position: [" + arr[1][0]);
		for(int j = 1; j < arr[1].length; j++)
		{
			System.out.print(", " + arr[1][j]);
		}
		System.out.println("]\n");
	}
}
