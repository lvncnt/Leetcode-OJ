import java.util.LinkedList;
import java.util.List;

/*
 * Merge k Sorted Lists
 *  Merge k sorted linked lists and return it as one sorted list. 
 */

class ListNode{
	int val; 
	ListNode next; 
	ListNode(int x){
		val = x; 
		next = null; 
	}
}
class Solution {
	
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
	
	/** merge two lists */ 
	private ListNode mergeTwoLists(ListNode l1, ListNode l2){

	}
	
	/** merge k lists */ 
	public ListNode mergeKLists(List<ListNode> lists){


	}
	
	public static void main(String[] args) {
		
		MergeKLists test = new MergeKLists(); 
		int[] arrayA = {1, 5, 10};
		int[] arrayB = {4, 7, 11 }; 
		int[] arrayC = {2, 6, 9 }; 
		int[] arrayD = {3, 8, 12 }; 
		ListNode l1 = test.makeList(arrayA); 
		ListNode l2 = test.makeList(arrayB); 
		ListNode l3 = test.makeList(arrayC); 
		ListNode l4 = test.makeList(arrayD); 
		
		List<ListNode> lists = new LinkedList<ListNode>(); 
		lists.add(l1); 
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);
		
		ListNode l = test.mergeKLists(lists); 
		test.showList(l);
	}
}
