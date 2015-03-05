

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top? 
 * @author lvncnt
 *
 */

public class Solution {
	
	public int climbStairs(int n){	
		int i, array[] = {1,1};
		for( i = 2; i <= n; i++) array[(i-1)%2] = array[0] + array[1]; 
		return array[i%2]; 
	}

	public static void main(String[] args) {
		Solution test = new Solution(); 
		try{
			int n = Integer.parseInt(args[0]); 
			System.out.println("Number of ways: " + test.climbStairs(n));
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Missing stair number...");
		}
		catch(NumberFormatException e){
			System.out.println("Invalid stair number ... ");
		}
		
	}

}

