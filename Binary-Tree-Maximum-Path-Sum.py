""" 
  Binary tree maximum path sum: 
  Given a binary tree, find the maximum path sum 
""" 

# defing tree node 
class TreeNode(): 
  def __init__(self, x): 
    self.val = x 
    self.left = None 
    self.right = None 
    
class Solution(): 
  # Bottom-up approach; O(n) run time 
  maxSum = -(1<<31) 
  def maxPathSum(self, root): 
    self.maxNode(root)
    return self.maxSum 
  
  def maxNode(self, p): 
    if(p == None): return 0
    left = self.maxNode(p.left)
    right = self.maxNode(p.right) 
    self.maxSum = max(p.val + left + right, self.maxSum) 
    maxPath = p.val + max(left, right)
    return maxPath if maxPath > 0 else 0 
    
  
  
  
