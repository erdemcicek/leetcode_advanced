package other2;

public class MatchCases {
	
	public static void main(String[] args) {
//		System.out.println(matchCases("TacoCat"));   // -1
//		System.out.println(matchCases("azABaabza")); // 5
//		System.out.println(matchCases("AcZCbaBz"));  // 8
//		System.out.println(isMatch("AcZCbaBz"));
		System.out.println(matchCases("azABaabzaxZ"));
		
	}
	
	private static int matchCases(String s) {
		int  max = 0;
		for(int i = 0 ; i < s.length() - 1 ; i++) {
			for(int j = i + 2 ; j <= s.length() ; j++) {
				if(isMatch(s.substring(i,j)) && s.substring(i,j).length() > max) {
					max = s.substring(i,j).length();
				}
			}
		}
		return max > 0 ? max : -1;
	}
	
	private static boolean isMatch(String s) {
		
		for(char c: s.toCharArray()) {
			if(Character.isLowerCase(c)) {
				if(!s.contains((c+"").toUpperCase())) return false;
			}
		}
		
		return true;
	}	
}
