""" 
Binary Tree Upside Down
For example: 
Given a binary tree: 
    1
   / \
  2   3
 / \
4   5
Return the root of the new binary tree: 
  4
 / \
5   2
   / \
  3   1

""" 

# defintion of tree node 
class TreeNode(): 
  def __init__(self, x): 
    self.val = x
    self.left = None 
    self.right = None 
    
# top down approach 
def UpsideDownBinaryTree(root): 
  p = root 
  parent, parentRight = None, None 
  while(p != None): 
    left = p.left
    p.left = parentRight 
    parentRight = p.right 
    p.right = parent 
    parent = p
    p = left 

# bottom up approach 
def UpsideDownBinaryTree(root): 
  
