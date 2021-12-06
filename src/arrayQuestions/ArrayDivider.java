package arrayQuestions;

import java.util.Arrays;

public class ArrayDivider {
	
	private static int divideArrays(int[] A, int[] B) {
		
		int sumA = Arrays.stream(A).sum();
		int sumB = Arrays.stream(B).sum();
		
		if( (sumA != sumB) || (sumA % 2 == 1) || (sumB % 2 == 1) ) return 0;
		
		int pA = 0, pB = 0;
		for(int i = 0 ; i < A.length ; i++) {
			pA += A[i];
			pB += B[i];
			if(pA * 2 == sumA && pB * 2 == sumB) return i+1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] a = {0, -1, 4, 0, 3};
		int[] b = {2, -2, 3, 1, 2};
		System.out.println(divideArrays(a, b));
	}

}
