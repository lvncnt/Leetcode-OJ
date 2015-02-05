import java.util.HashMap;
import java.util.Map;

/*
 * Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list. 
 */

/** Definition for singly-linked list with a random pointer */ 
class RandomListNode{
	int label; 
	RandomListNode next, random; 
	RandomListNode(int x){
		this.label = x; 
	}
}

class CopyRandomList {
	
	private RandomListNode makeRandomList(int[] array){
		RandomListNode list = new RandomListNode(0), dummy = list ;
		
		// set node connection: three nodes 
		for(int i: array){
			RandomListNode temp = new RandomListNode(i); 
			dummy.next = temp; 
			dummy = dummy.next; 
		}	
		
		// set random pointer: 1st node points to 2nd, 2nd points to 1st, 3rd points to itself 
		dummy = list.next; 
		dummy.random = dummy.next; 
		dummy.next.random = dummy;
		dummy.next.next.random = dummy.next.next; 	
		return list.next; 
	}
	
	private void showList(RandomListNode head){
		RandomListNode dummy = head; 
		while(dummy != null){
			System.out.print(dummy.label + "(" + dummy.random.label + ")" );
			if((dummy = dummy.next) != null) System.out.print(" -> ");
		}
	}
	
	/* using a hashmap to store the node connection */ 
	public RandomListNode copyRandomList(RandomListNode head){
		RandomListNode p = head; 
		RandomListNode copy = new RandomListNode(0), q = copy; 
		Map<RandomListNode, RandomListNode> map = new HashMap(); 
		while(p != null ){
			q.next = new RandomListNode(p.label); 
			map.put(p, q.next); 
			p = p.next; 
			q = q.next; 
		}
		
		p = head; q = copy.next; 
		while(p != null){
			q.random = map.get(p.random); 
			p = p.next; 
			q = q.next; 
		}
		return copy.next; 
	}
	
	public static void main(String[] args) {
		CopyRandomList test = new CopyRandomList(); 
		int[] array = {0, 1, 2}; 
		RandomListNode head = test.makeRandomList(array); 
		test.showList(test.copyRandomList(head));
	}
}
