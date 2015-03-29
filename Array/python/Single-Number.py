""" 
Given an array of integer, every elements appears twice except for one. 
Find that single one. 
""" 

# using a dict to keep track of the number of times an item appears 
def singleNumber(A): 
  dict = {}
  for i in A: 
    if(dict.get(i) == None): dict[i] = 1 
    elif(dict.get(i) == 1): dict.pop(i) 
  return list(dict.keys())[0] 
  
# using bitwise operation 
def singleNumber(A): 
  num = 0
  for i in A: num ^= i 
  return num 
  
""" 
Given an array of integer, every elements appears three times except for one, 
Find that single one. 
""" 
def singleNumber(A): 
  dict = {} 
  for i in A: 
    dict[i] = dict[i]+1 if dict.get(i) else 1 
  for key in dict: 
    if(dict.get(key)): return key 
    
# using bitwise operation 
def singleNumber(A): 
  result = 0 
  for i in range(32): 
    bit = 0 
    for j in A: 
      bit += (j>>i) & 1
    result |= (bit%3)<<i

    return result if not( result ^ 0x80000000) else -(result^0xFFFFFFFF) - 1
