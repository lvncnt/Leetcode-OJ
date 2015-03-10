/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. 
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example, 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 *
 */

public class Solution {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		if(obstacleGrid == null || obstacleGrid.length == 0) return 0; 
		
		int m = obstacleGrid.length, n = obstacleGrid[0].length; 
		int[][] mat = new int[m + 1][n + 1]; 
		mat[m - 1][n] = 1; 
		for(int r = m - 1; r >= 0; r--){
			for(int c = n - 1; c >= 0; c--){
				mat[r][c] = obstacleGrid[r][c] == 1 ? 0: mat[r + 1][c] + mat[r][c + 1]; 
			}
		}
		return mat[0][0]; 
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}}; 
		System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
	}

}
