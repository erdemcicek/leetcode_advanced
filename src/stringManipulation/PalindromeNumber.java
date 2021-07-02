package stringManipulation;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(124));
	}
	private static boolean isPalindrome(int n) {
		
		if ( n < 0 ) return false;
		else if ( n < 10 ) return true;
		else {
			String s = "" + n;
			for ( int i = 0 ; i < s.length() ; i++) {
				if ( s.charAt(i) != s.charAt(s.length()-1-i)) return false;
			}
		}
		return true;
	}
}
