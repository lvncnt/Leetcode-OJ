"""
Find the continuous subarray within an array of integers that has the largest product. 
"""

class Solution(): 
  def maxProduct(self, A): 
    maxFinal, maxLocal, minLocal = A[0], A[0], A[0]
    for x in A[1:]: 
      maxCopy, minCopy = maxLocal, minLocal 
      maxLocal = max(max(maxCopy*x, x), minCopy*x)
      minLocal = min(min(maxCopy*x, x), minCopy*x)
      maxFinal = max(maxFinal, maxLocal) 
    return maxFinal 
