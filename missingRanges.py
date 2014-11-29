## Given a sorted integer array where the ranges of elements are [start, end] inclusive,
## return its missing ranges 

def missingRanges(nums, start, end):
  output = []
  nums.insert(0, start - 1)
  nums.append(end + 1)
  
  for i in range(len(nums) - 1):
    count = len(range(nums[i], nums[i + 1]))
    if(count == 2):
      output.append(str(nums[i] + 1))
    elif(count > 2):
      temp = str(nums[i] + 1) + '->' + str(nums[i + 1] - 1)
      output.append(temp)
      
  return output 
