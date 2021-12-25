package arrayQuestions;

import java.util.Arrays;
import java.util.List;

public class FindMinimumNotExist {
	
	public static void main(String[] args) {
//		System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));
		System.out.println(solution(new int[] {1, 2, 3}));
		System.out.println(solution(new int[] {}));
		System.out.println(solution(null));

	}
	
	private static int solution(int[] A) {
		
		if(A==null) return 1;
		
		Arrays.sort(A);
		int[] arr = Arrays.stream(A).distinct().filter(t->t>0).toArray();
		
		if(arr.length==0) return 1;
		int p = 1;
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(p == arr[i]) p++;
			else return p;
		}
		
		return arr[arr.length-1] + 1;
	}
}
