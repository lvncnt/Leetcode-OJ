## Balanced Binary Tree 
## Given a binary tree, check it is height-balanced 

# define TreeNode class 
class TreeNode():
  self __init__(self, x): 
    self.val = x 
    self.left = None 
    self.right = None 
    
# O(n2) runtime 
def isBalanced(root): 
  if(not root): return True 
  return (abs(maxDepth(root.left), maxDepth(root.right)) + 1 and 
          isBalanced(root.left) and 
          isBalanced(root.right)) 

def maxDepth(root): 
  if(not root): return 0
  return max(maxDepth(root.left), maxDepth(root.right)) + 1
