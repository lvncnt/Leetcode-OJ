""" 
You are climbing a stair case. 
It takes n steps to reach to the top. 
Every time you either climb 1 step or 2 steps. 
In how many distinct ways can you climb to the top? 
""" 

## ////////////// Recursion ///////////////
class Solution(): 
  def climbStairs(self, n): 
    if(n == 1): return 1 
    elif(n == 2): return 2 
    else: return self.climbStairs(n - 1) + self.climbStairs(n - 2) 
    
    
## ///////// Dynamic Programming  ////////
class Solution(): 
  def climbStairs(self, n): 
    array = [1, 1, 0] 
    for i in range(2, n + 1): 
      array[i%3] = array[(i - 1)%3] + array[(i - 2)%3]
    return array[n%3]
