
/**
 * Implement the reversal of a singly linked list iteratively and recursively.
 * @author LVNCNT
 */

class Node{
	int val; 
	Node next; 
	Node(int val){this.val = val; } 
}

class LinkedList{
	private Node head = null; 
	public void add(int val){
		if(this.head == null){
			this.head = new Node(val); 
			return; 
		}
		Node dummy = this.head; 
		while(dummy.next != null){ dummy = dummy.next;}
		dummy.next = new Node(val); 
	}
	
	public Node getHead(){
		return this.head; 
	}
	
	/**
	 * 1) Reverse a linked list iteratively
	 */
	public void reverseListI(){	
		Node prev, curr, temp;
		prev = null;  
		curr = this.head; 
		while(curr != null){
			temp = curr.next; 
			curr.next = prev; 
			prev = curr; 
			curr = temp; 
		}
		this.head = prev;	 
	}
	
	/**
	 * 2) Reverse a linked list recursively
	 */
	public void reverseListII(){
		recursive(this.head); 		
	}
	
	private void recursive(Node curr){
		if(curr == null) return; 
		if(curr.next == null){
			this.head = curr; 
			return; 
		}
		
		recursive(curr.next);
		curr.next.next = curr; 
		curr.next = null;
	}
	
	/**
	 * Reverse a linked list from position m to n
	 * @param m: 1 ≤ m ≤ n ≤ length of list. 
	 * @param n
	 */
	public void reverseBetween(int m, int n){
		
		Node dummy, curr, p;  
		dummy = new Node(-1); dummy.next = this.head;  
		curr = this.head; 
		p = dummy;
		
		int i = 1; 		
		while(i < m){  
			p = curr; 
			curr = curr.next; 
			i++; 
		}
		
		
		Node prev, temp; 
		prev = curr; curr=curr.next; 
		
		while(curr != null && i++ < n){ 
			temp = curr.next; 
			curr.next = prev; 
			prev = curr; 
			curr = temp; 
		}

		p.next.next=curr; p.next = prev; 		
		this.head = dummy.next;  	
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(); 
		Node dummy = this.head; 
		sb.append("["); 
		while(dummy.next != null){
			sb.append(dummy.val + ","); 
			dummy = dummy.next; 
		}
		sb.append(dummy.val).append("]"); 
		return sb.toString(); 
	}
}

class Solution{

	public static void main(String[] args) {
		
		int[] num = {1,2,3,4,5};
		LinkedList list = new LinkedList(); 
		for(int i: num){ list.add(i); }

		System.out.printf("=>Old list: \n%s\n\n", list);		
		list.reverseListI(); 
		System.out.printf("=>Iteratively Reversed list: \n%s\n\n", list);
		
		list.reverseListII(); 
		System.out.printf("=>Recursively Reversed list: \n%s\n\n", list);
		
		int m, n; m = 1; n = 5; 
		list.reverseBetween(m, n); 
		System.out.printf("=>Reversed list between %d and %d: \n%s\n", m, n, list);
 
	}
}

