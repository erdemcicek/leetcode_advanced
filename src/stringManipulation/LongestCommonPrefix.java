package stringManipulation;

import java.util.Arrays;
import java.util.Comparator;

/*
 		Write a function to find the longest common prefix string amongst an array of strings.

		If there is no common prefix, return an empty string "".
		
		Example 1:

		Input: strs = ["flower","flow","flight"]
		Output: "fl"
		Example 2:
		
		Input: strs = ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.
		
 */

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		
		String[] st = { "flower", "flow", "flight"};
		System.out.println(longestCommonPrefix(st));
		System.out.println(longestCommonPrefix1(st));
		
	}
	// 1.Way
	public static String longestCommonPrefix(String[] strs) {
		
		StringBuilder sb = new StringBuilder();
		
		String min = Arrays.stream(strs).min(Comparator.comparing(String::length)).get(); // flow
		boolean cont = true;
		for ( int i = 0 ; i < min.length() ; i++) {
			
			for ( int j = 0 ; j < strs.length-1 ; j++ ) {
				if ( strs[j].charAt(i) != strs[j+1].charAt(i)) {
					cont = false;
				}
			}
			if ( cont ) sb.append(min.charAt(i));
			else break;
		}
		return sb.toString();
	}
	
	// 2.Way
	public static String longestCommonPrefix1(String[] a) {
		
	    int size = a.length;
	    /* if size is 0, return empty string */
	    if (a.length == 0)
	      return "";
	    if (a.length == 1)
	      return a[0];
	    /* sort the array of strings */
	    Arrays.sort(a); 
	    /* find the minimum length from first and last string */
	    int end = Math.min(a[0].length(), a[size-1].length()); 
	    /* find the common prefix between the first and
	      last string */
	    int i = 0;
	    while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
	      i++;
	    String pre = a[0].substring(0, i);
	    return pre;
	  }
}

