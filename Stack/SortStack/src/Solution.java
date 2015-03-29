
/**
Given a stack, write a program to sort the stack 
in the ascending order.
 *
 */

class Solution {

	/**
	 * @param stack
	 */
	public void quickSort(java.util.Stack<Integer> stack){
		
		if(stack.isEmpty()) return; 
		int pivot = stack.pop(); 
		java.util.Stack<Integer> smaller, greater; 
		smaller = new java.util.Stack<>(); 
		greater = new java.util.Stack<>(); 
		while(!stack.isEmpty()){
			int val = stack.pop(); 
			if(val <= pivot)smaller.push(val); 
			else greater.push(val); 
		}

		quickSort(smaller); 
		quickSort(greater); 

		greater.push(pivot);
		while(!smaller.isEmpty()) greater.push(smaller.pop());
		while(!greater.isEmpty()) stack.push(greater.pop());
	}
	
	public static void main(String[] args) {
		
		java.util.Stack<Integer> stack = new java.util.Stack<>(); 
		int nums[] = {2,1,8,5,1,3}; 
		for(int num: nums)stack.push(num); 
		System.out.printf("Before Sort: %s\n", stack);
		new Solution().quickSort(stack);
		System.out.printf("After Sort: %s\n", stack);		
	}

}

