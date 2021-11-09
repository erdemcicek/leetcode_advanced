package arrayQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class OccurrenceOfLetters {

	public static void main(String[] args) {
		//findOccurrence("erdem");
		findOccFunctional("erdem");
		
	}
	
	private static void findOccurrence(String str) {
		String[] s = str.split("");
		int[] count = new int[str.length()];
		for ( int i = 0 ; i < str.length() ; i++) {	
			if ( str.contains(s[i])) {
				count[str.indexOf(s[i])]++;
			}
		}	
		for ( int i = 0 ; i<str.length(); i++){
			if ( count[i] != 0)
				System.out.println(s[i] + " " + count[i]);
		}
	}
	// 2.way functional programming
	private static void findOccFunctional(String str) {
		Stream.of(str.split("")).distinct()
		.forEach(t->System.out.println(t + " " + Collections.frequency(Arrays.asList(str.split("")), t)));
	}
}
