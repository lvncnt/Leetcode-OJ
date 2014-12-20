""" 
Given an array of integer, every elements appears twice except for one. 
Find that single one. 
""" 

# using a dict to keep track of the number of times an item appears 
def singleNumber(A): 
  dict = {}
  for i in range(len(A)): 
    if(dict.get(A[i]) == None): dict[A[i]] = 1 
    elif(dict.get(A[i]) == 1): dict.pop(A[i]) 
  return list(dict.keys())[0] 
