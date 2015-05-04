class TwoSum {
	public int[] twoSum(int[] nums, int target){
		java.util.Arrays.sort(nums); 
		int i = 0, j = nums.length - 1; 
		while(i < j){
			int sum = nums[i] + nums[j]; 
			if(sum == target) return new int[]{i + 1, j + 1};
			if(sum < target) i ++; 
			else j --; 
		}
		return new int[2]; 
	} 

	public static void main(String[] args){
		int nums[] = {2,7,11,15};
		int target = 9; 
		System.out.println(java.util.Arrays.toString(new TwoSum().twoSum(nums,target)));
	}
}  
