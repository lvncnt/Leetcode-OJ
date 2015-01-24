package reverseInteger;

/*
 * Reverse digits of an integer.
 */
class ReverseInteger {
	
	public int reverse(int x){
		boolean flag = true;  // + 
		if(x < 0){
			flag = false; 
			x = -x; 
		}
		
		int output = 0, max = -(1<<31) - 1; 
		while(x > 0){
			if(output > max/10) return 0;  // overflow 
			output  = output * 10 + x%10; 
			x/=10; 
		}
		return flag?output:-output; 
	}
	
	public static void main(String[] args) {
		int[] testCase = {-123, 100, 1000000003, -2147483412}; 
		for(int x: testCase){
			System.out.print(new ReverseInteger().reverse(x) + " ");
		}
	}

}
