package other2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteFive {
	
	public static void main(String[] args) {
		System.out.println(deleteFive(15958));
		System.out.println(deleteFive(-5859));
		System.out.println(deleteFive(-5000));
	}
	// 15958 -> 1958
	// -5859 -> -589
	// -5000 -> 0
	private static int deleteFive(int N) {
		
		String s = "" + N;
		String st = new String(s);
		int val;
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) == '5') {
				s = s.substring(0, i) + s.substring(i+1);
				val = Integer.parseInt(s);
				list.add(val);
				s = st;
			}
		}
		Collections.sort(list);
		return list.get(list.size()-1);
	}
	


}
