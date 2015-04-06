import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Main {

	/**
         * Merge k Sorted Lists
         * Merge k sorted linked lists and return it as one sorted list. 
         */
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists == null || lists.isEmpty()) return null; 
		int start = 0, end = lists.size() - 1; 
		while(end > 0 ){
			start = 0; 
			while(start < end ){
				lists.set(start, mergeTwoLists(lists.get(start), lists.get(end))); 
				start ++; 
				end --; 
			}
		}
		return lists.get(0); 
	}

	/** 
	 * Merge two sorted linked lists 
	 * and return it as a new list.
         */ 
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

	/**
 	 * Merge Sorted Array: merge B into A
 	 * m, n: number of elements initialized in A, B 
         * Assume that the size of A is greater or equal to m + n
 	 * */ 
	public void merge(int[] A, int m, int[] B, int n){
		int i = m - 1, j = n - 1, x = m + n - 1; 
		while(i >= 0 && j >= 0){
			A[x] = (A[i] > B[j]) ? A[i--] : B[j--]; 
			x--; 
		}
		while(j >= 0) A[x--] = B[j--]; 
	}

	/** create linked list from array **/ 
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
	
	/** print linked list **/ 
	private String showList(ListNode list){
		ListNode dummy = list ; 
		StringBuilder sb = new StringBuilder(); 
		sb.append("["); 
		while(dummy != null){
			sb.append(dummy.val + ", "); 
			dummy = dummy.next; 
		}
		return sb.substring(0, sb.length() - 2) + "]"; 
	}
	
	public static void main(String[] args) {
		
		Main test = new Main(); 

		 System.out.println("==> Test merge sorted arrays: ");
		 int m, n; 
		 m = 3; n = 3; 
		 int[] A = new int[m+n];
		 A[0] = 4; A[1] = 5; A[2] = 6;  
		 int[] B = {1,2,3}; 
		 
		 System.out.printf("Array 1:%25s%nArray 2:%25s%n", Arrays.toString(A), Arrays.toString(B));
		 test.merge(A, m, B, n); 
		 System.out.printf("Merged Array:%20s%n%n", Arrays.toString(A));

		System.out.println("==> Test merge sorted Lists: ");
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
		
		System.out.printf("Lists:%4s", ""); 
		for(ListNode list: lists)System.out.print(test.showList(list) + " ");
		ListNode l = test.mergeKLists(lists); 
		System.out.printf("%nMerged Lists:%20s%n%n", test.showList(l));
	}
}
