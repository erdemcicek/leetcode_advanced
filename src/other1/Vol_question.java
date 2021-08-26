package other1;

import java.util.Scanner;

/*
   Create following pattern on the console
		    A
		   BAB  
		  CBABC
		 DCBABCD
		EDCBABCDE
		 DCBABCD
		  CBABC
		   BAB
		    A 
 */

public class Vol_question {
	
	public static void main(String[] args) {
		
		// A --> 65  ; E --> 69 
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the final letter for the pattern");
		char ch = scan.next().toUpperCase().charAt(0);
		if ( ch < 'A' || ch > 'Z') System.out.println("Please enter an alphabet");
		else {
			
			for ( char c = 'A' ; c <= ch ; c++) {// A,B,C,D,E
				
				for ( int i = (int)(ch-c); i > 0 ; i--) System.out.print(" ");
				for ( char i = c ; i >= 'A' ; i--) System.out.print(i);
				for ( char i = 'B' ; i <= c ; i++) System.out.print(i);
				System.out.println();
			}

			for ( char d = (char)(ch-1) ; d >= 'A' ; d--){ // E,D,C,B,A
																
				for (int j = (int)(ch-d) ; j > 0 ; j--) System.out.print(" ");
				for ( char j = d ; j >= 'A' ; j--) System.out.print(j);
				for ( char j = 'B' ; j <= d ; j++) System.out.print(j);
				System.out.println();
			}
		}
		scan.close();
	}
}
