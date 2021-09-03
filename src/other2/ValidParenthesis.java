package other2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
	
	public static void main(String[] args) {
		System.out.println(isValid("([{{])"));
		System.out.println(isValid("([{}])"));
		System.out.println(isValid("([]){}"));

	}

	private static boolean valid(char b, char e) {
        return b == '(' && e == ')' || b == '{' && e == '}' || b == '[' && e == ']';
    }

	private static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (Character c: s.toCharArray()) {
			if(stack.isEmpty()) stack.push(c);
			else if(valid(stack.peek(), c)) stack.pop();
			else stack.push(c);
		}
		return stack.isEmpty();
	}
}
