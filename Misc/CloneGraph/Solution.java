
import java.util.*;

/**
 * Clone Graph
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
 */

/**
 * Definition for undirected graph
 *
 */
class UndirectedGraphNode{
	int label; 
	List<UndirectedGraphNode> neighbors; 
	UndirectedGraphNode(int label){
		this.label = label; 
		this.neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

class Graph{

	private UndirectedGraphNode graph; 
	
	/**
	 * Initialize graph 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w){
		if(graph == null){
			graph = new UndirectedGraphNode(v); 
			graph.neighbors.add(new UndirectedGraphNode(w)); 
			return; 
		}
		add(graph, v, w); 	
	}
	
	private void add(UndirectedGraphNode node, int v, int w){
		if(node.label == v){
			node.neighbors.add(new UndirectedGraphNode(w)); 
			return; 
		}
		for(UndirectedGraphNode n: node.neighbors){
			add(n,v,w); 
		}
	}
	
	/**
	 * Clone graph: BFS
	 * @param graph
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph){
		if(graph == null){
			return null; 
		}
		// Initialize queue with graph; 
		Queue<UndirectedGraphNode> queue = new LinkedList<>(); 
		queue.add(graph); 
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label); 
		// mark graph as visited by adding it to map 
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>(); 
		map.put(graph, graphCopy); 
		
		while(!queue.isEmpty()){
			UndirectedGraphNode v = queue.poll(); 
			for(UndirectedGraphNode w: v.neighbors){
				if(!map.containsKey(w)){
					UndirectedGraphNode wCopy = new UndirectedGraphNode(w.label); 
					map.put(w, wCopy); 
					queue.add(w);
					
					map.get(v).neighbors.add(wCopy); 
				}
				else{
					map.get(v).neighbors.add(map.get(w)); 
				}
			}
		}
		
		return graphCopy; 
	}
	
	/**
	 * @return graph
	 */
	public UndirectedGraphNode getGraph(){
		return graph; 
	}
	
	public String printGraph(UndirectedGraphNode node){
		StringBuilder sb = new StringBuilder(); 
		Queue<UndirectedGraphNode> queue = new LinkedList<>(); 
		queue.add(node); 
		
		List<Integer> list = new ArrayList<>(); 
		list.add(node.label); 
		
		while(!queue.isEmpty()){
			
			UndirectedGraphNode v = queue.poll(); 
			sb.append(v.label + ":"); 
			for(UndirectedGraphNode w: v.neighbors){
				sb.append(w.label + " "); 
				if(!list.contains(w.label)){
					list.add(w.label); 
					queue.add(w); 
				}
			}
			sb.append('\n'); 	
		}
		return sb.toString(); 
	}	
}

class Solution {

	public static void main(String[] args) {
	
		Graph G = new Graph(); 
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 0);
		G.addEdge(1, 2);
		G.addEdge(2, 0);
		G.addEdge(2, 2);
		System.out.println("** Old graph **");
		System.out.println(G.printGraph(G.getGraph()));
		
		System.out.println("** Copied graph **");
		UndirectedGraphNode graphCopy = G.cloneGraph(G.getGraph()); 
		System.out.println(G.printGraph(graphCopy));
		
	}
}

