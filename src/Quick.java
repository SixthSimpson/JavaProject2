import java.util.*;
import java.io.*;

public class Quick {

	public static void main(String[] args) {
		
		int[] data = readFiles("input2.txt");		
		quickSort(data, 0, data.length - 1);
		System.out.print("Sorted array: ");
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("\nQuick Sort is: " + data[4]);

	
	}
	
	//function to read files
	public static int[] readFiles(String file) {
		
		//try catch exception if file not read 
		try {
			
			//create file object 
			File f = new File(file);
			Scanner scan = new Scanner(f);
			
			//counter and while loop used to create size of array (lazy way to go around array list)
			int counter = 0;
			while(scan.hasNextInt()) {
				counter++;
				scan.nextInt();
			}
			
			//counter is the size of the array
			int[] arr = new int[counter];
			
			//second scanner to replace the pointer at the top of the txt file 
			Scanner scan1 = new Scanner(f);
			
			//add values to array
			for(int i = 0; i < arr.length; i++) {
				arr[i] = scan1.nextInt();
			}
			
			return arr;
			
			
		}catch(Exception e) {
			
			return null;
			
		}	
	}
	
	//quick sort function
	public static void quickSort(int[] data, int left, int right) {
		
		if(left >= right) {
			return;
		}
		int pivot = data[(left+right) / 2];
		int index = partition(data, left, right, pivot);
		quickSort(data, left, index - 1);
		quickSort(data, index, right);
	}
	
	//this will partition the array 
	public static int partition(int[] data,int left, int right, int pivot) {
		
		while(left <= right) {
			while(data[left] < pivot) {
				left++;
			}
			
			while(data[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				swap(data, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	//this is swapping the values to each side of the pivot
	public static void swap(int[] data, int left, int right) {
		
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
	}
}
