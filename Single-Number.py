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
  
""" 
Given an array of integer, every elements appears three times except for one, 
Find that single one. 
""" 
def singleNumber(A): 
  dict = {} 
  for i in range(len(A)): 
    dict[A[i]] = dict[A[i]]+1 if dict.get(A[i]) else 1 
  for key in dict: 
    if(dict.get(key)): return key 
    
