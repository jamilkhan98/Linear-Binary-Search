//Jamil Khan
//CECS 328 - Lab 1
//2/22/19
//Professor Pouye

package lab1;

import java.util.*;

public class Linear_Binary_Search {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		
		//getArrayLength method called to prompt user to
		//enter a positive integer which will be called 'n'
		//in order to generate an array 'a' of random integers
		//between -1000 and 1000 of size 'n'
		int n = getArrayLength();
		int[] a = new int[n];
		System.out.println("Part A of Programming Assignment: ");

		for(int i = 0; i < n; i++) {
			a[i] = (int)((Math.random() * 2001) - 1000);
		}
		
		System.out.println("Random array of integers of size " + n + " has been created.\n");
		Arrays.sort(a);
		System.out.println("Array has now been sorted.");
		
		long startTime = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			int key = a[(int)(Math.random() * a.length)];
			linearSearch(a, key);		
		}
		long runTime = System.nanoTime() - startTime;

		System.out.println("Time to search for key in array a using linear search 100 times is " + runTime + " nanoseconds.");
		
		long realTime = (long)(runTime/100);
		System.out.println("Average run time for one loop is " + realTime + " nanoseconds.");

//binary search
		System.out.println("\nBinary Search will now be used:");

		startTime = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			int key = a[(int)(Math.random() * a.length)];
			binarySearch(a, key);			
		}
		runTime = System.nanoTime() - startTime;

		System.out.println("Time to search for key in array a using binary search 100 times is " + runTime + " nanoseconds.");
		realTime = (long)(runTime/100);
		System.out.println("Average run time for one loop is " + realTime + " nanoseconds.");		

		System.out.println("\nPart B of Programming Assignment: ");
		a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = (int)((Math.random() * 2001) - 1000);
		}
		
		System.out.println("Random array of integers of size " + n + " has been created.\n");
		Arrays.sort(a);
		
		int key = 5000;
		startTime = System.nanoTime();
		linearSearch(a, key);
		runTime= System.nanoTime() - startTime;
		System.out.println("Run time using linear search to find key is: " + runTime + " nanoseconds.");
		long linearTime = runTime;
		
		startTime = System.nanoTime();
		binarySearch(a, key);
		runTime= System.nanoTime() - startTime;
		System.out.println("Run time using binary search to find key is: " + runTime + " nanoseconds.");
		
		float oneStep = (float) (runTime/Math.log(n));
		System.out.println("Time to do one step using binary search is " + oneStep + " nanoseconds.");
				
		float linearStep = (float) (Math.pow(10, 7) * oneStep);
		System.out.println("Worst case running time for linear search of size 10^7: " + linearStep + " nanoseconds.");
		
		float lastStep = (float) (Math.log(Math.pow(10, 7)) * oneStep);
		System.out.println("Worst case running time for binary search of size 10^7: " + lastStep + " nanoseconds.");
		
	}

	public static int getArrayLength() {
		Scanner intin = new Scanner(System.in);
		while (!intin.hasNextInt()) {
			System.out.println("Enter a positive integer here: ");
			intin.next();
		}
		int n = intin.nextInt();
		if (n < 0) {
			System.out.println("Your integer is negative, so we will use the positive integer.");
			n = n * (-1);
		}
		return n;
	}


	public static boolean linearSearch(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				return true;
			}
		}
		return false;
	}

	public static boolean binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		int middle;
		while(start <= end) {
			middle = (start + end) / 2;
			if (key == a[middle]) {
				return true;
			} else if (key < a[middle]) {
				end = middle - 1;
			} else if (key > a[middle]) {
				start = middle + 1;
			}
		}
		return false;
	}
}
