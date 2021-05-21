package stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {

	public static void main(String[] args) {
		System.out.println(romanConv("CMXC"));
		
	}										  
	public static int romanConv(String str) {
		
		Map<Character, Integer> hm = new HashMap<>();
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);
		
		int sum = 0;
		for ( int i = 0 ; i < str.length() ; i++) { 
			if ( i == str.length()-1) {
				sum += hm.get(str.charAt(i));
				break;
			}
			if ( hm.get(str.charAt(i)) < hm.get(str.charAt(i+1))) {
				sum = sum - hm.get(str.charAt(i)) + hm.get(str.charAt(i+1));
				i++;
			}
			else {
				sum += hm.get(str.charAt(i));
			}
		}
		return sum;
	}
}
