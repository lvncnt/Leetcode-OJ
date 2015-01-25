/*
 * Compute and return the square root of x
 */

class Sqrt {
	
	public int sqrt(int x){
		double x0 = 1, x1; 
		while(true){
			x1 = (x0 + x/x0)/2; 
			if(Math.abs(x1 - x0) < 1e-6)break; 
			x0 = x1; 
		}
		return (int)x1; 
	}
	
	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]); 
		System.out.println(new Solution().sqrt(x)); 

	}

}
