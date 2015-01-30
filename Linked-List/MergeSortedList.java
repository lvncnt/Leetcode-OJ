/*
 * Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists. 
 * 
 */

/** Definition for singly-linked list */ 
class ListNode{
	int val; 
	ListNode next; 
	ListNode(int x){
		val = x; 
		next = null; 
	}
}

class MergeSortedList {
	/** Merge two sorted lists */ 
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode merged = new ListNode(0);
		ListNode dummy = merged; 
		while(l1 != null && l2 != null){
			if(l1.val < l2.val) {
				dummy.next = l1; 
				l1 = l1.next; 
			}
			else{
				dummy.next = l2; 
				l2 = l2.next; 
			}
			dummy = dummy.next; 
		}
		if(l1 != null) dummy.next = l1; 
		if(l2 != null) dummy.next = l2; 
		return merged.next; 
	}
	
	/** Create linked list from an array*/ 
	ListNode makeList(int[] array){
		ListNode list = new ListNode(array[0]);
		ListNode dummy = list, temp; 
		for(int i = 1; i < array.length; i ++ ){
			temp = new ListNode(array[i]);
			dummy.next = temp; 
			dummy = temp; 
		}
		return list; 
		
	}
	
	/** Print a linked list */ 
	void showList(ListNode list){
		ListNode dummy = list ; 
		while(dummy != null){
			System.out.print(dummy.val + " "); 
			dummy = dummy.next; 
		}
	}
	
	public static void main(String[] args) {
		
		MergeSortedList testCase = new MergeSortedList(); 
		int[] arrayA = {1, 6, 9, 12}; 
		ListNode l1 = testCase.makeList(arrayA); 
		
		int[] arrayB = {2, 5, 10};
		ListNode l2 = testCase.makeList(arrayB); 
		
		ListNode l12 = testCase.mergeTwoLists(l1, l2); 
		testCase.showList(l12);
	}
}
