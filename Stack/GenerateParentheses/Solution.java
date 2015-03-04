
import java.util.ArrayList;
import java.util.List;

/**
 * GenerateParentheses
 * Given n pairs of parentheses
 * generate all combinations of well-formed parentheses. 
 *
 */

class GenerateParentheses{
	private List<String> list = new ArrayList<String>();
	 
	public List<String> generateParenthesis(int n){
		StringBuilder sb = new StringBuilder(); 
		recur(n, 0, 0, sb); 
		return list; 
	}
	
	private void recur(int n, int l, int r, StringBuilder sb){		
		if(l == n){
			int i = n - r; 
			while(i-- > 0){ 
				sb.append(")"); 				 
			}
			list.add(sb.toString()); 
			return; 
		}
		if(l == r){
			recur(n, l + 1, r, new StringBuilder(sb).append("(")); 
		} else{
			recur(n, l + 1, r, new StringBuilder(sb).append("(")); 
			recur(n, l , r + 1, new StringBuilder(sb).append(")")); 
		}
	}
}

class Solution {

	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses(); 
		
		try{
			int n = Integer.parseInt(args[0]); 
			System.out.println(test.generateParenthesis(n));
		}catch(NumberFormatException e){
			System.out.println("Invalid Number" + args[0]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Missing Number In Argument List");
		}		
	}
}

