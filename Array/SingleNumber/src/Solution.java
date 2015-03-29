
import java.util.*;

/**
 * Single Number Given an array of integers, every element appears twice except
 * for one. Find that single one.
 */
class SingleNumber {

	/**
	 * Method 1: Use HashMap
	 * 
	 * @param array
	 * @return
	 * @throws Exception
	 */
	public int singleNumberI(int[] array) throws Exception {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : array) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		for (int i : array) {
			if (map.get(i) == 1) {
				return i;
			}
		}
		throw new IllegalArgumentException("No single number found!");
	}

	/**
	 * Method 2: Use HashSet
	 * 
	 * @param array
	 * @return
	 */
	public int singleNumberII(int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			if (set.contains(i)) {
				set.remove(i);
			} else {
				set.add(i);
			}
		}
		return set.iterator().next(); 
	}
}

class Solution {

	public static void main(String[] args) {
		// Test
		int[] array = { 2, 1, 2, 1, 3, 4, 3 };
		SingleNumber test = new SingleNumber();
		try {
			System.out.println("Single Number: " + test.singleNumberI(array));
			System.out.println("Single Number: " + test.singleNumberII(array));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

