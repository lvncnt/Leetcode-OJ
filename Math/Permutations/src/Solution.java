
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Permutations  
Given a collection of numbers, return all possible permutations.
 */

class Solution {
	
	public List<List<Integer>> permutations(int[] num){
		List<List<Integer>> out = new ArrayList<>(); 
		Arrays.sort(num);  
		do{
			List<Integer> list = new ArrayList<>(); 
			for(int i: num)list.add(i); 
			out.add(list);
		}while(nextPermutation(num)); 
		return out; 
	}
	
	private boolean nextPermutation(int[] num){
		
		int i, j, k, l; 
		
		for(i = num.length - 1; i >= 1; i --){
			if(num[i - 1 ] < num[i])break; 
		}

		if(i <= 0)return false; 
		
		k = i - 1;
		
		for(i = num.length - 1; i >= k + 1; i -- ){
			if(num[k] < num[i]) break; 
		}
		l = i; 
		swap(num, k, l); 
		
		i = k + 1;
		j = num.length - 1; 
		while(i < j){
			swap(num, i++, j--); 
		}
		return true; 
	}
	
	private void swap(int num[], int i, int j){
		int temp; 
		temp = num[i]; 
		num[i] = num[j]; 
		num[j] = temp; 
	}

	
	public static void main(String[] args) {
		
		int[] num = {0,-1,1}; 
		for(List<Integer> list : new Solution().permutations(num)){
			System.out.println(list);
		}		
	}	
}

