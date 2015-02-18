class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int val) {
		this.val = val;
	}
}

class BinarySearchTree {
	private TreeNode root;

	/**
	 * Build tree from array
	 * 
	 * @param array
	 */
	BinarySearchTree(int[] array) {
		for (int element : array) {
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

	/**
	 * Print tree
	 */
	public TreeNode getRoot() {
		return this.root;
	}

	private StringBuilder printTree(TreeNode node, int level) {
		StringBuilder sb = new StringBuilder();
		if (node == null) {
			return sb;
		}
		sb.append(printTree(node.right, level + 1));
		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				sb.append(".   ");
			}
			sb.append("+---" + node.val).append('\n');
		} else {
			sb.append(node.val).append('\n');
		}
		sb.append(printTree(node.left, level + 1));
		return sb;
	}

	public String printTree(TreeNode node) {
		return printTree(node, 0).toString();
	}

	/**
	 * Upside down binary tree
	 * 
	 * @param node
	 * @return
	 */
	public TreeNode UpsideDownBinaryTree(TreeNode node) {
		TreeNode newRoot = null, newRootRight = null, dummy = node;
		while (dummy != null) {
			TreeNode left = dummy.left;
			dummy.left = newRootRight;
			newRootRight = dummy.right;
			dummy.right = newRoot;
			newRoot = dummy;
			dummy = left;
		}
		return newRoot;
	}
}

class Solution {
	public static void main(String[] args) {
		int[] array = { 4, 2, 5, 1, 3 };
		BinarySearchTree tree = new BinarySearchTree(array);
		TreeNode root = tree.getRoot();
		System.out.println("Original Tree: ");
		System.out.println(tree.printTree(root));
		System.out.println("Flipped Tree: ");
		System.out.println(tree.printTree(tree.UpsideDownBinaryTree(root)));
	}
}

