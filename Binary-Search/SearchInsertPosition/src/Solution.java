
/**
 * Search Insert Position 
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if
 * it were inserted in order.
 * @author LVNCNT
 *
 */
public class Solution {

	StringBuilder sb = new StringBuilder(); 
	boolean isFound; 
	public int searchInsert(int[] num, int target){
		int start, mid, end; 
		start = 0; 
		end = num.length - 1; 
		
		while(start <= end){
			mid = (start + end)/2;
			if(num[mid] == target){
				isFound = true;
				return mid; 
			}
			if(num[mid] < target){
				start = mid + 1; 
			}else{
				end = mid - 1; 
			}			 
		}
		isFound = false; 
		return end + 1; 
	}
	
	public static void main(String[] args) {
		int[] num = {2,4,6,8,10};
		int[] target = {1,2,3,4,5,6,7,8,9,10};
		Solution solution = new Solution(); 
		
		for(int i : target){
			int index = solution.searchInsert(num, i); 
			String s= " -> Found at "; 
			if(!solution.isFound)s = " -> Not Found -> Insert at "; 
			solution.sb.append(i + s).append(index).append('\n'); 
		}
		System.out.println(solution.sb.toString());
	}
}

