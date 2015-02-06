## Validate binary search tree
## given a binary tree, determine if it is a valid binary search tree 

class TreeNode(): 
  def __init__(self, x): 
    self.val = x
    self.left = None
    self.right = None 
    
## Brute force: O(n2) runtime 
def isValidBST(root): 
  if(not root): return True
  return (
    leftValid(root.left, root.val) and 
    rightValid(root.right, root.val) and 
    isValidBST(root.left) and
    isValidBST(root.right)) 
    
def leftValid(left, val):
  if(not left): return True
  return (
    left.val < val and 
    leftValid(left.left, val) and 
    leftValid(left.right, val))
    
def rightValid(right, val): 
  if(not right): return True 
  return (
    right.val > val and 
    rightValid(right.left, val) and 
    rightValid(right.right, val))
