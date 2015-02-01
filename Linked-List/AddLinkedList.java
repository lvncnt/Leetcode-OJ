/*
 * Add Two Numbers 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
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

class AddLinkedList {
	/** create linked list from array*/ 
	ListNode makeList(int[] array){
		
		ListNode list = new ListNode(0); 
		ListNode dummy = list; 
		
		for(int i: array){
			ListNode temp = new ListNode(i); 
			dummy.next = temp; 
			dummy = dummy.next; 
		}
		return list.next; 
	}
	
	/** print linked list */ 
	void showList(ListNode list){
		
		ListNode dummy = list; 
		while(dummy != null){
			System.out.print(dummy.val + " ");
			dummy = dummy.next; 
		}	
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode addList = new ListNode(0), dummy = addList; 
		ListNode p = l1, q = l2; 
		int carry = 0, sum; 
		while(p != null || q != null ){
			sum = (p != null ? p.val : 0) + (q != null ? q.val : 0) + carry ;
			carry = sum/10; 
			dummy.next = new ListNode(sum%10);
			if(p != null){
				p = p.next; 
			}
			if(q != null){
				q = q.next; 
			}
			dummy = dummy.next; 
		}
		if(carry == 1){
			dummy.next = new ListNode(carry); 
		}
		return addList.next; 
	}
	
	public static void main(String[] args) {
		
		int[] arrayA = {2, 4}; 
		int[] arrayB = {5, 6, 4};
		AddLinkedList testCase = new AddLinkedList(); 
		ListNode l1 = testCase.makeList(arrayA); 
		ListNode l2 = testCase.makeList(arrayB); 
		ListNode addList = testCase.addTwoNumbers(l1, l2); 
		testCase.showList(addList);

	}

}
