package javabook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 		The bin packing problem is to pack the objects of various weights
 		into containers. Assume each container can hold a maximum of 10
 		pounds. The program uses an algorithm that places an object
 		into the first bin in which it would fit. Your program should prompt
 		the user to enter the total number of objects and the weight of 
 		each object. The program displays the total number of containers 
 		needed to pack the objects and the contents of each container.
 		
 		Please enter the number of objects : 6
 		7 5 2 3 5 8 prints ; 
 		
 		Container 1 contains objects with weight 7,2
 		Container 2 contains objects with weight 5,3
 		Container 3 contains objects with weight 5
 		Container 4 contains objects with weight 8
 		
 		Please enter the number of objects : 9
 		2 2 4 5 4 3 8 1 4 prints 
 		
 		Container 1 contains objects with weight 2, 2, 4, 1
		Container 2 contains objects with weight 5, 4
		Container 3 contains objects with weight 3, 4
		Container 4 contains objects with weight 8
 */

public class BinPacking {
	
	public static void main(String[] args) {
		
		List<Integer> mylist = new ArrayList<>(); // full
		List<Integer> list = new ArrayList<>();	  // empty
		List<Integer> idx = new ArrayList<>();	  // empty
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of objects");
		
		int n = scan.nextInt();
		
		System.out.println("Enter the weights of the objects");
		
		int count = 0;
		
		while( count < n) {
			System.out.println("Please enter " + (count+1) + ". object");
			int b = scan.nextInt();
			if ( b < 10 && b > 0) {
				mylist.add(b);
				count++;
			}
			else if ( b >= 10) System.out.println("Luggages that are 10 pounds and more are not allowed");
			else System.out.println("Invalid luggage weight.");	
		}
		
		System.out.println("You have " + mylist.size() + " objects in total");
		
		while ( !mylist.isEmpty()) {
			int contNum = 0;
			for ( int i = 0 ; i < mylist.size() ; ) { 
				int sum = mylist.get(i);  
				list.add(mylist.get(i)); 
				mylist.remove(mylist.get(i)); 
				for ( int j = 0 ; j < mylist.size() ; j++) {
					if ( sum + mylist.get(j) < 10 ) {
						sum += mylist.get(j);
						list.add(mylist.get(j)); 
						idx.add(j); 
					}
				}
				if ( idx.size() != 0) { 
					for ( int k = idx.size()-1 ; k >= 0 ; k--) {
						mylist.remove(mylist.get(idx.get(k)));
					}
				}
				contNum++;
				System.out.print("Container " + contNum + " contains objects with weight ");
				printContainer(list);
				System.out.println();
				list.clear();
				idx.clear();	
			}	
		}
		System.out.println("Thank you. Have a good flight");
		scan.close();
	}
	
	private static void printContainer(List<Integer> list) {
		for ( int i = 0 ; i < list.size() ; i++) System.out.print(list.get(i) + " ");
	}
}
