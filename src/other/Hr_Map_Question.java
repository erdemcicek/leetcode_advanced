package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hr_Map_Question {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		Map<String, Integer> map1 = new HashMap<>();
		for(int i=0;i<n;i++){
			String name=in.nextLine();
			int phone=in.nextInt();
			map1.putIfAbsent(name, phone);
			in.nextLine();
		}

		for ( int i = 0 ; i < n ; i++) {
			String input = in.nextLine();
			if ( map1.containsKey(input)) {
				System.out.println(input + "=" + map1.get(input));
			}
			else
				System.out.println("Not found");
		}
		in.close();
		
	}
}
