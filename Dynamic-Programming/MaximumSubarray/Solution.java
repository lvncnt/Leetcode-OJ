
/**
 * Maximum Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
 */
public class Solution {

	/**
	 * Kadane's algorithm
	 * @param num
	 * @return
	 */
	public int maxSubArray(int[] num){
		int maxEndHere, maxSoFar, start, end, startSoFar; 
		maxEndHere = maxSoFar = num[0]; 
		start = end = startSoFar = 0; 
		for(int i = 1; i < num.length; i++){
			maxEndHere = Math.max(num[i], num[i] + maxEndHere); 

			if(maxEndHere < 0){	
				startSoFar = i + 1; 
			}
			
			if(maxEndHere > maxSoFar){
				maxSoFar = maxEndHere; 
				start = startSoFar; 
				end = i; 
			}

		}
		System.out.println("Subarray: [" + start + ":" + end + "]");
		return maxSoFar; 
	}
	
	public static void main(String[] args) {
		int[] num = {-2,1,-3,4,-1,2,1,-5,4}; 
		System.out.println(new Solution().maxSubArray(num));
	}
}
