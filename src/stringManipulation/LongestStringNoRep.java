package stringManipulation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

 // Given a string s, find the length of the longest substring without repeating characters.
 
public class LongestStringNoRep {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSub("pww"));
	}
	private static int lengthOfLongestSub(String s) {
		if ( s == null || s.length() == 0) return 0;
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();
		while( i < s.length()) {
			char c = s.charAt(i);		 
			while ( set.contains(c)) {   
				set.remove(s.charAt(j));  
				++j;
			}
			set.add(c); 
			max = Math.max(max, i-j+1); 
			++i;
		}
		return max;
	}
}
