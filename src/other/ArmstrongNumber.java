package other;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {

	public static void main(String[] args) {

		System.out.println(isArmstrong(153));
	}
	private static boolean isArmstrong(int n) {
		
		if( n!=0 ) {
			int n_in = n, sum = 0;
			List<Integer> list = new ArrayList<>();
			while( n != 0) {
				list.add(n%10);
				n /= 10;
			}
			for(Integer w : list) sum += Math.pow(w, list.size());
			return n_in == sum;
		}
		return false;
	}
}
