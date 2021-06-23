package arrayQuestions;

public class ContainsArray {
	
	/*
	 		Given two arrays of ints sorted in increasing order, outer and inner, 
	 		return true if all of the numbers in inner appear in outer. 
	 		The best solution makes only a single "linear" pass of both arrays, 
	 		taking advantage of the fact that both arrays are already in sorted order.
	 		
			linearIn([1, 2, 4, 6], [2, 4])  true
			linearIn([1, 2, 4, 6], [2, 3, 4])  false
			linearIn([1, 2, 4, 4, 6], [2, 4])  true
	 */

	public static void main(String[] args) {
		
		int[] a = {1,2,2,3,4,6};
		int[] b = {1,3,4,6};
		System.out.println(doesContain(a,b));
		
	}
	public static boolean doesContain(int[] a , int[] b) {
		
		boolean isStart = false;
		int count = 0, t = 0;
		for ( int i = 0 ; i < a.length ; i++) {
			if ( a[i] == b[0]) {
				t = i;
				isStart = true;
			}
			if(isStart) {
				for ( int k = 0 ; k < b.length ; k++) {
					if ( b[k] == a[k+t]) count++;
					else {
						isStart = false;
						count = 0;
						break;
					}
				}
				if ( count == b.length) return true;
			}
		}
		return false;
	}
}
//int ind = 0, count = 0, t = 0;
//ind = i;
//			t = j-i;	
