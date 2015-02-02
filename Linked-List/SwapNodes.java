/*
 * Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head. 
 *  For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 *  Your algorithm should use only constant space. 
 *  You may not modify the values in the list, only nodes itself can be changed. 
 */
class ListNode{
	int val; 
	ListNode next; 
	ListNode(int x){
		val = x; 
		next = null; 
	}
}

class SwapNodes {
	
	/** create linked list from array*/ 
	private ListNode makeList(int[] array){
		ListNode list = new ListNode(array[0]);
		ListNode dummy = list, temp; 
		for(int i = 1; i < array.length; i ++ ){
			temp = new ListNode(array[i]);
			dummy.next = temp; 
			dummy = temp; 
		}
		return list; 
		
	}
	
	/** print linked list */ 
	private void showList(ListNode list){
		ListNode dummy = list ; 
		while(dummy != null){
			System.out.print(dummy.val + " "); 
			dummy = dummy.next; 
		}
	}
	
	/** swap nodes in pairs */ 
	public ListNode swapPairs(ListNode head){
		
		ListNode dummy = new ListNode(0), curr = dummy;
		dummy.next = head; 
		ListNode p = head, q, r; 
		while(p != null && p.next != null){
			q = p.next; r = p.next.next; 
			curr.next = q; curr = p;  
			q.next = p; p.next = r;	
			p = p.next; 
		}
		return dummy.next ; 
	}
	
	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4}; 
		SwapNodes testCase = new SwapNodes(); 
		ListNode list = testCase.makeList(array); 
		list = testCase.swapPairs(list); 
		testCase.showList(list);
		
	}
}
