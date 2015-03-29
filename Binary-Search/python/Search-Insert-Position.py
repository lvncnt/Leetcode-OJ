""" 
Given a sorted array and a target value, 
return the index if the target is found. 
If not, return the index where it would 
be if it were inserted in order.
""" 

class Solution(): 
  def searchInsert(self, A, target): 
    start, end = 0, len(A) - 1
    while(start <= end): 
      mid = (start + end)//2
      if(A[mid] < target): start = mid + 1
      elif(A[mid] > target): end = mid - 1
      else: return mid 
    return end + 1 
    
