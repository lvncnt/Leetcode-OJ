/*
 * 
 * Reverse Words in a String 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue", return "blue is sky the".
 * 
 */
class Solution {
	
	/** O(n) runtime */ 
	public String reverseWords(String s){
		StringBuilder reversed = new StringBuilder(); 
		int i = s.length() - 1 ;
		int count; 
		while(i >= 0){
			while(i >= 0 && s.charAt(i) == ' ' ) i --; 
			count = 0; 
			while(i >= 0 && s.charAt(i) != ' ') {
				count ++; i --; 
				if(i < 0 || s.charAt(i ) == ' ') reversed.append(' ').append(s.substring(i + 1, i + 1 + count)) ; 
			}
		}
		return reversed.length() == 0 ? "":reversed.toString().substring(1); 
	}
	
	/** Test case */ 
	public static void main(String[] args) {
		
		String s = "  the sky is blue  "; 
		System.out.println(new Solution().reverseWordsI(s));
		
	}

}
