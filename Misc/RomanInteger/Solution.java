
import java.util.*;

class Solution {
	private int[] keys = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private String[] values = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
			"X", "IX", "V", "IV", "I" };
	private Map<Character, Integer> map = new HashMap<Character, Integer>() {
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

	/**
	 * Integer to Roman Given an integer, convert it to a roman numeral.
	 * 
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {

		StringBuilder output = new StringBuilder();
		int i = 0, digit;

		while (num > 0) {
			digit = num / keys[i];
			for (int j = 0; j < digit; j++) {
				output.append(values[i]);
				num -= keys[i];
			}
			i++;
		}
		return output.toString();
	}

	/**
	 * Roman to Integer Given a roman numeral, convert it to an integer.
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int output = 0, curr, prev = 0;
		for (Character c : s.toCharArray()) {
			curr = map.get(c);
			output += curr;
			if (prev < curr) {
				output -= 2 * prev;
			}
			prev = curr;
		}
		return output;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println("** Integer to Roman **");
		int num = 1526;
		System.out.println(test.intToRoman(num));

		System.out.println("** Test Roman to Integer **");
		String s = "MDXXVI";
		System.out.println(test.romanToInt(s));
	}
}

