package leetcode.intrv;

import java.util.Stack;

public class BalancedParentheses {
	public static char[][] TOKENS = { { '{', '}' }, { '[', ']' }, { '(', ')' } };

	public static boolean isOpenTerm(char c) {
		for (char[] arr : TOKENS) {
			if (arr[0] == c)
				return true;
		}
		return false;
	}

	public static boolean matches(char openTern, char closedTerm) {
		for (char[] arr : TOKENS) {
			if (arr[0] == openTern)
				return arr[1] == closedTerm;
		}
		return false;

	}

	public static boolean isBlanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for (char c : expression.toCharArray()) {
			if (isOpenTerm(c))
				stack.push(c);
			else if (stack.isEmpty() || !matches(stack.pop(), c))
				return false;
		}
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		String exp = "{[()]}}";
		System.out.println(isBlanced(exp));

	}

}
