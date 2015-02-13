
/**
 * Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author Feng
 *
 */

/**
 * Definition for singly-liked list
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int val) {
		this.val = val;
	}
}

class SortedListToBST {
	private ListNode head, list;
	private TreeNode root;

	/**
	 * Set sort list from array
	 * @param array
	 */
	public void setList(int[] array) {
		ListNode dummy = new ListNode(0);
		head = dummy;
		for (int i : array) {
			dummy.next = new ListNode(i);
			dummy = dummy.next;
		}
		head = head.next;
	}

	/**
	 *  Convert Sorted List to Tree
	 */
	public void sortedListToBST() {
		// Count the number of Nodes in the List 
		int n = 0; 
		ListNode dummy = head; 
		while(dummy != null){
			n ++; 
			dummy = dummy.next; 
		}
		list = head; 
		root = sortedListToBST(0, n - 1); 
	}
	
	private TreeNode sortedListToBST(int start, int end){
		if(start > end) return null; 
		int mid = start + (end - start)/2; 
		// Build left tree
		TreeNode left = sortedListToBST(start, mid - 1); 
		TreeNode parent = new TreeNode(list.val);
		// Connect left tree to its root
		parent.left = left; 
		list = list.next; 
		// Build right tree 
		parent.right =  sortedListToBST(mid + 1, end); 		
		return parent; 
	}

	/**
	 * Show List
	 * @return
	 */
	public String toListString() {
		ListNode dummy = head;
		return toListString(head);
	}

	private String toListString(ListNode node) {
		if (node == null)
			return null;
		return node.val + "->" + toListString(node.next);
	}

	/**
	 * Show Tree
	 */
	public String toString() {
		return toString(root);
	}

	private String toString(TreeNode node) {
		if (node == null)
			return null;
		return "[" + toString(node.left) + "," + node.val + ","
				+ toString(node.right) + "]";
	}

	public static void main(String[] args) {
		// Test
		SortedListToBST test = new SortedListToBST();

		System.out.println("List: ");
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		test.setList(array);
		System.out.println(test.toListString());
		System.out.println("Tree: ");
		test.sortedListToBST();
		System.out.println(test.toString());
	}
}
