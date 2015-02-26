""" 
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. 
""" 

class MinStack():
  
  def __init__(self): 
    self.stack = [] 
    self.minStack = [] 
    
  # Push element x onto stack 
  def push(self, x): 
    self.stack.append(x) 
    if(len(self.minStack) == 0 or self.minStack[-1] >= x): 
      self.minStack.append(x) 
    
  # Remove the element on top of the stack 
  def pop(self): 
    if(self.stack.pop() == self.minStack[-1]):
      self.minStack.pop() 
      
  # Get the top element
  def top(self): 
    return self.stack[-1]  
  
  # Retrieve the minimum element in the stack 
  def getMin(self): 
    return self.minStack[-1]  
