
/*
 * Compute and return the square root of x
 */

class Solution {
	
	public double sqrt(int x){
		double x0 = 1, x1; 
		while(true){
			x1 = (x0 + x/x0)/2; 
			if(Math.abs(x1 - x0) < 1e-6)break; 
			x0 = x1; 
		}
		return x1; 
	}
	
	public static void main(String[] args) {	
		int x = 8; 
		System.out.printf("sqrt(%d) = %.2f\n", x, new Solution().sqrt(x)); 
		System.out.println(Math.sqrt(x));
	}

}

