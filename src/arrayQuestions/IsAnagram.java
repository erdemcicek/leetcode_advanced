package arrayQuestions;

import java.util.Arrays;

public class IsAnagram {
	
	public static void main(String[] args) {
		
//		System.out.println(isAnagram("anagram", "graanma"));
		char[] arr = {'h','e','l'};
		revStr(arr);	
	}
	
	private static boolean isAnagram(String s, String t) {
		
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();
		Arrays.sort(sch);
		Arrays.sort(tch);
		return Arrays.equals(sch, tch);
	}
	
	private static void revStr(char[] s) {
		
		int left = 0, right = s.length-1;
		
		while( left <= right) {
			
			char temp = s[right];
			s[right] = s[left];
			s[left] = temp;
			left++;
			right--;
		}
		System.out.println(Arrays.toString(s));
	}
}
