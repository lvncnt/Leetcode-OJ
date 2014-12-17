"""
  Convert sorted array to balanced binary search tree 
""" 

# definition of binary tree node 
class TreeNode(): 
  def __init__(self, x): 
    self.val = x
    self.left = None 
    self.right = None 
    
# Divide and Conquer 
def sortedArrayToBST(array): 
  if(not array): return None 
  return makeNode(array, 0, len(array) -1 ) 

def makeNode(array, start, end ): 
  if(start > end): return None 
  mid = (start + end )//2
  node = TreeNode(array[mid])
  node.left = makeNode(array, start, mid -1 )
  node.right = makeNode(array, mid + 1, end) 
  return node 
  
  
