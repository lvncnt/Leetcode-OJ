 

/**
 * Given an MX N matrix in which each row and each column is sorted 
 * in ascending order, write a method to find an element.
 **/

class Main {
	
	/* Step-wise Linear Search */ 
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) return false; 
		int row, col; 
		row = 0; col = matrix[0].length - 1; 
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == target) return true; 
			else if(matrix[row][col] > target) col --; 
			else row ++; 
		}
        return false; 
    }

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7}, {10, 11, 16, 20}, {23, 30, 34, 50}};  
		for(int[] targets : matrix){
			for(int target: targets){
				System.out.printf("%s ", new Main().searchMatrix(matrix, target));
			}
			System.out.println(); 
		}
	}
}

