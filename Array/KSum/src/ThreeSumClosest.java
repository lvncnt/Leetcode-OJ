/**
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * */ 

import java.util.*; 

class ThreeSumClosest{
	public int threeSumClosest(int[] nums, int target){
		Arrays.sort(nums); 
		int closest = 0, min = Integer.MAX_VALUE; 
		for(int i= 0; i < nums.length - 2; i ++){
			int j = i + 1, k = nums.length - 1; 
			while(j < k){
				int sum = nums[i] + nums[j] + nums[k]; 
				if(Math.abs(sum - target) < min){
					closest = sum ;
					min = Math.abs(sum - target); 
				}
				if(sum < target ) j ++; 
				else k --; 
			}
		}
		return closest; 
	}
	
	public static void main(String[] args__){
		int nums[] = {1,1,-1,-1,3}, target = -1; 
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, target)); 
	}
} 
