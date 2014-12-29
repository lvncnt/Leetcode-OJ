 
## Given a string containing just the characters 
## '(', ')', '[', ']', '{' and '}', determine 
## if the input string is valid.
 
class Solution(): 
	def __init__(self): 
		self.map = {
			'(':')', 
			'[': ']', 
			'{': '}'
		}
		
	def isValidParentheses(self, s): 
		stack = [] 
		for i in s: 
			if(self.map.get(i)): stack.append(i) 
			elif(len(stack) == 0 or self.map.get(stack[-1]) != i): return False 
			else: stack.pop() 
		return len(stack) == 0 
