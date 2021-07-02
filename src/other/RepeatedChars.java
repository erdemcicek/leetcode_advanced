package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RepeatedChars {
	
	public static void main(String[] args) {
		
		findRepeated1("aaabbbc");
		
	}
	private static void findRepeated1(String s) {
		List<Character> list = new ArrayList<>();
		for(int i = 0 ; i < s.length() ; i++) list.add(s.charAt(i));
		list.stream().filter(t->Collections.frequency(list, t) > 1).distinct().forEach(t->System.out.print(t +" "));
	}
	
	private static void findRepeated2(String s) {
		List<String> list = Arrays.asList(s.replaceAll(" ", "").split(""));
		list.stream().filter(t->Collections.frequency(list, t) > 1).distinct().forEach(t->System.out.print(t + " "));
	}
	
	private static void findRepeated3(String s) {
		s=s.replaceAll(" ", "");
		String t[]=s.split("");
		int cont[]=new int[t.length];
		
		
		for (int i = 0; i < cont.length-1; i++) {
			if(cont[i]==-1) continue;
			for (int j = i+1; j < cont.length; j++) {
				if(t[i].equals(t[j])) {
					cont[i]++;
					cont[j]--;
				}
			}
		}
		for (int i = 0; i < cont.length; i++) {
			if(cont[i]>0) {
				System.out.print(t[i]+" ");
			}
			
		}
	}

}
