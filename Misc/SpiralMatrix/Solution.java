
import java.util.*;

/**
 * Spiral Matrix Given a matrix of m x n elements (m rows, n columns), return
 * all elements of the matrix in spiral order.
 */

class SpiralMatrix {
	
	/**
	 * Print matrix in spiral order
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> output = new ArrayList<Integer>();
		if(matrix.length == 0) {
			return output; 
		}	
		int m = matrix.length, n = matrix[0].length; 
		int T = 0, B = m - 1; 
		int L = 0, R = n - 1; 
		int dir = 0; 
		while(T <= B && L <= R){
			if(dir == 0){
				for(int i = L; i <= R; i++){
					output.add(matrix[T][i]); 
				}
				T ++;    
			}
			else if(dir == 1){
				for(int i = T; i <= B; i++){
					output.add(matrix[i][R]); 
				}
				R -- ; 
			}
			else if(dir == 2){
				for(int i = R; i >= L; i--){
					output.add(matrix[B][i]); 
				}
				B --; 
			}
			else if(dir == 3){
				for(int i = B; i >= T; i --){
					output.add(matrix[i][L]); 
				}
				L ++ ; 
			}
			dir = (dir + 1)%4; 
		}
		return output;
	}
}

class Solution {

	public static void main(String[] args) {
		SpiralMatrix test = new SpiralMatrix(); 
		int[][] matrix = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		System.out.println("Matrix: ");
 		StringBuilder sb = new StringBuilder(); 
		for(int[] array: matrix){
			
			for(int i: array){
				sb.append(i).append('\t');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
		System.out.println("Print matrix in spiral order: ");
                sb = new StringBuilder(); 
		for(int i: test.spiralOrder(matrix)){
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

}

