
/*
 *
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 */

class Solution {
	
	boolean isPalindrome(String s){
		s = s.toLowerCase(); 
		int i = 0; 
		int j = s.length() - 1; 
		while(i < j){
			while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i ++; 
			while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j --; 
			if(s.charAt(i) != s.charAt(j)) return false; 
			i++; 
			j--; 
		}
		return true; 
	}
	
 
	
	public static void main(String[] args) {
		
		String s = "A man, a plan, a canal: Panama"; 
		//s = "race a car"; 
		System.out.println(new Solution().isPalindrome(s));
		
	}
	

}

