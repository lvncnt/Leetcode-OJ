
import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II 
 * Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum. 
 */

class PathSumII{
	/**
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		int[] path = new int[depth(root)]; 
		List<List<Integer>> lists = new ArrayList<>(); 
		pathSum(root, sum, path, 0, lists); 
		return lists; 
	}
	
	private void pathSum(TreeNode node, int sum, int[] path, int level, List<List<Integer>> lists){
		if(node == null) return;
		path[level] = node.val; 
		if(node.left == null && node.right == null){
			int t = 0; 
			for(int i = level; i >= 0; i--) t += path[i]; 	
			if(t == sum) lists.add(add(path, level));
		}
		pathSum(node.left, sum, path, level + 1,lists); 
		pathSum(node.right, sum, path, level + 1,lists ); 	
	}

	private List<Integer> add(int[] path, int end){
		List<Integer> list = new ArrayList<>(); 
		for(int i=0 ; i<= end; i++ ) list.add(path[i]); 
		return list; 
	}
	
	private int depth(TreeNode node){
		if(node == null) return 0; 
		return Math.max(depth(node.left), depth(node.right)) + 1; 
	}
}

