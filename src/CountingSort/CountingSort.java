package CountingSort;

/**
 * Models a counting sort 
 * @author Quang-Duy Tran
 *
 */

import java.util.Arrays;

public class CountingSort {
	
	/**
	 * Sort the given array using counting sort method
	 * @param arrA the given array
	 * @param arrB the output array
	 * @param k the largest number in the given array
	 */
	public void counting_sort(int[][] arrA, int[][] arrB, int k) 
	{
		//Initialize the array C to all zeros
		int[] arrC = new int[k+1];
		for(int i = 0; i <= k; i++)
		{
			arrC[i] = 0;
		}
		
		//Count each number to see how many times they show up in array A
		for(int j = 0; j < arrA[0].length; j++)
		{
			arrC[arrA[0][j]] = arrC[arrA[0][j]] + 1;
		}
		System.out.println("Array C after counting numbers: " + Arrays.toString(arrC));
		
		//Set the position of the numbers
		for(int i = 1; i <= k; i++)
		{
			arrC[i] = arrC[i-1] + arrC[i];
		}
		System.out.println("\nArray C as position for numbers: " + Arrays.toString(arrC));
		
		//Put the number into array B and decrement the position of the corresponding number
		for(int j = arrA[0].length - 1; j >= 0; j--)
		{
			arrB[0][arrC[arrA[0][j]] - 1] = arrA[0][j]; //Put the number into first row of array B
			arrB[1][arrC[arrA[0][j]] - 1] = arrA[1][j]; //Put the relative index/position of the numbers into second row of array B
			arrC[arrA[0][j]] = arrC[arrA[0][j]] - 1;
			
			print2DArray(arrB);
			System.out.println("\nArray C after " + "inserting a number into array B: " + Arrays.toString(arrC));
		}
		
		
	}
	
	/**
	 * Print 2D array
	 * I don't use Arrays.deepToString() because it prints 2 columns in one line, hard to compare with first column
	 * @param arr
	 */
	public void print2DArray(int[][] arr)
	{
		System.out.printf("%n%-19s", "Array B: ");
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
		System.out.println("]");
	}
}
