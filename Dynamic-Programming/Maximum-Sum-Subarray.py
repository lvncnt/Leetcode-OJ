""" 
Find the contiguous subarray within an array 
(containing at least one number) 
which has the largest sum.
""" 

# Brute force: O(n^2) runtime
# Time limit exceed 
class Solution(): 
  def maxSubArray(self, A): 
    maxSoFar = min(A) 
    for i in range(1, len(A) + 1):
      for j in range(len(A) - i + 1):
        sumHere = sum(A[j:j+i])
        maxSoFar = max(maxSoFar, sumHere) 
    return maxSoFar 
    
# Dynamic programming
# O(n) runtime 
class Solution(): 
  def maxSubArray(self): 
    maxSoFar = A[0] 
    maxHere = A[0] 
    for i in A[1:]: 
      maxHere = max(maxHere + i, i) 
      maxSoFar = max(maxSoFar, maxHere) 
    return maxSoFar 
  
