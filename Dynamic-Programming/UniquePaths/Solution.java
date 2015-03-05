
/**
 * Unique Paths
 * A robot is located at the top-left corner of a m x n grid: 
 * Compute the number of unique paths to reach the bottom-right corner of the grid 
 * The robot can only move either down or right at any point in time. 
 *
 */

public class Solution {
	
	/**
	 * bottom-up DP
	 * @param m
	 * @param n
	 * @return
	 */
	public long uniquePaths(int m, int n){
		long[][] mat = new long[m + 1][n + 1]; 
		mat[m - 1][n] = 1; 
		for(int r = m -1; r >= 0; r--){
			for(int c = n - 1; c >= 0; c--){
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1]; 
			}
		}
		return mat[0][0]; 
	}
	
	public static void main(String[] args) {
		Solution test = new Solution(); 

		try{
			int m, n; 
			m = Integer.parseInt(args[0]); 
			n = Integer.parseInt(args[1]);  
			System.out.println("Number of unique paths: " + test.uniquePaths(m, n));
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Missing grid number (m X n)...");
		}catch(NumberFormatException e){
			System.out.println("Invalid number ... ");
		}

	}
	
	

}

