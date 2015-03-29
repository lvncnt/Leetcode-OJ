'''
Created on Jan 4, 2015

Description: 
Suppose a sorted array is rotated at 
some pivot unknown to you beforehand. 

Find the minimum element.   
  
The array may contain duplicates.
'''

class Solution(): 
    def findMin(self, A): 
        start, end = 0, len(A) - 1; 
        while(start < end and A[start] >= A[end]): 
            mid = (start + end)//2; 
            if(A[start] < A[mid]): start = mid + 1;
            elif(A[start] > A[mid]): end = mid;
            else: start += 1;
        return A[start];  
                
        
    
