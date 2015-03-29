
import java.util.Stack;

/**
 * Min Stack Design a stack that supports push, pop, top, and retrieving the
 * minimum element in constant time.
 */
class MinStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> min = new Stack<>();

	/**
	 * Push element x onto stack
	 * 
	 * @param x
	 */
	public void push(int x) {
		this.stack.add(x);
		if (min.isEmpty() || x < min.peek()) {
			min.push(x);
		}
	}

	/**
	 * Removes element on the top of the stack
	 */
	public void pop() {
		int x = stack.pop();
		if (x == min.peek() && !stack.contains(x)) {
			min.pop();
		}
	}

	/**
	 * Get the top element
	 * 
	 * @return
	 */
	public int top() {
		return stack.peek();
	}

	/**
	 * Retrieve the minimum element in the stack
	 * 
	 * @return
	 */
	public int getMin() {
		return min.peek();
	}

	public Stack getStack() {
		return stack;
	}
}

class Solution {
	public static void main(String[] args) {

		MinStack test = new MinStack();
		int[] array = { 1, 4, 3, 0, 3, 0 };
		for (int i : array) {
			test.push(i);
		}
		System.out.println("Add element to stack: " + test.getStack());
		System.out.print("Remove two element from top of stack: " + test.top());
		test.pop();
		System.out.println(", " + test.top());
		test.pop();
		System.out.println("Min element in the remaining stack: " + test.getMin());
	}
}

