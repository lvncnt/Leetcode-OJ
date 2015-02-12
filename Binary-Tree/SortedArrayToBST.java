
/**
 * Convert Sorted Array to Binary Search Tree 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 *
 */

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class SortedArrayToBST {

	TreeNode root;

	/**
	 * Convert Sorted Array to Binary Search Tree 
	 * @param num
	 */
	public void sortedArrayToBST(int[] num){
		root = sortedArrayToBST(num, 0, num.length - 1);
	}
	
	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if(start > end) return null; 
		int mid = start + (end - start)/2 ; 
	
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBST(num, start, mid - 1); 
		node.right = sortedArrayToBST(num, mid + 1, end);  
		return node;
	}

	/**
	 * @return balanced binary search tree 
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
		int[] num = { 0, 1, 2, 3, 4, 5 };
		SortedArrayToBST test = new SortedArrayToBST();
		test.sortedArrayToBST(num);
		System.out.println(test.toString());
	}
}

