package BucketSort;

/**
 * Test the bucket sort 
 * @author Quang-Duy Tran
 *
 */

public class BucketSortTester {
	
	/**
	 * Initialize the array with the given values and call bucket sort method
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		BucketSort sort = new BucketSort();
		double[][] arr = {
				{7, 7, 2, 8, 4, 2, 3, 5, 4, 8, 3, 6, 4, 6, 2}, //numbers that need to be sorted
				{1, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 3, 2, 3}  //relative index/position of the number
		};
		
		print2DArray(arr, "Original array");
		sort.bucket_sort(arr);
		print2DArray(arr, "Sorted array");
		
		double[][] newArr = {
				{71, 7, 21, 82, 41, 22, 31, 52, 45, 82, 31, 62, 41, 62, 21}, //numbers that need to be sorted
				{ 1, 1,  1,  1,  1,  1,  1,  1,  1,  2,  2,  1,  2,  2,  2}  //relative index/position of the number
		};
		
		print2DArray(newArr, "\nOriginal array");
		sort.bucket_sort(newArr);
		print2DArray(newArr, "Sorted array");
		
	}
	
	/**
	 * Print 2D array
	 * I don't use Arrays.deepToString() because it prints 2 columns in one line, hard to compare with first column
	 * @param arr the given 2D array
	 * @param nameOfArray the name of the 2D array
	 */
	private static void print2DArray(double[][] arr, String nameOfArray)
	{
		System.out.printf("%-19s", nameOfArray + ": ");
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
