## Top-down recursion method
## O(n) runtime 

class TreeNode(): 
  def __init__(self, x):
    self.val = x
    self.left = None
    self.right = None 
  
def isValidBST(root): 
  MIN, MAX = (-1<<31) - 1, 1<<31
  return valid(root, MIN, MAX)

def valid(p, low, high): 
  if(not p): return True 
  if(p.val > low and p.val < high and valid(p.left, low, p.val) and valid(p.right, p.val, high)): return True
  else: return False 
  
