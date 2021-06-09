package arrayQuestions;

import java.util.Scanner;

public class OccurrenceOfLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next(); // tablet
		String[] s = str.split(""); // 			t,a,b,l,e,t
		int[] count = new int[str.length()]; // 0,0,0,0,0,0
		for ( int i = 0 ; i < str.length() ; i++) {	
			if ( str.contains(s[i])) {
				count[str.indexOf(s[i])]++;  // String'deki indexOf baz alinmali*** 
			}
		}	
		for ( int i = 0 ; i<str.length(); i++){
			if ( count[i] != 0)
				System.out.println(s[i] + " " + count[i]);
		}
		scan.close();
	}
}
