package stringManipulation;

/*
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */

import java.util.Arrays;

public class MultiplyStrings {
	
	public static void main(String[] args) {
		
		System.out.println(multStrings("702", "30"));
		
	}
	public static String multStrings(String s1, String s2) { // "12" , "37"
		/*
		     12
		     37
		   ------ 
		     84
		    36
		  -------
		    444
		 */
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int n1 = c1.length, n2 = c2.length;
		int[] results = new int[n1+n2];
		
		for ( int i = n2-1; i >= 0 ; i--) { 
			for ( int j = n1-1 ; j >= 0 ; j--) { 
				int prod = ( c1[j] - '0') * ( c2[i] - '0');
				int temp = results[i+j+1] + prod;
				results[i+j+1] = temp % 10;
				results[i+j] += temp / 10;
			}
		}
		System.out.println(Arrays.toString(results));
		
		StringBuilder sb = new StringBuilder();
		boolean seen = false;
		for ( int c : results) {
			if ( c == 0 && !seen) continue;
			sb.append((char)(c +'0'));
			seen = true;
		}
		
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
