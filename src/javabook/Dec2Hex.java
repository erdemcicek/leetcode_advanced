package javabook;

import java.util.Scanner;

public class Dec2Hex {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a decimal number: ");
		int decimal = scan.nextInt();
		String hex = "";
		if ( decimal == 0)
			System.out.println("The hex number is 0");
		
		else {
			while ( decimal != 0) {
				int hexValue = decimal % 16;  // hexValue can be 15 max 																				// 10 -> A 11 -> B
				char hexDigit = ( 0 <= hexValue && hexValue <= 9) ? (char)(hexValue + '0') : (char)( hexValue - 10 + 'A');
				 
				hex = hexDigit + hex;
				decimal = decimal / 16;
			}
			System.out.println("The hex number is " + hex);
		}
		scan.close();
	}
}
