
/**
 * Maximum Sum Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
 * Maximum Product Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.  
 */

public class Solution {

	/**
	 * Maximum Sum Subarray
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
		System.out.println("[" + start + ":" + end + "]");
		return maxSoFar; 
	}
	
	/**
	 * Maximum Product Subarray
	 * @param num
	 * @return
	 */
	public int maxProduct(int[] num){
		
		int maxSoFar; 
		int maxPos, prevMaxPos; 
		int minNeg, prevMinNeg; 
	
		maxSoFar = maxPos = minNeg = num[0]; 	 
		
		for(int i = 1; i < num.length; i ++ ){
			prevMaxPos = maxPos; prevMinNeg = minNeg; 
			if(num[i] > 0 ){
				maxPos = prevMaxPos > 0 ? num[i]*prevMaxPos : num[i]; 
				minNeg = prevMinNeg <= 0 ? num[i]*prevMinNeg : num[i]; 
			}else{
				maxPos = prevMinNeg <= 0 ? num[i]*prevMinNeg : num[i]; 
				minNeg = prevMaxPos > 0 ? num[i]*prevMaxPos : num[i]; 	
			}

			if(maxPos >= maxSoFar) {
				maxSoFar = maxPos; 
			}
		}
		return maxSoFar; 
	}
	public static void main(String[] args) {
		Solution solution = new Solution(); 
		int[] num = {-1,-2,-2,-1,-3}; 
		System.out.print("Maximum Sum Subarray: ");
		System.out.println("Sum: " + solution.maxSubArray(num));
		System.out.println("**********************");
		System.out.println("Maximum Product Subarray");
		System.out.println("Product: " + solution.maxProduct(num));	
	}

}

