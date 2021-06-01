package other;

public class ReverseInteger {
	
	public static void main(String[] args) {
		
//		System.out.println(reverse(2,147,483,647));// 3021
		//					       1,000,000,003									
		// 2147483648
//		System.out.println(reverseWithString(Integer.MAX_VALUE));
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverseWithStringTryCatch(2047483699));
		
	}
	public static int reverse(int x) {
		
		int n = 0, n_rev = 0, t = 0, x_in = x;
		
		while(x != 0) {
			
			n = n*10 + x%10; // 0 + 3  ,  30+0  , 300+2 , 3020+1 
			x = x/10;//         120    ,   12   ,    1  ,    0
		}
		
		t = n;// 3021
		
		while(t != 0) {
			
			n_rev = n_rev*10 + t%10; // 0 + 1 , 10 + 2 , 120 + 0 , 1200 + 3 
			t = t/10;				 //  302  ,   30   ,   3     ,   0
		}
		
		while(x_in%10==0 && x_in!=0) {
			
			x_in = x_in/10;
		}
		
		if ( n_rev == x_in) return n;
		
		return 0;
	}
	
	public static int reverseWithString(int x) { // 2147483647  pos
												 // -2147483648 neg
		boolean isNeg = (x<0)?(true):(false);
		if ( x == Integer.MIN_VALUE) return 0;
		if (isNeg) x = -x;
		StringBuilder sb = new StringBuilder("" +x);
		sb.reverse();
		long n = Long.parseLong(sb.toString());
		if ( n >= Integer.MAX_VALUE ) return 0;
		return (isNeg)?(-1 * Integer.parseInt(sb.toString())) : ( Integer.parseInt(sb.toString()));
	}
	
	public static int reverseWithStringTryCatch(int x) {
		
		String s = (x<0)?(  new StringBuilder(String.valueOf(-x)).reverse().toString())
				: ( new StringBuilder(String.valueOf(x)).reverse().toString() );
		try {
			return (x<0)?(-1*Integer.parseInt(s)):(Integer.parseInt(s));
		}catch(Exception e) {
			return 0;
		}
	}

}
