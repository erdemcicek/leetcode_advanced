package stringManipulation;

import java.util.List;

public class IntegerToRoman {
	
	public static void main(String[] args) { 
		
		System.out.println(intToRoman(394));
		System.out.println(convertRoman(213)); 
	}
	
	final static int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; // I II III IV V VIII IX
    final static String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    private static String intToRoman(int N) {// 973
        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++)
            while (N >= val[i]) {
                ans.append(rom[i]);
                N -= val[i]; 
            }
        return ans.toString();
    }
	
// -------------------------------------------------------------------------------------------
	
	private static String convertRoman(int n) {
											    
		if ( n <= 0 || n > 3999) return "Invalid Number";
		
		List<Character> list = List.of('I','V','X','L','C','D','M');
		
		StringBuilder sb = new StringBuilder("" + n); 
		sb.reverse();
		StringBuilder t = new StringBuilder();
		
		for ( int i = sb.length()-1 ; i >= 0  ; i--) {			
			int digit = sb.charAt(i) - '0'; 
															
			switch(digit) {
				case 1:
				case 2:
				case 3: t.append(multStr(list.get(2*i), digit));break;
				case 4: t.append(list.get(2*i) + "" + list.get(2*i+1));break;
				case 5: t.append(list.get(2*i+1));break;
				case 6:
				case 7:
				case 8: t.append(list.get(2*i+1) + "" + multStr(list.get(2*i), digit-5));break;
				case 9: t.append(list.get(2*i) + "" + list.get(2*i+2));break;
				
			}	
		}
		return t.toString();
	}
	
	private static String multStr(char c, int x) {
		
		StringBuilder stb = new StringBuilder("" + c);
		for ( int i = 1 ; i < x ; i++)  stb.append(c);
		return stb.toString();
	}
}
