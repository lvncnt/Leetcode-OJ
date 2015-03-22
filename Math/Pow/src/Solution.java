
/**
 * Pow(x, n)
 * Implement pow(x, n).
 *
 */

class Solution {

	
	/**
	 * @param x
	 * @param n
	 * @return
	 */
	public double pow(double x, int n){
		if(x == 0) return 0;
		if(n == 0) return 1; 
		boolean isNeg = false; 
		if(n<0){
			isNeg = true; n = -n; 
		}

		double output, half; 
		half = pow(x,n/2); 
		output = (n%2 == 0) ? half*half : half*half*x ;  
		return isNeg ? 1/output : output; 		
	}
	
	public static void main(String[] args) {
		double x = -2; 
		int n = -6; 
		System.out.printf("%.2f^%d = %.2f\n", x, n, new Solution().pow(x, n));
		
	}

}

