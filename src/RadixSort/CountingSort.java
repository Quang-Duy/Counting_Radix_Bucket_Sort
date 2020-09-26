package RadixSort;
/**
 * Models a counting sort
 * @author Quang-Duy Tran
 *
 */

/**
 * I have to make a separate counting sort for radix sort because: 
 * 1. I want my counting sort to take array A as a String instead of integer 
 * 2. I want to pass the digit instead of k, because k will always be hex F, which is 15.
 * 3. I want to print differently than counting sort package
 */

import java.util.Arrays;

public class CountingSort {
	
	/**
	 * Sort the given array by using counting sort method
	 * @param arr the given array
	 * @param sorted_by_digit_arr the output array
	 * @param digit the n-th digit
	 */
	public void counting_sort(String[] arr, String[] sorted_by_digit_arr, int digit) 
	{
		int[][] arrA = getOneDigit2DArray(arr, digit);
		int[][] arrB = new int[arrA.length][arrA[0].length];
		int largestNum = getLargestNum(arrA);
		
		//Initialize the array C to all zeros
		int[] arrC = new int[largestNum+1];
		for(int i = 0; i <= largestNum; i++)
		{
			arrC[i] = 0;
		}
		
		print2DArray(arrA, "A"); //Print the array A
		
		//Count each number to see how many times they show up in array A
		for(int j = 0; j < arrA[0].length; j++)
		{
			arrC[arrA[0][j]] = arrC[arrA[0][j]] + 1;
		}
		System.out.println("\nArray C after counting numbers: " + Arrays.toString(arrC));
		
		//Set the position of the numbers
		for(int i = 1; i <= largestNum; i++)
		{
			arrC[i] = arrC[i-1] + arrC[i];
		}
		System.out.println("\nArray C as position for numbers: " + Arrays.toString(arrC));
		
		//Put the number into array B and decrement the position of the corresponding number
		for(int j = arrA[0].length - 1; j >= 0; j--)
		{
			arrB[0][arrC[arrA[0][j]] - 1] = arrA[0][j]; //Put the 1-digit number into first row of sorted array
			arrB[1][arrC[arrA[0][j]] - 1] = arrA[1][j]; //Put the relative index/position of the numbers into second row of sorted array
			
			sorted_by_digit_arr[arrC[arrA[0][j]] - 1] = arr[j]; //Put the relative 5-digit number into array B
			
			arrC[arrA[0][j]] = arrC[arrA[0][j]] - 1;
			
		}
		
		//Print the array B. I don't print the intermediate result because 
		//you didn't ask me to and it should be the same as Counting Sort package
		print2DArray(arrB, "B"); 
		
		System.out.println("\nArray C after " + "inserting a number into array B: " + Arrays.toString(arrC));
		System.out.println("\nArray after sorted by " + digit + " digit: " + Arrays.toString(sorted_by_digit_arr));
		
		System.out.println();//Skip one line so we know it's done with sorting n-th digit. Exit out and move on to the next n-th digit
	}
	
	/**
	 * Print 2D array
	 * I don't use Arrays.deepToString() because it prints 2 columns in one line, hard to compare with first column
	 * @param arr the given 2D array
	 * @param nameOfArray the name of the 2D array
	 */
	public void print2DArray(int[][] arr, String nameOfArray)
	{
		System.out.printf("%n%-19s", "Array " + nameOfArray + ": ");
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
	
	/**
	 * Get the largest one-digit number
	 * @param arr the array contains only 1-digit numbers
	 * @return the largest one-digit number
	 */
	private int getLargestNum(int[][] arr)
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
	 * Get the n-th digit in the original array and put in a new array
	 * by converting an integer into an array of characters
	 * @param arr the original array
	 * @return the array contains 1-digit numbers
	 */
	private int[][] getOneDigit2DArray(String[] arr, int nth_digit)
	{
		int[][] newArr = new int[2][arr.length];
		
		//Initialize the second column to 1; Because second column will be the relative index/position of
		//the same numbers, and we start counting at 1 instead of 0
		for(int i = 0; i < newArr[1].length; i++)
		{
			newArr[1][i]++;
		}
		
		//Get the n-th digit in the original array and put in a new array
		for(int i = 0; i < arr.length; i++)
		{
			char[] ch = arr[i].toCharArray(); //Converting a string into an array of char
			
			//Get the n-th digit, put it into a string so we can convert the hex value to an integer
			String str = ch[ch.length - nth_digit] + ""; 
			
			//Convert a hex number into an integer and put it into a new array
			newArr[0][i] = Integer.parseInt(str, 16); 
			
			//Input the correct index/relation of the numbers
			getNumberRelation(newArr, newArr[0][i], i);
		}
		return newArr;
	}

	/**
	 * Generate the index/relation of the target and put in the second row of the array
	 * @param arr the given array
	 * @param target the given target
	 * @param index the index of the target in the array
	 */
	private void getNumberRelation(int[][] arr, int target, int index) 
	{
		for(int i = 0; i < index; i++)
		{
			if(arr[0][i] == target)
				arr[1][index] = arr[1][i] + 1;
		}
	}
}
