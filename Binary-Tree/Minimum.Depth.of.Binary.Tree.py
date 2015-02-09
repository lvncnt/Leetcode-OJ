## Minimum Depth of Binary Tree
## Given a binary tree, find its minimum depth.
class TreeNode(): 
  def __init__(self, x): 
    self.val = x
    self.left= None
    self.right = None

## recursion
## O(n) runtime
def minDepth(root): 
  if(root == None): return 0
  if(root.left == None): return minDepth(root.right) + 1
  if(root,right == None): return minDepth(root.left) + 1
  else: 
    leftDepth = minDepth(root.left) + 1
    rightDepth = minDepth(root.right) + 1
    return min(leftDepth, rightDepth) + 1
    
  
