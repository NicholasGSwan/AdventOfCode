
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Checksum {
	
	static int getRowDifference(int[] array) {
		int difference = 0;
		int biggest = 0;
		int smallest = 9999;
		for(int i = 0; i<array.length-1; i++) {
			for(int j = 1; j<array.length; j++) {
				
				if(array[i]>array[j]) {
					if(array[i]>biggest) {
						biggest = array[i];
					}
					if(array[j]<smallest) {
						smallest = array[j];
					}	
				}
				if(array[i]<array[j]) {
					if(array[j]>biggest) {
						biggest = array[j];
					}
					if(array[i]<smallest) {
						smallest = array[i];
					}	
				}
				
			}
			
		}
		difference = biggest -smallest;
		return difference;
	}
	static int[] returnArray(Scanner in) {
		System.out.println("Enter your array");
		String stringToArray = in.nextLine();
		String[] stringArray = stringToArray.split("\t");
		int[] intArray = new int[stringArray.length];
		for(int i = 0; i<stringArray.length; i++) {
			if(!stringArray[i].equals("")) {
			intArray[i] = Integer.valueOf(stringArray[i]);
			}
		}
		return intArray;
	}
	
	static int getQuotientIfEvenlyDivisible(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] % arr[j] == 0) {
				result = arr[i] / arr[j];	
				}
				if(arr[j] % arr[i] == 0) {
					result = arr[j] / arr[i];
				}
			}
		}
		
		return result;
	}
	
	
	static int returnChecksum(Scanner in) {
		int checksum = 0;
		List<Integer> differences = new ArrayList<>();
		List<Integer> quotients = new ArrayList<>();
		String answer = "";
		do {
			int[] array = returnArray(in);
			int quotient = getQuotientIfEvenlyDivisible(array);
			quotients.add(quotient);
			int difference = getRowDifference(array);
			differences.add(difference);
			System.out.println("is there another row?");
			answer = in.nextLine();
		}while(answer.equalsIgnoreCase("y"));
		for(int num: quotients) {
			checksum+= num;
		}
		
		return checksum;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] testArray = {1919,2959,82,507,3219,239,3494,1440,3107,259,3544,683,207,562,276,2963};
		
		System.out.println(getRowDifference(testArray));
//		int[] testArray2 = returnArray(in);
//		System.out.println(getRowDifference(testArray2));
		int checksum = returnChecksum(in);
		System.out.println(checksum);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
