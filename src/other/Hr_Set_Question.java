package other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 		You are given  pairs of strings. Two pairs (a,b) and (c,d) are identical if a=c and  
 		b=d.That also implies (a,b) is not same as (b,a). 
 		
 		After taking each pair as input, you need to print number of unique pairs you currently have.
		Complete the code in the editor to solve this problem.

		Input Format

		In the first line, there will be an integer T denoting number of pairs. 
		Each of the next T  lines will contain two strings seperated by a single space.

		Constraints:
		* 1 <= T <= 100,000
		*Length of each string is atmost 5 and will consist lower case letters only.
		
		Output Format

		Print  lines. In the  line, print number of unique pairs you have after taking  pair as input.
		
		Sample Input:
		5
		john tom
		john mary
		john tom
		mary anna
		mary anna
		
		Sample output
		1
		2
		2
		3
		3
 */

public class Hr_Set_Question {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        
        Set<String> myset = new HashSet<>();
        for ( int i = 0 ; i < t ; i++) {
        	myset.add(pair_left[i] + " " + pair_right[i]);
        	System.out.println(myset.size());
        }
//        boolean isValid;
//        while(t>0) {
//        	isValid = true;
//        	String str = s.nextLine();
//        	if ( str.split(" ").length != 2 || str.split(" ")[0].length()>5 || str.split(" ")[1].length()>5 ) isValid = false;
//        	
//        	if ( isValid) {
//        		myset.add(str);
//        		t--;
//        	}
//        	
//        }
        
        
        
        
        s.close();
		
	}
	

	
}
