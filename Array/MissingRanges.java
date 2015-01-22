import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array where the range of the elements are [start, end] inclusive, 
 * Return its missing ranges. 
 */
 
class Solution {
	
	public List<String> findMissingRanges(int[] array, int start, int end ){
		List<String> output = new ArrayList<String>(); 
		int curr, prev  = start - 1 ; 
		for(int i = 0; i <= array.length; i ++ ){
			curr = (i == array.length )? end + 1 : array[i];
			if(curr - prev == 2)output.add("" + (prev + 1)); 
			if(curr - prev > 2) output.add("" + (prev + 1) + "->" + (curr - 1)); 
			prev = curr; 
		}
		return output; 
	}
	
	public static void main(String[] args) {
		
		int[][] testCase = {{2, 4, 5, 50, 75}, {}}; 
		int start = 0, end = 99; 
		for(int[] array: testCase){
			System.out.println(new Solution().findMissingRanges(array, start, end ));
		}
	}
}
