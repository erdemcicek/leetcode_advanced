package other1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/*
 		6 3
		5 3 5 2 3 2
		Output : 3
 */

public class Hr_Deque_Question {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        Deque<Integer> deq = new ArrayDeque<>();
        int n = scan.nextInt(); // total input number
        int m = scan.nextInt(); // length of subarray
        int[] a = new int[10000001];
        long max = 0, current = 0;
        
        for ( int i = 0 ; i < n ; i++ ) { 
        	
        	if ( i >= m) {
        		
        		int f = deq.removeLast(); 
        		a[f]--;
        		if ( a[f] == 0) current--;
        	}
        	
        	int x = scan.nextInt();
        	if ( a[x] == 0) {				  
        		current++;					 
        		max = Math.max(current, max); 
        	}
        	a[x]++;							 
        	deq.addFirst(x); 
        }				
        System.out.println(max);
        scan.close();
	}
}
