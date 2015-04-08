
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class Solution {
	
	    /*
	    * Subsets 
	    * Given a collection of integers that might contain duplicates, S
	    * return all possible subsets. 
	    */ 
	    public List<List<Integer>> subsetsWithDup(int[] num) {
	    	List<List<Integer>> out = new ArrayList<>(); 
			out.add(new ArrayList<Integer>()); 
			Arrays.sort(num); 
		
			for(int i: num){
				int len = out.size(); 
				for(int j = 0; j < len; j++){
					List<Integer> list = new ArrayList<>(out.get(j));  // clone the sets in 'out' list
					list.add(i); // add i to each of these cloned sets
					if(!out.contains(list))out.add(list); // 
				}
			}
		
			return out; 
	    }
	
	public static void main(String[] args) {

		Solution test = new Solution(); 

		int[][] testcases = {{1,2,3}, {1,2,2}}; 
		for(int[] S:testcases){
			System.out.println(test.subsetsWithDup(S));
		}
	}

}

