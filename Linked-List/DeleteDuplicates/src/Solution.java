

/**
 * Definition for singly-linked list 
 *
 */
class Node{
	int val; 
	Node next; 
	Node(int val){this.val = val; }
}

/**
 * Definition for linked list 
 *
 */
class LinkedList{
	private Node head;
	
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
	
	public void deleteNode(int val){
		if(this.head.val == val){
			this.head = this.head.next; 
			return; 
		}
		Node curr = this.head, prev = this.head; 
		while(curr != null && curr.val != val){
			prev = curr; 
			curr = curr.next; 
		}
		if(curr != null){
			prev.next = curr.next; 
		}
	}
	
	/**
	 * Given a Unsorted linked list, delete all duplicates 
	 * such that each element appear only once. 
	 * @param head
	 */
	public void deleteDuplicatesUnsorted(){
		if(this.head == null) return; 
		 java.util.Set<Integer> set = new java.util.HashSet<>();
		 Node curr = this.head, prev = curr; 
		 while(prev.next != null){
			 if(!set.contains(curr.val)){
				 set.add(curr.val); 
				 prev = curr;
				 curr = curr.next; 
			 }else{
				 curr = curr.next; 
				 prev.next  = curr; 
			 } 
		 }
	}
	
	/**
	 * Remove Duplicates from Sorted List II 
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
	 * leaving only distinct numbers from the original list. 
	 */
	public void deleteDuplicatesII(){
		if(this.head == null || this.head.next == null)return; 
		Node dummy, prev, curr;
		dummy = new Node(-1); 
		dummy.next = this.head;
		prev = dummy; curr = dummy.next; 
		while(curr != null && curr.next != null){
			if(curr.next.val == curr.val){
				while(curr.next != null && curr.next.val == curr.val){
					curr = curr.next; 
				}	 
				curr = curr.next; 
				prev.next = curr;
			}
			else{
				prev = curr; 
				curr = curr.next; 
			}
		}
		this.head= dummy.next; 
	}

	/**
	 * Remove Nth Node From End of List  
	 * Given a linked list, remove the nth node from the end of list
	 * @param k
	 */
	public void removeNthFromEnd(int k){
		if(k == 0) return; 
		Node dummy, p1, p2, p3; 
		dummy = new Node(-1); 
		dummy.next = this.head; 
		p1 = dummy; 
		p2 = p3 = dummy.next; 
		int i; 
		for(i = 0; i < k ; i++){
			p3 = p3.next; 
			if(p3 == null){
				this.head = (i == k - 1) ? dummy.next.next : dummy.next;  
				return; 
			}
		}
		while(p3 != null){
			p3 = p3.next; 
			p2 = p2.next;
			p1 = p1.next; 
		}
		p1.next = p2.next; 
		this.head = dummy.next; 

	}
	
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

class Solution {

	public static void main(String[] args) {
		int[] nums = {1,2,2,3,3,5,6,6,7}; 
		LinkedList list = new LinkedList(); 
		for(int num: nums){
			list.add(num); 
		}
		System.out.printf("Original List:\n%s\n", list);
		
		int val = 6; 
		list.deleteNode(val);
		System.out.printf("\nRemove Node(%d):\n%s\n", val, list);
		
		list.deleteDuplicatesII();
		System.out.printf("\nRemove Duplicates:\n%s\n", list);
		
		int k = 4; 
		list.removeNthFromEnd(k);
		System.out.printf("\nRemove the %dth Node from End:\n%s\n", k, list);
		
	}

}

