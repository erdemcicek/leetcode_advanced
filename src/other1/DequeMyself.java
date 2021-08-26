package other1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DequeMyself {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        Deque<Integer> deq = new ArrayDeque<>();
        int n = scan.nextInt(); // total number
        int m = scan.nextInt(); // length of subarray
        int current = 0 , max = 0;
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for ( int i = 0 ; i < n ; i++) {
        	
        	if ( i >= m) {
        		int f = deq.removeLast();
        		hm.put(f, hm.get(f)-1);
        		if ( hm.get(f) == 0 ) current--;
        		
        	}
        	int x = scan.nextInt();
        	if ( !hm.containsKey(x)) {
        		hm.put(x, 1);
        		current++;
        		max = current>max ? current: max;
        	}
        	else {
        		hm.put(x, hm.get(x)+1);
        	}
        	deq.addFirst(x);
        	
        }
        System.out.println(max);
        scan.close();
          
	}
}
