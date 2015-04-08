
public class Solution {
	
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. 
	 * In how many distinct ways can you climb to the top? 
	 */
	public int climbStairsDPI(int n){	
		if(n < 0) return 0; 
		int[] x = {1,1}; 
		int temp; 
		for(int i = 2; i <= n; i++){
			temp = x[0] ; 
			x[0] = x[1]; 
			x[1] += temp; 
		}
		return x[1]; 
	}

	
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 step, 2 steps or 3 steps. 
	 * In how many distinct ways can you climb to the top? 
	 */
	public int climbStairsDPII(int n){
		if(n < 0) return 0; 
		if(n == 0) return 1; 
		int[] x = {0,0,1};
		int i; 
		for(i = 1; i <= n; i++){
			x[(i - 1)%3] = x[0] + x[1] + x[2]; 
		}
		return x[(i - 2)%3]; 
	}

	public static void main(String[] args) {
		Solution test = new Solution(); 
		int n = 6; 
		System.out.println("Given n: " + n);
		System.out.println("Number of ways (up to 2 steps): " + test.climbStairsDPI(n));
		System.out.println("Number of ways (up to 3 steps): " + test.climbStairsDPII(n));
	}
}

