
class Solution {

	/**
	 * Rotate Array
 	 * Rotate an array of n elements to the right by k steps.
	 * @param nums
	 * @param k
	 */
	public void rotateArray(int[] nums, int k){
		if(nums == null || nums.length <= 1)return; 
		
		int n = nums.length; 
		if(k > n)k%=n; 
		
		reverse(nums, 0, n - k - 1); 
		reverse(nums, n - k, n - 1); 
		reverse(nums, 0, n - 1); 
	}
	
	private void reverse(int[] nums, int start, int end){
		int temp; 
		while(start < end){
			temp = nums[start]; 
			nums[start] = nums[end]; 
			nums[end] = temp; 
			start ++; 
			end --; 
		}
	}


	/**
          * Rotate Image
          * Given an n x n 2D matrix representing an image.
          * write a method to rotate the image by 90 degrees (clockwise).
	  * @param matrix
	  */
	public void rotateMatrix(int[][] matrix){
		
		int n = matrix.length; 
		assert n == matrix[0].length: "Unequal Dimension"; 
		
		if(n <= 1) return; 
		int temp; 
		for(int i = 0; i < n/2; i++){  
			for(int j = i; j < n - i - 1; j++){  
				temp = matrix[i][j]; 
				matrix[i][j] = matrix[n - 1 - j][n - 1 - (n - 1 - i)]; 
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; 				
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; 
				matrix[j][n - 1 - i] = temp; 
			}
		}
	}
 
	public static void main(String[] args) {
                System.out.println("#### Test Rotate Array ####");
		int[] nums = {1,2,3,4,5,6,7};
		System.out.println("Original Array: \n" + java.util.Arrays.toString(nums));
		System.out.println("\nRotated Array:");
		for(int k = 1; k <= nums.length + 1; k++){
			new Solution().rotateArray(nums, k);
			System.out.println(k + "=>"+ java.util.Arrays.toString(nums));
		}

		System.out.println("#### Test Rotate Matrix ####");
		int[][] array = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}, {13,14,15,16}};
		System.out.println("Original array: ");
		for(int[] arr : array){
			System.out.println(java.util.Arrays.toString(arr));
		}
		
		
		System.out.println("\nRotated array (90 degree clockwise): ");
		new Solution().rotateMatrix(array);
		for(int[] arr : array){
			System.out.println(java.util.Arrays.toString(arr));
		}
	}
}

