package recursion;

public class Fibanocci {
	
	
	public static void main(String[] args) {
		
		System.out.println(fib(6));
		
	}
	public static long fib(int n) { // 1,1,2,3
		
		long[] arr = new long[n+1];
		
		arr[1] = 1;
		arr[2] = 1;
		
		for ( int i = 3 ; i <= n ; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}
	public static long fibRec(int n) {
		
		if ( n == 1 || n == 2) return 1;
		
		return fibRec(n-1) + fibRec(n-2);
	}
}
