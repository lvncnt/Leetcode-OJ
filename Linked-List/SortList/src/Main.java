public class Main {
	public static void main(String[] args) {
		int[] array = {14, 7, 3, 12, 9, 11, 6, 2}; 
		LinkedList list = new LinkedList(); 
		for(int i: array) list.add(i); 
		list.sort(); 
		System.out.println("Sorted List: " + list);
	}
}
