/** Implement atoi to convert a string to an integer. */ 
class Solution {
	
	public int atoi(String str){
		if(str == null || str.length() == 0) return 0; 

		int i = 0, len = str.length();
		boolean isNeg = false; 
 
		while(i < len && str.charAt(i) == ' ') i ++;
		 	 
		if(i < len && str.charAt(i) == '+') i++ ; 		 
		else if(i < len && str.charAt(i) == '-') {
			isNeg = true; i++; 
		}
 
		int output = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE; 
		int digit; 
		while(i < len && Character.isDigit(str.charAt(i))){
			digit = Character.getNumericValue(str.charAt(i)); 
			if(output > max/10 || ( output == max/10  && digit >=8)) 
				return isNeg ? min : max; 
			output = output * 10 + digit;  
			i ++; 
		}
 
		return  isNeg ?  -output : output; 
	}

	public static void main(String[] args) {
		
		String str = "  -67q1-5889a";  // -67
		System.out.println(">" + new Solution().atoi(str) + "<");

	}
}
