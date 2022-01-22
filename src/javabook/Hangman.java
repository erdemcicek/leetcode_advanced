package javabook;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	
	/*
	 	Write a hangman game that randomly generates a word and promts user to guess one letter at a time, 
	 	as presented in the
	 	simple run. Each letter in the word is displayed as an asterisk. When the user makes a correct guess, 
	 	the actual letter
	 	is then displayed. When the user finishes a word, display the number of misses and ask the user 
	 	whether to continue to play
	 	with another word. Declare an array to store words, as follows:
	 */

	public static void main(String[] args) {
		
		String[] words = {"computer","notebook","calendar","dashboard","utility","highlight"};
		String right = words[(int)(Math.random()*words.length)];
		char[] rightArr = right.toCharArray();  // ["c","a","l","e","n","d","a","r"];
		String ast = "";
		
		for ( int i = 0 ; i < rightArr.length; i++) {  // [*,*,*,*,*,*,*,*]
			ast += "*";
		}
		
		char[] astArr = ast.toCharArray();
		boolean[] index = new boolean[rightArr.length];
		int mistake = 0;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a letter in word" + Arrays.toString(astArr));
			char c = scan.next().toLowerCase().charAt(0);
			String s = "" + c;
			
			for ( int i = 0 ; i < right.length(); i++) {
				if ( rightArr[i] == c) {
					index[i] = true;
				}
			}
			
			if ( !right.contains(s)) {
				mistake++;
				System.out.println(s + " is not in the word");
			}
			
			for ( int i = 0 ; i < right.length() ; i++) {
				if ( index[i]) {
					astArr[i] = rightArr[i];
				}
			}
			
			System.out.println(Arrays.toString(astArr));
			
			
			scan.close();
			
		}while(!Arrays.equals(astArr, rightArr));
		
		
		System.out.println("The word is " + right + ". You missed " + mistake + " time.");
		
	}	
}		
