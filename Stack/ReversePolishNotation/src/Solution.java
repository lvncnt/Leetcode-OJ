
import java.util.*;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation 
 */
class Solution {
	/**
	 * Postfix algorithm for evaluating any postfix expression 
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens){
		Stack<Integer> stack = new Stack<Integer>(); 
		Set<String> set = new HashSet<String>(Arrays.asList("+","-","*","/")); 
		
		for(String i: tokens){
			if(!set.contains(i)){
				stack.push(Integer.parseInt(i)); 
			}else{
				int x,y; 
				x = stack.pop(); 
				y = stack.pop();   
				stack.push(operate(x,y,i)); 
			}
		}
		return stack.peek(); 
	}
	
	private int operate(int x, int y, String operator){
		switch(operator){
		case "+": return x + y; 
		case "-": return y - x; 
		case "*": return x * y; 
		default: return y/x; 
		}
	}
	
	public static void main(String[] args) {
		String[][] tokens = {{"8","1","2","+","2","*","-"},
				{"2", "1", "+", "3", "*"},
				{"5", "1", "2", "+", "4", "*", "+", "3", "-"}};
		for(String[] i: tokens){
			System.out.println(new Solution().evalRPN(i));
		}		 
	}
}

