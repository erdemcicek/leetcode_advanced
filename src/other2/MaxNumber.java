package other2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumber {
	
	public static void main(String[] args) {
		System.out.println(findMaxCombin("1573935"));
	}
	private static String findMaxCombin(String s){
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int p = 0;
		for(int i = 0 ; i < s.length() - 1 ; i++) {
			if((s.charAt(i) - s.charAt(i+1)) % 2 == 0) sb.append(s.charAt(i));
			else {
				p = i;
				sb.append(s.charAt(i));
				list.add(sb.toString());
				sb.delete(0, sb.length());
			}
		}
		if(p==0) return sortPartial(s);
		list.add(s.substring(p+1, s.length()));
		System.out.println(list);
		StringBuilder acc = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).length() > 1) acc.append(sortPartial(list.get(i)));
			else acc.append(list.get(i));
		}
		return acc.toString();
	}
	private static String sortPartial(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		StringBuilder sbb = new StringBuilder();
		for(char e: arr) sbb.append(e);
		return sbb.reverse().toString();
	}
}
