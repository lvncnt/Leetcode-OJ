/*
 * Add Two Numbers 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 */

/**
 * Definition for node 
 *
 */
class Node{
	int val; 
	Node next; 
	Node(int val){this.val = val; }
}

/**
 * Definition for singly-linked list.
 *
 */
class LinkedList{
	private Node head;
	
	LinkedList(){}
	
	LinkedList(Node head){this.head = head;}
	
	public void add(int val){
		if(this.head == null){
			this.head = new Node(val); 
			return; 
		}
		add(this.head, val); 
	}
	
	private void add(Node node, int val){
		Node dummy = node; 
		while(dummy.next != null){
			dummy = dummy.next; 
		}
		dummy.next = new Node(val); 
	}
	
	public Node getHead(){return this.head; }
	
	public String toString(){
		if(this.head == null)return null; 
		StringBuilder sb = new StringBuilder(); 
		Node dummy = this.head; 
		while(dummy.next != null){
			sb.append(dummy.val).append(" -> "); 
			dummy = dummy.next; 
		}
		sb.append(dummy.val); 
		return sb.toString(); 
	}	
}

class Main {

	/**
	 * Add two numbers represented by linked lists (reverse order) 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public Node addTwoNumbers(Node l1, Node l2){
		Node addList = new Node(0), p3 = addList; 
		Node p1 = l1, p2 = l2; 
		int carry = 0, sum; 		
		while(p1 != null || p2 != null ){
			sum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + carry ;	
			p3.next = new Node(sum%10);
			carry = sum/10; 		
			if(p1 != null) p1 = p1.next; 
			if(p2 != null) p2 = p2.next;
			p3 = p3.next; 
		}
		if(carry == 1) p3.next = new Node(carry); 
		return addList.next; 
	}
	
	public static void main(String[] args) {
		int[] nums1 = {7,1,6}; 
		int[] nums2 = {5,9,2};
		LinkedList list1 = new LinkedList(); 
		for(int num: nums1){
			list1.add(num); 
		}
		
		LinkedList list2 = new LinkedList(); 
		for(int num: nums2){
			list2.add(num); 
		}
		
		System.out.printf("List 1:\n%s\n\n", list1);
		System.out.printf("List 2:\n%s\n\n", list2);
	 
		LinkedList list3 = new LinkedList(new Main().addTwoNumbers(list1.getHead(), list2.getHead()));
		
		System.out.printf("Added List:\n%s\n", list3);
	}

}

