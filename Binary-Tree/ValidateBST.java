/*
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST). 
 * 
 *  Assume a BST is defined as follows:
 *  - The left subtree of a node contains only nodes with keys less than the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 *
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, 
 * where '#' signifies a path terminator where no node exists below. 
 *   1
 *  / \
 * 2   3
 *    /
 *   4
 *    \
 *     5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
 * 
 */

/** Definition for binary tree node */
class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		this.val = x;
	}
}

/** create a binary search tree from an array: using recursion to add value */
class BinarySearchTree {
	private TreeNode root;

	public void add(int val) {
		if (this.root == null) {
			this.root = new TreeNode(val);
			return;
		}
		add(this.root, val); 
	}

	public void add(TreeNode node, int val) {
		if(val < node.val){
			if(node.left == null ){
				node.left = new TreeNode(val); 
			} else{
				add(node.left, val); 
			}
		}
		else{
			if(node.right == null){
				node.right = new TreeNode(val); 
			}
			else{
				add(node.right, val); 
			}
		}
	}

	// print out the value of each node
	public String toString() {
		return toString(this.root);
	}

	public String toString(TreeNode node) {
		if (node == null)
			return null;
		return "[" + toString(node.left) + "," + node.val + ","
				+ toString(node.right) + "]";
	}

	/**
	 * @return the root
	 */
	public TreeNode getRoot() {
		return root;
	}
}

class ValidateBST {
	
	// ====================== brute force ================== 
	/** valid a binary search tree:    */
	public boolean isValidBST(TreeNode root) {
		if(root == null ) return true; 
		return isValidBST(root.left) && isValidBST(root.right) 
				&& isLess(root.left, root.val) && isMore(root.right, root.val) ;
	}
	
	private boolean isLess(TreeNode node, int val ){ 
		if(node == null) return true; 
		return node.val < val && 
				isLess(node.left, val) && isLess(node.right, val); 
	}
	
	private boolean isMore(TreeNode node, int val ){
		if(node == null) return true; 
		return node.val > val &&
				isMore(node.left, val) && isMore(node.right, val ); 
	}
	
	public static void main(String[] args) {
		// {2,1,4,#,#,3,5};
		BinarySearchTree tree = new BinarySearchTree();
		int[] array = { 2, 1, 4, 3, 5 };
		for (int i : array){
			tree.add(i);
		}
		System.out.println("BST: " + tree.toString() );
		
		// valid a binary search tree 
		ValidateBST test = new ValidateBST(); 
		System.out.println(test.isValidBSTII(tree.getRoot()));
	}
}
