/*
 * Edit Distance
 * Given two words s1 and s2, 
 * find the minimum number of operations required to convert s1 to s2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 */
 
class EditDistance {
	/** Edit Distance */ 
	public int minDistance(String s1, String s2){
		int m = s1.length(), n = s2.length(); 
		if(m == 0) return n; 
		if(n == 0) return m; 
		int[][] dp = new int[m + 1][n + 1]; 
		// initialize matrix
		for(int i = 1; i < m + 1; i ++ ) dp[i][0] = i; 
		for(int j = 1; j < n + 1; j ++ ) dp[0][j] = j; 
		// dynamic programming
		for(int i = 1; i < m + 1; i++){
			for(int j = 1; j < n + 1; j ++ ){
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1]; 
				else{
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
				}
			}
		}
		return dp[m][n]; 
	}
	
	public static void main(String[] args) {

		// -------- Edit Distance ----------
		String[][] testCase2 = {{"abcde", "abcXde"}, {"a", "b"}, {"", ""}}; 
		for(String[] s: testCase2){
			System.out.print(new EditDistance().minDistance(s[0], s[1]) + " ");
		}
	}

}
