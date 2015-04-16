
/*
 * Anagrams
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */

class Solution {

    public java.util.List<String> anagrams(String[] strs) {
    	
    	java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>(); 
    	java.util.List<String> list; 
    	for(String str: strs){
    		String sort = quickSort(str);  // Sort strings
    		if(map.isEmpty() || !map.containsKey(sort)){ 
    			list = new java.util.ArrayList<>(); 
    		}else{
    			list = map.get(sort); 
    		}
			list.add(str); 
			map.put(sort, list); 
    	}
    	
    	list = new java.util.ArrayList<>();
    	for(String s: map.keySet()){
    		if(map.get(s).size() > 1){
    			list.addAll(map.get(s)); 
    		}
    	}
    	return list;     
    }
    
    private String quickSort(String s){
    	char[] temp = s.toCharArray(); 
    	quickSort(temp, 0, temp.length - 1); 
    	return new String(temp); 
    }
    
    private void quickSort(char[] s, int start, int end){
    	if(end <= start) return; 
    	int i = start, j = end; 
    	char p = s[(start + end)/2]; 
    	while(i <= j){
    		while(s[i] < p) i ++; 
    		while(s[j] > p) j--; 
    		if(i <= j) swap(s, i ++ , j -- ); 
    	}
    	if(j > start) quickSort(s, start, j); 
    	if(i < end) quickSort(s, i, end); 
    }
    
    private void swap(char[] s, int i, int j){
    	char temp = s[i]; 
    	s[i] = s[j]; 
    	s[j] = temp; 
    }
	
    public static void main(String[] args) {
		String[] strs = {"cat", "dog", "tac", "god", "act", "a", "overturns","turnovers"}; 
		System.out.println(new Solution().anagrams(strs));
	}
}

