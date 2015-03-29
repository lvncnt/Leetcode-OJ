
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses Given a string containing just the characters '(', ')',
 * '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 */

class Solution {
	
	Map<Character, Character> map = new HashMap<Character, Character>() {
		private static final long serialVersionUID = 1L;
		{
			put('(', ')');
			put('[', ']');
			put('{', '}');
		}
	};

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			}
			else if (stack.isEmpty() || c != map.get(stack.pop())) {
				return false;
			}  
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		String[] s = {"[()()]", "()[]{}", "([)]", "]"};

		Solution test = new Solution();
		StringBuilder sb = new StringBuilder();

		for (String i : s) {
			sb.append(i + "\t-") ;
			if (!test.isValid(i)) {
				sb.append(" NOT");
			}
			sb.append(" valid parentheses").append('\n');
		}
		System.out.println(sb.toString());
	}
}

