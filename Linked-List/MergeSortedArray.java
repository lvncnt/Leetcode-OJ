package mergeSortedArray;

/*
 * Merge Sorted Array
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B. 
 */

class MergeSortedArray {
	
	static int[] A = new int[6]; 
	static int[] B = {4, 5, 6}; 
	
	/** merge B into A */ 
	public void merge(int[] A, int m, int[] B, int n){
		// m, n: number of elements initialized in A, B 
		int i = m - 1, j = n - 1, x = m + n - 1; 
		while(i >= 0 && j >= 0){
			if(A[i] >= B[j]){
				A[x] = A[i]; 
				i--; 
			}
			else{
				A[x] = B[j]; 
				j--; 
			}
			x--; 
		}

		// no need for checking i: order of the remaining elements in A is still preserved.
		while(j >= 0){
			A[x] = B[j]; 
			j--; 
			x--; 
		}
	}
	
	public static void main(String[] args) {
		A[0] = 1; A[1] = 2; A[2] = 3; 
		int m = 3, n = B.length; 
		new MergeSortedArray().merge(A, m, B, n); 
		for(int i: A)System.out.print(i + " ");
	}

}
