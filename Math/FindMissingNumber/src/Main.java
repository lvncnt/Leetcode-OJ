
import java.util.ArrayList;
import java.util.Arrays;

/**
 * An array A contains all the integers from 0 through n, 
 * except for one number which is missing, find the missing number 
 *
 */
class Main {
	
	public static void main(String[] args) {
		int nums[] = {0,1,2,4,9,3,8,7,6}; 

		ArrayList<Integer> list = new ArrayList<>(); 
		 
		for(int i: nums) {
			list.add(i); 	
		}

		Main main = new Main(); 
		System.out.println("Given array: " + list);
		System.out.println("Missing number: " + main.findMissing(list));
	}
	
	public int findMissing(ArrayList<Integer> list){	
		return findMissing(list, 0); 
	}
	
	private int findMissing(ArrayList<Integer> list, int bit){
		 
		if(list.size() == 0 ) return 0;
		
		ArrayList<Integer> ones, zeros; 
		ones = new ArrayList<>(); 
		zeros = new ArrayList<>(); 
		
		for(int num: list){
			/* separate num based on their bit at position 'bit' */ 
			if((num & (1 << bit)) != 0) ones.add(num); 
			else zeros.add(num); 
		}

		if(zeros.size() > ones.size()){
			/* if counts of 0s  > 1s, insert a bit 1 */ 
			int missing = findMissing(ones, bit + 1);  
			return (missing << 1) | 1;   
		}
		else{
			int missing = findMissing(zeros, bit + 1); 
			return (missing << 1) | 0; 
		} 
	}
}

