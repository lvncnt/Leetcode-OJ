
/*
 * Longest Substring Without Repeating Characters 
 * Given a string, find the length of the longest substring without repeating characters. 
 *  */
 
class Solution {
	public int lengthOfLongestSubstring(String s){
		Map<Character, Boolean> map = new HashMap<Character, Boolean>(); 
		int start = 0, maxLen = 0 ; 
		for(int i = 0; i < s.length(); i ++ ){
			while(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))){
				map.replace(s.charAt(start), false); 
				start ++; 
			}
			map.put(s.charAt(i), true); 
			maxLen = Math.max(i - start + 1, maxLen);
		}
		return maxLen; 
	}
}
