package other2;

import java.util.List;

public class CardGame {
	
	public static void main(String[] args) {
		
		System.out.println(findWinScore("5AKQ4", "3KT81"));
	}
	
	private static int findWinScore(String s, String t) {
		
		List<Character> deck = List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
		int score = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(deck.indexOf(s.charAt(i)) > deck.indexOf(t.charAt(i))) score++;
		}
		
		return score;
	}

}
