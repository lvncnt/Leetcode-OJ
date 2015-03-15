
/**
 * Search in Rotated Sorted Array  
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. 
 * If found in the array return its index, otherwise return -1.
 *
 */

public class Search {
	
	/**
	 * Search in Rotated Sorted Array (w/ duplicates) 
	 * @param num
	 * @param target
	 * @return
	 */
	public int searchWithDuplicates(int[] num, int target){
		int start, end, mid; 
		start = 0; end = num.length - 1; 
		while(start <= end){
			mid = (start + end )/2; 
			if(num[mid] == target)return mid; 
			
			if(num[start] == num[mid] && num[mid] == num[end]){
				start ++; end --; 
			}
			else if(num[start] <= num[mid]){
				if(num[start] <= target && target < num[mid])end = mid - 1; 
				else start = mid + 1; 
			}else if(num[start] > num[mid]){
				if(num[mid] < target && target <= num[end]) start = mid + 1; 
				else end = mid - 1; 
			}
		}
		return -1; 
	}
	
	public static void main(String[] args) {
		Search s = new Search(); 
		int[] num = {1,3,6,7,1};
		int[] targets = {1,3,6,7,1};

		for(int target : targets){
			System.out.println(target + "@ " + s.searchWithDuplicates(num, target));
		}
	}
}

