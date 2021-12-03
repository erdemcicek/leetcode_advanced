package other2;

import java.util.Arrays;

public class PrintArray {
	
	public static void main(String[] args) {
		printArray(new int[] {4, 2, 6, 5});
//		printArray(new int[] {0});
//        patternArray(new int[]{1, 6, 3, 0});
//        patternArray(null);
	}
	
	private static void printArray(int[] arr) {        // 4, 2, 6, 5
		
		if(arr == null || arr.length == 0) {
			System.out.println("Please provide a valid input");
			return;
		}
		boolean containsNegative = Arrays.stream(arr).anyMatch(t->t<0);
		if(containsNegative) {
			System.out.println("Please do not enter negative numbers");
			return;
		}
		
		int max = Arrays.stream(arr).max().getAsInt(); // 6	
		int max_in = max; // because max is modified in for loop, I stored it in a separate variable
		for(int i = 0; i < max_in ; i++) {
			for(int j = 0 ; j < arr.length ; j++) {	    
				if( arr[j] < max) System.out.print("   ");
				else System.out.print("*  ");
			}
			System.out.println();
			max--;
		}
		for(int k = 0 ; k < arr.length ; k++) System.out.print("---");
		System.out.println();
		for(int w : arr) System.out.print(w + "  ");
	}
	
//	public static void patternArray(int[] input) {
//        String[] pattern = new String[input.length];
//        boolean isContainsNegative = Arrays.stream(input).anyMatch(t -> t < 0);
//        if (input.length == 0 || isContainsNegative) {
//            System.out.println("wrong input type");
//            return;
//        }
//        int max = Arrays.stream(input).max().getAsInt();
//        for (int i = max; i > 0; i--) {
//            pattern = Arrays.stream(pattern).map(t -> t = "*").toArray(String[]::new);
//            for (int j = 0; j < input.length; j++) {
//                if (!(input[j] - i >= 0)) {
//                    pattern[j] = " ";
//                }
//                System.out.print(pattern[j] + "  ");
//            }
//            System.out.println("");
//        }
//        Arrays.stream(pattern).map(t-> t="---").forEach(System.out::print);
//        System.out.println("");
//        Arrays.stream(input).forEach(PrintArray::print);
//    }
//    public static void print(int i) {System.out.print(i + "  ");}
    
    
}
