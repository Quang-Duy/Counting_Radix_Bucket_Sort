package BucketSort;

/**
 * Models a bucket sort
 * @author Quang-Duy Tran
 *
 */

import java.util.Arrays;
import java.util.LinkedList;

public class BucketSort {
	
	public static Integer BUCKET_SIZE = 10;
	
	/**
	 * Sort the given array using bucket sort method
	 * @param arr the given array
	 */
	public void bucket_sort(double[][] arr)
	{
		int n = BUCKET_SIZE;
		LinkedList<Double[]>[] bucket = new LinkedList[n];
		
		double decimal = getDecimal(arr);
		
		//make elements an empty list
		for(int i = 0; i < n; i++)
		{
			bucket[i] = new LinkedList<Double[]>();
		}
		
		//Divide the interval of all the element to [0,1) and put them in the bucket
		divideInterval(arr, decimal);
		
		for(int i = 0; i < arr[0].length; i++)
		{
			Double[] tempArr = new Double[2];
			tempArr[0] = arr[0][i]; //Put the number from the arr into first element of a temporary array
			tempArr[1] = arr[1][i]; //Put the relative position/index of that number into second element of a temporary array
			
			bucket[(int) (arr[0][i] * 10)].add(tempArr); //Insert the number with its relative position into the bucket
		}
		
		//Print the bucket to check
		printBucket(bucket, "Original");
		
		//Use insertion sort to sort each element in bucket (to sort the linked list)
		for(int i = 0; i < n; i++) {
			insertionSort(bucket[i]);
		}
		
		//Print the sorted bucket
		printBucket(bucket, "Sorted");
		
		//Concatenate the bucket together in order
		int index = 0; //Index to loop through arr
		for(int i = 0; i < bucket.length; i++)
		{
			for(int j = 0; j < bucket[i].size(); j++)
			{
				//Get the element 0 in the list in the bucket and put it in the first row of arr
				arr[0][index] = bucket[i].get(j)[0]; 
				
				//Get the relative position of that element in the list in the bucket and put it to the second row of arr
				arr[1][index] = bucket[i].get(j)[1]; 
				
				index++;
			}
		}
		
		//Convert the interval back to its original
		for(int i = 0; i < arr[0].length; i++)
		{
			arr[0][i] = Math.round(arr[0][i] * decimal);
		}
	}
	
	/**
	 * Print the bucket for checking purposes
	 * @param bucket the bucket
	 * @param name the name of the bucket
	 */
	private void printBucket(LinkedList<Double[]>[] bucket, String name) 
	{
		System.out.println(name + " Bucket:");
		for(int i = 0; i < bucket.length; i++)
		{
			if(bucket[i].isEmpty()) {
				System.out.print("[Empty]");
			}
			else {
				System.out.print(Arrays.toString(bucket[i].get(0)));
				for(int j = 1; j < bucket[i].size(); j++)
				{
					System.out.print("->" + Arrays.toString(bucket[i].get(j)));
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Get the number with largest length and return 10^length
	 * @param arr the given array
	 * @return the decimal 10^length
	 */
	private double getDecimal(double[][] arr) 
	{
		double largestNum = 0;
		
		//Find the largest number
		for(int i = 0; i < arr[0].length; i++)
		{
			if(arr[0][i] > largestNum)
				largestNum = arr[0][i];
		}
		
		int length = 0;
		
		//Find the power of 10 (the length of integer)
		while(largestNum > 1)
		{
			length += 1;
			largestNum /= 10;
		}
		
		return Math.pow(10, length);
	}

	/**
	 * Divide the interval of all element in arr to [0,1)
	 * @param arr the given array
	 * @param decimal the 10^length
	 */
	private void divideInterval(double[][] arr, double decimal)
	{
		for(int i = 0; i < arr[0].length; i++)
		{
			arr[0][i] = arr[0][i] / decimal;
		}
	}
	
	/**
	 * Sort the linked list using insertion sort
	 * @param list the given linked list
	 */
	private void insertionSort(LinkedList<Double[]> list)
	{
		for(int j = 1; j <= list.size() - 1; j++) 
		{
			//Key acts like an temp
			Double[] key = list.get(j);
			int i = j - 1;
			
			while(i >= 0 && list.get(i)[0] > key[0])
			{
				list.set(i+1, list.get(i));
				i = i - 1;
			}
			
			list.set(i+1, key);
		}
	}
}
