/** Implement atoi to convert a string to an integer. */ 
class Solution {
	
	public int atoi(String str){
		int i = 0, len = str.length(), sign = 1; 
		while(i < len && str.charAt(i) == ' ') i ++; 	 
		if(i < len && str.charAt(i) == '+') i++ ; 		 
		else if(i < len && str.charAt(i) == '-') {
			sign = -1; i++; 
		}
 
		int output = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE; 
		int digit; 
		while(i < len && Character.isDigit(str.charAt(i))){
			digit = Character.getNumericValue(str.charAt(i)); 
			if(output > max/10 || ( output == max/10  && digit >=8)) 
				return (sign == 1) ? max : min; 
			output = output * 10 + digit;  
			i ++; 
		}
 
		return (sign == 1) ? output : -output; 
	}

	public static void main(String[] args) {
		
		String str = "  -67q1-5889a";  // -67
		System.out.println("__" + new Solution().atoi(str) + "__");

	}
}
