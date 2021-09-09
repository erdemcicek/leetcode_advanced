package other2;

import java.util.stream.DoubleStream;

/*
	 Maximum possible value by inserting '5'
	examples:
	input: 1234 -> output: 51234
	input: 7643 -> output 76543
	input: 0 -> output 50
	input: -661 -> output -5661
	
 */

public class InsertFiveFindMax {
	
	public static void main(String[] args) {
		
		System.out.println(insertFiveFindMax(-5)); // ilkKisim * pow 10 
		// 7 pow 4
		// 76 pow 3
		// 764 pow 2
		// 7643 pow 1
	}
	
	private static int insertFiveFindMax(int n) {

		if ( n == 0 ) return 50;
		
		int n_in = n, len = 0, comp = Integer.MIN_VALUE;
		
		while( n_in != 0 ) {
			n_in /= 10;
			len++;
		} 
		
		while( len != -1 ) {
			
			int fiveCaseR = (int) (5 * Math.pow(10, len)); // 50000, 5000, 500, 50, 5
			int fiveCase  = n > 0 ? fiveCaseR : - fiveCaseR;
			int firstPart = n / (int)Math.pow(10, len); // 0     7
			int lastPart  = n % (int)Math.pow(10, len); // 7643  643
			int res = fiveCase + firstPart * (int)Math.pow(10, len+1) + lastPart;  // 57643
			
			if(res > comp) comp = res;
			
			len--;
		}

		return comp;
	}

}
