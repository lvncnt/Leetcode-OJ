
/** Validate if a given string is numeric. */  

class Solution(){
  
  public boolean isNumber(String s){
    int i = 0, len = s.length(); 
    boolean output = false; 
    
    while(i < len && s.charAt(i) == ' ') i ++ ; 
    
    if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-' )) i ++; 
    
    while(i < len && Character.isDigit(s.charAt(i))){
      i ++; output = true; 
    } 
    
    if(i < len && s.charAt(i) == '.'){
      i++; 
      while(i < len && Character.isDigit(s.charAt(i))){
        i ++; output = true; 
      } 
    }
    
    if(output && i < len && (s.charAt(i) == 'e' || s.charAt(i) == 'E')){
      i ++; output = false; 
      if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-' )) i ++; 
      while(i < len && Character.isDigit(s.charAt(i))){
        i ++; output = true; 
      } 
    }
    
    while(i < len && s.charAt(i) == ' ') i ++; 
    return output && i == len; 
  }
  
	public static void main(String[] args) {
	  /** test cases */ 
		String[][] testCase = {{"0", " 0.1 ", " 2e10"}, {"1 a", "abc", " "}};
		for(int i = 0; i < testCase.length; i++ ){
			for(String s : testCase[i]){
				System.out.print(new Solution().isNumber(s) + " ");
			}			
			System.out.println();
		}
	}
}
  
  
