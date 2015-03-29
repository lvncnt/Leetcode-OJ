'''
Created on Jan 4, 2015

Description: 
Suppose a sorted array is rotated at 
some pivot unknown to you beforehand. 

Find the minimum element.   
  
Assume no duplicates in the array
'''

class Solution(): 
    def findMin(self, A): 
        start, end = 0, len(A) - 1; 
        while(start < end and A[start] >= A[end]): 
            mid = (start + end)//2; 
            if(A[start] <= A[mid]): start = mid + 1
            else: end = mid
        return A[start]  
                
        
    
