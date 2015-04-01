class Main {

	public static void main(String[] args) {
		TreeNode root = null; 
		int sum = 0; 
		System.out.printf("=>Check if tree {%s} has a root-to-leaf path with sum %d\n",root, sum); 
	
		PathSumI test1 = new PathSumI(); 
		System.out.println( test1.hasPathSum(root, sum));

		root = new TreeNode(1); 
		root.left = new TreeNode(-2); 

		PathSumII test2= new PathSumII(); 
		sum = -1; 

		System.out.println("=>Tree: {1,-2}"); 
		System.out.printf("=>Print the root-to-leaf path with sum %d\n%s\n", sum, test2.pathSum(root, -1)); 
	}
}
