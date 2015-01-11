public class Solution {

	/** O(nm) runtime, O(1) space – Brute force: */ 
	
	public int strStr(String haystack, String needle){
		
		int m = needle.length(); 
		int n = haystack.length(); 
		if( m == 0) return 0; 
		if( m > n || (n == 0 && m != 0)) return -1; 
		
		int index; 
		for(int i = 0; i < n ; i++){
			int j = 0; 
			index = i; 
			// check length of remaining haystack: if enough to hold needle
			if(n - index >= m ){
				while(haystack.charAt(index) == needle.charAt(j) && j < m ){
					if(j + 1 == m) return i; 
					index ++; j ++;
				}
			}
			
		}
		return -1 ; 

	}
}
