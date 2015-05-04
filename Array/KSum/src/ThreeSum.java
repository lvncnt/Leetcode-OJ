import java.util.*;
/**
 * 3Sum Given an array S of n integers, are there elements a, b, c in S such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero. Note: - Elements in a triplet (a,b,c) must be in non-descending
 * order. (ie, a ≤ b ≤ c) - The solution set must not contain duplicate
 * triplets.
 *
 */

class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] num){
		Arrays.sort(num);
		Set<List<Integer>> set = new HashSet<>(); 
		int i, j, k; 
		for(i = 0; i < num.length; i++){
			j = i + 1; k = num.length - 1; 
			while(j < k){
				int sum = num[i] + num[j] + num[k]; 
				if(sum < 0){
					j++; 
				}else if(sum > 0){
					k--; 
				}else{
					List<Integer> val = new ArrayList<>();
					val.add(num[i]);					 
					val.add(num[j]);
					val.add(num[k]);
					set.add(val);
					j++; 
					k--; 
				}
			}
		}
		return new ArrayList<List<Integer>>(set); 
	}

	public static void main(String[] args) {
		int[] num = {-1,-1,-1,0,2,2};		 
		System.out.println(new ThreeSum().threeSum(num));
	}
}
