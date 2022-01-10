package other3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*	Given an array of strings strs, group the anagrams together. You can return the answer in any order.
	An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
	typically using all the original letters exactly once.
	
	Example 1:
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	
	Example 2:
	Input: strs = [""]
	Output: [[""]]
	
	Example 3:
	Input: strs = ["a"]
	Output: [["a"]]
*/
public class GroupAnagrams {
	
	public static void main(String[] args) {
//		System.out.println(sortString("erdem"));
		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
//		System.out.println(groupAnagrams(new String[] {""}));
//		System.out.println("".hashCode());
		
	}
	
	private static List<List<String>> groupAnagrams(String[] strs) {
		var x = Arrays.stream(strs).collect(Collectors.groupingBy(t->sortString(t)));
		List<List<String>> list = new ArrayList<>();
		x.values().forEach(t->list.add(t));
        return list;
    }
	private static String sortString(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
	
	
	
	
	
	
	
	
	

}
