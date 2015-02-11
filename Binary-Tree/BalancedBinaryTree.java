/**
 * Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is defined as a binary tree in which 
 * the depth of the two subtrees of every node never differ by more than 1.
 * @author Feng
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

/**
 * Create binary search tree from an array
 */
class BinarySearchTree {

	private TreeNode root;

	public void add(int x) {
		if (root == null) {
			root = new TreeNode(x);
			return;
		}
		add(root, x);
	}

	private void add(TreeNode node, int x) {

		if (x < node.val) {
			if (node.left == null) {
				node.left = new TreeNode(x);
			} else {
				add(node.left, x);
			}
		} else {
			if (node.right == null) {
				node.right = new TreeNode(x);
			} else {
				add(node.right, x);
			}
		}
	}

	/**
	 * @return root
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * Print tree
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
}

class BalancedBinaryTree {

	/**
	 * Determine if a tree is height-balanced
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	/**
	 * Compute max depth of a tree
	 * @param node
	 * @return
	 */
	private int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
	}

	public static void main(String[] args) {
		// Make a test tree
		BinarySearchTree tree = new BinarySearchTree();
		int[] array = { 3, 1, 5, 2, 8 };
		for (int i : array) {
			tree.add(i);
		}
		System.out.println(tree.toString());

		// If tree is balanced
		BalancedBinaryTree test = new BalancedBinaryTree();
		System.out.println(test.isBalanced(tree.getRoot()));
	}

}

