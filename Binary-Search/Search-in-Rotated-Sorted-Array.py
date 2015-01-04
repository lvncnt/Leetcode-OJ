'''
Created on Jan 3, 2015

Description: 
Suppose a sorted array is rotated at 
some pivot unknown to you beforehand. 

You are given a target value to search.

If found in the array return its index, 
otherwise return -1.  
  
Assume no duplicates in the array
'''

class Solution(): 
    def search(self, A, target): 
        start, end = 0, len(A); 
        while(start <= end): 
          mid = (start + end )//2
          if(A[mid] == target): return mid 
          if(A[start] <= A[mid]): 
            if(target < A[mid] and target >= A[start]): end = mid - 1
            else: start = mid + 1
          else: 
            if(target > A[mid] and target <= A[end]): start = mid + 1
            else: end = mid - 1
        return -1
        
    
