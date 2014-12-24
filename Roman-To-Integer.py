"""
Given a roman numeral, convert it to an integer. 
""" 
class Solution(): 
  dict = {
    'I': 1, 'V': 5, 'X': 10, 'L': 50, 
    'C': 100, 'D': 500, 'M': 1000
    }
    
  def romanToInt(self, s): 
    output = 0 
    prev = 0 
    for i in s: 
      curr = self.dict.get(i) 
      output += curr
      if(prev < curr): output -= (2 * prev) 
      prev = curr 
  
    return output 
    
