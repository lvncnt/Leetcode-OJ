""" 
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
""" 

# definition of a undirected graph node 
 
class UndirectedGraphNode: 
 def __init__(self, x): 
  self.label = x 
  self.neighbors = [] 
  
# Breadth-First
class Solution(): 
 def cloneGraph(self, node): 
  if(node == None): return node
  map = {}
  queue = [] 
  clone = UndirectedGraphNode(node.label) 
  map[node] = clone 
  queue.append(node )
  while(queue): 
  	curr = queue.pop() 
  	for neighbor in curr.neighbors: 
  		if(not map.get(neighbor)): 
  			cloneNeighbor = UndirectedGraphNode(neighbor.label) 
  			map[curr].neighbors.append(cloneNeighbor) 
  			
  			map[neighbor] = cloneNeighbor 
  			queue.append(neighbor) 
  		else: 
  			map[curr].neighbors.append(map[neighbor]) 
  return clone 
  
  
