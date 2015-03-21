
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for tree node
 * 
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

/**
 * Definition for binary tree
 * 
 */
class BinaryTree{
	
	private TreeNode root; 
	
	public void add(int val){
		if(root == null){
			root = new TreeNode(val); 
			return; 
		}
		add(root, val); 
	}
	
	private void add(TreeNode node, int val){
		if(node == null)return; 
		if(node.left == null){
			node.left = new TreeNode(val); 
		}else if(node.right == null){
			node.right = new TreeNode(val); 
		}else{
			add(node.left, val); 
		}		
	}
	
	public String toString(){
		return toString(root); 
	}
	
	private String toString(TreeNode node){
		if(node == null) return null; 
		return "[" + toString(node.left) + "," + node.val + "," + toString(node.right) + "]"; 
	}
	
	public TreeNode getRoot(){
		return root; 
	}
	
	private int depth(TreeNode node){
		if(node == null)return 0; 
		return Math.max(depth(node.left), depth(node.right)) + 1; 
	}
	
	public int getDepth(){
		return depth(root); 
	}
}

public class Solution {
	
	/**
	 * Given a binary tree, return the level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level).
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> output = new ArrayList<>(); 
    	if(root == null) return output; 
    	
    	List<Integer> list = new ArrayList<>(); 
    	Queue<TreeNode> queue = new LinkedList<>(); 
    	TreeNode dummy = root; 
    	int current, next; 
    	current = next = 0; 
    	queue.add(dummy); 
    	current ++; 
    	  
    	while(!queue.isEmpty()){
    		queue.poll();    
    		list.add(dummy.val);
    		current --; 
    		if(dummy.left != null){
    			queue.add(dummy.left); 
    			next ++; 
    		}
    		if(dummy.right != null){
    			queue.add(dummy.right); 
    			next ++; 
    		}
    		if(current == 0){
    			//System.out.println();
    			output.add(list); 
    			list = new ArrayList<>(); 
    			current = next;
    			next = 0; 
    		}
    		dummy = queue.peek(); 
    	}
        return output; 
    }
    
    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
     * (ie, from left to right, level by level from leaf to root).
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root){
    	List<List<Integer>> output = new ArrayList<>(); 
    	if(root == null) return output; 
    	Queue<TreeNode> queue= new LinkedList<>(); 
    	List<Integer> list = new ArrayList<>(); 
    	int curr, next; 
    	curr = next = 0; 
    	
    	queue.add(root); 
    	curr ++; 
    	while(!queue.isEmpty()){

    		TreeNode temp = queue.poll(); 
    		curr --; 
    		list.add(temp.val); 
    		if(temp.left != null){
    			queue.add(temp.left); 
    			next ++; 
    		}
    		if(temp.right != null){
    			queue.add(temp.right); 
    			next ++; 
    		}
    		if(curr ==0){
    			curr = next; 
    			next = 0; 
    			output.add(0, list); 
    			list = new ArrayList<>(); 
    		}  
    	} 
    	return output;
    }
    
    public static void main(String[] args) {
    	BinaryTree tree = new BinaryTree(); 
    	int[] num = {3,9,20,15,7};
    	for(int i: num)tree.add(i);

    	System.out.println("\nBinary Tree: ");
     	System.out.println(tree.toString());
    	System.out.println("\nLevel Order Traversal: ");
     	System.out.println(new Solution().levelOrder(tree.getRoot()));
     	System.out.println(new Solution().levelOrder(null));
     	
     	System.out.println("\nReverse Order Traversal: ");
     	System.out.println(new Solution().levelOrderBottom(tree.getRoot()));
	}
}


