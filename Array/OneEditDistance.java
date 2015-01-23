/*
 * One Edit Distance
 * Given two string s1 and s2, determine if they are both one edit distance apart. 
 */

class OneEditDistance {
	/** One Edit Distance */ 
	public boolean isOneEditDistance(String s1, String s2 ){
		int m = s1.length(), n = s2.length(); 
		if(m > n) return isOneEditDistance(s2, s1); 
		if(n - m > 1) return false; 
		int i = 0, shift = n - m ;
		while(i < m && s1.charAt(i) == s2.charAt(i)) i ++; 
		if( i == m ) return shift > 0;  // if s1 equals s2, shift = 0, return F
		if(shift == 0) i++;  
		while(i < m && s1.charAt(i) == s2.charAt(i + shift)) i++; 
		return i == m;  
	}

	public static void main(String[] args) {
		// -------- One Edit Distance -------
		String[][] testCase2 = {{"abcdef", "abXde"}, {"a", "b"}, {"", ""}};
		for(String[] s: testCase2){
			System.out.print(new OneEditDistance().isOneEditDistance(s[0], s[1]) + " ");
		}
	}

}
