package longestPalindrome;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * Assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

class Solution {
	
	public String longestPalindrome(String s ){
		int odd, even, len;
		int start = 0, end = 0; 
		for(int i = 0; i < s.length(); i ++ ){
			
			odd = expand(s, i , i); 
			even = expand(s, i , i + 1); 
			len = Math.max(odd, even); 
			if(len > end - start){
				start = i - (len - 1)/2; 
				end = i + len/2; 
			}
		}
		
		return s.substring(start, end + 1); 
	}
	
	private int expand(String s, int left, int right ){
		
		while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
			left --; right ++; 
		}
		return right - left - 1 ; 
	}
	public static void main(String[] args) {
		
		String[] testCase = {"cabaa", "abacdfgdcaba", "a"};
		for(String s : testCase){
			System.out.println(new Solution().longestPalindrome(s)); 
		}
		
	}
}
