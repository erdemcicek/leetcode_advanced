package depth_first_search;

import java.util.ArrayList;
import java.util.List;

/*
 	Given a string s and a dictionary of strings wordDict, return true if s can be segmented into
 	a space-separated sequence of one or more dictionary words.
	Note that the same word in the dictionary may be reused multiple times in the segmentation.
	
	Input: s = "leetcode", wordDict = ["leet","code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	
	Input: s = "applepenapple", wordDict = ["apple","pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	Note that you are allowed to reuse a dictionary word.
	
	Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
	Output: false
	
	Input:"cars"
	["car","ca","rs"]
	Output: false
	Expected: true
 */

public class WordDictionary {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("car");
		list.add("ca");
		list.add("rs");
//		System.out.println(wordBreak1("applepenapp", list));
//		System.out.println(canConstruct("cars", list));
		System.out.println(wordBreak2("cars", list));
//		System.out.println(wordBreak2("eeeeeeeeeeeeeeeeeef", list));
	}
	
	private static boolean wordBreak2(String s, List<String> wordDict) {
		int n = s.length();
		boolean [] dp = new boolean[n + 1];

		dp[n] = true;
		for(int i= n - 1 ; i >= 0 ; i-- ){
		    for(String w: wordDict){
			if(i + w.length() <= n  && s.substring(i,i+ w.length()).equals(w))
			    dp[i] = dp[i + w.length()];
			if(dp[i])
			   break;
		    }
		}
		return dp[0];
	}
	
	private static boolean canConstruct(String target, List<String> list) { 
		
		if ( target.equals("")) return true;
		
		for ( int i = 0 ; i < list.size() ; i++) { 
			if ( target.indexOf(list.get(i)) == 0) {
				if (canConstruct(target.substring(list.get(i).length()) , list)) {
					return true;
				}
			}
		}	
		return false;
	}
	
	private static boolean wordBreak1(String s, List<String> wordDict) { // I understood the mistake 
		
		StringBuilder sb = new StringBuilder(s);
		if (sb.length()==0) return true;
		
		for(int i = 0 ; i < wordDict.size() ; i++) {
			if ( sb.toString().contains(wordDict.get(i))) {
				int startInd = sb.indexOf(wordDict.get(i)); 
				int endInd = startInd + wordDict.get(i).length();
				sb.delete(startInd, endInd);
				return wordBreak1(sb.toString(), wordDict);
			}
		}
		return false;
	}
}
