
class Main {
	
	/* Given a sorted array of strings which is interspersed with empty strings, 
	write a method to find the location of a given string.*/
	public int Search(String[] strs, String target){
		if(strs == null || target == null || target.equals("")) return -1; 
		return Search(strs, target, 0, strs.length - 1); 
	}
	
	private int Search(String[] strs, String target, int start, int end){
		int mid = (start + end)/2; 
		if(start > end) return -1; 
		if(strs[mid].compareTo(target) == 0) return mid; 
		
		int i, j; 
		i = j = mid; 
		/* find the closest non-empty string. */
		while(i >= start && strs[i].equals("")) i--; 
		while(j <= end && strs[j].equals("")) j++; 
		
		if(strs[i].equals(target)) return i; 
		if(strs[j].equals(target)) return j; 
		
		if(strs[j].compareTo(target) < 0) return Search(strs, target, j + 1, end); 
		else if(strs[i].compareTo(target) > 0) return Search(strs, target, start, i - 1); 
		
		return -1; 
	}
	
	public static void main(String[] args) {
		Main test = new Main(); 
		
		System.out.println("=============================");
		String[] strsR = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}; 
		String[] targets = {"at", "ball", "car", "dad"}; 
		for(String target: targets){
			System.out.printf("%s: %d%n", target, test.Search(strsR, target));
		}
	}

}
