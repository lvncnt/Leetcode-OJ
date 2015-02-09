
/**
 * Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

/** 
 * Definition for binary tree 
 * */ 
class TreeNode{
	int val; 
	TreeNode left; 
	TreeNode right; 
	TreeNode(int x){
		val = x; 
	}
}

class BinarySearchTree {
	private TreeNode root;
	
	/**
	 * Create a binary search tree from an array
	 * Use recursion to add value
	 * @param val
	 */
	public void add(int val) {
		if (this.root == null) {
			this.root = new TreeNode(val);
			return;
		}
		add(this.root, val); 
	}

	private void add(TreeNode node, int val) {
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

	/**
	 * Print out the value of each node
	 */
	public String toString() {
		return toString(this.root);
	}

	private String toString(TreeNode node) {
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

class Solution {
	
	/**
	 * Compute Maximum Depth of Binary Tree
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root){
		if(root == null) return 0; 
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; 
	}
	
	/**
	 * Compute Minimum Depth of Binary Tree
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root){
		if(root == null)return 0; 
		if(root.left == null) return minDepth(root.right) + 1; 
		if(root.right == null) return minDepth(root.left) + 1; 
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1; 
	}
	
	public static void main(String[] args){
		// {1,2}, {2,1,4,#,#,3,5,#,#,#,6} 
		int[][] arrays = {{1,2}, { 2, 1, 4, 3, 5, 6 }}; 
		for(int[] array: arrays){
			
			BinarySearchTree tree = new BinarySearchTree();
			for (int i : array){
				tree.add(i);
			}
			System.out.println("BST: " + tree.toString() );
			
			// compute max and min depth
			Solution test = new Solution(); 
			System.out.println("- Max depth = " + test.maxDepth(tree.getRoot()));
			System.out.println("- Min depth = " + test.minDepth(tree.getRoot()));
		}		
	}
}
