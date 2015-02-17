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

/**
 * Binary search tree
 */
class BinarySearchTree {
	TreeNode root;

	/** Construct tree from array */
	BinarySearchTree(int[] array) {
		for (Integer element : array) {
			if (root == null) {
				root = new TreeNode(element);
			} else {
				add(root, element);
			}
		}
	}

	private void add(TreeNode node, int element) {
		if (element < node.val) {
			if (node.left == null) {
				node.left = new TreeNode(element);
				return;
			}
			add(node.left, element);
		} else {
			if (node.right == null) {
				node.right = new TreeNode(element);
				return;
			}
			add(node.right, element);
		}
	}

	/** Print tree structure */
	public String toString() {
		return toString(root);
	}

	private String toString(TreeNode node) {
		if (node == null) {
			return null;
		}
		return "[" + toString(node.left) + "," + node.val + ","
				+ toString(node.right) + "]";
	}

	/** Return root */
	public TreeNode getRoot() {
		return root;
	}
}

/**
 * Binary Tree Maximum Path Sum Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 */
class MaxPathSum {
	private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		pathSum(root);
		return maxSum;
	}

	private int pathSum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left, right;
		left = pathSum(node.left);
		right = pathSum(node.right);
		maxSum = Math.max(left + right + node.val, maxSum);
		int max = node.val + Math.max(left, right);
		return max > 0 ? max : 0;
	}
}

class Solution {
	public static void main(String[] args) {
		System.out.println("Construct test tree ... ");
		int[] array = {2, -1, 4};
		BinarySearchTree tree = new BinarySearchTree(array);
		System.out.println(tree.toString());

		System.out.println("Compute maximum path sum ... ");
		System.out.println(new MaxPathSum().maxPathSum(tree.getRoot()));
	}
}

