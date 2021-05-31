package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer to see if it is Armstrong");
		int a = scan.nextInt();
		if ( a != 0 ){
			int b = a, sum = 0;
			List<Integer> list = new ArrayList<>();
			while( a != 0) { 
				int r = a%10;
				list.add(r);  
				a /= 10;
			}
			for ( Integer w : list) {
				sum += Math.pow(w, list.size());
			}
			System.out.println("The number is" + (( sum == b)?(""):( " not")) + " Armstrong number");
		}
		else {
			System.out.println("The number is not Armstrong number");
		}
		scan.close();
	}
}
//for ( int i = 0 ; i < list.size() ; i++) {
//sum += Math.pow(list.get(i), list.size());
//}