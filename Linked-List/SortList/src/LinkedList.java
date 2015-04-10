
public class LinkedList{
	private ListNode head;

	public void add(int val){
		if(head == null){
			head = new ListNode(val); 
			return; 
		}
		ListNode dummy = head; 
		while(dummy.next != null)dummy = dummy.next; 
		dummy.next = new ListNode(val); 
	}
	
	
	/**
	 * Sort linked list
	 */
	public void sort(){
		head = mergeSort(head); 
	}
	
	private ListNode mergeSort(ListNode src){
		if(src == null || src.next == null) return src; 
		
		ListNode left, right, mid; 
		left = src; 
		mid = splitHalf(src);
		right = mid.next; 
		mid.next = null; 
		
		left = mergeSort(left);
		right = mergeSort(right); 

		return merge(left, right); 
	}
	
	/**
	 * Split list into front and back halves near the middle
	 */
	private ListNode splitHalf(ListNode src){
		ListNode slow, fast; 
		slow = src; 
		fast = src.next; 
		// fast pointer moves twice as fast as slow pointer
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next; 
		}
		return slow; 
	}
	
	/** 
	 * Merge two sorted linked lists
	 * */ 
	private ListNode merge(ListNode l1, ListNode l2){
		
		ListNode merged, dummy; 
		merged = new ListNode(-1); 
		dummy = merged; 
		while(l1 != null && l2 != null){
			if(l1.val > l2.val){
				dummy.next = l2; 
				l2 = l2.next; 			
			}else{
				dummy.next = l1; 
				l1 = l1.next; 
			}
			dummy = dummy.next; 
		}
		if(l1 != null) dummy.next = l1; 
		if(l2 != null) dummy.next = l2; 
		return merged.next; 
	}
	
	/**
	 * Print nodes in linked list 
	 * */
	public String toString(){
		ListNode dummy = head; 
		StringBuilder sb = new StringBuilder(); 
		sb.append("["); 
		while(dummy.next != null){
			sb.append(dummy.val + ", "); 
			dummy = dummy.next; 
		}
		sb.append(dummy.val + "]"); 
		return sb.toString(); 
	}
}
