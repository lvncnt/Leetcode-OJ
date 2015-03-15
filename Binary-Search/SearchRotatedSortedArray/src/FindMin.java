

/**
 * Find Minimum in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 *
 */

public class FindMin {
	
	public int findMin(int[] num){
		
		int start, end, mid; 
		start = 0; end = num.length - 1; 
		while(start < end && num[start] >= num[end]){ 
			mid = (start + end)/2; 
			
			if(num[start] == num[mid] ){ 
				start ++;  
			}
			else if(num[start] < num[mid]){
				start = mid + 1; 
			}else{
				end = mid ; 
			}
		}
		return num[start]; 
	}
	
	public static void main(String[] args) {
		int[] num = {4,5,6,7,0,1};
		System.out.println(new FindMin().findMin(num));

	}

}

