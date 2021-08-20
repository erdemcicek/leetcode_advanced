package udemytimbuch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RandomPasswordGenerator {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many letters?");
		int n_let = scan.nextInt(); // 4
		System.out.println("How many numbers?");
		int n_num = scan.nextInt(); // 2
		System.out.println("How many symbols?");
		int n_sym = scan.nextInt(); // 2
		
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] symbols = {'!', '#', '$', '%', '&', '(', ')', '*', '+'};
		
		StringBuilder sb = new StringBuilder();
		
		List<String> mylist = new ArrayList<>();
		mylist.add("L");
		mylist.add("N");
		mylist.add("S");
		
		while(!mylist.isEmpty()) {
			
			int ran = (int) (Math.random() * mylist.size());
			
			if( n_let>0 && mylist.get(ran).equals("L")) {
				sb.append(letters[(int) (Math.random()*letters.length)]);
				n_let--;
			}
			else if ( n_num > 0 && mylist.get(ran).equals("N")) {
				sb.append(numbers[(int) (Math.random()*numbers.length)]);
				n_num--;
			}
			else if( n_sym > 0 && mylist.get(ran).equals("S")) {
				sb.append(symbols[(int) (Math.random()*symbols.length)]);
				n_sym--;
			}
			if ( n_let == 0 ) mylist.remove("L");
			if ( n_num == 0 ) mylist.remove("N");
			if ( n_sym == 0 ) mylist.remove("S");
		}
		System.out.println(sb);
		
		// 2.Way ==> Collections.shuffle()
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0 ; i < n_let ; i++) sb.append(letters[(int) (Math.random()*letters.length)]);
//		for(int i = 0 ; i < n_num ; i++) sb.append(numbers[(int) (Math.random()*numbers.length)]);
//		for(int i = 0 ; i < n_sym ; i++) sb.append(symbols[(int) (Math.random()*symbols.length)]);
//
//		List<String> x = Arrays.asList(sb.toString().split(""));
//		Collections.shuffle(x);
//		for(String w: x ) System.out.print(w);

		scan.close();
	}
}
