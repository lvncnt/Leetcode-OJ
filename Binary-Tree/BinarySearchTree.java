package createBinarySearchTree;

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
}

class Solution {

	public static void main(String[] args) {

		// {1,2,3,#,#,4,#,#,5};
		BinarySearchTree tree = new BinarySearchTree();
		int[] array = { 1, 2, 3, 4, 5 };
		for (int i : array){
			tree.add(i);
		}
		System.out.println(tree.toString() );
	}
}
