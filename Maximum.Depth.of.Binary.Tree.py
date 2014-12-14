## Given a binary tree, find its maximum depth.
# O(n) runtine
class TreeNode(): 
  def __init__(self, x): 
    self.val = x
    self.left= None
    self.right = None

def maxDepth(self, root): 
  if(root == None): return 0
  leftDepth = self.maxDepth(root.left)
  rightDepth = self.maxDepth(root.right)
  return max(leftDepth, rightDepth) + 1
  
