/*
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 */
import java.util.*;
 
class FourSum{
	public List<List<Integer>> fourSum(int[] nums, int target){
		Set<List<Integer>> out = new HashSet<>(); 
		Arrays.sort(nums); 
		
		for(int i = 0; i < nums.length - 3; i ++){
			for(int j = i + 1; j < nums.length - 2; j ++){
				int m = j + 1, n = nums.length - 1; 
				while(m < n){
					int sum = nums[i] + nums[j] + nums[m] + nums[n]; 
					if(sum == target){
						List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
					out.add(temp); 
					}
					if(target > sum) m ++; 
					else n --; 
				}
			}
		}
		return new ArrayList<>(out); 
	}
	
	public static void main(String[] args){
		int[] nums = {1,0,-1,0,-2,2}; 
		int target = 0; 
		System.out.println(new FourSum().fourSum(nums,target)); 
	}
}  

