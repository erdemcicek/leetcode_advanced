package other2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteFiveFindMax {
	
	public static void main(String[] args) {
		System.out.println(deleteFive(15958));
		System.out.println(deleteFive(-5859));
		System.out.println(deleteFive(-5000));
//		System.out.println(deleteFive(515)); // 51
		
	}
	
	// 15958 -> 1958
	// -5859 -> -589
	// -5000 -> 0
	
	private static int deleteFive(int n) {
		
		if ( n == 0 ) return 0;
		
		int n_in = n, len = 0, pointer = 0, comp = Integer.MIN_VALUE;
		
		// Finding the number of digits of parameter
		while ( n_in != 0 ) {
			n_in /= 10;
			len++;
		}
		
		while( len != pointer ) { 
			int currentDigit = ( n % (int)Math.pow(10, pointer+1) )  / (int)Math.pow(10, pointer) ; 
			if ( currentDigit == 5  || currentDigit == -5) {
				int firstPart = ( n / (int)Math.pow(10, pointer+1)) * (int)Math.pow(10, pointer); 
				int lastPart = n % (int)Math.pow(10, pointer); //   8
				int res = firstPart + lastPart;
				if ( res > comp) comp = res;
			}
			pointer++;
		}
		
		return comp;
	}
	
	
	private static int deleteFiveWithList(int n) {
		
		String s = "" + n;
		String st = new String(s);
		int val;
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) == '5') {
				s = s.substring(0, i) + s.substring(i+1);
				val = Integer.parseInt(s);
				list.add(val);
				s = st;
			}
		}
		Collections.sort(list);
		return list.get(list.size()-1);
	}
}
