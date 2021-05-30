package stringManipulation;

/*
 	Given two binary strings a and b, return their sum 
 	as a binary string.
 	
 	Constraints:
 	* 1 <= a.length, b.length <= 104
	* a and b consist only of '0' or '1' characters.
	* Each string does not contain leading zeros except for the zero itself.
	
	Input  : a = "11", b = "1"
	Output : "100"
	
	Input  : a = "1010", b = "1011"
	Output : "10101"
	  
 */

public class AddBinaryString {
	
	public static void main(String[] args) {
		
		System.out.println(addBinary("1010", "1011"));
		System.out.println(powOfTwo("110"));
	}
	private static String addBinary(String a, String b) {
		
		long result = powOfTwo(a) + powOfTwo(b);
		StringBuilder sb = new StringBuilder();
		while(result>0) {
			sb.append(result%2);
			result /= 2;
		}
		
		return sb.reverse().toString();
	}
	
	private static long powOfTwo(String s) {
					
		char[] sc = s.toCharArray();
		long total = 0, temp = 0;
		
		for ( int i = 0 ; i < s.length() ; i++) {
			temp = sc[i] - '0';
			for ( int j = i ; j < s.length()-1 ; j++ ) {
				temp *= 2;
			}
			total += temp;
		}
		
		return total;
	}
}
