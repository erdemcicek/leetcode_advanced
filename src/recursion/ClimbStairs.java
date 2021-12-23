package recursion;

public class ClimbStairs {
	
	public static void main(String[] args) {
		climbStairs(3);
		climbStairs2(3);
	}
	
	// with recursion
	private static int climbStairs(int n) {
		
		if ( n == 1) return 1;
		if ( n == 2) return 2;
		
		return climbStairs(n-1) + climbStairs(n-2);
	}
	
	// without recursion // more efficient
	private static int climbStairs2(int n) {
		
		if(n==1) return 1;
		if(n==2) return 2;
		int[] steps = new int[n+1];
		steps[1] = 1;
		steps[2] = 2;
		for(int i = 3 ; i <= n ; i++ ) {
			steps[i] = steps[i-1] + steps[i-2];
		}
		return steps[n];
	}
}
