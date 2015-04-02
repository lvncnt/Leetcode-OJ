/*
 * 
 * Reverse Words in a String 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue", return "blue is sky the".
 * 
 */
class Main {
	
	/** Test case */ 
	public static void main(String[] args) {
		
		String s = "  the sky is blue  "; 
		System.out.println(">" + new Main().reverseWords(s) + "<");
		s = "   "; 
		System.out.println(">" + new Main().reverseWords(s) + "<");
		
	}

	public String reverseWords(String s) {
		int start, end;
		start = 0;
		end = s.length() - 1;
		 
		while (start <= end && s.charAt(start) == ' ')
			start++;
		if (start == s.length())
			return "";
		while (end >= 0 && s.charAt(end) == ' ')
			end--;

		char[] rev = (s.substring(start, end + 1)).toCharArray();

		reverse(rev, 0, rev.length - 1);

		int count = 0, i = 0;
		StringBuilder out = new StringBuilder();
		while (i < rev.length) {
			if ((rev[i] == ' ' && rev[i - 1] != ' ')) {
				reverse(rev, i - count, i - 1);
				count = 0;
			}
			if (i == (rev.length - 1))
				reverse(rev, i - count, i);
			if (rev[i] != ' ')
				count++;
			i++;
		}

		for (int j = 0; j < rev.length; j++) {
			if (rev[j] != ' ')
				out.append(rev[j]);
			if (rev[j] == ' ' && rev[j - 1] != ' ')
				out.append(" ");
		}
		return out.toString();
	}

	private void reverse(char[] c, int start, int end) {
		char t;
		int i = start, j = end;
		while (i < j) {
			t = c[i];
			c[i++] = c[j];
			c[j--] = t;
		}
	}
}
