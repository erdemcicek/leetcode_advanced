package other;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		boolean invalidInput = true;
		do {
			try {
				int input = scan.nextInt(); // If you enter a double here, you'll get InputMismatchException
				System.out.println("The number is " + input);
				invalidInput = false;
			}catch(InputMismatchException e) {
				System.out.println("Try again.");
				scan.nextLine();
			}
		}while(invalidInput);	
		scan.close();
	}
}




























/*
Scanner scan = new Scanner(System.in);
boolean invalidInput = true;
do {
	try {
		int input = scan.nextInt();
		invalidInput = false;
		System.out.println("The number is " + input);
		
	}catch(InputMismatchException e) {
		System.out.println("Try again. Invalid input");
		scan.nextLine();
	}
	
}while(invalidInput);
scan.close();

*/