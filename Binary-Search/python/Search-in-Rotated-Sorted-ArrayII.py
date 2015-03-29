'''
Created on Jan 3, 2015
Description: 
Follow up for "Search in Rotated Sorted Array":
Duplicates are allowed in the array
'''

class Solution(): 
    def search(self, A, target): 
        start, end = 0, len(A) - 1; 
        while(start <= end): 
          mid = (start + end )//2
          if(A[mid] == target): return mid 
          if(A[start] < A[mid]): 
            if(target < A[mid] and target >= A[start]): end = mid - 1
            else: start = mid + 1
          elif(A[start] > A[mid]): 
            if(target > A[mid] and target <= A[end]): start = mid + 1
            else: end = mid - 1
          else: start += 1 
        return -1
        
