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
  
