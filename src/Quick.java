import java.util.*;
import java.io.*;

public class Quick {

	public static void main(String[] args) {
		
		int[] data = readFiles("input2.txt");
		System.out.println(Arrays.toString(data));
		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}

	
	}
	
	public static int[] readFiles(String file) {
		
		try {
			
			File f = new File(file);
			Scanner scan = new Scanner(f);
			int counter = 0;
			while(scan.hasNextInt()) {
				counter++;
				scan.nextInt();
			}
			
			int[] arr = new int[counter];
			
			Scanner scan1 = new Scanner(f);
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = scan1.nextInt();
			}
			
			return arr;
			
			
		}catch(Exception e) {
			
			return null;
			
		}
		
	}
}
