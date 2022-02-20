package codewars;

public class ConvertStringToCamelCase {
	
	public static void main(String[] args) {
		
		System.out.println(toCamelCase("the-Stealth-Warrior"));
		
	}
	
	private static String toCamelCase(String s) { // the_stealth_warrior
		
		var sb = new StringBuilder(s);
		
		for(int i = 0 ; i < sb.length() ; i++) {
			
			if((sb.charAt(i) == '-' || sb.charAt(i) == '_') && Character.isLowerCase(sb.charAt(i+1)) ) {
				sb.setCharAt(i+1, (char) (sb.charAt(i+1)-32));
			}
		}
		
		return sb.toString().replaceAll("_", "").replaceAll("-", "");;
	}
	

}
