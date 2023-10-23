package programmers;

import java.util.Stack;

public class ¿Ã¹Ù¸¥°ýÈ£ {

	class Solution {
		boolean solution(String s) {
			boolean answer = true;

			Stack<Character> stack = new Stack<Character>();

			if (s.charAt(0) == ')') {
				return false;
			} else {
				stack.push(s.charAt(0));
			}

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else {
					if (stack.isEmpty()) {
						return false;
					} else {
						stack.pop();
					}
				}
			}

			if (!stack.isEmpty()) {
				return false;
			}

			return answer;
		}
	}

}
