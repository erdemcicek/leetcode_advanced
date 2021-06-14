package javabook;

import java.util.Scanner;

public class RockPaperScissor {
	/*
	 	*(Game: scissor, rock, paper) Write a program that plays the popular scissor–rock–
		paper game. (A scissor can cut a paper, a rock can knock a scissor, and a paper can
		wrap a rock.) The program randomly generates a number 0, 1, or 2 representing
		scissor, rock, and paper. The program prompts the user to enter a number 0, 1, or
		2 and displays a message indicating whether the user or the computer wins, loses,
		or draws. Here are sample runs: 
		
		scissor (0), rock (1), paper (2): 1
		The computer is scissor. You are rock. You won
		
		scissor (0), rock (1), paper (2): 2
		The computer is paper. You are paper too. It is a draw
	  
	 
	 	*(Game: scissor, rock, paper) Programming Exercise 3.17 gives a program that plays
		the scissor-rock-paper game. Revise the program to let the user continuously play
		until either the user or the computer wins three times more than their opponent.
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int countUserWin = 0 , countComWin = 0;
//		while ( countUserWin < 5 && countComWin < 5) {
		while ( Math.abs(countUserWin - countComWin) < 3 ) {
			System.out.println("Enter from 0 to 2 -> scissor (0), rock (1), paper (2):");
			int user = scan.nextInt();
			int com = (int)(Math.random() * 3);
			if ( user > -1 && user < 3) {
				if ( ( user == 0 && com == 2) || ( user == 1 && com == 0) || ( user == 2 && com == 1) ) {
					countUserWin++;
					System.out.println("You won this turn. You : " + countUserWin + "  Computer : " + countComWin); 
				}
				else if ( ( com == 0 && user == 2) || ( com == 1 && user == 0) || ( com == 2 && user == 1) ){
					countComWin++;
					System.out.println("You lost this turn. You : " + countUserWin + "  Computer : " + countComWin); 
				}
				else System.out.println("It's a draw. You : " + countUserWin + "  Computer : " + countComWin);
			}	
			else System.out.println("Please enter a valid input.");
		}
		if ( countUserWin > countComWin) {
			System.out.println("Congradulations!!! You won!!!" + "\nFinal score : You :" + countUserWin + " Computer :" + countComWin);
		}
		else System.out.println("Unfortunately you lost." + "\nFinal score : You :" + countUserWin + " Computer :" + countComWin);
		scan.close();
	}
}