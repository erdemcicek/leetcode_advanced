package codewars;

public class PersistBugger {
	
	public static void main(String[] args) {
		System.out.println(persistence(25));
	}
	private static int persistence(long n) { // 39
		int pers = 0;
		while(n>9) {
			n = findCurrentProd(n);
			pers++;
		}
		return pers;
	}
	private static int findCurrentProd(long n) {
		if(n==0) return 1;
		int prod = 1;
		while(n!=0) {
			int currentDigit = (int)n%10;
			n /= 10;
			prod *= currentDigit;
		}
		return prod;
	}

}
