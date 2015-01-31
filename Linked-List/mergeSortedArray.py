## Given two sorted array A and B, 
## merge B into A as one sorted array, 
## and return A
def mergeSortedArray(A, B, m, n):
  i, j = m - 1, n - 1
  while(i >= 0 and j >= 0):
    if(A[i] >= B[j]): i -= 1
    else:
      A.insert(i + 1, B[j]); j -= 1
  while(j >= 0):
    A.insert(0, B[j]); j -= 1
  return A
  
