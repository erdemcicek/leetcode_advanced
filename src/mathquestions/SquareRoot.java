package mathquestions;

public class SquareRoot {
	
	public static void main(String[] args) {
		
		System.out.println(mySqrt(1));
	}
	private static int mySqrt(int n) {
		
		long low = 0, high = n;
		while(low <= high) {
			long mid = low + (high - low) / 2;
			if(mid * mid == n) return (int) mid;
			else if (mid * mid < n) low = mid + 1;
			else high = mid - 1;
		}
		return (int) high;
	}
}
