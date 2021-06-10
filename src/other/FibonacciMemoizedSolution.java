package other;

public class FibonacciMemoizedSolution {
	
	public static void main(String[] args) {
		
		System.out.println(fibBottomUp(100)); 
		System.out.println(fibMemo(12));
	}
	private static long fibBottomUp(int n) {
		
		if ( n == 1 || n == 2) return 1;
		long[] bottomUp = new long[n+1];
		bottomUp[1] = 1;
		bottomUp[2] = 1;
		for( int i = 3 ; i <= n ; i++) {
			bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
		}
		return bottomUp[n];
	}
	private static int fibMemo(int n) {
		
		int[] memo = new int[n+1];
		return fib2(n, memo);
	}
	private static int fib2(int n, int[] memo) {
		int result;
		if ( memo[n] != 0) return memo[n];
		if ( n == 1 || n == 2) result = 1;
		else {
			result = fib2(n-1, memo) + fib2(n-2, memo);
			memo[n] = result;
		}
		return result;
	}
}
